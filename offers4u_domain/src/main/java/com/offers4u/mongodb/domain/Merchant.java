package com.offers4u.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "merchant")
public class Merchant {

	@Id
	private String id;

	private String merchantName;

	private String merchantCategories;

	private String merchantLogoLarge;

	private String merchantLogoSmall;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantCategories() {
		return merchantCategories;
	}

	public void setMerchantCategories(String merchantCategories) {
		this.merchantCategories = merchantCategories;
	}

	public String getMerchantLogoLarge() {
		return merchantLogoLarge;
	}

	public void setMerchantLogoLarge(String merchantLogoLarge) {
		this.merchantLogoLarge = merchantLogoLarge;
	}

	public String getMerchantLogoSmall() {
		return merchantLogoSmall;
	}

	public void setMerchantLogoSmall(String merchantLogoSmall) {
		this.merchantLogoSmall = merchantLogoSmall;
	}

	@Override
	public String toString() {
		return "Merchant [id=" + id + ", merchantName=" + merchantName + ", merchantCategories=" + merchantCategories
				+ ", merchantLogoLarge=" + merchantLogoLarge + ", merchantLogoSmall=" + merchantLogoSmall + "]";
	}

}
