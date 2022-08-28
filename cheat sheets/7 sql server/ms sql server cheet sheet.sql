
/*
    basics
    datatypes
    operators
    structure
        database
        schema
        synonym
    tables master
    tables constraints
        computed column
    indexes
    temporaty tables
    copying tables
        select into
        insert into select
    tables delete & alter
    crud
    query
    subquery
    sets
    views
    variables
    flow
    functions
    user functions
    advanced functions
        table variables
        table valued functions
    procedures
    exceptions
    triggers
    custor
    dynamic sql
    cte common table expressions
    sequence
    pivot
    sql injection
*/

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ BASICS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- single line comment
/* multi line
comment */

-- ; is a command terminator
-- GO is a batch terminator

-- BEGIN...END statement is used to define a statement block (batch). which consists of a set of SQL statements that execute together. The statement block can be nested
-- often used for stored procedure or function. But it is not strictly necessary. However is required for the IF ELSE statements, WHILE statements, etc., where you need to wrap multiple statements
BEGIN
END

-- returns version of sql server
select @@version;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ DATATYPES @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ datatypes numbers & bits @@@@@@@@@@

/*
    tinyint, smallint, int, bigint
        bigint_col BIGINT
    decimal / numeric / dec
        decimal_num DECIMAL(p,s)
        p - precision
        s - num of digits right of decimal point
    bit (0 or false, 1 or true, null)(converts any non 0 value to 1)
        bit_col BIT
    float
        val FLOAT[(n)]
        Where n is the number of bits that are used to store the mantissa of the float number in scientific notation and, therefore, dictates the precision and storage size. If n is specified, it must be a value between 1 and 53. The default value of n is 53, real equivalent is float(24), double equivalent is float(53)
    money & small money (stored significant to two decimal places)
        val MONEY
        val SMALLMONEY
*/

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ datatypes strings @@@@@@@@@@

/*
    char / character (fixed length string, store ascii, up to 8000 characters, adds trailing spaces to fill specified length, if you don't specify length it defaults to 1)
        val CHAR(3)
        val CHAR
    nchar (fixed length string, store unicode, up to 4000 characters, must prefix unicode characters with N on insert, adds trailing spaces to fill specified length, if you don't specify length it defaults to 1)
        val NCHAR(1)
    varchar (variable length, store ascii, up to 8000 characters, if you don't specify length it defaults to 1)
        val VARCHAR
        val VARCHAR(7)
    nvarchar (variable length, store unicode, up to 4000 characters, must prefix unicode characters with N on insert, if you don't specify length it defaults to 1
        val NVARCHAR
        val NVARCHAR(10)
*/

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ datatypes date & time @@@@@@@@@@

/*
    datetime2 [(fractional seconds precision)](fractional seconds precision is optional & goes from 0 to 7, store date and time)
        column_name DATETIME2(3)
        format is: YYYY-MM-DD hh:mm:ss[.fractional seconds]
        insert current value with: GETDATE()
        or with: '2018-06-23 07:30:20'
        add default current time with:
            ALTER TABLE production.product_colors 
            ADD CONSTRAINT df_current_time 
            DEFAULT CURRENT_TIMESTAMP FOR created_at;
    date (store date only)
        val DATE
        format is: YYYY-DD-MM / '2016-01-05'
    time[(fractional second scale)] (fractional second scale ranges from 0 to 7 & defaults to 7 if not specified, defines a time of a day based on 24-hour clock)
        start_at TIME(0)
        format is: hh:mm:ss[.nnnnnnn]
    datetimeoffset [(fractional seconds precision)] (for time zones)
        column_name DATETIMEOFFSET(7)
        format is: YYYY-MM-DDThh:mm:ss[.nnnnnnn][{+|-}hh:mm] (2020-12-12 11:30:30.12345)
        or by iso: 	YYYY-MM-DDThh:mm:ss[.nnnnnnn]Z (2020-12-12 19:30:30.12345Z.)
        inserting value in datetimeoffset field:
            INSERT INTO messages(message,created_at)
            VALUES('DATETIMEOFFSET demo',
            CAST('2019-02-28 01:45:00.0000000 -08:00' AS DATETIMEOFFSET));
*/

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ datatypes guid @@@@@@@@@@

-- A globally unique identifier or GUID is guaranteed to be unique across tables, databases, and even servers, 16-byte binary data type, which is generated by using the NEWID() function

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ OPERATORS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

/*
    arithmetic
    + 	    Add 	
    - 	    Subtract 	
    * 	    Multiply 	
    / 	    Divide 	
    % 	    Modulo

    bitwise
    & 	    Bitwise AND
    | 	    Bitwise OR
    ^ 	    Bitwise exclusive OR

    comparison
    = 	    Equal to 	
    > 	    Greater than 	
    < 	    Less than 	
    >= 	    Greater than or equal to 	
    <= 	    Less than or equal to 	
    <> 	    Not equal to

    compound
    += 	    Add equals
    -= 	    Subtract equals
    *= 	    Multiply equals
    /= 	    Divide equals
    %= 	    Modulo equals
    &= 	    Bitwise AND equals
    ^-=     Bitwise exclusive equals
    |*= 	Bitwise OR equals

    logical
    ALL 	        TRUE if all of the subquery values meet the condition 	
    AND 	        TRUE if all the conditions separated by AND is TRUE 	
    ANY 	        TRUE if any of the subquery values meet the condition 	
    BETWEEN         TRUE if the operand is within the range of comparisons 
            (start & end value are included) (if any input to the BETWEEN or NOT BETWEEN is NULL, then the result is UNKNOWN)
    EXISTS 	        TRUE if the subquery returns one or more records 	
    IN 	            TRUE if the operand is equal to one of a list of expressions
            (replace multiple OR with IN) (if a list contains NULL, the result of IN or NOT IN will be UNKNOWN)
    LIKE 	        TRUE if the operand matches a pattern 	
    NOT 	        Displays a record if the condition(s) is NOT TRUE 	
    OR 	            TRUE if any of the conditions separated by OR is TRUE 	
    SOME 	        TRUE if any of the subquery values meet the condition

    AND, OR and NOT - When you use more than one logical operator in an expression, SQL Server always evaluates the AND operators first. However, you can change the order of evaluation by using parentheses
*/

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ STRUCTURE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ database @@@@@@@@@@

CREATE DATABASE testDB;

DROP DATABASE Sales, NewSales;
DROP DATABASE IF EXISTS TestDb;

BACKUP DATABASE testDB
TO DISK = 'D:\backups\testDB.bak'; -- windows

BACKUP DATABASE testDB
TO DISK = 'home/mmm/testDB.bak'; -- ubuntu

-- backs up the parts of the database that have changed since the last full database backup
BACKUP DATABASE testDB
TO DISK = 'D:\backups\testDB.bak'
WITH DIFFERENTIAL; 

USE northwind;
USE master;  -- select master if you want to delete database

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ schema @@@@@@@@@@

/*
    A schema is a collection of database objects including tables, views, triggers, stored procedures, indexes, etc. A schema is associated with a username which is known as the schema owner, there are some pre-defined schemas which have the same names as the built-in database users and roles, for example: dbo, guest, sys, and INFORMATION_SCHEMA, The default schema for a newly created database is dbo, which is owned by the dbo user account. By default, when you create a new user with the CREATE USER command, the user will take dbo as its default schema
    [server_name].[database_name].[schema_name].object_name
*/

CREATE SCHEMA customer_services;
CREATE SCHEMA schema_name AUTHORIZATION owner_name;

-- alter schema

DROP SCHEMA schema_name;
DROP SCHEMA IF EXISTS schema_name;

-- use schema example
CREATE TABLE dbo.offices -- create table inside dbo schema
(
    office_id      INT PRIMARY KEY IDENTITY, 
    office_name    NVARCHAR(40) NOT NULL
);

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ synonym @@@@@@@@@@

/*
    synonym is an alias or alternative name for a database object such as a table, view, stored procedure, user-defined function or sequence
    [server_name].[database_name].[schema_name].object_name

    CREATE SYNONYM [schema_name_1.]synonym_name 
    FOR [server_name.][database_name.][schema_name_2.]object_name;

    DROP SYNONYM [IF EXISTS] [schema.]synonym_name  
*/

CREATE SYNONYM suppliers 
FOR test.purchasing.suppliers;

DROP SYNONYM synonym_name;
DROP SYNONYM IF EXISTS orders;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ TABLES MASTER @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- rename any object (table, index, column)
EXEC sp_rename 'sales.contr', 'contracts';

