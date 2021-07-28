package br.com.zupacademy.felipe.gadelha.transaction.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.felipe.gadelha.transaction.domain.entity.Establishment;

public class EstablishmentDto {

	@JsonProperty("nome")
	private String name;
	
	@JsonProperty("cidade")
	private String city;
	
	@JsonProperty("endereco")
	private String address;

	@Deprecated
	public EstablishmentDto() {	}
	
	public EstablishmentDto(String name, String city, String address) {
		this.name = name;
		this.city = city;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public String getAddress() {
		return address;
	}

	public Establishment convert() {
		return new Establishment(name, city, address);
	}

	@Override
	public String toString() {
		return "EstablishmentDto [name=" + name + ", city=" + city + ", address=" + address + "]";
	}
}
