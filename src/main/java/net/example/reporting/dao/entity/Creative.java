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
@Table(name = "creative")
public class Creative implements BaseEntity {
	@Id
	@Column(name = "cr_id", nullable = false)
	Long crId;

	@Column(name = "width", nullable = true)
	Long creative_width;

	@Column(name = "height", nullable = true)
	Long height;

	@Column(name = "name", nullable = true)
	String name;

	@Column(name = "url", nullable = true)
	String url;

	@Column(name = "is_popup", nullable = true)
	String isPopUp;

	@Column(name = "type", nullable = true)
	String type;

	public long getCrId() {
		return crId;
	}

	public void setCrId(long cr_id) {
		this.crId = cr_id;
	}

	public long getCreative_width() {
		return creative_width;
	}

	public long getHeight() {
		return height;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public String getIsPopUp() {
		return isPopUp;
	}

	public String getType() {
		return type;
	}

	public void setCreative_width(long creative_width) {
		this.creative_width = creative_width;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setIsPopUp(String isPopUp) {
		this.isPopUp = isPopUp;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Creative [creative_width=" + creative_width + ", height="
				+ height + ", name=" + name + ", url=" + url + ", isPopUp="
				+ isPopUp + ", type=" + type + "]";
	}
}
