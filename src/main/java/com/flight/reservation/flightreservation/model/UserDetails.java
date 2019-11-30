package com.flight.reservation.flightreservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "USERDETAILS")
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long loginId;
	@Column(name="mobile")
	private Long mobileNumber;
	@Column(name="username",unique = true)
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="email" )
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName="user_id")
	private Set<UserRole> roles;
	@Transient
	private String role;
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
	public Set<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}
	@Override
	@JsonIgnore
	public String getUsername() {
		return this.userName;
	}
	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}
	public String getRole() {
		if(roles!=null&&roles.size()>0)
			return ((UserRole)roles.toArray()[0]).getRole();
		return role;
	}

	public void setAuthorities(Set<UserRole> authorities) {
		this.roles=authorities;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
