
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ REGEX - REGULAR EXPRESSIONS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import re

# ---------- syntax ----------

# for syntax refer to somewhere else, python org, tutorial..

# You can compile a regex into pattern objects which provide additional methods
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
# re.A 	        re.ASCII 	    Specifies ASCII encoding for character classification
# re.X	        re.VERBOSE	    Allowing "verbose regular expressions", i.e. whitespace are ignored.
#                               This means that spaces, tabs, and carriage returns are not
#                               matched as such. If you want to match a space in a verbose regular
#                               expression, you'll need to escape it by escaping it with a backslash
#                               in front of it or include it in a character class.
#                               # are also ignored, except when in a character class or preceded by an
#                               non-escaped backslash. Everything following a "#" will be ignored until
#                               the end of the line, so this character can be used to start a comment.

# if there is an issue with backslash in strings use raw strings instead

# ---------- methods ----------

random_string = "The ape was at the regex1 apex Cat rat mat fat pat mat pat"
regex_pattern_object = re.compile("regex1")

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
for match_object in iterator:
    # You can use span, start and end to get the location
    location_tuple = match_object.span()
    location_start = match_object.start()
    location_end = match_object.end()

# sub() replaces first item that match the regex in the string
random_string = regex_pattern_object.sub("substitutionString", random_string)
# subn() replaces all items that match the regex and returns their number
random_tuple = regex_pattern_object.subn("substitutionString", random_string)

# using split from re module instead of regular split
splited_list = re.split("\W+", random_string)

# ---------- grouping ----------

# We can use group to retrieve parts of regex matches
random_string = "06-22-1998"
regex_pattern_object = re.compile(r"(\d{1,2})-(\d{1,2})-(\d{4})")
match_object = re.search(regex_pattern_object, random_string)

# return all
print0 = match_object.group()
# returns 1st group
print0 = match_object.group(1)
# returns 2nd group
print0 = match_object.group(2)
print0 = match_object.group(3)

# You can also assign names to matches with (?P<groupName>matchText)
random_string = "December 21 1974"
regex_pattern_object = re.compile(r"^(?P<month>\w+)\s(?P<day>\d+)\s(?P<year>\d+)")
match_object = re.search(regex_pattern_object, random_string)

print_month = match_object.group('month')
print_day = match_object.group('day')
print_year = match_object.group('year')

# Return a dictionary containing all the named subgroups of the match, keyed by the subgroup name
random_string = "Malcolm Reynolds"
regex_pattern_object = re.compile(r"(?P<first_name>\w+) (?P<last_name>\w+)")
match_object = re.search(regex_pattern_object, random_string)
a = match_object.groupdict()
