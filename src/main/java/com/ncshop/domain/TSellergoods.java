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
	private Integer sellerId;
	private Integer goodsInventory=0;
	private Integer goodsSales=0;
	private boolean isSale=true;

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


	@Column(name = "sellerId", length = 11)
	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
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