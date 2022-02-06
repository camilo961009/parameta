package co.com.parameta.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "El nombre no puede ser vacio")
	@NotNull(message = "El nombre no puede ser nulo")
	@Column(nullable = false)
	private String names;

	@NotEmpty(message = "El apellido no puede ser vacio")
	@NotNull(message = "El apellido no puede ser nulo")
	@Column(nullable = false)
	private String last_names;

	@NotEmpty(message = "El tipo de documento no puede ser vacio")
	@NotNull(message = "El tipo de documento no puede ser nulo")
	@Column(nullable = false)
	private String document_type;

	@NotEmpty(message = "El numero de documento no puede ser vacio")
	@NotNull(message = "El numero de documento no puede ser nulo")
	@Column(nullable = false)
	@Id
	private String document_number;

	@NotNull(message = "La fecha de nacimiento no puede ser nula")
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_of_birth;

	@NotNull(message = "La fecha de vinculacion no puede ser nula")
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date vinculation;

	@NotEmpty(message = "El cargo no puede ser vacio")
	@NotNull(message = "El cargo no puede ser nulo")
	@Column(nullable = false)
	private String position;

	@Column(nullable = false)
	private Double salary;

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLast_names() {
		return last_names;
	}

	public void setLast_names(String last_names) {
		this.last_names = last_names;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getDocument_number() {
		return document_number;
	}

	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Date getVinculation() {
		return vinculation;
	}

	public void setVinculation(Date vinculation) {
		this.vinculation = vinculation;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