-- CREATE TABLE [database_name.][schema_name.]table_name
CREATE TABLE Persons (

    -- identity & primary key
    PersonID int IDENTITY(1,1) PRIMARY KEY,
    PersonID int IDENTITY(1,1) CONSTRAINT PK_Person PRIMARY KEY, -- ?????
    -- IDENTITY[(seed,increment)]
    -- identity for autoincrement, You must specify both the seed and increment or neither. If neither is specified, the default is (1,1)
    -- or named constraint
    PersonID int IDENTITY(1,1),
    CONSTRAINT PK_Person PRIMARY KEY (PersonID),
    -- or unnamed constraint
    PersonID int IDENTITY(1,1),
    PRIMARY KEY (PersonID),
    -- or multiple columns named constraint
    LastName varchar(255) NOT NULL,
    FirstName varchar(255) NOT NULL,
    CONSTRAINT PK_Person PRIMARY KEY (FirstName,LastName),
    -- or multiple columns unnamed constraint
    LastName varchar(255) NOT NULL,
    FirstName varchar(255) NOT NULL,
    PRIMARY KEY (FirstName,LastName),

    -- not null
    FirstName varchar NOT NULL,

    -- unique
    LastName varchar UNIQUE,
    -- or with named constraint
    LastName varchar,
    CONSTRAINT unique_name UNIQUE(LastName),
    -- or with unnamed constraint
    LastName varchar,
    UNIQUE(LastName),
    -- or on multiple columns with named constraint
    FirstName varchar,
    LastName varchar,
    CONSTRAINT UC_Person UNIQUE(FirstName,LastName),
    -- or on multiple columns with unnamed constraint
    FirstName varchar,
    LastName varchar,
    UNIQUE(FirstName,LastName),

    -- check
    Age int CHECK (Age>=18), -- unnamed
    Age int CONSTRAINT mature_age CHECK (Age>=18), -- named
    -- check constraint on multiple fields
    CONSTRAINT recheck CHECK (Age>=18 AND FirstName='Sandnes'), -- named
    CHECK(discounted_price < unit_price), -- unnamed

    -- default
    City varchar DEFAULT 'Sandnes', -- unnamed
    OrderDate date DEFAULT GETDATE(), -- unnamed, input system date
    column_b INT CONSTRAINT DF_column DEFAULT 50, -- named

/*
    foreign key general syntax:
    CONSTRAINT fk_constraint_name -- constraint keyword & name is optional, it will be automatically generated
    FOREIGN KEY (column_1, column2,...)
    REFERENCES parent_table_name(column1,column2,..)
    ON UPDATE action 
    ON DELETE action;
    (NO ACTION, CASCADE, SET NULL, and SET DEFAULT)
*/
    group_id int NOT NULL,
    CONSTRAINT fk_group
    FOREIGN KEY (group_id)
    REFERENCES People(group_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE, -- option one, using existing column
    -- or
    PersonID int NOT NULL
    CONSTRAINT fk_person
    FOREIGN KEY
    REFERENCES People(PersonID)
    ON DELETE CASCADE
    ON UPDATE CASCADE, -- option two, on the same line
    -- or
    -- foreign key on multiple columns
    ref_num int NOT NULL,
    ref_type int NOT NULL,
    CONSTRAINT fk_composite,
    FOREIGN KEY (ref_num, ref_type)
    REFERENCES accounts (acc_num, acc_type))
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    -- computed columns allows you to add a new column to a table with the value derived from the values of other columns in the same table
    -- if the expression is deterministic and you want to store the data of the computed column physically, use PERSISTED property
    -- column_name AS expression [PERSISTED],
    full_name AS (first_name + ' ' + last_name);
    full_name AS (first_name + ' ' + last_name) PERSISTED;

)

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ TABLES CONSTRAINTS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- return all constraints
SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE TABLE_NAME='tablename';

-- find unnamed constraint
EXEC sp_help 'table_name';

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ constraints primary key @@@@@@@@@@

-- add primary key named constraint
ALTER TABLE Persons
ADD CONSTRAINT PK_Person PRIMARY KEY (ID);
-- add primary key unnamed constraint
ALTER TABLE Persons
ADD PRIMARY KEY (ID);
-- add primary key on multiple tables named constraint
ALTER TABLE Persons
ADD CONSTRAINT PK_Person PRIMARY KEY (ID,LastName); 
-- add primary key on multiple tables unnamed constraint
ALTER TABLE Persons
ADD PRIMARY KEY (ID,LastName); 

-- delete primary key
ALTER TABLE Persons
DROP CONSTRAINT PK_Person; 

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ constraints not null @@@@@@@@@@

-- add not null
ALTER TABLE Persons
MODIFY Age int NOT NULL;
-- or
ALTER TABLE table_name
ALTER COLUMN column_name data_type NOT NULL;
-- remove not null
ALTER TABLE Persons
MODIFY Age int NULL;
-- or
ALTER TABLE table_name
ALTER COLUMN column_name data_type NULL;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ constraints unique @@@@@@@@@@

-- add unique named constraint
ALTER TABLE Persons
ADD CONSTRAINT constraint_name
UNIQUE (ID);
-- add unique unnamed constraint
ALTER TABLE Persons
ADD UNIQUE (ID);
-- add named constraint on multiple tables
ALTER TABLE Persons
ADD CONSTRAINT UC_Person
UNIQUE (ID,LastName);
-- add unnamed constraint on multiple tables
ALTER TABLE Persons
ADD UNIQUE (ID,LastName);

-- delete unique constraint
ALTER TABLE Persons
DROP CONSTRAINT UC_Person;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ constraints check @@@@@@@@@@

-- adding check unnamed
ALTER TABLE Persons
ADD CHECK (Age>=18);
-- adding check named
ALTER TABLE Persons
ADD CONSTRAINT CHK_PersonAge
CHECK (Age>=18);
-- add new column with check constraint unnamed
ALTER TABLE Persons
ADD Age int
CHECK(Age > 0);
-- add new column with check constraint named
ALTER TABLE Persons
ADD Age int
CONSTRAINT CHK_PersonAge CHECK(Age > 0);
-- adding check on multiple columns named
ALTER TABLE Persons
ADD CONSTRAINT CHK_PersonAge CHECK(Age>=18 AND City='Sandnes');
-- adding check on multiple columns unnamed
ALTER TABLE Persons
ADD CHECK(Age>=18 AND City='Sandnes');

-- deleting check constraint
ALTER TABLE Persons
DROP CONSTRAINT CHK_PersonAge;

-- disable check constraint for insert (nocheck ili no check ??????????????)
ALTER TABLE test.products
NO CHECK CONSTRAINT valid_price;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ constraints default @@@@@@@@@@

-- adding default
ALTER TABLE Persons
ADD CONSTRAINT df_City
DEFAULT 'Sandnes' FOR Column_City;

-- deleting default
ALTER TABLE Persons
ALTER COLUMN City DROP DEFAULT; 

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ constraints foreign key @@@@@@@@@@

-- column_PersonID int
ALTER TABLE Orders
ADD CONSTRAINT FK_orders_person
FOREIGN KEY (column_PersonID)
REFERENCES Persons(PersonID)
ON DELETE NO ACTION
ON UPDATE NO ACTION, 

-- on multiple columns
-- ref_num int NOT NULL,
-- ref_type int NOT NULL,
ALTER TABLE Orders
ADD CONSTRAINT FK_orders_person
FOREIGN KEY (ref_num, ref_type)
REFERENCES accounts (acc_num, acc_type) -- references composite key
ON DELETE CASCADE
ON UPDATE CASCADE,

-- delete foreign key constraint
ALTER TABLE Orders
DROP CONSTRAINT FK_PersonOrder; 

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ tables computed columns @@@@@@@@@@

ALTER TABLE persons
ADD full_name AS (first_name + ' ' + last_name);
-- or
ALTER TABLE persons
ADD full_name AS (first_name + ' ' + last_name) PERSISTED;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ INDEXES @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ clustered index @@@@@@@@@@

-- When you create a table with a primary key, SQL Server automatically creates a corresponding clustered index based on columns included in the primary key. Each table has only one clustered index because data rows can be only sorted in one order
-- If you add a primary key constraint to an existing table that already has a clustered index, SQL Server will enforce the primary key using a non-clustered index:
-- In case a table does not have a primary key or clustered index, which is very rare, you can use the CREATE CLUSTERED INDEX statement to define a clustered index for the table.

-- CREATE CLUSTERED INDEX index_name
-- ON schema_name.table_name (column_list);
CREATE CLUSTERED INDEX ix_parts_id
ON production.parts (part_id);

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ non clustered index @@@@@@@@@@

