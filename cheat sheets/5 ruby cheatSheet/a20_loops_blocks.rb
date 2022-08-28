
# times
2.times { puts "hello" } # prefered for singleline
# or
2.times do
  puts "alo"
end # prefered for multiline

# times & counter
3.times do |count|
  puts "alo #{count}"
end # with variable

# down to
4.downto(1) do |i|
  puts "countdown: #{i}"
end

# up to
1.upto(3) do |i|
  puts "countdown: #{i}"
end

# step next & break keyword
# next & break keywords can be put in any loop
0.step(20, 3) do |num|
  if num == 6
    next
  end
  puts "broj je #{num}"
  if num == 12
    break
  end
end
