package web.app.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.app.entities.Course;
import web.app.entities.Game;
import web.app.entities.Student;
import web.app.services.CourseService;

@Controller
public class CourseController {

	private CourseService courseservice;
	@Autowired
	public void  SetCourseService(CourseService cc)
	{
		courseservice=cc;
		
	}
	@RequestMapping(value="/createcourse",method=RequestMethod.GET)
	public ModelAndView SaveCourse()
	  {
		
		   ModelAndView mv=new ModelAndView();
		    mv.setViewName("courseinfo");
			mv.addObject("Course", new Course());
			return mv;
	   }
	@RequestMapping(value="/created",method=RequestMethod.GET)
	public ModelAndView CreateCourse(@ModelAttribute Course course)
	{
		courseservice.CreatCourse(course);
	   ModelAndView mv=new ModelAndView();
	   mv.setViewName("coursecreated");
	  mv.addObject("course",course);
	   return mv; 
	}
	@RequestMapping(value="/showcourses",method=RequestMethod.GET)
	public ModelAndView ShowCourses()
	  {
		 ArrayList<Course> courses=new ArrayList<Course>();
		  courses=courseservice.FindAllCourses();
		    ModelAndView mv=new ModelAndView();
		    mv.setViewName("courses");
			mv.addObject("courses",courses);
			return mv;
	   }
	/*@RequestMapping(value="/showgames",method=RequestMethod.GET)
	public ModelAndView ShowGames(@ModelAttribute Game game)
	  {
		   ArrayList<game>
		   ModelAndView mv=new ModelAndView();
		    mv.setViewName("games");
			mv.addObject("games", new Course());
			return mv;
	   }*/
	
	@RequestMapping(value="/showgames/{name}",method=RequestMethod.GET)
	public ModelAndView ShowGames(@PathVariable String name)
	  {
		ModelAndView mv=new ModelAndView();
		if(StudentController.student1.getEmail() != null){
		ArrayList<Game> games=new ArrayList<Game>();
		   games=courseservice.FindGames(name);
		   
		    mv.setViewName("gamesstudent");
			mv.addObject("games", games);
			//System.out.print(games.size());
			}
		
		else if(TeacherController.teacher1.getEmail() !=null){
			ArrayList<Game> games=new ArrayList<Game>();
			   games=courseservice.FindGames(name);
			    mv.setViewName("games");
				mv.addObject("games", games);
				//System.out.print(games.size(
			
		}
		return mv;
	   }
	
	
}
