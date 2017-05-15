package web.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.*;
@Entity
@Table(name="COURSE")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "Course_ID")
	int id;
	
	String name;
	int age;
	String teacher;
	ArrayList <Student> students=new ArrayList<Student>();
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	//@OneToMany(cascade=CascadeType.ALL, mappedBy="id")
	ArrayList <Game> games=new ArrayList<Game>();
	public String getteacher() {
		return teacher;
	}
	public void setCreatedby(String teacher) {
		this.teacher = teacher;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Game> getGames() {
		return games;
	}
	public void setGames(ArrayList<Game> games) {
		this.games = games;
		
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
		
	public void AddGame(Game game){
		games.add(game);
	}
	
}