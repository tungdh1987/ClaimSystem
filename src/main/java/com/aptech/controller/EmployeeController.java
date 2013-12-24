package com.aptech.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aptech.model.Account;
import com.aptech.model.Employee;
import com.aptech.service.AccountService;
import com.aptech.service.EmployeeService;
import com.aptech.service.EncryptService;
import com.aptech.service.RoleService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {

		model.addAttribute("title", "Add New Employee");
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("view", "Employee/create.jsp");

		return "Shared/template";
	}

	@RequestMapping(value = "/edit/{employeeId}", method = RequestMethod.GET)
	public String edit(@PathVariable(value = "employeeId") Long employeeId,
			Model model) {

		Employee employee = employeeService.findById(employeeId);

		if (employee != null) {
			model.addAttribute("title", "Edit Employee");
			model.addAttribute("employee", employee);
			model.addAttribute("roles", roleService.findAll());
			model.addAttribute("view", "Employee/edit.jsp");
		} else {
			return "Shared/404";
		}

		return "Shared/template";
	}

	@RequestMapping(value = { "", "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model,
			@RequestParam(value = "page", required = false) Integer temp,
			HttpServletRequest request) {

		if (temp == null) {
			temp = 1;
		}

		Page<Employee> page = employeeService.findAll(temp, 1);

		if (temp > page.getTotalElements()) {
			return "Shared/404";
		}

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 1);
		int end = Math.min(begin + 1, page.getTotalPages());

		model.addAttribute("title", "Employees List");
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("page", page);
		model.addAttribute("employees", page.getContent());
		model.addAttribute("view", "Employee/index.jsp");

		return "Shared/template";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String save(
			@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "birthday") String birthday,
			@RequestParam(value = "phone") String phone,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "cfpw") String cfpw,
			@RequestParam(value = "roleId") String roleId,
			@RequestParam(value = "insMoneyAcceptedPerYear") String insMoneyAcceptedPerYear,
			Model model) throws ParseException {

		firstName = firstName.trim();
		lastName = lastName.trim();
		birthday = birthday.trim();
		phone = phone.trim();
		address = address.trim();
		email = email.trim();
		insMoneyAcceptedPerYear = insMoneyAcceptedPerYear.trim().replace(",",
				"");

		if (!employeeService.validEmployee(firstName, lastName, birthday,
				phone, address, email, password, cfpw, roleId,
				insMoneyAcceptedPerYear, model)) {
			model.addAttribute("firstName", firstName);
			model.addAttribute("lastName", lastName);
			model.addAttribute("birthday", birthday);
			model.addAttribute("phone", phone);
			model.addAttribute("address", address);
			model.addAttribute("email", email);
			model.addAttribute("roleId", roleId);
			model.addAttribute("insMoneyAcceptedPerYear",
					insMoneyAcceptedPerYear);
			model.addAttribute("title", "Add New Employee");
			model.addAttribute("roles", roleService.findAll());
			model.addAttribute("view", "Employee/create.jsp");

			return "Shared/template";
		}

		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setBirthday((new SimpleDateFormat("MM/dd/yyyy"))
				.parse(birthday));
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setInsMoneyAcceptedPerYear(new BigDecimal(
				insMoneyAcceptedPerYear));

		employeeService.save(employee);

		Account account = new Account();
		account.setEmail(email);
		account.setPassword(EncryptService.SHA1(password));
		account.setRole(roleService.findRoleById(Integer.parseInt(roleId)));
		account.setEmployee(employee);

		accountService.save(account);

		return "redirect:index";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(value = "searchBy") String searchBy,
			@RequestParam(value = "q") String q,
			@RequestParam(value = "page", required = false) Integer temp,
			Model model, HttpServletRequest request) {

		if (temp == null) {
			temp = 1;
		}

		model.addAttribute("title", "Employees List");

		if ("email".equals(searchBy)) {
			List<Employee> employees = employeeService.findByEmail(q);
			model.addAttribute("employees", employees);
		} else {
			Page<Employee> page = null;
			if ("userRole".equals(searchBy)) {
				page = employeeService.findByUserRole(q, temp, 1);
			} else if ("fullName".equals(searchBy)) {
				page = employeeService.findByFullName(q, temp, 1);
			} else {
				return "Shared/404";
			}
			int current = page.getNumber() + 1;
			int begin = Math.max(1, current - 1);
			int end = Math.min(begin + 1, page.getTotalPages());

			model.addAttribute("beginIndex", begin);
			model.addAttribute("endIndex", end);
			model.addAttribute("currentIndex", current);
			model.addAttribute("url", request.getRequestURI() + "?searchBy="
					+ searchBy + "&q=" + q);
			model.addAttribute("page", page);
			model.addAttribute("employees", page.getContent());
		}

		model.addAttribute("action", "search");
		model.addAttribute("searchBy", searchBy);
		model.addAttribute("view", "Employee/index.jsp");

		return "Shared/template";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String update(
			@RequestParam(value = "employeeId") String employeeId,
			@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "birthday") String birthday,
			@RequestParam(value = "phone") String phone,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "cfpw") String cfpw,
			@RequestParam(value = "roleId") String roleId,
			@RequestParam(value = "insMoneyAcceptedPerYear") String insMoneyAcceptedPerYear,
			Model model) throws ParseException {

		Long id = null;
		try {
			id = Long.parseLong(employeeId);
		} catch (NumberFormatException ex) {
		}

		firstName = firstName.trim();
		lastName = lastName.trim();
		birthday = birthday.trim();
		phone = phone.trim();
		address = address.trim();
		email = email.trim();
		insMoneyAcceptedPerYear = insMoneyAcceptedPerYear.trim().replace(",",
				"");

		if (!employeeService.validEmployee(firstName, lastName, birthday,
				phone, address, email, password, cfpw, roleId,
				insMoneyAcceptedPerYear, model)) {
			model.addAttribute("firstName", firstName);
			model.addAttribute("lastName", lastName);
			model.addAttribute("birthday", birthday);
			model.addAttribute("phone", phone);
			model.addAttribute("address", address);
			model.addAttribute("email", email);
			model.addAttribute("roleId", roleId);
			model.addAttribute("insMoneyAcceptedPerYear",
					insMoneyAcceptedPerYear);
			model.addAttribute("title", "Add New Employee");
			model.addAttribute("roles", roleService.findAll());
			model.addAttribute("view", "Employee/create.jsp");

			return "Shared/template";
		}

		Employee employee = employeeService.findById(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setBirthday((new SimpleDateFormat("MM/dd/yyyy"))
				.parse(birthday));
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setInsMoneyAcceptedPerYear(new BigDecimal(
				insMoneyAcceptedPerYear));

		employeeService.save(employee);

		Account account = employee.getAccount();
		account.setEmail(email);
		account.setPassword(EncryptService.SHA1(password));
		account.setRole(roleService.findRoleById(Integer.parseInt(roleId)));
		account.setEmployee(employee);

		accountService.save(account);

		return "redirect:index";
	}
}
