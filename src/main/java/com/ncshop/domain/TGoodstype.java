package com.ncshop.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TGoodstype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_goodstype", catalog = "ncshop")
public class TGoodstype implements java.io.Serializable {

	// Fields

	private Integer goodsTypeId;
	private String goodsTypeName;
	private String goodsTypeImg;
	private Date goodsTypeTime=new Date();
	private boolean isValid=true;

	// Property accessors
	@Id
	@Column(name = "goodsTypeId", unique = true, nullable = false)
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	public Integer getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	@Column(name = "goodsTypeName", nullable = false, length = 20)
	public String getGoodsTypeName() {
		return this.goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	
	@Column(name = "goodsTypeImg", nullable = false, length = 50)
	public String getGoodsTypeImg() {
		return goodsTypeImg;
	}

	public void setGoodsTypeImg(String goodsTypeImg) {
		this.goodsTypeImg = goodsTypeImg;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "goodsTypeTime", length = 10)
	public Date getGoodsTypeTime() {
		return goodsTypeTime;
	}

	public void setGoodsTypeTime(Date goodsTypeTime) {
		this.goodsTypeTime = goodsTypeTime;
	}
	
	@Column(name="isValid")
	public boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
}
