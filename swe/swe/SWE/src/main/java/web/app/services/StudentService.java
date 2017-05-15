package web.app.services;

import web.app.entities.Student;


public interface StudentService {

	Iterable<Student> ListAllStudents(); 
    Student GetStudentById(String email);
    String SaveStudent(Student Student);
    boolean exists(String email);
    boolean verfiy(Student student);
    long count();
    
}
