package com.openweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.openweb.controller.mapper.EmployeeMapper;
import com.openweb.datatransferobject.EmployeeDTO;
import com.openweb.service.EmployeeService;
import com.openweb.util.AppConstants;
import com.openweb.util.JSONUtilService;

@RestController
@RequestMapping("/api")
public class EmployeesController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired 
	JSONUtilService jsonUtilService;
	
	Logger log = LoggerFactory.getLogger(EmployeesController.class);

	@RequestMapping(value = "/employees/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String indexPage() throws Exception {

		List<EmployeeDTO> 
			employees = EmployeeMapper
					.makeEmployeeDTOList(employeeService.getEmployees(AppConstants.EMPLOYEES_JSON_URL));
		
        // convert objects to JSON and return it.
		return jsonUtilService.getJson(employees);
	}

}