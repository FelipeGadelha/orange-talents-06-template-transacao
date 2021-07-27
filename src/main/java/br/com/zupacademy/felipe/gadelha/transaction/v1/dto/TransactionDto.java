package br.com.zupacademy.felipe.gadelha.transaction.v1.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDto {

	private String id;
	@JsonProperty("valor")
	private BigDecimal value;

	@JsonProperty("efetivadaEm")
	private LocalDateTime effectiveIn;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public LocalDateTime getEffectiveIn() {
		return effectiveIn;
	}
	public void setEffectiveIn(LocalDateTime effectiveIn) {
		this.effectiveIn = effectiveIn;
	}
	@Override
	public String toString() {
		return "TransationDto [id=" + id + ", value=" + value + ", effectiveIn=" + effectiveIn + "]";
	}
}
