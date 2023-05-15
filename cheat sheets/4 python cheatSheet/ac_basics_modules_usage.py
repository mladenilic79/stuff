
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ MODULES USAGE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# You can import module by listing the file name minus the py
import ab_basics_modules_example
# When you use import you access element by referencing the module & element
a = ab_basics_modules_example.add(1, 2)
a = ab_basics_modules_example.variable
a = ab_basics_modules_example.Example()

# when use from you specify which elements will be imported (one, more or all)
from ab_basics_modules_example import add
from ab_basics_modules_example import add, mult
from ab_basics_modules_example import *
# You don't have to reference the module name now
b = add(1, 2)

# We create an alias to avoid conflicts with methods with the same name
from ab_basics_modules_example import add as a

# multiple import
from math import pi, pow as power, sin as sinus

# for reloading/rerunning module already imported module
import importlib
# importlib.import_module(ba_modules)  # this is instead of import ba_modules
importlib.reload(ab_basics_modules_example)
