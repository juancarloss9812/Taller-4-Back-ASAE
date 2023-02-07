package co.edu.unicauca.asae.proyecto_api_rest_unicauca.core.services.DTO;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Getter @Setter @AllArgsConstructor
public class StudentDTO {
    private Integer id;
	@NotNull(message = "{user.name.empty}")
	@Size(min = 4, max = 45, message = "la cantidad de caracteres del nombre debe estar entre 4 y 45")
	private String name;	
	@NotNull(message = "{user.lastname.empty}")
	@Size(min = 4, max = 45, message = "{user.lastname.length}")
	private String lastName;	
	@NotNull(message = "{user.email.emply}")
	@Email(message = "{user.email.mask}")
	private String email;	
	@PastOrPresent(message = "{user.date.past}")
	private Date createAt;
	

	public StudentDTO()
	{
		
	}
}
