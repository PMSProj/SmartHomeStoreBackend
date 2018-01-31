package com.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Entity
@Component
public class UserData implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @NotNull
    String name;
	//@Email(message="Enter valid Email")
	private String email;
	@NotNull
	@Length(min=8)
	private String password;
	private String role;
	@NotNull
	private String address;
	//@Pattern(regex="[\\d](10)" ,message="Enter valid digits")
	// @Size(min=8,max=10,message="Enter valid number for contact number")
	private int contactnumber;
	private Boolean enabled;
	public UserData() {
		
	}
			public UserData(String name, String email, String password, String role, String address, int contactnumber,
			boolean enabled) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.address = address;
		this.contactnumber = contactnumber;
		this.enabled = enabled;
	}
	@Override
		public String toString() {
	        return"UserData [name="+name+",email=" + email +",password="+password+" ,address="+address +"]";
		}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(int contactnumber) {
		this.contactnumber = contactnumber;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
