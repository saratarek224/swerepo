package web.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import web.app.controllers.StudentController;
import web.app.controllers.TeacherController;
import web.app.entities.Course;
import web.app.entities.GNotification;
import web.app.entities.Game;
import web.app.repositories.GNRepository;

public class GNotificationServer implements GNotificationService{

	
	private GNRepository nrepositry;
	Course course=new Course();
	ArrayList <String> addn=new ArrayList<String>();
	CourseService cs;
	@Autowired
	public void SetGNotification(GNRepository nr){
		nrepositry=nr;
	}
	@Override
	public void save(GNotification n) {
		nrepositry.save(n);
		
	}

	@Override
	public void delete(GNotification n) {
		nrepositry.delete(n);
		
	}

	@Override
	public ArrayList<String> findNotification(String Sname) {
		ArrayList<GNotification> g = new ArrayList<GNotification>();
		ArrayList<GNotification> g1 = new ArrayList<GNotification>();
		ArrayList <String> ng=new ArrayList<String>();
		g1=(ArrayList<GNotification>) nrepositry.findAll();
		for(int i=0;i<g1.size();i++){
			if(g1.get(i).getSname().equals(StudentController.student1.getEmail())||(g1.get(i).getSname().equals(StudentController.student1.getEmail()))){
				g1.add(g.get(i));
				ng.add(g1.get(i).getNotification());
			}
		}
		return ng ;
	}

	@Override
	public ArrayList<String> findCourse(String Sname) {
		ArrayList<GNotification> g = new ArrayList<GNotification>();
		ArrayList<GNotification> g1 = new ArrayList<GNotification>();
		ArrayList <String> ng=new ArrayList<String>();
		g1=(ArrayList<GNotification>) nrepositry.findAll();
		for(int i=0;i<g1.size();i++){
			if(g1.get(i).getSname().equals(StudentController.student1.getEmail())||(g1.get(i).getSname().equals(StudentController.student1.getEmail()))){
				g1.add(g.get(i));
				ng.add(g1.get(i).getCname());
			}
		}
		return ng ;
	}
	

}
