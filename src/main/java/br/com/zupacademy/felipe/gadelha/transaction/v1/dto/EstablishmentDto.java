package br.com.zupacademy.felipe.gadelha.transaction.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentDto {

	@JsonProperty("nome")
	private String name;
	
	@JsonProperty("cidade")
	private String city;
	
	@JsonProperty("endereco")
	private String address;
	
	
	
}
