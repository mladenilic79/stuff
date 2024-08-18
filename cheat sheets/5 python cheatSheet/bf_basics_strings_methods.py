
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ STRINGS METHODS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

samp_string = "  This is a an very important string  "

# ---------- CONCATENATION ----------

string = "string 1" + "string 2"
string = "string 1" "string 2"
string = "string 1""string 2"

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
justString1 = samp_string.ljust(80, "k")
#  This is a an very important string  kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
justString2 = samp_string.rjust(80, " ")
#                                            This is a an very important string

# ---------- SUBSTRING ----------

# Count how many times a string occurs in a string
countStrin = samp_string.count("is")

# Get first / last index of matching string (raises error on failure)
indexOfString1 = samp_string.index("string")
indexOfString2 = samp_string.rindex("string")

# Get index of first / last matching string (ne error on failure)
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
