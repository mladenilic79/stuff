
# method definitions must be on top
# returns last line even if return keyword is not used
# empty method returns nil

def random_method
  puts "hello"
end

      # parentheses in method calls are usually optional and often omitted.
      random_method
      random_method()
      result = random_method()
      puts

# default/optional parameter must be on the end
def praise_person(name, age = 55)
  puts "#{name} is amazing"
  puts "interpolated method #{random_method}"
  puts name, age
  return age*3 if age < 10
  return age*2
end

      praise_person "sima", 5
      praise_person("pero")
      puts

def outer_method(inner_method)
  inner_method
end

      outer_method(random_method)
      puts

# receive undetermine number of arguments
def splat_method(*nums)
  p nums
end

      splat_method(3, 3, 5, 6, 2)
      puts

# receive undetermine number of hash arguments
def splat_hash_method(**keyword)
  p keyword
end

      splat_hash_method(a: 10, b: 20)
      # returns hash {:a=>10, :b=>20}
      puts

def pass_control
  puts "inside method"
  outside = yield # outside method / inside block
  if block_given? # checking for block on method call
    outside2 = yield # second yield
  end
  puts "inside method & yield #{outside} & yield2 #{outside2}"
end

      pass_control do # pass block on method call
        # last evaluation will be returned from block, do not use return keyword
        "evaluation inside the block"
      end
      puts

def pass_control2
  if block_given?
    yield "boris"
  end
end

      pass_control2 { |name| puts "#{name} great"}
      pass_control2 { |name| puts "#{name} super"}
      puts

def pass_control3(name)
  if block_given?
    yield name
  end
end

      pass_control3("boris") { |name| puts "#{name} great"}
      pass_control3("simic") { |name| puts "#{name} super"}
      puts

def pass_control4(num1, num2, num3)
  if block_given?
    yield(num1, num2, num3)
  end
end

      p result = pass_control4(3, 5, 6) { |num1, num2, num3| num1*num2*num3 }
      p result = pass_control4(3, 5, 6) { |num1, num2, num3| num1+num2+num3 }
      puts
