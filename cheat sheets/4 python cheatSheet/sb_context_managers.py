
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ CONTEXT MANAGERS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# how to create custom WITH RECOURCE

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ FUNCTION EXAMPLE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# this example is unclear, doesn't work

from contextlib import contextmanager

@contextmanager
def open_managed_file(filename):
    f = open(filename, 'w')
    try:
        yield f
    finally:
        f.close()

with open_managed_file('notes.txt') as f:
    f.write('some todoo...')

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ CLASS EXAMPLE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# this example is unclear, doesn't work

class ManagedFile:
    def __init__(self, filename):
        print('init')
        self.filename = filename

def __enter__(self):
    print('enter')
    self.file = open(self.filename, 'w')
    return self.file

def __exit__(self, exc_type, exc_value, exc_traceback):
    if self.file:
        self.file.close()
    print('exc:', exc_type, exc_value)
    print('exit')

with ManagedFile('notes.txt') as file:
    print('do some stuff...')
    file.write('some todoo...')
