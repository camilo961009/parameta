package co.com.parameta.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parameta.dao.IEmployeeDao;
import co.com.parameta.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {
		employeeDao.save(employee);
		return employee;
	}
}
