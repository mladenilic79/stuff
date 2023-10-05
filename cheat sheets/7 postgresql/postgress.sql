
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
    id int,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    gender VARCHAR(7),
    date_of_birth DATE,
)

-- create table
CREATE TABLE person(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender VARCHAR(7) NOT NULL,
    date_of_birth DATE NOT NULL,
    email VARCHAR(150),
    country_of_birth VARCHAR(50)
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
SELECT * FROM person;
SELECT first_name, last_name FROM person;
SELECT * FROM person ORDER BY last_name; -- asscending is default
SELECT * FROM person ORDER BY last_name ASC;
SELECT * FROM person ORDER BY last_name DESC;
SELECT * FROM person ORDER BY first_name, last_name; -- combine order

-- query functions
SELECT DISTINCT country_of_birth FROM person ORDER BY country_of_birth;
