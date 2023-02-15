
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ PPRINT MODULE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# for outputting nicely

import pprint

# exapmle data
coordinates = [
   {
       "name": "Location 1",
       "gps": (29.008966, 111.573724)
   },
   {
       "name": "Location 2",
       "gps": (40.1632626, 44.2935926)
   },
   {
       "name": "Location 3",
       "gps": (29.476705, 121.869339)
   }
]

# regular print
print(coordinates)

# parameters
# indent (default 1)
# width (default 80)
# stream (default none for stdout) - for outputting to file
# depth (default none to show all data) - how many levels to show
# compact (default false) - consolidate complex data to one line
# sort_dict (default true) - sort alphabetically, else by order of insertion

pp = pprint.PrettyPrinter(indent=4)
pp.pprint(coordinates)
