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
import javax.persistence.JoinColumn;
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
	private Date joinTime=new Date();//加盟时间
	private Integer joinDeadline=1;//加盟期限，默认1个月
	private boolean isValid=false;
	private Integer minBuy=0;
	private float deliverMoney=0;
	private String sellerMsg;
	private Set<TSellergoods> TSellergoodses = new HashSet<TSellergoods>(0);
	private Set<TOrder> TOrders = new HashSet<TOrder>(0);

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
	public boolean getIsValid() {
		return this.isValid;
	}

	public void setIsValid(boolean isValid) {
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="sellerId")
	public Set<TSellergoods> getTSellergoodses() {
		return this.TSellergoodses;
	}

	public void setTSellergoodses(Set<TSellergoods> TSellergoodses) {
		this.TSellergoodses = TSellergoodses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="sellerId")
	public Set<TOrder> getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set<TOrder> TOrders) {
		this.TOrders = TOrders;
	}

}