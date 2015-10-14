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
@Table(name = "t_sellergoods", catalog = "ncshop")
public class TSellergoods implements java.io.Serializable {

	// Fields

	private Integer sellerGoodsId;
	private TGoods TGoods;
	private TSeller seller;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sellerId")
	public TSeller getSeller() {
		return seller;
	}

	public void setSeller(TSeller seller) {
		this.seller = seller;
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
