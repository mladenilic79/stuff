
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

-- run sql from file, set file permissions before this
\i C:\Users\Administrator.DRHW10EDGE10\Desktop\postgres\person.sql

-- toggle standard & expended output
\x

-- create database
CREATE DATABASE testingDatabase;

-- delete database
DROP DATABASE testingDatabase;

-- create table
CREATE TABLE car(
    car_id BIGSERIAL PRIMARY KEY,
    make VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    price NUMERIC(19,2) NOT NULL
);
CREATE TABLE person(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL DEFAULT 'Sara', -- put default if not provided
    last_name VARCHAR(50) NOT NULL,
    gender VARCHAR(15) NOT NULL CHECK(gender = 'Female' OR gender = 'Male' OR gender = 'Agender' OR gender = 'Non-binary' OR gender = 'Genderqueer'),
    email VARCHAR(150),
    date_of_birth DATE NOT NULL,
    country_of_birth VARCHAR(50),
    randomnumber DECIMAL(19,2) UNIQUE,
    -- constraint can be written also like this
    -- price DECIMAL(19,2),
    -- UNIQUE(price)
    car_id BIGINT REFERENCES car (car_id)
    -- UNIQUE(car_id) --  add unique if car can only be owned by one owner
);

-- delete table
DROP TABLE person;

-- modify constraints drop
ALTER TABLE person DROP CONSTRAINT person_pkey; -- primary key in this case
ALTER TABLE person DROP CONSTRAINT person_car_id_fkey; -- foreign key in this case
ALTER TABLE person DROP CONSTRAINT person_gender_check;
ALTER TABLE person DROP CONSTRAINT person_randomnumber_key;
-- modiry constraints add
ALTER TABLE person ADD PRIMARY KEY (id); -- add primary key - will work if there are no duplicates
ALTER TABLE person ADD FOREIGN KEY (person_car_id_fkey) REFERENCES car (car_id);
-- modify constraints add (with setting custom name)
ALTER TABLE person ADD CONSTRAINT unique_email UNIQUE(email); -- will work if there are no duplicates
ALTER TABLE person ADD CONSTRAINT gender_check CHECK(gender = 'Female' OR gender = 'female' OR gender = 'Male' OR gender = 'male' OR gender = 'Agender' OR gender = 'Non-binary' OR gender = 'Genderqueer'); -- add checked constraint with choose name
-- modify constraints add alternatively with letting database set the name for them
ALTER TABLE person ADD UNIQUE(email); -- will work if there are no duplicates
ALTER TABLE person ADD CHECK(gender = 'Female' OR gender = 'female' OR gender = 'Male' OR gender = 'male' OR gender = 'Agender' OR gender = 'Non-binary' OR gender = 'Genderqueer'); -- add checked constraint let db choose name for you

-- alter table
ALTER TABLE person ADD another_column TYPE VARCHAR(10);
ALTER TABLE person ALTER COLUMN another_column SET NOT NULL;
ALTER TABLE person RENAME COLUMN another_column TO another_column_2;
ALTER TABLE person DROP COLUMN another_column_2;
ALTER TABLE person RENAME TO person2;
ALTER TABLE person2 RENAME TO person;

-- restart sequence / auto numbering -- eh.. don't do this :)

-- indexes
CREATE INDEX person_index_1 ON person(first_name);
CREATE INDEX person_index_2 ON person(first_name, last_name);

-- insert into table

INSERT INTO person(first_name, last_name, gender, email, date_of_birth, country_of_birth, randomnumber) 
VALUES('Anne', 'Smith', 'Female', 'jake@gmail.com', DATE '1993-01-03', 'US', 444);  -- convert string to date with DATE function

INSERT INTO person(first_name, last_name, gender, email, date_of_birth, country_of_birth, randomnumber) 
VALUES('Bri', 'Smith', 'Female', 'bri@gmail.com', DATE '1989-01-03', NULL, 5.5);

INSERT INTO person(first_name, last_name, gender, email, date_of_birth, country_of_birth, randomnumber)
VALUES('Jack', 'Smith', 'Male', 'jake@gmail.com', DATE '1993-02-03', 'Paris', 888)
ON CONFLICT (email) DO NOTHING; -- this will work on unique column, and will prevent an error

