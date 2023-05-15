
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ TIME MODULE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import time

# ---------- sleep ----------
print('start')
time.sleep(1)
print('finish')

# ---------- check execution speed ----------
t1 = time.time()
time.sleep(1)
t2 = time.time()
result = t1 - t2
print(result)
