-- @BLOCK
CREATE TABLE usercredential(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);
-- @BLOCK
INSERT INTO usercredential(username,password)
VALUE("hello",168);

-- @BLOCK
DROP TABLE usercredential;