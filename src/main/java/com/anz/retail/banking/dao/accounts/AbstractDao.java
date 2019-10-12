package com.anz.retail.banking.dao.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AbstractDao {
	
    @Autowired
    protected JdbcTemplate jdbcTemplate;	

}
