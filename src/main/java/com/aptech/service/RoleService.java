package com.aptech.service;

import java.util.List;

import com.aptech.model.Role;

public interface RoleService {

	List<Role> findAll();

	Role findRoleById(int roleId);

}