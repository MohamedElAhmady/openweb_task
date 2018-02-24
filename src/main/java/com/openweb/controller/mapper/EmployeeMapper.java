package com.openweb.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.openweb.datatransferobject.EmployeeDTO;
import com.openweb.domainobject.Employee;

public class EmployeeMapper {

	public static EmployeeDTO makeCarDTO(Employee employee) {

		EmployeeDTO.EmployeeDTOBuilder employeeDTOBuilder = EmployeeDTO.newBuilder()
				.setName(employee.getName())
				.setRole(employee.getRole())
				.setSkillset(String.join(",", employee.getSkills()))
				.setProfileImageURL(employee.getProfileImage());

		return employeeDTOBuilder.createEmployeeDTO();
	}

	public static List<EmployeeDTO> makeEmployeeDTOList(Collection<Employee> employees) {
		return employees.stream().map(EmployeeMapper::makeCarDTO).collect(Collectors.toList());
	}

}
