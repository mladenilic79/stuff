
a = 3
id = true

if a == 5 && ( 3 != 4 || id ) # id evaluates to true
  puts "hello"
elsif a == 4
  puts "yeah"
else
  puts "super"
end

# replace <if> and <!(negation)> with keyword <unless>
# if a != 5
unless a == 5
  puts "wrong"
else
  puts "right"
end

# alternative sintax for if & unless
puts "huge number" if a > 1000
puts "x is not great" unless a > 10

# ternary operator

puts result = 1 < 2 ? "yes" : "no"
puts 1 < 2 ? "yes" : "no"
