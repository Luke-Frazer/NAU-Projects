import random
import string
import sys

allowed = set(string.ascii_lowercase + ' ')

choice = input("encrypt(1) or decrypt(2):")

yes = {'yes','y','Y','YES','Yes'}
no = {'no','n','N','NO','No'}

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

def decryptor(message):
#    permited = set(string.ascii_lowercase + ' ')
#    permited.remove("q")
#    permited.remove("u")
#    
#    key = input("Key:")
#    if set(key) <= permited:
#
#        matrix = {
#            'a1':key[0],
#            'b1':key[1],
#            'c1':key[2],
#            'd1':key[3],
#            'e1':key[4],
#            'a2':key[5],
#            'b2':key[6],
#            'c2':key[7],
#            'd2':key[8],
#            'e2':key[9],
#            'a3':key[10],
#            'b3':key[11],
#            'c3':key[12],
#            'd3':key[13],
#            'e3':key[14],
#            'a4':key[15],
#            'b4':key[16],
#            'c4':key[17],
#            'd4':key[18],
#            'e4':key[19],
#            'a5':key[20],
#            'b5':key[21],
#            'c5':key[22],
#            'd5':key[23],
#            'e5':key[24]
#        }
    alphabet = "abcdefghijklmnoprstvwxyz "
    password = input("enter a key: ")
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
    if key == key:
        matrix = {
            'a1':key[0],
            'b1':key[1],
            'c1':key[2],
            'd1':key[3],
            'e1':key[4],
            'a2':key[5],
            'b2':key[6],
            'c2':key[7],
            'd2':key[8],
            'e2':key[9],
            'a3':key[10],
            'b3':key[11],
            'c3':key[12],
            'd3':key[13],
            'e3':key[14],
            'a4':key[15],
            'b4':key[16],
            'c4':key[17],
            'd4':key[18],
            'e4':key[19],
            'a5':key[20],
            'b5':key[21],
            'c5':key[22],
            'd5':key[23],
            'e5':key[24]
        }
        
        messlen = len(message)
        answer = ""
        finalanswer = ""
        while messlen > 1:
            x = message[0]
            y = message[1]
            a = (list(matrix.keys())[list(matrix.values()).index(x)])
            b = (list(matrix.keys())[list(matrix.values()).index(y)])
            if {a, b} <= row1 or {a, b} <= row2 or {a, b} <= row3 or {a, b} <= row4 or {a, b} <= row5:
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

                    newa = lrow1[rowloca]
                    newb = lrow1[rowlocb]
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
            elif {a, b} <= col1 or {a, b} <= col2 or {a, b} <= col3 or {a, b} <= col4 or {a, b} <= col5:
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
            else:
                if a in row1:
                    rowloca = lrow1.index(a) #row location of a
                    if b in row2:
                        rowlocb = lrow2.index(b) #row location of b
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb]) 
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
                    answer = (matrix[newa]) 
                    answer = answer + (matrix[newb])
                
            finalanswer = finalanswer + answer        
            message = message[2:]
            messlen = len(message)
        print("Message: ", finalanswer)

def encryptor(message):
    alphabet = "abcdefghijklmnoprstvwxyz "
    password = input("enter a key: ")
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

#    letters = list(string.ascii_lowercase)
#    random.shuffle(letters)
#    nothing = ''
#    key = nothing.join(letters[:26])
#    key = key.replace("u", "")
#    key = key.replace("q", " ")
    print ("key: ["+ key + "]")

    matrix = {
        'a1':key[0],
        'b1':key[1],
        'c1':key[2],
        'd1':key[3],
        'e1':key[4],
        'a2':key[5],
        'b2':key[6],
        'c2':key[7],
        'd2':key[8],
        'e2':key[9],
        'a3':key[10],
        'b3':key[11],
        'c3':key[12],
        'd3':key[13],
        'e3':key[14],
        'a4':key[15],
        'b4':key[16],
        'c4':key[17],
        'd4':key[18],
        'e4':key[19],
        'a5':key[20],
        'b5':key[21],
        'c5':key[22],
        'd5':key[23],
        'e5':key[24]
    }

    messlen = len(message)
    answer = ""
    finalanswer = ""
    while messlen > 1:
        x = message[0]
        y = message[1]
        a = (list(matrix.keys())[list(matrix.values()).index(x)])
        b = (list(matrix.keys())[list(matrix.values()).index(y)])
        sub = (list(matrix.keys())[list(matrix.values()).index("x")])
        if a == b:
            b = sub
        if {a, b} <= row1 or {a, b} <= row2 or {a, b} <= row3 or {a, b} <= row4 or {a, b} <= row5:
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
                    
        elif {a, b} <= col1 or {a, b} <= col2 or {a, b} <= col3 or {a, b} <= col4 or {a, b} <= col5:
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
                    
        else:    
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb]) 
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
                answer = (matrix[newa]) 
                answer = answer + (matrix[newb])
                
        finalanswer = finalanswer + answer
        
        message = message[2:]
        messlen = len(message)

    print ("Encrypted message: [" + finalanswer + "]")


def tryagain():
    
    again = input("Try again?(y,n):  ")
    
    if again in yes:
        repeat()
    elif again in no:
        sys.exit()
    else:
        print ("Invalid choice")
        tryagain()
        
def repeat():
    global choice
    choice = input("encrypt(1) or decrypt(2):")
    if choice == "1":
        encrypt()
    elif choice == "2":
        decrypt()
    else:
        print ("Invalid choice")
        repeat()

def encrypt():

    message = input("Message to encrypt:")

    length = len(message)%2

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
        print ("Invalid characters")
        
    tryagain()
    
def decrypt():
    message = input("Message to decrypt:")

    length = len(message)%2

    if length != 0:
        print ("Invalid length")
    elif "q" in message:
        print ("Invalid characters")
    elif "u" in message:
        print ("Invalid characters")
    elif set(message) <= allowed:
        decryptor(message)
    else:
        print ("Invalid characters")
       
    tryagain()

if choice == "1":
    encrypt()
elif choice == "2":
    decrypt()
else:
    print ("Invalid choice")
    repeat()
    

