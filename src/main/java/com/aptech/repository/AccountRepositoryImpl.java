package com.aptech.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.aptech.model.Account;

@Repository("accountRepository")
public class AccountRepositoryImpl implements AccountRepository {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aptech.repository.AccountRepository#findAccount(java.lang.String)
	 */
	@Override
	public Account findAccount(String email) {
		try {
			TypedQuery<Account> query = em.createNamedQuery(
					Account.FIND_ACCOUNT, Account.class);
			return query.setParameter("email", email).getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aptech.repository.AccountRepository#save(com.aptech.model.Account)
	 */
	@Override
	public Account save(Account account) {

		if (account.getId() == null) {
			em.persist(account);
			em.flush();
		} else {
			em.merge(account);
		}

		return account;

	}

}
