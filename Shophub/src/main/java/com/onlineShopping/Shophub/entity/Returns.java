package com.onlineShopping.Shophub.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.onlineShopping.Shophub.entity.Orders;

import com.onlineShopping.Shophub.entity.Customer;
@Entity
public class Returns {

	@Id
	@Column(name="ReturnID")
	private int returnID;
	
	@Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="OrderID")
	private int orderID;
	
	@NotNull(message = "ReturnDate can't be have null value.")
    @Size(min=8,max=10, message = "Minimum 8 and maximum 10 characters allowed.")
	@Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed")
	@Column(name="ReturnDate",length=20)
	private LocalDate returnDate;
	
    @Size(min = 2, max = 255, message = "Minimum 2 and maximum 255 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Only Alphabets,numeric value are Allowed.")
	@Column(name="Reason",length=255)
	private String reason;
	
	@NotNull(message = "Status can't be Null vlaue.")
    @Size(min = 3, max =30 , message = "Minimum 3 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="Status",length=30)
	private String status;

	@OneToOne(mappedBy="returns",cascade=CascadeType.ALL)
	Orders orders;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	Customer customer;
	
	public int getReturnID() {
		return returnID;
	}

	public void setReturnID(int returnID) {
		this.returnID = returnID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
    
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Returns(int returnID,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") int orderID,
			@NotNull(message = "ReturnDate can't be have null value.") @Size(min = 8, max = 10, message = "Minimum 8 and maximum 10 characters allowed.") @Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed") LocalDate returnDate,
			@Size(min = 2, max = 255, message = "Minimum 2 and maximum 255 characters allowed.") @Pattern(regexp = "^[a-zA-Z0-9\\\\s]*$", message = "Only Alphabets,numeric value are Allowed.") String reason,
			@NotNull(message = "Status can't be Null vlaue.") @Size(min = 3, max = 30, message = "Minimum 3 and maximum 30 characters allowed.") @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.") String status) {
		super();
		this.returnID = returnID;
		this.orderID = orderID;
		this.returnDate = returnDate;
		this.reason = reason;
		this.status = status;
	}

	public Returns() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
