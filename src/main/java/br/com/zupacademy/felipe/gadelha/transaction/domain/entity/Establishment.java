package br.com.zupacademy.felipe.gadelha.transaction.domain.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Establishment {
	
	private String name;
	private String city;
	private String address;

	@Deprecated
	public Establishment() {  }
	
	public Establishment(String name, String city, String address) {
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

	@Override
	public String toString() {
		return "Establishment [name=" + name + ", city=" + city + ", address=" + address + "]";
	}
}
