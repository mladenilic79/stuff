
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ IO FILES PATHLIB @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import pathlib
import shutil

# ---------- set paths ----------

# windows
# this is pathlib path object, use raw strings
working_directory_path_2 = pathlib.Path(r"C:\Users\mlade\Documents")
# create path alternatively
working_directory_path_3 = pathlib.Path.home().joinpath("Documents")
# or concatenate two paths with /
working_directory_path_4 = working_directory_path_3 / pathlib.Path("archive")
# branching all way to leaf
working_directory_path_5 = working_directory_path_4.joinpath("leaf")
# print(working_directory_path/_2) returs C:\Users\mlade\Documents

# linux
# directory_path = '/home/mmm/Desktop'

# files
file_for_testing = working_directory_path_2.joinpath("textfile.txt")
file_for_testing_2 = working_directory_path_2 / pathlib.Path("textfile2.txt")

# ---------- dirs ----------

# get home directory
home_directory_path = pathlib.Path.home()
# on windows 11: C:\Users\mlade

# Display current directory
default_directory_path = pathlib.Path.cwd()

# List directory
list_of_files_in_working_directory = working_directory_path_2.iterdir()
list_of_files_in_working_directory = list(list_of_files_in_working_directory)

# Create a directory inside current working directory
# if parents is true, any missing parents of this path are created as needed they are created with the default permissions without taking mode into account
# if exist_ok is false (the default), FileExistsError is raised if the target directory already exists
working_directory_path_4.mkdir(parents=True, exist_ok=True)

# Change directories to specified path
# generally no needed, use os library for that

# move back 1 directory
# generally no needed, use os library for that

# Remove a directory
working_directory_path_4.rmdir()

# recursive create all directories to leaf
working_directory_path_5.mkdir(parents=True, exist_ok=True)

# recursive removal of directories
shutil.rmtree(working_directory_path_4)

# ---------- read/write ----------

# create or use an already created file with open, which requires closing with with guarantees the file will be closed if the program crashes

# Text is stored using unicode where numbers represent all characters

# If you use w (write) for mode then the file is overwritten.
# If you use a (append) you add to the end of the file

# mode is optional for reading
# encoding optional

# simple write
file_for_testing.write_text("testing")

# simple read
content = file_for_testing.read_text()
content_list = content.splitlines()

# with write
# open from pathlib is just wrapper for regular open
# default parameters (mode='r', buffering=-1, encoding=None, errors=None, newline=None)
with file_for_testing.open(mode="a", encoding="utf-8", newline=None) as myFile:
    myFile.write("\nSome random text\nMore random text\nAnd some more")

# with read, for reading do not provide a mode at all
with file_for_testing.open(encoding="utf-8") as myFile:

    # We can read data in a few ways, uncomment only one method to test, will not work with multiple ways uncomment

    # 1. basic
    for line in myFile:
        a = line

    # 2. read() read everything into string or number of characters provided
    read_string = myFile.read()
    read_string = myFile.read(10)

    # 3. readline() reads one line up to newline (\n)
    line = myFile.readline()
    wordList = line.split()

    # 4. readlines() returns a list of lines (\n included in each)
    line_list = myFile.readlines()

# ---------- files ----------

# name: The filename without any directory
a = file_for_testing.name

# stem: The filename without the file extension
a = file_for_testing.stem

# suffix: The file extension
a = file_for_testing.suffix

# anchor: The part of the path before the directories
a = file_for_testing.anchor

# parent: The directory containing the file, or the parent directory if the path is a directory
a = file_for_testing.parent

# check if file exists
a = file_for_testing.exists()

# check if it's a file
a = file_for_testing.is_file()

# check if it's a dir
a = file_for_testing.is_dir()

# Get the access mode of the file
a = myFile.mode

# Find out if the file is open or closed
a = myFile.closed

# Rename and move file
file_for_testing.replace(file_for_testing_2)
file_for_testing_2.replace(file_for_testing)

# rename file without filetype just a name
file_for_testing.with_stem("new_name")

# open file
myFile = file_for_testing.open()

# tell returns current position of reader
a = myFile.tell()
print('check position: ', a)

# read reads string by number of characters
a = myFile.read(5)
print('read something: \n' + a)

# move position of reader by number of characters
a = myFile.seek(2)
print('move position to: ', a)

# close a file
myFile.close()

# create empty file
file_for_testing_2.touch()

# remove a file
file_for_testing.unlink(missing_ok=False)
file_for_testing_2.unlink(missing_ok=False)
