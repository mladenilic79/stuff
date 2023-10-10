
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
\connect mydb1
\c mydb1

-- describe
\d -- database
\dt -- database tables only
\d person -- specific object

-- run sql from file, set permissions before this
\i C:\Users\Administrator.DRHW10EDGE10\Desktop\postgres\person.sql

-- create database
CREATE DATABASE test;

-- delete database
DROP DATABASE test;

-- create table
CREATE TABLE person(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender VARCHAR(15) NOT NULL CHECK(gender = 'Female' OR gender = 'female' OR gender = 'Male' OR gender = 'male' OR gender = 'Agender' OR gender = 'Non-binary' OR gender = 'Genderqueer'),
    date_of_birth DATE NOT NULL,
    email VARCHAR(150),
    country_of_birth VARCHAR(50),
    price DECIMAL(19,2) UNIQUE
    -- constraint can be written also like this
    -- price DECIMAL(19,2),
    -- UNIQUE(price)
);

-- delete table
DROP TABLE person;

-- modify constraints
ALTER TABLE person DROP CONSTRAINT person_pkey; -- drop constraint, primary key in this case
ALTER TABLE person ADD PRIMARY KEY (id); -- add primary key - will work if there are no duplicates
ALTER TABLE person ADD CONSTRAINT unique_email UNIQUE(email); -- add unique constraint with custom name - will work if there are no duplicates
ALTER TABLE person ADD UNIQUE(email); -- add unique constraint and let postres choose a name - will work if there are no duplicates
ALTER TABLE person ADD CONSTRAINT gender_check CHECK(gender = 'Female' OR gender = 'female' OR gender = 'Male' OR gender = 'male' OR gender = 'Agender' OR gender = 'Non-binary' OR gender = 'Genderqueer'); -- add checked constraint with choose name
ALTER TABLE person ADD CHECK(gender = 'Female' OR gender = 'female' OR gender = 'Male' OR gender = 'male' OR gender = 'Agender' OR gender = 'Non-binary' OR gender = 'Genderqueer'); -- add checked constraint let db choose name for you

-- insert into table

INSERT INTO person(first_name, last_name, gender, date_of_birth, country_of_birth) 
VALUES('Anne', 'Smith', 'female', DATE '1993-01-03', 'US');  -- convert string to date with DATE function

INSERT INTO person(first_name, last_name, gender, date_of_birth, email)
VALUES('Jack', 'Smith', 'male', DATE '1993-02-03', 'jake@gmail.com')
ON CONFLICT (email) DO NOTHING; -- this will work on unique column, and will prevent an error

INSERT INTO person(
    first_name, last_name, gender, date_of_birth, email
) VALUES(
    'Jack', 'Smith', 'male', DATE '1993-02-03', 'jake@gmail.com'
) ON CONFLICT (email) DO UPDATE SET email = EXCLUDED.email, first_name = EXCLUDED.first_name; -- this will work on unique column, and will prevent an error and update the field instead of doing nothing

-- update whole table -- !!!!!!!!! this will update whole table don't do this !!!!!!!!!!
UPDATE person SET email = 'omar@gmail.com'; -- !!!!!!!!! this will update whole table don't do this !!!!!!!!!!
-- update records
UPDATE person SET email = 'omar@gmail.com' WHERE id = 31;
UPDATE person SET gender = 'Female', country_of_birth = 'China' WHERE id = 31;

-- delete all inside table -- !!!!!!!!! this will empty table don't do this !!!!!!!!!!
DELETE FROM person; -- !!!!!!!!!! this will empty table don't do this !!!!!!!!!!
-- delete records
DELETE FROM person WHERE id = 10;
DELETE FROM person WHERE gender = 'Female' AND country_of_birth = 'China';

-- select / from
SELECT * FROM person;
SELECT first_name, last_name FROM person;

-- some keywords
SELECT DISTINCT country_of_birth FROM person ORDER BY country_of_birth; -- distinct(unique values/rows only)
SELECT * FROM person LIMIT 10; -- limit/fetch(return only number of records)
SELECT * FROM person FETCH FIRST 10 ROWS ONLY; -- fetch is same as limit just is part of sql standard
SELECT * FROM person OFFSET 10; -- offset(return records after that number of records), skip first 10, 
SELECT country_of_birth AS country FROM person; -- as(alias) / coalesce(return default if value missing)
SELECT first_name, coalesce(email, 'default value if value missing') FROM person; -- coalesce - default value
-- handle null value - nullif returns 1st argument if both values are not equel, returns null if they are equal
SELECT first_name, 10/NULLIF(1+1-2, 0) AS new_price FROM person; -- this will replace 0 with null to prevent division with zero

-- +(add) / -(subtract) / *(multiply) / /(division) / ^(power) / %(moduo)
SELECT price, price * 2 AS MULT, price / 2 AS DIV, price + price AS ADS, price - price AS SUB, price ^ 2 AS POWER, price % 3 AS MODUL FROM person;

-- dates - refer to the official documentation
SELECT NOW(); -- return this moment
SELECT NOW()::DATE; -- casting to only date
SELECT NOW()::TIME; -- casting to only time
-- interval used for conversion
SELECT NOW() - INTERVAL '1 YEAR';
SELECT NOW()::DATE + INTERVAL '5 MONTHS'; -- casting here will round date but now change pattern
SELECT (NOW() + INTERVAL '10 DAYS')::DATE; -- cast it in the end
-- extract used for specific element of the date/time
SELECT EXTRACT(YEAR FROM NOW());
SELECT EXTRACT(MONTH FROM NOW());
SELECT EXTRACT(DAY FROM NOW());
SELECT EXTRACT(DOW FROM NOW()); -- DOW - day of the week
SELECT first_name, AGE(NOW(), date_of_birth) AS age FROM person; -- AGE returns time between two dates

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

-- count
SELECT COUNT(*) FROM PERSON;
SELECT country_of_birth, COUNT(*) FROM person GROUP BY country_of_birth;
SELECT country_of_birth, COUNT(*) FROM person GROUP BY country_of_birth HAVING COUNT(*) > 5;

-- min / max / avg / sum / round
SELECT MAX(price) FROM person;
SELECT MIN(price) FROM person;
SELECT ROUND(AVG(price)) FROM person;
SELECT SUM(price) FROM person;
SELECT country_of_birth, MIN(price) FROM person GROUP BY country_of_birth;
SELECT country_of_birth, MIN(price) FROM person GROUP BY country_of_birth HAVING MIN(price) >= 500;
SELECT country_of_birth, SUM(price) FROM person GROUP BY country_of_birth HAVING SUM(price) <= 500;
SELECT first_name, country_of_birth, MIN(price) FROM person GROUP BY first_name, country_of_birth; -- double grouping

--order by / asc/desc
SELECT * FROM person ORDER BY last_name; -- asscending is default
SELECT * FROM person ORDER BY last_name ASC;
SELECT * FROM person ORDER BY last_name DESC;
SELECT * FROM person ORDER BY first_name, last_name; -- combine order
