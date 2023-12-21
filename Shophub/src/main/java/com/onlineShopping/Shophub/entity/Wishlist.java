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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.onlineShopping.Shophub.entity.Customer;
import com.onlineShopping.Shophub.entity.Products;
@Entity
public class Wishlist {
	@Id
	@Column(name="wishlistID")
	private int WishlistID;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="CustomerID")
	private int customerID;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="ProductID")
	private int productID;
	
	@NotNull(message = "DateAdded can't be have null value.")
    @Size(min=8,max=10, message = "Minimum 8 and maximum 10 characters allowed.")
	@Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed")
	@Column(name="DateAdded",length=20)
	private LocalDate dateAdded;

	@OneToOne(mappedBy="wishlist",cascade=CascadeType.ALL)
	Customer customer;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Products> products = new ArrayList<Products>();

	
	public int getWishlistID() {
		return WishlistID;
	}

	public void setWishlistID(int wishlistID) {
		WishlistID = wishlistID;
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

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public Wishlist(int wishlistID,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") int customerID,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") int productID,
			@NotNull(message = "DateAdded can't be have null value.") @Size(min = 8, max = 10, message = "Minimum 8 and maximum 10 characters allowed.") @Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed") LocalDate dateAdded) {
		super();
		WishlistID = wishlistID;
		this.customerID = customerID;
		this.productID = productID;
		this.dateAdded = dateAdded;
	}

	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
