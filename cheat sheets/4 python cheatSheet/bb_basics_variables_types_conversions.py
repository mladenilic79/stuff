
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ VARIABLES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Variable names start with a letter or _ and then can contain numbers
# Names are case sensitive

# You can't use the following for variable names: and, del, from, not, while,
# as, elif, global, or, with, assert, else, if, pass, yield, break, except,
# import, print, class, exec, in, raise, continue, finally, is, return, def,
# for, lambda, try

# assigning
var = 5
def method1():
    print("method")

# reassigning
variable = var
method2 = method1

# deleting
del var
del method1

# @@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ TYPES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@

string_type = "67"

byte_string_type = b"Hallo"

int_type = 43

octal_type_1 = 0o10
octal_type_2 = 0O10

hexadecimal_type_1 = 0xA0F
hexadecimal_type_2 = 0XA0F

binary_type_1 = 0b101010
binary_type_2 = 0B101010

# Floats are precice up to 16 digits of precision
float_type = 3.4

# complex numbers
complex_number = 3 + 3j

# You can use type to see the data type of a value
a = type(complex_number)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ CONVERSIONS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Convert between string, int, float
int_type2, int_type3 = int("34"), int(3.5)
float_type2, float_type3 = float("23"), float(65)
string_type2, string_type3 = str(87), str(3.6)

# convert between int and hexadecimal, binary & octal string representations
hex_string = hex(33)
int_num_1 = int(hex_string, 16)
oct_string = oct(22)
int_num_2 = int(oct_string, 8)
bin_string = bin(99)
int_num_3 = int(bin_string, 2)

# convert between byte string and string
byte_string = b"Hallo"
string = byte_string.decode("UTF-8")
byte_string = string.encode("UTF-8")
