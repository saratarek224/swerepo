package web.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.app.entities.Course;
@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {


}
