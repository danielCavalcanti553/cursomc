package com.daniel.cursomc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.ItemPedido;
import com.daniel.cursomc.domain.PagamentoComBoleto;
import com.daniel.cursomc.domain.Pedido;
import com.daniel.cursomc.domain.enums.EstadoPagamento;
import com.daniel.cursomc.repositories.ClienteRepository;
import com.daniel.cursomc.repositories.ItemPedidoRepository;
import com.daniel.cursomc.repositories.PagamentoRepository;
import com.daniel.cursomc.repositories.PedidoRepository;
import com.daniel.cursomc.repositories.ProdutoRepository;
import com.daniel.cursomc.resources.BoletoService;
import com.daniel.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Pedido find(Integer id) {
		Pedido obj = repo.findOne(id);
		
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto Não eoncontrado! " +
					id + ", Tipo " + Pedido.class.getName());
			}
		
		return obj;
	}

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteRepository.findOne(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto,obj.getInstante());
		}
		obj = repo.save(obj); // Salvando pedido
		pagamentoRepository.save(obj.getPagamento()); // Salvando pagamento
		for(ItemPedido ip:obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoRepository.findOne(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.save(obj.getItens());
		
		System.out.println(obj);
		
		return obj;
		
	}
	
}
