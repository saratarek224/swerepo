package web.app.services;

import java.util.ArrayList;

import web.app.entities.Game;

public interface GameService {
	String SaveGame(Game game);
	Game FindGame(String name);
	boolean exists(String name);
    float CalculateScore(Game game);
	String UpdateGame(Game game);
	ArrayList<Game> FindAllGames();
	String setcname(Game g);
	void cancel(Game g);
	

}
