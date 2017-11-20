package com.offers4u.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the category_segment database table.
 * 
 */
@Embeddable
public class CategorySegmentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="segment_id", insertable=false, updatable=false)
	private String segmentId;

	@Column(name="category_id", insertable=false, updatable=false)
	private String categoryId;

	public CategorySegmentPK() {
	}
	public String getSegmentId() {
		return this.segmentId;
	}
	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CategorySegmentPK)) {
			return false;
		}
		CategorySegmentPK castOther = (CategorySegmentPK)other;
		return 
			this.segmentId.equals(castOther.segmentId)
			&& this.categoryId.equals(castOther.categoryId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.segmentId.hashCode();
		hash = hash * prime + this.categoryId.hashCode();
		
		return hash;
	}
}