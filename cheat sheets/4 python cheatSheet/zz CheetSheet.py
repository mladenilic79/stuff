
# ---------- TKINTER ----------

# Test to see if TkInter is working
# import tkinter
# tkinter._test()

from tkinter import *
from tkinter import ttk # for alternative styling
from tkinter import messagebox

boolVar = True
strVar = "pera"
intVar = 3
dblVar = 8

# root is the main window that surrounds your interface
# This creates a Tk object
root = Tk()

# You can define the size of the window and the
# position on the screen with
# widthxheight+xoffset+yoffset
root.geometry("400x400+300+300")

# You can make it so the window isn't resizable
root.resizable(width=False, height=False)

# Give your app a title
root.title("First GUI")

# Frame widgets surround other widgets
frame = Frame(root)

# ---------- TKINTER: MULTIPLE COMPONENTS  ----------
# Some of the different Widgets : Button, Label,
# Canvas, Menu, Text, Scale, OptionMenu, Frame,
# CheckButton, LabelFrame, MenuButton, PanedWindow,
# Entry, ListBox, Message, RadioButton, ScrollBar,
# Bitmap, SpinBox, Image

# ---------- TKINTER: PACK GEOMETRY MANAGER  ----------
# Pack positions widgets by allowing them to define their position (Top,
# Right, Bottom, Left) and their fill direction (X, Y, BOTH, NONE) inside of
# a box

# Label(frame, text="A Bunch of Buttons").pack()
# Button(frame, text="B1").pack(side=LEFT, fill=Y)
# Button(frame, text="B2").pack(side=TOP, fill=X)
# Button(frame, text="B3").pack(side=RIGHT, fill=X)
# Button(frame, text="B4").pack(side=LEFT, fill=X)
#
# label = Label(frame, textvariable="labelText")
# button = Button(frame, text="Click Me")
# label.pack()
# button.pack()
#
# frame.pack()


# ---------- TKINTER: FUNCTIONS ----------
def get_sum(event):  # event=None can be also
    # Get the value stored in the entries
    num1 = int(Entry1.get())

    # Delete the value in the entry
    Entry1.delete(0, "end")

    # Insert value into the entry
    Entry1.insert(0, sum)


# You can open message boxes
def open_msg_box():
    messagebox.showwarning("Event Triggered", "Button Clicked")


# Quits the TkInter app when called
def quit_app():
    root.quit()


# ---------- TKINTER: GRID GEOMETRY MANAGER ----------
# The Grid manager is the most useful using a series of rows and columns for
# laying out widgets. Each cell can only hold 1 widget, but a widget can cover
# multiple cells.

# rows start at 0, 1, ...
# columns start at 0, 1, ...
# sticky defines how the widget expands (N, NE, E, SE, S, SW, W, NW)
# padx and pady provide padding around the widget above and below it

Label1 = Label(root, text="First Name")
Label1.grid(row=0, sticky=W, padx=4)
# update label
Label1['text'] = 'Konvertovano: {:.1f} eura'.format(num1)

Entry1 = Entry(root, width=50)
Entry1.grid(row=0, column=1, sticky=E, pady=4)
# delete entry
Entry1.delete(0, END)

Button1 = Button(root, text="Submit")
Button1.grid(row=3)
# When the left mouse button is clicked call the function get_sum
Button1 = ttk.Button(frame, textvariable=num1,
                     command=open_msg_box, accelerator="command-H")
# accelerator is used to show a shortcut
# OSX, Windows and Linux use the following options
# Command-O, Shift+Ctrl+S, Command-Option-Q with the
# modifiers Control, Ctrl, Option, Opt, Alt, Shift,
# and Command
Button1.bind("<Button-1>", get_sum)
Button1.unbind("<Button-1>")

Radio1 = Radiobutton(root, text="Dmg", value=4)
Radio1.grid(row=5, column=0, sticky=W)

Check1 = Checkbutton(root, text="Free Shipping",
                     variable=boolVar)
Check1.grid(row=2, column=1, sticky=W)
# When the left mouse button is clicked call the function bind_button
Check1.bind("<Button-1>", get_sum())

# You can also disable and enable widgets
Button1['state'] = 'disabled'
Button1['state'] = 'normal'

# ---------- TKINTER: GETTERS AND SETTERS ----------
# there are TkInter variables you can use with Widgets to set and get values
strVar = StringVar()
intVar = IntVar()
dblVar = DoubleVar()
boolVar = BooleanVar()

# Set the default values with set()
strVar.set("Enter String")
intVar.set("Enter Integer")
dblVar.set("Enter Double")
boolVar.set(True)

print("String :", strVar.get())
print("Integer :", intVar.get())
print("Double :", dblVar.get())
print("Boolean :", boolVar.get())

# ---------- TKINTER: STYLING WIDGETS ----------
# Color option names are here http://wiki.tcl.tk/37701
# For the font list the font family, px and font style
style = ttk.Style()
# You can change the theme style for your applications
# This shows you all the themes for your OS
print(ttk.Style().theme_names())
# Show theme in use
print(ttk.Style().theme_use())
# Change the theme for every widget (always set one by default)
ttk.Style().theme_use('clam')
# master style override is with "."
style.configure(".", foreground="midnight blue",
                font="Times 20 bold italic", padding=20)
# Ttk widget names : TButton, TCheckbutton, TCombobox,
# TEntry, TFrame, TLabel, TLabelframe, TMenubutton,
# TNotebook, TProgressbar, TRadiobutton, TScale,
# TScrollbar, TSpinbox, Treeview
# You can see current style settings like this
print(style.lookup('TButton', 'font'))
print(style.lookup('TButton', 'foreground'))
print(style.lookup('TButton', 'padding'))

# ---------- TKINTER: MENU BARS ----------

# Create the menu object
the_menu = Menu(root)

# Create a pull down menu that can't be removed
file_menu = Menu(the_menu, tearoff=0)

# Add items to the menu that show when clicked
# compound allows you to add an image
# Call for the function to execute when clicked
file_menu.add_command(label="Quit", command=quit_app)
# Add a horizontal bar to group similar commands
file_menu.add_separator()
# Add the pull down menu to the menu bar
the_menu.add_cascade(label="File", menu=file_menu)

# Bind the shortcut to the function
root.bind('<Command-A>', open_msg_box)
root.bind('<Command-a>', open_msg_box)

# Display the menu bar
root.config(menu=the_menu)

# This keeps the root window visible and your program running
root.mainloop()
