package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@IdClass(OrderDetailPK.class)
@Getter
@Setter
public class OrderDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name="orderID",referencedColumnName = "orderID")
	private Order order;
	@Id
	@ManyToOne
	@JoinColumn(name="productID", referencedColumnName = "productID")
	private Product product;
	private double price;
	private int quantity;
	public OrderDetail() {
		super();
	}
	public OrderDetail(double price, int quantity, Product product) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.product = product;
	}
	
	public OrderDetail(Order order, Product product, double price, int quantity) {
		super();
		this.order = order;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

}
