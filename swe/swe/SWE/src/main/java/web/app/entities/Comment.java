package web.app.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
   String commentstatment;
   String username;
   String gamename;

public String getCommentstatment() {
	return commentstatment;
}
public void setCommentstatment(String commentstatment) {
	this.commentstatment = commentstatment;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getGamename() {
	return gamename;
}
public void setGamename(String gamename) {
	this.gamename = gamename;
}
  
}
