
# if put on same line must include <then>

food = "sushi"

case food
when "steak", "STEAK"
  puts "pass the steak"
when "sushi"
  puts "my favorite dish"
when "pizza", "burritos" then puts "oh joy it is now"
else
  puts "i don't know about that food"
end

grade = 65

case grade
when 90..100
  puts "a"
when 80..89
  puts "b"
when 70..79 then puts "c"
when 60..69 then puts "d"
else puts "f"
end
