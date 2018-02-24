package com.openweb.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.openweb.domainobject.Employee;
import com.openweb.domainobject.Employees;
import com.openweb.util.JSONLoader;

@Service
public class DefaultEmployeeService implements EmployeeService {

	@Override
	public List<Employee> getEmployees(String JSON_URL) throws Exception {

		String json = JSONLoader.readUrl(JSON_URL);
		Gson gson = new Gson();
		Employees employees = gson.fromJson(json, Employees.class);
		
		return employees.getEmployees();
	}

}
