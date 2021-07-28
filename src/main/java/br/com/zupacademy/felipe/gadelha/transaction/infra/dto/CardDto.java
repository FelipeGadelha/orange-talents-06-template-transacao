package br.com.zupacademy.felipe.gadelha.transaction.infra.dto;

import br.com.zupacademy.felipe.gadelha.transaction.domain.entity.Card;

public class CardDto {
	
	private String id;
	private String email;

	@Deprecated
	public CardDto() {	}

	public CardDto(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	public Card convert() {
		return new Card(id, email);
	}

	@Override
	public String toString() {
		return "CardDto [id=" + id + ", email=" + email + "]";
	}
}
