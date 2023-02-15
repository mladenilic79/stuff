
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ THREADS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import threading
import time
import random


# ---------- EXAMPLE 1 ----------
print("\nexample 1\n")

# function that will be started multiple times
def xthread(i):
    # print time at start moment
    print("\nThread {} sleeps at {}"
          .format(i, time.strftime("%H:%M:%S", time.gmtime())))

    random_sleep_time = random.randint(1, 2)
    time.sleep(random_sleep_time)

    # print time at wake moment
    print("\nThread {} stops sleeping at {}"
          .format(i, time.strftime("%H:%M:%S", time.gmtime())))

# start 10 threads
for i in range(10):
    thread = threading.Thread(target=xthread, args=(i,))
    thread.start()

    time.sleep(0.05)  # this just to print correctly

    # show number of thread that are currently executing
    print(threading.activeCount())

    # show all thread that are active at given time
    print(threading.enumerate())


# ---------- EXAMPLE 2 ----------
time.sleep(5)
print("\nexample 2\n")

# subclassing thread object
class CustThread(threading.Thread):

    # put name for identification
    def __init__(self, name):
        # initialize super class
        threading.Thread.__init__(self)
        self.name = name

    # this method executes automaticaly (run)
    def run(self):
        print("Thread {} sleeps at {}"
              .format(self.name, time.strftime("%H:%M:%S", time.gmtime())))

        randsleeptime = random.randint(2, 3)
        time.sleep(randsleeptime)

        print("Thread {} stops sleeping at {}"
              .format(i, time.strftime("%H:%M:%S", time.gmtime())))

# create two threads
thread1 = CustThread("1")
thread2 = CustThread("2")

# start threads
thread1.start()
thread2.start()

# method for checking if thread is alive
print("\nThread 1 Alive :", thread1.is_alive())
print("\nThread 2 Alive :", thread2.is_alive())

# get names of threads
print("Thread 1 Name :", thread1.getName())
print("Thread 2 Name :", thread2.getName())

# wait for thread to exit
thread1.join()
thread2.join()


# ---------- EXAMPLE 3 ----------
print("\nexample 3\n")

# subclassing thread object and with thread lock
class BankAccount(threading.Thread):

    acctBalance = 100

    # name of person requesting, and quantity of money requested
    def __init__(self, name, moneyRequest):
        threading.Thread.__init__(self)
        self.name = name
        self.moneyRequest = moneyRequest

    # run runs automaticaly (in thread class)
    def run(self):
        threadLock.acquire()
        BankAccount.getMoney(self)
        threadLock.release()

    @staticmethod
    def getMoney(customer):
        print("{} tries to withdrawal ${} at {}".format(customer.name,
              customer.moneyRequest,
              time.strftime("%H:%M:%S", time.gmtime())))

        if BankAccount.acctBalance - customer.moneyRequest > 0:
            BankAccount.acctBalance -= customer.moneyRequest
            print("New account balance is : ${}".
                  format(BankAccount.acctBalance))
        else:
            print("Not enough money in the account")
            print("Current balance : ${}".format(BankAccount.acctBalance))


# lock thread in advance
threadLock = threading.Lock()

doug = BankAccount("Doug", 1)
paul = BankAccount("Paul", 100)
sally = BankAccount("Sally", 50)

doug.start()
paul.start()
sally.start()

doug.join()
paul.join()
sally.join()

# ---------- EXAMPLE 4 ----------
print("\nexample 4\n")

from threading import *

class Hello(Thread):
    def run(self):
        for i in range(5):
            print("Hello")

class Hi(Thread):
    def run(self):
        for i in range(5):
            print("Hi")

t1 = Hello()
t2 = Hi()

t1.start()
t2.start()

# wait for threads to finish and join main thread
t1.join()
t2.join()

print("Bye")

# ---------- EXAMPLE 5 ----------
print("\nexample 5\n")

from threading import Thread

def square_numbers():
    for i in range(100):
        i*i

threads = []
num_threads = 10

for i in range(num_threads):
    # create threads
    thread = Thread(target=square_numbers)
    threads.append(thread)

for p in threads:
    p.start()

# block main thread until all threads are completed
for p in threads:
    p.join()

print('end')

# ---------- EXAMPLE 6 ----------
print("\nexample 6\n")

from threading import Thread, Lock
import time

database_value = 0

def increase(lock):
    # declaring value as global for access inside a thread
    global database_value

    lock.acquire()
    database_value += 1
    time.sleep(0.1)
    lock.release()

    # alternative way
    # with lock:
    #     database_value += 1
    #     time.sleep(0.1)

lock = Lock()

print('start value', database_value)

thread1 = Thread(target=increase, args=(lock,))
thread2 = Thread(target=increase, args=(lock,))

thread1.start()
thread2.start()

thread1.join()
thread2.join()

print('end value', database_value)
