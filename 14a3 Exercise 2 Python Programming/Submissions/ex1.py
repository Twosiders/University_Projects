"""
ex1.py
Student Details
Reads information about students from an external file
and makes them available to search through
"""
import os
myTup = ()
"""
Splits the read line to 5 parts.
Argument: myList : str
Returns: myTup : tuple
"""
def readLine(myList) :
    myList = myList.split(" ")
    if len(myList) == 6 :
        myList[3] = myList[3]+ " " + myList[4]
        myList[4] = myList[5]
        myList.pop()
    global myTup
    myTup = myList
    return(myTup)
"""
Prints out the tuple in a nice way.
Argument: myTup : tuple
Returns: None
"""
def printLine(myTup) :
    print(format(myTup[4] + ", " + myTup[3], "32s") + format(myTup[0], "7s") + format(myTup[2], "6s") + format("Year " + myTup[1], "1s"))
"""
Try to open file, if not abort.
Below, read each line and strip them of the \n,
store them in a list, then perform the print function.
"""
myFile = input("Specify input file: ")
try: 
    fileObject = open(myFile)
    if fileObject != None:
        content = fileObject.readlines()
        myList = []
        studList = []
        i = 0    
        for elem in content :   
            elem = elem.strip() 
            if elem :      
                myList.extend(elem.strip().split('\n'))
                readLine(myList[i])
                studList.append(myList[i])
                printLine(myTup)
                i = i + 1
    """
    Initiate the menu with the options.
    - Degree search finds all the matching students,
    reverses list and sorts by surname.
    - Year search takes 2 numbers from user. A while loop
    is used to store all the numbers between the lower and
    higher numbers in a list, so the program can match those years.
    - Registration number search finds a single person with the number,
    reverses list, pops all the unnecessary data, then reverses again so
    surname prints out first.
    """
    menu = True
    while menu == True :        
        menuOption = str(input("\nTo choose a menu option, type in the corresponding number...\n" 
              "Search for degree scheme - 1 \n"
              "Search for year range    - 2 \n"
              "Look up reg. number      - 3 \n"
              "Quit the program         - 4 \n"))
        if menuOption == "1" :
            nameList = []
            uInput = str(input("Degree Scheme Search, enter degree scheme: ")).upper()
            matching = [s for s in studList if uInput in s]
            for e in matching :
                readLine(e)
                nameList.append(myTup)
            for elem in nameList :
                elem.reverse()
            nameList.sort()    
            for item in nameList:
                print(format(item[0] + ", " + item[1], "32s") + format(item[4], "7s") + format(item[2], "6s") + format("Year " + item[3], "1s"))
        elif menuOption == "2" : 
            uInput = str(input("Year Range Search, enter years like 1-2 "))  
            uInput = uInput.split("-")
            uInput[0] = int(uInput[0])
            uInput[1] = int(uInput[1])
            k = uInput[0]
            newInput = []
            while k < uInput[1] :
                uInput.append(k+1)
                k = k + 1
            uInput.pop()
            uInput.sort()    
            uInput = [str(x) for x in uInput]           
            for i in uInput :
                newInput.append(" " + i + " " )   
            for i in newInput :
                matching = [s for s in studList if i in s]
                for e in matching :
                    readLine(e)
                    printLine(myTup)
        elif menuOption == "3" :
            nameList = []
            uInput = str(input("Registration number search, enter 6 or 7 digit number: "))
            matching = [s for s in studList if uInput in s]
            for e in matching :
                readLine(e)
                nameList.append(myTup)
            nameList.reverse()    
            for elem in nameList :
                elem.pop(0)
                elem.pop(0)
                elem.pop(0)
            nameList.reverse()       
            for item in nameList:
                print(item[0], ', '.join(map(str, item[1:])))
        elif menuOption == "4" :
            os._exit(1)
        else : print("Inappropriate option.")
except IOError as e :
    fileObject = None
    print("Failed to open file, program aborted.")
    os._exit(1)
