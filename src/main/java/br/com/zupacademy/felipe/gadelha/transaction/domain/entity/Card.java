package br.com.zupacademy.felipe.gadelha.transaction.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {

	@Id 
	private String id;
	private String email;
	
	@Deprecated
	public Card() { }
	
	public Card(String id, String email) {
		this.id = id;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", email=" + email + "]";
	}
}
