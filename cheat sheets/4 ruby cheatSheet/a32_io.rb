
# for writing
file = File.open("test1.txt", "w") # open for writing
file = File.new("test1.txt", "w") # new for writing
# print & write doesn't add line breaks
file.print "newly created line"
file.write "no line break here"
file.puts "pretty cool"
file.puts "pretty cool"
file.puts "pretty cool"
file.close

# for reading (access whole file)
file = File.read("test1.txt") # read
file = File.open("test1.txt") # open for reading
file.readline() # read only single line & moves to the next line
file.readline()
file.readchar() # read only single character from the file
file.readchar()
file.readlines() # returns array of all the lines
file.read() # read whole file line by line
file.close

# for reading (iterate through lines)
File.open("test1.txt").each do |line|
  puts line
end

File.open("test1.txt", "a") # appending
File.rename("test1.txt", "test2.txt")
File.delete("test2.txt")
# or
if File.exist?("test2.txt")
  File.delete("test2.txt")
end
