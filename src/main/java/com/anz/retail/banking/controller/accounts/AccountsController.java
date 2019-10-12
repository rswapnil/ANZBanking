package com.anz.retail.banking.controller.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.retail.banking.dto.Response;
import com.anz.retail.banking.dto.accounts.Account;
import com.anz.retail.banking.dto.transactions.Transaction;
import com.anz.retail.banking.service.accounts.IAccountsService;

/**
 * Handles all account related requests
 *
 */
@RestController
@RequestMapping("/accounts")
public class AccountsController {
	
	@Autowired
	private IAccountsService service;
	
    @GetMapping("/{userId}")
    public ResponseEntity<Response<List<Account>>> getUserAccounts(@PathVariable("userId") Long userId) {
    	if (userId == null) {
    		return ResponseEntity.badRequest().build();
    	}
        return ResponseEntity.ok(service.getUserAccounts(userId));
    }
	
    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<Response<List<Transaction>>> getUserAccountTransactions(@PathVariable("accountId") Long accountId) {
    	if (accountId == null) {
    		return ResponseEntity.badRequest().build();
    	}
        return ResponseEntity.ok(service.getUserAccountTransactions(accountId));
    }
	
}
