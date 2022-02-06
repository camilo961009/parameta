package co.com.parameta.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.parameta.model.Employee;

public interface IEmployeeDao extends CrudRepository<Employee, String> {

}
