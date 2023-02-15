
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ MODULES USAGE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# You can import module by listing the file name minus the py
import ba_modules
# When you use import you access methods by referencing the module & method
a = ba_modules.add(1, 2)

# when use from you specify which methods will be imported (one, more or all)
from ba_modules import add
from ba_modules import add, mult
from ba_modules import *
# You don't have to reference the module name now
b = add(1, 2)

# We create an alias to avoid conflicts with methods with the same name
from ba_modules import add as a
from math import pi, pow as power, sin as sinus
c = a(1, 2)

# for reloading/rerunning module already imported module
import importlib
# importlib.import_module(ba_modules)  # this is instead of import ba_modules
importlib.reload(ba_modules)

# example calling standard elements from module
import math
e = math.pi
f = math.sin(math.pi/2)

# returning module file path
d = ba_modules.__file__
