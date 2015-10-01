package com.ncshop.domain;

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

/**
 * TGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_goods", catalog = "ncshops")
public class TGoods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private TGoodstype TGoodstype;
	private String goodsName;
	private Double goodsPrice;
	private String goodsMsg;
	private String goodsPic;
	private Set<TOrderdetail> TOrderdetails = new HashSet<TOrderdetail>(0);
	private Set<TSellergoods> TSellergoodses = new HashSet<TSellergoods>(0);
	private Set<TOrder> TOrders = new HashSet<TOrder>(0);

	// Constructors

	/** default constructor */
	public TGoods() {
	}

	/** minimal constructor */
	public TGoods(Integer goodsId) {
		this.goodsId = goodsId;
	}

	/** full constructor */
	public TGoods(Integer goodsId, TGoodstype TGoodstype, String goodsName,
			Double goodsPrice, String goodsMsg, String goodsPic,
			Set<TOrderdetail> TOrderdetails, Set<TSellergoods> TSellergoodses,
			Set<TOrder> TOrders) {
		this.goodsId = goodsId;
		this.TGoodstype = TGoodstype;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsMsg = goodsMsg;
		this.goodsPic = goodsPic;
		this.TOrderdetails = TOrderdetails;
		this.TSellergoodses = TSellergoodses;
		this.TOrders = TOrders;
	}

	// Property accessors
	@Id
	@Column(name = "goodsId", unique = true, nullable = false)
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goodsTypeId")
	public TGoodstype getTGoodstype() {
		return this.TGoodstype;
	}

	public void setTGoodstype(TGoodstype TGoodstype) {
		this.TGoodstype = TGoodstype;
	}

	@Column(name = "goodsName", length = 50)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "goodsPrice", precision = 22, scale = 0)
	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	@Column(name = "goodsMsg", length = 100)
	public String getGoodsMsg() {
		return this.goodsMsg;
	}

	public void setGoodsMsg(String goodsMsg) {
		this.goodsMsg = goodsMsg;
	}

	@Column(name = "goodsPic", length = 50)
	public String getGoodsPic() {
		return this.goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TGoods")
	public Set<TOrderdetail> getTOrderdetails() {
		return this.TOrderdetails;
	}

	public void setTOrderdetails(Set<TOrderdetail> TOrderdetails) {
		this.TOrderdetails = TOrderdetails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TGoods")
	public Set<TSellergoods> getTSellergoodses() {
		return this.TSellergoodses;
	}

	public void setTSellergoodses(Set<TSellergoods> TSellergoodses) {
		this.TSellergoodses = TSellergoodses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TGoods")
	public Set<TOrder> getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set<TOrder> TOrders) {
		this.TOrders = TOrders;
	}

}