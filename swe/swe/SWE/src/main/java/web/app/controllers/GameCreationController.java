

package web.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import web.app.entities.GNotification;
import web.app.entities.Game;
import web.app.entities.Question;
import web.app.entities.Teacher;
import web.app.services.CourseService;
import web.app.services.GNotificationService;
import web.app.services.GameService;
import web.app.services.QuestionService;

@Controller
public class GameCreationController {
	 
	private Game NewGame;
	private Game game;
	private ArrayList<Question>questions;
	private GameService gameservice;
	private CourseService courseservice;
	private QuestionService questionservice;
    private String teacher;
    public ArrayList<String> studentname=new ArrayList<String>();
    GNotificationService gn;
    GNotification nstudent=new GNotification();
	@Autowired
	public void  SetGameService(GameService gs)
	{
		gameservice=gs;
		
	}
	@Autowired
	public void SetCourseService(CourseService cs)
	{
		courseservice=cs;
	}
	@Autowired
	public void  SetQuestionService(QuestionService qs)
	{
		questionservice=qs;
		
	}
    @RequestMapping(value="/game/create", method=RequestMethod.GET)
    public ModelAndView ShowGameForm()
	{
	  NewGame=new Game(); 
	  questions=new ArrayList();
	  ModelAndView mv=new ModelAndView();
	  mv.setViewName("gameform");
	  mv.addObject("game",new Game());
	  return mv;
		
	}
    
   @RequestMapping(value="/game/info", method=RequestMethod.GET)
   public ModelAndView GetGameInfo(@ModelAttribute Game game)
   {
	   NewGame.setName(game.getName());
	   NewGame.setSecondaryId(game.getSecondaryId());
	   NewGame.setDescription(game.getDescription());
       NewGame.setTeachername(TeacherController.teacher1.getEmail());
	   gameservice.SaveGame(NewGame);
	   ModelAndView mv =new ModelAndView();
	   mv.setViewName("questionform");
	   mv.addObject("question",new Question());
	   return mv;
   }
    @RequestMapping(value="/game/add/question",method=RequestMethod.GET)
	public ModelAndView ShowQuestionForm()
	{
      ModelAndView mv=new ModelAndView();
  	  mv.setViewName("questionform"); 
  	  mv.addObject("question",new Question());
  	  return mv;
		 
	}

    @RequestMapping(value="/game/recieve/question",method=RequestMethod.GET)
	public String AddQuestion(@ModelAttribute Question question)
	{
    	question.setGameName(NewGame.getName());
    	questions.add(question);
    	//System.out.println(question.statement);
        return "options";
		 
	}
    @RequestMapping(value="/game/save",method=RequestMethod.GET)
	public ModelAndView SaveGame()
	{
    	NewGame.setQuestions(questions);
    	//String message =courseservice.AddGame(NewGame.getSecondaryId(), NewGame);
    	//questionservice.SaveQuestion(questions);
    	String message=questionservice.SaveQuestion(questions);
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("reply");
    	mv.addObject("message",message);
    	return mv;
        
		 
	}
    
    @RequestMapping(value="/game/cteacher/{name}", method=RequestMethod.GET)
    public ModelAndView SetCteacher(@PathVariable String name)
    {
 	   game=new Game();
 	   game=gameservice.FindGame(name);
 	   ModelAndView mv =new ModelAndView();
 	   mv.setViewName("cteacher");
 	  mv.addObject("game1", new Game());
 	   return mv;
    }
    
    
    @RequestMapping(value="/game/done", method=RequestMethod.GET)
    public ModelAndView SetCteacher(@ModelAttribute Game game1)
    {
 	   
 	   ModelAndView mv =new ModelAndView();
 	   
 	   game.setCteacher(game1.getCteacher());
 	   String message=gameservice.setcname( game);
 	   mv.setViewName("reply");
 	   mv.addObject("message", message);
 	   return mv;
    }
}

