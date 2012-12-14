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
@Table(name="publisher")
public class Publisher implements BaseEntity {
	@Id
	@Column(name="li_id",nullable=false)
	Long liId;
	
	@Column(name="io_id", nullable=true)
	Long ioId;

	@Column(name="publisher_id", nullable=true)
	Long publisherId;
	
	@Column(name="licensee_id", nullable=true)
	Long licenseeId;
	
	@Column(name="pricing_type", nullable=true)
	Long pricingType;
	
	@Column(name="publisher_name", nullable=true)
	String publisherName;
	
	@Column(name="io_name", nullable=true)
	String ioName;
	
	@Column(name="li_name", nullable=true)
	String liName;
	
	public long getLiId() {
		return liId;
	}

	public long getIoId() {
		return ioId;
	}

	public long getPublisherId() {
		return publisherId;
	}

	public long getLicenseeId() {
		return licenseeId;
	}

	public long getPricingType() {
		return pricingType;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public String getIoName() {
		return ioName;
	}

	public String getLiName() {
		return liName;
	}

	public void setLiId(long liId) {
		this.liId = liId;
	}

	public void setIoId(long ioId) {
		this.ioId = ioId;
	}

	public void setPublisherId(long publisherId) {
		this.publisherId = publisherId;
	}

	public void setLicenseeId(long licenseeId) {
		this.licenseeId = licenseeId;
	}

	public void setPricingType(long pricingType) {
		this.pricingType = pricingType;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public void setIoName(String ioName) {
		this.ioName = ioName;
	}

	public void setLiName(String liName) {
		this.liName = liName;
	}

	@Override
	public String toString() {
		return "Publisher [liId=" + liId + ", ioId=" + ioId + ", publisherId="
				+ publisherId + ", licenseeId=" + licenseeId + ", pricingType="
				+ pricingType + ", publisherName=" + publisherName
				+ ", ioName=" + ioName + ", liName=" + liName + "]";
	}
	 
}
