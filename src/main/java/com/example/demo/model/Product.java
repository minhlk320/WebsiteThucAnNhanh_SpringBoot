package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String productID;
	private double unitPrice;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String productName;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String description;
	private int manufactureDate;
	private String imgURL;
	@OneToMany(mappedBy ="reviewID")
	private List<Review> reviews;
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;
	@ManyToOne
	@JoinColumn(name="supplierID", referencedColumnName = "supplierID")
	private Supplier supplier;
	
	
	public Product() {
		super();
	}
	public Product(String productID, double unitPrice, String productName, String description, int manufactureDate, String imgURL) {
		super();
		this.productID = productID;
		this.unitPrice = unitPrice;
		this.productName = productName;
		this.description = description;
		this.manufactureDate = manufactureDate;
		this.imgURL = imgURL;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productID == null) ? 0 : productID.hashCode());
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
		Product other = (Product) obj;
		if (productID == null) {
			if (other.productID != null)
				return false;
		} else if (!productID.equals(other.productID))
			return false;
		return true;
	}
	
}
 