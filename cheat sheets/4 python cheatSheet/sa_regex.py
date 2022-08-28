
# @@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ REGEX @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@

import re

# ---------- syntax ----------

# [ ]   : Match what is in the brackets
# [Aa]	: Represents 1 A or 1 a ??????????????????????????????????????
# [^ ]  : Match anything not in the brackets
# ( )   : Return surrounded submatch
# .     : Match any 1 character or space (except a newline)
# +     : Match 1 or more of what proceeds
# ?     : Match 0 or 1 of what proceeds
# *     : Match 0 or More of what proceeds
# *?, +?, or {n,}?    : Lazy match the smallest match
# \b    : Word boundary
# \B	: anything not a word boundary
# ^     : Beginning of String
# $     : End of String
# \n    : Newline
# \r\n  : newline on Windows sometimes
# \d    : Any 1 number
# \D    : Anything but a number (oposite of \d)
# \w    : Same as [a-zA-Z0-9_]
# \W    : Same as [^a-zA-Z0-9_] (oposite of \w)
# \s    : Same as [\f\n\r\t\v] (any space)
# \S    : Same as [^\f\n\r\t\v] (not any space, oposite of \s)
# {5}   : Match 5 of what proceeds the curly brackets
# {5,7} : Match values that are between 5 and 7 in length
# (?m)  : Allow ^ on multiline string
# |	    : or

# ---------- mini language from strings for reference ----------

# \b    : Backspace
# \f    : Form Feed
# \r    : Carriage Return
# \t    : Tab
# \v    : Vertical Tab

# ---------- basic matching ----------

random_string = "The ape was at the regex1 apex Cat rat mat fat pat mat pat"

# You can compile a regex into pattern objects which provide additional methods
# "regex" is regular expression string: "ape" "ape." "[cr]at" ...
# returns patterns object
regex_pattern_object = re.compile("regex1")
# regex_pattern_object = re.compile(pattern[, flags])

# flags
# Abbreviation	Full name	    Description
# re.I	        re.IGNORECASE	Makes the regular expression case-insensitive
# re.L	        re.LOCALE	    The behaviour of some special sequences like \w, \W, \b,\s, \S
#                               will be made dependant on the current locale,
#                               i.e. the user's language, country aso.
# re.M	        re.MULTILINE	^ and $ will match at the beginning and at the end of each line
#                               and not just at the beginning and the end of the string
# re.S	        re.DOTALL	    The dot "." will match every character plus the newline
# re.U	        re.UNICODE	    Makes \w, \W, \b, \B, \d, \D, \s, \S dependent on
#                               Unicode character properties
# re.X	        re.VERBOSE	    Allowing "verbose regular expressions", i.e. whitespace are ignored.
#                               This means that spaces, tabs, and carriage returns are not
#                               matched as such. If you want to match a space in a verbose regular
#                               expression, you'll need to escape it by escaping it with a backslash
#                               in front of it or include it in a character class.
#                               # are also ignored, except when in a character class or preceded by an
#                               non-escaped backslash. Everything following a "#" will be ignored until
#                               the end of the line, so this character can be used to start a comment.

# search for match in any part of string, returns match object
match_object = re.search(regex_pattern_object, random_string)
# use span, start and end to get the location
location_tuple = match_object.span()
location_start = match_object.start()
location_end = match_object.end()

# search for match in start of string, returns match object (same as search)
match_object = re.match(regex_pattern_object, random_string)
# trying to match whole string, returns match object (same as search)
match_object = re.fullmatch(regex_pattern_object, random_string)

# findall() returns a list of matches
matches_list = re.findall(regex_pattern_object, random_string)

# finditer returns an iterator of matching objects
iterator = re.finditer(regex_pattern_object, random_string)
for i in iterator:
    # You can use span, start and end to get the location
    location_tuple = i.span()
    location_start = i.start()
    location_end = i.end()

# sub() replaces first item that match the regex in the string
random_string = regex_pattern_object.sub("substitutionString", random_string)
# subn() replaces all items that match the regex and returns their number
random_tuple = regex_pattern_object.subn("substitutionString", random_string)

