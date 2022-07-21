package gmc.learning.swaggerdemo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -6031038848118523097L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String employeeId;
	
	private String emplyeeName;
	
	private String designation;
	
	private String mobileNumber;
	
	private Boolean isEnabled;

}
