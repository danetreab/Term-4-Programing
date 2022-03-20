CREATE TABLE category(
    id INT NOT NULL AUTO_INCREMENT,
    categoryname VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
-- @BLOCK
INSERT INTO category(categoryname,status)
VALUE("PHP","ACTIVE");
-- @BLOCK
SELECT * FROM category;