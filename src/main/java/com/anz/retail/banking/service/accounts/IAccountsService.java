package com.anz.retail.banking.service.accounts;

import java.util.List;

import com.anz.retail.banking.dto.Response;
import com.anz.retail.banking.dto.accounts.Account;
import com.anz.retail.banking.dto.transactions.Transaction;

public interface IAccountsService {

	Response<List<Account>> getUserAccounts(Long userId);

	Response<List<Transaction>> getUserAccountTransactions(Long userId, Long accountId);

}
