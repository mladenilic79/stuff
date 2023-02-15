
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
