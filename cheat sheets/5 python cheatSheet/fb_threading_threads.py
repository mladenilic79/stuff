
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ THREADS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import threading
from threading import Thread, Lock
import time

# show number of thread that are currently executing
print(threading.active_count())

# show all thread that are active at given time
print(threading.enumerate())

print()
print("example 1")
# ---------- EXAMPLE 1 - basic function ----------

# function to pass to threads
def toprint():
    print("print")

# crete threads
thread1 = Thread(target=toprint)
thread2 = Thread(target=toprint)

# start threads
thread1.start()
thread2.start()

# wait for threads to finish and join main thread
thread1.join()
thread2.join()

print("example 1 end")
print()
time.sleep(1)
print("example 2")
# ---------- EXAMPLE 2 - function with lock ----------

# value to access in different threads
database_value = 0

# pass lock to method
def increase(lock):
    
    # declaring value as global for access inside a thread
    global database_value

    # lock, access global variable, release lock
    lock.acquire()
    database_value += 1
    lock.release()

    # alternative way
    # with lock:
    #     database_value += 1

# create lock
lock = Lock()

print('start value', database_value)

# pass lock to threads
thread1 = Thread(target=increase, args=(lock,))
thread2 = Thread(target=increase, args=(lock,))

thread1.start()
thread2.start()

thread1.join()
thread2.join()

print('end value', database_value)

print("example 2 end")
print()
time.sleep(1)
print("example 3")
# ---------- EXAMPLE 3 - basic class ----------

# class with implemented thread module
class Hello(Thread):
    # run method automatically implements thread
    def run(self):
        print("Hello")

class Hi(Thread):
    def run(self):
        print("Hi")

t1 = Hello()
t2 = Hi()

t1.start()
t2.start()

t1.join()
t2.join()

print("example 3 end")
print()
time.sleep(1)
print("example 4")
# ---------- EXAMPLE 4 - complete class with init and lock ----------

# subclassing thread object
class CustThread(threading.Thread):

    global_variable = 0

    # put name for identification, else you don't need __init__
    def __init__(self, name):
        # initialize super class
        threading.Thread.__init__(self)
        self.name = name
        self.tlock = threading.Lock()

    # this method executes/run automaticaly
    def run(self):

        self.tlock.acquire()
        print("print")
        self.tlock.release()

        # alternatively with with
        # with self.tlock:
        #     print("print")

# create two threads
thread1 = CustThread("thread1")
thread2 = CustThread("thread2")

# start threads
thread1.start()
thread2.start()

# method for checking if thread is alive
print("Thread 1 Alive :", thread1.is_alive())
print("Thread 2 Alive :", thread2.is_alive())

# wait for thread to exit
thread1.join()
thread2.join()

print("example 4 end")
print()
