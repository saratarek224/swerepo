package web.app.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.stereotype.Service;

import web.app.entities.Course;
import web.app.entities.Game;
import web.app.entities.Question;
import web.app.repositories.*;

@Service
public class CourseServer implements CourseService{

	CourseRepository courserep;
	GameRepository gamerepo;
	
	@Autowired
	public void SeTCourseRepository(CourseRepository cr)
	{
		courserep=cr;
		
	}
	@Autowired
	public void Setgamerepositry(GameRepository gr)
	{
		gamerepo=gr;
		
	}


	@Override
	public Course CreatCourse(Course course) {
		
		return  courserep.save(course);
	}


	@Override
	public ArrayList<Course> FindAllCourses() {
		
		return (ArrayList<Course>) courserep.findAll();
	}


	@Override
	public ArrayList<Game> FindGames(String CourseName) {
		
		ArrayList<Game> g = new ArrayList<Game>();
		ArrayList<Game> g1 = new ArrayList<Game>();

		g=(ArrayList<Game>) gamerepo.findAll();
		for(int i=0;i<g.size();i++)
		{
			if(g.get(i).getSecondaryId().equals(CourseName))
			{
				g1.add(g.get(i));
			}
		}
	
		return g1;
	}


	@Override
	public String AddGame(String CourseName, Game game) {
		Course course=new Course();
		course=find(CourseName);
		ArrayList<Game> games=new ArrayList(); 
		//games=course.getGames();
		games.add(game);
	    course.setGames(games);
		   //courserep.delete(course.getId());
		if(courserep.save(course)!=null)
			{
			return "Your New Game is added succesfully ! :)";

			}
		
			return "You New Game isn't added, please try again";
		
	}


	@Override
	public boolean exists(String CourseName) {
		if(find(CourseName)!=null)
			return true;
		else
			return false;
					
			
	}


	@Override
	public Course find(String CourseName) {
		Course course=new Course();
		ArrayList<Course>courses=new ArrayList<Course>();
		courses=(ArrayList<Course>) courserep.findAll();
		for(int i=0;i<courses.size();i++)
			{
			if(courses.get(i).getName().equals(CourseName))
			
			{
				course=courses.get(i);
				return course;
			}
			}
	        return null ;
	}
  
		

}
