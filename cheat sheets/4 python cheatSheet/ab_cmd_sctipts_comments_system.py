
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ CMD PIP @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# pip install openpyxl
# pip install openpyxl --upgrade
# pip install pandas
# pip install pandas --upgrade

# @@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ CMD @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@

# enter python
# py or python or python3 or python3.8

# exit python
# exit() or quit()

# check python version with
# python -V

# (in shell only) the most recent variable is stored in variable _ 

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SCRIPTS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# python must be in path, else type full path to python
# go to directory containing script or type full path to script
# use any of those (some work on windows some on linux)
# pass command line parameters if needed
# py python_script.py
# python python_script.py
# python3 python_script.py arg1 arg2
# python3.8 python_script.py arg1 arg2

# running module as script
# -m option searches sys.path for module name and runs its content as __main__
# python -m python_module.py

# redirect output to text file
# python python_script.py > output.txt

# options for execution on linux without python keyword
# to make script universal for both unix/linux & windows put this line first in
# python script (with hash in front) to indicate path to interpreter
# (this is not needed for windows)
# #! /usr/bin/python  (search for absolute path, hardcoded)
# #! /usr/bin/env python  (search for environment variable - recommended way)
# go to directory containing script and assign execution permission
# chmod +x python_script.py
# execute with or if current directory
# ./script.py
# script.py
# there may be need to add script location to path somewhere

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ COMMENTS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# comments
# Single line comments are ignored by the interpreter
'''
So are multiline comments
'''

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ BASIC & MODULES SYS OS PLATFORM @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# sys module controls python interpreter
import sys

# getting size of arbitrary object
list = [1, 2, 3, 4, 5]
a = sys.getsizeof(list)

# check python version
a = sys.version_info
a = sys.version

# some helpful information
# help(sys)

# list all constants, functions & methods
a = dir(sys)

# list all loaded modules
a = sys.modules
# or
for path in sys.path:
    a = path

# returns platform
a = sys.platform

# sys.argv is list, which contains command-line arguments passed to script
a = sys.argv

# get & set recursion information
a = sys.getrecursionlimit()
sys.setrecursionlimit(999)

# interating with operating system
import os

# returns operating system (posix-linux, nt-windows, java)
a = os.name

# get current process id
a = os.getpid()

# platform identifying data
import platform

# get system platform
a = platform.system()
