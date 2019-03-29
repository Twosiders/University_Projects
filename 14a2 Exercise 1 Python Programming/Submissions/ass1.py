"""
ass1.py
CE151 assignment 1 template
created by sands 30/10/10
modified by sands 28/10/11 - number of exercises changed
exercises written by amezod 11/11/14
"""
from math import sqrt, atan, degrees
from collections import Counter

def ex1() :
    """
    exercise 1
    calculates angles and hypotenuse of a triangle
    arguments: width, height : float
    returns hypo (hypotenuse), angleA, angleB : float,
    """
    print(" - The right angled triangle - ")
    width = float(input("Enter the width of the triangle: "))
    height = float(input("Enter the height of the triangle: "))
    if width < 0 or height < 0 :
        print("Value entered can't be less than zero.")
    else :
        hypo = (width * width) + (height * height) #hypotenuse calculation
        print("The hypotenuse of the triangle is: ", round(sqrt(hypo), 1)) #up to 1 decimal figures
        angleA = degrees(atan(height / width))  #calculating angleA with the functions degrees and atan
        angleB =  90 - angleA #we know one angle is 90 degrees, the other one we just calculated, so subtract those to get the 3rd angle
        print("The angles of the triangle are the following: 90 degrees, ",
              round(angleA,1), " degrees, and ", round(angleB, 1), " degrees.")    
def ex2() :
    """
    exercise 2
    show number members of the fibonacci list defined by user
    argument: userNumber : int
    fiboList : [1,1]
    returns expanded list if input > list
    0 if input = 0; 1 if input = 1; 1,1 if input = 2
    """
    print(" - Fibonacci Series - ")
    userNumber = int(input("Enter number of fibonacci numbers to show: "))
    fiboList = [1,1] #list starts with 1,1
    if userNumber == 0 : print(0)
    if userNumber < 0 : print("Number entered can't be less than 0.")
    elif userNumber == 1 : print(1) #fibonacci list rules 
    elif userNumber == 2 : print("1,1")
    else :
        while userNumber > len(fiboList) : #until our list reaches the desired number - 
            fiboList.append(fiboList[-1] + fiboList[-2]) # - keep calculating the fibo number and adding it to the end of the list
        print("{}".format(",".join(map(repr, fiboList)))) #format the list without spaces and comma inbetween
 
def ex3() :
    """
    exercise 3
    checks whether user input is prime number
    argument: prime: int
    returns 'The number is prime'
    or 'The number is not prime'
    """
    print(" - Prime Numbers - ")
    prime = int(input("Please enter an integer: "))
    if prime == 2 or prime == 3 : print("The number is prime") #2, 3 are prime numbers
    elif prime%2 == 0 or prime%3 == 0 or prime == 1 : print("The number is not prime.") #if the user number can be perfectly divided with 2, 3 or if it is 1 != prime
    elif prime <= 0 : print("Please enter an integer higher than 0")   #negative numbers don't count 
    else : print("The number is prime") #otherwise it's prime
    
def factorial(num) :    #ex4 needed a factorial function 
    if num == 0 : return(1)
    else : return num * factorial(num-1)
