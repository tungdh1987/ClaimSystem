package com.aptech.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import com.aptech.model.Employee;

public interface EmployeeService {

	Page<Employee> findAll(int page, int pageSize);

	List<Employee> findByEmail(String email);

	Page<Employee> findByFullName(String fullName, int page, int pageSize);

	Employee findById(Long employeeId);

	Page<Employee> findByUserRole(String roleName, int page, int pageSize);

	Employee save(Employee employee);

	boolean validEmployee(String firstName, String lastName, String birthday,
			String phone, String address, String email, String password,
			String cfpw, String roleId, String insMoneyAcceptedPerYear,
			Model model);

}