package br.com.zupacademy.felipe.gadelha.transaction.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.felipe.gadelha.transaction.domain.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{

	Boolean existsByCardId(String id);
	
	List<Transaction> findTop10ByCardIdOrderByEffectiveInDesc(String cardId);
}
