package com.onlineShopping.Shophub.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.onlineShopping.Shophub.entity.Customer;
import com.onlineShopping.Shophub.entity.Orders;
@Entity
public class Shipment {
	@Id
	@Column(name="ShipmentID")
	private int shipmentID;
	
	@NotNull(message = "ShipmentDate can't be have null value.")
    @Size(min=8,max=10, message = "Minimum 8 and maximum 10 characters allowed.")
	@Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed")
	@Column(name="ShipmentDate",length=20)
	private LocalDate shipmentDate;
	
	@NotEmpty(message = "State can't be Empty.")
    @Size(max = 50, message = "State must not exceed 50 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed")
	@Column(name="State",length=50)
	private String state;
	
	@NotEmpty(message = "City can't be Empty.")
    @Size(max = 30, message = "City must not exceed 30 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed")
	@Column(name="City",length=30)
	private String city;
	
    @Size(min=1,max =20, message = "Minimum 1 and maximum 20 characters allowed.")
	@Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed")
    @NotNull(message = "pincode can't be have null value.")
	@Column(name="pincode")
	private String pincode;
	
	@NotEmpty(message = "HouseName can't be Empty.")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="HouseName",length=30)
	private String houseName;
	
	@NotEmpty(message = "Area can't be Empty.")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="Area",length=30)
	private String area ;

	@OneToOne(mappedBy="shipment",cascade=CascadeType.ALL)
	Orders orders; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	Customer customer;
	public int getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(int shipmentID) {
		this.shipmentID = shipmentID;
	}

	public LocalDate getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
    
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Shipment(int shipmentID,
			@NotNull(message = "ShipmentDate can't be have null value.") @Size(min = 8, max = 10, message = "Minimum 8 and maximum 10 characters allowed.") @Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed") LocalDate shipmentDate,
			@NotEmpty(message = "State can't be Empty.") @Size(max = 50, message = "State must not exceed 50 characters") @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed") String state,
			@NotEmpty(message = "City can't be Empty.") @Size(max = 30, message = "City must not exceed 30 characters") @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed") String city,
			@Size(min = 1, max = 20, message = "Minimum 1 and maximum 20 characters allowed.") @Pattern(regexp = "^[0-9]*$", message = "Only digit are Allowed") @NotNull(message = "pincode can't be have null value.") String pincode,
			@NotEmpty(message = "HouseName can't be Empty.") @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.") @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.") String houseName,
			@NotEmpty(message = "Area can't be Empty.") @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.") @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.") String area) {
		super();
		this.shipmentID = shipmentID;
		this.shipmentDate = shipmentDate;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.houseName = houseName;
		this.area = area;
	}

	public Shipment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
   
}
