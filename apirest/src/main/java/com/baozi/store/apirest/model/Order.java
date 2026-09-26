package com.baozi.store.apirest.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "orders")
@Entity	
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "client_id")
	private Long clientId;
	
	@Column(name = "product_id")
	private Long productId;
	private Integer quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", clientId=" + clientId + ", productId=" + productId + ", quantity=" + quantity
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(clientId, id, productId, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(clientId, other.clientId) && Objects.equals(id, other.id)
				&& Objects.equals(productId, other.productId) && Objects.equals(quantity, other.quantity);
	}
	
	
}
