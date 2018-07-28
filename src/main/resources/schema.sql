drop table drink;

CREATE TABLE IF NOT EXISTS drink (
  DRINK_ID INT NOT NULL,
  DRINK_NAME VARCHAR(45) NOT NULL,
  PRICE INT NOT NULL,
  PRIMARY KEY (DRINK_ID),
  UNIQUE INDEX DRINK_ID_UNIQUE (DRINK_ID ASC));
