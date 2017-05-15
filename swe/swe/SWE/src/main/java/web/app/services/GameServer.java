package web.app.services;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.app.controllers.TeacherController;
import web.app.entities.Game;
import web.app.entities.Question;
import web.app.repositories.GameRepository;
@Service
public class GameServer implements GameService {
	
	private GameRepository gamerepositry;
	@Autowired
	public void SetGameRepository(GameRepository gr){
		gamerepositry=gr;
	}
	@Override
	public String SaveGame(Game game) {
		if(gamerepositry.save(game)!=null)
			return"Your new game crated successfully";
		else
			return "Sorry, an errr ocurr while saving your new game.Please try again";
		
	}

	@Override
	public Game FindGame(String name) {
		ArrayList<Game> g = new ArrayList<Game>();
		g=(ArrayList<Game>) gamerepositry.findAll();
		for(int i=0;i<g.size();i++)
		{
			if(g.get(i).getName().equals(name))
			{
				return g.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean exists(String name) {
		ArrayList<Game> allgames = new ArrayList<Game>();
		allgames=(ArrayList<Game>) gamerepositry.findAll();
		for(int i=0;i<allgames.size();i++)
		{
			String gamename = allgames.get(i).getName();
			if(name.equals(gamename))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public float CalculateScore(Game game) {
		float score=0;
		ArrayList<Question> q=new ArrayList<Question>();
		q=game.getQuestions();
		for(int i=0;i<q.size();i++)
		{
			//System.out.println("the correctanswer is " +q.get(i).getCorrectAnswer());
			//System.out.println("the user answer is " +q.get(i).getUserAnswer());


			if(q.get(i).getCorrectAnswer().equals(q.get(i).getUserAnswer()))
			{
				score++;
			}
			
			
		}
		System.out.println("the score is " +score);
		System.out.println("the score is " +game.getQuestions().size());
		float res=score/(float)game.getQuestions().size();
		res=res*100;
		return res;
	}
	
	
	@Override
	public String UpdateGame(Game game)
	{
		gamerepositry.delete(game);
		if(gamerepositry.save(game)!=null)
			return"Your new description is edited successfully";
		else
			return "Sorry, an errr ocurr while editing your description.Please try again";
		
		
	}
	
	
	@Override
	public ArrayList<Game> FindAllGames()
	{
		ArrayList<Game> games = new ArrayList<Game>();
		ArrayList<Game> games1 = new ArrayList<Game>();
		games=(ArrayList<Game>) gamerepositry.findAll();
		for(int i=0;i<games.size();i++){
			if(games.get(i).getTeachername().equals(TeacherController.teacher1.getEmail())||(games.get(i).getCteacher().equals(TeacherController.teacher1.getEmail()))){
				games1.add(games.get(i));
			}
		}
		return games1;
	}
	
	@Override
	public String setcname(Game g){

		gamerepositry.delete(g);
		if(gamerepositry.save(g)!=null)
			return"Done";
		else
			return "Sorry, an errr ocurr happen";
	}
	
	
	@Override
	public void cancel(Game g){
		System.out.println("hii");
		System.out.println(g.getName());
		gamerepositry.delete(g);
	}
		
	

}
