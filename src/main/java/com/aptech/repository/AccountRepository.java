package com.aptech.repository;

import com.aptech.model.Account;

public interface AccountRepository {

	Account findAccount(String email);

	Account save(Account account);

}