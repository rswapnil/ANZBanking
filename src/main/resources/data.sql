-- Users Table holds all application users

CREATE TABLE users (
  user_id INT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);


-- Creating Some Users for demo purpose
-- User Creation API is outside of scope  
INSERT INTO users (user_id, first_name, last_name, email) VALUES
  (1, 'Swapnil', 'R', 'swapnil@anz.com'),
  (2, 'Bob', 'G', 'bob@microsoft.com'),
  (3, 'John', 'A', 'john@gmail.com');
 

-- Accounts table holds all user accounts details 
-- 1 User can have Multiple Accounts 
CREATE TABLE accounts (
  account_id INT PRIMARY KEY,
  user_id INT NOT NULL,
   account_number VARCHAR(250) NOT NULL,
   account_name VARCHAR(250) NOT NULL,
  account_type VARCHAR(250) NOT NULL,
  account_currency VARCHAR(250) NOT NULL,
  foreign key (user_id) references users(user_id)
);

-- Creating some user accounts for demo purpose
-- Account Creation API is outside of scope  
INSERT INTO accounts (account_id,account_number,account_name, account_type, account_currency,user_id) VALUES
  (1,'585309209','SGSavings726','Savings','SGD',1),
  (2,'7910666','AUSavings933','Savings','AUD',2),
  (3,'321143048','AUCurrent433','Current','AUD',3),
  (4,'585309201','SGSavings123','Savings','SGD',1),
  (5,'79106661','AUSavings123','Savings','AUD',2),
  (6,'321143041','AUCurrent123','Current','AUD',3),
  (7,'321143042','AUCurrent222','Current','AUD',1),
  (8,'585309202','SGSavings222','Savings','SGD',2),
  (9,'79106662','AUSavings222','Savings','AUD',3);
 
 
 
-- Transactions table holds all User Account Transactions 
-- 1 Account can have multiple transactions  
CREATE TABLE transactions (
  trans_id INT AUTO_INCREMENT  PRIMARY KEY,
  account_id INT NOT NULL,
  value_date DATE NOT NULL,
  currency VARCHAR(250) NOT NULL,
  amount VARCHAR(250) NOT NULL,
  debit_or_credit VARCHAR(1) NOT NULL,
  trans_narrative VARCHAR(250) DEFAULT NULL,
  foreign key (account_id) references accounts(account_id)  
);


-- Creating some user account transactions for demo purpose
-- User Account Transaction Creation API is outside of scope  
 
INSERT INTO transactions (account_id,value_date,currency, amount, debit_or_credit,trans_narrative) VALUES
 (1,CURRENT_DATE(),'SGD',100.00,'C',''),
 (1,CURRENT_DATE(),'SGD',100.00,'C',''), 
 (1,CURRENT_DATE(),'SGD',100.00,'C',''),
 (1,CURRENT_DATE(),'AUD',100.99,'C',''),
 (2,CURRENT_DATE(),'AUD',100.00,'C',''),
 (3,CURRENT_DATE(),'AUD',100.00,'C',''),
 (4,CURRENT_DATE(),'SGD',100.00,'C',''),
 (5,CURRENT_DATE(),'AUD',100.00,'C',''),
 (6,CURRENT_DATE(),'AUD',100.00,'C',''),
 (7,CURRENT_DATE(),'AUD',100.00,'C',''),
 (8,CURRENT_DATE(),'SGD',100.00,'C',''),
 (9,CURRENT_DATE(),'AUD',100.00,'C','');


-- balance table holds available balance for all user accounts
-- This balance is updated continuously throughout the day. 
-- Any transaction that takes place in the account affects this balance

CREATE TABLE balance (
  balance_id INT AUTO_INCREMENT  PRIMARY KEY,
  account_id INT NOT NULL,  
  balance_date DATE NOT NULL,
  available_balance DECIMAL(20, 2) NOT NULL,
  foreign key (account_id) references accounts(account_id)    
);
  

-- Calculation of Balance is outside of scope   
-- ideally the User Account Transaction Creation API (outside of scope) will also update the balance table
-- Creating some user account balances for demo purpose
  
INSERT INTO balance (balance_date, available_balance, account_id) VALUES
 (CURRENT_DATE(),400.99, 1),
 (CURRENT_DATE(),100.00, 2),
 (CURRENT_DATE(),100.00, 3),
 (CURRENT_DATE(),100.00, 4),
 (CURRENT_DATE(),100.00, 5),
 (CURRENT_DATE(),100.00, 6),
 (CURRENT_DATE(),100.00, 7),
 (CURRENT_DATE(),100.00, 8),
 (CURRENT_DATE(),100.00, 9);  
  
  