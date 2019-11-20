package com.flight.reservation.flightreservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERDETAILS")
public class UserDetails extends AbstractEntity {
	
	private Long mobileNumber;
	private String userName;
	private String password;
	private String email;

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
	 * inverseJoinColumns = @JoinColumn(name = "role_id")) private Set<Role> roles;
	 * 
	 * public Set<Role> getRoles() { return roles; }
	 * 
	 * public void setRoles(Set<Role> roles) { this.roles = roles; }
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		System.out.println("getemail:"+email);
		return email;
	}

	public void setEmail(String email) {
		System.out.println("setemail:"+email);
		this.email = email;
	}

	public Long getMobileNumber() {
		System.out.println("get Mobilenumber:"+mobileNumber);
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {

		System.out.println("setMobilenumber:"+mobileNumber);
		this.mobileNumber = mobileNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
