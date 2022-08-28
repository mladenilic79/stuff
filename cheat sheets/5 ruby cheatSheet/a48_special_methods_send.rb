# value = send("resolve_#{key}")
# send sends a message to an object instance and its ancestors in class hierarchy until some method reacts (because its name matches the first argument).
# use public_send instead if you want to call public methods only

# example 1:

class Car
  attr_accessor :make, :model
end

c = Car.new
c.make="Honda"
c.model="CRV"

# Or using .send method:
c.send("make=", "Honda")
c.public_send("model=", "CRV")

# But it can all be replaced with the following, Assuming your Rails app needs to assign attributes to your car class from user input, you can do

params = {:make => "boris1", :model => "boris2"}

c = Car.new()
params.each do |key, value|
  c.send("#{key}=", value)
end

p c.make
p c.model

# or example 2:

p 1.send '+', 2
# same as
p 1.+(2)
# same as
p 1 + 2

# or example 3:

class Klass
  def hello(*args)
    "Hello " + args.join(' ')
  end
end
k = Klass.new
p k.send :hello, "gentle", "readers"
