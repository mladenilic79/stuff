
###############################################################
# BASICS ######################################################
###############################################################

# powershell - basic console, run as administrator
# powershell ise - integrated environment, run as administrator

# interupt console
# ctrl-c

# add flag after every command to find out what will happen
# -whatif
# add flag after every command to confirm execution
# -confirm

# get powershell version
$PSVersionTable

# execution policy
Set-ExecutionPolicy -ExecutionPolicy Unrestricted
Set-ExecutionPolicy -ExecutionPolicy Unrestricted -Scope CurrentUser
# windows powershell shortcut parameter add to end of target path
# %SystemRoot%\system32\WindowsPowerShell\v1.0\powershell.exe -ExecutionPolicy Unrestricted

# clear screen
cls
clear
Clear-Host

# help on specific command
Get-Help Format-Table
Get-Help -Name Format-Table
Get-Help Format-Table -Detailed
Get-Help Format-Table -Full

# list modules available
Get-Module -ListAvailable
# list modules specified
Get-Module -ListAvailable PSDiagnostics, Dism
# import modules
Import-Module -Name PSDiagnostics
# import modules with parameters
Import-Module -Global -Name PSDiagnostics
# import only specified functions from module
Import-Module PSDiagnostics -Function Disable-PSTrace, Enable-PSTrace

# list aliases
Get-Alias
# list verbs
Get-Verb
# list all available commands
Get-Command

# set working location
Set-Location -Path "C:\Users\mlade\OneDrive\Desktop"

###############################################################
# TYPES & VARIABLES ###########################################
###############################################################

# variables create with $
# variables are not case sensitive
# anything can be stored in them
$var2 = Get-ComputerInfo
# access properties with period and press TAB to go through properties
$var2.BiosCaption
# declare & redeclare variables
$varTest = "4"
# [] here cast operator
[float]$varTest = 2.2
[decimal]$varTest = 2.2
[string]$varTest = "pera"
# get variable type
$varTest.GetType()
$varTest.GetType().name
# automatic variable
# $_

# complex types
# arrays
$letterArray = 'a','b','c','d'
$letterArray[3]
$letterArray[2]
# hash table - dictionary
$letterHash = @{
	'a'=10
	'b'=5
	'c'=8
	'd'=9
}
$letterHash['a']
$letterHash['b']
# range operator
# ..
1..10
$a = 10
1..$a

# enumerators
# skipped

# object variables
# skipped

###############################################################
# INPUT OUTPUT ################################################
###############################################################

# output to console
Write-Host "pera" -ForegroundColor Yellow
# output to pipeline, invoked implicitly
Write-Output "test message"
# echo is an alias for write-output
echo "test message"

# double quotes recognizes variables
write-output "pera $vartest"
# single quotes are literal
write-output 'pera $vartest'

# input
$inputvar = Read-Host "this is input prompt"
Write-Host $inputvar

###############################################################
# SEARCHING & FINDING & LISTING ###############################
###############################################################

# get everithing powershell see on the system
get-psdrive
# list all processes
get-process
# get specific process
get-process winlogon
# list all services
get-service
# get specific service
get-service svsvc
# start/stop service
get-service svsvc | stop-service
get-service svsvc | start-service
# list environment variables
Get-ChildItem env:
# get specific environment variable
$env:SystemRoot
$env:TMP

# search / filter / sort & format list / table & expand with get-member / select-object & grid-view
Get-Command | Where-Object | Sort-Object | Select_Object Name | format
Get-Sevice | Get-Member | Select-Object
Get-Command *Wait*
Get-Command -Verb Add
Get-Command -Noun Computer
Get-Command -Verb Get, Set -Noun *Firewall*
Get-Command -CommandType Cmdlet
Get-Command | Where-Object { $_.CommandType -eq 'cmdlet' }
Get-Command | Where-Object { $_.Name -like '*workflow*' }
# ! for negation
Get-Command | Where-Object { ($_.Name -like '*workflow*') -and !($_.CommandType -eq 'cmdlet') }
# get everything about get service command
Get-Service | Get-Member
# format output as list or table or gridview
get-service | format-list
Get-service | format-table
get-service | out-gridview
Get-service -ServiceName 'Dnscache'
Get-service -ServiceName 'Dnscache' | Select-Object -Property *
Get-service -ServiceName 'Dnscache' | Select-Object -Property 'StartType'
Get-service -ServiceName * | Select-Object -Property 'Status', 'DisplayName', 'StartType'
Get-service -ServiceName * | Select-Object -Property 'Status', 'DisplayName' | Sort-Object -Property 'Status' -Descending
Get-service -ServiceName 'Dnscache' | Get-Member
Get-service -ServiceName 'Dnscache' | Get-Member -MemberType Property
    
###############################################################
# LOGIC & FLOW ################################################
###############################################################

# if
# -lt less than, -gt greater than, -eq equal, -ne not equal, -le less than or equal
$value = 2
if($value -lt 9) { Write-Host "Value is less than 9" }
if($value -gt 9) { Write-Host "Value is greater than 9" }
if($value -eq 9) { Write-Host "Value is equal to 9" } else { Write-Host "Value is greater than 9" }
if ($value -gt 3) {
    Write-Host "greater than 3"
} elseif ($value -gt 2) {
    Write-Host "greater than 2"
} else {
	Write-Host "greater than 1"
}

