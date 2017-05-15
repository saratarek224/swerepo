package web.app.services;


import java.util.ArrayList;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.stereotype.Service;

import web.app.entities.Comment;
import web.app.entities.Game;
import web.app.entities.Student;
import web.app.repositories.CommentRepository;
import web.app.repositories.QuestionRepository;

@Service
public class CommentServer implements CommentService{
	  CommentRepository commentrepo;
	    @Autowired
		public void SeTCommentRepository(CommentRepository cr)
		{
			commentrepo=cr;
			
		}
	@Override
	public ArrayList<Comment> findAll (String name){
		ArrayList<Comment> c = new ArrayList<Comment>();
		ArrayList<Comment> c1 = new ArrayList<Comment>();

		c=(ArrayList<Comment>) commentrepo.findAll();
		for(int i=0;i<c.size();i++)
		{
			if(c.get(i).getGamename().equals(name))
			{
				c1.add(c.get(i));
			}
		}
		return c1;
		
	}
	@Override
	public String save(Comment comment)
	{
		if(commentrepo.save(comment)!=null)
		{
			return"Your comment is added successfully";

		}
		return"Sorry, Your Comment isn't added, Try Again later";
	}


}
