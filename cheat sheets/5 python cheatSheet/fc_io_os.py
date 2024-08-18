
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ IO FILES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import os
import shutil

# ---------- set paths ----------

# windows
# hardcode first slash as drive is not a directory
# this returns string
working_directory_path = os.path.join("C:\\", "Users", "mlade", "Documents")
# print(working_directory_path/_2) returs C:\Users\mlade\Documents

# linux
# directory_path = '/home/mmm/Desktop'

# files
file_for_testing = os.path.join(working_directory_path, "textfile.txt")
file_for_testing_2 = os.path.join(working_directory_path, "textfile2.txt")

# ---------- dirs ----------

# Display current directory
default_directory_path = os.getcwd()

# List directory
list_of_files_in_working_directory = os.listdir(working_directory_path)

# Create a directory inside current working directory
os.mkdir(working_directory_path + os.sep + "mydir")

# Change directories to specified path
os.chdir(working_directory_path + os.sep + "mydir")

# move back 1 directory
os.chdir("..")

# Remove a directory
os.rmdir(working_directory_path + os.sep + "mydir")

# recursive create all directories to contain leaf
os.makedirs(working_directory_path + os.sep + "mydir" + os.sep + "testing_outer" + os.sep + "testing_leaf")

# recursive removal of directories
shutil.rmtree(working_directory_path + os.sep + "mydir")

# ---------- read/write ----------

# create or use an already created file with open, which requires closing with with guarantees the file will be closed if the program crashes

# Text is stored using unicode where numbers represent all characters

# If you use w (write) for mode then the file is overwritten.
# If you use a (append) you add to the end of the file

# mode is optional for reading
# encoding optional

# write
myFile = open(file_for_testing, mode='w', encoding='utf-8')
# try (optionally for write)
myFile.write('ttext\nttext')
# finaly (optionally for close)
myFile.close()

# with write
with open(file_for_testing, mode="a", encoding="utf-8") as myFile:
    myFile.write("Some random text\nMore random text\nAnd some more")

# read, for reading do not provide a mode at all
myFile = open(file_for_testing, encoding='utf-8')
for line in myFile:
    a = line
myFile.close()

# with read, for reading do not provide a mode at all
with open(file_for_testing, encoding="utf-8") as myFile:

    # We can read data in a few ways, uncomment only one method to test, will not work with multiple ways uncomment

    # 1. basic
    for line in myFile:
        a = line

    # 2. read() read everything into string or number of characters provided
    read_string = myFile.read()
    read_string = myFile.read(10)
 
    # 3. readline() reads one line up to newline (\n)
    while True:
        line = myFile.readline()
        if not line:
            break
        wordList = line.split()

    # 4. readlines() returns a list of lines (\n included in each)
    line_list = myFile.readlines()

# ---------- files ----------

# Get the file name
a = myFile.name

# Get the access mode of the file
a = myFile.mode

# Find out if the file is open or closed
a = myFile.closed

# Rename our file
os.rename(file_for_testing, file_for_testing_2)

# as rename except it creates recursively any intermediate directories needed to make the new pathname
os.renames(file_for_testing_2, file_for_testing)

myFile = open(file_for_testing)

# ---------- seek ----------

# tell returns current position of reader
a = myFile.tell()
print('check position: ', a)

# read reads string by number of characters
a = myFile.read(5)
print('read something: \n' + a)

# move position of reader by number of characters
a = myFile.seek(2)
print('move position to: ', a)

# ---------- close ----------

# close a file
myFile.close()

# remove a file
os.remove(file_for_testing)
