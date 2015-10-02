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
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user", catalog = "ncshops")
public class TUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String openId;
	private String userName;
	private String telNumber;
	private String email;
	private String sex;
	private Boolean isAttention=true;
	private Set<TAddress> TAddresses = new HashSet<TAddress>(0);
	private Set<TOrder> TOrders = new HashSet<TOrder>(0);
	private Set<TComment> TComments = new HashSet<TComment>(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public TUser(Integer userId, String openId, String userName,
			String telNumber, String email, String sex, Boolean isAttention,
			Set<TAddress> TAddresses, Set<TOrder> TOrders,
			Set<TComment> TComments) {
		this.userId = userId;
		this.openId = openId;
		this.userName = userName;
		this.telNumber = telNumber;
		this.email = email;
		this.sex = sex;
		this.isAttention = isAttention;
		this.TAddresses = TAddresses;
		this.TOrders = TOrders;
		this.TComments = TComments;
	}

	// Property accessors
	@Id
	@Column(name = "userId", unique = true, nullable = false)
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "OpenID", length = 50)
	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Column(name = "userName", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "telNumber", length = 11)
	public String getTelNumber() {
		return this.telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	@Column(name = "email", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "sex", length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "isAttention")
	public Boolean getIsAttention() {
		return this.isAttention;
	}

	public void setIsAttention(Boolean isAttention) {
		this.isAttention = isAttention;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TAddress> getTAddresses() {
		return this.TAddresses;
	}

	public void setTAddresses(Set<TAddress> TAddresses) {
		this.TAddresses = TAddresses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TOrder> getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set<TOrder> TOrders) {
		this.TOrders = TOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TComment> getTComments() {
		return this.TComments;
	}

	public void setTComments(Set<TComment> TComments) {
		this.TComments = TComments;
	}

}