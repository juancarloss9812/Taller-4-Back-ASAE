package co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.services.DTO.StudentDTO;
import co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.services.services.IStudentService;

/*
 * permite solicitudes desde un origen
determinado.
 */
@CrossOrigin(origins =( "http://localhost:4200"))
/*Indica que los
métodos del controlador serán servicios que
siguen el modelo REST. */
@RestController
/* 
Indica que las rutas para acceder a los servicios que siguen el
modelo REST deben tener el prefijo api. */

@RequestMapping("/api")
public class StudentRestController {
 
	@Autowired
	private IStudentService StudentService;
	
	@GetMapping("/Students")
	public List<StudentDTO> index() {
		return StudentService.findAll();
	}
		
	@GetMapping("/Students/{id}")
	public StudentDTO show(@Min(5) @PathVariable Integer id) {
		StudentDTO objStudent = null;		
		objStudent = StudentService.findById(id);		
		return objStudent;
	}

	@GetMapping("Students/{name}/{age}") 
    public String getMessage(@PathVariable String name, 
				@PathVariable("age") String edad) {        
        String msg = String.format("%s es %s años viejo", name, edad);
        System.out.println(msg);
        return msg;
    }

	@GetMapping("ConsultStudents") 
    public String getMessageParametros(@RequestParam String nombres, 
										@RequestParam String apellidos,
										@RequestParam("date") 
										@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {        
        String msg = String.format("buscando un Estudiante por nombre: %s, apellidos: %s fecha %s", nombres, apellidos,fecha);
        System.out.println(msg);
        return msg;
    }
	
	
	@PostMapping("/Students")
	public StudentDTO create(@Valid @RequestBody StudentDTO Student) {	
		StudentDTO objStudent = null;
		objStudent =  StudentService.save(Student);
		return objStudent;
	}
	

	@PutMapping("/Students/{id}")
	public StudentDTO update(@Valid @RequestBody StudentDTO Student, @PathVariable Integer id) {
		StudentDTO objStudent = null;
		StudentDTO StudentActual = StudentService.findById(id);
		if(StudentActual!=null)	
		{
			objStudent = StudentService.update(id,Student);
		}
		return objStudent;
	}
	
	
	@DeleteMapping("/Students/{id}")
	public Boolean delete(@PathVariable Integer id) {				
		Boolean bandera=false;
		StudentDTO StudentActual = StudentService.findById(id);
		if(StudentActual!=null)		
		{
			bandera = StudentService.delete(id);
		}
		return bandera;
		
	}

	@GetMapping("/Students/ListHeaders")
	public void ListHeaders(@RequestHeader Map<String, String> headers) {
		System.out.println("cabeceras");
		headers.forEach((key, value) -> {
			System.out.println(String.format("Cabecera '%s' = %s", key, value));
		});
	}
			   
}
