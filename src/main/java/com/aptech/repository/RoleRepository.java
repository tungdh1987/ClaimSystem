package com.aptech.repository;

import java.util.List;

import com.aptech.model.Role;

public interface RoleRepository {

	List<Role> findAll();

	Role findRoleById(int roleId);

}