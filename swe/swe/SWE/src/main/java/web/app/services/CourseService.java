package web.app.services;

import java.util.ArrayList;
import java.util.Set;

import web.app.entities.Course;
import web.app.entities.Game;

public interface CourseService {

	 Course CreatCourse(Course course);
	 ArrayList<Course>FindAllCourses();
	 Course find(String CourseName);
	 ArrayList<Game> FindGames(String CourseName);
	String AddGame(String CourseName, Game game);
    boolean exists(String CourseName);
    
    
	
}
