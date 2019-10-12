package com.anz.retail.banking.service.accounts;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.retail.banking.dao.accounts.IAccountsDao;
import com.anz.retail.banking.dto.Header;
import com.anz.retail.banking.dto.Response;
import com.anz.retail.banking.dto.accounts.Account;
import com.anz.retail.banking.dto.transactions.Transaction;

@Service	
public class AccountsService implements IAccountsService {
	
	// TODO fetch from DB
	private static final List<Header> ACCOUNT_LIST_HEADERS = 
				Stream.of(new Header("number", "Account Number", 1),
								  new Header("name", "Account Name", 2), 
								  new Header("type", "Account Type", 3),
								  new Header("balanceDate", "Balance Date", 4), 
								  new Header("currency", "Currency", 5),
								  new Header("openingBalance", "Opening Available Balance", 6))
				.collect(Collectors.toList());
	
	// TODO fetch from DB
	private static final List<Header> ACCOUNT_TRANSACTION_HEADERS = 
			Stream.of(new Header("accountNumber", "Account Number", 1),
							  new Header("accountName", "Account Name", 2), 
							  new Header("type", "Account Type", 3),
							  new Header("valueDate", "Value Date", 4), 
							  new Header("currency", "Currency", 5),
							  new Header("debitAmount", "Debit Amount", 6),
							  new Header("creditAmout", "Credit Amount", 7),
							  new Header("debitOrCredit", "Debit/Credit", 8),
							  new Header("transactionNarrative", "Transaction Narrative", 9))
			.collect(Collectors.toList());

	private static final Logger logger = LoggerFactory.getLogger(AccountsService.class);
	
	@Autowired
	private IAccountsDao accountsDao;

	@Override
	public Response<List<Account>> getUserAccounts(Long userId) {
		
		Response<List<Account>> response = new Response<>();
		
		try {
			
			if (userId <= 0) {
				logger.info("Invalid UserId");
				response.setValidation("Invalid UserId");
				return response;
			}
			
			response.setData(accountsDao.getUserAccountsForUserId(userId));
			response.setHeaders(ACCOUNT_LIST_HEADERS);
			
		} catch (Exception e) {
			logger.error("Error getting User Accounts for userId: " + userId, e);
			response.setError("Error getting User Accounts for userId: " + userId);
		}
		
		return response;
	}

	@Override
	public Response<List<Transaction>> getUserAccountTransactions(Long accountId) {
		Response<List<Transaction>> response = new Response<>();
		
		try {
			
			if (accountId <= 0) {
				logger.info("Invalid AccountId");
				response.setValidation("Invalid AccountId");
				return response;
			}
			
			response.setData(accountsDao.getUserAccountTransactionsForAccountId(accountId));
			response.setHeaders(ACCOUNT_TRANSACTION_HEADERS);

			
		} catch (Exception e) {
			logger.error("Error getting User Account Transactions for accountId: " + accountId, e);
			response.setError("Error getting User Account Transactions for accountId: " + accountId);
		}
		
		return response;
	}

}
