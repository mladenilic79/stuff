
# proc don't care about missing arguments, lambda do

a = [1, 3, 5, 6, 3]
b = [3, 4, 5, 6, 2]
c = [2, 3, 4, 5, 6]

# custom procs
basic = Proc.new { "basic proc" }
cubes = Proc.new { |number| number ** 3 }
squares = Proc.new { |number| number ** 2 }
bigenough = Proc.new { |number| number > 5 }
squares_proc = Proc.new { |number| number ** 2 }
squares_lambda = lambda { |number| number ** 2 }
some_proc = Proc.new { |name, age| "name is #{name}, age is #{age}"}
some_lambda = lambda { |name, age| "name is #{name}, age is #{age}"}

# & serves to pass proc or block to a method

# calling on array
p a.map(&cubes)
p a.map(&squares)
p a.select(&bigenough)
p b.reject(&bigenough)
p a.map(&squares_proc)
p a.map(&squares_lambda)
p "line"

# call on single element
p basic.call
p squares_proc.call(5)
p squares_lambda.call(5)
p some_proc.call("boris", 25)
p some_proc.call("boris")
p some_lambda.call("boris", 25)

# or shorthand solution
a_cubes, b_cubes, c_cubes = [a, b, c].map do |array|
  array.map(&cubes)
end
p a_cubes, b_cubes, c_cubes

# passing ruby methods as procs

p a.map { |number| number.to_i }
# same as
p b.map(&:to_i)
p c.map(&:to_s)

p a.select { |number| number.even? }
# same as
p b.select(&:even?)

p a.reject { |number| number.odd? }
# same as
p b.reject(&:odd?)
