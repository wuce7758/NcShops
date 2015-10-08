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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user", catalog = "ncshop")
public class TUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String openId;
	private String userName;
	private String telNumber;
	private String email;
	private String sex;
	private boolean isAttention=true;
	private boolean userState=true;
	private Set<TAddress> TAddresses = new HashSet<TAddress>(0);
	private Set<TOrder> TOrders = new HashSet<TOrder>(0);
	private Set<TComment> TComments = new HashSet<TComment>(0);

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
	public boolean getIsAttention() {
		return this.isAttention;
	}

	public void setIsAttention(boolean isAttention) {
		this.isAttention = isAttention;
	}
	
	@Column(name = "userState")
	public boolean getUserState() {
		return userState;
	}

	public void setUserState(boolean userState) {
		this.userState = userState;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	public Set<TAddress> getTAddresses() {
		return this.TAddresses;
	}

	public void setTAddresses(Set<TAddress> TAddresses) {
		this.TAddresses = TAddresses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	public Set<TOrder> getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set<TOrder> TOrders) {
		this.TOrders = TOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	public Set<TComment> getTComments() {
		return this.TComments;
	}

	public void setTComments(Set<TComment> TComments) {
		this.TComments = TComments;
	}

}