-- Unlike a clustered index, a nonclustered index sorts and stores data separately from the data rows in the table. It is a copy of selected columns of data from a table with the links to the associated table. A table may have one or more nonclustered indexes and each non-clustered index may include one or more columns of the table

-- CREATE [NONCLUSTERED] INDEX index_name
-- ON table_name(column_list);
CREATE INDEX ix_customers_city
ON sales.customers(city);
-- or for multiple columns, When you create a nonclustered index that consists of multiple columns, the order of the columns in the index is very important. You should place the columns that you often use to query data at the beginning of the column list.
CREATE INDEX ix_customers_name
ON sales.customers(last_name, first_name);

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ unique index @@@@@@@@@@

-- A unique index may consist of one or many columns. If a unique index has one column, the values in this column will be unique. In case the unique index has multiple columns, the combination of values in these columns is unique. A unique index can be clustered or non-clustered

CREATE UNIQUE INDEX index_name
ON table_name(column_list);
-- or multiple columns
CREATE UNIQUE INDEX ix_uniq_ab 
ON t1(a, b);

-- Both unique index and UNIQUE constraint enforce the uniqueness of values in one or many columns. When you create a unique constraint, behind the scene, SQL Server creates a unique index associated with this constraint. However, creating a unique constraint on columns make the objective of the unique index clear

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ indexes with included columns @@@@@@@@@@

-- To help reduce key lookup cost, SQL Server allows you to extend the functionality of a non-clustered index by including non-key columns. By including non-key columns in non-clustered indexes, you can create nonclustered indexes that cover more queries because all columns in the query are included in the index;

-- CREATE [UNIQUE] INDEX index_name
-- ON table_name(key_column_list)
-- INCLUDE(included_column_list);
CREATE UNIQUE INDEX ix_cust_email_inc
ON sales.customers(email)
INCLUDE(first_name,last_name);

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ indexes on computed columns @@@@@@@@@@

-- The functions involved in the computed column expression must have the same owner as the table
-- The computed column expression must be deterministic. It means that expression always returns the same result for a given set of inputs
-- The computed column must be precise, which means its expression must not contain any FLOAT or REAL data types

-- create index on a computed column
CREATE INDEX ix_cust_email_local_part
ON sales.customers(email_local_part);

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ filtered indexes @@@@@@@@@@

-- A filtered index is a nonclustered index with a predicate that allows you to specify which rows should be added to the index.

-- CREATE INDEX index_name
-- ON table_name(column_list)
-- WHERE predicate;
CREATE INDEX ix_cust_phone
ON sales.customers(phone)
WHERE phone IS NOT NULL;

-- Note that to improve the key lookup, you can use an index with included columns, which includes both first_name and last_name columns in the index:	
CREATE INDEX ix_cust_phone
ON sales.customers(phone)
INCLUDE (first_name, last_name)
WHERE phone IS NOT NULL;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ rename index @@@@@@@@@@

-- rename any object (table, index, column)
EXEC sp_rename 
    index_name, 
    new_index_name, 
    N'INDEX';  
-- or you can use the explicit parameters:
EXEC sp_rename 
    @objname = N'index_name', 
    @newname = N'new_index_name',   
    @objtype = N'INDEX';

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ disable index @@@@@@@@@@

-- When you disable an index on a table, SQL Server keeps the index definition in the metadata and the index statistics in nonclustered indexes. However, if you disable a nonclustered or clustered index on a view, SQL Server will physically delete all the index data
-- If you disable a clustered index of a table, you cannot access the table data using data manipulation language such as SELECT, INSERT, UPDATE, and DELETE until you rebuild or drop the index

-- disable index
ALTER INDEX index_name
ON table_name
DISABLE;
-- To disable all indexes of a table, you use the following form of the ALTER INDEX statement:	
ALTER INDEX ALL
ON table_name
DISABLE;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ enable index @@@@@@@@@@

-- This statement uses the ALTER INDEX statement to enable an index on a table
ALTER INDEX index_name 
ON table_name  
REBUILD;

-- This statement uses the CREATE INDEX statement to enable the disabled index and recreate it
CREATE INDEX index_name 
ON table_name(column_list)
WITH(DROP_EXISTING=ON)

-- The following statement uses the ALTER INDEX statement to enable all disabled indexes on a table	
ALTER INDEX ALL
ON table_name
REBUILD;

-- This statement uses the DBCC DBREINDEX to enable an index on a table	
DBCC DBREINDEX (table_name, index_name);

-- This statement uses the DBCC DBREINDEX to enable all indexes on a table
DBCC DBREINDEX (table_name, " ");  

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ drop index @@@@@@@@@@

-- The DROP INDEX statement does not remove indexes created by PRIMARY KEY or UNIQUE constraints. To drop indexes associated with these constraints, you use the ALTER TABLE DROP CONSTRAINT statement.

-- DROP INDEX [IF EXISTS] index_name
-- ON table_name;
DROP INDEX IF EXISTS ix_cust_email
ON sales.customers;

-- DROP INDEX [IF EXISTS] 
--     index_name1 ON table_name1,
--     index_name2 ON table_name2,
--     ...;
DROP INDEX 
    ix_cust_city ON sales.customers,
    ix_cust_fullname ON sales.customers;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ TEMPORATY TABLES @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- create temporary table with hash symbol
-- temporary tables are only accessible within the session that created them
CREATE TABLE #haro_products (
    product_name VARCHAR(MAX),
);

-- for temporary table that is accessible across connections, use global temporary tables
-- create global temporary table with double hash symbol
CREATE TABLE ##heller_products (
    product_name VARCHAR(MAX),
);

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ COPYING TABLES  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ copying table @@@@@@@@@@

-- create new table using existing table, new table will be filled with existing values from old table

CREATE TABLE TestTable AS
SELECT customername, contactname
FROM customers; 

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ select into @@@@@@@@@@

-- The SELECT INTO statement copies data from one table into a new table, does not copy constraints such as primary key and indexes from the source table to the destination table

-- creates a copy of data
SELECT * INTO TestDb.dbo.customers
FROM Customers
WHERE Country = 'Germany'; 

-- creates a backup copy of Customers in another database
SELECT * INTO CustomersBackup2017 IN 'Backup.mdb'
FROM Customers
WHERE Country = 'Germany';

-- This statement copies only a few columns into a new table
SELECT CustomerName, ContactName INTO CustomersBackup2017
FROM Customers; 

-- This statement copies data from more than one table into a new table:
SELECT Customers.CustomerName, Orders.OrderID
INTO CustomersOrderBackup2017
FROM Customers
    LEFT JOIN Orders
        ON Customers.CustomerID = Orders.CustomerID;

-- SELECT INTO can also be used to create a new, empty table using the schema of another. Just add a WHERE clause that causes the query to return no data
SELECT * INTO newtable
FROM oldtable
WHERE 1 = 0;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ insert into select @@@@@@@@@@

-- INSERT INTO SELECT statement copies data from one table and inserts it into another table, data types in source and target tables must match, existing records in the target table are unaffected, the columns that are not filled with data will contain NULL

-- Copy all columns from one table to another table
INSERT INTO Customers
SELECT *
FROM Suppliers
WHERE Country='Germany';

-- Copy only some columns from one table into another table
INSERT INTO Customers (CustomerName, City, Country)
SELECT SupplierName, City, Country 
FROM Suppliers
WHERE Country='Germany';

-- with TOP
INSERT TOP 10 
INTO sales.addresses (street, city, state, zip_code) 
SELECT street, city, state, zip_code
FROM sales.customers;

-- with TOP PERCENT	
INSERT TOP 10 PERCENT  
INTO sales.addresses (street, city, state, zip_code) 
SELECT street, city, state, zip_code
FROM sales.customers;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ TABLES DELETE & ALTER @@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ tables delete @@@@@@@@@@

-- delete table
-- DROP TABLE [database_name.][schema_name.]table_name_1,
--             [database_name.][schema_name.]table_name_2,
DROP TABLE Shippers;
DROP TABLE IF EXISTS Shippers;

-- delete all data
-- TRUNCATE TABLE [database_name.][schema_name.]table_name;
TRUNCATE TABLE Shippers; 

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ tables alter columns @@@@@@@@@@

-- add column
-- ALTER TABLE table_name
-- ADD column_name_1 data_type_1 column_constraint_1,
--     column_name_2 data_type_2 column_constraint_2;
ALTER TABLE Customers
ADD Email varchar(255);

-- drop column
-- ALTER TABLE table_name
-- DROP COLUMN column_name_1, column_name_2,...;
ALTER TABLE Customers
DROP COLUMN Email;

