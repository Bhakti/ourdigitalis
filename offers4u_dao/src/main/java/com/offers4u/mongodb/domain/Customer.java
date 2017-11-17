package com.offers4u.mongodb.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {

	@Id
	private String id;

	private String accountNumber;

	private String firstName;

	private String middleName;

	private String lastName;

	private String gender;

	private Date dob;

	private String nationality;

	private String emailId;

	private String mobileNumber;

	private String dnpMobile;

	private String dnpEmail;

	// define
	private String houseNumberName;

	private String flatNumber;

	private String street;

	private String city;

	private String postCode;

	private String residentalStatus;

	private String employmentStatus;

	private String currentAnnualIncome;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDnpMobile() {
		return dnpMobile;
	}

	public void setDnpMobile(String dnpMobile) {
		this.dnpMobile = dnpMobile;
	}

	public String getDnpEmail() {
		return dnpEmail;
	}

	public void setDnpEmail(String dnpEmail) {
		this.dnpEmail = dnpEmail;
	}

	public String getHouseNumberName() {
		return houseNumberName;
	}

	public void setHouseNumberName(String houseNumberName) {
		this.houseNumberName = houseNumberName;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getResidentalStatus() {
		return residentalStatus;
	}

	public void setResidentalStatus(String residentalStatus) {
		this.residentalStatus = residentalStatus;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getCurrentAnnualIncome() {
		return currentAnnualIncome;
	}

	public void setCurrentAnnualIncome(String currentAnnualIncome) {
		this.currentAnnualIncome = currentAnnualIncome;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", accountNumber=" + accountNumber + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", gender=" + gender + ", dob=" + dob + ", nationality="
				+ nationality + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", dnpMobile=" + dnpMobile
				+ ", dnpEmail=" + dnpEmail + ", houseNumberName=" + houseNumberName + ", flatNumber=" + flatNumber
				+ ", street=" + street + ", city=" + city + ", postCode=" + postCode + ", residentalStatus="
				+ residentalStatus + ", employmentStatus=" + employmentStatus + ", currentAnnualIncome="
				+ currentAnnualIncome + "]";
	}

}
