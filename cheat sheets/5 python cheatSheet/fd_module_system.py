
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SYSTEM MODULE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# sys module controls python interpreter
import sys

# some helpful information
# help(sys)

# list all constants, functions & methods
a = dir(sys)

# list all loaded modules
a = sys.modules

# list paths
for path in sys.path:
    a = path

# returns platform
a = sys.platform

# sys.argv is list, which contains command-line arguments passed to script
a = sys.argv

# get & set recursion information
a = sys.getrecursionlimit()
sys.setrecursionlimit(999)