INSERT INTO person(
    first_name, last_name, gender, email, date_of_birth, country_of_birth, randomnumber
) VALUES(
    'Marica', 'Smith', 'Male', 'jake@gmail.com', DATE '1993-02-03', 'London', 333
) ON CONFLICT (email) DO UPDATE SET email = EXCLUDED.email, first_name = EXCLUDED.first_name; -- this will work on unique column, and will prevent an error and update the field instead of doing nothing

-- update whole table -- !!!!!!!!! this will update whole table don't do this !!!!!!!!!!
UPDATE person SET email = 'omar@gmail.com'; -- !!!!!!!!! this will update whole table don't do this !!!!!!!!!!

-- update records
UPDATE person SET email = 'omar@gmail.com' WHERE id = 1;
UPDATE person SET gender = 'Male', country_of_birth = 'Paris' WHERE id = 2;

-- delete all inside table -- !!!!!!!!! this will empty table don't do this !!!!!!!!!!
DELETE FROM person; -- !!!!!!!!!! this will empty table don't do this !!!!!!!!!!
TRUNCATE TABLE person; -- !!!!!!!!!! this will empty table don't do this !!!!!!!!!!

-- delete records
DELETE FROM person WHERE id = 1;
DELETE FROM person WHERE gender = 'Male' AND country_of_birth = 'Paris';

-- select / from
SELECT * FROM person;
SELECT *, first_name FROM person;
SELECT first_name, last_name FROM person;

-- some keywords
SELECT DISTINCT country_of_birth FROM person ORDER BY country_of_birth; -- distinct(unique values/rows only)
SELECT * FROM person LIMIT 10; -- limit/fetch(return only number of records)
SELECT * FROM person FETCH FIRST 10 ROWS ONLY; -- fetch is same as limit just is part of sql standard
SELECT * FROM person OFFSET 10; -- offset(return records after that number of records), skip first 10, 
SELECT country_of_birth AS country FROM person; -- as(alias) / coalesce(return default if value missing)

-- some functions
SELECT first_name, coalesce(email, 'default value if value missing') FROM person; -- coalesce - default value
-- handle null value - nullif returns 1st argument if both values are not equel, returns null if they are equal
SELECT first_name, 10/NULLIF(1+1-2, 0) AS new_price FROM person; -- this will replace 0 with null to prevent division with zero
SELECT first_name, UPPER(first_name) AS upper_first_name, LOWER(first_name) AS lower_first_name FROM person;
SELECT first_name, LENGTH(first_name) AS length_of_first_name FROM person;
SELECT first_name, TRIM(first_name) AS trimmed_first_name FROM person;
SELECT first_name || ' ' || last_name AS full_name FROM person;
SELECT CONCAT(first_name, ' ', last_name) AS full_name, country_of_birth FROM person;
SELECT first_name, last_name, date_of_birth, 
    CASE
        WHEN date_of_birth < DATE 1-1-1980 THEN 'old'
        ELSE 'young';

-- +(add) / -(subtract) / *(multiply) / /(division) / ^(power) / %(moduo)
SELECT randomnumber, randomnumber * 2 AS MULT, randomnumber / 2 AS DIV, randomnumber + randomnumber AS ADS, randomnumber - randomnumber AS SUB, randomnumber ^ 2 AS POWER, randomnumber % 3 AS MODUL FROM person;

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
SELECT EXTRACT(MONTH FROM date_of_birth) AS month_of_birth FROM PERSON;
SELECT first_name, AGE(NOW(), date_of_birth) AS age FROM person; -- AGE returns time between two dates

-- where / and / or / in / between / like / ilike / < > <= >= <> !=
SELECT * FROM person WHERE date_of_birth >= DATE '1960-06-01';
SELECT * FROM person WHERE date_of_birth > DATE '1960-06-01';
SELECT * FROM person WHERE gender = 'Female' AND country_of_birth = 'Russia';
SELECT * FROM person WHERE gender = 'Female' AND (country_of_birth != 'Russia' OR country_of_birth <> 'China');
SELECT * FROM person WHERE country_of_birth IN ('Russia', 'China');
SELECT * FROM person WHERE country_of_birth NOT IN ('Russia', 'China');
SELECT * FROM person WHERE date_of_birth BETWEEN DATE '2000-01-01' AND '2023-01-01';
SELECT * FROM person WHERE email LIKE '%o.com'; -- % means any number of characters
SELECT * FROM person WHERE email LIKE '%oo%';
SELECT * FROM person WHERE email LIKE '_________@_________.com'; -- _ represents single character
SELECT * FROM person WHERE country_of_birth ILIKE 'p%'; -- ILIKE same as LIKE just ignores case
SELECT * FROM person WHERE email SIMILAR TO '%oo%'; -- SIMILAR TO same as like just interprets regex differently
SELECT * FROM person WHERE email ~ '%oo%'; -- ~ same as like just interprets regex differently
SELECT * FROM person WHERE email IS NULL;
SELECT * FROM person WHERE email IS NOT NULL;
SELECT * FROM person WHERE email = NULL;

