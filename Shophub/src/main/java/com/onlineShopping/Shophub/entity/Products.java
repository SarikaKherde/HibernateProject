package com.onlineShopping.Shophub.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.onlineShopping.Shophub.entity.Categories;

import com.onlineShopping.Shophub.entity.Reviews;

import com.onlineShopping.Shophub.entity.ShoppingCart;

import com.onlineShopping.Shophub.entity.Orders;
import com.onlineShopping.Shophub.entity.Wishlist;
import com.onlineShopping.Shophub.entity.Discount;

@Entity
public class Products {
	@Id
	@Column(name="ProductID")
	private int productID;
	
	@NotEmpty(message = "ProductName can't be Empty.")
    @Size(min = 2, max = 40, message = "Minimum 2 and maximum 40 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="ProductName",length=30)
	private String productName;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="CategoryID")
	private int categoryID;
	
    @NotNull(message = "Price can't be null value.")
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="Price")
	private int price;
	
    @NotNull(message = "Stack can't be null value.")
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
	@Column(name="StockQuantity")
	private int stockQuantity;
	
	
    @Size(min = 2, max = 255, message = "Minimum 2 and maximum 255 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z0-9\\\\s]*$", message = "Only Alphabets,numeric value are Allowed.")
	@Column(name="Description",length=255)
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Categories categories;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Reviews> reviews = new ArrayList<Reviews>();

	@ManyToOne(cascade=CascadeType.ALL)
	ShoppingCart shoppingCart;
	
	@ManyToMany(cascade=CascadeType.ALL)
	List<Orders> orders = new ArrayList<Orders>();
	
	@ManyToOne(cascade=CascadeType.ALL)
	Discount discount;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Wishlist wishlist;
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}
	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	public Wishlist getWishlist() {
		return wishlist;
	}
	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}
	public Products(int productID, String productName, int categoryID, int price, int stockQuantity,
			String description) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.categoryID = categoryID;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.description = description;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}






