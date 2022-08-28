
# import for additional functionalities (parsing)
require 'time'

# outputing this moment in time
p today = Time.new
# outputing specific date
p specific_date = Time.new(2015, 5)
p specific_date = Time.new(2015, 5, 18, 23, 33, 54)

# output date only
# p Time.zone.now.to_date
p Date.today
# p Time.zone.today

p today.class
p today.to_s # convert to string
p today.ctime # convert to string more readable
p today.to_a # convert to array

# getting date elements from time object
p today.year
p today.month
p today.day
p today.hour
p today.min
p today.sec

p today.yday # day of the year
p today.mday # day of the month
p today.wday # day of the week (0 is sunday, 1 is monday)

# check for specific day
p specific_date.monday?
p specific_date.tuesday?
p specific_date.wednesday?
p specific_date.thursday?
p specific_date.friday?
p specific_date.saturday?
p specific_date.sunday?

p specific_date.dst? # daylight saving time

# calculation in seconds
p specific_date + 60 # adding one minute
p specific_date + (60 * 60 * 24 * 15) # adding 15 days

# comparison
puts today < specific_date
puts today >= specific_date
puts today == specific_date
puts today != specific_date
puts today.between?(specific_date, Time.new(2015, 5, 18, 23, 33, 54))

# time to string
p today.strftime("%B %d, %Y")
p today.strftime("%d----%B----%j")

# string to time
puts Time.parse("2016-01-01")
puts Time.strptime("03-04-2000", "%m-%d-%Y")