-- modify column datatype
-- ALTER TABLE table_name 
-- ALTER COLUMN column_name new_data_type(size);
ALTER TABLE Persons
ALTER COLUMN DateOfBirth year; 

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ CRUD @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ insert @@@@@@@@@@

-- insert (can skip id field if it is autoincremented)
-- to allow insert of specific value for id field in identity column enable IDENTITY_INSERT property first
SET IDENTITY_INSERT table_name ON;
SET IDENTITY_INSERT table_name OFF;

-- insert data into all columns
INSERT INTO Customers
VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');

-- insert data into specified columns
INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');

-- capture inserted values with OUTPUT
INSERT INTO promotions (promotion_name, discount, expired_date) 
OUTPUT inserted.promotion_id, inserted.promotion_name
VALUES ('2018 Winter Promotion', 0.2, '20181201');

-- inserting multiple records at once
INSERT INTO promotions (promotion_name, discount, expired_date)
VALUES ('2019 Summer Promotion', 0.15, '20190901'),
    ('2019 Fall Promotion', 0.20, '20191101'),
    ('2019 Winter Promotion', 0.25, '20200101');

-- inserting multiple records at once with OUTPUT data capturing
INSERT INTO promotions (promotion_name, discount, expired_date)
OUTPUT inserted.promotion_id, inserted.promotion_name --[INTO ...] --INTO @TableName
VALUES ('2020 Summer Promotion',0.25,'20200601','20200901'),
    ('2020 Fall Promotion',0.10,'20201001','20201101'),
    ('2020 Winter Promotion', 0.25,'20201201','20210101');

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ update @@@@@@@@@@

-- update single record
UPDATE Customers 
SET ContactName = 'Alfred Schmidt', City= 'Frankfurt' 
WHERE CustomerID = 1;

-- update multiple records
UPDATE Customers 
SET ContactName='Juan' 
WHERE Country='Mexico';

-- update inner join
UPDATE commissions
SET commissions.commission = commissions.base_amount * targets.percentage
FROM  sales.commissions
    INNER JOIN sales.targets
        ON sales.commissions.target_id = sales.targets.target_id;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ delete @@@@@@@@@@

-- delete one or more records
DELETE FROM Customers 
WHERE CustomerName='Alfreds Futterkiste';

-- delete all records from table
DELETE FROM Customers;

-- delete random records with TOP & TOP PERCENT
DELETE TOP 10 FROM target_table;
DELETE TOP 10 PERCENT FROM target_table;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ merge @@@@@@@@@@

-- merge statement runs insert, update & delete to synchronize table (target table) based on another table (source table)

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ QUERY @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

/*
    SELECT      (DISTINCT, TOP, AS)
    FROM        (AS, JOINS)
    WHERE       (LIKE, IS NULL)
    GROUP BY    (AGREGATION, GROUPING SETS, FUNCTIONS, CUBE, ROLLUP)
    HAVING      (AGREGATION)
    ORDER BY    (OFFSET & FETCH)
*/

-- enable query statistics
SET STATISTICS IO ON
GO

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ select, from, top & distinct @@@@@@@@@@

-- select, from, distinct
SELECT column1, column2 FROM table_name;
SELECT * FROM Customers;
SELECT DISTINCT Country FROM Customers;
SELECT DISTINCT Country, City FROM Customers; -- will return distinct/unique combination of fields/columns
SELECT COUNT(DISTINCT Country) FROM Customers;

-- top is replacement for limit from mysql
SELECT TOP (3) * FROM Customers; -- top 3, pharentesys optional
SELECT TOP 50 PERCENT * FROM Customers; -- top 50%
SELECT TOP 3 WITH TIES * FROM Customers; -- top 3 and all that match the value in the last row

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ aliases @@@@@@@@@@

-- AS can be used or not used
-- aliases only exists for the duration of the query
-- requires double quotation marks or square brackets if the alias name contains spaces
SELECT CustomerName AS Customer, ContactName AS [Contact Person] FROM Customers;
-- concatenation
SELECT CustomerName, Address + ', ' + City AS Address FROM Customers;
-- aliases for tables
SELECT o.OrderID, o.OrderDate, c.CustomerName
FROM Customers AS c, Orders AS o
WHERE c.CustomerName="Around the Horn"
    AND c.CustomerID=o.CustomerID;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ joins @@@@@@@@@@

SELECT Orders.OrderID, Customers.CustomerName
FROM Orders
INNER JOIN Customers
    ON Orders.CustomerID = Customers.CustomerID; 

SELECT Orders.OrderID, Customers.CustomerName, Shippers.ShipperName
FROM Orders
INNER JOIN Customers
    ON Orders.CustomerID = Customers.CustomerID
INNER JOIN Shippers
    ON Orders.ShipperID = Shippers.ShipperID; 

SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
LEFT JOIN Orders
    ON Customers.CustomerID = Orders.CustomerID;

SELECT Orders.OrderID, Employees.LastName, Employees.FirstName
FROM Orders
RIGHT JOIN Employees
    ON Orders.EmployeeID = Employees.EmployeeID;

SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
FULL OUTER JOIN Orders
    ON Customers.CustomerID=Orders.CustomerID;
-- add this line if you only want paired or unpaired data
WHERE CustomerID IS NULL OR OrderID IS NULL;
WHERE CustomerID IS NOT NULL OR OrderID IS NOT NULL;

-- self join (aliases for both tables)
SELECT *
FROM martian AS m
LEFT JOIN martian AS s
ON m.super_id = s.martian_id;
-- self join for comparison between records in same table (use > for single side)
SELECT
    c1.city,
    c1.first_name + ' ' + c1.last_name customer_1,
    c2.first_name + ' ' + c2.last_name customer_2
FROM sales.customers c1
INNER JOIN sales.customers c2 
    ON c1.customer_id > c2.customer_id
    AND c1.city = c2.city;
-- self join for comparison between records in same table (use <> for double side)
SELECT
    c1.city,
    c1.first_name + ' ' + c1.last_name customer_1,
    c2.first_name + ' ' + c2.last_name customer_2
FROM sales.customers c1
INNER JOIN sales.customers c2 
    ON c1.customer_id <> c2.customer_id
    AND c1.city = c2.city;

-- cross join joins every row from the first table with every row from the second table, returns a Cartesian product of rows from both tables, cross join doesn't establish relationship between two tables
SELECT product_id
FROM production.products
CROSS JOIN sales.stores;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ where @@@@@@@@@@

SELECT * FROM Customers WHERE CustomerID=1;
SELECT * FROM Customers WHERE Country='Mexico';
SELECT * FROM Customers WHERE Country='Germany' AND (City='Berlin' OR City='München'); 
SELECT * FROM Customers WHERE NOT Country='Germany' AND NOT Country='USA'; 

SELECT * FROM Customers WHERE Country NOT IN ('Germany', 'France', 'UK');
SELECT * FROM Customers WHERE Country IN (SELECT Country FROM Suppliers);

SELECT * FROM Products WHERE Price NOT BETWEEN 10 AND 20;
SELECT * FROM Products WHERE ProductName BETWEEN 'Carnarvon Tigers' AND 'Mozzarella di Giovanni';
SELECT * FROM Orders WHERE OrderDate BETWEEN #01/07/1996# AND #31/07/1996#;
SELECT * FROM Orders WHERE OrderDate BETWEEN '1996-07-01' AND '1996-07-31';

/*
    Normally, the result of a logical expression is TRUE or FALSE. However, when NULL is involved in the logical evaluation, the result is UNKNOWN
    NULL = 0, NULL <> 0, NULL > 0, NULL = NULL
    so this returns unknown & therefore empty result set
    SELECT customer_id, FROM sales.customers WHERE phone = NULL;
    right way below
*/
SELECT CustomerName FROM Customers WHERE Address IS NULL;
SELECT CustomerName FROM Customers WHERE Address IS NOT NULL;

/*
    %  The percent sign represents zero, one, or multiple characters
    _  The underscore represents a single character

    [] Represents any single character within the brackets  h[oa]t finds hot and hat, but not hit
    ^  Represents any character not in the brackets         h[^oa]t finds hit, but not hot and hat
    -  Represents a range of characters                     c[a-b]t finds cat and cbt
*/
SELECT * FROM Customers WHERE CustomerName LIKE '_r%';
SELECT * FROM Customers WHERE CustomerName NOT LIKE 'a__%';
SELECT * FROM Customers WHERE City LIKE '[bsp]%'; -- starting with b, s or p (matching single character)
SELECT * FROM Customers WHERE City LIKE '[a-c]%'; -- starting with any from range a, b or c (matching single character)
SELECT * FROM Customers WHERE City LIKE '[^a-c]%'; -- starting character not in the list or range

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ group by @@@@@@@@@@

