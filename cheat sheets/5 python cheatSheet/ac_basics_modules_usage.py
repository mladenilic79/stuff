
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ MODULES USAGE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# import from unreleated directory
import sys
sys.path.append("../") # here one directory above

# You can import module by listing the file name minus the py
import ac_basics_modules_example
# When you use import you access element by referencing the module & element
a = ac_basics_modules_example.add(1, 2)
a = ac_basics_modules_example.variable
a = ac_basics_modules_example.Example()

# when use from you specify which elements will be imported (one, more or all)
from ac_basics_modules_example import add
from ac_basics_modules_example import add, mult
from ac_basics_modules_example import *
# You don't have to reference the module name now
b = add(1, 2)

# We create an alias to avoid conflicts with methods with the same name
from ac_basics_modules_example import add as a

# multiple import
from math import pi, pow as power, sin as sinus

# for reloading/rerunning module already imported module
import importlib
# importlib.import_module(ba_modules)  # this is instead of import ba_modules
importlib.reload(ac_basics_modules_example)
