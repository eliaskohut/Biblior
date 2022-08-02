CREATE TABLE IF NOT EXISTS USERS (
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    ROLE VARCHAR(15) NOT NULL,
    DTYPE VARCHAR(15) NOT NULL,
    FIRST_NAME VARCHAR(30) NOT NULL,
    LAST_NAME VARCHAR(30) NOT NULL,
    EMAIL VARCHAR(30) NOT NULL UNIQUE,
    PASSWORD VARCHAR(61) NOT NULL,
    FAILED_BORROWS INT NOT NULL
);
CREATE TABLE IF NOT EXISTS PRINTED (
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    DTYPE VARCHAR(10) NOT NULL,
    PRINTED_TYPE VARCHAR(10) NOT NULL,
    TITLE VARCHAR(30) NOT NULL,
    AUTHOR VARCHAR(30) NOT NULL,
    YEAR_OF_PUBLICATION INT NOT NULL,
    PAGES INT NOT NULL,
    FEE_PRICE DOUBLE PRECISION NOT NULL,
    FIELD VARCHAR2(30),
    GENRE VARCHAR2(20),
    COUNTRY VARCHAR2(20),
    QUANTITY INT NOT NULL
);

CREATE TABLE IF NOT EXISTS user_borrows (
    USER_ID BIGINT NOT NULL,
    PRINTED_ID BIGINT NOT NULL,
    PRIMARY KEY (USER_ID,PRINTED_ID),
    CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES USERS (ID),
    CONSTRAINT FK_PRINTED_ID FOREIGN KEY (PRINTED_ID) REFERENCES PRINTED (ID),
    START_DATE DATE NOT NULL,
    CLOSE_DATE DATE NOT NULL
);