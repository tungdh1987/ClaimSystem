package com.aptech.service;

import com.aptech.model.Account;

public interface AccountService {

	boolean checkAccountExist(Account account);

	Account findAccount(String email);

	Account save(Account account);

}