--groups rows that have same values into summary rows, often used with aggregate functions (COUNT, MAX, MIN, SUM, AVG) to group by one or more columns

SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country;

SELECT Shippers.ShipperName, COUNT(Orders.OrderID) AS NumberOfOrders
FROM Orders
    LEFT JOIN Shippers
        ON Orders.ShipperID = Shippers.ShipperID
GROUP BY ShipperName;

-- grouping sets
-- grouping functions
-- cube
-- rollup

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ having @@@@@@@@@@

-- The HAVING clause was added to SQL because the WHERE keyword could not be used with aggregate functions
-- WHERE clause is applied first, then the results grouped, and finally the groups filtered according to the HAVING clause
-- in HAVING clause cannot be used aliases, must use full agregation expression

SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country
HAVING COUNT(CustomerID) > 5;

SELECT Employees.LastName, COUNT(Orders.OrderID) AS NumberOfOrders
FROM Orders
    INNER JOIN Employees
        ON Orders.EmployeeID = Employees.EmployeeID
WHERE LastName = 'Davolio'
    OR LastName = 'Fuller'
GROUP BY LastName
HAVING COUNT(Orders.OrderID) > 25;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ order by @@@@@@@@@@

SELECT * FROM Customers ORDER BY Country;
SELECT * FROM Customers ORDER BY Country DESC; 
SELECT * FROM Customers ORDER BY Country, CustomerName; -- first by country, than by costomer name
SELECT * FROM Customers ORDER BY Country ASC, CustomerName DESC;

SELECT * FROM Customers ORDER BY LEN(first_name) DESC; -- use function for sorting
SELECT * FROM Customers ORDER BY 1, 2; -- sort by columns in the select list

-- offset & fetch can only be used with ORDER BY
SELECT product_name, list_price
FROM production.products
ORDER By list_price, product_name 
OFFSET 10 ROWS -- offset (skip) first 10 records from result set
FETCH NEXT 10 ROWS ONLY; -- return next 10 records (fetch is optional)

SELECT product_name, list_price
FROM production.products
ORDER BY list_price, product_name 
OFFSET 10 ROWS;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ SUBQUERIES @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ general subqueries @@@@@@@@@@

-- subqueries can be in SELECT, FROM & WHERE
-- A subquery can be nested within another subquery. SQL Server supports up to 32 levels of nesting

-- subquery in select
SELECT order_id, order_date, (
        SELECT MAX (list_price)
        FROM sales.order_items
        WHERE sales.order_items.order_id = sales.orders.order_id
    ) AS max_list_price
FROM sales.orders;

-- subquery in from
SELECT s.supply_id, i.quantity, s.name, s.description
FROM (
        SELECT * 
        FROM inventory 
        WHERE base_id = 1
    ) AS i
    RIGHT JOIN supply AS s 
        ON i.supply_id = s.supply_id;

-- subquery in where
SELECT product_name, list_price
FROM production.products
WHERE list_price > (
        SELECT AVG (list_price)
        FROM production.products
        WHERE brand_id = 8
    );

SELECT order_id, order_date, customer_id
FROM sales.orders
WHERE customer_id IN (
        SELECT customer_id
        FROM sales.customers
        WHERE city = 'New York'
    );

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ correlated or repeating subqueries @@@@@@@@@@

-- subquery that uses the values of the outer query, depends on the outer query for its values, so it cannot be executed independently, and is executed repeatedly, once for each row

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ exists @@@@@@@@@@

-- used to test for the existence of any record in a subquery, returns true if the subquery returns one or more records

SELECT SupplierName
FROM Suppliers
WHERE EXISTS (
        SELECT ProductName 
        FROM Products 
        WHERE Products.SupplierID = Suppliers.supplierID
        AND Price < 20
    ); 

SELECT customer_id, first_name, last_name, city
FROM sales.customers c
WHERE NOT EXISTS (
        SELECT customer_id
        FROM sales.orders o
        WHERE o.customer_id = c.customer_id
        AND YEAR (order_date) = 2017
    );

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ any & all @@@@@@@@@@

-- The ANY and ALL operators are used with a WHERE or HAVING clause
-- The ANY operator returns true if any of the subquery values meet the condition
-- The ALL operator returns true if all of the subquery values meet the condition

SELECT product_name, list_price
FROM production.products
WHERE list_price > ALL (
        SELECT ProductID
        FROM production.products
        WHERE Quantity > 99
        GROUP BY brand_id
    );

SELECT product_name, list_price
FROM production.products
WHERE list_price = ANY (
        SELECT AVG (list_price)
        FROM production.products
        WHERE Quantity = 10
        GROUP BY brand_id
    );
	
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ SETS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- UNION used to combine the result-set of two or more SELECT statements, with the same number of columns, with similar data types, and in the same order
SELECT City, Country 
FROM Customers
WHERE Country='Germany'
UNION
SELECT City, Country 
FROM Suppliers
WHERE Country='Germany'
ORDER BY City;

-- UNION operator selects only distinct values by default. To allow duplicate values, use UNION ALL
SELECT City, Country 
FROM Customers
WHERE Country='Germany'
UNION ALL
SELECT City, Country 
FROM Suppliers
WHERE Country='Germany'
ORDER BY City;

-- EXCEPT subtracts one result set from another & returns distinct result set
SELECT product_id
FROM production.products
EXCEPT
SELECT product_id
FROM sales.order_items
ORDER BY city;

-- INTERSECT combines result sets of two or more queries and returns distinct rows that are output by both queries
SELECT city
FROM sales.customers
INTERSECT
SELECT city
FROM sales.stores
ORDER BY city;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ VIEW @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ list views @@@@@@@@@@

-- To list all views in a SQL Server Database, you query the sys.views or sys.objects catalog view
SELECT OBJECT_SCHEMA_NAME(v.object_id) schema_name, v.name
FROM sys.views as v;
-- or
SELECT OBJECT_SCHEMA_NAME(o.object_id) schema_name, o.name
FROM sys.objects as o
WHERE o.type = 'V';
-- stored procedure to wrap those queries inside
CREATE PROC usp_list_views(
        @schema_name AS VARCHAR(MAX)  = NULL,
        @view_name AS VARCHAR(MAX) = NULL
    )
AS
SELECT OBJECT_SCHEMA_NAME(v.object_id) schema_name, v.name view_name
FROM sys.views as v
WHERE 
    (@schema_name IS NULL OR OBJECT_SCHEMA_NAME(v.object_id) LIKE '%' + @schema_name + '%') AND
    (@view_name IS NULL OR v.name LIKE '%' + @view_name + '%');
-- procedure call with parameter passing
EXEC usp_show_views @view_name = 'sales'

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ show views info @@@@@@@@@@

-- Getting the view information using the sql.sql_module catalog (pass the name of the view in where)
SELECT definition, uses_ansi_nulls, uses_quoted_identifier, is_schema_bound
FROM sys.sql_modules
WHERE object_id = object_id('sales.daily_sales');

-- Getting view information using the sp_helptext stored procedure (pass view name)
EXEC sp_helptext 'sales.product_catalog' ;

-- Getting the view information using OBJECT_DEFINITION() function (pass name in pharenteses)
SELECT OBJECT_DEFINITION(
        OBJECT_ID('sales.staff_sales')
    ) view_info;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ create view @@@@@@@@@@

-- If you don’t explicitly specify a list of columns for the view (column list), SQL Server will use the column list derived from the SELECT statement
CREATE VIEW [OR ALTER] schema_name.view_name [(column_list)]
AS
select_statement;

-- create view default example
CREATE VIEW sales.daily_sales
AS
SELECT
    year(order_date) AS y,
    month(order_date) AS m,
    day(order_date) AS d,
    p.product_id,
    product_name,
    quantity * i.list_price AS sales
FROM sales.orders AS o
    INNER JOIN sales.order_items AS i
        ON o.order_id = i.order_id
    INNER JOIN production.products AS p
        ON p.product_id = i.product_id
WHERE Country = "Brazil";
-- call view
SELECT  * 
FROM sales.daily_sales
ORDER BY y, m, d, product_name;

-- create view, specify columns other then than called in select statement
CREATE OR ALTER sales.daily_sales (
    year, month, day, customer_name, product_id, product_name, sales
)
AS
SELECT
    year(order_date),
    month(order_date),
    day(order_date),
    concat(first_name, ' ', last_name),
    p.product_id,
    product_name,
    quantity * i.list_price
