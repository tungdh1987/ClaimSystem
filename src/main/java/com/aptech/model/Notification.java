package com.aptech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Notifications")
public class Notification {

	@Id
	@GeneratedValue
	@Column(name = "NotificationId")
	private Long id;

	@NotEmpty
	@Lob
	@Size(max = 2147483647)
	@Column(name = "Content")
	private String content;

	@Column(name = "Status", nullable = false)
	private boolean status;

	@NotNull
	@JoinColumn(name = "EmployeeId", referencedColumnName = "EmployeeId")
	@ManyToOne
	private Employee employee;

	public String getContent() {
		return content;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Long getId() {
		return id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
