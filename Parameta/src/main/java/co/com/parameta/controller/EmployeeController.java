package co.com.parameta.controller;

import static co.com.parameta.utils.Util.getDays;
import static co.com.parameta.utils.Util.getYears;
import static co.com.parameta.utils.Util.getmonths;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.parameta.model.Employee;
import co.com.parameta.model.ResponseMessage;
import co.com.parameta.service.IEmployeeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee, BindingResult result) {

		Employee employeNew = null;
		ResponseMessage responseMessage = new ResponseMessage();

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> err.getDefaultMessage() + " (" + "El campo '" + err.getField() + "')")
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if (employee.getSalary() <= 0) {

			String error = "El valor del salario no es valido";
			response.put("error", error);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		int age = getYears(employee.getDate_of_birth());
		int months = getmonths(employee.getDate_of_birth());
		int days = getDays(employee.getDate_of_birth());

		int ageVinculation = getYears(employee.getVinculation());
		int monthsVinculation = getmonths(employee.getVinculation());
		int daysVinculation = getDays(employee.getVinculation());

		if (age < 18) {
			String error = "El empleado debe ser mayor de edad";
			response.put("error", error);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			employeNew = employeeService.saveEmployee(employee);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		responseMessage.setAge("años: " + age + ", meses: " + months + ", dias: " + days);
		responseMessage.setMessage(
				"El empleado " + employee.getNames() + " " + employee.getLast_names() + " ha sido creado con éxito.");
		responseMessage.setAgeVinculation(
				"años: " + ageVinculation + ", meses: " + monthsVinculation + ", dias: " + daysVinculation);
		response.put("response", responseMessage);

		response.put("Empleado", employeNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
