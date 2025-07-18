package br.com.cotiinformatica.infraestructure.components;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.cotiinformatica.infraestructure.repositories.OutboxMessageRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoCriadoProducer {
	
	private final RabbitTemplate rabbitTemplate;
	private final OutboxMessageRepository outboxMessageRepository;
	private final Queue queue;
	
	
	/*
	 * fixedDelay: Executando a cada  X milisegundos desde o final da última execução
	 * fixedRate:  Executando a cada  X milisegundos desde o início da última execução
	 */
	@Scheduled(fixedDelay = 60000)
	public void enviarPedidosCriados() {
		//Ler as mensagens na tabela de outbox:
		var pageable = PageRequest.of(0, 20); //ler os primeiros 20 registros
		var mensagens = outboxMessageRepository.find("PedidoCriado", pageable); 
		
		try {
			//lendo mensagens obtidas
			for (var mensagem : mensagens) {
				//enviando o conteudo JSON da mensagem para a fila
//				rabbitTemplate.convertAndSend(mensagem.getPayload()); //payload é o Json
				
				rabbitTemplate.convertAndSend(queue.getName(), mensagem.getPayload());

				
				//atualizando o registro no banco de dados
				mensagem.setPublished(true);
				mensagem.setTransmitedAt(LocalDateTime.now());
			}
			
		} catch (Exception e) {
			e.printStackTrace(); //TODO gravar um log
		}
	}
}
