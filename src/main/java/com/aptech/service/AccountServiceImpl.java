package com.aptech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptech.model.Account;
import com.aptech.repository.AccountRepository;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aptech.service.AccountService#checkAccountExist(com.aptech.model.
	 * Account)
	 */
	@Override
	public boolean checkAccountExist(Account account) {

		Account ac = findAccount(account.getEmail());

		return (ac != null && account.getPassword().equals(
				ac.getPassword().toUpperCase())) ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aptech.service.AccountService#findAccount(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Account findAccount(String email) {
		return accountRepository.findAccount(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aptech.repository.AccountRepository#save(com.aptech.model.Account)
	 */
	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}
}
