
import os

if os.path.exists('d:/MOVIES & SERIES/list.txt'):
  os.remove('d:/MOVIES & SERIES/list.txt')

for subdir, dirs, files in os.walk("d:/MOVIES & SERIES"):
    with open('d:/MOVIES & SERIES/list.txt', mode='a') as file:
        file.write(subdir)
        file.write("\n")
