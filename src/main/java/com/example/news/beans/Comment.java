package com.example.news.beans;

public class Comment implements java.io.Serializable {
	// Fields
	private Integer id;
	private String comment;
	private String commentauthor;
	private String commenttime;
	private Integer newsid;
	//private Integer checkstate;
	private String note;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(String comment, String commentauthor, String commenttime,
			Integer newsid, String note) {
		this.comment = comment;
		this.commentauthor = commentauthor;
		this.commenttime = commenttime;
		this.newsid = newsid;
		this.note = note;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentauthor() {
		return this.commentauthor;
	}

	public void setCommentauthor(String commentauthor) {
		this.commentauthor = commentauthor;
	}

	public String getCommenttime() {
		return this.commenttime;
	}

	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}

	public Integer getNewsid() {
		return this.newsid;
	}

	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}