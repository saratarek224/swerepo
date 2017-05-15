package web.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.app.entities.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student , String> {
}
