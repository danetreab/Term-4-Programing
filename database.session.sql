-- @BLOCK
CREATE TABLE usercredential(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
-- @BLOCK
INSERT INTO usercredential(username,password)
VALUE("Jocker","768b84ef05f655d57fe22d488451f075365f6cd18a13073466aa826cc0ebdbfb");
-- @BLOCK
DELETE FROM usercredential where id=1;
-- @BLOCK
DROP TABLE usercredential;
-- @BLOCK
SELECT * FROM usercredential;
-- @BLOCK
SELECT username FROM usercredential;
-- @BLOCK
ALTER TABLE usercredential MODIFY COLUMN password VARCHAR(255);
-- @BLOCK
SHOW TABLES;
-- @BLOCK
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
CREATE TABLE author(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(255),
    PRIMARY KEY (id)
);

-- @BLOCK
CREATE TABLE publisher(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(255),
    PRIMARY KEY (id)
);

-- @BLOCK
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
CREATE TABLE member(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(255),
    PRIMARY KEY (id)
);

-- @BLOCK
CREATE TABLE lendbook(
    id INT NOT NULL AUTO_INCREMENT,
    memberid INT NOT NULL,
    bookid INT NOT NULL,
    issuedate DATE NOT NULL,
    returndate DATE NOT NULL,
    PRIMARY KEY (id)
);
-- @BLOCK
INSERT INTO member(name)
VALUE("Jack-Ma");
-- @BLOCK
SELECT * FROM author;
-- @BLOCK
DESCRIBE category;
-- @BLOCK
DELETE FROM category WHERE id in(19);

-- @BLOCK
SHOW TABLES;
-- @BLOCK
SELECT * FROM author;
-- @BLOCK
insert into author (name,address,phone) VALUE("Stephen King","None","None"),("Dr.Seuss","None","None"),("Spider","New york","None"),("Leonado da vinci","None","None"),("Sophocles","None","None"),("J.K Rowling","None","None"),("J.D Salinger","India","None"),("Victor Hugo","Paris","None");

-- @BLOCK
insert into author(name,address,phone) VALUE("Patty McCord","None","None"),("Sophie jaff","Rome","None"),("Dr.Strang","Mcu","None"),("Petter Parker","New york","none"),("Elon musk","None","None");

-- @BLOCK
DESCRIBE book;
-- @BLOCK
insert into book(bookname,author,publisher,contents,pages,edition) VALUE("Holes","Patty McCord","None","None","100","1");
-- @BLOCK
select * from book;
-- @BLOCK
select Count(bookname) from book;