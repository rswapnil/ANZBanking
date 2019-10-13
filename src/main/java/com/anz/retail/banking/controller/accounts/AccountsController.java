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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Handles all account related requests
 *
 */
@RestController
@RequestMapping("/user")
@Api(value = "User Account list and transactions REST Endpoint", description="User Account list and transactions REST Endpoint")
public class AccountsController {
	
	@Autowired
	private IAccountsService service;
	
	/**
	 * Fetches all User Accounts by userId from accounts table
	 * Account Balances are fetched from balance table
	 * Calculation of Balances (outside of scope) ideally should be handled when a new transaction is added in transaction table
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "View Account List API", 
				  notes = "A user will be presented with a list of their accounts in a table, with the basic account attributes "
				  		+ "on display (Account Number, Account Name, Account Type, Balance Data, Currency, Opening Available Balance)")
    @GetMapping("/{userId}/accounts")
    public ResponseEntity<Response<List<Account>>> getUserAccounts(
    															   @ApiParam(value = "Userid of User for which we need to view Account List", required = true, example = "1") 
    															   @PathVariable("userId") Long userId) {
    	if (userId == null) {
    		return ResponseEntity.badRequest().build();
    	}
        return ResponseEntity.ok(service.getUserAccounts(userId));
    }
	
	/**
	 * Fetches Transactions for a given User Account 
	 * @param userId
	 * @param accountId
	 * @return
	 */
	@ApiOperation(value = "View User Account Transactions API", 
			  notes = "Upon selecting an account, a user will be presented with a list of transactions made on the selected account")
    @GetMapping("/{userId}/account/{accountId}/transactions")
    public ResponseEntity<Response<List<Transaction>>> getUserAccountTransactions(
    		@ApiParam(value = "UserId of User for which we need to view Account Transactions", required = true, example = "1") 
    		@PathVariable("userId") Long userId, 
    		@ApiParam(value = "AccountId of the User Account for which we need to view Account Transactions", required = true, example = "1") 
    		@PathVariable("accountId") Long accountId) {
    	if (userId == null || accountId == null) {
    		return ResponseEntity.badRequest().build();
    	}
        return ResponseEntity.ok(service.getUserAccountTransactions(userId, accountId));
    }
	
}
