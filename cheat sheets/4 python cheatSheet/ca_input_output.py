
# @@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ INPUT @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@

# raw input
name = input('What is your name? ')
num1, num2 = input('Enter 2 nums with split using whitespace: ').split()

# evaluate input (useful for importing possible code)
eval_input = eval(input('input number: '))
print(eval_input)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ F STRING OUTPUT @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

first_parameter = 1
second_parameter = 2

string = f"this is an f-string {first_parameter} and the {second_parameter}"

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ STANDARD OUTPUT @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import sys

# print with default arguments values"
# file atribute can be file or error also"
print("hello", 'samos', sep=' ', end='\n', file=sys.stdout, flush=False)

# end="" means a newline won't be added"
print('Hello ', end="")
# change separator"
print('09', '12', '2016', sep='-')

# format() loads the variable values in order into the {} placeholders"
string = "{} + {} = {}".format(00, 11, 22)
# optional positional & keywords arguments"
string = "{0} + {1} + {name} = {pera}".format(00, 11, pera='sima', name="jim")

# mini syntax
"""

https://docs.python.org/3/library/string.html

s – strings
d – decimal integers (base-10)
f – floating point display
c – character
b – binary
o – octal
x – hexadecimal with lowercase letters after 9
X – hexadecimal with uppercase letters after 9
e – exponent notation

format_spec     ::=  [[fill]align][sign][#][0][width][grouping_option][.precision][type]
fill            ::=  <any character>
align           ::=  "<" | ">" | "=" | "^"
sign            ::=  "+" | "-" | " "
width           ::=  digit+
grouping_option ::=  "_" | ","
precision       ::=  digit+
type            ::=  "b" | "c" | "d" | "e" | "E" | "f" | "F" | "g" | "G" | "n" | "o" | "s" | "x" | "X" | "%"

"""

# < > ^ for forced alignment"
print()
print("{0:<20}".format('Spam & Eggs'))
print("{:>20}".format('Spam & Eggs'))
print('{:^20}'.format('Spam & Eggs'))

# add padding"
print()
print('{0:_<10}'.format('test'))
print('{:_>10}'.format('test'))
print('{:_^10}'.format('test'))

# format numbers and 1000 separator"
print()
print('{:d}'.format(4267868))
print('{:,d}'.format(4267868))
print('{:f}'.format(3.141592653589793))

# .3 or .5 to truncate to specific length"
print()
print('{:.5}'.format('xylophone'))

# 6.2 num of places before and after
# for numbers can only be used 0 as padding?
print()
print('{:06.2f}'.format(3.141592653589793))
print('{:04d}'.format(42))

# signed numbers + for all, - for default, ' ' for leading space for positive"
print()
print('{:+d}'.format(42))
print('{:+d}'.format(-42))
print('{:-d}'.format(42))
print('{:-d}'.format(-42))
print('{: d}'.format(42))
print('{: d}'.format(-42))

# control position of sign with padding"
print()
print('{:=+5d}'.format(42))
print('{:=+5d}'.format(-42))
print('{:=-5d}'.format(42))
print('{:=-5d}'.format(-42))
print('{:= 5d}'.format(42))
print('{:= 5d}'.format(-42))

# datetime format
print()
from datetime import datetime
print('{:%Y-%m-%d %H:%M}'.format(datetime(2001, 2, 3, 4, 5)))

# advanced access, can be freely mixed and arbitrarily nested"

print()
data = [4, 8, 15, 16, 23, 42]
print('lists: {d[4]} {d[5]}'.format(d=data))

print()
person = {'first': 'Jean-Luc', 'last': 'Picard'}
print('dicts: {p[first]} {p[last]}'.format(p=person))

print()
class Plant:
    type = 'tree'
print('class: {p.type}'.format(p=Plant()))

print()
class Plant:
    type = 'tree'
    kinds = [{'name': 'oak'}, {'name': 'maple'}]
print('combined: {p.type}: {p.kinds[0][name]}'.format(p=Plant()))

print()
# parametrized formats / untested"
print('{:{align}{width}}'.format('test', align='^', width='10'))
print('{:.{prec}} = {:.{prec}f}'.format('Gibberish', 2.7182, prec=3))
print('{:{width}.{prec}f}'.format(2.7182, width=5, prec=2))
print('{:{prec}} = {:{prec}}'.format('Gibberish', 2.7182, prec='.3'))
dt = datetime(2001, 2, 3, 4, 5)
print('{:{dfmt} {tfmt}}'.format(dt, dfmt='%Y-%m-%d', tfmt='%H:%M'))
print('{:{}{}{}.{}}'.format(2.7182818284, '>', '+', 10, 3))
print('{:{}{sign}{}.{}}'.format(2.7182818284, '>', 10, 3, sign='+'))
