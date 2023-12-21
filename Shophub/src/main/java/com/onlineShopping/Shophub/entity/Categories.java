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
public class Categories {
	@Id
	@Column(name="CategoryID")
	private int categoryID;
	
	@NotNull(message = "CategoryName can't be Empty.")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Only Alphabets and Numeric value are Allowed.")
	@Column(name="CategoryName",length=30)
	private String categoryName;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Products> products = new ArrayList<Products>();
	
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public Categories(int categoryID, String categoryName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
