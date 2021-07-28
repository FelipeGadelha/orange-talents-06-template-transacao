package br.com.zupacademy.felipe.gadelha.transaction.api.v1.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.felipe.gadelha.transaction.domain.entity.Transaction;

public class TransactionRs {
	
	private String id;
	private BigDecimal value;
	private String cardId;
	private LocalDateTime effectiveIn;

	public TransactionRs(Transaction transaction) {
		this.id = transaction.getId();
		this.value = transaction.getValue();
		this.cardId = transaction.getCard().getId();
		this.effectiveIn = transaction.getEffectiveIn();
	}
	public String getId() {
		return id;
	}
	public BigDecimal getValue() {
		return value;
	}
	public String getCardId() {
		return cardId;
	}
	public LocalDateTime getEffectiveIn() {
		return effectiveIn;
	}
	@Override
	public String toString() {
		return "TransactionRs [id=" + id + ", value=" + value + ", cardId=" + cardId + ", effectiveIn=" + effectiveIn
				+ "]";
	}
}
