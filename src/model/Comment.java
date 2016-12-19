package model;

import java.time.LocalDate;

public class Comment {
	int commmentId;
	int userId;
	String comment;
	LocalDate dateCreated;
	LocalDate dateUpdate;
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
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDate getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(LocalDate dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

}
