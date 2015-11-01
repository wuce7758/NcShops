package com.ncshop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_ads", catalog = "ncshop")
public class TAds implements java.io.Serializable {
	private int adsId;
	private String adsName;
	private String adsPic;
	private Date adsTime=new Date();
	private boolean isValid=true;
	
	@Id
	@Column(name = "adsId", unique = true, nullable = false)
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	public int getAdsId() {
		return adsId;
	}
	public void setAdsId(int adsId) {
		this.adsId = adsId;
	}
	
	@Column(name = "adsName", length = 50)
	public String getAdsName() {
		return adsName;
	}
	public void setAdsName(String adsName) {
		this.adsName = adsName;
	}
	
	@Column(name = "adsPic", length = 50)
	public String getAdsPic() {
		return adsPic;
	}
	public void setAdsPic(String adsPic) {
		this.adsPic = adsPic;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "adsTime", length = 10)
	public Date getAdsTime() {
		return adsTime;
	}
	public void setAdsTime(Date adsTime) {
		this.adsTime = adsTime;
	}
	@Column(name = "isValid")
	public boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
}
