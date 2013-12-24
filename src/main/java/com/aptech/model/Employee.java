package com.aptech.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Employees")
public class Employee {

	public static final String FIND_ALL = "Employee.findAll";
	public static final String FIND_BY_FULL_NAME = "Employee.findByFullName";
	public static final String FIND_BY_BIRTHDAY = "Employee.findByBirthday";
	public static final String FIND_BY_EMAIL = "Employee.findByEmail";
	public static final String FIND_BY_USER_ROLE = "Employee.findByUserRole";

	@Id
	@GeneratedValue
	@Column(name = "EmployeeId")
	private Long id;

	@NotEmpty
	@Size(max = 20)
	@Column(name = "FirstName")
	private String firstName;

	@NotEmpty
	@Size(max = 30)
	@Column(name = "LastName")
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name = "Birthday", nullable = false)
	private Date birthday;

	@NotEmpty
	@Size(max = 15)
	@Column(name = "Phone", unique = true)
	private String phone;

	@NotEmpty
	@Size(max = 150)
	@Column(name = "Address")
	private String address;

	@NotNull
	@Column(name = "InsMoneyAcceptedPerYear", nullable = false)
	private BigDecimal insMoneyAcceptedPerYear;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Account account;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Claim> claims;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Notification> notifications;

	public Account getAccount() {
		return account;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getInsMoneyAcceptedPerYear() {
		return insMoneyAcceptedPerYear;
	}

	public String getLastName() {
		return lastName;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public String getPhone() {
		return phone;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInsMoneyAcceptedPerYear(BigDecimal insMoneyAcceptedPerYear) {
		this.insMoneyAcceptedPerYear = insMoneyAcceptedPerYear;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
