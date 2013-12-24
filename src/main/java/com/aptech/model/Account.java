package com.aptech.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Embeddable
@Table(name = "Accounts")
@NamedQueries({ @NamedQuery(name = Account.FIND_ACCOUNT, query = "SELECT a FROM Account a WHERE a.email = :email") })
public class Account {

	public static final String FIND_ACCOUNT = "Account.findAccount";

	@Id
	@GeneratedValue
	@Column(name = "AccountId")
	private Long id;

	@NotEmpty
	@Email
	@Column(name = "Email", unique = true)
	private String email;

	@NotEmpty
	@Column(name = "Password")
	private String password;

	@JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
	@ManyToOne
	private Role role;

	@NotNull
	@JoinColumn(name = "EmployeeId")
	@OneToOne
	private Employee employee;

	public String getEmail() {
		return email;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
