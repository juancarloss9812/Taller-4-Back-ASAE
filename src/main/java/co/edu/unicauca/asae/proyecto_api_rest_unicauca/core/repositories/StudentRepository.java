package co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.models.StudentEntity;

@Repository
public class StudentRepository {
    private ArrayList<StudentEntity> listStudents;
	
	public ArrayList<StudentEntity> getListStudents() {
		return listStudents;
	}

	public StudentRepository()
	{
		this.listStudents= new ArrayList<StudentEntity>();
		loadStudents();
	}
	
   public List<StudentEntity> findAll()
   {
	   System.out.println("Invocando a listStudents");
	   return this.listStudents;	
   }
	
   public StudentEntity findById(Integer id)
   {
	   System.out.println("Invocando a consultar un Estudiante");
		StudentEntity objStudent=null;
		
		for (StudentEntity Student : listStudents) {
			if(Student.getId()==id)
			{
				objStudent=Student;
				break;
			}
		}
		
		return objStudent;
	}
	
	public StudentEntity save(StudentEntity Student)	
	{
		 System.out.println("Invocando a almacenar Estudiante");
		 StudentEntity objStudent=null;
		 if (this.listStudents.add(Student))
		 {
			 objStudent=Student;
		 }
		 
		 return objStudent;
	}
	
	public StudentEntity update(Integer id, StudentEntity Student)
	{
		 System.out.println("Invocando a actualizar un Estudiante");
		 StudentEntity objStudent=null;
		 
		 for (int i = 0; i < this.listStudents.size(); i++) {
			if(this.listStudents.get(i).getId()==id)
			{				
				this.listStudents.set(i,Student);
				objStudent=Student;
				break;
			}
		}
		 
		 return objStudent;
	}
	
	public boolean delete(Integer id)
	{
		System.out.println("Invocando a eliminar un Estudiante");
		boolean bandera=false;
		 
		 for (int i = 0; i < this.listStudents.size(); i++) {
			if(this.listStudents.get(i).getId()==id)
			{
				this.listStudents.remove(i);
				bandera=true;
				break;
			}
		}
		 
		 return bandera;
	}
	
	private void loadStudents()
	{
		StudentEntity objStudent1= new StudentEntity(1, "Juan", "Perez", "juan@unicauca.edu.co", new Date());
		this.listStudents.add(objStudent1);
		StudentEntity objStudent2= new StudentEntity(2, "Catalina", "Lopez", "catalina@unicauca.edu.co", new Date());
		this.listStudents.add(objStudent2);
		StudentEntity objStudent3= new StudentEntity(3, "Sandra", "Sanchez", "Sandra@unicauca.edu.co", new Date());
		this.listStudents.add(objStudent3);
		StudentEntity objStudent= new StudentEntity(4, "Andres", "Perez", "andres@unicauca.edu.co", new Date());
		this.listStudents.add(objStudent);
	}
}
