
# creating arrays
puts "creating arrays"
empty = []
numbers = [3, 5, 2]
strings = ["teddy", "soaker", "board"]
mixed = [3, "silly", true, 22.34]
inner = [2, 5, 2, ["suma", "hama", "resa"]]
students = [["boris", 25, true],
            ["sally", 23, true],
            ["ingrid", 42, false]]
# shorthand for creating of arrays of words without <,> & <"">
p names = %w[jack jill john]
# shorthand for creating of arrays of symbols without <,> & <"">
p names = %i[:jack :jill :john]
# make array size n(3) with default nil values
p Array.new(3)
# make array size n(3) with default 5 value
p Array.new(3, 5)
# make array size n(3) with default inner arrays
p Array.new(3, [1, 2, 3])
puts

# outputing
puts "outputing arrays"
p numbers
puts numbers
print numbers
puts
puts

# math on arrays
puts "math on arrays"
p numbers * 3 # multipliing arrays
p numbers | strings | mixed # union returns array af all elements no duplicates
p strings - mixed # subtraction of arrays (delete all elements from first array)
p numbers & strings # returns intersection
puts

# method equivalent to arrays math operation
puts "method equivalent to arrays math operation"
p numbers.|(strings)
p strings.-(mixed)
p numbers.&(strings)
puts

# array methods
puts "arrays methods"
p [1, 2, 3].class # return class
p numbers.length # return length of array (length or size or count)
p numbers.count(2) # count all numbers 2 (for example)
p numbers.count(nil) # count all nils (for example)
puts numbers.empty? # check if array is empty
letters = ("a".."j").to_a # convert range to array
p [3, 4, 5] <=> [3, 4, 5] # comparison with spaceship operator
p [3, 4, 5] <=> [3, 4, 10]
p [3, 4, 5] <=> ["d", 4, 5] # returns nil if uncomparable
puts numbers.is_a?(Fixnum) # check if array is composed of integers
# map creates array from existing array based on some rule (map or collect)
squares = numbers.map do |number|
  number ** 2
end
p numbers.reverse # reverse order of elements in array
p numbers.sort # ascending order (capital letters comes first)
numbers.concat([4, 5, 6]) # cancatination, adding to array
p numbers.max # returns max value from array
p numbers.min # returns min value from array
p numbers.include?(3) # check if element exist in array returns boolean
p numbers.index(3) # returns index position of element (index or find_index)
# return array from another array based on math rule
matches = numbers.select do |number|
  number >= 3  # anything in block must evaluate to a boolean
end
# same as select just oposite (returns on false instead of true)
matches = numbers.reject do |number|
  number >= 3
end
# partition combines select & reject methods, returns two nested arrays
more, less = numbers.partition do |number|
  number >=3
end
# find if any element passes some rule, returns boolean
p numbers.any? do |number|
  number.even?
end
# find if all elements passes some rule, returns boolean
p numbers.all? do |number|
  number.odd?
end
# return first match from array based on some filter (find or detect)
match = numbers.find do |num|
  num > 4 # must evaluete to boolean
end
p numbers.uniq # removes duplicates
p numbers.compact # removes nil objects from array
p inner.flatten # flatten nested arrays, returns single array
# combines multiple arrays with preserving order, returns pairs of nested arrays
p numbers.zip(strings, mixed)
puts numbers.sample # returns random value from array
puts numbers.sample(1) # returns random value from arrays as array
puts numbers.sample(2) # returns array of random elements (without repeating)
puts

# methods bang variants
puts "bang variants"
p numbers.reverse!
p numbers.sort!
p numbers.uniq!
p numbers.compact!
p inner.flatten!
puts

# return elements from array
puts "returns elements from arrays"
# returns integer
p numbers[0]
p numbers[1]
p strings[strings.length-1] # pulling last element
p strings[-1] # pulling last element
p strings[-3] # 3rd from the end
p strings.[](3) # 3rd using method
p strings.[](-3) # 3rd from the end
p numbers.fetch(0) # first using fetch
p numbers.fetch(100, "nema") # specify return if no value is found
puts
# returns arrays
p numbers[1, 2] # starting at index 2 & returning 2 elements
p numbers[1..3] # using range
p numbers.values_at(0) # one element using method
p numbers.values_at(0, 2)
p numbers.values_at(0, -1) # return 1. & last element
puts
# using slice, first & last
p numbers.slice(0) # returns integer
p numbers.slice(0, 2) # returns array
p numbers.slice(0..2) # returns array
p numbers.first # returns integer
p numbers.last # returns integer
p numbers.first() # returns array
p numbers.last() # returns array
p numbers.first(3) # returns array
p numbers.last(3) # returns array
puts

# editing & adding & removing elements
puts "changing, adding & removing elements"
numbers[0] = "marka"
numbers[4] = "334"
numbers[10] = "desetka" # adding other elements with nils
numbers[2, 3] = [3, 5] # editing multiple values at the same time
numbers[0..2] = [3, 6, 6] # editing multiple values at the same time
numbers[0...2] = ["remove"] # removing elements that was not replaced
numbers.push(7) # add to the end of array
numbers.push(3, 4, 5) # add to the end of array
numbers << 44 # add to the end of array
numbers << 55 << 66 # add to the end of array
numbers.insert(1, 77) # add 77 at index 1
p one = numbers.pop # remove & return last element from array
p one = numbers.pop(1) # remove & return last array of one
p two = numbers.pop(2) # remove & return 2 last elements array
p one = numbers.shift # removes & returns first element
p one = numbers.shift(1) # removes & returns first element as array
numbers.unshift(443) # add to first place in array
numbers.unshift(23, 33) # add to first places in array
puts

# multidimentional array
puts "multidimentional array"
p students[1][0] # accessing specific element
boris, sani, lola = students # unpacking multidimentional array
p boris, sani, lola
