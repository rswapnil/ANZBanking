package com.anz.retail.banking.dao.accounts;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Repository;

import com.anz.retail.banking.dto.accounts.Account;
import com.anz.retail.banking.dto.transactions.Transaction;

@Repository
public class AccountsDao extends AbstractDao implements IAccountsDao {
	
	private static final String GET_USER_ACCOUNTS_FOR_USER_ID = new StringBuilder()
			.append(" select a.account_id, a.account_number, a.account_name, a.account_type, b.balance_date, a.account_currency, b.available_balance")
			.append("   from accounts a, balance b")
			.append("  where a.account_id = b.account_id ")
			.append("    and a.user_id = ? ")
			.toString();

	private static final String GET_USER_ACCOUNT_TRANSACTIONS_FOR_ACCOUNT_ID = new StringBuilder()
			.append(" select a.account_number, a.account_name, t.value_date, a.account_currency, t.amount, ")
			.append("        t.debit_or_credit, t.trans_narrative")
			.append("   from users u, accounts a, transactions t ")
			.append("  where u.user_id = a.user_id ")
			.append("    and a.account_id = t.account_id ")
			.append("    and u.user_id = ? ")
			.append("    and a.account_id = ? ")
			.toString();	
	
	private static final String INVALID_USER = new StringBuilder()
			.append(" select count(*) from users where user_id = ? ")
			.toString();
	
	private static final String INVALID_ACCOUNT = new StringBuilder()
			.append(" select count(*) from accounts where account_id = ? ")
			.toString();
	
	private static final DateFormat FORMAT_1 = new SimpleDateFormat("MM/dd/yyyy");

	private static final DateFormat FORMAT_2 = new SimpleDateFormat("MMM dd, yyyy");
	
    private static final NumberFormat CURRENCY = NumberFormat.getCurrencyInstance(Locale.US);
	
	@Override
	public List<Account> getUserAccountsForUserId(Long userId) {
		
		return jdbcTemplate.query(GET_USER_ACCOUNTS_FOR_USER_ID, 
			   (rs, rowNum) ->
        			new Account(
        				rs.getLong("account_id"),
        				rs.getString("account_number"),
        				rs.getString("account_name"),
        				rs.getString("account_type"),
        				FORMAT_1.format(rs.getDate("balance_date")),
        				rs.getString("account_currency"),
        				CURRENCY.format(rs.getBigDecimal("available_balance"))
        			    ), 
        		userId);
	}

	@Override
	public List<Transaction> getUserAccountTransactionsForAccountId(Long userId, Long accountId) {
		return jdbcTemplate.query(GET_USER_ACCOUNT_TRANSACTIONS_FOR_ACCOUNT_ID, 
				   (rs, rowNum) ->
	        			new Transaction(
	        				rs.getString("account_number"),
	        				rs.getString("account_name"),
	        				FORMAT_2.format(rs.getDate("value_date")),
	        				rs.getString("account_currency"),
	        				"D".equals(rs.getString("debit_or_credit")) ? CURRENCY.format(rs.getBigDecimal("amount")) : null,
	        				"C".equals(rs.getString("debit_or_credit")) ? CURRENCY.format(rs.getBigDecimal("amount")) : null,
	        				"C".equals(rs.getString("debit_or_credit")) ? "Credit" : "Debit",
	        				rs.getString("trans_narrative")
	        			 ), 
	        		userId, accountId);
	}

	@Override
	public boolean isInvalidUserId(Long userId) {
		return jdbcTemplate.queryForObject(INVALID_USER, new Object[] {userId}, Integer.class) <= 0;
	}

	@Override
	public boolean isInvalidAccountId(Long accountId) {
		return jdbcTemplate.queryForObject(INVALID_ACCOUNT, new Object[] {accountId}, Integer.class) <= 0;
	}
	
	

}
