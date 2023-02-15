
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ METHODS MAIN @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# What if you want code to execute when you run the script from the command
# line but not when the Python interpreter imports the file as module
# add this code to any script that you want to use both solo and as an import

# put all code in main method
def main():
    pass

# put this at the end of file/script/module
# special value of "__main__" for the __name__ variable means the
# Python interpreter is executing your script and not importing it
if __name__ == "__main__":
    main()
