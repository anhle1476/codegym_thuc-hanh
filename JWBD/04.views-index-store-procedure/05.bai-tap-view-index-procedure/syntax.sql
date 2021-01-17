-- B1: Tạo cơ sở dữ liệu demo
CREATE DATABASE demo;

USE demo;

-- B2: Tạo bảng Products với các trường dữ liệu...
CREATE TABLE products(
	id INT PRIMARY KEY AUTO_INCREMENT,
    product_code INT,
    product_name VARCHAR(50),
    product_price FLOAT,
    product_amount INT,
    product_description VARCHAR(255),
    product_status VARCHAR(50)
);

INSERT INTO products(product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES (2349, 'A', 10, 100, 'product A', 'selling'),
(2345, 'b', 11, 1100, 'product b', 'selling'),
(3462, 'c', 14, 1400, 'product c', 'selling'),
(6423, 'd', 111, 200, 'product d', 'discount'),
(6023, 'e', 100, 600, 'product e', 'selling'),
(9560, 'f', 93, 700, 'product f', 'discount'),
(2234, 'g', 23, 170, 'product g', 'selling');

-- B3: Tao & su dung index

ALTER TABLE products ADD UNIQUE INDEX productCodeIndex(product_code);
ALTER TABLE products ADD INDEX nameAndPriceIndex(product_name, product_price);

EXPLAIN SELECT * FROM products WHERE product_code = 2345;
EXPLAIN SELECT * FROM products WHERE product_name = 'f' AND product_price = 93;

-- B4: Tao & su dung view

CREATE VIEW productDetails AS
SELECT product_code, product_name, product_price, product_status
FROM products;

SELECT * FROM productDetails;

DROP VIEW productDetails;

-- B5: tao store procedure

DELIMITER //
CREATE PROCEDURE getAllDetails()
BEGIN
	SELECT * FROM products;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE addNewProduct(
	IN pr_code INT,
    IN pr_name VARCHAR(50),
    IN pr_price FLOAT,
    IN pr_amount INT,
    IN pr_description VARCHAR(255),
    IN pr_status VARCHAR(50)
)
BEGIN
	INSERT INTO products(product_code, product_name, product_price, product_amount, product_description, product_status)
	VALUES (pr_code, pr_name, pr_price, pr_amount, pr_description, pr_status);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE modifyProductById(
	IN pr_id INT,
	IN pr_code INT,
    IN pr_name VARCHAR(50),
    IN pr_price FLOAT,
    IN pr_amount INT,
    IN pr_description VARCHAR(255),
    IN pr_status VARCHAR(50)
)
BEGIN
	UPDATE products
	SET product_code = pr_code, 
    product_name = pr_name, 
    product_price = pr_price, 
    product_amount = pr_amount, 
    product_description = pr_description, 
    product_status = pr_status
    WHERE id = pr_id;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE deleteProductById(
	IN pr_id INT
)
BEGIN
	DELETE FROM products
    WHERE id = pr_id;
END //
DELIMITER ;

