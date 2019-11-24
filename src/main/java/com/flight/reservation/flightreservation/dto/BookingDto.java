package com.flight.reservation.flightreservation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

 
public class BookingDto {
 
private boolean isAdult;
	 
private boolean isChild;
private boolean isEconomy;
private boolean isBussiness;
private int flightNo;
private double price;

private String firstName;
private String lastName;
private String middleName;
private String email;
private String phone;
private String adharCard;
private String pancard;
public boolean isAdult() {
	return isAdult;
}
public void setAdult(boolean isAdult) {
	this.isAdult = isAdult;
}
public boolean isChild() {
	return isChild;
}
public void setChild(boolean isChild) {
	this.isChild = isChild;
}
public boolean isEconomy() {
	return isEconomy;
}
public void setEconomy(boolean isEconomy) {
	this.isEconomy = isEconomy;
}
public boolean isBussiness() {
	return isBussiness;
}
public void setBussiness(boolean isBussiness) {
	this.isBussiness = isBussiness;
}
public int getFlightNo() {
	return flightNo;
}
public void setFlightNo(int flightNo) {
	this.flightNo = flightNo;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getMiddleName() {
	return middleName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAdharCard() {
	return adharCard;
}
public void setAdharCard(String adharCard) {
	this.adharCard = adharCard;
}
public String getPancard() {
	return pancard;
}
public void setPancard(String pancard) {
	this.pancard = pancard;
}


}
