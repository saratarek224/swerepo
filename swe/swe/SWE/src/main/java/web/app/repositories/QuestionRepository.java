package web.app.repositories;
import org.springframework.data.repository.CrudRepository;

import web.app.entities.Question;



public interface QuestionRepository extends CrudRepository<Question, Integer>{

}

