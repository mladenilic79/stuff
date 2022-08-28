
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ STRINGS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# ---------- BASICS ----------

# Single or double quotes are both used for strings

# in double quotes backslash need to be used for escaping double quotes
samp_string = "This it's a very \" important string"
samp_string4 = """triple string can
                span multiple lines"""

# in single quotes backslash need to be used for escaping single quotes
samp_string2 = 'This it\'s a very " important string'
samp_string3 = '''triple string can 
                span multiple lines'''

# ---------- CONCATENATION ----------

# Join or concatenate strings
newString1 = "Green " + "Eggs"
newString2 = "Green " "Eggs"

# ---------- UNICODE ----------

# Computers assign characters with a number known as a Unicode
# A-Z have the numbers 65-90 and a-z 97-122

# You can get the Unicode code with ord()
print("A =", ord("A"))

# You can convert from Unicode with chr
print("65 =", chr(65))

# ---------- RAW & ESCAPES ----------

# String literals may optionally be prefixed with a letter 'r' or 'R'; these
# strings are called raw strings. Raw strings use different rules for
# interpreting backslash escape sequences

# Escape Sequence	Meaning Notes:

# \newline	        Ignored
# \\	            Backslash (\)
# \'	            Single quote (')
# \"	            Double quote (")
# \a 	            ASCII Bell (BEL)
# \b 	            ASCII Backspace (BS)
# \f 	            ASCII Formfeed (FF)
# \n 	            ASCII Linefeed (LF)
# \N{name} 	        Character named name in the Unicode database (Unicode only)
# \r 	            ASCII Carriage Return (CR)
# \t 	            ASCII Horizontal Tab (TAB)
# \uxxxx 	        Character with 16-bit hex value xxxx (Unicode only)
# \Uxxxxxxxx 	    Character with 32-bit hex value xxxxxxxx (Unicode only)
# \v 	            ASCII Vertical Tab (VT)
# \ooo 	            Character with octal value ooo
# \xhh 	            Character with hex value hh

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ STRINGS METHODS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

samp_string = "  string This is a an very important string  "

# ---------- MODIFICATION ----------

# Delete whitespace on left/right/both
leftStrip = samp_string.lstrip()
rightStrip = samp_string.rstrip()
bothStrip = samp_string.strip()

# Capitalize the 1st letter, all upper or all lower
capitalize = samp_string.capitalize()
upper = samp_string.upper()
lower = samp_string.lower()
title = samp_string.title()

# fill from lest and from right
justString1 = samp_string.ljust(50, "k")
justString2 = samp_string.rjust(50, " ")

# ---------- SUBSTRING ----------

# Count how many times a string occurs in a string
countStrin = samp_string.count("is")

# Get first / last index of matching string (raises error on failure)
indexOfString1 = samp_string.index("string")
indexOfString2 = samp_string.rindex("string")

# Get index of first and last matching string (ne error on failure)
indexOfString3 = samp_string.find("string")
indexOfString4 = samp_string.rfind("string")

# Replace a substring
newString = samp_string.replace("an ", "a kind of ")

# ---------- CHECKS ----------

samp_string = "  This is a an very important string  "

# Returns True if characters are letters or numbers, Whitespace is false
isalphanumeric = samp_string.isalnum()

# Returns True if characters are letters
isalpha = samp_string.isalpha()

# Returns True if characters are numbers (Floats are False)
isnumeric = samp_string.isdigit()

# Returns True if characters are decimal
isdecimal = samp_string.isdecimal()

# Returns True if all are lowercase/uppercase
isAllLower = samp_string.islower()
isAllUpper = samp_string.isupper()

# Returns True if all are spaces
isSpaces = samp_string.isspace()

# returns true / false if it start or ends with string
startsWith = samp_string.startswith("ring")
# str.startswith(prefix[, start[, end]])
endsWith = samp_string.endswith("ring")
# str.endswith(suffix[, start[, end]])
