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
 * TSeller entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_seller", catalog = "ncshops")
public class TSeller implements java.io.Serializable {

	// Fields

	private Integer sellerId;
	private String shopName;
	private String sellerName;
	private String sellerAddress;
	private String sellerPhone;
	private Date joinTime;
	private Integer joinDeadline;
	private Integer isValid;
	private Integer minBuy;
	private Float deliverMoney;
	private String sellerMsg;
	private Set<TSellergoods> TSellergoodses = new HashSet<TSellergoods>(0);
	private Set<TOrder> TOrders = new HashSet<TOrder>(0);

	// Constructors

	/** default constructor */
	public TSeller() {
	}

	/** minimal constructor */
	public TSeller(Integer sellerId) {
		this.sellerId = sellerId;
	}

	/** full constructor */
	public TSeller(Integer sellerId, String shopName, String sellerName,
			String sellerAddress, String sellerPhone, Date joinTime,
			Integer joinDeadline, Integer isValid, Integer minBuy,
			Float deliverMoney, String sellerMsg,
			Set<TSellergoods> TSellergoodses, Set<TOrder> TOrders) {
		this.sellerId = sellerId;
		this.shopName = shopName;
		this.sellerName = sellerName;
		this.sellerAddress = sellerAddress;
		this.sellerPhone = sellerPhone;
		this.joinTime = joinTime;
		this.joinDeadline = joinDeadline;
		this.isValid = isValid;
		this.minBuy = minBuy;
		this.deliverMoney = deliverMoney;
		this.sellerMsg = sellerMsg;
		this.TSellergoodses = TSellergoodses;
		this.TOrders = TOrders;
	}

	// Property accessors
	@Id
	@Column(name = "sellerId", unique = true, nullable = false)
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	@Column(name = "shopName", length = 50)
	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Column(name = "sellerName", length = 20)
	public String getSellerName() {
		return this.sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	@Column(name = "sellerAddress", length = 100)
	public String getSellerAddress() {
		return this.sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	@Column(name = "sellerPhone", length = 11)
	public String getSellerPhone() {
		return this.sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "joinTime", length = 10)
	public Date getJoinTime() {
		return this.joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	@Column(name = "joinDeadline")
	public Integer getJoinDeadline() {
		return this.joinDeadline;
	}

	public void setJoinDeadline(Integer joinDeadline) {
		this.joinDeadline = joinDeadline;
	}

	@Column(name = "isValid")
	public Integer getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	@Column(name = "minBuy")
	public Integer getMinBuy() {
		return this.minBuy;
	}

	public void setMinBuy(Integer minBuy) {
		this.minBuy = minBuy;
	}

	@Column(name = "deliverMoney", precision = 12, scale = 0)
	public Float getDeliverMoney() {
		return this.deliverMoney;
	}

	public void setDeliverMoney(Float deliverMoney) {
		this.deliverMoney = deliverMoney;
	}

	@Column(name = "sellerMsg", length = 100)
	public String getSellerMsg() {
		return this.sellerMsg;
	}

	public void setSellerMsg(String sellerMsg) {
		this.sellerMsg = sellerMsg;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSeller")
	public Set<TSellergoods> getTSellergoodses() {
		return this.TSellergoodses;
	}

	public void setTSellergoodses(Set<TSellergoods> TSellergoodses) {
		this.TSellergoodses = TSellergoodses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSeller")
	public Set<TOrder> getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set<TOrder> TOrders) {
		this.TOrders = TOrders;
	}

}