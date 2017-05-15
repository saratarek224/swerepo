/*package web.app.notification.system;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.app.controllers.StudentController;
import web.app.entities.Course;
import web.app.entities.GNotification;
import web.app.entities.Student;
import web.app.notification.system.GameNotification;
import web.app.repositories.CourseRepository;
import web.app.repositories.GNRepository;
import web.app.repositories.StudentRepository;
import web.app.services.CourseService;
import web.app.services.GNotificationService;
import web.app.services.StudentService;


@Service
public class NewGameNotification implements GameNotification {
	CourseService courseservice;
	StudentRepository studentrepository;
	String notification;
    ArrayList<Student>observers=new ArrayList<Student>();
    ArrayList<String> Notification=new ArrayList<String>();
    ArrayList<String> Course=new ArrayList<String>();
	GNotification notify=new GNotification();
	ArrayList<GNotification> n=new ArrayList<GNotification>();
	GNRepository nrepo;
	GNotificationService nservice;
	
	@Autowired
	public void SetCourseSevice (CourseService cs)
	{
		courseservice=cs;
	}
	@Autowired
	public void SetStudentRepository (StudentRepository sr)
	{
		studentrepository=sr;
	}

	@Override
	public void subscribe(Student student, String CourseName) {
		Course course=new Course();
		Course=nservice.findCourse(student.getEmail());
		course=courseservice.find(CourseName);
		if( course.getStudents().indexOf(student)==-1)
		{
		course.getStudents().add(student);
		courseservice.CreatCourse(course);
		}
		
	}

	@Override
	public void unsubscribe(Student student, String CourseName) {
		Course course=new Course();
		course=courseservice.find(CourseName);
		course.getStudents().remove(student);
		courseservice.CreatCourse(course);
		
	}
	@Override
	public void SetObservers(ArrayList<Student> observers) {
		this.observers=observers;
		
	}
	@Override
	public void SetNotifivcation(String notification) {
		this.notification=notification;
		Notify();
		
	}
	@Override
	public void Notify() {
		for(int i=0;i<nservice.findNotification(StudentController.student.getEmail()).size();i++)
		{
			
			Notification.add(notification);
			
		}
		
	}

	

}
*/