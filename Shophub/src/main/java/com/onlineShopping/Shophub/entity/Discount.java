package com.onlineShopping.Shophub.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.onlineShopping.Shophub.entity.Products;
@Entity
public class Discount {
	@Id
	@Column(name="DiscountID")
	private int discountID;
	
	@NotEmpty(message = "DiscountName can't be Empty.")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="DiscountName",length=30)
	private String discountName;
	
    @Size(min=1,max =3, message = "Minimum 1 and maximum 3 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
    @NotNull(message = "DiscountPercent can't be have null value.")
	@Column(name="DiscountPercent")
	private int discountPercent;
    
	@OneToMany(cascade=CascadeType.ALL)
	List<Products> products = new ArrayList<Products>();

	public int getDiscountID() {
		return discountID;
	}
	public void setDiscountID(int discountID) {
		this.discountID = discountID;
	}
	public String getDiscountName() {
		return discountName;
	}
	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}
	public int getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(int value) {
		this.discountPercent = value;
	}
	
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public Discount(int discountID, String discountName, int discountPercent) {
		super();
		this.discountID = discountID;
		this.discountName = discountName;
		this.discountPercent = discountPercent;
	}
	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
