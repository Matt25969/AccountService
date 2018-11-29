package com.qa.business;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.endpoint.JmsMessageEndpointManager;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.IAccountRepo;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepo accountRepo;

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private RestTemplate rt;

	public Account addAccountGen() {

		Account account = new Account();

		String prefix = rt.getForObject("http://localhost:8082/getLetter", String.class);
		String suffix = rt.getForObject("http://localhost:8081/getNumber", String.class);

		account.setAccountNumber(prefix + suffix);

		return accountRepo.save(account);
	}

	public String getPrizeGen(Account account) {
		String result = rt.getForObject("http://localhost:8083/getPrize/" + account.getAccountNumber(), String.class);
		
		com.qa.transfer.DTO.Account accountToSend = new com.qa.transfer.DTO.Account();
		accountToSend.setAccountID(1);
		accountToSend.setAccountNumber(account.getAccountNumber());
		accountToSend.setFirstName(account.getFirstName());
		accountToSend.setLastName(account.getLastName());
		accountToSend.setPrize(result);
		
		jmsTemplate.convertAndSend("AccountQueue", accountToSend);
		
		return result;
	}

}
