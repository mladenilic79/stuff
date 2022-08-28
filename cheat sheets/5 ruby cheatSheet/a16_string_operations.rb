
# strings are mutable

osoba = "perovic simic markovic"
array = ["sima", "sera", "pera"]
broj = 3

# concatination & math
p name = "harry" + " potter"
p name += " sima"
p name = name.concat(" sumar")
p name << " horor"
p name << " heroj" << " ruska"
p name.prepend("prvo ")
p name * 3

# string methods
p osoba.length
p osoba.size # same as length
p osoba.upcase
p osoba.downcase
p osoba.capitalize
p osoba.swapcase # reverse capitalization
p osoba.reverse # reverse characters
p osoba.include?("pe") # check if exists in a string
p "".empty? # check if string have length zero
p osoba.split # returns array based on <" "> space delimiter
p osoba.split("i") # returns array based on custom delimiter
p osoba.split("") # return array of characters
osoba.each_char do |char| # iterate over characters
  puts char
end
p osoba.chars # return array of all characters
p array.join("-") # joining strings in array in one array using delimiter
p osoba.count("ic") # count total number of characters
p osoba.index("ma") # returns index of first instance of a letter or letters
p osoba.index("m", 3) # returns index after index position
p osoba.rindex("m") # same as index back from the end of string
p osoba.insert(3, "sa") # insert char/chars at index
p osoba.insert(-3, "sa") # insert char/chars at index
p osoba.squeeze # remove any duplicate chars in a row
p osoba.squeeze(" p") # remove only duplicate spaces & p
p osoba.lstrip # remove spaces on the left
p osoba.rstrip # remove spaces on the right
p osoba.strip # remove spaces on the left & right
p osoba.rjust(50, '.') # right justified
p osoba.ljust(50, '.') # left justified
p osoba.center(50, '.') # center justified
p osoba.chop # cuts the last letter
p osoba.chomp("ic") # cuts 2 last letters
p osoba.clear # deletes string are returns empty string ""
p osoba.delete("la") # deletes all char/chars from string
p osoba.start_with?("the")
p osoba.downcase.start_with?("the")
p osoba.end_with?("ing")
p "a".next # gets next from natural order

# bang methods which mutate original object
osoba.capitalize!
osoba.upcase!
osoba.downcase!
osoba.swapcase!
osoba.reverse!
osoba.squeeze!
