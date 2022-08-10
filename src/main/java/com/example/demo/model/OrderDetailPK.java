package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
public class OrderDetailPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private String order;
	private String product;
	
	public OrderDetailPK() {
		super();
	}
	public OrderDetailPK(String order, String product) {
		super();
		this.order = order;
		this.product = product;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailPK other = (OrderDetailPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	

}
