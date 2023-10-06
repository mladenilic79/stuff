
/*
after installation of postgresql to execute psql from terminal add postgresql path to system variable if needed
*/

/*
connect to server & database using psql
open psql and get prompt
    Server [localhost]:
paste url for connection to server or except localhost with enter
    Database [postgres]:
input database name you want to connect to or just accept default postgres database with enter
    Port [5432]:
input port to use of accept default port with enter
    Username [postgres]:
en enter we will be prompted for password, input user password and enter
*/

-- quit psql
\q

-- list all databases
\list
\l

-- connect to database
\connect
\c

-- describe
\d -- database
\dt -- database tables only
\d person -- specific object

-- create database
CREATE DATABASE test;

-- delete database
DROP DATABASE test;

-- create table
CREATE TABLE person(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender VARCHAR(15) NOT NULL,
    date_of_birth DATE NOT NULL,
    email VARCHAR(150),
    country_of_birth VARCHAR(50),
    price DECIMAL(19,2)
);

-- delete table
DROP TABLE person;

-- insert into table
INSERT INTO person(
    first_name,
    last_name,
    gender,
    date_of_birth,
    country_of_birth
) VALUES(
    'Anne',
    'Smith',
    'female',
    DATE '1993-01-03', -- convert string to date with DATE function
    'US'
);
INSERT INTO person(
    first_name,
    last_name,
    gender,
    date_of_birth,
    email
) VALUES(
    'Jack',
    'Smith',
    'male',
    DATE '1993-02-03', -- convert string to date with DATE function
    'jake@gmail.com'
);

-- query

-- select / from
SELECT * FROM person;
SELECT first_name, last_name FROM person;

-- where / and / or / in / between / like / ilike
SELECT * FROM person WHERE gender = 'Female';
SELECT * FROM person WHERE date_of_birth > DATE '2023-06-01';
SELECT * FROM person WHERE gender = 'Female' and country_of_birth = 'Russia';
SELECT * FROM person WHERE gender = 'Female' and (country_of_birth = 'Russia' or country_of_birth = 'China');
SELECT * FROM person WHERE country_of_birth IN ('Russia', 'China');
SELECT * FROM person WHERE date_of_birth BETWEEN DATE '2022-01-01' AND '2023-01-01';
SELECT * FROM person WHERE email LIKE '%log.com'; -- % means any number of characters
SELECT * FROM person WHERE email LIKE '%oo%';
SELECT * FROM person WHERE email LIKE '_________oo_____om'; -- _ represents single character
SELECT * FROM person WHERE country_of_birth ILIKE 'p%'; -- ILIKE same as LIKE just ignores case

-- aggragate / group by / having (having is filtering of groups)
-- count / max / min / avg / sum
-- round
SELECT country_of_birth, COUNT(*) FROM person GROUP BY country_of_birth;
SELECT country_of_birth, COUNT(*) FROM person GROUP BY country_of_birth HAVING COUNT(*) > 5;
SELECT MAX(price) FROM person;
SELECT MIN(price) FROM person;
SELECT AVG(price) FROM person;
SELECT ROUND(AVG(price)) FROM person;
SELECT country_of_birth, MIN(price) FROM person GROUP BY country_of_birth;
SELECT first_name, country_of_birth, MIN(price) FROM person GROUP BY first_name, country_of_birth; -- double grouping

--order by
SELECT * FROM person ORDER BY last_name; -- asscending is default
SELECT * FROM person ORDER BY last_name ASC;
SELECT * FROM person ORDER BY last_name DESC;
SELECT * FROM person ORDER BY first_name, last_name; -- combine order

-- keywords
SELECT DISTINCT country_of_birth FROM person ORDER BY country_of_birth;
SELECT * FROM person LIMIT 10;
SELECT * FROM person FETCH FIRST 10 ROWS ONLY; -- fetch is same as limit just is part of sql standard
SELECT * FROM person OFFSET 10; -- skip first 10 records