FROM sales.orders AS o
    INNER JOIN sales.order_items AS i
        ON o.order_id = i.order_id
    INNER JOIN production.products AS p
        ON p.product_id = i.product_id
    INNER JOIN sales.customers AS c
        ON c.customer_id = o.customer_id;
-- call view
SELECT * 
FROM sales.daily_sales
ORDER BY y, m, d, customer_name;

-- create view agregation example
CREATE VIEW sales.staff_sales (
        first_name, 
        last_name,
        year,
        amount
    )
AS
SELECT
    first_name,
    last_name,
    YEAR(order_date),
    SUM(list_price * quantity) amount
FROM sales.order_items i
    INNER JOIN sales.orders o
        ON i.order_id = o.order_id
    INNER JOIN sales.staffs s
        ON s.staff_id = o.staff_id
GROUP BY first_name, last_name, YEAR(order_date);
-- call view
SELECT *
FROM sales.staff_sales
ORDER BY first_name, last_name, year;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ indexed views @@@@@@@@

-- Unlike regular views, indexed views are materialized views that stores data physically like a table hence may provide some the performance benefit if they are used appropriately.

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ rename view @@@@@@@@@@

-- renaming view (must specify schema on current name)
EXEC sp_rename 
    @objname = 'sales.product_catalog',
    @newname = 'product_list';

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ delete view @@@@@@@@@@

-- DROP VIEW [IF EXISTS] 
--     schema_name.view_name1, 
--     schema_name.view_name2,
--     ...;
DROP VIEW Brazil_Customers;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ VARIABLES @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ variables basics @@@@@@@@@@

-- declaring variable, by default, its value is set to NULL
DECLARE @model_year AS SMALLINT;
-- or
DECLARE @model_year SMALLINT;
-- or multiple
DECLARE @model_year AS SMALLINT, 
        @product_name AS VARCHAR(MAX);

-- setting variable value
SET @model_year = 2018;

-- using variable
SELECT product_name, model_year, list_price 
FROM production.products
WHERE model_year = @model_year

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ variables storing @@@@@@@@@@

-- storing query result in a variable
SET @product_count = (
    SELECT COUNT(*) 
    FROM production.products 
);
-- output that value
SELECT @product_count;
-- Or you can use the PRINT statement to print out the content of a variable:	
PRINT @product_count;
-- or
PRINT 'The number of products is ' + CAST(@product_count AS VARCHAR(MAX));

-- storing & outputing record into variables
-- assign column names to variables
SELECT 
    @product_name = product_name, 
    @list_price = list_price
FROM production.products;
WHERE product_id = 100;
-- output content of the variables
SELECT 
    @product_name AS product_name, 
    @list_price AS list_price;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ FLOW @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ case @@@@@@@@@@

-- as CASE is an expression, you can use it in any clause that accepts an expression such as SELECT, WHERE, GROUP BY, and HAVING

SELECT OrderID, Quantity,
    CASE
        WHEN Quantity > 30 THEN "The quantity is greater than 30"
        WHEN Quantity = 30 THEN "The quantity is 30"
        ELSE "The quantity is under 30" -- else is optional
    END AS QuantityText
FROM OrderDetails;

SELECT CustomerName, City, Country
FROM Customers
ORDER BY
    CASE
        WHEN City IS NULL THEN Country
        ELSE City
    END; 

SELECT    
    CASE order_status
        WHEN 1 THEN 'Pending'
        WHEN 2 THEN 'Processing'
        WHEN 3 THEN 'Rejected'
        WHEN 4 THEN 'Completed'
    END AS order_status, 
    COUNT(order_id) order_count
FROM sales.orders
WHERE YEAR(order_date) = 2018
GROUP BY order_status;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ if else @@@@@@@@@@

-- Note that if the Boolean expression contains a SELECT statement, you must enclose the SELECT statement in parentheses

-- if
BEGIN
    DECLARE @sales INT;
 
    SELECT @sales = SUM(list_price * quantity)
    FROM sales.order_items i
        INNER JOIN sales.orders o ON o.order_id = i.order_id
    WHERE YEAR(order_date) = 2018;
 
    SELECT @sales;
 
    IF @sales > 1000000
        BEGIN
            PRINT 'Great! The sales amount in 2018 is greater than 1,000,000';
        END
END

-- if..else
BEGIN
    DECLARE @sales INT;
 
    SELECT @sales = SUM(list_price * quantity)
    FROM sales.order_items i
        INNER JOIN sales.orders o ON o.order_id = i.order_id
    WHERE YEAR(order_date) = 2017;
 
    SELECT @sales;
 
    IF @sales > 10000000
        BEGIN
            PRINT 'Great! The sales amount in 2018 is greater than 10,000,000';
        END
    ELSE
        BEGIN
            PRINT 'Sales amount in 2017 did not reach 10,000,000';
        END
END

-- nested if..else
BEGIN
    DECLARE @x INT = 10,
            @y INT = 20;
 
    IF (@x > 0)
        BEGIN
            IF (@x < @y)
                PRINT 'x > 0 and x < y';
            ELSE
                PRINT 'x > 0 and x >= y';
        END 
END

--@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ while @@@@@@@@@@

-- WHILE loop can be nested inside another WHILE loop, BREAK & CONTINUE statements only exits in the innermost loop in the WHILE statement, and can be used only inside the WHILE loop. The IF statement is often used with the BREAK/CONTINUE statements but it is not required

-- while
DECLARE @counter INT = 1;
WHILE @counter <= 5
    BEGIN
        PRINT @counter;
        SET @counter = @counter + 1;
    END

-- while with break
DECLARE @counter INT = 0;
WHILE @counter <= 5
    BEGIN
        SET @counter = @counter + 1;
        IF @counter = 4
            BREAK;
        PRINT @counter;
    END

-- while with continue
DECLARE @counter INT = 0;
WHILE @counter < 5
    BEGIN
        SET @counter = @counter + 1;
        IF @counter = 3
            CONTINUE; 
        PRINT @counter;
    END

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ FUNCTIONS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ conversion functions @@@@@@@@@@

-- CAST(expression AS datatype(length))
-- length. optional. The length of the resulting data type (for char, varchar, nchar, nvarchar, binary and varbinary)
SELECT CAST(25.65 AS int);

-- CONVERT(data_type(length), expression, style)
-- length. optional. The length of the resulting data type (for char, varchar, nchar, nvarchar, binary and varbinary)
-- style. Optional. The format used to convert between data types, such as a date or string format. Can be one of the following values: see online https://www.w3schools.com/sql/func_sqlserver_convert.asp
SELECT CONVERT(int, 25.65); 

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ math functions @@@@@@@@@@

-- ROUND(number, decimals, operation)
-- operation If 0, it rounds the result to the number of decimal. If another value than 0, it truncates the result to the number of decimals. Default value is 0
SELECT ROUND(235.415, 2) AS RoundValue; 

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ null functions @@@@@@@@@@

-- ISNULL() function lets you return an alternative value when an expression is NULL
SELECT ProductName, UnitPrice + ISNULL(UnitsOnOrder, 0) FROM Products; 

-- NULLIF expression accepts two arguments and returns NULL if two arguments are equal. Otherwise, it returns the first expression
SELECT NULLIF('Hello', 'Hello') result;

SELECT first_name, last_name, phone, -- return records without phones
FROM sales.leads
WHERE NULLIF(phone,'') IS NULL; -- if there is no phone return empty string instead of null

-- COALESCE expression is a syntactic sugar of the CASE expression
-- COALESCE accepts a number of arguments, evaluates them in sequence, and returns the first non-null argument, If all expressions evaluate to NULL, then returns NULL
SELECT COALESCE(NULL, 'Hi', 'Hello', NULL) result;
SELECT COALESCE(phone,'N/A') phone; -- returns phone if null return N/A

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ agregate functions @@@@@@@@@@

-- agregate functions
SELECT MIN(Price) FROM Products;
SELECT MAX(Price) FROM Products;
SELECT COUNT(ProductID) FROM Products;
SELECT AVG(Price) FROM Products;
SELECT SUM(quantity * list_price * (1 - discount)) FROM OrderDetails;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ system functions @@@@@@@@@@

-- object_id is an id of any object in database that is schema scoped
OBJECT_ID ( '[ database_name . ] schema_name . object_name' [ ,'object_type' ] )  

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ USER FUNCTIONS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

/*
SQL Server scalar function takes one or more parameters and returns a single value, Scalar functions can use logic such as IF blocks or WHILE loops, Scalar functions can call other functions
    CREATE FUNCTION [schema_name.]function_name (parameter_list)
    RETURNS data_type
    AS
        BEGIN
            statements
            RETURN value
        END
*/

