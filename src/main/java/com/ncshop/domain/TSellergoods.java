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
 * TSellergoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_sellergoods", catalog = "ncshops")
public class TSellergoods implements java.io.Serializable {

	// Fields

	private Integer sellerGoodsId;
	private TGoods TGoods;
	private TSeller TSeller;
	private Integer goodsInventory=0;
	private Integer goodsSales=0;
	private boolean isSale=true;

	// Constructors

	/** default constructor */
	public TSellergoods() {
	}

	/** minimal constructor */
	public TSellergoods(Integer sellerGoodsId) {
		this.sellerGoodsId = sellerGoodsId;
	}

	/** full constructor */
	public TSellergoods(Integer sellerGoodsId, TGoods TGoods, TSeller TSeller,
			Integer goodsInventory, Integer goodsSales, boolean isSale) {
		this.sellerGoodsId = sellerGoodsId;
		this.TGoods = TGoods;
		this.TSeller = TSeller;
		this.goodsInventory = goodsInventory;
		this.goodsSales = goodsSales;
		this.isSale = isSale;
	}

	// Property accessors
	@Id
	@Column(name = "sellerGoodsId", unique = true, nullable = false)
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	public Integer getSellerGoodsId() {
		return this.sellerGoodsId;
	}

	public void setSellerGoodsId(Integer sellerGoodsId) {
		this.sellerGoodsId = sellerGoodsId;
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
	@JoinColumn(name = "sellerId")
	public TSeller getTSeller() {
		return this.TSeller;
	}

	public void setTSeller(TSeller TSeller) {
		this.TSeller = TSeller;
	}

	@Column(name = "goodsInventory")
	public Integer getGoodsInventory() {
		return this.goodsInventory;
	}

	public void setGoodsInventory(Integer goodsInventory) {
		this.goodsInventory = goodsInventory;
	}

	@Column(name = "goodsSales")
	public Integer getGoodsSales() {
		return this.goodsSales;
	}

	public void setGoodsSales(Integer goodsSales) {
		this.goodsSales = goodsSales;
	}

	@Column(name = "isSale")
	public boolean getIsSale() {
		return this.isSale;
	}

	public void setIsSale(boolean isSale) {
		this.isSale = isSale;
	}

}