
# output

# puts for output/print
puts "puts output" # output
puts "puts big line
break" # utput with line break
puts # blank line

# print is same as puts but without newline
print "print output" # output
print "print big line
break" # output with line break
puts
puts

# p print same as puts but with specified output
p "p output"
p "p very big line
break"

# printf
printf "string %s integer %d float %f\n", "str", 4, 3.5

# input

puts "hi, what's your first name?"
first_name = gets # gets returns input with newline
print first_name

puts "hi, what's your last name?"
last_name = gets.chomp # gets.chomp returns input without newline
print last_name

puts "great! what's your age?"
age = gets.chomp.to_i # receive & convert to integer
print age
