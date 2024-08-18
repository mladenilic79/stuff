
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ F STRING @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# put f for f-string
# put : after variable for formating mini language below

string = "string"
dictionary = {"var_1":"first_name", "var_2":"last_name"}

# basic and complex objects
sstring = f"this is an f-string {string} and the {dictionary['var_2']}"
print(sstring)

# running code
print(f"this is an f-string {string.upper()} and the {5*5}")

# formating mini language/syntax
# https://docs.python.org/3/library/string.html