# We can use group to retrieve parts of regex matches
random_string = "06-22-1998"
regex_pattern_object = re.compile(r"(\d{1,2})-(\d{1,2})-(\d{4})")
match_object = re.search(regex_pattern_object, random_string)

# return all
print0 = match_object.group()
# returns 1st group
print1 = match_object.group(1)
# returns 2nd group
print2 = match_object.group(2)
print3 = match_object.group(3)

# You can also assign names to matches with (?P<groupName>matchText)
random_string = "December 21 1974"
regex_pattern_object = re.compile(r"^(?P<month>\w+)\s(?P<day>\d+)\s(?P<year>\d+)")
match_object = re.search(regex_pattern_object, random_string)

print_month = match_object.group('month')
print_day = match_object.group('day')
print_year = match_object.group('year')

# using split from re module instead of regular split
splited_list = re.split("\W+", random_string)

# ---------- some basic examples ----------

# match any x.x.x
random_string = "F.B.I. I.R.S. CIA"
matches_list = re.findall(".\..\..", random_string)

# remove newlines
random_string = """This is a long
string that goes
on for many lines"""
regex_pattern_object = re.compile("\n")
random_string = regex_pattern_object.sub(" ", random_string)

# Find all of the following email addresses
random_string = "d+b@aol.com a_1@yahoo.co.uk A-100@m-b.INTERNATIONAL"
regex_pattern_object = \
    re.compile(r"[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+")
matches_list = re.findall(regex_pattern_object, random_string)

# Find all of the following phone numbers and then print them
random_string = "14125551212 4125551212 (412)5551212 412 555 1212 " \
                "412-555-1212 1-412-555-1212"
regex_pattern_object = re.compile(
    r"((1?)(-| ?)(\()?(\d{3})(\)|-| |\)-|\) )?(\d{3})(-| )?(\d{4}|\d{4}))")
matches_list = re.findall(regex_pattern_object, random_string)
for i in matches_list:
    a = i[0].lstrip()

# ---------- Solving Backslash Problems ----------

# Regex use the backslash to designate special characters
# and Python does the same inside strings which causes issues

# Let's try to get "\\stuff" out of a string
random_string = "Here is \\stuff"

# we have to put in 4 slashes which is messy
match_object = re.search("\\\\stuff", random_string)

# You can get around this by using raw strings which
# don't treat backslashes as special
match_object = re.search(r"\\stuff", random_string)

# ---------- Greedy & Lazy Matching ----------

# Let's try to grab everything between first <name> tags
random_string = "<name>Life On Mars</name><name>Freaks and Geeks</name>"

# Because * is greedy (It grabs the biggest match possible)
# we can't get what we want, which is each individual tag match
regex_pattern_object = re.compile(r"<name>.*</name>")
matches_list = re.findall(regex_pattern_object, random_string)

# We want to grab the smallest match we use *?, +?, or {n,}? instead
# (adding ? make it lazy)
regex_pattern_object = re.compile(r"<name>.*?</name>")
matches_list = re.findall(regex_pattern_object, random_string)

# ---------- Word Boundaries ----------

# We use word boundaries to define where our matches start and end
random_string = "ape at the apex"

# this won't work
regex_pattern_object = re.compile(r"ape")

# \b matches the start or end of a word
regex_pattern_object = re.compile(r"\bape\b")
matches_list = re.findall(regex_pattern_object, random_string)

# ---------- String Boundaries ----------

# ^ : Matches the beginning of a string if outside of a [ ]
# $ : Matches the end of a string if outside of a [ ]

# Grab everything from the start of the string to @
random_string = "Match everything up to @"
regex_pattern_object = re.compile(r"^.*[^\s@]")
matches_list = re.findall(regex_pattern_object, random_string)

# Grab everything from @ to the end of the line
random_string = "@ Get this string"
regex_pattern_object = re.compile(r"[^@\s].*$")
matches_list = re.findall(regex_pattern_object, random_string)

# ---------- String Boundaries in multi line strings ----------

# Grab the 1st word of each line using the the multi line code which allows for
# the targeting of each line after a line break with ^
random_string = '''Ape is big
Turtle is slow
Cheetah is fast'''
regex_pattern_object = re.compile(r"(?m)^.*?\s")
matches_list = re.findall(regex_pattern_object, random_string)

