-- @BLOCk
CREATE TABLE returnbook(
    id INT NOT NULL AUTO_INCREMENT,
    mid INT NOT NULL,
    mname VARCHAR(255),
    bname VARCHAR(255),
    returndate DATE,
    dayselip INT,
    fine INT,
    PRIMARY KEY (id)
);
-- @BLOCK
INSERT INTO returnbook(mid,mname,bname,returndate,dayselip,fine) VALUE (2,"Jonh","Powerful","2020-10-09",1,10);
-- @BLOCK
select * FROM returnbook;