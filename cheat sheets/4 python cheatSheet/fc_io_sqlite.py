
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SQLITE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@

import sqlite3
from pathlib import Path

# run query through function
def query_method(the_cursor):
    try:
        result_set = the_cursor.execute(
            "SELECT ID, FName, LName, Age, Address, HireDate FROM Employees")
        # You receive a cursor object which is a iterable
        # one row is a tuple
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

# ---------- set dirs and files ----------

working_directory_path = Path(r"C:\Users\mlade\Documents")
working_directory_file = working_directory_path / Path('test.db')

# ---------- set database ----------

# connect() will open or create an SQLite database
db_conn = sqlite3.connect(working_directory_file)

# A cursor is used to traverse the records of a result
the_cursor = db_conn.cursor()

# ---------- execute sql ----------

# You can delete a table if it exists
db_conn.execute("DROP TABLE IF EXISTS Employees")
db_conn.commit()

# create table
db_conn.execute(
    "CREATE TABLE Employees(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT "
    "NULL, FName TEXT NOT NULL, LName TEXT NOT NULL, Age INT NOT NULL, "
    "Address TEXT, Salary REAL, HireDate TEXT);")
db_conn.commit()

# insert
db_conn.execute(
    "INSERT INTO Employees (FName, LName, Age, Address, Salary, HireDate)"
    "VALUES ('Derek', 'Banas', 41, '123 Main St', '500,000', date('now'))"
)
db_conn.commit()

# also insert
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

# ---------- methods ----------

# Undo the last commit()
db_conn.rollback()

# ---------- get data ----------

# Retrieve data with cursor
the_cursor.execute("SELECT ID, FName, LName, Age, Address, HireDate FROM Employees")

# returns records in a list/tuple
list_result_set = the_cursor.fetchall()
list_result_set = the_cursor.fetchmany(3)
tuple_result_set = the_cursor.fetchone()

# run query through function above
query_method(the_cursor)

# closes cursor
the_cursor.close()

# Closes the database connection
db_conn.close()

# delete database
working_directory_file.unlink(missing_ok=False)
