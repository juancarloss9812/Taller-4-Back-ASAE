package co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.services.services;

import java.util.List;

import co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.services.DTO.StudentDTO;

public interface IStudentService {
    
	public List<StudentDTO> findAll();		
	public StudentDTO findById(Integer id);	
	public StudentDTO save(StudentDTO Student);	
	public StudentDTO update(Integer id, StudentDTO Student);	
	public boolean delete(Integer id);	
}
