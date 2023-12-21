package com.onlineShopping.Shophub.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


//import com.onlineShopping.Shophub.entity.Seller;





@Entity
public class Users {
	//Variable Declaration
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UserID")
	private int userID;
	
	@NotEmpty(message = "UserName can't be Empty.")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
	@Column(name="UserName",length=30)
	private String userName;
    
	@NotEmpty(message = "Email can't be Empty.")
    @Size(max = 255, message = "Email address must not exceed 255 characters")
	@Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Only Alphabets and Numeric Values are Allowed")
	@Email(message = "Please provide a valid email address")
	@Column(name="Email")
	private String email;
	
	@NotEmpty(message = "Password can't be Empty.")
    @Size(min = 3, max = 50, message = "Minimum 3 and maximum 40 characters allowed.")
	@Pattern(regexp = "^[A-Za-z\\d@$!%*?&]*$", message = "At least one lowercase letter, one uppercase letter, one digit and one spacial charector must be there")
	@Column(name="Password")
	private String password;

    //This regex pattern allows for variations like "(123) 456-7890", "123-456-7890", "1234567890"
	@NotEmpty(message = "PhoneNumber can't be Empty.")
    @Size(min=10,max =10, message = "PhoneNumber must be exactly 10 characters")
	@Pattern(regexp = "^[0-9-()]*$", message = "Only digit are Allowed")
	@Column(name="PhoneNumber",length=10)
	private String phoneNumber;
	
	@NotEmpty(message = "UserType can't be Empty.")
    @Size(min=5,max=8, message = "Minimum 5 and maximum 8 characters allowed.")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed")
	@Column(name="UserType",length=8)
	private String userType;
	
	@NotNull(message = "registrationDate can't be have null value.")
    @Size(min=8,max=10, message = "Minimum 8 and maximum 10 characters allowed.")
	@Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed")
	@Column(name="RegistrationDate",length=20)
	private LocalDate registrationDate;
	
	//Relations with other table

	
	
//	@OneToOne
//	Seller seller;
	

    

	
	//Getter & Setter
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}




	public Users(
			@NotEmpty(message = "UserName can't be Empty.") @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.") @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.") String userName,
			@NotEmpty(message = "Email can't be Empty.") @Size(max = 255, message = "Email address must not exceed 255 characters") @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Only Alphabets and Numeric Values are Allowed") @Email(message = "Please provide a valid email address") String email,
			@NotEmpty(message = "Password can't be Empty.") @Size(min = 3, max = 50, message = "Minimum 3 and maximum 40 characters allowed.") @Pattern(regexp = "^[A-Za-z\\d@$!%*?&]*$", message = "At least one lowercase letter, one uppercase letter, one digit and one spacial charector must be there") String password,
			@NotEmpty(message = "PhoneNumber can't be Empty.") @Size(min = 10, max = 10, message = "PhoneNumber must be exactly 10 characters") @Pattern(regexp = "^[0-9-()]*$", message = "Only digit are Allowed") String phoneNumber,
			@NotEmpty(message = "UserType can't be Empty.") @Size(min = 5, max = 8, message = "Minimum 5 and maximum 8 characters allowed.") @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets Values are Allowed") String userType,
			@NotNull(message = "registrationDate can't be have null value.") @Size(min = 8, max = 10, message = "Minimum 8 and maximum 10 characters allowed.") @Pattern(regexp = "^[0-9-]*$", message = "Only digit and hyphen Values are Allowed") LocalDate registrationDate) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.userType = userType;
		this.registrationDate = registrationDate;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}





