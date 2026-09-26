package com.baozi.store.apirest.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "products")
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private BigDecimal price;
	private Boolean stock;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Boolean getStock() {
		return stock;
	}

	public void setStock(Boolean stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(stock, other.stock);
	}
}