def ex4() :
    """
    exercise 4
    calculates the binomial coefficients of 2 user inputted numbers
    arguments: x, y, facX, facY : int
    returns facX//facY (binomial coefficient of x and y)
    """
    print(" - Binomial Coefficients - ")
    x = int(input("Please enter the value of x (larger number): "))
    y = int(input("Please enter the value of y (smaller number): "))
    if y>x : print("The answer is 0.")
    elif y < 0 or x < 0 : print("Number entered cannot be less than 0") #no negatives
    elif y == 0 and x == 0 :print("The answer is 1") #if both 0 == 1
    else:
        i = 1 #start with 1 not 0 as usual
        facX = x #use another variable which equals x to begin with
        while i < y : #we need as many top numbers as bottom ones, so keep calculating til it reaches the bottom number
            facX = facX * (x - i) #keep calculating
            i = i + 1
        facY = factorial(y) #for the bottom number all we need is it's factorial
        print("The binomial coefficient of ", x, " and ", y, " is: ", facX//facY) #divide x number with fac(y)  
def ex5() :
    """
    exercise 5
    enter text, split into words
    display words one per line, print length of shortest/longest words
    argument: userText: int
    returns splitText[word], max(len(word)), min(len(word))
    """
    print(" - Sentence Splitter - ")
    userText = input("Enter a line of text: ")
    splitText = userText.split() #split function to generate list of words
    for word in splitText : #for every word generate newline and print those words
        print(word)
    print("The longest word is ", max(len(word) for word in splitText), " characters long.") #max() function to check every word in list and show longest
    print("The shortest word is ", min(len(word) for word in splitText), " characters long.")#min() function to check every word in list and show shortest
  
def ex6() :
    """
    exercise 6
    enter text, count vowels, display least frequent vowel
    arguments: userInput: int, vowel, minVowels: str
    return userInput, minVowels
    """
    print(" - Vowel Counter - ")
    userInput = input("Enter a word or sentence: ")
    vowel = "aeiou" #list of vowels
    userInput = Counter(char for char in userInput.lower() if char in vowel) #if 'hello' userInput = {'o':1, 'e':1}. lower() makes them lowercase as well
    minVowels = {k: userInput[k] for k in userInput if userInput[k] == min(userInput.values())} #if a vowel has a minimum occurance, add it into minVowels
                #k = vowel, userInput[k] = occurance
    print("The least occuring vowel is:")
    for e in minVowels: #for every least occurring vowel print them on a newline and their occurences 
        print(e," with ",minVowels[e]," occurences.")#
def ex7() :
    """
    exercise 7
    enter list of non negative integers
    sorts numbers into ascending order
    arguments: list, number, size: int
    return list (which has been sorted)
    """
    print(" - Number Comparator - ")
    list = []
    print("Enter numbers one per line to sort into ascending order.")
    print("Use a negative number to finish")

    number = int(input("First number: "))
    if number == 0 : print("You can't enter 0 as a number.")
    else : 
        while number > 0 : #if negative number entered, inputting to list terminates
                list.append(number) #add to end of list
                number = int(input("Next number: "))
        print("List entered: ",list) 
        size = len(list) - 1                                    # -1 because otherwise list would be out of range
        def swapper(list) :
            sorted = False                                      #false to being with 
            while not sorted :
                sorted = True                                   #if no swapping is done through 1st iteration, terminate
                for i in range(size) :                          #start = 0, end = length of list, iterate by 1
                    #if size > 1 : size = size - 1
                    if list[i] > list[i+1] :                    #if list item 1 is bigger than 2
                        list[i], list[i+1] = list[i+1], list[i] #swap the 2 items
                        sorted = False                          #list is not sorted yet

        print("Swapping numbers...")
        swapper(list)           
        print(list)     
def ex8() :
    """
    exercise 8
    enter date in the future
    calculates difference between date and today in days
    arguments: today, userDate : date_object
    return: delta (difference) : str
    """
    print(" - Date Calculator - ")
    import datetime
    today = datetime.date.today()
    print(today)
    try :   #try catch method, in case user enters non-date, or 31st Feb etc.
        userDate = input("Please enter the date to check in a dd/mm/yy format: ") #userDate is string
        userDate = datetime.datetime.strptime(userDate, '%d/%m/%Y').date()      #userDate is date_object
        if userDate < today : print("Invalid input, date is in the past")
        elif userDate == today: print("That's today you dum-dum, answer is 0 days.")
        else:
            delta = userDate - today #calculate difference
            delta = str(delta)       #date_object don't work with split only str
            delta = delta.split(",") #unorthodox method to delete time (0:00:0) from the days
            print("The number of days between today (",today,") and entered date (",userDate,") are ",delta[0],".")
    except ValueError as e :
        print("Not a valid date.")


# modify the following line so that your name is displayed instead of Lisa's
print("CE151 assignment 1 - Alex Mezodi")

# do not modify anything beneath this line
exlist = [None, ex1, ex2, ex3, ex4, ex5, ex6, ex7, ex8]
running = True
while running :
    line = input("Select exercise (0 to quit): ")
    if line == "0" : running = False
    elif len(line)==1 and "1"<=line<="8": exlist[int(line)]()
    else : print("Invalid input - try again")


