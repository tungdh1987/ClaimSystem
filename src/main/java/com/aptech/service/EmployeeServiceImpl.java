package com.aptech.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.aptech.model.Employee;
import com.aptech.repository.EmployeeRepository;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aptech.service.EmployeeService#findAll(int, int)
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<Employee> findAll(int page, int pageSize) {

		PageRequest pageRequest = new PageRequest(page - 1, pageSize,
				Sort.Direction.ASC, "id");
		return employeeRepository.findAll(pageRequest);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aptech.repository.EmployeeRepository#findByEmail(java.lang.String)
	 */
	@Override
	public List<Employee> findByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aptech.repository.EmployeeRepository#findByFullName(java.lang.String,
	 * int, int)
	 */
	@Override
	public Page<Employee> findByFullName(String fullName, int page, int pageSize) {
		PageRequest pageRequest = new PageRequest(page - 1, pageSize,
				Sort.Direction.ASC, "id");
		return employeeRepository.findByFullName("%" + fullName + "%",
				pageRequest);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aptech.service.EmployeeService#findById(int)
	 */
	@Override
	public Employee findById(Long employeeId) {
		return employeeRepository.findOne(employeeId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aptech.repository.EmployeeRepository#findByUserRole(java.lang.String,
	 * int, int)
	 */
	@Override
	public Page<Employee> findByUserRole(String roleName, int page, int pageSize) {

		PageRequest pageRequest = new PageRequest(page - 1, pageSize,
				Sort.Direction.ASC, "id");

		return employeeRepository.findByUserRole(roleName, pageRequest);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aptech.repository.EmployeeRepository#save(com.aptech.model.Employee)
	 */
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public boolean validEmployee(String firstName, String lastName,
			String birthday, String phone, String address, String email,
			String password, String cfpw, String roleId,
			String insMoneyAcceptedPerYear, Model model) {
		boolean flag = true;

		if (firstName.equals("")) {
			model.addAttribute("firstNameHasError", true);
			model.addAttribute("firstNameError", "The First Name is required.");
			flag = false;
		} else if (firstName.length() > 20) {
			model.addAttribute("firstNameHasError", true);
			model.addAttribute("firstNameError",
					"The First Name must be less than 20 characters.");
			flag = false;
		}

		if (lastName.equals("")) {
			model.addAttribute("lastNameHasError", true);
			model.addAttribute("lastNameError", "The Last Name is required.");
			flag = false;
		} else if (lastName.length() > 30) {
			model.addAttribute("lastNameHasError", true);
			model.addAttribute("lastNameError",
					"The Last Name must be less than 30 characters.");
			flag = false;
		}

		if (birthday.equals("")) {
			model.addAttribute("birthdayHasError", true);
			model.addAttribute("birthdayError", "The Birthday is required.");
			flag = false;
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			try {
				Date birthday_t = formatter.parse(birthday);
				Date now = formatter.parse(formatter.format(new Date()));
				if (birthday_t.compareTo(now) >= 0) {
					model.addAttribute("birthdayHasError", true);
					model.addAttribute("birthdayError",
							"The Birthday must be before today.");
					flag = false;
				}
			} catch (ParseException e) {
				model.addAttribute("birthdayHasError", true);
				model.addAttribute("birthdayError",
						"The Birthday format is incorrectly. (Ex: MM/dd/yyyy)");
				flag = false;
			}
		}

		if (phone.equals("")) {
			model.addAttribute("phoneHasError", true);
			model.addAttribute("phoneError", "The Phone is required.");
			flag = false;
		} else {
			if (!phone.matches("^\\(0[0-9]{2}\\) [0-9]{3}-[0-9]{4}")) {
				model.addAttribute("phoneHasError", true);
				model.addAttribute("phoneError",
						"The Phone format is incorrectly. (Ex: (091) 234-5678)");
				flag = false;
			}
		}

		if (address.equals("")) {
			model.addAttribute("addressHasError", true);
			model.addAttribute("addressError", "The Address is required.");
		} else if (address.length() > 150) {
			model.addAttribute("addressHasError", true);
			model.addAttribute("addressError",
					"The Address must be less than 150 characters.");
			flag = false;
		}

		if (email.equals("")) {
			model.addAttribute("emailHasError", true);
			model.addAttribute("emailError", "The Email is required.");
			flag = false;
		} else if (!email
				.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$")) {
			model.addAttribute("emailHasError", true);
			model.addAttribute("emailError",
					"Please enter a valid email address.");
			flag = false;
		}

		if (password.equals("")) {
			model.addAttribute("passwordHasError", true);
			model.addAttribute("passwordError", "The Password is required.");
			flag = false;
		}

		if (!password.equals(cfpw)) {
			model.addAttribute("cfpwHasError", true);
			model.addAttribute("cfpwError",
					"The Confirm Password doesn't match. ");
			flag = false;
		}

		if (roleId.equals("")) {
			model.addAttribute("roleIdHasError", true);
			model.addAttribute("roleError", "The Role is required.");
			flag = false;
		}

		if (insMoneyAcceptedPerYear.equals("")) {
			model.addAttribute("insMoneyAcceptedPerYearHasError", true);
			model.addAttribute("insMoneyAcceptedPerYearError",
					"The Insurance Money Per Year is required.");
			flag = false;
		} else {
			try {
				float temp = Float.parseFloat(insMoneyAcceptedPerYear);
				if (temp < 0) {
					model.addAttribute("insMoneyAcceptedPerYearHasError", true);
					model.addAttribute("insMoneyAcceptedPerYearError",
							"The Insurance Money Per Year must greater than 0.");
					flag = false;
				}
			} catch (NumberFormatException ex) {
				model.addAttribute("insMoneyAcceptedPerYearHasError", true);
				model.addAttribute("insMoneyAcceptedPerYearError",
						"The Insurance Money Per Year must be a positive number.");
				flag = false;
			} catch (StackOverflowError ex) {
				model.addAttribute("insMoneyAcceptedPerYearHasError", true);
				model.addAttribute("insMoneyAcceptedPerYearError",
						"Number of money you entered too many.");
				flag = false;
			}
		}

		return flag;
	}

}
