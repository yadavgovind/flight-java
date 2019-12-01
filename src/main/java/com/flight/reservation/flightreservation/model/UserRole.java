package com.flight.reservation.flightreservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="user_role")
public class UserRole implements GrantedAuthority
{

	@Id
	@GeneratedValue
	@Column(name="role_id")
	private Integer roleId;
	@Column(name="role")
	private String role;
	@Column(name="user_id")
	private Long userId;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@JsonIgnore
	public String getAuthority() {
		return role;
	}
	    
}
