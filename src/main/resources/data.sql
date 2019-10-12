DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id INT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

INSERT INTO users (user_id, first_name, last_name, email) VALUES
  (1, 'Swapnil', 'R', 'swapnil@anz.com'),
  (2, 'Bob', 'G', 'bob@microsoft.com'),
  (3, 'John', 'A', 'john@gmail.com');
 
 
CREATE TABLE accounts (
  account_id INT PRIMARY KEY,
  user_id INT NOT NULL,
   account_number VARCHAR(250) NOT NULL,
   account_name VARCHAR(250) NOT NULL,
  account_type VARCHAR(250) NOT NULL,
  account_currency VARCHAR(250) NOT NULL,
  foreign key (user_id) references users(user_id)
);

 
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
 
INSERT INTO transactions (account_id,value_date,currency, amount, debit_or_credit,trans_narrative) VALUES
 (1,CURRENT_DATE(),'SGD',9540.98,'C',''),
 (1,CURRENT_DATE(),'SGD',7497.82,'C',''), 
 (1,CURRENT_DATE(),'SGD',5564.79,'C',''),
 (1,CURRENT_DATE(),'SGD',8136.19,'C','');
  
  
CREATE TABLE balance (
  balance_id INT AUTO_INCREMENT  PRIMARY KEY,
  account_id INT NOT NULL,  
  balance_date DATE NOT NULL,
  available_balance DECIMAL(20, 2) NOT NULL,
  foreign key (account_id) references accounts(account_id)    
);
  
  
INSERT INTO balance (balance_date, available_balance, account_id) VALUES
 (CURRENT_DATE(),19540.98, 1),
 (CURRENT_DATE(),29540.98, 2),
 (CURRENT_DATE(),39540.98, 3),
 (CURRENT_DATE(),49540.98, 4),
 (CURRENT_DATE(),59540.98, 5),
 (CURRENT_DATE(),69540.98, 6),
 (CURRENT_DATE(),99540.98, 7),
 (CURRENT_DATE(),89540.98, 8),
 (CURRENT_DATE(),79540.98, 9);  
  
  