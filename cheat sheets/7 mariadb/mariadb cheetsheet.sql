
-- oneline comment
/* multiline comment */

/* strings are enclosed in ' or " */

/*
PRIVILEGES & POLICIES
*/

/*
SCHEMAS
*/

/* show databases present */
SHOW DATABASES;
/* show tables in current db */
SHOW TABLES;
/* show tables in specified db with table type */
SHOW FULL TABLES IN randomDatabase;
/* show all functions in db */
SHOW FUNCTION STATUS;
/* show all procedures in db */
SHOW PROCEDURE STATUS;
/* show triggers for current database */
show triggers;

/* show ddl of object */
SHOW CREATE DATABASE randomDatabase;
SHOW CREATE TABLE orders;

DROP DATABASE IF EXISTS randomDatabase;
CREATE OR REPLACE DATABASE randomDatabase;
USE randomDatabase;

DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS persons;
CREATE OR REPLACE TABLE persons (
    PersonID INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    randomNumber INT
);

DROP TABLE IF EXISTS orders;
CREATE OR REPLACE TABLE orders (
    OrderID INT AUTO_INCREMENT,
    PersonID INT,
    OrderNumber INT NOT NULL DEFAULT 6,
    OrderContent VARCHAR(20),
    INDEX (OrderNumber),
    PRIMARY KEY (OrderID),
    FOREIGN KEY (PersonID) REFERENCES persons(PersonID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

/*
Moguće vrednosti za ON DELETE i ON UPDATE u definiciji stranog ključa
RESTRICT - Dolazi do greške ako postoji "dete record" roditelja koga pokušavamo da obrišemo/promenimo
CASCADE - "Dete record" se takođe briše/menja
SET NULL - Ako obrišemo roditelja, "dete record" dobija vrednost NULL u koloni koja referencira na roditelja
NO ACTION - Možemo da brišemo/menjamo roditeljski ID, bez da se bilo šta desi sa "dete record-om"
*/

-- indexes are used to speed up search, automatically created on primary indexes
CREATE OR REPLACE INDEX index_name_create ON randomDatabase.Persons (first_name);
DROP INDEX index_name_create ON randomDatabase.Persons;
CREATE OR REPLACE INDEX index_name_create ON randomDatabase.Persons (first_name);
ALTER TABLE randomDatabase.Persons DROP INDEX index_name_create;

/* alter table */
ALTER TABLE persons ADD COLUMN putnik VARCHAR(30);
ALTER TABLE persons MODIFY COLUMN putnik VARCHAR(35);
/* for changing position of column use alter with BEFORE / AFTER */
ALTER TABLE persons MODIFY COLUMN putnik varchar(35) AFTER PersonID;
ALTER TABLE persons DROP COLUMN putnik;

/* foreign key */
ALTER TABLE orders DROP FOREIGN KEY orders_ibfk_1;
ALTER TABLE orders ADD FOREIGN KEY (PersonID) REFERENCES Persons(PersonID);

/* insert */

INSERT INTO randomDatabase.persons
    (first_name, last_name, randomNumber)
VALUES
    ('pera', 'eric', 7),
    ('sav', 'los', 4),
    ('pera', 'zdera', 3),
    ('snesko', 'belic', 8),
    ('krenbil', 'stepanovic', 2);

INSERT INTO randomDatabase.orders
    (PersonID, OrderNumber, OrderContent)
VALUES
    ('1', '23', 'sema'),
    ('2', '33', 'puno'),
    ('3', '42', 'rito'),
    ('2', '99', 'sima'),
    ('4', '87', 'hama');

/* update */
UPDATE randomDatabase.persons
SET first_name = 'pera'
WHERE last_name = 'los';

/* delete */
DELETE FROM randomDatabase.orders
WHERE OrderNumber = 99;

-- clear all data from table - !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
TRUNCATE TABLE orders; -- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
DELETE FROM orders; -- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
INSERT INTO randomDatabase.orders
    (PersonID, OrderNumber, OrderContent)
VALUES
    ('1', '23', 'sema'),
    ('2', '33', 'puno'),
    ('3', '42', 'rito'),
    ('2', '99', 'sima'),
    ('4', '87', 'hama');

/*
SELECT
FROM
WHERE
GROUP BY
HAVING
ORDER BY
OFFSET/LIMIT
*/

SELECT * FROM persons;

/* aliases - as */
SELECT first_name AS glumac FROM persons;
SELECT first_name glumac FROM persons;

/* distinct */
SELECT DISTINCT first_name FROM persons;

/* limit/offset */
SELECT first_name, last_name FROM persons LIMIT 3;
/* offset definiše od kojeg unosa će baza započeti pretragu. preskoči 10, vrati 5. */
SELECT first_name, last_name FROM persons LIMIT 2, 5;

/* converts datatype to specified type */
SELECT CONVERT(first_name, CHAR) FROM persons;
SELECT CAST(first_name AS CHAR) FROM Persons;
SELECT CONVERT(randomNumber, DECIMAL(10,2)) FROM Persons;
SELECT CAST(randomNumber as DECIMAL(10,2)) FROM Persons;

/* dealing with null */
SELECT first_name, COALESCE(last_name, 'replacement value') FROM persons;
SELECT IFNULL(first_name, 'radi') FROM persons;

/* kompletan tekst, tekst koji želimo da izmenimo, novi tekst, works on numbers also */
SELECT REPLACE("moj tekst","moj", "Link");
/* returns left substring from point */
SELECT LEFT(first_name, 3) FROM persons;
SELECT LENGTH(first_name) FROM persons;
SELECT CHAR_LENGTH(first_name) FROM persons;
SELECT CONCAT(first_name, ", ", last_name) FROM persons;
SELECT CONCAT_WS("-", first_name, last_name, randomNumber) FROM persons;
SELECT LOWER(first_name), UPPER(last_name) FROM persons;
SELECT LTRIM("     SQL ;)  Vežbe     "), RTRIM("     SQL ;)  Vežbe     ");

/* basic math functions */

/* math functions */

/* case */

/* if */

SELECT NOW();
SELECT CURRENT_TIMESTAMP();
SELECT CURDATE();
SELECT CURTIME();

SELECT DATE_FORMAT(NOW(),'Datum: %d-%Y-%m');
SELECT DATE_ADD(NOW(), INTERVAL 10 DAY);

/* select in with - complex select */

/* where */
SELECT * FROM randomDatabase.persons WHERE PersonID <> 1 AND first_name != 'NICK';
SELECT * FROM persons WHERE PersonID = 4 OR randomNumber >= 5;
SELECT * FROM persons WHERE PersonID NOT BETWEEN 10 AND 20;
SELECT * FROM persons WHERE PersonID IN (1,3,53,23);
SELECT * FROM persons WHERE PersonID NOT IN (1,3,53,23);

/* like */
/* percentage % matches any string of zero or more characters */
SELECT * FROM persons WHERE first_name LIKE '%NN%';
/* underscore _ wildcard matches any single character */
SELECT * FROM persons WHERE first_name NOT LIKE 'J_E';
/* backslash \ is default escape character */
SELECT * FROM persons WHERE first_name LIKE '\_pera';

/* agragate/group/having */
SELECT SUM(randomNumber) FROM persons;
SELECT COUNT(randomNumber) FROM persons;
SELECT AVG(randomNumber) FROM persons;
SELECT MAX(randomNumber) FROM persons;
SELECT MIN(randomNumber) FROM persons;
SELECT ROUND(AVG(randomNumber), 2) FROM persons;
SELECT *, COUNT(*) FROM persons GROUP BY first_name;
SELECT *, COUNT(*) FROM persons GROUP BY first_name HAVING COUNT(*) > 1;

/* ordering */
SELECT * FROM persons ORDER BY first_name ASC, last_name DESC;

/* joins */

SELECT *
FROM persons
    INNER JOIN orders ON persons.personid = orders.personid;

SELECT *
FROM persons
    LEFT OUTER JOIN orders ON persons.personid = orders.personid;

SELECT *
FROM persons
    RIGHT OUTER JOIN orders ON persons.personid = orders.personid;

SELECT *
FROM persons
    CROSS JOIN orders ON persons.personid = orders.personid;

/* self join */

/* unions */

SELECT *
FROM persons
    INNER JOIN orders ON persons.personid = orders.personid
UNION
SELECT *
FROM persons
    LEFT JOIN orders ON persons.personid = orders.personid;

SELECT *
FROM persons
    INNER JOIN orders ON persons.personid = orders.personid
UNION ALL
SELECT *
FROM persons
    LEFT JOIN orders ON persons.personid = orders.personid;

-- sub queries

/* nested select in where */
SELECT * FROM persons WHERE first_name IN (SELECT first_name FROM persons);

/* nested select in from */

/* exists */
/* any */
/* all */
/* some */

/* views */
CREATE VIEW vieww AS SELECT * FROM persons;
CREATE OR REPLACE VIEW vieww AS SELECT * FROM persons;
ALTER VIEW vieww AS SELECT * FROM persons;
SELECT * FROM vieww;
DROP VIEW vieww;

/* case */

/* if */

/* select in with from postgresql - complex select */

/* functions */

/* procedures */

/* triggers */

/* cursors */

/*
execution control:
BEGIN or BEGIN TRANSACTION;
COMMIT or COMMIT TRANSACTION;
SAVEPOINT my_savepoint;
ROLLBACK or ROLLBACK TRANSACTION;
ROLLBACK TO my_savepoint;
*/
