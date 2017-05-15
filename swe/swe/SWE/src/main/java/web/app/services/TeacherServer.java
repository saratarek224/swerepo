package web.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.app.entities.Teacher;
import web.app.repositories.TeacherRepository;
@Service
public class TeacherServer implements TeacherService {

	TeacherRepository teacherrepository;
	@Autowired
	public void SetTeacherRepository(TeacherRepository tr)
	{
		this.teacherrepository=tr;
	}
	@Override
	public Iterable<Teacher> ListAllTeachers() {
		
		return teacherrepository.findAll();
	}

	@Override
	public Teacher GetTeacherById(String email) {
		ArrayList<Teacher> allteacher = new ArrayList<Teacher>();
		allteacher= (ArrayList<Teacher>) teacherrepository.findAll();
	    for(int i =0 ;i<allteacher.size();i++)
	    {
	    	String teachername=allteacher.get(i).getEmail();
	    	if(teachername.equals(email))
	    	{
	    		return allteacher.get(i);
	    	}
	    }
		return null;
	}

	@Override
	public String SaveTeacher(Teacher teacher) {
	
		 if(exists(teacher.getEmail()))
			  return "This email is already exists ";
		 else
		 {
		   if(teacherrepository.save(teacher)!=null)
		   return "Your acout created sucessfuly, you will recive confirmation mail";
		   else
			   return"An error occure, please try again";
		 }
	}


	@Override
	public boolean exists(String email) {
		ArrayList<Teacher> allteacher = new ArrayList<Teacher>();
		allteacher= (ArrayList<Teacher>) teacherrepository.findAll();
	    for(int i =0 ;i<allteacher.size();i++)
	    {
	    	String teachername=allteacher.get(i).getEmail();
	    	if(teachername.equals(email))
	    	{
	    		return true;
	    	}
	    }
		
		return false;
	}
	@Override
	public boolean verfiy(Teacher teacher) {
		
		boolean TeacherExist=exists(teacher.getEmail());
		boolean CorrectPassword=false;
		if(TeacherExist)
		{
		Teacher t=new Teacher();
		t=GetTeacherById(teacher.getEmail());
		if(t.getPassword().equals(teacher.getPassword()))
		    CorrectPassword=true;
		    
		}
         return (TeacherExist&&CorrectPassword);
	}
	@Override
	public int count() {
		
		return  (int)teacherrepository.count() ;
	}

}
