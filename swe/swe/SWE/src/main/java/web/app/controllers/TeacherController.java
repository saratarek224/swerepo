package web.app.controllers;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.app.entities.Teacher;
import web.app.entities.CNotification;

import web.app.services.CNotificationService;
import web.app.services.TeacherService;
@Controller
public class TeacherController {
	private TeacherService teacherservice;
	private CNotificationService notifyservice;
    ArrayList<CNotification> notifications = new ArrayList<CNotification>();
	public static Teacher teacher1;
	@Autowired
	public void  SetTeacherService(TeacherService ts)
	{
		teacherservice=ts;
		
	}
	 @Autowired
		public void  SetNotifyService(CNotificationService ns)
		{
		 notifyservice=ns;	
		}
	@RequestMapping(value="/teacher/signin" ,method=RequestMethod.GET)
	public ModelAndView ShowloginPage()
	{
		    ModelAndView mv=new ModelAndView();
		    mv.setViewName("teachersigninpage");
			mv.addObject("teacher",new Teacher());
			return mv;

	}

	@RequestMapping(value="teacher/signup",method=RequestMethod.GET)
	public ModelAndView ShowSignUpPage()
	{
		 ModelAndView mv=new ModelAndView();
		    mv.setViewName("teachersignuppage");
			mv.addObject("teacher",new Teacher());
			return mv;
	}
	  @RequestMapping(value ="/teacher/save",method=RequestMethod.GET)
	  public ModelAndView SaveTeacher(@ModelAttribute Teacher teacher)
	  {

		   String message=teacherservice.SaveTeacher(teacher);	   
		   ModelAndView mv=new ModelAndView();
		    mv.setViewName("reply");
			mv.addObject("message", message);
			return mv;
	  
		
	  }
	@RequestMapping(value="/teacher/homepage" ,method=RequestMethod.GET )
	   public ModelAndView ShowhomePage(@ModelAttribute Teacher teacher)
	   {
		   
			   ModelAndView mv=new ModelAndView();
			 if(teacherservice.verfiy(teacher))
			   {
				   teacher1=teacher;
				   mv.setViewName("teacherhomepage");
				   teacher=teacherservice.GetTeacherById(teacher.getEmail());
				   mv.addObject("teacher",teacher);
				   
			   }
			  else if(teacherservice.exists(teacher.getEmail()))
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
			   //mv.setViewName("teacherhomepage");
			   //mv.addObject("teacher",teacher);
			   return mv;
		  
		  
	   }
	@RequestMapping(value="/teacher/Shownotification",method=RequestMethod.GET)
	public ModelAndView ShowNotification()
	{
		
		notifications=notifyservice.all(teacher1.getEmail());
		for(int i=0;i<notifications.size();i++)
		{
			System.out.println(notifications.get(i).getCname());
		}
		System.out.println("helloooooo"+notifications.size());

		    ModelAndView mv=new ModelAndView();
		    mv.setViewName("Notificationpage");
			mv.addObject("notifications",notifications);
			return mv;
	}
	@RequestMapping(value="/all" , method=RequestMethod.GET)
	public long all()
	{
		return teacherservice.count();
	}
		
}