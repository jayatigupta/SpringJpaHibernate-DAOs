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
@Table(name = "advertiser")
public class Advertiser implements BaseEntity{

	@Id
	@Column(name = "li_id", nullable = false)
	Long liId;

	@Column(name = "licensee_id", nullable = true)
	long licenseeId;

	@Column(name = "advertiser_id", nullable = true)
	long advertiserId;

	@Column(name = "currency_id", nullable = true)
	long currencyId;

	@Column(name = "io_region_id", nullable = true)
	long ioRegionId;

	@Column(name = "io_id", nullable = true)
	long ioId;

	@Column(name = "io_currency_id", nullable = true)
	long ioCurrencyId;

	@Column(name = "pricing_type", nullable = true)
	long pricingType;

	@Column(name = "advertiser_name", nullable = true)
	String advertiserName;

	@Column(name = "io_name", nullable = true)
	String ioName;

	@Column(name = "li_name", nullable = true)
	String liName;

	@Column(name = "li_budget", nullable = true)
	String liBudget;

	@Column(name = "start_time", nullable = true)
	long startTime;

	@Column(name = "end_time", nullable = true)
	long endTime;

	public long getLiId() {
		return liId;
	}

	public long getLicenseeId() {
		return licenseeId;
	}

	public long getAdvertiserId() {
		return advertiserId;
	}

	public long getCurrencyId() {
		return currencyId;
	}

	public long getIoRegionId() {
		return ioRegionId;
	}

	public long getIoId() {
		return ioId;
	}

	public long getIoCurrencyId() {
		return ioCurrencyId;
	}

	public long getPricingType() {
		return pricingType;
	}

	public String getAdvertiserName() {
		return advertiserName;
	}

	public String getIoName() {
		return ioName;
	}

	public String getLiName() {
		return liName;
	}

	public String getLiBudget() {
		return liBudget;
	}

	public long getStartTime() {
		return startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setLiId(long advertiserLiId) {
		this.liId = advertiserLiId;
	}

	public void setLicenseeId(long licenceeId) {
		this.licenseeId = licenceeId;
	}

	public void setAdvertiserId(long advertiserId) {
		this.advertiserId = advertiserId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	public void setIoRegionId(long ioRegionId) {
		this.ioRegionId = ioRegionId;
	}

	public void setIoId(long ioId) {
		this.ioId = ioId;
	}

	public void setIoCurrencyId(long ioCurrencyId) {
		this.ioCurrencyId = ioCurrencyId;
	}

	public void setPricingType(long pricingType) {
		this.pricingType = pricingType;
	}

	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}

	public void setIoName(String ioName) {
		this.ioName = ioName;
	}

	public void setLiName(String liName) {
		this.liName = liName;
	}

	public void setLiBudget(String liBudget) {
		this.liBudget = liBudget;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Advertiser [advertiserLiId=" + liId + ", licenceeId="
				+ licenseeId + ", advertiserId=" + advertiserId
				+ ", currencyId=" + currencyId + ", ioRegionId=" + ioRegionId
				+ ", ioId=" + ioId + ", ioCurrencyId=" + ioCurrencyId
				+ ", pricingType=" + pricingType + ", advertiserName="
				+ advertiserName + ", ioName=" + ioName + ", liName=" + liName
				+ ", liBudget=" + liBudget + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
}
