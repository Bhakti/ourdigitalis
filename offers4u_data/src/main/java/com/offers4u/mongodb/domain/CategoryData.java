package com.offers4u.mongodb.domain;

public class CategoryData {

	private Category category;

	private int availedCount;

	private int clickedCount;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getAvailedCount() {
		return availedCount;
	}

	public void setAvailedCount(int availedCount) {
		this.availedCount = availedCount;
	}

	public int getClickedCount() {
		return clickedCount;
	}

	public void setClickedCount(int clickedCount) {
		this.clickedCount = clickedCount;
	}

	@Override
	public String toString() {
		return "CategoryData [category=" + category + ", availedCount=" + availedCount + ", clickedCount="
				+ clickedCount + "]";
	}

}
