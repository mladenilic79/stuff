
numbers = [3, 2, 6]

# while
i = 1
while i < 5
  puts i # code to be executed
  i += 1
end
puts

# until
i = 1
until i > numbers.length do
  puts numbers[i] # code to be executed
  i += 1
end
puts

# do while & next & break
x = 1
loop do
  x = x + 1
  if x == 9
    next
  end
  puts x # code to be executed
  if x == 5
    break
  end
end

status = true
while status
  puts "enter name/password"
  name = gets.chomp
  if name == "pera"
    puts "enter"
    status = false
  else
    puts "incorect"
  end
end
