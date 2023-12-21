package com.onlineShopping.Shophub.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.onlineShopping.Shophub.entity.Customer;
import com.onlineShopping.Shophub.entity.Returns;
import com.onlineShopping.Shophub.entity.Payments;
import com.onlineShopping.Shophub.entity.Products;
import com.onlineShopping.Shophub.entity.Shipment;
import com.onlineShopping.Shophub.entity.Refund;
@Entity
public class Orders {
	@Id
	@Column(name="OrderID")
	private int orderID;
	
	@Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
    @Column(name="CustomerID")
	private int customerID;
	
	@NotNull(message = "OrderDate can't be have null value.")
    @Size(min=8,max=10, message = "Minimum 8 and maximum 10 characters allowed.")
	@Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed")
	@Column(name="OrderDate",length=20)
	private LocalDate orderDate;
	
	@NotNull(message = "Status can't be Null vlaue.")
    @Size(min = 3, max =30 , message = "Minimum 3 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="Status",length=30)
	private String status;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Customer customer;
	
	@OneToOne
	Payments payments;
	
	@OneToOne
	Returns returns;
	
	@OneToOne
	Shipment shipment;
	
	@OneToOne
	Refund refund;
	
	@ManyToMany(mappedBy="orders",cascade=CascadeType.ALL)
	List<Products> products = new ArrayList<Products>();
	
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
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Payments getPayments() {
		return payments;
	}
	public void setPayments(Payments payments) {
		this.payments = payments;
	}
	public Returns getReturns() {
		return returns;
	}
	public void setReturns(Returns returns) {
		this.returns = returns;
	}
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	
	public Refund getRefund() {
		return refund;
	}
	public void setRefund(Refund refund) {
		this.refund = refund;
	}
	public Orders(int orderID, int customerID,LocalDate orderDate, String status){
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.status = status;
  
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}	

	
}


