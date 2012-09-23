package net.example.reporting.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import net.example.reporting.dao.interfaces.BaseEntity;

/**
 * 
 * @author puneet
 *
 */
@Entity
@Table(name = "segment")
public class Segment implements BaseEntity {
	@Id
	@Column(name = "seg_id", nullable = false)
	Long segId;

	@Column(name = "name", nullable = false)
	String name;

	public long getSegId() {
		return segId;
	}

	public void setSegId(long segId) {
		this.segId = segId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Segment [segid=" + segId + ", name=" + name + "]";
	}
}
