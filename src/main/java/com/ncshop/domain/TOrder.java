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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_order", catalog = "ncshops")
public class TOrder implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private TGoods TGoods;
	private TUser TUser;
	private TSeller TSeller;
	private String orderNo;
	private Date orderTime=new Date();
	private Double orderTotalCost=0.0;
	private String orderMsg;
	private Integer orderState=0;//默认0：已生成；1:已支付
	private Set<TOrderdetail> TOrderdetails = new HashSet<TOrderdetail>(0);

	// Constructors

	/** default constructor */
	public TOrder() {
	}

	/** minimal constructor */
	public TOrder(Integer orderId) {
		this.orderId = orderId;
	}

	/** full constructor */
	public TOrder(Integer orderId, TGoods TGoods, TUser TUser, TSeller TSeller,
			String orderNo, Date orderTime, Double orderTotalCost,
			String orderMsg, Integer orderState, Set<TOrderdetail> TOrderdetails) {
		this.orderId = orderId;
		this.TGoods = TGoods;
		this.TUser = TUser;
		this.TSeller = TSeller;
		this.orderNo = orderNo;
		this.orderTime = orderTime;
		this.orderTotalCost = orderTotalCost;
		this.orderMsg = orderMsg;
		this.orderState = orderState;
		this.TOrderdetails = TOrderdetails;
	}

	// Property accessors
	@Id
	@Column(name = "orderId", unique = true, nullable = false)
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goodsId")
	public TGoods getTGoods() {
		return this.TGoods;
	}

	public void setTGoods(TGoods TGoods) {
		this.TGoods = TGoods;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sellerId")
	public TSeller getTSeller() {
		return this.TSeller;
	}

	public void setTSeller(TSeller TSeller) {
		this.TSeller = TSeller;
	}

	@Column(name = "orderNo", length = 8)
	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "orderTime", length = 10)
	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	@Column(name = "orderTotalCost", precision = 22, scale = 0)
	public Double getOrderTotalCost() {
		return this.orderTotalCost;
	}

	public void setOrderTotalCost(Double orderTotalCost) {
		this.orderTotalCost = orderTotalCost;
	}

	@Column(name = "orderMsg", length = 100)
	public String getOrderMsg() {
		return this.orderMsg;
	}

	public void setOrderMsg(String orderMsg) {
		this.orderMsg = orderMsg;
	}

	@Column(name = "orderState")
	public Integer getOrderState() {
		return this.orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TOrder")
	public Set<TOrderdetail> getTOrderdetails() {
		return this.TOrderdetails;
	}

	public void setTOrderdetails(Set<TOrderdetail> TOrderdetails) {
		this.TOrderdetails = TOrderdetails;
	}

}