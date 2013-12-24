package com.aptech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptech.model.Role;
import com.aptech.repository.RoleRepository;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aptech.service.RoleService#findAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aptech.service.RoleService#findRoleById(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public Role findRoleById(int roleId) {
		return roleRepository.findRoleById(roleId);
	}

}
