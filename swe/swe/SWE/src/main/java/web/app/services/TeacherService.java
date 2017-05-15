package web.app.services;

import web.app.entities.Teacher;

public interface TeacherService {
	
	Iterable<Teacher> ListAllTeachers(); 
    Teacher  GetTeacherById(String email);
    String SaveTeacher(Teacher teacher);
    boolean exists(String email);
    boolean verfiy(Teacher teacher);
    int count();

}
