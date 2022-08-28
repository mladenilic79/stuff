
# one class can inherit multiple modules

module Module_custom
  # constant
  PI = 3.14

  # regular attributes
  attr_accessor :name2

  # do not include self to include module on other classes
  def congratulate
    puts "hello"
    puts self.name2
  end

  # do not include self to include module on other classes
  def area(side)
    side * side
  end

  # include self to call on module itself
  def self.miles_to_feet(miles)
    miles * 5280
  end

  # include self to call on module itself
  def self.miles_to_inches(miles)
    feet = miles_to_feet(miles)
    feet * 12
  end
end
