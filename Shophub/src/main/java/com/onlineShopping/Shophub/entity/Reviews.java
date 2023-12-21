package com.onlineShopping.Shophub.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.onlineShopping.Shophub.entity.Products;
import com.onlineShopping.Shophub.entity.Customer;



@Entity
public class Reviews {
	@Id
	@Column(name="ReviewID")
	private int reviewID;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="CustomerID")
	private int customerID;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="ProductID")
	private int productID;
	
    @DecimalMin(value = "0.0", inclusive = true, message = "Rating must be at least 0.0")
    @DecimalMax(value = "5.0", inclusive = true, message = "Rating must be at most 5.0")
	@Pattern(regexp = "^[0-9.]*$", message = "Only digit are Allowed")
    @NotNull(message = "Rating can't be have null value.")
	@Column(name="Rating")
	private Double rating;
	
    @Size(max = 100, message = "Comment must not exceed 100 characters")
  	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed")
	@Column(name="Comment",length=100)
	private String comment;
	
	@NotNull(message = "ReviewDate can't be have null value.")
    @Size(min=8,max=10, message = "Minimum 8 and maximum 10 characters allowed.")
	@Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed")
	@Column(name="ReviewDate",length=20)
	private LocalDate reviewDate;

	

	@ManyToOne(cascade=CascadeType.ALL)
	Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Products products;
	
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDate getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(LocalDate reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Reviews(int reviewID, int customerID, int productID, Double rating, String comment, LocalDate reviewDate) {
		super();
		this.reviewID = reviewID;
		this.customerID = customerID;
		this.productID = productID;
		this.rating = rating;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}
	public Reviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

