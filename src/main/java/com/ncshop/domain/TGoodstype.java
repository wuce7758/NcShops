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
@Table(name = "t_goodstype", catalog = "ncshop")
public class TGoodstype implements java.io.Serializable {

	// Fields

	private Integer goodsTypeId;
	private String goodsTypeName;

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

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TGoodstype")
//	public Set<TGoods> getTGoodses() {
//		return this.TGoodses;
//	}
//
//	public void setTGoodses(Set<TGoods> TGoodses) {
//		this.TGoodses = TGoodses;
//	}

}