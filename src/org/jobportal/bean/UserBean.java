package org.jobportal.bean;
/**
 * This the User Bean class that will hold
 * information to be displayed pertaining to the userbean
 * @author Izzul
 *
 */
public class UserBean extends Entity {
	String firstName;
	String lastName;
	String username;
	String email;
	String password;
	String country;
	String city;
	String state;
	String postalCode;
	String birthDate;
	String birthMonth;
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
/**
 * this method is for JUnit testing. It should not pass when firstName.length() is lesser than 2
 * @return this will return a value of true or false depending on the condition.
 */
	public boolean firstNameValidation() {
		boolean isValid=false;
		if(this.firstName.length()>=2) {
			isValid=true;
		}
		return isValid;
		
	}
}
