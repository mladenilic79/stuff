
/*
default db port 3306

install community version
	developer defaults option
	rest of settings left on default

start through cmd
	go to mysql exe location
	start server with password
		mysql.exe -u root -p
	start server without password
		mysql.exe -u root

cmd commands
	check server status with
		status
	show ways to store tables
		show engines;
	exit mysql
		exit
		quit
/*

/* default databases present are (with all meta data)
    information_schema
        returns all db on server */
        SELECT * FROM INFORMATION_SCHEMA.SCHEMATA
        /* returns all tables on server */
        SELECT * FROM INFORMATION_SCHEMA.TABLES
    /* performance_schema */

/* show isolation level */
SELECT @@TRANSACTION_ISOLATION
/* set transaction isolation level variant
(serializable, repeatable read, read commited i read uncommited) */
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
/* set global transaction isolation level */
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;

/* kill process id kills process in question */
KILL 43

# oneline comment
-- oneline comment
/* multiline comment */

/* strings are enclosed in ' or " */

/* write to screen */
SELECT 'ZDRAVO!' ;

/* check required parameters for password to pass validation */
SHOW VARIABLES LIKE 'validate_password%';
/* switch password policy levels 0, 1, 2 */
SET GLOBAL validate_password.policy = 0;

/* show all users, mysql.user must be smallcaps*/
SELECT * FROM mysql.user;
SELECT User, Host FROM mysql.user;
/* can access from specified location using password */
CREATE USER 'John'@'localhost' identified BY '123';
CREATE USER 'John'@'209.85.445.498' identified BY '123';
/* can access from any location */
CREATE USER 'John'@'%' identified BY '123';
/* alter & drop */
ALTER USER 'John'@'localhost' identified by 'ABC';
DROP USER 'John'@'localhost';

/* grants create and revoke and show from table or db */
GRANT SELECT ON sakila TO 'John'@'localhost';
GRANT SELECT, UPDATE, INSERT, DELETE ON '.' TO 'John'@'localhost';
GRANT ALL PRIVILEGES ON actor TO 'John'@'localhost'
/* revoke */
REVOKE SELECT, UPDATE, INSERT, DELETE FROM '.' TO 'John'@'localhost';
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'John'@'localhost';
/* show grants for specified user */
SHOW GRANTS FOR 'John'@'localhost';
/* reload all privileges in case you made a change */
FLUSH PRIVILEGES;

/* show databases present */
SHOW DATABASES;
/* show tables in current db */
SHOW TABLES;
/* show tables in specified db with table type */
SHOW FULL TABLES IN sakila;
/* show all views (with caps) */
SHOW FULL TABLES IN sakila WHERE table_type LIKE 'VIEW';
/* show all functions in db */
SHOW FUNCTION STATUS WHERE DB='sakila';
/* show all procedures in db */
SHOW PROCEDURE STATUS WHERE DB='sakila';
/* show triggers for current database */
show triggers;

/* show ddl of object */
SHOW CREATE DATABASE sakila;
SHOW CREATE TABLE actor;
SHOW CREATE VIEW actor_info;

/* db creating */
CREATE DATABASE randomDatabase;
CREATE DATABASE randomDatabase CHARACTER SET utf8 COLLATE utf8_unicode_ci;
CREATE DATABASE IF NOT EXISTS randomDatabase CHARACTER SET=utf8 COLLATE=utf8_unicode_ci;
/* deleting of db */
DROP DATABASE randomDatabase;
DROP DATABASE IF EXISTS randomDatabase;

/* show character set & collation of current db */
SHOW CHARACTER SET
SHOW COLLATION
/* change character set & collation */
ALTER DATABASE randomDatabase CHARACTER SET = utf8 COLLATE = utf8_slovenian_ci

/* tables creating */

CREATE TABLE Persons (
    PersonID int NOT NULL PRIMARY KEY auto_increment,
    firstname VARCHAR(20) NOT NULL
);

