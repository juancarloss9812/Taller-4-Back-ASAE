package co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.services.services;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.models.StudentEntity;
import co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.repositories.StudentRepository;
import co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.services.DTO.StudentDTO;

@Service
public class IStudentServiceImpl implements IStudentService{

	@Autowired
	private StudentRepository servicioAccesoBaseDatos;

	@Autowired
    private ModelMapper modelMapper;

	@Override
	public List<StudentDTO> findAll() {	
		
		List<StudentEntity> StudentsEntity= this.servicioAccesoBaseDatos.findAll();
		List<StudentDTO> StudentsDTO=this.modelMapper.map(StudentsEntity, new TypeToken<List<StudentDTO>>() {}.getType());
		return StudentsDTO;
	}

	@Override
	public StudentDTO findById(Integer id) {		
		StudentEntity objStudentEntity= this.servicioAccesoBaseDatos.findById(id);
		StudentDTO StudentDTO=this.modelMapper.map(objStudentEntity, StudentDTO.class);
		return StudentDTO;
	}

	@Override
	public StudentDTO save(StudentDTO Student) {
	    Integer id = (this.servicioAccesoBaseDatos.getListStudents().get(this.servicioAccesoBaseDatos.getListStudents().size()-1).getId())+1;
		Student.setId(id); 
		StudentEntity StudentEntity=this.modelMapper.map(Student, StudentEntity.class);
		StudentEntity objStudentEntity= this.servicioAccesoBaseDatos.save(StudentEntity);
		StudentDTO StudentDTO=this.modelMapper.map(objStudentEntity, StudentDTO.class);
		return StudentDTO;		
	}

	@Override
	public StudentDTO update(Integer id, StudentDTO Student) {	
		StudentEntity StudentEntity=this.modelMapper.map(Student, StudentEntity.class);	
		StudentEntity StudentEntityActualizado= this.servicioAccesoBaseDatos.update(id, StudentEntity);
		StudentDTO StudentDTO=this.modelMapper.map(StudentEntityActualizado, StudentDTO.class);
		return StudentDTO;	
	}

	@Override
	public boolean delete(Integer id) {
		return this.servicioAccesoBaseDatos.delete(id);		
	}
 
    
}
