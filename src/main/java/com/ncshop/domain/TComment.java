package com.ncshop.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_comment", catalog = "ncshops")
public class TComment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private TOrderdetail TOrderdetail;
	private TUser TUser;
	private Integer credit;
	private String commentMsg;
	private Date commentTime;

	// Constructors

	/** default constructor */
	public TComment() {
	}

	/** minimal constructor */
	public TComment(Integer commentId) {
		this.commentId = commentId;
	}

	/** full constructor */
	public TComment(Integer commentId, TOrderdetail TOrderdetail, TUser TUser,
			Integer credit, String commentMsg, Date commentTime) {
		this.commentId = commentId;
		this.TOrderdetail = TOrderdetail;
		this.TUser = TUser;
		this.credit = credit;
		this.commentMsg = commentMsg;
		this.commentTime = commentTime;
	}

	// Property accessors
	@Id
	@Column(name = "commentId", unique = true, nullable = false)
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "detailId")
	public TOrderdetail getTOrderdetail() {
		return this.TOrderdetail;
	}

	public void setTOrderdetail(TOrderdetail TOrderdetail) {
		this.TOrderdetail = TOrderdetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@Column(name = "credit")
	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Column(name = "commentMsg", length = 100)
	public String getCommentMsg() {
		return this.commentMsg;
	}

	public void setCommentMsg(String commentMsg) {
		this.commentMsg = commentMsg;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "commentTime", length = 10)
	public Date getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

}