package com.onlineShopping.Shophub.entity;

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



import com.onlineShopping.Shophub.entity.Products;

import com.onlineShopping.Shophub.entity.Customer;


@Entity
public class ShoppingCart {

	@Id
	@Column(name="CartID")
	private int cartID;
	
	@Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
    @Column(name="CustomerID")
	private int customerID;
	
	@Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="ProductID")
	private int productID;
	
	@Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@NotNull(message = "Quantity can't be have null value.")
	@Column(name="Quantity")
	private int quantity;

	
	@OneToMany(cascade=CascadeType.ALL)
	List<Products> products = new ArrayList<Products>();
	
	@OneToOne(mappedBy="shoppingCart",cascade=CascadeType.ALL)
	Customer customer;
	
	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShoppingCart(int cartID,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") int customerID,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") int productID,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") @NotNull(message = "Quantity can't be have null value.") int quantity) {
		super();
		this.cartID = cartID;
		this.customerID = customerID;
		this.productID = productID;
		this.quantity = quantity;
	}

	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
