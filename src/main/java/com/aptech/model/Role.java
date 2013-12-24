package com.aptech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Roles")
@NamedQueries({ @NamedQuery(name = Role.FIND_ALL, query = "SELECT r FROM Role r") })
public class Role {

	public static final String FIND_ALL = "Role.findAll";

	@Id
	@GeneratedValue
	@Column(name = "RoleId")
	private int id;

	@NotEmpty
	@Size(max = 20)
	@Column(name = "RoleName", nullable = false)
	private String roleName;

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public int getId() {
		return id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
