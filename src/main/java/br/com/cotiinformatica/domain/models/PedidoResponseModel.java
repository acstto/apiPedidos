package br.com.cotiinformatica.domain.models;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoResponseModel {
	
	private UUID id;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPedido;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern= "#0.00")
	private Double valorPedido;
	
	private String nomeCliente;
	
	private String descricao;
	
	private String status;

}
