package com.api.customer.models;

//UserCredentials.java
public class LoginRequest {

 private String loginId;
 private String password;

 
 public LoginRequest(String loginId, String password) {
	super();
	this.loginId = loginId;
	this.password = password;
}


//getters and setters
 
public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

 // getters and setters
 
 
 
}
