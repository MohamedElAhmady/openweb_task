package com.openweb.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.openweb.datatransferobject.EmployeeDTO;
import com.openweb.domainobject.Employee;

public class EmployeeMapper {

	/**
	 * A method to make a DTO from the DO
	 * @param employee
	 * @return DTO
	 */
	public static EmployeeDTO makeEmployeeDTO(Employee employee) {

		EmployeeDTO.EmployeeDTOBuilder employeeDTOBuilder = EmployeeDTO.newBuilder()
				.setName(employee.getName())
				.setRole(employee.getRole())
				.setSkillset(String.join(",", employee.getSkills()))
				.setProfileImageURL(employee.getProfileImage());

		return employeeDTOBuilder.createEmployeeDTO();
	}

	/***
	 * 
	 * @param employees
	 * @return List of employee DTOs
	 */
	public static List<EmployeeDTO> makeEmployeeDTOList(Collection<Employee> employees) {
		return employees.stream().map(EmployeeMapper::makeEmployeeDTO).collect(Collectors.toList());
	}

}
