package co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class StudentEntity {
    private Integer id;		
	private String name;	
	private String lastName;	
	private String email;	
	private Date createAt;  
	
	public StudentEntity()
	{
		
	}

}
