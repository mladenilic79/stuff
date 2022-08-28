
# declaration
empty_hash = {}
nfl_roster = {"tom"=>"england",
              "sim"=>56887,
              "lik"=>"3345"}
nba_roster = {"cleveland"=>["le bron", "sim kel", "lol bon"],
              "goldensta"=>["stef", "tomphon", "kevin"]}
# declaration using symbols
person = {:name => "boris",
          :age => 25,
          :handsome => true,
          :languages => ["ruby", "java", "js"]}
shorthand = {name: "boris",
            age: 33,
            handsome: true,
            languages: ["ruby", "java", "js"]}
# declaration with passing array
p superheroes = Hash["clark kent", "superman", "bruce wayne", "batman"]

# create hash with default value for key
default_hash = Hash.new("not found")
# add default value in hash
default_hash.default = "not found"

# output
p empty_hash
p nfl_roster
p nba_roster
p person
puts

# various methods
p empty_hash.class
p person.length # return number of elements
p person.empty? # return boolean
p person.keys # returns array of keys
p person.values # returns array of values
array = person.to_a # convert hash to nested array
p array.to_h # convert nested array to hash
p person.sort # sort ascending by keys
p person.sort.reverse # sort descending by keys
p nba_roster.sort_by { |key, value| key } # sort by keys
p nba_roster.sort_by { |key, value| value }.reverse # sort by value
p person.key?(:name) # check if key exists (alternative method has_key?)
p nfl_roster.key?("tom") # check if key exists
p person.value?(25) # check if value exists (alternative method has_value?)

# manipulation
# select new hash from old based on some rule
p person.select do |key, value|
  value > 5 # body must evaluate to boolean
end
# select new hash from old based on some rule (oposite of select)
p person.reject do |key, value|
  value > 5 # body must evaluate to boolean
end
# union of hashes, duplicates kept from second
p nfl_roster.merge(nba_roster)
p nfl_roster.merge nba_roster
# beng version of merge
nfl_roster.merge!(nba_roster)
# union of hashes, duplicates removed
nfl_roster.update(nba_roster)
puts

# extract value
p nfl_roster["tom"]
p nba_roster["cleveland"]
p person[:name]
p person.fetch(:name) # extract value
p person.fetch(:name, "not found") # same as above with default option
puts
# add & edit & delete value
person[:name] = "simic" # direct access adding & editing
person[:age] = person[:age]+1 # add key and edit value in the same time
person.store(:sushi, 33.35) # method adding & editing
deleted = shorthand.delete(:boris) # delete key and returned it value

# iterating (each() & each_pair())
nba_roster.each do |state, capital| # returns key/value
  puts "#{state}, #{capital}"
end
nba_roster.each do |pair| # returns array
  puts "#{pair}"
end
nba_roster.each_key do |key|
  puts "#{key}"
end
nba_roster.each_value do |value|
  puts "#{value}"
end
