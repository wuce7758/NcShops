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
@Table(name = "t_orderdetail", catalog = "ncshop")
public class TOrderdetail implements java.io.Serializable {

	// Fields

	private Integer detailId;
	private TGoods TGoods;
	private Integer orderId;
	private Integer buyMount=1;
	private Double buyCost=0.0;
	private Set<TComment> TComments = new HashSet<TComment>(0);

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "goodsId")
	public TGoods getTGoods() {
		return this.TGoods;
	}

	public void setTGoods(TGoods TGoods) {
		this.TGoods = TGoods;
	}


	@Column(name = "orderId", length = 11)
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="detailId")
	public Set<TComment> getTComments() {
		return this.TComments;
	}

	public void setTComments(Set<TComment> TComments) {
		this.TComments = TComments;
	}

}
