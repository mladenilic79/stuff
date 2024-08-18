
osoba = "alkdfjad;sja;fj"

# return character
p osoba[2]
p osoba[osoba.length - 1]
p osoba[-2]
p osoba.slice(2)
p osoba.slice(-2)

# return range of characters
p osoba[2, 3] # 3 characters from 2 position onward
p osoba.slice(2, 3) # 3 characters from 2 position onward
p osoba[-4, 2]
p osoba.slice(-4, 2)
p osoba[2..4] # last character included
p osoba.slice(2..4) # last character included
p osoba[2...4] # last character excluded
p osoba.slice(2...4) # last character excluded
p osoba[2..-2] # from to (from behind)
p osoba.slice(2..-2) # from to (from behind)
p osoba[2...-2] # from to (with excluded)
p osoba.slice(2...-2) # from to (with excluded)

# reassign characters
osoba[2] = "a"
osoba[2, 3] = "sma"
osoba[2, 3] = "kucerak" # doesn't have to be the same size
