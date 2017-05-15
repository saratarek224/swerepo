package web.app.repositories;

import org.springframework.data.repository.CrudRepository;

import web.app.entities.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, String> {

}
