package co.com.parameta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.parameta.dao.IEmployeeDao;
import co.com.parameta.model.Employee;
import co.com.parameta.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class ParametaApplicationTests {

	@MockBean
	IEmployeeDao employeeDao;

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Test
	public void saveEmployeeSuccessfully() {
		Employee employee = new Employee();
		employee.setDocument_number("1096548799");
		when(employeeDao.save(any())).thenReturn(employee);
		assertEquals(employee, employeeServiceImpl.saveEmployee(employee));
	}

	@Test
	public void saveEmployeeExeption() {
		Employee employeeExpected = new Employee();
		when(employeeDao.save(any())).thenReturn(employeeExpected);
		Employee employeeActual = employeeServiceImpl.saveEmployee(employeeExpected);
		assertEquals(employeeExpected, employeeActual);
	}
}
