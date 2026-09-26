package com.baozi.store.apirest.model;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "clients")
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(name = "customer_since", columnDefinition = "DATE")
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate customerSince;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCustomerSince() {
		return customerSince;
	}

	public void setCustomerSince(LocalDate customerSince) {
		this.customerSince = customerSince;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", customerSince=" + customerSince + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerSince, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(customerSince, other.customerSince) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
}
