package web.app.notification.system;
import java.util.ArrayList;

import web.app.entities.Student;

public interface GameNotification {
	void subscribe(Student student,String CourseName);
	void unsubscribe(Student student,String CourseName);
	void SetObservers(ArrayList<Student>observers);
	void SetNotifivcation(String notification );
	void Notify();
	

}
