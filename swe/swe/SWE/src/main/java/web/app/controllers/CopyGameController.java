package web.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.app.entities.Game;
import web.app.entities.Question;
import web.app.entities.Teacher;
import web.app.services.CourseService;
import web.app.services.GameService;
import web.app.services.QuestionService;


@Controller
public class CopyGameController {
	
	private Game newgame=new Game();
	ArrayList<Game> games = new ArrayList<Game>();
	public Question question =new Question();
    ArrayList<Question> q ;
    ArrayList<Question> q1 = new ArrayList<Question>();
	private Game game;
	
	private ArrayList<Question>questions;
	private GameService gameservice;
	private CourseService courseservice;
	private QuestionService questionservice;
    private String teacher;
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
	
	@RequestMapping(value="/copy/{name}",method=RequestMethod.GET)
	public ModelAndView copygame(@PathVariable String name)
	{
		System.out.println("hiii");
    	game=new Game();
		game=gameservice.FindGame(name);
		System.out.println(game.getName());
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("copygame");
	  mv.addObject("game", game);
	  return mv;
	
	}
	
	@RequestMapping(value="/game/copy",method=RequestMethod.GET)
	public ModelAndView copy(){
		System.out.println(game.getName());
		System.out.println("hii from copy");
		newgame.setName(game.getName());
		newgame.setDescription(game.getDescription());
		newgame.setSecondaryId(game.getSecondaryId());
		newgame.setTeachername(TeacherController.teacher1.getEmail());
		gameservice.SaveGame(newgame);
		q=questionservice.find(game.getName());
		System.out.println(q.size());
		ModelAndView mv = new ModelAndView();
		  mv.setViewName("copyquestions");
		  mv.addObject("q", q);
		return mv;
		
		
	}
	@RequestMapping(value="/game/editt",method=RequestMethod.GET)
	public ModelAndView edit(){
		ModelAndView mv = new ModelAndView();
		  mv.setViewName("editgame");
		  mv.addObject("g", game);
		return mv;
		
		
	}
	@RequestMapping(value="/edited",method=RequestMethod.GET)
	public ModelAndView edited(@ModelAttribute Game g){
		System.out.println("hii from edit");
		System.out.println(g.getName());
		newgame.setName(g.getName());
		newgame.setDescription(g.getDescription());
		newgame.setSecondaryId(g.getSecondaryId());
		newgame.setTeachername(TeacherController.teacher1.getEmail());
		gameservice.SaveGame(newgame);
		q=questionservice.find(game.getName());
		System.out.println(q.size());
		ModelAndView mv = new ModelAndView();
		  mv.setViewName("copyquestions");
		  mv.addObject("q", q);
		return mv;
		
		
	}
	@RequestMapping(value="/copyquestion",method=RequestMethod.GET)
	public ModelAndView copyquestion()
	{
	  q=questionservice.find(game.getName());
	  for(int i=0;i<q.size();i++){
		  question.setStatement(q.get(i).getStatement());
		  question.setCorrectAnswer(q.get(i).getCorrectAnswer());
		  question.setGameName(newgame.getName());
		  q1.add(question);
	  }
	  newgame.setQuestions(q1);
	  System.out.println("hello");
	  ModelAndView mv = new ModelAndView();
	  String message=questionservice.SaveQuestion(q1);
	  mv.setViewName("reply");
	  mv.addObject("message", message);
	  return mv;
	
	}
	

}
