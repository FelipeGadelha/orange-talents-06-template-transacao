package br.com.zupacademy.felipe.gadelha.transaction.infra.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.felipe.gadelha.transaction.domain.entity.Transaction;

public class TransactionDto {

	private String id;
	@JsonProperty("valor")
	private BigDecimal value;
	
	@JsonProperty("estabelecimento")
	private EstablishmentDto establishmentRs;
	
	@JsonProperty("cartao")
	private CardDto cardRs;

	@JsonProperty("efetivadaEm")
	private LocalDateTime effectiveIn;
	
	@Deprecated
	public TransactionDto() {	}
	
	public TransactionDto(String id, BigDecimal value, EstablishmentDto establishmentRs, CardDto cardRs,
			LocalDateTime effectiveIn) {
		this.id = id;
		this.value = value;
		this.establishmentRs = establishmentRs;
		this.cardRs = cardRs;
		this.effectiveIn = effectiveIn;
	}
	public String getId() {
		return id;
	}
	public BigDecimal getValue() {
		return value;
	}
	public EstablishmentDto getEstablishmentRs() {
		return establishmentRs;
	}
	public CardDto getCardRs() {
		return cardRs;
	}
	public LocalDateTime getEffectiveIn() {
		return effectiveIn;
	}

	public Transaction convert() {
		return new Transaction(id, value, 
				establishmentRs.convert(), 
				cardRs.convert(), 
				effectiveIn);
	}

	@Override
	public String toString() {
		return "TransactionDto [id=" + id + ", value=" + value + ", establishmentRs=" + establishmentRs + ", cardRs="
				+ cardRs + ", effectiveIn=" + effectiveIn + "]";
	}
}
