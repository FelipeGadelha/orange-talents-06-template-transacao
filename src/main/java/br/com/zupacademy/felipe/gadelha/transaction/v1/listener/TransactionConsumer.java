package br.com.zupacademy.felipe.gadelha.transaction.v1.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.zupacademy.felipe.gadelha.transaction.v1.dto.TransactionDto;

@Service
public class TransactionConsumer {

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void consume(TransactionDto transactionDto) {
		System.err.println("Consumed transaction: " + transactionDto.toString());
	}
	
}
