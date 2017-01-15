package model;

import java.time.LocalDate;
import java.util.Date;

public class Comment {
	int commmentId;
	int userId;
	String comment;
	int postId;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	Date dateCreated;
	Date dateUpdate;
	public int getCommmentId() {
		return commmentId;
	}
	public void setCommmentId(int commmentId) {
		this.commmentId = commmentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

}