/* variant 1 explicit primary key */
CREATE TABLE IF NOT EXISTS Orders (
    OrderID int NOT NULL AUTO_INCREMENT,
    OrderNumber int NOT NULL DEFAULT 6,
    PersonID int,
    /* add index to field */
    INDEX (OrderNumber) 
    /* declare primary key field */
    PRIMARY KEY (OrderID),
    /* declare foreign key (field in this) references other table (id in other) */
    FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;

/* variant 2 implicit primary key */
CREATE TABLE tableName (
    fieldName1 VARCHAR(10),
    /* declare primary key field */
    OrderID INT NOT NULL PRIMARY KEY,
    PersonID INT,
    /* declare foreign key (field in this) references other table (id in other) */
    FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

/*
Moguće vrednosti za ON DELETE i ON UPDATE u definiciji stranog ključa
RESTRICT - Dolazi do greške ako postoji "dete record" roditelja koga pokušavamo
da obrišemo/promenimo
CASCADE - "Dete record" se takođe briše/menja
SET NULL - Ako obrišemo roditelja, "dete record" dobija vrednost NULL u koloni
koja referencira na roditelja
NO ACTION - Možemo da brišemo/menjamo roditeljski ID, bez da se bilo šta desi sa
"dete record-om"
*/

/* indexes */

/* must specify name for index */
CREATE INDEX index_name_create ON sakila.actor (first_name, last_name);
/* or */
/* may not specify name for index - but better if specify */
ALTER TABLE sakila.actor ADD INDEX index_name_alter (last_name, last_name);
/* can be searched normally */
select first_name, last_name from sakila.actor;

/* must specify name for index */
CREATE fulltext INDEX index_name_create_full ON sakila.actor (first_name);
/* may not specify name for index - but better if specify */
ALTER TABLE sakila.actor ADD fulltext INDEX index_name_alter_full (last_name);
/* must be searched with */
SELECT * FROM sakila.actor WHERE MATCH(first_name) AGAINST('CHRISTIAN');
SELECT * FROM sakila.actor WHERE MATCH(last_name) AGAINST('GARLAND' IN BOOLEAN MODE);

/* delete indexes */
alter table sakila.actor drop index index_name_create;

/*
indexes explanation

SELECT * FROM film WHERE MATCH(desctioption) AGAINST('epic drama')
SELECT * FROM film WHERE MATCH(desctioption) AGAINST('epic drama' IN BOOLEAN MODE)
SELECT * FROM film WHERE MATCH(desctioption) AGAINST('+epic -drama')
SELECT * FROM film WHERE MATCH(desctioption) AGAINST('~epic drama')
SELECT * FROM film WHERE MATCH(desctioption) AGAINST('<epic >drama')
SELECT * FROM film WHERE MATCH(desctioption) AGAINST('epic*')
SELECT * FROM film WHERE MATCH(desctioption) AGAINST("epic drama")
SELECT * FROM film WHERE MATCH(desctioption) AGAINST('(epic saga) drama')

+word reč se mora pojaviti u rezultatu
-word reč se ne sme pojaviti u rezultatu
~word reč se može prijaviti u rezultatu, ali joj je data manja važnost
<word reči se daje manje značenje prilikom pretrage
>word reči se daje veće značenje prilikom pretrage
word* sve reči koje počinju sa word (npr. word, words, wordless)
„word1 word2“ traži se fraza identična onoj navedenoj među navodnicima
() zagrade se koriste za grupisanje izraza, npr. '+drama +(epic saga) ',
traže se svi izrazi koji sadrže fraze drama ili epic saga, ili i jedno i drugo
*/

/* alter table */
ALTER TABLE persons ADD COLUMN putnik VARCHAR(30);
/* alter specs of field */
ALTER TABLE persons MODIFY COLUMN putnik VARCHAR(35);
/* for changing position of column use alter with BEFORE / AFTER */
ALTER TABLE persons MODIFY COLUMN putnik varchar(35) AFTER personsid;
/* delete field */
ALTER TABLE persons DROP COLUMN putnik;
/* deleting table */
DROP TABLE persons;
DROP TABLE IF EXISTS persons;
/* clear all data from table & reset counter */
TRUNCATE TABLE persons;

/* adding & removing foreign key */
ALTER TABLE Orders ADD FOREIGN KEY (PersonID) REFERENCES Persons(PersonID);
/* foreign key name will be auto generated so find name begore removing */
ALTER TABLE Orders DROP FOREIGN KEY foreign_key_PersonID;

/*
adding & removing foreign key in workbench
on foreign key tab
1 set name for foreign key
2 choose reference table (table from which you will poll data)
3 choose field (field from this table, foreign key field)
4 choose field (field from reference table, usually id field)
*/

/*
basic types

tinyint – 1 bajt : od -128 do 128 (neoznačeno do 256)
smallint – 2 bajta : od -32768 do 32767 (neoznačeno do 65535)
mediumint – 3 bajta : od -8388608 do 8388607 (neoznačeno do 16777215)
bigint – 8 bajtova : od -9223372036854775808 do -9223372036854775807
(neoznačeno do 18446744073709551615)

int(2) - limits number of figures
zerofill - add zeroes to fill number to specified limit
unsigned - remove - but doubles the range of integers

float - 4 bytes for storing number (single precision)
double or real - 8 bytes for storing number (double precision)
decimal(5,2) - max 5 figured number with 2 decimal places

bit - true or false, 0 or 1

char(5) / varchar(35) - set field to 5 / max field to 35
binary(5) / varbinary(5) -||-

tinytext / tinyblob – 255 karaktera/bajtova
text / blob – 65535 karaktera/bajtova
mediumtext / mediumblob – 16,777,215 karaktera/bajtova
longtext / longblob – 4,294,967,295 karaktera/bajtova

enum - enum('januar', 'februar', 'mart','april', 'maj', 'jun')
set - set('a','b','c','d')
*/

/* database positioning */
USE sakila;

/* insert */
INSERT INTO world.tablename
(fieldname1, fieldname2, ordernumber, personid, orderid)
VALUES  ('pera', 'eric', 3, 2, 4),
        ('sav', 'los', 5, 1, 3);

/* update */
UPDATE world.tablename
SET fieldname1 = 'pera', 
    fieldname2 = 'perovic' 
WHERE orderid = 1;

/* delete */
DELETE FROM world.tablename
WHERE fieldname1 = 'pera';
/* delete - empty table */
DELETE FROM world.tablename;

/* aliases - as */
SELECT 'actor' AS 'glumac'
SELECT actor as g
SELECT actor g

/* select basic schema*/
SELECT
FROM
WHERE
GROUP BY
HAVING
ORDER BY
LIMIT

/* distinct */
SELECT DISTINCT first_name FROM actor;

/* not equal 2 versions */
SELECT * FROM sakila.actor WHERE actor_id <> 1 AND first_name != 'NICK';
SELECT * FROM sakila.actor WHERE actor_id = 4 OR actor_id >= 5;
SELECT * FROM sakila.actor WHERE actor_id NOT BETWEEN 10 AND 20;
SELECT * FROM actor WHERE actor_id IN (1,3,53,23);
SELECT * FROM actor WHERE actor_id NOT IN (1,3,53,23);

/* LIKE */
/* percentage % matches any string of zero or more characters */
SELECT * FROM actor WHERE first_name LIKE '%NN%' OR last_name LIKE 'JO%';
/* underscore _ wildcard matches any single character */
SELECT * FROM actor WHERE first_name NOT LIKE 'J_E';
/* backslash \ is default escape character */
SELECT * FROM actor WHERE first_name LIKE '\_pera';

/* group by */
SELECT city.name, sum(city.population) FROM city GROUP BY city.name 

/* having - filters aggregate query */
SELECT COUNT(city.name), city.CountryCode
FROM city
GROUP BY city.CountryCode
HAVING COUNT(city.name) > 5;

/* ordering */
SELECT * FROM actor ORDER BY first_name ASC, last_name DESC;
/* order by column number */
SELECT * FROM actor ORDER BY 2 ASC, 3 DESC
SELECT * FROM actor ORDER by RAND();

/* limit */
SELECT first_name, last_name FROM actor LIMIT 3;
/* offset definiše od kojeg unosa će baza započeti pretragu. preskoči 10, vrati 5. */
SELECT first_name, last_name FROM actor LIMIT 10, 5;

/* nested select */
SELECT city.district FROM city
  WHERE city.name IN (SELECT city.name FROM city
                        WHERE city.population > 8000000);

/* exists returns true/false from subquery */
SELECT country.name FROM country 
WHERE EXISTS (SELECT city.name FROM city WHERE population > 8000000 AND 
country.code = city.countrycode);

/* any returns true if any of subquarie values meet the condition */
SELECT city.name FROM city 
WHERE city.id = ANY (SELECT city.id FROM city WHERE population > 9000000);

/* ALL operator returns true if all of the subquery values meet the condition. */
SELECT city.name FROM city WHERE city.id = ALL
(SELECT city.id FROM city WHERE population = 1000000);

/* SOME command */
/* simillar to ANY & ALL */

/* joins */

/* example matrix */
1		1
2		4
3

/* inner join */
1		1

SELECT country.name, city.name
FROM city, country
WHERE city.CountryCode = country.Code
/* this also can be used for joining */
AND where marks between min_Mark and Max_Mark;
/* or */
SELECT country.name, city.name
FROM city 
    INNER JOIN country
        ON city.CountryCode = country.Code
    LEFT OUTER JOIN images
        ON dashboard_messages.image_id = images.image_id;

/* left join */
1		1
2		null
3		null

SELECT country.name, city.name
FROM city left JOIN country
ON city.CountryCode = country.Code;

/* right join */
1		1
null	4

SELECT country.name, city.name
FROM city RIGHT JOIN country
ON city.CountryCode = country.Code;

/* full join */
1		1
2		null
3		null
null	4

SELECT country.name, city.name
FROM city left JOIN country
ON city.CountryCode = country.Code;
UNION
SELECT country.name, city.name
FROM city RIGHT JOIN country
ON city.CountryCode = country.Code;

/* view */
CREATE VIEW vieww AS SELECT * FROM actor;
CREATE OR REPLACE VIEW vieww AS SELECT * from actor;
/* alter view */
ALTER VIEW vieww AS SELECT * from actor;
/* delete view */
DROP VIEW vieww;

/* some functions in sql */

SELECT SUM(population) FROM city;
SELECT COUNT(city.name) FROM city;
SELECT COUNT(city) - count(distinct city) from station;
SELECT AVG(population) FROM city;
SELECT MAX(population) FROM city;
SELECT MIN(population) FROM city;
SELECT ABS(population) FROM city;
SELECT POW(population) FROM city;
/* round num to number of decimals */
SELECT ROUND(135.375, 2);
/* round down to the neerest integer */
SELECT FLOOR(population);

/* returns first non null value in a list */
SELECT COALESCE(a, b, c)
/* The REPEAT() function repeats a string as many times as specified */
SELECT REPEAT(string, number)

SELECT NOW(); /* danasnji datum i vreme */
SELECT CURRENT_TIMESTAMP(); /* danasnji datum i vreme */
SELECT DATE_FORMAT(NOW(),'Datum: %d-%Y-%m')
    /*
    %d  Dan, prikazan u numeričkom obliku (01,10,17,24...)
    %D  Dan sa sufiksom (1st, 2nd, 14th...)
    %m  Mesec u numeričkom obliku (01,04,08,11...)
    %M  Mesec u tekstualnom obliku (January,April,August...)
    %b  Mesec u skraćenom tekstualnom obliku (Jan,Apr,Aug,Nov...)
    %y  Godina u dvobrojnoj numeričkoj formi (07,08,09...)
    %Y  Godina u četvorobrojnoj numeričkoj formi (2007,2008,2009...)
    %W  Dan u nedelji (Monday,Wednesday,Friday...)
    %a  Skraćeni dan u nedelji (Mon,Wed,Fri...)
    %H  Sat u 24-časovnom formatu (07,11,16,23...)
    %h  Sat u 12-časovnom formatu (07,11,04,11...)
    %p  Oznaka AM ili PM
    %i  Minuti (01,16,36,49...)
    %s  Sekunde (01,16,36,49...)
    */
/*
Na sličan način, delovi datuma se mogu izolovati date extracting funkcijama:
DAYOFMONTH(dt)  Dan, prikazan u numeričkom obliku (01, 10, 17, 24...)
DAYNAME(dt)     Dan sa sufiksom (1st, 2nd, 14th...)
MONTH(dt)       Mesec u numeričkom obliku (01, 04, 08, 11...)
MONTHNAME(dt)   Mesec u te`kstualnom obliku (January,April,August...)
YEAR(dt)        Godina u četvorobrojnoj numeričkoj formi (2007, 2008, 2009...)
HOUR(dt)        Sat u 24-časovnom formatu (07, 11, 6, 23...)
MINUTE(dt)      Minuti (01, 16, 36, 49...)
SECOND(dt)      Sekunde (01, 16, 36, 49...)
DAYOFYEAR(dt)   Dan u godini (1.....366)
*/
/* current date & time */
SELECT CURDATE();
SELECT CURTIME();
/* adding interval */
SELECT DATE_ADD(NOW(), INTERVAL 10 DAY);

/* Vraća dužinu string-a in bytes */
SELECT LENGTH(city.name) FROM city;
/* returns length in characters */
SELECT CHAR_LENGTH(city.name) FROM city;
/* Spajanje nekoliko 'kolona' u jednu: */
SELECT CONCAT(city.name, ", ", city.district) AS concatString FROM city;
/* Spajanje nekoliko 'kolona' u jednu sa separatorom: */
SELECT CONCAT_WS("-", city.name, city.district) AS concatString FROM city;
/* Konvertuje tekst u mala slova: */
SELECT LOWER(city.name) FROM city;
/* Konvertuje tekst u velika slova: */
SELECT UPPER(city.name) FROM city;
/* Uklanja višak spejsova iz string-a: */
SELECT LTRIM("     SQL ;)  Vežbe     ") AS LeftTrimmedString;
/* Poređenje dva stringa: */
SELECT STRCMP(city.name, city.district) FROM city;
/* kompletan tekst, tekst koji želimo da izmenimo, novi tekst, works on numbers also */
SELECT REPLACE("moj tekst","moj", "Link");
/* returns substring of a string counting first one (start_at_position) */
SELECT SUBSTRING(city, 1, 1)
SELECT SUBSTRING(city, start_at_position, return_number_of_characters)
/* returns left substring from point */
SELECT LEFT(city, 3)

/* converts datatype to specified type */
SELECT CONVERT('test', CHAR CHARACTER SET utf8);
SELECT CAST('test' AS CHAR CHARACTER SET utf8);
SELECT CONVERT('test', CHAR);
SELECT CAST('test' AS CHAR);
SELECT CONVERT(columnName, DECIMAL(10,2))
SELECT CAST(columnName as DECIMAL(10,2))
    /* must be one of the following
    DATE  Converts value to DATE. Format: "YYYY-MM-DD"
    DATETIME  Converts value to DATETIME. Format: "YYYY-MM-DD HH:MM:SS"
    TIME  Converts value to TIME. Format: "HH:MM:SS"
    CHAR  Converts value to CHAR (a fixed length string)
    SIGNED  Converts value to SIGNED (a signed 64-bit integer)
    UNSIGNED  Converts value to UNSIGNED (an unsigned 64-bit integer)
    BINARY  Converts value to BINARY (a binary string)
    DECIMAL Converts string to DECIMAL (total num of digits, num of digits right of decimal point) */

/* adding variable & setting it's value = and := is just a syntatic sugar */
SET @functionCallVariable = CONCAT('pozdrav ', 'sql');
SET @functionCallVariable := SELECT CONCAT('pozdrav ', 'sql');
SELECT @functionCallVariable;

/* advanced functions */

/* select if function / ternary function */
SELECT IF(6 < 5, 'true', 'false')

/* set if */
SET col_Z = IF(col_A = 4 OR col_B = 4, 4, NULL)

/* if statements work only in functions & stored procedures */
/* if statement variant 1 */
IF expression THEN 
   statements;
END IF;

/* if statement variant 2 */
IF expression THEN
   statements;
ELSE
   else-statements;
END IF;

/* if statement variant 3 */
IF expression THEN
   statements;
ELSEIF elseif-expression THEN
   elseif-statements;
...
ELSE
   else-statements;
END IF;

/* ifnull (expression to check if null, value to return if expression is null) */
SELECT IFNULL(NULL,'radi'); /* returns 'radi' */
SELECT IFNULL(500,'ne radi'); /* returns 500 */

/* case function */

/* case variant 1 */
SELECT city.name, population,
CASE
    WHEN population > 5000000 
        THEN "more"
    WHEN population > 1000000 
        THEN "less"
    ELSE "none"
END
FROM city;

/* case variant 2 */
select 
case 
    when not (a + b > c and b + c > a and c + a > b) then "Not A Triangle"
    when a = b and b = c then "Equilateral"
    when a = b or b = c or c = a then "Isosceles"
    else "Scalene" 
end
from Triangles;

/* union - combine data from both tables distinct values only */
SELECT * FROM actor
UNION
SELECT * FROM city;

/* union all - combine data from both tables allow for duplicates */
SELECT * FROM actor
UNION ALL
SELECT * FROM city;

/* custom functions */

DELIMITER //
CREATE FUNCTION my_function(var1 INTEGER, var2 VARCHAR(20))
    RETURNS VARCHAR(20)
    /* specify if is deterministic or not deterministic */
    DETERMINISTIC
        BEGIN
            SET @a = var1 + 1;
            RETURN @a;
	END //
DELIMITER ;

/* funtion call */
SELECT my_function(7, 'sima');
/* deleting function */
DROP FUNCTION my_function;

/* stored procedure */

DELIMITER //
/* put any number of arguments in parentesis */
CREATE PROCEDURE my_procedure(var1 INTEGER, var2 VARCHAR(20))
BEGIN
    /* declaring variable (declare/name/type/size/(optional-default+defaultValue))*/
    DECLARE randomVariable INTEGER(7) DEFAULT 55;
    /* set variable or function */
    SET var1 = var1 + 1;
    SELECT var1;
    /* put here sql statement - what ever */
    SELECT * FROM city;
END //
DELIMITER ;

SET @variableA=1;
SET @varibaleB='pera';
/* procedure call */
CALL my_procedure(@variableA, @variableB);
/* delete procedure */
DROP PROCEDURE my_procedure;

/* triggers */

DELIMITER $$
CREATE     
/* [DEFINER = { user | CURRENT_USER }] (can put user here) */ 
TRIGGER trigger_name 
/* before/after */
/* trigger_event: insert, load data, replace, update, delete */
BEFORE INSERT
ON sakila.actor FOR EACH ROW   
BEGIN
    /*
    Variable declaration (DECLARE) and assignment (SET)
    Flow-of-control statements (IF, CASE, WHILE, LOOP, WHILE,
    REPEAT, LEAVE, ITERATE)
    Condition declarations
    Handler declarations
    old.column and new.column keywords
    */
    SET NEW.FIRST_NAME = LOWER(NEW.FIRST_NAME);
    SET NEW.Last_NAME = LOWER(NEW.last_name);
END $$
DELIMITER ;

/* delete trigger */
DROP TRIGGER IF EXISTS sakila.trigger_name;

/* cursors untested*/

/* procedure example with cursor */
DELIMITER $$
CREATE PROCEDURE build_email_list (INOUT email_list varchar(4000))
BEGIN
    DECLARE v_finished INTEGER DEFAULT 0;
    DECLARE v_email varchar(100) DEFAULT "";
/* cursor for iterating over rows from result set */
    DECLARE email_cursor CURSOR FOR SELECT email FROM employees;
/* for handling end of iteration */
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;
    OPEN email_cursor;
    get_email: LOOP
        FETCH email_cursor INTO v_email;
        IF v_finished = 1 THEN 
        LEAVE get_email;
        END IF;
        SET email_list = CONCAT(v_email,";",email_list);
    END LOOP get_email;
    CLOSE email_cursor;
END$$
DELIMITER ;
SET @email_list = "";
CALL build_email_list(@email_list);
SELECT @email_list;

/* function example with cursor */
DELIMITER //
CREATE FUNCTION FindSiteID ( name_in VARCHAR(50) )
RETURNS INT
BEGIN
   DECLARE done INT DEFAULT FALSE;
   DECLARE siteID INT DEFAULT 0;
   DECLARE c1 CURSOR FOR
     SELECT site_id
     FROM sites
     WHERE site_name = name_in;
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
   OPEN c1;
   FETCH c1 INTO siteID;
   CLOSE c1;
   RETURN siteID;
END; //
DELIMITER ;
SELECT FindSiteID ('TechOnTheNet.com');

/* transactions */

/* set autocommit to on */
SET @@AUTOCOMMIT=1;
/* set autocommit to on */
SET @@AUTOCOMMIT=0;

/* lock resource before access */
SELECT * FROM country LOCK IN SHARE MODE;

/* specify explicit transaction */
START TRANSACION;
/* cancel to previous */
ROLLBACK;

/* create savepoint */
SAVEPOINT first_savepoint;
/* cancel to specified savepoint */
ROLLBACK TO SAVEPOINT first_savepoint;

/* commit */
COMMIT;

/* backup & restore

backup with cmd
go to: program files/mysql/mysql server 8.0/bin
[password] can be ommited for entering from command line
mysqldump -u [username] -p[password] [database_name] > [dump_file.sql]
mysqldump -u [username] -p[password] --databases [database_name1] [database_name2] > [dump_file.sql]
mysqldump -u [username] -p[password] --all-databases > [dump_file.sql]
example
mysqldump -u mysqltutorial -psecret --databases database1 database2 > c:\temp\backup001.sql

restore with...:
drop old database, create blank database

...with mysql (cannot specify db during import)
go to: program files/mysql/mysql server 8.0/bin
start mysql with: mysql.exe -u root -pperovic
put command in shell: mysql> source dump.sql
example
source c:\backup\rd.sql

...with cmd (prefered way - can specify db during import - but specifying
doesn't work at the moment???????????????????????????)
go to: program files/mysql/mysql server 8.0/bin
populate blank database/databases with saved copy
mysql -u [uname] -p[pass] [db_to_restore] < [backupfile.sql]
mysql -u root -p Tutorials < c:\backup\tut_backup.sql

*/
