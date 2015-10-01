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
@Table(name = "t_address", catalog = "ncshops")
public class TAddress implements java.io.Serializable {

	// Fields

	private Integer addressId;
	private TUser TUser;
	private String adsContent;
	private String adsPhone;

	// Constructors

	/** default constructor */
	public TAddress() {
	}

	/** minimal constructor */
	public TAddress(Integer addressId) {
		this.addressId = addressId;
	}

	/** full constructor */
	public TAddress(Integer addressId, TUser TUser, String adsContent,
			String adsPhone) {
		this.addressId = addressId;
		this.TUser = TUser;
		this.adsContent = adsContent;
		this.adsPhone = adsPhone;
	}

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
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

}