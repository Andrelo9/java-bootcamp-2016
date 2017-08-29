CREATE DATABASE IF NOT EXISTS shopping_cart;
USE shopping_cart;

CREATE SCHEMA IF NOT EXISTS shoppingcart;

CREATE TABLE IF NOT EXISTS product(
	product_id INT NOT NULL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    product_category VARCHAR(255) NOT NULL,
    product_price FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS customer(
	customer_id INT NOT NULL PRIMARY KEY,
    customer_nickname VARCHAR(255) NOT NULL,
    customer_firstname VARCHAR(255) NOT NULL,
    customer_lastname VARCHAR(255) NOT NULL,
	customer_password VARCHAR(255) NOT NULL,
    customer_email VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS shoppingcart(   
	cart_id INT NOT NULL PRIMARY KEY,
    cartcustomer_id INT NOT NULL    
);

CREATE TABLE IF NOT EXISTS cartitem(
	cartitem_id INT NOT NULL PRIMARY KEY,
    cartitemproduct_id INT,
    cartitemproduct_quantity INT,
    CONSTRAINT cartcustomer_fk FOREIGN KEY (cartitem_id) REFERENCES shoppingcart(cart_id)
);

CREATE TABLE IF NOT EXISTS customerwallet(
	wallet_id INT NOT NULL PRIMARY KEY,
    customerwallet_id INT NOT NULL,
    amount FLOAT NOT NULL,
    CONSTRAINT customerwallet_fk FOREIGN KEY (customerwallet_id) REFERENCES customer(customer_id)
);