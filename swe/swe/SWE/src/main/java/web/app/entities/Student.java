package web.app.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="STUDENT")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
    String email;
	String name;
	String country;
	String organizatio;
	String password;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOrganizatio() {
		return organizatio;
	}
	public void setOrganizatio(String organizatio) {
		this.organizatio = organizatio;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
private ArrayList<Achievement> achievements;
	
	public Student() {
		achievements=new ArrayList<Achievement>();
	}
	public ArrayList<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(ArrayList<Achievement> achievements) {
		this.achievements = achievements;
	}
	
}
  
