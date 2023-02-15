
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SQLITE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@

import os
import sqlite3

# run query through function
def query_method():
    try:
        result_set = the_cursor.execute(
            "SELECT ID, FName, LName, Age, Address, HireDate FROM Employees")
        # You receive a list of lists that hold the result
        for row in result_set:
            id = row[0]
            fname = row[1]
            lname = row[2]
            age = row[3]
            address = row[4]
            hireDate = row[5]
    except sqlite3.OperationalError:
        print("The Table Doesn't Exist")
    except:
        print("Couldn't Retrieve Data From Database")

# connect() will open or create an SQLite database
# The file appears in the same directory as this Python file
db_conn = sqlite3.connect('test.db')

# A cursor is used to traverse the records of a result
the_cursor = db_conn.cursor()

# Get SQLite version
the_cursor.execute('SELECT SQLITE_VERSION()')
# fetchone() returns one result
SQLiteVersion = the_cursor.fetchone()

# Undo the last commit()
db_conn.rollback()

# create table
db_conn.execute(
    "CREATE TABLE Employees(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT "
    "NULL, FName TEXT NOT NULL, LName TEXT NOT NULL, Age INT NOT NULL, "
    "Address TEXT, Salary REAL, HireDate TEXT);")
db_conn.commit()

# You can delete a table if it exists like this
# db_conn.execute("DROP TABLE IF EXISTS Employees")
# db_conn.commit()

# You can add a new column to a table with ALTER
db_conn.execute(
    "ALTER TABLE Employees ADD COLUMN 'Image' BLOB DEFAULT NULL")
db_conn.commit()

# insert
db_conn.execute(
    "INSERT INTO Employees (FName, LName, Age, Address, Salary, HireDate)"
    "VALUES ('Derek', 'Banas', 41, '123 Main St', '500,000', date('now'))"
)
db_conn.commit()
db_conn.execute(
    "INSERT INTO Employees (FName, LName, Age, Address, Salary, HireDate)"
    "VALUES ('sima', 'Banas', 41, '123 Main St', '500,000', date('now'))"
)
db_conn.commit()

# update
db_conn.execute(
    "UPDATE Employees "
    "SET Address = '121 Main St' "
    "WHERE ID=2"
)
db_conn.commit()

# delete
db_conn.execute(
    "DELETE "
    "FROM Employees "
    "WHERE ID=5"
)
db_conn.commit()

# Retrieve table column names
the_cursor.execute("PRAGMA TABLE_INFO(Employees)")
# returns records in a list/tuple
list_result_set = the_cursor.fetchall()
list_result_set = the_cursor.fetchmany(3)
tuple_result_set = the_cursor.fetchone()

# run query through function above
query_method()

# closes cursor
the_cursor.close()

# Closes the database connection
db_conn.close()

# delete database
os.remove('test.db')
