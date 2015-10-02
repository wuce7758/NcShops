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
 * TOrderdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_orderdetail", catalog = "ncshops")
public class TOrderdetail implements java.io.Serializable {

	// Fields

	private Integer detailId;
	private TGoods TGoods;
	private TOrder TOrder;
	private Integer buyMount=1;
	private Double buyCost=0.0;
	private Set<TComment> TComments = new HashSet<TComment>(0);

	// Constructors

	/** default constructor */
	public TOrderdetail() {
	}

	/** minimal constructor */
	public TOrderdetail(Integer detailId) {
		this.detailId = detailId;
	}

	/** full constructor */
	public TOrderdetail(Integer detailId, TGoods TGoods, TOrder TOrder,
			Integer buyMount, Double buyCost, Set<TComment> TComments) {
		this.detailId = detailId;
		this.TGoods = TGoods;
		this.TOrder = TOrder;
		this.buyMount = buyMount;
		this.buyCost = buyCost;
		this.TComments = TComments;
	}

	// Property accessors
	@Id
	@Column(name = "detailId", unique = true, nullable = false)
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	public Integer getDetailId() {
		return this.detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
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
	@JoinColumn(name = "orderId")
	public TOrder getTOrder() {
		return this.TOrder;
	}

	public void setTOrder(TOrder TOrder) {
		this.TOrder = TOrder;
	}

	@Column(name = "buyMount")
	public Integer getBuyMount() {
		return this.buyMount;
	}

	public void setBuyMount(Integer buyMount) {
		this.buyMount = buyMount;
	}

	@Column(name = "buyCost", precision = 22, scale = 0)
	public Double getBuyCost() {
		return this.buyCost;
	}

	public void setBuyCost(Double buyCost) {
		this.buyCost = buyCost;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TOrderdetail")
	public Set<TComment> getTComments() {
		return this.TComments;
	}

	public void setTComments(Set<TComment> TComments) {
		this.TComments = TComments;
	}

}