package br.com.cotiinformatica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/pedidos")
@Tag(
		name="Controle de Pedidos",
		description="Serviços para gerenciamento de solicitações de pedidos"
	)
public class PedidoController {

	@Operation(
			summary = "Cadastro de solicitações de pedido",
			description = "Cria uma nova solicitação de pedido no sistema"
	)
	@PostMapping
	public ResponseEntity<?> post() {
		return ResponseEntity.ok().build();
	}
	
	@Operation(
			summary = "Atualização de Pedido",
			description = "Modifica uma solicitação de pedido no sistema"
	)
	@PutMapping
	public ResponseEntity<?> put() {
		return ResponseEntity.ok().build();
	}
	
	@Operation(
			summary = "Inativação de solicitações de pedido",
			description = "Inativa uma solicitação de pedido no sistema"
	)
	@DeleteMapping
	public ResponseEntity<?> delete() {
		return ResponseEntity.ok().build();
	}
	
	@Operation(
			summary = "Consulta de solicitação de pedido",
			description = "Retorna uma consulta paginada de solicitações de pedidos no sistema"
	)
	
	@GetMapping
	public ResponseEntity<?> get() {
		return ResponseEntity.ok().build();
	}
}
