
p true
p false
handsome = true
stupid = false

# only value that evaluates to false in ruby is nil

p 5 < 10 && 3 > 3 || 3 != 5
p 10 <= 12 and 3 >= 3 or 4 == !4
p "a" != "a"
p 5 == 5.0 # returns true if objects are equivalent
p "He".downcase == "he"
p "slip" == "slig" # strings are compared one by one char
p 3.between?(1, 6)
p 'cat'.between?('ant', 'dog')
puts

# is it the same object
puts "randomString".equal?("randomString")
puts

# spaceship operator
p 5 <=> 3 # $ 1 (bigger left)
p 3 <=> 3 # $ 0 (equal)
p 4 <=> 7 # $ -1 (bigger left)

# return boolean of anything with double exclamation
p !!""
p !!"adlja"
p !!2
p !!false
p !!nil