-- example 1
CREATE FUNCTION sales.udfNetSale(
    @quantity INT,
    @list_price DEC(10,2),
    @discount DEC(4,2)
)
RETURNS DEC(10,2)
AS 
    BEGIN
        RETURN @quantity * @list_price * (1 - @discount);
    END;
-- function call is like for regular function
SELECT sales.udfNetSale(10,100,0.1) AS net_sale;

/*
modify scalar function
    ALTER FUNCTION [schema_name.]function_name (parameter_list)
    RETURN data_type 
    AS
        BEGIN
            statements
            RETURN value
        END
or
    CREATE OR ALTER FUNCTION [schema_name.]function_name (parameter_list)
    RETURN data_type
    AS
        BEGIN
            statements
            RETURN value
        END
*/

-- delete function with
-- DROP FUNCTION [schema_name.]function_name;	
DROP FUNCTION sales.udfNetSale;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ ADVANCED FUNCTIONS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ table variables @@@@@@@@@@

-- Table variables are kind of variables that allow you to hold rows of data, which are similar to a temporary tables, declare table variable with
DECLARE @table_variable_name TABLE (
    column_list
);
/*
    Similar to local variables, table variables are out of scope at the end of the batch. If you define a table variable in a stored procedure or user-defined function, the table variable will no longer exist after the stored procedure or user-defined function exits

    Should be used for holding a small number of rows

    you cannot use the table variable as an input or output parameter like other data types. However, you can return a table variable from a user-defined function

    if you are using a table variable with a join, you need to alias the table in order to execute the query so you cannot used @product_table in JOIN statement

    Using table variables in a stored procedure results in fewer recompilations than using a temporary table, In addition, a table variable use fewer resources than a temporary table with less locking and logging overhead
*/

-- example 1
DECLARE @product_table TABLE (
    product_name VARCHAR(MAX) NOT NULL,
    brand_id INT NOT NULL,
    list_price DEC(11,2) NOT NULL
);
-- Once declared, the table variable is empty. You can insert rows into the table variables using the INSERT statement
-- You cannot alter the structure of the table variable after the declaration
INSERT INTO @product_table
SELECT product_name, brand_id, list_price
FROM production.products
WHERE category_id = 1;
-- querying data with
SELECT *
FROM @product_table;
-- Note that you need to execute the whole batch or you will get an error
GO

-- example 2
-- user-defined function named ufnSplit() that returns a table variable
CREATE OR ALTER FUNCTION udfSplit(
    @string VARCHAR(MAX),
    @delimiter VARCHAR(50) = ' '
)
RETURNS @parts TABLE
(
    idx INT IDENTITY PRIMARY KEY,
    val VARCHAR(MAX)
)
AS
    BEGIN
        DECLARE @index INT = -1;
        WHILE (LEN(@string) > 0) 
            BEGIN 
                SET @index = CHARINDEX(@delimiter , @string)  ;
                IF (@index = 0) AND (LEN(@string) > 0)  
                    BEGIN  
                        INSERT INTO @parts 
                        VALUES (@string);
                        BREAK  
                    END 
                IF (@index > 1)  
                    BEGIN  
                        INSERT INTO @parts 
                        VALUES (LEFT(@string, @index - 1));
                        SET @string = RIGHT(@string, (LEN(@string) - @index));  
                    END 
                ELSE
                    SET @string = RIGHT(@string, (LEN(@string) - @index)); 
            END
        RETURN
    END
GO
-- calls the udfSplit() function:
SELECT * 
FROM udfSplit('foo,bar,baz',',');

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ table valued functions @@@@@@@@@@

-- The return type of a table-valued function is a table, therefore, you can use the table-valued function just like you would use a table

-- create table valued function
CREATE FUNCTION udfProductInYear (
    @model_year INT
)
RETURNS TABLE
AS
RETURN
    SELECT product_name, model_year, list_price
    FROM production.products
    WHERE model_year = @model_year;
-- calling table valued function
SELECT *
FROM udfProductInYear(2017);
-- specify columns to be returned
SELECT product_name, list_price
FROM udfProductInYear(2018);

-- modifying table valued function
ALTER FUNCTION udfProductInYear (
    @start_year INT,
    @end_year INT
)
RETURNS TABLE
AS
RETURN
    SELECT product_name, model_year, list_price
    FROM production.products
    WHERE model_year BETWEEN @start_year AND @end_year
-- calling function
SELECT product_name, model_year, list_price
FROM udfProductInYear(2017,2018)
ORDER BY product_name;

/*
    Multi-statement table-valued functions (MSTVF)

    A multi-statement table-valued function or MSTVF is a table-valued function that returns the result of multiple statements

    The multi-statement-table-valued function is very useful because you can execute multiple queries within the function and aggregate results into the returned table

    To define a multi-statement table-valued function, you use a table variable as the return value. Inside the function, you execute one or more queries and insert data into this table variable

    The following udfContacts() function combines staffs and customers into a single contact list
*/
CREATE FUNCTION udfContacts()
    RETURNS @contacts TABLE (
        first_name VARCHAR(50),
        last_name VARCHAR(50),
        email VARCHAR(255),
        phone VARCHAR(25),
        contact_type VARCHAR(20)
    )
AS
    BEGIN
        INSERT INTO @contacts
        SELECT first_name, last_name, email, phone, 'Staff'
        FROM sales.staffs;
    
        INSERT INTO @contacts
        SELECT first_name, last_name, email, phone, 'Customer'
        FROM sales.customers;
        
        RETURN;
    END;

/*
    delete function

    DROP FUNCTION [ IF EXISTS ] [ schema_name. ] function_name;

    or multiple

    DROP FUNCTION [IF EXISTS] 
        schema_name.function_name1, 
        schema_name.function_name2,
        ...;

    If the function that you want to remove is referenced by views or other functions created using the WITH SCHEMABINDING option, the DROP FUNCTION will fail.

    In addition, if there are constraints like CHECK or DEFAULT and computed columns that refer to the function, the DROP FUNCTION statement will also fail.
*/
DROP FUNCTION sales.udf_get_discount_amount;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ PROCEDURES @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ create procedure @@@@@@@@@@

-- CREATE PROCEDURE or CREATE PROC
CREATE PROC SelectAllCustomers
AS
-- If the stored procedure has one statement, the BEGIN and END keywords surrounding the statement are optional
BEGIN
    SELECT * 
    FROM Customers;
END
-- execute with EXECUTE or EXEC
EXEC SelectAllCustomers;

-- with parameters (pharentheses & AS are optional)?????
CREATE PROC SelectAllCustomers (@City AS nvarchar(30), @PostalCode AS nvarchar(10))
AS
BEGIN
    SELECT * 
    FROM Customers 
    WHERE City = @City 
        AND PostalCode = @PostalCode 
        AND product_name LIKE '%' + @City + '%';
END
-- execute
EXEC SelectAllCustomers @City = "London", @PostalCode = "WA1 1DP";
-- or
EXEC SelectAllCustomers "London", "WA1 1DP";

-- with optional/default parameters (pharentheses & AS are optional)?????
CREATE PROC SelectAllCustomers (@City AS nvarchar(30) = "sima", @PostalCode AS nvarchar(10) = "hera")
AS
BEGIN
    SELECT * 
    FROM Customers 
    WHERE City = @City 
        AND PostalCode = @PostalCode 
        AND product_name LIKE '%' + @City + '%';
END
-- execute
EXEC SelectAllCustomers @City = "London", @PostalCode = "WA1 1DP";
-- or with default parameters
EXEC SelectAllCustomers;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ edit & delete procedure @@@@@@@@@@

-- edit procedure with ALTER
ALTER PROCEDURE uspProductList
AS
BEGIN
    SELECT product_name, list_price
    FROM production.products
    ORDER BY list_price 
END;

-- delete stored procedure
DROP PROCEDURE sp_name;
DROP PROC sp_name;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ outputing parameters @@@@@@@@@@

-- stored procedure can have many output parameters
-- parameter_name data_type OUTPUT
CREATE PROCEDURE uspFindProductByModel (
    @model_year SMALLINT,
    @product_count INT OUTPUT
) AS
BEGIN
    SELECT product_name, list_price
    FROM production.products
    WHERE model_year = @model_year;
    -- @@ROWCOUNT Returns the number of rows affected by the last statement
    SELECT @product_count = @@ROWCOUNT;
END;
-- procedure call with output parameters
DECLARE @count INT;
EXEC uspFindProductByModel
    @model_year = 2018,
    @product_count = @count OUTPUT;
SELECT @count AS 'Number of products found';

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ EXCEPTIONS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ try catch @@@@@@@@@@

