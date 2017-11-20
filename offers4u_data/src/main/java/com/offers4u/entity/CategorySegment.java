package com.offers4u.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the category_segment database table.
 * 
 */
@Entity
@Table(name="category_segment")
//@NamedQuery(name="CategorySegment.findAll", query="SELECT c FROM CategorySegment c")
public class CategorySegment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CategorySegmentPK id;

	public CategorySegment() {
	}

	public CategorySegmentPK getId() {
		return this.id;
	}

	public void setId(CategorySegmentPK id) {
		this.id = id;
	}

}