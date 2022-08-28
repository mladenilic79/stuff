
osoba = "perovic"
broj = 5

p osoba.class # returns class
p 5.class.superclass # returns superclass
p 5.class.superclass.superclass # returns its superclass
p 5.class.ancestors # returns array of superclasses
puts "hello world".inspect # for object inspection (output same as with p)
puts osoba.nil? # can be called on any object returns false it not nil
p osoba.object_id # returns objects adress in memory
copy = osoba.dup # making duplicate of any object
p osoba.methods # return all available methods to specified object
p 4.methods - 4.1.methods # return array of methods used by only one class
p broj.is_a?(Numeric) # returns true if is part of inheritance hierarchy
p broj.instance_of?(Numeric) # check if is instance of specified class
p osoba.singleton_methods # methods given only to a single object
# check if class have require singleton & include singleton
p osoba.singleton_class

puts

# check if object can respond to specified method
# : creates lightweight object (symbol object)
p broj.respond_to?(:next)
p broj.respond_to?(:class)
p broj.respond_to?(:odd?)
p broj.respond_to?(:respond_to?)
p broj.respond_to?(:length)
p osoba.respond_to?("length")
p osoba.respond_to?("class")
p osoba.respond_to?("upcase")
p osoba.respond_to?("odd?")
# if respond_to? next() than call next()
if broj.respond_to?("next")
  p broj.next
end
