package com.qa.business;

import com.qa.persistence.domain.Account;

public interface IAccountService {

	public String getPrizeGen(Account account);

	public Account addAccountGen();

}