# ---------- Subexpressions ----------

# Subexpressions are parts of a larger expression
# If you want to match for a larger block, but only want to return part of it
# To do that surround what you want with ( )

# Get just the number minus the area code
random_string = "My number is 412-555-1212"
regex_pattern_object = re.compile(r"412-(.*)")
matches_list = re.findall(regex_pattern_object, random_string)

# ---------- Multiple Subexpressions ----------

# You can have multiple subexpressions as well
# Get both numbers that follow 412 separately
random_string = "My number is 412-555-1212"
regex_pattern_object = re.compile(r"412-(.*)-(.*)")
matches_list = re.findall(regex_pattern_object, random_string)

# ---------- Back References ----------

# A back reference allows you to to reuse the expression that proceeds it
# Grab a double word
random_string = "The cat cat fell out the window"

# Match a word boundary, 1 or more characters followed by a space if it is then
# followed by the same match that is surrounded by the parentheses
regex_pattern_object = re.compile(r"(\b\w+)\s+\1")
matches_list = re.findall(regex_pattern_object, random_string)

# ---------- Back Reference Substitutions ----------

# Replace the bold tags in the link with no tags
random_string = "<a href='#'><b>The Link</b></a>"

# Regex matches bold tags and grabs the text between
# them to be used by the back reference
regex_pattern_object = re.compile(r"<b>(.*?)</b>")

# Replace the tags with just the text between them
# (substitute regex with r"\1" in string
random_string = re.sub(regex_pattern_object, r"\1", random_string)


# second example
random_string = "412-555-1212"

# Match the phone number using multiple subexpressions
regex_pattern_object = re.compile(r"([\d]{3})-([\d]{3}-[\d]{4})")

# Output (412)555-1212
random_string = re.sub(regex_pattern_object, r"(\1)\2", random_string)


# third example
random_string = "https://www.youtube.com http://www.google.com"

# Grab the URL and then output using a back reference substitution
# <a href='https://www.youtube.com'>www.youtube.com</a>
# <a href='https://www.google.com'>www.google.com</a>

regex_pattern_object = re.compile(r"(https?://([\w.]+))")
random_string = re.sub(regex_pattern_object, r"<a href='\1'>\2</a>\n", random_string)

# ---------- Look Ahead ----------

# A look ahead defines a pattern to match but not return
# You define the expression to look for but not return like this (?=expression)

random_string = "One two three four"
# Grab all letters and numbers of 1 or more separated by a word boundary but
# don't include it
regex_pattern_object = re.compile(r"\w+(?=\b)")
matches_list = re.findall(regex_pattern_object, random_string)

# ---------- Look Behind ----------

# look behind look for what is before the text to return, but doesn't return it
# It is defined like (?<=expression)

random_string = "1. Bread 2. Apples 3. Lettuce"
# Find the number, period and space, but only return the 1 or more letters or
# numbers that follow
regex_pattern_object = re.compile(r"(?<=\d.\s)\w+")
matches_list = re.findall(regex_pattern_object, random_string)

# ---------- Look Ahead & Behind ----------

random_string = "<h1>I'm Important</h1> <h1>So am I</h1>"
# Use the look behind, get 1 or more of anything, and use the look ahead use
# lazy here
regex_pattern_object = re.compile(r"(?<=<h1>).+?(?=</h1>)")
matches_list = re.findall(regex_pattern_object, random_string)

# ---------- Negative Look Ahead & Behind ----------

# These are used to look for text that doesn't match the pattern
# (?!expression) : Negative Look Ahead
# (?<!expression) : Negative Look Behind

random_string = "8 Apples $3, 1 Bread $1, 1 Cereal $4"
# Grab the total number of grocery items by ignoring the $
regex_pattern_object = re.compile(r"(?<!\$)\d+")
matches_list = re.findall(regex_pattern_object, random_string)

# ---------- OR CONDITIONAL ----------

# You can use | to define the matches you'll except
random_string = "1. Dog 2. Cat 3. Turtle"
regex_pattern_object = re.compile(r"\d\.\s(Dog|Cat)")
matches_list = re.findall(regex_pattern_object, random_string)
