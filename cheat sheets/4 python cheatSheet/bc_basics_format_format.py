
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ STRING FORMAT @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# put : after variable for formating mini language below

dictionary = {"var_1":"first_name", "var_2":"last_name"}

# format() loads the variable values in order into the {} placeholders
string = "{} + {} = {}".format(00, 11, 22)
# optional positional & keywords arguments
string = "{0} + {1} + {name} = {pera}".format(00, 11, pera='sima', name="jim")
# complex objects
string = "{pera[var_1]} and {pera[var_2]}".format(pera=dictionary)
# running code
string = "i love {pera}".format(pera='sima is a fat ass'.upper())

# formating mini language/syntax
# https://docs.python.org/3/library/string.html

print()
print()
print("< > ^ for forced alignment")
print()
print("{:<20}".format('Spam & Eggs'))
print("{:>20}".format('Spam & Eggs'))
print('{:^20}'.format('Spam & Eggs'))

print()
print()
print("add padding")
print()
print('{:_<10}'.format('test'))
print('{:_>10}'.format('test'))
print('{:_^10}'.format('test'))

print()
print()
print("format numbers and 1000 separator")
print()
print('{:d}'.format(4267868))
print('{:,d}'.format(4267868))
print('{:f}'.format(3.141592653589793))

print()
print()
print(".3 or .5 to truncate to specific length")
print()
print('{:.5}'.format('xylophone'))

print()
print()
print("6.2 num of places before and after")
print()
print('{:06.2f}'.format(3.141592653589793))
print('{:04d}'.format(42))

print()
print()
print("signed numbers + for all, - for default, ' ' for leading space for positive")
print()
print('{:+d}'.format(42))
print('{:+d}'.format(-42))
print('{:-d}'.format(42))
print('{:-d}'.format(-42))
print('{: d}'.format(42))
print('{: d}'.format(-42))

print()
print()
print("control position of sign with padding")
print()
print('{:=+5d}'.format(42))
print('{:=+5d}'.format(-42))
print('{:=-5d}'.format(42))
print('{:=-5d}'.format(-42))
print('{:= 5d}'.format(42))
print('{:= 5d}'.format(-42))

print()
print()
print("datetime format")
print()
from datetime import datetime
print('{:%Y-%m-%d %H:%M}'.format(datetime(2001, 2, 3, 4, 5)))

print()
print()
print("accessing list object")
print()
data = [4, 8, 15, 16, 23, 42]
print('lists: {d[4]} {d[5]}'.format(d=data))

print()
print()
print("accessing dictionary object")
print()
person = {'first': 'Jean-Luc', 'last': 'Picard'}
print('dicts: {p[first]} {p[last]}'.format(p=person))
print('dicts: {first} {last}'.format(**person))

print()
print("similar access is for other objects, same as for lists and dicts")
print()
print()
