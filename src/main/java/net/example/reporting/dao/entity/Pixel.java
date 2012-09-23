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
@Table(name = "pixel")
public class Pixel implements BaseEntity {
	@Id
	@Column(name = "px_id", nullable = false)
	Long pxId;

	@Column(name = "times_fired", nullable = true)
	long timesFired;

	@Column(name = "max_time", nullable = true)
	long maxTime;

	@Column(name = "pxcount", nullable = true)
	long pxcount;

	@Column(name = "type", nullable = true)
	long type = 0;

	@Column(name = "is_piggyback", nullable = true)
	String isPiggyback;

	public Long getPxId() {
		return pxId;
	}

	public long getTimesFired() {
		return timesFired;
	}

	public long getMaxTime() {
		return maxTime;
	}

	public long getPxCount() {
		return pxcount;
	}

	public long getType() {
		return type;
	}

	public String getIsPiggyback() {
		return isPiggyback;
	}

	public void setPxId(Long pxId) {
		this.pxId = pxId;
	}

	public void setTimesFired(long timesFired) {
		this.timesFired = timesFired;
	}

	public void setMaxTime(long maxTime) {
		this.maxTime = maxTime;
	}

	public void setPxCount(long count) {
		this.pxcount = count;
	}

	public void setType(long type) {
		this.type = type;
	}

	public void setIsPiggyback(String isPiggyback) {
		this.isPiggyback = isPiggyback;
	}

	@Override
	public String toString() {
		return "Pixel [timesFired=" + timesFired + ", maxTime=" + maxTime
				+ ", count=" + pxcount + ", type=" + type + ", isPiggyback="
				+ isPiggyback + "]";
	}
}