# ternary operators
4 -gt 5 ? Write-Host 'exists' : Write-Host 'not found'
(4 -gt 5) ? Write-Host 'exists' : Write-Host 'not found'
$value = (4 -gt 5) ? Write-Host 'exists' : Write-Host 'not found'

# Switch Statement with Default
$value = "tojota"
Switch ($value) {
    "mercedes" {Write-Output "mercedes"}
    "fica" {Write-Output "fica"}
    "peglica" {Write-Output "peglica"}
    default {'You did not type any brand'}
}

# foreach ($<item> in $<collection>){<statement list>}
$letterArray = 'a','b','c','d'
foreach ($letter in $letterArray) {
  Write-Host $letter
}

# foreach-object
get-childitem C:\Users\mlade\OneDrive\Desktop | foreach-object {
	Write-Output $_
	write-host $_.name
}

# for
for ($i=1; $i -le 10; $i++){
	write-host $i
}

# while
$count = 0
while ($count -lt 20) {
	write-host $count
	$count++
}

# do while
$count=0
do {
	write-host $count
	$count++
} while ($count -lt 10)

###############################################################
# SPECIAL OPERATORS ###########################################
###############################################################

# Subexpression operator $( )
# Returns the result of one or more statements. For a single result, returns a scalar. For multiple results, returns an array. Use this when you want to use an expression within another expression. For example, to embed the results of command in a string expression.

# Array subexpression operator @( )
# Returns the result of one or more statements as an array. The result is always an array of 0 or more objects.

# && and || operators
# If Get-Process successfully finds a process called notepad,
# Stop-Process -Name notepad is called
Get-Process notepad && Stop-Process -Name notepad
# If npm install fails, the node_modules directory is removed
npm install || Remove-Item -Recurse ./node_modules

# null operators
# Null-coalescing operator ??
# Null-coalescing assignment operator ??=
# Null-conditional operators ?. and ?[]

###############################################################
# FUNCTIONS ###################################################
###############################################################

# functions
function Display-Message(){
	write-host "my message"
}
Display-Message

function Display-Message($message){
	write-host $message
}
Display-Message "my message"

# function will accept any number of parameters into args 
function Display-Message(){
	[String]$Value1 = $args[0]
	[String]$Value2 = $args[1]
	Write-Host $Value1 $Value2
    write-host $args.Length
    write-host $args.Count
}
Display-Message
Display-Message "my message 1"
# this will be separate single parameters
Display-Message "my message 1" "my message 2" "pera"
# this will be one array parameter
Display-Message "my message 1", "my message 2", "pera"
# this will be one array parameter & one extra single parameter, so 2 in total
Display-Message "my message 1", "my message 2", "pera" "sima"

###############################################################
# FILES #######################################################
###############################################################

$documentsPath = C:\Users\mlade\Documents
$desktopPath = C:\Users\mlade\OneDrive\Desktop

# combine paths with concatenation & with join-path command

# list current content
ls
dir
Get-ChildItem
# list directory content
get-ChildItem C:\
get-ChildItem -path C:\
# list directory content with hidden items & system items
get-ChildItem -force C:\
# with names only
get-ChildItem C:\ -name
# also look in all subdirectories
get-ChildItem -path $documentsPath -recurse
# search with * for any text
# search with ? for any single character
get-ChildItem -path (join-path -path $documentsPath -ChildPath '*.txt') -recurse
# include/exclude specified type
get-ChildItem -path $documentsPath -include *.xlsx
get-ChildItem -path $documentsPath -exclude *.xlsx
# use where filter less than in this case
get-ChildItem -path $documentsPath -recurse | where-object -filterscript { ($_.lastWriteTime -lt '2023-10-22') }
# alternative to include & exclude
Get-ChildItem -Path $documentsPath -filter *.xlsx

# create new item
new-item -path (join-path -path $desktopPath -ChildPath "newDir") -ItemType directory
# force overwrite
new-item -path (Join-Path -path $desktopPath -ChildPath "newDir\newfile.txt") -ItemType file -force

# output to file
"create file from string" | Out-File ($desktopPath+"\newDir\newfile.txt")
"pera" | out-file -filePath ($desktopPath+"\newDir\newfile.txt")

# copy items
copy-item -path ($desktopPath+"\newDir\newfile.txt") -destination ($desktopPath+"\newDir\newfile2.txt")

# rename
rename-item -path ($desktopPath+"\newDir\newfile.txt") -newname ($desktopPath+"\newDir\newfile3.txt")

# delete
remove-item -path ($desktopPath+"\newDir") -recurse

###############################################################
# EXEPTIONS ###################################################
###############################################################

try {
	5 / 0
} catch {
	Write-Host "catch an error"
	Write-Host $_
	Write-Host $_.ScriptStackTrace
	write-error "error $($_.Exception.Message)"
} finally {
	Write-Host "ovo je finaly"
}

throw "error"
