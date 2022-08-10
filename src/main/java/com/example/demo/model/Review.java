package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
@Getter
@Setter
@Entity
public class Review implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String reviewID;
	@Column(name = "description",columnDefinition = "NVARCHAR(255)")
	private String description;
	@ManyToOne
	@JoinColumn(name = "customerID",referencedColumnName = "customerID")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="productID",referencedColumnName = "productID")
	private Product product;
    private LocalDateTime reviewDate;
	
	public Review() {
		super();
	}
	public Review(String reviewID, String description, Customer customer, Product product) {
		super();
		this.reviewID = reviewID;
		this.description = description;
		this.customer = customer;
		this.product = product;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reviewID == null) ? 0 : reviewID.hashCode());
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
		Review other = (Review) obj;
		if (reviewID == null) {
			if (other.reviewID != null)
				return false;
		} else if (!reviewID.equals(other.reviewID))
			return false;
		return true;
	}
	

}
