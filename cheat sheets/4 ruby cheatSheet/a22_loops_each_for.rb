
# for loop
for num in [3, 5, 6]
  puts num
end

# each arrays

numbers = [3, 5, "ludilo"]
numbers.each do |element|
  puts element
end

# each ranges

ranges = 1..4
ranges.each do |range|
  puts range
end

# each with index

numbers = [2, 5, 6, 3]

numbers.each_with_index do |num, index|
  puts "num is #{num}, index is #{index}"
end
