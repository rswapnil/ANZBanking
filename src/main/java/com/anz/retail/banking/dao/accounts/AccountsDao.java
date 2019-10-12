package com.anz.retail.banking.dao.accounts;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anz.retail.banking.dto.accounts.Account;
import com.anz.retail.banking.dto.transactions.Transaction;

@Repository
public class AccountsDao extends AbstractDao implements IAccountsDao {
	
	private static final String GET_USER_ACCOUNTS_FOR_USER_ID = new StringBuilder()
			.append(" select a.account_number, a.account_name, a.account_type, b.balance_date, a.account_currency, b.available_balance")
			.append("   from accounts a, balance b")
			.append("  where a.account_id = b.account_id ")
			.append("    and a.user_id = ? ")
			.toString();

	private static final String GET_USER_ACCOUNT_TRANSACTIONS_FOR_ACCOUNT_ID = new StringBuilder()
			.append(" select a.account_number, a.account_name, t.value_date, a.account_currency, t.amount, ")
			.append("        t.debit_or_credit, t.trans_narrative")
			.append("   from accounts a, transactions t ")
			.append("  where a.account_id = t.account_id ")
			.append("    and a.account_id = ? ")
			.toString();	
	
	@Override
	public List<Account> getUserAccountsForUserId(Long userId) {
		
		return jdbcTemplate.query(GET_USER_ACCOUNTS_FOR_USER_ID, 
			   (rs, rowNum) ->
        			new Account(
        				rs.getString("account_number"),
        				rs.getString("account_name"),
        				rs.getString("account_type"),
        				rs.getString("balance_date"),
        				rs.getString("account_currency"),
        				rs.getString("available_balance")
        			    ), 
        		userId);
	}

	@Override
	public List<Transaction> getUserAccountTransactionsForAccountId(Long accountId) {
		return jdbcTemplate.query(GET_USER_ACCOUNT_TRANSACTIONS_FOR_ACCOUNT_ID, 
				   (rs, rowNum) ->
	        			new Transaction(
	        				rs.getString("account_number"),
	        				rs.getString("account_name"),
	        				rs.getString("value_date"),
	        				rs.getString("account_currency"),
	        				"D".equals(rs.getString("debit_or_credit")) ? rs.getString("amount") : null,
	        				"C".equals(rs.getString("debit_or_credit")) ? rs.getString("amount") : null,
	        				"C".equals(rs.getString("debit_or_credit")) ? "Credit" : "Debit",
	        				rs.getString("trans_narrative")
	        			 ), 
	        		accountId);
	}
	
	

}
