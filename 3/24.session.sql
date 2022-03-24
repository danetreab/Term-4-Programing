CREATE TABLE book(
    id INT NOT NULL AUTO_INCREMENT,
    bookname VARCHAR(255) NOT NULL,
    author INT,
    publisher INT,
    contents VARCHAR(255),
    pages INT,
    edition INT,
    PRIMARY KEY (id)
);
-- @BLOCK
SHOW TABLES;
-- @BLOCK
DROP TABLE book;
-- @BLOCK
INSERT INTO book() VALUE ();
-- @BLOCK
SELECT * FROM book;
-- @BLOCK
-- @BLOCK
-- @BLOCK
-- @BLOCK
-- @BLOCK
-- @BLOCK