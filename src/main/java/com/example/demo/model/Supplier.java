package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
@Setter
@Getter
public class Supplier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String supplierID;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String supplierName;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String address;
	@OneToMany(mappedBy = "productID")
	private List<Product> products;
	
	public Supplier() {
		super();
	}
	public Supplier(String supplierID, String supplierName, String address) {
		super();
		this.supplierID = supplierID;
		this.supplierName = supplierName;
		this.address = address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supplierID == null) ? 0 : supplierID.hashCode());
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
		Supplier other = (Supplier) obj;
		if (supplierID == null) {
			if (other.supplierID != null)
				return false;
		} else if (!supplierID.equals(other.supplierID))
			return false;
		return true;
	}
	
	

}
