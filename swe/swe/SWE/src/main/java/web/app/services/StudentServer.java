package web.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import web.app.entities.Student;
import web.app.repositories.StudentRepository;
@Service
public class StudentServer implements StudentService {
	private StudentRepository studentrepository;
	
	@Autowired
	public void SeTStudentRepository(StudentRepository sr)
	{
		studentrepository=sr;
		
	}
	@Override
	public Iterable<Student> ListAllStudents()
	{
		return studentrepository.findAll();
	}
	
	
	 @Override
   public   Student GetStudentById(String email)
    {
		 ArrayList<Student> allstudent = new ArrayList<Student> ();
		 allstudent=(ArrayList<Student>) studentrepository.findAll();
		 for(int i=0;i<allstudent.size();i++)
		 {
			String nameofStudent = allstudent.get(i).getEmail();
			if(nameofStudent.equals(email))
			{
				return allstudent.get(i);
			}
		 }
		
		 return null;
		 
    }
   @Override
   public String SaveStudent(Student student)
   {   
	  if(exists(student.getEmail()))
	  { 
		  return "This email is already exists ";
		  }
	   else
	   { 
		if (studentrepository.save(student)!=null)  
		{ return "Your account is created sucessfuly,you will recive confirmation mail ";}
		 else 
			 {return "An error occure, please try again";}
	   }
   }
   @Override
public boolean  exists(String email)
   {

		 ArrayList<Student> allstudent = new ArrayList<Student> ();
		 allstudent=(ArrayList<Student>) studentrepository.findAll();
	    for(int i=0;i<allstudent.size();i++)
		 {
			String nameofStudent = allstudent.get(i).getEmail();
			if(nameofStudent.equals(email))
			{
				return true;
			}
		 }
	   return false;
   }
@Override
public boolean verfiy(Student student) {
	
	boolean StudentExist=exists(student.getEmail());
	boolean CorrectPassword=false;
	if(StudentExist)
	{
	Student s=new Student();
	s=GetStudentById(student.getEmail());
	if(s.getPassword().equals(student.getPassword()))
	    CorrectPassword=true;
	}
	return (StudentExist&&CorrectPassword);
}
@Override
public long count() {
	
	return studentrepository.count();
}
   
}
