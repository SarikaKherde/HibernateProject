package com.onlineShopping.Shophub.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.onlineShopping.Shophub.entity.Customer;
import com.onlineShopping.Shophub.entity.Payments;
@Entity
public class GiftCards {
	@Id
	@Column(name="GiftCardID")
	private int giftCardID;
	
	@NotNull(message = "Code can't be Null value.")
    @Size(min=2,max = 50, message = "Minimum 2 and maximum 50 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Only Alphabets and Numeric Values are Allowed")
	@Column(name="Code",length=50)
	private String code;
	
	@Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
    @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@NotNull(message = "Amount can't be have null value.")
	@Column(name="Amount")
	private int amount;
	
	@NotNull(message = "ExpiryDate can't be have null value.")
    @Size(min=8,max=10, message = "Minimum 8 and maximum 10 characters allowed.")
	@Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed")
	@Column(name="ExpiryDate",length=20)
	private LocalDate expiryDate;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
    @Column(name="CustomerID")
	private int customerID;

	@ManyToOne(cascade=CascadeType.ALL)
	Customer customer;

	@ManyToOne(cascade=CascadeType.ALL)
	Payments payments;
	
	public int getGiftCardID() {
		return giftCardID;
	}

	public void setGiftCardID(int giftCardID) {
		this.giftCardID = giftCardID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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

	public GiftCards(int giftCardID,
			@NotNull(message = "Code can't be Null value.") @Size(min = 2, max = 50, message = "Minimum 2 and maximum 50 characters allowed.") @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Only Alphabets and Numeric Values are Allowed") String code,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") @NotNull(message = "Amount can't be have null value.") int amount,
			@NotNull(message = "ExpiryDate can't be have null value.") @Size(min = 8, max = 10, message = "Minimum 8 and maximum 10 characters allowed.") @Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed") LocalDate expiryDate,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") int customerID) {
		super();
		this.giftCardID = giftCardID;
		this.code = code;
		this.amount = amount;
		this.expiryDate = expiryDate;
		this.customerID = customerID;
	}

	public GiftCards() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
