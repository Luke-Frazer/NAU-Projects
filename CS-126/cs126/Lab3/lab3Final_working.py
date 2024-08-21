import random
import string
import sys

# Establishes permited characters
allowed = set(string.ascii_lowercase + ' ')




# Establishes valid answers for yes / no questions
yes = {'yes', 'y', 'Y', 'YES', 'Yes'}
no = {'no', 'n', 'N', 'NO', 'No'}

# Establishes sets & lists which the program can
# search through

# Sets to check for membership
row1 = {'a1', 'b1', 'c1', 'd1', 'e1'}
row2 = {'a2', 'b2', 'c2', 'd2', 'e2'}
row3 = {'a3', 'b3', 'c3', 'd3', 'e3'}
row4 = {'a4', 'b4', 'c4', 'd4', 'e4'}
row5 = {'a5', 'b5', 'c5', 'd5', 'e5'}

col1 = {'a1', 'a2', 'a3', 'a4', 'a5'}
col2 = {'b1', 'b2', 'b3', 'b4', 'b5'}
col3 = {'c1', 'c2', 'c3', 'c4', 'c5'}
col4 = {'d1', 'd2', 'd3', 'd4', 'd5'}
col5 = {'e1', 'e2', 'e3', 'e4', 'e5'}

# Lists to check for position
lrow1 = ['a1', 'b1', 'c1', 'd1', 'e1']
lrow2 = ['a2', 'b2', 'c2', 'd2', 'e2']
lrow3 = ['a3', 'b3', 'c3', 'd3', 'e3']
lrow4 = ['a4', 'b4', 'c4', 'd4', 'e4']
lrow5 = ['a5', 'b5', 'c5', 'd5', 'e5']

lcol1 = ['a1', 'a2', 'a3', 'a4', 'a5']
lcol2 = ['b1', 'b2', 'b3', 'b4', 'b5']
lcol3 = ['c1', 'c2', 'c3', 'c4', 'c5']
lcol4 = ['d1', 'd2', 'd3', 'd4', 'd5']
lcol5 = ['e1', 'e2', 'e3', 'e4', 'e5']

