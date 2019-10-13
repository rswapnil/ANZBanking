package com.anz.retail.banking.dao.accounts;

import java.util.List;

import com.anz.retail.banking.dto.accounts.Account;
import com.anz.retail.banking.dto.transactions.Transaction;

public interface IAccountsDao {

	List<Account> getUserAccountsForUserId(Long userId);

	List<Transaction> getUserAccountTransactionsForAccountId(Long userId, Long accountId);

	boolean isInvalidUserId(Long userId);

	boolean isInvalidAccountId(Long accountId);

}
