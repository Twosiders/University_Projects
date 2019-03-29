"""
ex2.py
Reads words from a list, and reverses them
for a hangman game. User has to guess letters,
if the guess is wrong a certain number of lives
are reduced.
"""
import os, random
"""
func1 creates dictionary. Fills word to guess
with asterisks representing the letters. 
Arguments: word : str, lives : int
Returns: myDict : dictionary
"""
def func1(word,lives) :
    myDict = {'secretWord':word, 'guessedWord':[], 'livesLeft':lives}
    myList = []
    for i in word :
        myList.append('*')    
    myDict['guessedWord'] = myList
    return myDict

"""
func2 checks whether the word has been guessed or not.
Argument: myDict : dictionary
Returns: guessed : boolean
"""
def func2(myDict) :
    guessed = False
    if any('*' in s for s in myDict['guessedWord']) : guessed = False
    else :
        guessed = True
    return guessed

"""
func3 returns the amount of lives left.
Argument: myDict : dictionary
Returns: myDict['livesLeft'] : int
"""
def func3(myDict) :
    return myDict['livesLeft']

"""
func4 returns the word to be guessed.
Argument: myDict : dictionary
Returns: myDict['guessedWord'] : str
"""
def func4(myDict) :
    return myDict['guessedWord']

"""
func5 combines and prints lives left and word to be guessed for user.
Argument: myDict : dictionary
Returns: myString : str
"""
def func5(myDict) :
    myString = ''.join([c for c in str(["WORD: ", func4(dictio), "; you have ", func3(dictio), " lives left"]) if c not in ",'[]()"])
    return myString

"""
func6 checks if userInput is equal to any letters of secretWord. If yes it appends the
index of the letter to the index list. If the list is empty, it didn't find any
matches, therefore the user got it wrong and it decrements the lives.
Argument: myDict : dictionary, inputC: char
"""
def func6(myDict, inputC) :
    index = []
    k = 0
    for i in myDict['secretWord'] :
        if inputC == i :
            index.append(k)
        k = k + 1
    if len(index) < 1 : myDict['livesLeft'] = myDict['livesLeft'] - 1
    else :
        guess = myDict['guessedWord']
        for i in index :
            guess[i] = inputC    
    return len(index)

def playGame(word, lives) :
    while dictio['livesLeft'] > 0 and func2(dictio) == False :
        print(func5(dictio))
        inputC = str(input("Enter character: ")).upper()
        inputC = inputC[0:1]
        print("Occurences: ", func6(dictio, inputC))
    if func2(dictio) == True: print("You won! Well done! The word was", dictio['secretWord'])
    else : print("You lost. The word was ", dictio['secretWord'])
#words_for_hangman.txt
myFile = input("Please enter the name of the file that contains the words: ")
try:
    fileObject = open(myFile)
    if fileObject != None:
        content = fileObject.read().splitlines()
        runLoop = True
        while runLoop == True :
            inputWord = random.choice(content)
            try:
                while runLoop == True :
                    uInput = int(input("Enter difficulty. 1 - Easy, 2 - Hard, 3 - Insane: "))
                    runLoop = False
                    if uInput == 1 : inputLives = 10
                    elif uInput == 2 : inputLives = 5
                    elif uInput == 3 : inputLives = 3
                    else :
                        print("Invalid input.")
                        runLoop = True
                dictio = func1(inputWord, inputLives)        
                playGame(inputWord, inputLives)
                runLoop = False
                while runLoop == False :
                    uInput = str(input("Restart? Yes[Y], No[N] ")).upper()
                    print(uInput)
                    if uInput == 'Y' : runLoop = True
                    elif uInput == 'N' :
                        print("Aborting...")
                        os._exit(1)
                    else :
                        print("Invalid input. [Y] for restart, [N] for no. ")
            except ValueError as e:
                print("Invalid input.")
except IOError as e :
    fileObject = None
    print("Failed to open file. Aborting...")
    os._exit(1)
