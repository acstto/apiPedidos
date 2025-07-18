package br.com.cotiinformatica.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Mapeamento de uma fila para gravar / ler
 * eventos de pedidos criados
 * 
 */
@Configuration
public class RabbitMQConfiguration {
	
	/*
	 * 'fila.pedidos_criados' : Nome da fila
	 * 'true': fila durável (mantida mesmo depois de reiniciar o servidor)
	 * 
	 */
	@Bean
	Queue filaPedidosCriados() {
		return new Queue("fila.pedidos_criados", true);
	}

}
