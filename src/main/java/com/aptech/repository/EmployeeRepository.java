package com.aptech.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aptech.model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE e.account.email = ?1")
	List<Employee> findByEmail(String email);

	@Query("SELECT e FROM Employee e "
			+ "WHERE CONCAT(e.firstName, ' ', e.lastName) LIKE ?1")
	Page<Employee> findByFullName(String fullName, Pageable pageable);

	@Query("SELECT e FROM Employee e " + "WHERE e.account.role.roleName = ?1")
	Page<Employee> findByUserRole(String roleName, Pageable pageable);

}