-- aggragate / group by / having (having is filtering of groups)

-- count
SELECT COUNT(*) FROM PERSON;
SELECT country_of_birth, COUNT(*) FROM person GROUP BY country_of_birth;
SELECT country_of_birth, COUNT(*) FROM person GROUP BY country_of_birth HAVING COUNT(*) > 5;

-- min / max / avg / sum / round
SELECT MAX(randomnumber) FROM person;
SELECT MIN(randomnumber) FROM person;
SELECT ROUND(AVG(randomnumber)) FROM person;
SELECT SUM(randomnumber) FROM person;
SELECT country_of_birth, MIN(randomnumber) FROM person GROUP BY country_of_birth;
SELECT country_of_birth, MIN(randomnumber) FROM person GROUP BY country_of_birth HAVING MIN(randomnumber) >= 90;
SELECT country_of_birth, SUM(randomnumber) FROM person GROUP BY country_of_birth HAVING SUM(randomnumber) <= 500;
SELECT first_name, country_of_birth, MIN(randomnumber) FROM person GROUP BY first_name, country_of_birth; -- double grouping

--order by / asc/desc
SELECT * FROM person ORDER BY last_name; -- asscending is default
SELECT * FROM person ORDER BY last_name ASC;
SELECT * FROM person ORDER BY last_name DESC;
SELECT * FROM person ORDER BY first_name, last_name; -- combine order

-- joins

-- inner

SELECT * 
FROM person
    JOIN car ON person.car_id = car.car_id;
    -- JOIN table_y ON table_x.id = table_y.id; -- add like this in case of joining multiple tables

-- inner join same as join
SELECT * 
FROM person
    INNER JOIN car ON person.car_id = car.car_id;

-- specific columns
SELECT person.first_name, car.make
FROM person
    JOIN car ON person.car_id = car.car_id;

-- if both ids are the same keyword USING can be used
SELECT *
FROM person
    JOIN car USING(car_id);

-- natural join
SELECT * 
FROM person
    NATURAL JOIN car ON person.car_id = car.car_id;


-- left (take all from left)
SELECT *
FROM person
    LEFT JOIN car ON person.car_id = car.car_id;

-- right (take all from right)
SELECT *
FROM person
    RIGHT JOIN car ON person.car_id = car.car_id;

-- full outer join
SELECT *
FROM person
    FULL OUTER JOIN car ON person.car_id = car.car_id;

-- cross join (include each row from both tables)
SELECT *
FROM person
    CROSS JOIN car ON person.car_id = car.car_id;

-- unions for stacking data verticaly (default is to remove all duplicates)
SELECT id, first_name, last_name, randomnumber FROM person
UNION
SELECT * FROM car
UNION
SELECT * FROM car;

-- unions for stacking data verticaly (keep all duplicates)
SELECT id, first_name, last_name, randomnumber FROM person
UNION ALL
SELECT id, first_name, last_name, randomnumber FROM person;

-- subqueries

-- subquery in from
SELECT a.first_name, a.last_name FROM (SELECT * FROM person) a; -- a refers to the subquery

-- subquery in where
SELECT * FROM person WHERE country_of_birth IN (SELECT country_of_birth FROM person);

