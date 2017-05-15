package web.app.services;

import java.util.ArrayList;

import web.app.entities.Question;
import web.app.entities.Student;




public interface QuestionService {

	 ArrayList<Question> find(String Name);
	 String SaveQuestion(ArrayList<Question> question);
	Question Find(String name);
	String DeleteQuestion(Question question);

    
	
}
