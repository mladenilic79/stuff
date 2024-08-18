
# example 1

def greeter
  puts "i'm inside the greeter method"
  yield
end

phrase = Proc.new do
  puts "inside the proc"
end

greeter(&phrase)

# example 2

# passing proc as argument
def talk_about(name, &myprc)
  puts "let me tell you about #{name}."
  myprc.call(name)
end

good_things = Proc.new do |name|
  puts "#{name} is a genius!"
  puts "#{name} is a jolly good fellow!"
end

bad_things = Proc.new do |name|
  puts "#{name} is a dolt!"
  puts "I can't stand #{name}!"
end

talk_about("boris", &good_things)
talk_about("brock", &bad_things)

# example 3

def convert(dollars, currency_lambda)
  currency_lambda.call(dollars) if dollars.is_a?(Numeric)
end

to_euros = lambda { |dollars| dollars * 0.95 }
to_pesos = lambda { |dollars| dollars * 20.67 }
to_rupees = lambda { |dollars| dollars * 68.13 }

p convert(1000, to_euros)
p convert(1000, to_pesos)
p convert(1000, to_rupees)

p [1000, 2000, 3000].map(&to_euros)
