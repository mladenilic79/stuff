
# load other classes & modules (run other file)
#     load: loads & executes each time it is called
#     require & require_relative: remembers that it is loaded
# use any of those:
#     load "a41_module_custom.rb"
#     load "./a41_module_custom.rb"
#     require "./a41_module_custom"
#     require "./a41_module_custom.rb"
#     require_relative "a41_module_custom"

# for this example load these
require_relative "a43_module_custom"
require_relative 'a42_structs'

class ClassMaster

  # extend make modules available on a class itself
  extend Module_custom
  # include/prepend to make methods in modules available to class instance
  # include gives higher precendence to methods in a class - instance methods
  include Module_custom
  # same as include but gives higher precendence to methods defined in module
  prepend Module_custom

  # put @@ for static variables
  @@static_variable = 6

  # access static variable with static method
  def self.access_static_variable_with_static_method
    @@static_variable
  end
  # access static variable with instance method
  def access_static_variable_with_instance_method
    @@static_variable
  end

  # put self for static method (better than static name)
  def self.static_method
    puts "i am static method"
  end
  def ClassMaster.static_method
    puts "i am also static method but don't use me"
  end

  # singleton syntax for class/static method (metaprogramming?)
  class << self
    def static_method_singleton_syntax( number )
      p number
    end
  end

  # constructor, private by default
  def initialize(string1, number1)
    # without @ for local varibale, live only within a block
    local_variable = number1 + 1
    # put @ for instance variables, all member variables are private, access via methods.
    @string1 = string1
    @number1 = number1
    @apps = []
    # add to static counter
    @@static_variable += 1
  end

  # getter & setter methods for instance varibales
  def getter_string1 # getter
    @string1
  end
  def setter_string1=(string1) # setter
    @string1 = string1
  end

  # accessor methods (setter & getter shorthand) for instance variables
  attr_accessor :string1, :apps # full setter/getter
  attr_reader :number1 # reader only
  attr_writer :number1 # setter only

  def basic_instance_method
    puts "i am basic instance method"
  end

  # random instance custom method
  def custom_instance_method
    # self refers to self/instance object
    "i am random custom instance method,
    access instance variable #{@number1},
    access instance method #{self.basic_instance_method},
    can also be shorthanded with #{basic_instance_method},
    access class variable with static method #{ClassMaster.access_static_variable_with_static_method},
    access class varibale with instance method #{self.access_static_variable_with_instance_method},
    access class method #{ClassMaster.static_method}"
  end

  # dinamic/meta programming, creating methods on the fly
  # these methods can be used also just as regular
  ["cheese", "wires", "nuts"].each do |food|
      define_method("eat_#{food}") do |argument|
            "The mouse is eating #{argument} #{food}"
    end
  end

  # structs
  def install_app(name)
    app = AppStore.find_app(name)
    @apps << app
  end
  def delete_app(name)
    app = apps.find { |installed_app| installed_app.name == name }
    apps.delete(app)
  end

  private # private keyword, make everyting private from this point onward
  # can access only from the same object

  def private_method
    puts "i am private method"
  end

  protected # protected keyword, make everyting protected from this point onward
  # can access only from the same object & objects of the same class,
  # used often for comparing current object with another object of same class

  def protected_method
    puts "i am protected method"
  end

end

# basic elements
# instantiating new object
p phone = ClassMaster.new("sima", 6)
# returns array of instance_variables
p phone.instance_variables
# calling to string method
p phone.to_s

# instance elements
# shorthand instance getter & setter methods
p phone.string1
p phone.number1
# standard instance getter & setter methods
p phone.getter_string1
p phone.setter_string1=("rubyman")
# or alternatively shorthand syntax for setter method
p phone.setter_string1 = "rubywoman"
# access instance methods
p phone.basic_instance_method
p phone.custom_instance_method

# static elements
# static variable access by instance method
p phone.access_static_variable_with_instance_method
# static variable access by static method
p ClassMaster.access_static_variable_with_static_method
# static method access
p ClassMaster.static_method
# static method singleton syntax
ClassMaster.static_method_singleton_syntax("static method singleton syntax")

# modules
# access constant
puts Module_custom::PI
# access instance variable
phone.name2 = "sima"
# module method call (extend keyword - static method)
puts Module_custom.miles_to_feet(100)
puts Module_custom.miles_to_inches(200)
# module method call (include/prepand keyword - instance method)
puts phone.congratulate
puts phone.area(4)

# structs
phone.install_app(:Chat)
phone.install_app(:Twitter)
p phone.apps
phone.delete_app(:Chat)
p phone.apps

# dinamic/meta programming, creating methods on the fly
puts phone.eat_cheese("cheddar")
puts phone.eat_wires("electrical")
puts phone.eat_nuts("hazel")

# adding instance method to object (to metaclass) not to original class
def phone.speak
  puts "added method"
end
phone.speak

p laptop = ClassMaster.new("pera", 6)
phone = laptop # now reference same object
