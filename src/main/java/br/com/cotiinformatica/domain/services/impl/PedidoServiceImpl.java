package br.com.cotiinformatica.domain.services.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.entities.Pedido;
import br.com.cotiinformatica.domain.exceptions.PedidoNaoEncontradoException;
import br.com.cotiinformatica.domain.models.PedidoRequestModel;
import br.com.cotiinformatica.domain.models.PedidoResponseModel;
import br.com.cotiinformatica.domain.services.interfaces.PedidoService;
import br.com.cotiinformatica.infraestructure.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

	//@Autowired
	private final PedidoRepository pedidoRepository;
	private final ModelMapper mapper;
	
//	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
//		this.pedidoRepository = pedidoRepository;
//	}
	
	@Override
	public PedidoResponseModel criarPedido(PedidoRequestModel model) {
		// TODO Auto-generated method stub
		
		//var mapper = new ModelMapper();
		var pedido = mapper.map(model, Pedido.class);
		pedido.setAtivo(Boolean.TRUE);	
		pedidoRepository.save(pedido);
		return mapper.map(pedido, PedidoResponseModel.class);
	}

	@Override
	public PedidoResponseModel alterarPedido(UUID id, PedidoRequestModel model) {
		
		var pedido = pedidoRepository.findByIdAndAtivo(id)
				//Caso o pedido não seja encontrado lance uma exceção
				.orElseThrow(() -> new PedidoNaoEncontradoException(id)); //Função Lâmbda (Anônima)
		
		mapper.map(model, pedido);
		
		pedidoRepository.save(pedido);
		
		return mapper.map(pedidoRepository,  PedidoResponseModel.class);
	}

	@Override
	public PedidoResponseModel inativarPedido(UUID id) {
		var pedido = pedidoRepository.findByIdAndAtivo(id)
				.orElseThrow(() -> new PedidoNaoEncontradoException(id));

		pedido.setAtivo(false);
		
		pedidoRepository.save(pedido);
		
		return mapper.map(pedidoRepository,  PedidoResponseModel.class);
	}

	@Override
	public Page<PedidoResponseModel> consultarPedidos(Pageable pageable) {
		
		var pedidos = pedidoRepository.findAtivos(pageable);
		
		//Pega todos os itens encontrados no banco e transforma para PedidoResponseModel
		return pedidos.map(pedido -> mapper.map(pedido, PedidoResponseModel.class));
		
		
		
	}

	@Override
	public PedidoResponseModel obterPedidoPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
