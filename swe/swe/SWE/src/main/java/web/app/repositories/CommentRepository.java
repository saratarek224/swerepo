package web.app.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.app.entities.Comment;
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{

}