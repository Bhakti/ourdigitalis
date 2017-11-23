package com.offers4u.mongodb.domain;

public class CategoryData {

	private Category category;

	private Integer availedCount;

	private Integer clickedCount;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getAvailedCount() {
		return availedCount;
	}

	public void setAvailedCount(Integer availedCount) {
		this.availedCount = availedCount;
	}

	public Integer getClickedCount() {
		return clickedCount;
	}

	public void setClickedCount(Integer clickedCount) {
		this.clickedCount = clickedCount;
	}

	@Override
	public String toString() {
		return "CategoryData [category=" + category + ", availedCount=" + availedCount + ", clickedCount="
				+ clickedCount + "]";
	}

}