-- If the statements between the TRY block complete without an error, the statements between the CATCH block will not execute. However, if any statement inside the TRY block causes an exception, the control transfers to the statements in the CATCH block
BEGIN TRY  
   -- statements that may cause exceptions
END TRY 
BEGIN CATCH  
   -- statements that handle exception
END CATCH  

-- they can be nested
BEGIN TRY
    --- statements that may cause exceptions
    BEGIN TRY
        --- nested TRY block
    END TRY
    BEGIN CATCH
        --- nested CATCH block
    END CATCH
END TRY
BEGIN CATCH
    -- statements to handle exception
    BEGIN TRY
        --- nested TRY block
    END TRY
    BEGIN CATCH
        --- nested CATCH block
    END CATCH
END CATCH

/*
Inside the CATCH block, you can use the following functions to get the detailed information on the error that occurred:
    ERROR_LINE() returns the line number on which the exception occurred
    ERROR_MESSAGE() returns the complete text of the generated error message
    ERROR_PROCEDURE() returns the name of the stored procedure or trigger where the error occurred
    ERROR_NUMBER() returns the number of the error that occurred
    ERROR_SEVERITY() returns the severity level of the error that occurred
    ERROR_STATE() returns the state number of the error that occurred
*/
CREATE PROC usp_divide(
    @a decimal,
    @b decimal,
    @c decimal output
) AS
    BEGIN
        BEGIN TRY
            SET @c = @a / @b;
        END TRY
        BEGIN CATCH
            SELECT  
                ERROR_NUMBER() AS ErrorNumber  
                ,ERROR_SEVERITY() AS ErrorSeverity  
                ,ERROR_STATE() AS ErrorState  
                ,ERROR_PROCEDURE() AS ErrorProcedure  
                ,ERROR_LINE() AS ErrorLine  
                ,ERROR_MESSAGE() AS ErrorMessage;  
        END CATCH
    END;
GO
-- call
DECLARE @r2 decimal;
EXEC usp_divide 10, 0, @r2 output;
PRINT @r2;

/*
    Inside a CATCH block, you can test the state of transactions by using the XACT_STATE() function
    
    If the XACT_STATE() function returns -1, it means that an uncommittable transaction is pending, you should issue a ROLLBACK TRANSACTION statement.
    In case the XACT_STATE() function returns 1, it means that a committable transaction is pending. You can issue a COMMIT TRANSACTION statement in this case.
    If the XACT_STATE() function return 0, it means no transaction is pending, therefore, you don’t need to take any action

    It is a good practice to test your transaction state before issuing a COMMIT TRANSACTION or ROLLBACK TRANSACTION statement in a CATCH block to ensure consistency
*/
CREATE PROC usp_report_error
AS
    SELECT   
        ERROR_NUMBER() AS ErrorNumber  
        ,ERROR_SEVERITY() AS ErrorSeverity  
        ,ERROR_STATE() AS ErrorState  
        ,ERROR_LINE () AS ErrorLine  
        ,ERROR_PROCEDURE() AS ErrorProcedure  
        ,ERROR_MESSAGE() AS ErrorMessage;  
GO
-- and
CREATE PROC usp_delete_person(
    @person_id INT
) AS
BEGIN
    BEGIN TRY
        BEGIN TRANSACTION;
        -- delete the person
        DELETE FROM sales.persons
        WHERE person_id = @person_id;
        -- if DELETE succeeds, commit the transaction
        COMMIT TRANSACTION;  
    END TRY
    BEGIN CATCH
        -- report exception
        EXEC usp_report_error;
        
        -- Test if the transaction is uncommittable.  
        IF (XACT_STATE()) = -1  
        BEGIN  
            PRINT  N'The transaction is in an uncommittable state.' +  
                    'Rolling back transaction.'  
            ROLLBACK TRANSACTION;  
        END;  
        
        -- Test if the transaction is committable.  
        IF (XACT_STATE()) = 1  
        BEGIN  
            PRINT N'The transaction is committable.' +  
                'Committing transaction.'  
            COMMIT TRANSACTION;     
        END;  
    END CATCH
END;
GO
-- and call to catch error
EXEC usp_delete_person 2;
EXEC usp_delete_person 1;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ raise error @@@@@@@@@@

-- The RAISERROR statement allows you to generate your own error messages and return these messages back to the application using the same format as a system error or warning message generated by SQL Server Database Engine. In addition, the RAISERROR statement allows you to set a specific message id, level of severity, and state for the error messages

-- content & example for raise error missing

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ throw error @@@@@@@@@@

-- similar to raise error. The THROW statement raises an exception and transfers execution to a CATCH block of a TRY CATCH construct.

-- content & example for throw error missing

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ triggers @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- triggers content missing

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ CURSOR @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- A database cursor is an object that enables traversal over the rows of a result set. It allows you to process individual row returned by a query

DECLARE 
    @product_name VARCHAR(MAX), 
    @list_price   DECIMAL;
-- first declare cursor name
DECLARE cursor_product CURSOR
-- define result set
FOR SELECT product_name, list_price
    FROM production.products;
-- open cursor
OPEN cursor_product;
-- fetch a row from a cursor into a variable
-- this is a first record check.. if it's ok than enter loop
FETCH NEXT FROM cursor_product INTO 
    @product_name,
    @list_price;
-- @@FETCHSTATUS function that returns the status of the last cursor FETCH statement executed against the cursor
WHILE @@FETCH_STATUS = 0
-- If @@FETCHSTATUS returns 0, meaning the FETCH statement was successful. You can use the WHILE statement to fetch all rows from the cursor as shown in the following code
    BEGIN
        PRINT @product_name + CAST(@list_price AS varchar);
        FETCH NEXT FROM cursor_product INTO
            @product_name,
            @list_price;
    END;
-- close the cursor
CLOSE cursor_product;
-- dealocate/release the cursor 
DEALLOCATE cursor_product;

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ dynamic sql @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- Dynamic SQL is a programming technique that allows you to construct SQL statements dynamically at runtime. It allows you to create more general purpose and flexible SQL statement because the full text of the SQL statements may be unknown at compilation like table name

/*
    sp_execuresql definition
    EXEC sp_executesql 
        sql_statement  
        parameter_definition
        @param1 = value1,
        @param2 = value2,
        ...
*/

-- Creating a dynamic SQL is simple, you just need to make it a string as follows, Because the sp_executesql accepts the dynamic SQL as a Unicode string, you need to prefix it with an N
EXEC sp_executesql N'SELECT * FROM production.products';

-- example 1
-- Using dynamic SQL to query from any table example
DECLARE 
    @table NVARCHAR(128),
    @sql NVARCHAR(MAX);
SET @table = N'production.products';
SET @sql = N'SELECT * FROM ' + @table;
EXEC sp_executesql @sql;
-- and if wrap it in stored procedure
CREATE PROC usp_query (
    @table NVARCHAR(128)
)
AS
    BEGIN
        DECLARE @sql NVARCHAR(MAX);
        -- construct SQL
        SET @sql = N'SELECT * FROM ' + @table;
        -- execute the SQL
        EXEC sp_executesql @sql;
    END;
-- procedure call
EXEC usp_query 'production.brands';

-- example 2
EXEC sp_executesql
N'SELECT *
    FROM 
        production.products 
    WHERE 
        list_price> @listPrice AND
        category_id = @categoryId
    ORDER BY
        list_price DESC', 
N'@listPrice DECIMAL(10,2),
@categoryId INT'
,@listPrice = 100
,@categoryId = 1;

-- sql injection & QUOTENAME() function for dynamic sql missing content

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ CTE common table expressions @@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- common table expressions & recursive common table expressions

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ SEQUENCE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- sql server sequence

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ PIVOT @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- PIVOT operation

--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@ SQL INJECTION @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

/*
    danger of user input

    txtUserId = getRequestString("UserId");
    txtSQL = "SELECT * FROM Users WHERE UserId = " + txtUserId;

    on input: 105 OR 1=1
    select statement will become
    SELECT * FROM Users WHERE UserId = 105 OR 1=1;
    and will return all data

    or on input: 105; DROP TABLE Suppliers
    select statement will become
    SELECT * FROM Users WHERE UserId = 105; DROP TABLE Suppliers;
    and will drop your data

    uName = getRequestString("username");
    uPass = getRequestString("userpassword");
    sql = 'SELECT * FROM Users WHERE Name ="' + uName + '" AND Pass ="' + uPass + '"'
    on input: " or ""="  and " or ""="
    select statement will become
    SELECT * FROM Users WHERE Name ="" or ""="" AND Pass ="" or ""=""
    and will return all data

    always manage input in application not direcly in database
*/
