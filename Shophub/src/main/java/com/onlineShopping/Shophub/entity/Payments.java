package com.onlineShopping.Shophub.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.onlineShopping.Shophub.entity.Orders;

import com.onlineShopping.Shophub.entity.Customer;
import com.onlineShopping.Shophub.entity.Refund;
import com.onlineShopping.Shophub.entity.GiftCards;
@Entity
public class Payments {
	@Id
	@Column(name="PaymentID")
	private int paymentID;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="OrderID")
	private int orderID;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
    @NotNull(message = "Amount can't be have null value.")
	@Column(name="Amount")
	private int amount;
	
	@NotNull(message = "PaymentDate can't be have null value.")
    @Size(min=8,max=10, message = "Minimum 8 and maximum 10 characters allowed.")
	@Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed")
	@Column(name="RegistrationDate",length=20)
	private LocalDate paymentDate;
	
	@NotEmpty(message = "PaymentMethod can't be Empty.")
    @Size(min = 3, max =30 , message = "Minimum 3 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="UserName",length=30)
	private String paymentMethod;
	
	@OneToOne(mappedBy="payments",cascade=CascadeType.ALL)
	Orders orders;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Customer customer;
	
	@OneToOne
	Refund refund;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<GiftCards> giftCards = new ArrayList<GiftCards>();
	
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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
	
	public Refund getRefund() {
		return refund;
	}
	public void setRefund(Refund refund) {
		this.refund = refund;
	}
	
	public List<GiftCards> getGiftCards() {
		return giftCards;
	}
	public void setGiftCards(List<GiftCards> giftCards) {
		this.giftCards = giftCards;
	}
	public Payments(int paymentID, int orderID, int amount, LocalDate paymentDate, String paymentMethod) {
		super();
		this.paymentID = paymentID;
		this.orderID = orderID;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
	}
	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}




