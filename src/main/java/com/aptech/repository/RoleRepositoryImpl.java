package com.aptech.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.aptech.model.Role;

@Repository("roleRepository")
public class RoleRepositoryImpl implements RoleRepository {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aptech.repository.RoleRepository#findAll()
	 */
	@Override
	public List<Role> findAll() {
		TypedQuery<Role> query = em.createNamedQuery(Role.FIND_ALL, Role.class);

		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aptech.repository.RoleRepository#findRoleById(int)
	 */
	@Override
	public Role findRoleById(int roleId) {

		return em.find(Role.class, roleId);
	}
}
