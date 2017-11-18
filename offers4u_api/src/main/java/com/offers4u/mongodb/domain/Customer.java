package com.offers4u.mongodb.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {

	@Id
	private String id;

	private User user;

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

	private List<Category> categoryPreferences;

	private List<Segment> segments;

	private List<RecommendedOffer> recommendedOffers;

	private List<Notification> notifications;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public List<Category> getCategoryPreferences() {
		return categoryPreferences;
	}

	public void setCategoryPreferences(List<Category> categoryPreferences) {
		this.categoryPreferences = categoryPreferences;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	public List<RecommendedOffer> getRecommendedOffers() {
		return recommendedOffers;
	}

	public void setRecommendedOffers(List<RecommendedOffer> recommendedOffers) {
		this.recommendedOffers = recommendedOffers;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", user=" + user + ", accountNumber=" + accountNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", gender=" + gender + ", dob=" + dob
				+ ", nationality=" + nationality + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber
				+ ", dnpMobile=" + dnpMobile + ", dnpEmail=" + dnpEmail + ", houseNumberName=" + houseNumberName
				+ ", flatNumber=" + flatNumber + ", street=" + street + ", city=" + city + ", postCode=" + postCode
				+ ", residentalStatus=" + residentalStatus + ", employmentStatus=" + employmentStatus
				+ ", currentAnnualIncome=" + currentAnnualIncome + ", categoryPreferences=" + categoryPreferences
				+ ", segments=" + segments + ", recommendedOffers=" + recommendedOffers + ", notifications="
				+ notifications + ", getId()=" + getId() + ", getUser()=" + getUser() + ", getAccountNumber()="
				+ getAccountNumber() + ", getFirstName()=" + getFirstName() + ", getMiddleName()=" + getMiddleName()
				+ ", getLastName()=" + getLastName() + ", getGender()=" + getGender() + ", getDob()=" + getDob()
				+ ", getNationality()=" + getNationality() + ", getEmailId()=" + getEmailId() + ", getMobileNumber()="
				+ getMobileNumber() + ", getDnpMobile()=" + getDnpMobile() + ", getDnpEmail()=" + getDnpEmail()
				+ ", getHouseNumberName()=" + getHouseNumberName() + ", getFlatNumber()=" + getFlatNumber()
				+ ", getStreet()=" + getStreet() + ", getCity()=" + getCity() + ", getPostCode()=" + getPostCode()
				+ ", getResidentalStatus()=" + getResidentalStatus() + ", getEmploymentStatus()="
				+ getEmploymentStatus() + ", getCurrentAnnualIncome()=" + getCurrentAnnualIncome()
				+ ", getCategoryPreferences()=" + getCategoryPreferences() + ", getSegments()=" + getSegments()
				+ ", getRecommendedOffers()=" + getRecommendedOffers() + ", getNotifications()=" + getNotifications()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
