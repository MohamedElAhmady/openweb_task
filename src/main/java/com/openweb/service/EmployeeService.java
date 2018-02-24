package com.openweb.service;

import java.util.List;

import com.openweb.domainobject.Employee;

public interface EmployeeService {
	List<Employee> getEmployees(String JSON_RUL) throws Exception;
}
