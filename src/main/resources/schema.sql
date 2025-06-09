-- schema.sql

CREATE TABLE customer (
    customer_id VARCHAR(50) PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20),
    account_id VARCHAR(50),
    street VARCHAR(150),
    city VARCHAR(100),
    state VARCHAR(100),
    zip_code VARCHAR(20),
    country VARCHAR(100)
);

CREATE TABLE transactions (
    transaction_id VARCHAR(50) PRIMARY KEY,
    account_id VARCHAR(50),
    date DATE,
    type VARCHAR(20),
    amount DOUBLE,
    description VARCHAR(255),
    currency VARCHAR(10)
);
