
nums = 1..5 # 5 included
nums = 1...5 # 5 excluded
nums = -34..234
alphabet = "A".."z"
alphabetvel = "A".."Z" # caps only
alphabetmal = "a".."z" # low only

p nums.class
p nums.size
puts

p nums.first
p nums.last
p nums.first(1) # return array of 1
p nums.last(1) # return array of 1
p nums.first(4) # return first 4 numbers
puts nums.last(4) # return last 4 numbers
p (1..10).first(2) # add pharenteses for clarification
p nums.include?(3)
p nums === 3 # check if it is included
p alphabet.include?("m")
p alphabet === "b" # check if it is included
puts
