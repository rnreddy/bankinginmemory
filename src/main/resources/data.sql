-- Insert Customers
INSERT INTO customer (customer_id, first_name, last_name, email, phone, account_id, street, city, state, zip_code, country)
VALUES 
('CUST001', 'John', 'Doe', 'john.doe@example.com', '1234567890', 'ACC001', '123 Elm Street', 'Springfield', 'IL', '62701', 'USA'),
('CUST002', 'Jane', 'Smith', 'jane.smith@example.com', '9876543210', 'ACC002', '456 Oak Avenue', 'Madison', 'WI', '53703', 'USA'),
('CUST003', 'Narasimha', 'reddy', 'test@example.com', '9876543210', 'ACC002', '456 Oak Avenue', 'Madison', 'WI', '53703', 'USA');
 ;

-- Insert Transactions
INSERT INTO transactions (transaction_id, account_id, date, type, amount, description, currency)
VALUES 
('TXN001', 'ACC001', '2024-06-01', 'DEBIT', 150.75, 'Grocery shopping', 'USD'),
('TXN002', 'ACC001', '2024-06-02', 'CREDIT', 500.00, 'Salary deposit', 'USD'),
('TXN003', 'ACC002', '2024-06-03', 'DEBIT', 75.25, 'Utility bill', 'USD');
