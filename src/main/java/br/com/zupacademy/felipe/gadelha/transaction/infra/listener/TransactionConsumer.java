package br.com.zupacademy.felipe.gadelha.transaction.infra.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.zupacademy.felipe.gadelha.transaction.domain.repository.TransactionRepository;
import br.com.zupacademy.felipe.gadelha.transaction.infra.dto.TransactionDto;

@Service
public class TransactionConsumer {

	private final TransactionRepository repository;

	@Autowired
	public TransactionConsumer(TransactionRepository repository) {
		this.repository = repository;
	}

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void consume(TransactionDto transactionRs) {
		repository.save(transactionRs.convert());
	}

}
