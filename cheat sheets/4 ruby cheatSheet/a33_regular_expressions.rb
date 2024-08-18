
phrase = "the is ruby programming 555-123-1236 language
is amazing regexman@mail.com THX1138."
regex = /(.)(.)(\d+)(\d)/
regex2 = /\w+/

puts //.class # returns regex object

# regex matcher returns index of the first match
p phrase =~ regex
# same as
p regex =~ phrase

# regex matcher returns MatchData object if match found, nil if not
p matchk = phrase.match(regex)
# same as
p matchk = regex.match(phrase)
# access like an array
p matchk[0]
p matchk[1]

# return array using scan
p scans = phrase.scan(regex2)

# replaces the first occurence of the first argument
# regex or string
puts phrase.sub(regex, "ss")
puts phrase.sub("sadasnji", "ss")
# replaces all occurences of the first argument
puts phrase.gsub(regex, "e")
# bang version
phrase.sub!("m", "ed")
phrase.gsub!("s", "32")

# ruby regex text editor
# https://rubular.com/
