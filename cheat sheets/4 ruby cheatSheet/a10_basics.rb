
# to read and execute from file go to folder with .rb file & put in terminal
# $ ruby fileName.rb
# & press enter & the file fileName will be executed

# for interactive version of ruby like python
# $ irb
# $ exit <or> quit

# single line comment

=begin
multiline comment
=end

# semicolon is not needed but can be added
puts "first world";
puts "second world"; puts "third world";

# broke one line into more
puts \
"second line"

# access documentation from terminal with/or
# $ ri classname
# $ ri classname.methodname
# $ ri methodname

# special array ARGV receives command line arguments
# access like any other array
puts ARGV
# put arguments in terminal like this
# terminal$ rubyfile.rb 3 6 7 jedan dva

# generate documentation with:
# $ rdoc filename.rb
# if rdoc missing from ruby install it first with:
# $ gem install rdoc