# Decrypts the message
def decryptor(message):
    # Asks the user for the key and formats it into the full key
    alphabet = "abcdefghijklmnoprstvwxyz "
    password = input("Enter a key: ")
    password = password.replace("u", "v")
    password = password.replace("q", "k")
    password = password.lower()
    if len(password) > 25:
        password = password[0:25]
    else:
        password = password
    full_key = password + alphabet
    nothing = ""
    key = nothing.join(dict.fromkeys(full_key))
    # Assigns each letter in the key to a fixed location
    dict_location = {
        'a1': key[0],
        'b1': key[1],
        'c1': key[2],
        'd1': key[3],
        'e1': key[4],
        'a2': key[5],
        'b2': key[6],
        'c2': key[7],
        'd2': key[8],
        'e2': key[9],
        'a3': key[10],
        'b3': key[11],
        'c3': key[12],
        'd3': key[13],
        'e3': key[14],
        'a4': key[15],
        'b4': key[16],
        'c4': key[17],
        'd4': key[18],
        'e4': key[19],
        'a5': key[20],
        'b5': key[21],
        'c5': key[22],
        'd5': key[23],
        'e5': key[24]
    }
    # Determines how many times to run the loop
    messlen = len(message)
    # Establishes some accumulator variables
    answer = ""
    finalanswer = ""
    # Loop which decrypts two letters at a time
    while messlen > 0:
        # Finds the location of both letters
        x = message[0]
        y = message[1]
        a = (list(dict_location.keys())[list(dict_location.values()).index(x)])
        b = (list(dict_location.keys())[list(dict_location.values()).index(y)])
        # Checks if both letters are in the same row
        if {a, b} <= row1 or {a, b} <= row2 or \
           {a, b} <= row3 or {a, b} <= row4 or {a, b} <= row5:
            # Checks which row they are both in
            # Checks what row position they are in
            # Finds the letter directly to the left of each letter
            # Sets answer variable to new letters
            # Repeats through line 193
            if a in row1:
                rowloca = lrow1.index(a)
                rowlocb = lrow1.index(b)
                
                if rowloca == 0:
                    rowloca = 4
                else:
                    rowloca = rowloca - 1
                if rowlocb == 0:
                    rowlocb = 4
                    rowlocb = rowlocb - 1
                else:
                    rowlocb = rowlocb - 1

                
                newa = lrow1[rowloca]
                newb = lrow1[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row2:
                rowloca = lrow2.index(a)
                rowlocb = lrow2.index(b)

                if rowloca == 0:
                    rowloca = 4
                else:
                    rowloca = rowloca - 1
                if rowlocb == 0:
                    rowlocb = 4
                else:
                    rowlocb = rowlocb - 1

                newa = lrow2[rowloca]
                newb = lrow2[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row3:
                rowloca = lrow3.index(a)
                rowlocb = lrow3.index(b)

                if rowloca == 0:
                    rowloca = 4
                else:
                    rowloca = rowloca - 1
                if rowlocb == 0:
                    rowlocb = 4
                else:
                    rowlocb = rowlocb - 1

                newa = lrow3[rowloca]
                newb = lrow3[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row4:
                rowloca = lrow4.index(a)
                rowlocb = lrow4.index(b)

                if rowloca == 0:
                    rowloca = 4
                else:
                    rowloca = rowloca - 1
                if rowlocb == 0:
                    rowlocb = 4
                else:
                    rowlocb = rowlocb - 1

                newa = lrow4[rowloca]
                newb = lrow4[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            else:
                rowloca = lrow5.index(a)
                rowlocb = lrow5.index(b)

                if rowloca == 0:
                    rowloca = 4
                else:
                    rowloca = rowloca - 1
                if rowlocb == 0:
                    rowlocb = 4
                else:
                    rowlocb = rowlocb - 1

                newa = lrow5[rowloca]
                newb = lrow5[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])

        # Checks if both letters are in the same column
        elif {a, b} <= col1 or {a, b} <= col2 or \
             {a, b} <= col3 or {a, b} <= col4 or {a, b} <= col5:
            # Checks which column they are both in
            # Checks what column position they are in
            # Finds the letter directly above each letter
            # Sets answer variable to new letters
            # Repeats through line 287
            if a in col1:
                colloca = lcol1.index(a)
                collocb = lcol1.index(b)

                if colloca == 0:
                    colloca = 4
                else:
                    colloca = colloca - 1
                if collocb == 0:
                    collocb = 4
                else:
                    collocb = collocb - 1

                newa = lcol1[colloca]
                newb = lcol1[collocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in col2:
                colloca = lcol2.index(a)
                collocb = lcol2.index(b)

                if colloca == 0:
                    colloca = 4
                else:
                    colloca = colloca - 1
                if collocb == 0:
                    collocb = 4
                else:
                    collocb = collocb - 1

                newa = lcol2[colloca]
                newb = lcol2[collocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in col3:
                colloca = lcol3.index(a)
                collocb = lcol3.index(b)

                if colloca == 0:
                    colloca = 4
                else:
                    colloca = colloca - 1
                if collocb == 0:
                    collocb = 4
                else:
                    collocb = collocb - 1

                newa = lcol3[colloca]
                newb = lcol3[collocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in col4:
                colloca = lcol4.index(a)
                collocb = lcol4.index(b)

                if colloca == 0:
                    colloca = 4
                else:
                    colloca = colloca - 1
                if collocb == 0:
                    collocb = 4
                else:
                    collocb = collocb - 1

                newa = lcol4[colloca]
                newb = lcol4[collocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            else:
                colloca = lcol5.index(a)
                collocb = lcol5.index(b)

                if colloca == 0:
                    colloca = 4
                else:
                    colloca = colloca - 1
                if collocb == 0:
                    collocb = 4
                else:
                    collocb = collocb - 1

                newa = lcol5[colloca]
                newb = lcol5[collocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
        # Executes if they are both in different rows & columns
        else:
            # Checks which row the first letter is in
            # Checks which row the second letter is in
            # Finds the row position of each letter
            # Swaps the row positions of each letter
            # Repeats through line 379
            if a in row1:
                rowloca = lrow1.index(a)
                if b in row2:
                    rowlocb = lrow2.index(b)
                    newb = lrow2[rowloca]
                elif b in row3:
                    rowlocb = lrow3.index(b)
                    newb = lrow3[rowloca]
                elif b in row4:
                    rowlocb = lrow4.index(b)
                    newb = lrow4[rowloca]
                else:
                    rowlocb = lrow5.index(b)
                    newb = lrow5[rowloca]
                newa = lrow1[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row2:
                rowloca = lrow2.index(a)
                if b in row1:
                    rowlocb = lrow1.index(b)
                    newb = lrow1[rowloca]
                elif b in row3:
                    rowlocb = lrow3.index(b)
                    newb = lrow3[rowloca]
                elif b in row4:
                    rowlocb = lrow4.index(b)
                    newb = lrow4[rowloca]
                else:
                    rowlocb = lrow5.index(b)
                    newb = lrow5[rowloca]
                newa = lrow2[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row3:
                rowloca = lrow3.index(a)
                if b in row1:
                    rowlocb = lrow1.index(b)
                    newb = lrow1[rowloca]
                elif b in row2:
                    rowlocb = lrow2.index(b)
                    newb = lrow2[rowloca]
                elif b in row4:
                    rowlocb = lrow4.index(b)
                    newb = lrow4[rowloca]
                else:
                    rowlocb = lrow5.index(b)
                    newb = lrow5[rowloca]
                newa = lrow3[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row4:
                rowloca = lrow4.index(a)
                if b in row1:
                    rowlocb = lrow1.index(b)
                    newb = lrow1[rowloca]
                elif b in row2:
                    rowlocb = lrow2.index(b)
                    newb = lrow2[rowloca]
                elif b in row3:
                    rowlocb = lrow3.index(b)
                    newb = lrow3[rowloca]
                else:
                    rowlocb = lrow5.index(b)
                    newb = lrow5[rowloca]
                newa = lrow4[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            else:
                rowloca = lrow5.index(a)
                if b in row1:
                    rowlocb = lrow1.index(b)
                    newb = lrow1[rowloca]
                elif b in row2:
                    rowlocb = lrow2.index(b)
                    newb = lrow2[rowloca]
                elif b in row3:
                    rowlocb = lrow3.index(b)
                    newb = lrow3[rowloca]
                else:
                    rowlocb = lrow4.index(b)
                    newb = lrow4[rowloca]
                newa = lrow5[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])

        # Adds the two letters to the end of the accumulator variable
        finalanswer = finalanswer + answer
        message = message[2:]
        messlen = len(message)
    # Prints the final answer
    print("Message: ", finalanswer)

# Encrypts the message
def encryptor(message):
    # Asks the user for the key and formats it into the full key
    alphabet = "abcdefghijklmnoprstvwxyz "
    password = input("Enter a key: ")
    password = password.replace("u", "v")
    password = password.replace("q", "k")
    password = password.lower()
    if len(password) > 25:
        password = password[0:25]
    else:
        password = password
    full_key = password + alphabet
    nothing = ""
    key = nothing.join(dict.fromkeys(full_key))
    # Prints the full formatted key
    print("Key: [" + key + "]")
    # Assigns each letter in the key to a fixed location
    dict_location = {
        'a1': key[0],
        'b1': key[1],
        'c1': key[2],
        'd1': key[3],
        'e1': key[4],
        'a2': key[5],
        'b2': key[6],
        'c2': key[7],
        'd2': key[8],
        'e2': key[9],
        'a3': key[10],
        'b3': key[11],
        'c3': key[12],
        'd3': key[13],
        'e3': key[14],
        'a4': key[15],
        'b4': key[16],
        'c4': key[17],
        'd4': key[18],
        'e4': key[19],
        'a5': key[20],
        'b5': key[21],
        'c5': key[22],
        'd5': key[23],
        'e5': key[24]
    }
    # Determines how many times to run the loop
    messlen = len(message)
    # Establishes some accumulator variables
    answer = ""
    finalanswer = ""
    # Loop which encrypts two letters at a time
    while messlen > 0:
        # Finds the location of both letters
        x = message[0]
        y = message[1]
        a = (list(dict_location.keys())[list(dict_location.values()).index(x)])
        b = (list(dict_location.keys())[list(dict_location.values()).index(y)])
        # Checks if both letters are the same
        # If they are it sets the second one to "x"
        sub = (list(dict_location.keys())[list(dict_location.values()).index("x")])
        if a == b:
            b = sub
        # Checks if both letters are in the same row
        if {a, b} <= row1 or {a, b} <= row2 or \
           {a, b} <= row3 or {a, b} <= row4 or {a, b} <= row5:
            # Checks which row they are both in
            # Checks what row position they are in
            # Finds the letter directly to the right of each letter
            # Sets answer variable to new letters
            # Repeats through line 542
            if a in row1:
                rowloca = lrow1.index(a)
                rowlocb = lrow1.index(b)

                if rowloca == 4:
                    rowloca = 0
                else:
                    rowloca = rowloca + 1
                if rowlocb == 4:
                    rowlocb = 0
                else:
                    rowlocb = rowlocb + 1

                newa = lrow1[rowloca]
                newb = lrow1[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row2:
                rowloca = lrow2.index(a)
                rowlocb = lrow2.index(b)

                if rowloca == 4:
                    rowloca = 0
                else:
                    rowloca = rowloca + 1
                if rowlocb == 4:
                    rowlocb = 0
                else:
                    rowlocb = rowlocb + 1

                newa = lrow2[rowloca]
                newb = lrow2[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row3:
                rowloca = lrow3.index(a)
                rowlocb = lrow3.index(b)

                if rowloca == 4:
                    rowloca = 0
                else:
                    rowloca = rowloca + 1
                if rowlocb == 4:
                    rowlocb = 0
                else:
                    rowlocb = rowlocb + 1

                newa = lrow3[rowloca]
                newb = lrow3[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row4:
                rowloca = lrow4.index(a)
                rowlocb = lrow4.index(b)

                if rowloca == 4:
                    rowloca = 0
                else:
                    rowloca = rowloca + 1
                if rowlocb == 4:
                    rowlocb = 0
                else:
                    rowlocb = rowlocb + 1

                newa = lrow4[rowloca]
                newb = lrow4[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            else:
                rowloca = lrow5.index(a)
                rowlocb = lrow5.index(b)

                if rowloca == 4:
                    rowloca = 0
                else:
                    rowloca = rowloca + 1
                if rowlocb == 4:
                    rowlocb = 0
                else:
                    rowlocb = rowlocb + 1

                newa = lrow5[rowloca]
                newb = lrow5[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
        # Checks if both letters are in the same column
        elif {a, b} <= col1 or {a, b} <= col2 or \
             {a, b} <= col3 or {a, b} <= col4 or {a, b} <= col5:
            # Checks which column they are both in
            # Checks what column position they are in
            # Finds the letter directly below each letter
            # Sets answer variable to new letters
            # Repeats through line 635
            if a in col1:
                colloca = lcol1.index(a)
                collocb = lcol1.index(b)

                if colloca == 4:
                    colloca = 0
                else:
                    colloca = colloca + 1
                if collocb == 4:
                    collocb = 0
                else:
                    collocb = collocb + 1

                newa = lcol1[colloca]
                newb = lcol1[collocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in col2:
                colloca = lcol2.index(a)
                collocb = lcol2.index(b)

                if colloca == 4:
                    colloca = 0
                else:
                    colloca = colloca + 1
                if collocb == 4:
                    collocb = 0
                else:
                    collocb = collocb + 1

                newa = lcol2[colloca]
                newb = lcol2[collocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in col3:
                colloca = lcol3.index(a)
                collocb = lcol3.index(b)

                if colloca == 4:
                    colloca = 0
                else:
                    colloca = colloca + 1
                if collocb == 4:
                    collocb = 0
                else:
                    collocb = collocb + 1

                newa = lcol3[colloca]
                newb = lcol3[collocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in col4:
                colloca = lcol4.index(a)
                collocb = lcol4.index(b)

                if colloca == 4:
                    colloca = 0
                else:
                    colloca = colloca + 1
                if collocb == 4:
                    collocb = 0
                else:
                    collocb = collocb + 1

                newa = lcol4[colloca]
                newb = lcol4[collocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            else:
                colloca = lcol5.index(a)
                collocb = lcol5.index(b)

                if colloca == 4:
                    colloca = 0
                else:
                    colloca = colloca + 1
                if collocb == 4:
                    collocb = 0
                else:
                    collocb = collocb + 1

                newa = lcol5[colloca]
                newb = lcol5[collocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
        # Executes if they are both in different rows & columns
        else:
            # Checks which row the first letter is in
            # Checks which row the second letter is in
            # Finds the row position of each letter
            # Swaps the row positions of each letter
            # Repeats through line 732
            if a in row1:
                rowloca = lrow1.index(a)
                if b in row2:
                    rowlocb = lrow2.index(b)
                    newb = lrow2[rowloca]
                elif b in row3:
                    rowlocb = lrow3.index(b)
                    newb = lrow3[rowloca]
                elif b in row4:
                    rowlocb = lrow4.index(b)
                    newb = lrow4[rowloca]
                else:
                    rowlocb = lrow5.index(b)
                    newb = lrow5[rowloca]

                newa = lrow1[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row2:
                rowloca = lrow2.index(a)
                if b in row1:
                    rowlocb = lrow1.index(b)
                    newb = lrow1[rowloca]
                elif b in row3:
                    rowlocb = lrow3.index(b)
                    newb = lrow3[rowloca]
                elif b in row4:
                    rowlocb = lrow4.index(b)
                    newb = lrow4[rowloca]
                else:
                    rowlocb = lrow5.index(b)
                    newb = lrow5[rowloca]

                newa = lrow2[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row3:
                rowloca = lrow3.index(a)
                if b in row1:
                    rowlocb = lrow1.index(b)
                    newb = lrow1[rowloca]
                elif b in row2:
                    rowlocb = lrow2.index(b)
                    newb = lrow2[rowloca]
                elif b in row4:
                    rowlocb = lrow4.index(b)
                    newb = lrow4[rowloca]
                else:
                    rowlocb = lrow5.index(b)
                    newb = lrow5[rowloca]

                newa = lrow3[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            elif a in row4:
                rowloca = lrow4.index(a)
                if b in row1:
                    rowlocb = lrow1.index(b)
                    newb = lrow1[rowloca]
                elif b in row2:
                    rowlocb = lrow2.index(b)
                    newb = lrow2[rowloca]
                elif b in row3:
                    rowlocb = lrow3.index(b)
                    newb = lrow3[rowloca]
                else:
                    rowlocb = lrow5.index(b)
                    newb = lrow5[rowloca]

                newa = lrow4[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
            else:
                rowloca = lrow5.index(a)
                if b in row1:
                    rowlocb = lrow1.index(b)
                    newb = lrow1[rowloca]
                elif b in row2:
                    rowlocb = lrow2.index(b)
                    newb = lrow2[rowloca]
                elif b in row3:
                    rowlocb = lrow3.index(b)
                    newb = lrow3[rowloca]
                else:
                    rowlocb = lrow4.index(b)
                    newb = lrow4[rowloca]

                newa = lrow5[rowlocb]
                answer = (dict_location[newa])
                answer = answer + (dict_location[newb])
        # Adds the two letters to the end of the accumulator variable
        finalanswer = finalanswer + answer

        message = message[2:]
        messlen = len(message)
    # Prints the final answer
    print("Encrypted message: [" + finalanswer + "]")

# Asks the user if they want to run the program again
def tryagain():

    again = input("Try again?(y,n):  ")

    if again in yes:
        repeat()
    elif again in no:
        sys.exit()
    else:
        print("Invalid choice")
        tryagain()

# Allows the user to chose program function
def repeat():
    global choice
    choice = input("encrypt(1) or decrypt(2):")
    if choice == "1":
        encrypt()
    elif choice == "2":
        decrypt()
    else:
        print("Invalid choice")
        repeat()

# Function to prepare the message and run the encryptor
def encrypt():

    message = input("Message to encrypt:")

    length = len(message) % 2
    # Checks if the message contains forbiden characters
    # Checks if the message is an even or odd number of characters
    # Adds "x" to the end if odd
    # Replaces "u"s with "v"s
    # Replaces "q"s with "k"s
    if set(message) <= allowed:
        if length != 0:
            fixed = message + "x"
            fixed = fixed.replace("u", "v")
            fixed = fixed.replace("q", "k")
            encryptor(fixed)
        else:
            fixed = message
            fixed = fixed.replace("u", "v")
            fixed = fixed.replace("q", "k")
            encryptor(fixed)
    else:
        print("Invalid characters")

    tryagain()

# Function to check if the message is valid and run the decryptor
def decrypt():
    message = input("Message to decrypt:")

    length = len(message) % 2
    # Checks if the message contains forbiden characters
    # Checks if the message is an even or odd number of characters
    if length != 0:
        print("Invalid length")
    elif "q" in message:
        print("Invalid characters")
    elif "u" in message:
        print("Invalid characters")
    elif set(message) <= allowed:
        decryptor(message)
    else:
        print("Invalid characters")

    tryagain()

repeat()
