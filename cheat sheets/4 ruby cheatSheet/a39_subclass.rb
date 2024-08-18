
require_relative 'a36_class'

class SubClass1 < ClassMaster
end

class SubClass2 < ClassMaster
  def sub_method2
    puts "i am sub_method2"
  end
end

class SubClass3 < ClassMaster
  def sub_method3(variable1)
    puts "i am sub_method3 and my var is #{variable1}"
  end
end

class SubClass4 < ClassMaster
  # overriding constructor
  def initialize(variable1, variable2, variable3)
    # call superconstructor
    super(variable1, variable2)
    @variable3 = variable3
  end
end

class SubClass5 < ClassMaster
  # overriding method from ClassMaster
  def custom_instance_method
    # call data from superclass & edit it
    # super without parentheses will try to pass all arguments
    super + ", overrided method from superclass"
  end
end

class SubClass6 < ClassMaster
  # overriding method from ClassMaster
  def custom_instance_method(variable1)
    # call data from superclass & edit it
    # put empty parentheses to call super without passing arguments
    super() + ", overrided method from superclass #{variable1}"
  end
end

sub1 = SubClass1.new("prvi", 1)
p sub1.custom_instance_method

sub2 = SubClass2.new("drugi", 2)
sub2.sub_method2
p sub2.custom_instance_method

sub3 = SubClass3.new("treci", 3)
sub3.sub_method3(5)
p sub3.custom_instance_method

sub4 = SubClass4.new("cetvrti", 4, "varijabla")
p sub4.custom_instance_method

sub5 = SubClass5.new("peti", 5)
p sub5.custom_instance_method

sub6 = SubClass6.new("sesti", 6)
p sub6.custom_instance_method(6)

# if subclass inherits superclass
puts SubClass1 < ClassMaster
