package com.ncshop.domain;

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

/**
 * TGoodstype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_goodstype", catalog = "ncshops")
public class TGoodstype implements java.io.Serializable {

	// Fields

	private Integer goodsTypeId;
	private String goodsTypeName;
	private Set<TGoods> TGoodses = new HashSet<TGoods>(0);

	// Constructors

	/** default constructor */
	public TGoodstype() {
	}

	/** minimal constructor */
	public TGoodstype(Integer goodsTypeId, String goodsTypeName) {
		this.goodsTypeId = goodsTypeId;
		this.goodsTypeName = goodsTypeName;
	}

	/** full constructor */
	public TGoodstype(Integer goodsTypeId, String goodsTypeName,
			Set<TGoods> TGoodses) {
		this.goodsTypeId = goodsTypeId;
		this.goodsTypeName = goodsTypeName;
		this.TGoodses = TGoodses;
	}

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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TGoodstype")
	public Set<TGoods> getTGoodses() {
		return this.TGoodses;
	}

	public void setTGoodses(Set<TGoods> TGoodses) {
		this.TGoodses = TGoodses;
	}

}