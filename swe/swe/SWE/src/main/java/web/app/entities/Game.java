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

import web.app.controllers.TeacherController;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="GAME_ID")
	int id;
	//@ManyToOne
   // @JoinColumn(name="name", nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String name;
	//@OneToMany(cascade=CascadeType.ALL, mappedBy="id")
	ArrayList<Question>questions = new ArrayList<Question>();
	float score;
	String SecondaryId;      //the name of the course that the game exists in
	String description;
	String teachername;
	String cteacher;
	
	
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername=teachername;
	}
	public String getCteacher() {
		return cteacher;
	}
	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Game(){
		questions=null;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getSecondaryId() {
		return SecondaryId;
	}
	public void setSecondaryId(String secondaryId) {
		SecondaryId = secondaryId;
	}
	
	

}