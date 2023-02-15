
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ TIME MODULE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import time

# sleep
print('start')
time.sleep(3)
print('finish')

# check execution speed
t1 = time.time()
time.sleep(3)
t2 = time.time()
result = t1 - t2
print(result)
