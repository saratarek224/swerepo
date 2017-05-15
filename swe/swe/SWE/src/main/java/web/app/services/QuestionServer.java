package web.app.services;

import java.util.ArrayList;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.stereotype.Service;

import web.app.entities.Question;
import web.app.entities.Student;
import web.app.repositories.QuestionRepository;

@Service
public class QuestionServer implements QuestionService{
    QuestionRepository questionrepo;
    @Autowired
	public void SeTQuestionRepository(QuestionRepository cr)
	{
		questionrepo=cr;
		
	}

	@Override
	public ArrayList<Question> find(String Name) {

		ArrayList<Question> q = new ArrayList<Question>();
		ArrayList<Question> q1 = new ArrayList<Question>();

		q=(ArrayList<Question>) questionrepo.findAll();
		for(int i=0;i<q.size();i++)
		{
			if(q.get(i).getGameName().equals(Name))
			{
				q1.add(q.get(i));
			}
		}
     	return q1;
	}
	  @Override
	   public String SaveQuestion(ArrayList<Question> question)
	   { int c=0;
		  for(int i=0;i<question.size();i++)
	   {
			if (questionrepo.save(question.get(i))!=null)  
			{
				c++;
			}
			
				
		   }
		  if(c==question.size())
		  {
			  return "Your Game is added successfully";
		  }
			 return "An error occure, please try again";

	   }
	  @Override
	  public Question Find(String name)
	  {
		    ArrayList<Question> q = new ArrayList<Question>();
			ArrayList<Question> q1 = new ArrayList<Question>();

			q=(ArrayList<Question>) questionrepo.findAll();
			for(int i=0;i<q.size();i++)
			{
				if(q.get(i).getStatement().equals(name))
				{
					return q.get(i);
				}
			}
			return null;
	  }
	  @Override
	  public String DeleteQuestion(Question question)
	  {
		  questionrepo.delete(question);
		 
		  return " Question is Deleted Successfully ";
	  }

}


