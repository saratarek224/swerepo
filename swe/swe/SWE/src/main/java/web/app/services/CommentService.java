package web.app.services;

import java.util.ArrayList;

import web.app.entities.Comment;

public interface CommentService {

	ArrayList<Comment> findAll(String name);

	String save(Comment comment);

}
