-- @BLOCK
CREATE TABLE usercredential(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
-- @BLOCK
INSERT INTO usercredential(username,password)
VALUE("hello","80c3cd40fa35f9088b8741bd8be6153de05f661cfeeb4625ffbf5f4a6c3c02c4");
-- @BLOCK
DELETE FROM usercredential where id=1;
-- @BLOCK
DROP TABLE usercredential;
-- @BLOCK
SELECT * FROM usercredential;
-- @BLOCK
ALTER TABLE usercredential MODIFY COLUMN password VARCHAR(255);