package web.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.app.entities.Student;
import web.app.services.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentservice;
	public static Student student1;
	@Autowired
	public void  SetStudentService(StudentService ss)
	{
		studentservice=ss;
		
	}
	@RequestMapping(value="student/signup",method=RequestMethod.GET)
	public ModelAndView ShowSignUpPage()
	{
		 ModelAndView mv=new ModelAndView();
		    mv.setViewName("studentsignuppage");
			mv.addObject("student",new Student());
			return mv;
	}
	@RequestMapping(value="/student/signin" ,method=RequestMethod.GET)
	public ModelAndView ShowloginPage()
	{
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("studentsigninpage");
		mv.addObject("student",new Student());
		return mv;
	}
   @RequestMapping(value ="/student/save",method=RequestMethod.GET)
  public ModelAndView SaveStudent(@ModelAttribute Student student)
  {

	   String message=studentservice.SaveStudent(student);	   
	   ModelAndView mv=new ModelAndView();
	    mv.setViewName("signedup");
		mv.addObject("message", message);
		return mv;
  
	
  }
   @RequestMapping(value="/student/homepage",method=RequestMethod.GET  )
   public ModelAndView ShowhomePage(@ModelAttribute Student student)
   {
	   
		   ModelAndView mv=new ModelAndView();
		   if(studentservice.verfiy(student))
		   {  
               student1=student;
			   mv.setViewName("studenthomepage");
			   student=studentservice.GetStudentById(student.getEmail());
			   mv.addObject("student",student );
			   
		   }
		   else if(studentservice.exists(student.getEmail()))
		   {
			  String massage="Incorrect password";
			  mv.setViewName("reply");
			  mv.addObject("message", massage);
			  
		  }
		  else
		  {
			  String massage="This email have no account";
			  mv.setViewName("reply");
			  mv.addObject("message", massage);
		  }
		   return mv;
	  
	  
   }
   @RequestMapping(value="/alls" , method=RequestMethod.GET)
	public long all()
	{
		return studentservice.count();
	}
  
}