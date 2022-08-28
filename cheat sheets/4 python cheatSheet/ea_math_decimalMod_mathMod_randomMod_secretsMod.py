
# @@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ MATH @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@

# basic operations
var1 = 2 + 3 - 5 * 3 / 2

# adding on the fly
a = 5
a += 1

# power
var2 = 5 ** 2

# floor division (positive round down, negative rounds up)
round_down = 10 // 3 # result 3
round_up = - 10 // 3 # result - 4

# Use modulus on the values to find the remainder
remainder = 3 % 2

# rounding to closer at 2 decimal places
var3 = round(4.68907, 2)

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

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ RANDOM MODULE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# random elements from random module are reproducible with seed command
import random
# random.seed(1)

# some data
listt = ["a", "b", "c", "d", "e", "f", "g"]

# Generate a random integer between 1 and 49
rand_value = random.randrange(1, 50)

# Generate a random integer between 1 and 50
rand_value = random.randint(1, 50)

# generate a random float between 1 and 50
rand_value = random.uniform(1, 50)

# generate a random float between 0 and 1
rand_value = random.random()

# pick value from list
rand_value = random.choice(listt)

# pick multiple unique values from a list
rand_value = random.sample(listt, k=3)

# pick multiple non unique values from a list
rand_value = random.choices(listt, k=3)

# shuffle elements in place
rand_value = random.shuffle(listt)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SECRETS MODULE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# recommended for security purposes
import secrets

# some data
listt = ["a", "b", "c", "d", "e", "f", "g"]

# pick random from 0 to 10 (10 not included)
a = secrets.randbelow(10)

# pick random from 0 to 4 bits (1111 - 15)
a = secrets.randbits(4)

# pick random choice from list
a = secrets.choice(listt)
