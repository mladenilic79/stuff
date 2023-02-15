
# comment out one example to run the other

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ PROCESSES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# exapmle 1

from multiprocessing import Process
import os

def square_numbers():
    for i in range(100):
        i*i

if __name__ == "__main__":

    processes = []
    # processes will be equal to cpu count
    num_processes = os.cpu_count()

    for i in range(num_processes):
        # create processes, pass what needs to be executed in each
        p = Process(target=square_numbers)
        processes.append(p)

    # start processes
    for p in processes:
        p.start()

    # join all processes
    for p in processes:
        p.join()

    print('end main')

# example 2

# value, array for shared resources across processes
from multiprocessing import Process, Value, Array, Lock
import time

def add_100(number, lock):
    for i in range(100):
        time.sleep(0.01)
        with lock:
            number.value += 1

def add_100s(numbers, lock):
    for i in range(100):
        time.sleep(0.01)
        for i in range(len(numbers)):
            with lock:
                numbers[i] += 1

if __name__ == "__main__":

    lock = Lock()
    # 'i' for integer, 0 for starting value
    shared_number = Value('i', 0)
    # 'd' for double, [] for list initial value
    shared_array = Array('d', [0.0, 100.0, 200.0])
    print('number at beginning is', shared_number.value)
    print('array at beginning is', shared_array[:])

    p1 = Process(target=add_100, args=(shared_number, lock))
    p2 = Process(target=add_100, args=(shared_number, lock))
    p3 = Process(target=add_100s, args=(shared_array, lock))
    p4 = Process(target=add_100s, args=(shared_array, lock))

    p1.start()
    p2.start()
    p3.start()
    p4.start()

    p1.join()
    p2.join()
    p3.join()
    p4.join()

    print('number at end is', shared_number.value)
    print('array at end is', shared_array[:])
