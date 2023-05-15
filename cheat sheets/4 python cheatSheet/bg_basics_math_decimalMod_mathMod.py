
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DECIMAL MODULE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# The decimal module provides for more accurate floating point calculations

from decimal import Decimal

num = Decimal(0)
num += Decimal("0.05")
num -= Decimal("0.03")
print(num)

# regular float
num = 0
num += 0.05
num -= 0.03
print(num)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ MATH MODULE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import math

# constants
a = math.e
b = math.pi

# Return remainder of division
c = math.fmod(5, 4)

# rounding
d = math.ceil(4.4)
e = math.floor(4.4)

# rounding number positive & negative closer to zero
f = math.trunc(4.2)

# absolute value
g = math.fabs(-4.4)

# Return x^y
j = math.pow(3, 3)

# Return the square root
k = math.sqrt(36)

# Return e^x
l = math.exp(4)

# natural logarithm e * e * e ~= 20
# so log(20) tells you that e^3 ~= 20
m = math.log(20)

# You can define the base and 10^3 = 1000
o = math.log(1000, 10)

# You can also use base 10 like this
p = math.log10(1000)

# We have the following trig functions
# sin, cos, tan, asin, acos, atan, atan2, asinh, acosh,
# atanh, sinh, cosh, tanh

# Convert radians to degrees and vice versa
q = math.degrees(1.5708)
r = math.radians(90)

# Factorial = 1 * 2 * 3 * 4
s = math.factorial(4)
