package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Setter
@Getter
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String customerID;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String firstName;
    @Column(columnDefinition = "NVARCHAR(255)")
	private String lastName;
	private String email;
	private String phoneNumber;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String address;
	@OneToOne(mappedBy = "customer")
	@PrimaryKeyJoinColumn
	private Account account;
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;
	public Customer() {
		super();
	}

	public Customer(String firstName, String email, String phoneNumber, String address) {
		super();
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
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
		Customer other = (Customer) obj;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		return true;
	}
}