-- views (recalculations are not updated automagically so to update on call 
-- don't use aggregations, calculation functions, distinct, union, group by, having)
CREATE VIEW custom_view AS
SELECT * FROM person;
-- call view with
SELECT * FROM custom_view;
-- delete view with
DROP VIEW custom_view;

-- create function with
CREATE OR REPLACE FUNCTION add_two_values(int, int) RETURNS int AS
'
SELECT $1 + $2;
'
LANGUAGE SQL
-- call function with
SELECT add_two_values(4,5);

-- create function with
CREATE OR REPLACE FUNCTION add_two_values(int, int) RETURNS int AS
$body$
    SELECT $1 + $2;
$body$
LANGUAGE SQL
-- call function with
SELECT add_two_values(4,5);

-- create function with (void means returns nothing)
CREATE OR REPLACE FUNCTION update_state() RETURNS void AS
$body$
    UPDATE person
    SET first_name = "Cirilo"
    WHERE country_of_birth = "China"
$body$
LANGUAGE SQL
-- call function with
SELECT update_state();

-- create function with (named parameters)
CREATE OR REPLACE FUNCTION text_ops(first_parameter VARCHAR, second_parameter VARCHAR) RETURNS void AS
$body$
    UPDATE person
    SET person.first_name = first_parameter, person.last_name = second_parameter
    WHERE country_of_birth = "China"
$body$
LANGUAGE SQL
-- call function with
SELECT text_ops("pera", "detlic");

-- create function with (return row as result)
CREATE OR REPLACE FUNCTION return_row() RETURNS result_row AS
$body$
    SELECT *
    FROM person
    ORDER BY date_of_birth
    LIMIT 1;
$body$
LANGUAGE SQL
-- call function with
SELECT return_row(); -- one field format
SELECT (return_row()).*; -- table format
SELECT (return_row()).first_name -- get specific field

-- create function with (return multiple rows as result)
CREATE OR REPLACE FUNCTION return_rows() RETURNS SETOF result_rows AS
$body$
    SELECT *
    FROM person
    ORDER BY date_of_birth
    LIMIT 5;
$body$
LANGUAGE SQL
-- call function with
SELECT result_rows(); -- one field format

-- PL/pgSQL
CREATE OR REPLACE FUNCTION select_function(name_to_get VARCHAR) RETURNS VARCHAR AS
$body$
BEGIN
    RETURN last_name
    FROM person
    WHERE first_name = name_to_get
END
$body$
LANGUAGE plpgsql
-- run function
SELECT select_function("Biljana");

-- PL/pgSQL
CREATE OR REPLACE FUNCTION get_sum(val1 int, val2 int) RETURNS int AS
$body$
DECLARE
    result int
BEGIN
    result := val1 + val2;
    RETUNS result
END
$body$
LANGUAGE plpgsql
-- run function
SELECT get_sum(2,3);

-- PL/pgSQL
CREATE OR REPLACE FUNCTION get_random(max_val int, min_val int) RETURNS int AS
$body$
DECLARE
    rand int
BEGIN
    SELECT random()*(max_val - min_val) + min_val INTO rand
    RETUNS rand;
END
$body$
LANGUAGE plpgsql
-- run function
SELECT get_random(10,3);

-- PL/pgSQL
CREATE OR REPLACE FUNCTION return_record() RETURNS VARCHAR AS
$body$
DECLARE
    rand INT
    row_data RECORD
BEGIN
    SELECT random()*(45-5) + 5 INTO rand;
    SELECT * FROM person INTO row_data WHERE person.id = rand
    RETURN rand
END
$body$
LANGUAGE plpgsql
-- run function
SELECT get_random(10,3);

-- PL/pgSQL
CREATE OR REPLACE FUNCTION add_two_nums(IN val1 INT, IN val2 INT, OUT result INT) AS
$body$
BEGIN
    result := val1 + val2
END
$body$
LANGUAGE plpgsql
-- run function
SELECT add_two_nums(10,3);

-- PL/pgSQL
CREATE OR REPLACE FUNCTION get_some_data(IN any_id INT, OUT first_name VARCHAR, OUT last_name VARCHAR) AS
$body$
BEGIN
    SELECT first_name, last_name INTO firstName, lastName
    FROM person
    WHERE person.id = any_id
    LIMIT 1
END
$body$
LANGUAGE plpgsql
-- run function
SELECT get_some_data(10);

-- PL/pgSQL
CREATE OR REPLACE FUNCTION return_query() RETURNS SETOF return_query_record AS
$body$
BEGIN
    RETURN QUERY
    SELECT *
    FROM person
END
$body$
LANGUAGE plpgsql
-- run function
SELECT return_query();
SELECT return_query().*;
SELECT return_query().first_name;
