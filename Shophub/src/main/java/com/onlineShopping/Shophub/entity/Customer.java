package com.onlineShopping.Shophub.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.onlineShopping.Shophub.entity.Orders;
import com.onlineShopping.Shophub.entity.GiftCards;
import com.onlineShopping.Shophub.entity.ShoppingCart;

import com.onlineShopping.Shophub.entity.ShoppingCart;
import com.onlineShopping.Shophub.entity.Wishlist;
import com.onlineShopping.Shophub.entity.Shipment;
import com.onlineShopping.Shophub.entity.Payments;
import com.onlineShopping.Shophub.entity.Returns;
import com.onlineShopping.Shophub.entity.Reviews;
import com.onlineShopping.Shophub.entity.Refund;
@Entity
public class Customer {
	@Id
	@Column(name="CustomerID")
	private int customerID;
	
    @Size(max = 100, message = "Address must not exceed 100 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed")
	@Column(name="Address",length=100)
	private String address;

    
	@OneToMany(cascade=CascadeType.ALL)
	List<Orders> orders = new ArrayList<Orders>();
	
	@OneToMany(cascade=CascadeType.ALL)
	List<GiftCards> giftCards = new ArrayList<GiftCards>();
	
	@OneToOne
	ShoppingCart shoppingCart;

	@OneToOne
	Wishlist wishlist;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Shipment> shipment = new ArrayList<Shipment>();
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Payments> payments = new ArrayList<Payments>();
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Returns> returns = new ArrayList<Returns>();
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Reviews> reviews = new ArrayList<Reviews>();
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Refund> refund = new ArrayList<Refund>();
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
    
	public List<GiftCards> getGiftCards() {
		return giftCards;
	}

	public void setGiftCards(List<GiftCards> giftCards) {
		this.giftCards = giftCards;
	}
    
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
    
    
	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	public List<Shipment> getShipment() {
		return shipment;
	}

	public void setShipment(List<Shipment> shipment) {
		this.shipment = shipment;
	}
    
	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}
    
	public List<Returns> getReturns() {
		return returns;
	}

	public void setReturns(List<Returns> returns) {
		this.returns = returns;
	}
	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}
    
	public List<Refund> getRefund() {
		return refund;
	}

	public void setRefund(List<Refund> refund) {
		this.refund = refund;
	}

	public Customer(int customerID,
			@Size(max = 100, message = "Address must not exceed 100 characters") @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed") String address) {
		super();
		this.customerID = customerID;
		this.address = address;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	}


   

    


    
	


