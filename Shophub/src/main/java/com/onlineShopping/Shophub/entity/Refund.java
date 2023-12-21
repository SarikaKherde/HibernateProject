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

import com.onlineShopping.Shophub.entity.Customer;
import com.onlineShopping.Shophub.entity.Orders;
import com.onlineShopping.Shophub.entity.Payments;
@Entity
public class Refund {
	@Id
	@Column(name="RefundID")
	private int refundID;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="OrderID")
	private int orderID;
    
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="CustomerID")
	private int customerID;
    
	@NotNull(message = "RefundDate can't be have null value.")
    @Size(min=8,max=10, message = "Minimum 8 and maximum 10 characters allowed.")
	@Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed")
	@Column(name="RefundDate",length=20)
	private LocalDate refundDate;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
    @NotNull(message = "RefundAmount can't be have null value.")
	@Column(name="RefundAmount")
	private int refundAmount;

    
	@ManyToOne(cascade=CascadeType.ALL)
	Customer customer;
	
	@OneToOne(mappedBy="refund",cascade=CascadeType.ALL)
	Orders orders;
	
	@OneToOne(mappedBy="refund",cascade=CascadeType.ALL)
	Payments payments;
	
	public int getRefundID() {
		return refundID;
	}

	public void setRefundID(int refundID) {
		this.refundID = refundID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public LocalDate getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(LocalDate refundDate) {
		this.refundDate = refundDate;
	}

	public int getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
   
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Payments getPayments() {
		return payments;
	}

	public void setPayments(Payments payments) {
		this.payments = payments;
	}

	public Refund(int refundID,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") int orderID,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") int customerID,
			@NotNull(message = "RefundDate can't be have null value.") @Size(min = 8, max = 10, message = "Minimum 8 and maximum 10 characters allowed.") @Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed") LocalDate refundDate,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") @NotNull(message = "RefundAmount can't be have null value.") int refundAmount) {
		super();
		this.refundID = refundID;
		this.orderID = orderID;
		this.customerID = customerID;
		this.refundDate = refundDate;
		this.refundAmount = refundAmount;
	}

	public Refund() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

    
}
