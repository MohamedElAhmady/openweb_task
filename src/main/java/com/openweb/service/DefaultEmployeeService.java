package com.openweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.openweb.domainobject.Employee;
import com.openweb.domainobject.Employees;
import com.openweb.util.JSONUtilService;

@Service
public class DefaultEmployeeService implements EmployeeService {

	@Autowired
	JSONUtilService jsonutilService;

	@Override
	public List<Employee> getEmployees(String JSON_URL) throws Exception {
		String json = jsonutilService.readJSONStringFromURL(JSON_URL);
		Employees employees = jsonutilService.getObjectfromJson(json, Employees.class);
		return employees.getEmployees();
	}

}
