
begin
  num = 10 / 0
# simple rescue catch any error
rescue
  puts "division by zero error"
end

# multiple errors expected
begin
  p [1, 3, 4][0]
  p [1, 3, 4]["dog"]
  num = 10 / 0
rescue ZeroDivisionError
  puts "division by zero error"
# returns actual error desctiption
rescue TypeError => e
  puts e
end

# manual raising errors
if 3 > 2
  raise ArgumentError, "this is error"
end
