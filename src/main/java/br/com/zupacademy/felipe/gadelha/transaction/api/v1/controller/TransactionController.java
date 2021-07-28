package br.com.zupacademy.felipe.gadelha.transaction.api.v1.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.felipe.gadelha.transaction.api.v1.dto.response.TransactionRs;
import br.com.zupacademy.felipe.gadelha.transaction.domain.repository.TransactionRepository;

@RestController
@RequestMapping("/v1/cards")
public class TransactionController {

	private final TransactionRepository repository;

	@Autowired
	public TransactionController(TransactionRepository repository) {
		this.repository = repository;
	}


	@GetMapping("/{id}/transactions")
	public ResponseEntity<?> findTransactions(@PathVariable String id){
		var exists = repository.existsByCardId(id);
		if (exists.equals(Boolean.FALSE)) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(repository.findTop10ByCardIdOrderByEffectiveInDesc(id)
				.stream()
				.map(TransactionRs::new)
				.collect(Collectors.toList()));
	}
	
	
	
	
}
