package com.offers4u.mysql.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the segment database table.
 * 
 */
@Entity
@NamedQuery(name="Segment.findAll", query="SELECT s FROM Segment s")
public class Segment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="segment_id")
	private String segmentId;

	@Column(name="segment_name")
	private String segmentName;

	public Segment() {
	}

	public String getSegmentId() {
		return this.segmentId;
	}

	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}

	public String getSegmentName() {
		return this.segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

}