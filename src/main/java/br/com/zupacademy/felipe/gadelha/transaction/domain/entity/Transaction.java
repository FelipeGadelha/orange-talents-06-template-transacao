package br.com.zupacademy.felipe.gadelha.transaction.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id 
	private String id;
	private BigDecimal value;
	@Embedded
	private Establishment establishment;
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Card card;
	private LocalDateTime effectiveIn;
	
	@Deprecated
	public Transaction() {	}

	public Transaction(String id, BigDecimal value, Establishment establishment, Card card, LocalDateTime effectiveIn) {
		this.id = id;
		this.value = value;
		this.establishment = establishment;
		this.card = card;
		this.effectiveIn = effectiveIn;
	}
	public String getId() {
		return id;
	}
	public BigDecimal getValue() {
		return value;
	}
	public Establishment getEstablishment() {
		return establishment;
	}
	public Card getCard() {
		return card;
	}
	public LocalDateTime getEffectiveIn() {
		return effectiveIn;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", value=" + value + ", establishment=" + establishment + ", card=" + card
				+ ", effectiveIn=" + effectiveIn + "]";
	}
}
