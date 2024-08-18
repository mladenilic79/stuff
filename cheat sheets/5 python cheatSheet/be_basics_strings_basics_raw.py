
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

# special characters

# \' 	Single Quote 	
# \\ 	Backslash 	
# \n 	New Line 	
# \r 	Carriage Return 	
# \t 	Tab 	
# \b 	Backspace 	
# \f 	Form Feed 	
# \ooo 	Octal value 	
# \xhh 	Hex value
# \v    Vertical Tab

# ---------- RAW STRINGS ----------

# String literals may optionally be prefixed with a letter 'r' or 'R'; these
# strings are called raw strings. Raw strings use different rules for
# interpreting backslash escape sequences

a = r"raw string"
a = R"raw string"

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
