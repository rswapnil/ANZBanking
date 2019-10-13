package com.anz.retail.banking.controller.accounts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.anz.retail.banking.dto.Response;
import com.anz.retail.banking.dto.accounts.Account;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountsControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testGetUserAccountsValidUser() {
		Response<List<Account>> response = restTemplate.getForObject("http://localhost:" + port + "/anz/user/1/accounts/", 
				Response.class);
				
		assertNotNull("Accounts List must not be null", response.getData());
		assertEquals("Size must be 3", 3, response.getData().size());
		assertEquals("Size must be 3", 6, response.getHeaders().size());
	}

	@Test
	public void testGetUserAccountsInValidUser() {
		Response<List<Account>> response = restTemplate.getForObject("http://localhost:" + port + "/anz/user/0/accounts/", 
				Response.class);
				
		assertNull("Accounts List must be null", response.getData());
		assertEquals("Validation Error must be set", "Invalid UserId", response.getValidation());
	}

	@Test
	public void testGetUserAccountTransactionsValidAccount() {
		Response<List<Account>> response = restTemplate.getForObject("http://localhost:" + port + "/anz/user/1/account/1/transactions", 
				Response.class);
				
		assertNotNull("Account Transactions List must not be null", response.getData());
		assertEquals("Size must be 3", 4, response.getData().size());
		assertEquals("Size must be 3", 9, response.getHeaders().size());
	}

	@Test
	public void testGetUserAccountTransactionsInvalidAccount() {
		Response<List<Account>> response = restTemplate.getForObject("http://localhost:" + port + "/anz/user/1/account/0/transactions", 
				Response.class);
				
		assertNull("Account Transactions List must be null", response.getData());
		assertEquals("Validation Error must be set", "Invalid AccountId", response.getValidation());
	}

}
