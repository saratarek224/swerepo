package web.app.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.net.SyslogOutputStream;
import web.app.entities.Game;
import web.app.entities.Question;
import web.app.entities.Teacher;
import web.app.services.CourseService;
import web.app.services.GameServer;
import web.app.services.GameService;
import web.app.services.QuestionService;


@Controller
public class EditGameController {
	
	private GameService gameservice;
	private Game game;
	private Game game1;
	private Game newgame;
	ArrayList<Game> games = new ArrayList<Game>();
	private QuestionService questionservice;
	private Question question;
	ArrayList<Question> questions = new ArrayList<Question>();

    
	@Autowired
	public void  SetGameService(GameService gs)
	{
		gameservice=gs;
		
	}
	@Autowired
	public void  SetQuestionService(QuestionService qs)
	{
		questionservice=qs;
		
	}
	@RequestMapping(value="/game/edit",method=RequestMethod.GET)
	public ModelAndView Showeditoptions()
	{
		System.out.println(TeacherController.teacher1.getName());
		games=gameservice.FindAllGames();
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("editoptions");
	  mv.addObject("games", games);
	  return mv;
	}
	@RequestMapping(value="/game/options/{name}",method=RequestMethod.GET)
	public ModelAndView Showeoptions(@PathVariable String name)
	{
    	game=new Game();
		game=gameservice.FindGame(name);
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("gameeditoptions");
	  mv.addObject("game", game);
	  return mv;
	}
	@RequestMapping(value="/game/options/description",method=RequestMethod.GET)
	public ModelAndView editdescription()
	{
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("editdescription");
	  mv.addObject("g", game);
	  return mv;
	}
	
	
	
	@RequestMapping(value="/game/editquestionsoptions",method=RequestMethod.GET)
	public ModelAndView editquestiooptions()
	{
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("editquestionsoptions");
	  mv.addObject("questions", questions);
	  return mv;
	}
	@RequestMapping(value="/game/delete/question",method=RequestMethod.GET)
	public ModelAndView showquestions()
	{
		questions=questionservice.find(game.getName());
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("questionsoptions");
	  mv.addObject("questions", questions);
	  return mv;
	}
	@RequestMapping(value="/game/add/questions",method=RequestMethod.GET)
	public ModelAndView addquestions()
	{
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("addform");
	  mv.addObject("question", new Question());
	  return mv;
	}
	@RequestMapping(value="/game/added/question",method=RequestMethod.GET)
	public String  addedquestions(@ModelAttribute Question question)
	{
		System.out.println(game.getName());
		question.setGameName(game.getName());
		questions.add(question);
	 
	  return "optionsadd";
	}
	   @RequestMapping(value="/game/saved",method=RequestMethod.GET)
		public ModelAndView SaveGame()
		{
	    	game.setQuestions(questions);
	    	
	    	String message=questionservice.SaveQuestion(questions);
	    	ModelAndView mv=new ModelAndView();
	    	mv.setViewName("reply");
	    	mv.addObject("message",message);
	    	return mv;
	        
			 
		}
	@RequestMapping(value="/game/deletedquestion/{name}",method=RequestMethod.GET)
	public ModelAndView deletequestion(@PathVariable String name)
	{
    	question=questionservice.Find(name);
    	String message = questionservice.DeleteQuestion(question);
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("reply");
	  mv.addObject("message", message);
	  return mv;
	}
	@RequestMapping(value="/game/newdescription",method=RequestMethod.GET)
	public ModelAndView newdescription(@ModelAttribute Game g)
	{
		  System.out.println("hello");
		  game.setDescription(g.getDescription());
		  String message =gameservice.UpdateGame(game);
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("reply");
	    	mv.addObject("message",message);
	 
	  return mv;
	}
	
	  @RequestMapping(value="/game/cancel/{name}", method=RequestMethod.GET)
	    public ModelAndView cancelgame(@PathVariable String name)
	    {
		  
		  game=new Game();
		  game=gameservice.FindGame(name);
	 	   ModelAndView mv =new ModelAndView();
	 	   mv.setViewName("cancelgame");
	 	   mv.addObject("game", game);
	 	   return mv;
	    }
	    
	    
	    @RequestMapping(value="/game/canceled", method=RequestMethod.GET)
	    public ModelAndView canceled()
	    {
	    	game1=game;
	       System.out.println(game.getName());
	 	   gameservice.cancel(game);
	 	   ModelAndView mv =new ModelAndView();
	 	   mv.setViewName("uncancelgame");
	 	   mv.addObject("game", game);
	 	   return mv;
	    }
	    
	    @RequestMapping(value="/game/uncanceled", method=RequestMethod.GET)
	    public ModelAndView uncanceled()
	    {
	       System.out.println(game.getName());
	 	   gameservice.SaveGame(game1);
	 	   ModelAndView mv =new ModelAndView();
	 	   String message="The Game is unCanceled";
	 	   mv.setViewName("reply");
	 	   mv.addObject("message", message);
	 	   return mv;
	    }
	    
	    
	    
	
	
}
