
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ IO FILES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import sys
import os

# example data for windows/linux

# windows
directory_path = 'C:/Users/m/Desktop'
# or with method and no double slash
full_path_2 = os.path.join('C:/Users/m/Desktop', 'test.txt')

# linux
# directory_path = '/home/mmm/Desktop'
# or with method and no double slash
# full_path_2 = os.path.join('/home/mmm/Desktop', 'test.txt')

# windows & linux
file_path = '/test.txt'
full_path = directory_path + file_path

# ---------- DIRS ----------

# Display current directory
current_working_directory = os.getcwd()

# List directory
list_of_files_in_current_working_directory = os.listdir(directory_path)

# get list of files in current working directory containing executing script
list_of_files_in_current_working_directory = os.listdir(os.path.dirname(sys.argv[0]))

# Loop through directory
for file in os.listdir(directory_path):
    a = file

# Create a directory inside current working directory
os.mkdir("mydir")

# Remove a directory
os.rmdir("mydir")

# recursive create all directories to contain leaf
os.makedirs('C:/Users/m/Desktop/testing/testing')

# remove a directories
os.rmdir('C:/Users/m/Desktop/testing/testing')
os.rmdir('C:/Users/m/Desktop/testing')

# Change directories to specified path
os.chdir("C:/Users/m/Desktop")

# move back 1 directory
os.chdir("..")

# ---------- READ / WRITE ----------

# create or use an already created file with open, which requires closing
# with with guarantees the file will be closed if the program crashes
# Text is stored using unicode where numbers represent all characters

# If you use w (write) for mode then the file is overwritten.
# If you use a (append) you add to the end of the file

# encoding optional
# mode is optional for reading

# write
myFile = open(full_path, mode='a', encoding='utf-8')
# try (optionally for write)
myFile.write('ttext\nttext')
# finally (optionally for close)
myFile.close()

# read
myFile = open(full_path, encoding='utf-8')
for line in myFile:
    a = line
myFile.close()

# with write
with open(full_path, mode="w", encoding="utf-8") as myFile:
    myFile.write("Some random text\nMore random text\nAnd some more")

# with read, For reading do not provide a mode at all
with open(full_path, encoding="utf-8") as myFile:

    # We can read data in a few ways

    # 1. basic
    for line in myFile:
        a = line

    # 2. read() read everything into string or number of characters provided
    read_string = myFile.read()
    read_string = myFile.read(10)

    # 3. readline() reads one line up to newline (\n)
    lineNum = 1
    while True:
        line = myFile.readline()
        # if there is no more lines of data to read
        if not line:
            break
        print("Line", lineNum, " :", line, end="")

        wordList = line.split()

        lineNum += 1

    # 4. readlines() returns a list of lines (\n included in each)
    line_list = myFile.readlines()

# ---------- FILES ----------

# Get the file name
print(myFile.name)

# Get the access mode of the file
print(myFile.mode)

# Find out if the file is closed
print(myFile.closed)

# Rename our file
os.rename(full_path, full_path_2)

# as rename except it creates recursively any intermediate directories needed
# to make the new pathname
os.renames(full_path, full_path_2)

# Delete a file
os.remove(full_path_2)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ IO FILES SEEK @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# example for windows
file = open('C:/Users/m/Desktop/test.txt', mode='a', encoding='utf-8')
file.write('ttexttesttexttest\nttexttesttexttest')
file.close()
file = open('C:/Users/m/Desktop/test.txt')

# examples for linux
# file = open('/home/mmm/Desktop/mouse_speed.txt')

# tell returns current position of reader
a = file.tell()
print('check position: ', a)

# read reads string
a = file.read(10)
print('read something: \n' + a)

a = file.tell()
print('check position: ', a)

# move position of reader
a = file.seek(2)
print('move position to: ', a)

a = file.tell()
print('check position: ', a)

# or move relative based on current position
a = file.seek(file.tell() +5)
print('move position to: ', a)

a = file.tell()
print('check position: ', a)

# delete example for windows
file.close()
os.remove('C:/Users/m/Desktop/test.txt')
