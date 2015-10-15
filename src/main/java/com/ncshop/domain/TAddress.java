package com.ncshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TAddress entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_address", catalog = "ncshop")
public class TAddress implements java.io.Serializable {

	// Fields

	private Integer addressId;
	private Integer userId;
	private String adsContent;
	private String adsPhone;
	private String receiverName;
	private boolean	isDefault;

	// Property accessors
	@Id
	@Column(name = "addressId", unique = true, nullable = false)
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}


	@Column(name = "userId", length = 11)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "adsContent", length = 100)
	public String getAdsContent() {
		return this.adsContent;
	}

	public void setAdsContent(String adsContent) {
		this.adsContent = adsContent;
	}

	@Column(name = "adsPhone", length = 11)
	public String getAdsPhone() {
		return this.adsPhone;
	}

	public void setAdsPhone(String adsPhone) {
		this.adsPhone = adsPhone;
	}
	@Column(name="receiverName",length=100)
	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	@Column(name="isDefault",length=1)
	public boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	
	

}
