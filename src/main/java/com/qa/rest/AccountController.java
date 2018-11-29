package com.qa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.business.AccountService;
import com.qa.persistence.domain.Account;

@RestController
@CrossOrigin
public class AccountController {

	@Autowired
	public AccountService service;

	@CrossOrigin
	@RequestMapping("/addAccountGen/{firstName}/{lastName}")

	public Account addAccountGen(@PathVariable String firstName,@PathVariable String lastName) {
		Account result = service.addAccountGen();
		result.setFirstName(firstName);
		result.setLastName(lastName);
		return result;
	}

	@CrossOrigin
	@RequestMapping("/getPrize")

	public String getPrizeGen(@RequestBody Account account) {
		return service.getPrizeGen(account);
	}

}
