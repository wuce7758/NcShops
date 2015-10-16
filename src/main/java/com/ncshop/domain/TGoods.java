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
@Table(name = "t_goods", catalog = "ncshop")
public class TGoods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private TGoodstype TGoodstype;
	private String goodsName;
	private Double goodsPrice=0.0;
	private String goodsMsg;
	private String goodsPic;

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

	@ManyToOne(fetch = FetchType.EAGER)
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

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TGoods")
//	public Set<TOrderdetail> getTOrderdetails() {
//		return this.TOrderdetails;
//	}
//
//	public void setTOrderdetails(Set<TOrderdetail> TOrderdetails) {
//		this.TOrderdetails = TOrderdetails;
//	}
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TGoods")
//	public Set<TSellergoods> getTSellergoodses() {
//		return this.TSellergoodses;
//	}
//
//	public void setTSellergoodses(Set<TSellergoods> TSellergoodses) {
//		this.TSellergoodses = TSellergoodses;
//	}
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TGoods")
//	public Set<TOrder> getTOrders() {
//		return this.TOrders;
//	}
//
//	public void setTOrders(Set<TOrder> TOrders) {
//		this.TOrders = TOrders;
//	}

}
