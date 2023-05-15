
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SEQUENCE SLICING ALL @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# 1st index always included, last index never included

samp_string = "sample data: This is a very important string"

# You can get a character by referencing an index
slice = samp_string[0]

# Get the last character
slice = samp_string[-1]

# Get the character at index
slice = samp_string[3 + 5]

# Get a slice by saying where to start and end
slice = samp_string[0:4]

# Get everything starting at an index
slice = samp_string[8:]

# Get everything ending at an index
slice = samp_string[:4]

# Slice a sequence with a step, 2 in this example
slice = samp_string[0:10:2]
slice = samp_string[::3]
