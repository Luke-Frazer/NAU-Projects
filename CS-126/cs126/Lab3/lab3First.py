#Would you like to:
#   (1) encrypt
#   (2) decrypt
# 1
#
#        Please enter a key: excelsior
#
#        Please enter a message to encrypt:
#        Epstein did not kill himself
#
#        Here is your encrypted message:
#        WOZZK LMNZ ABKDDLYCEDFXP IOM
#       
#        No symbols or numbers, only letters
import random
import string

letters = list(string.ascii_lowercase)
random.shuffle(letters)
nothing = ""
x = nothing.join(letters[:26])
x = x.replace("u", "")
x = x.replace("q", " ")
print (x)

row1 = x[:5]
print ("row 1 = " + row1)
row2 = x[5:10]
print ("row 2 = " + row2)
row3 = x[10:15]
print ("row 3 = " + row3)
row4 = x[15:20]
print ("row 4 = " + row4)
row5 = x[20:25]
print ("row 5 = " + row5)

column1 = row1[0] + row2[0] + row3[0] +row4[0] + row5[0]
print("column 1 is " + column1)
column2= row1[1] + row2[1] + row3[1] +row4[1] + row5[1]
print("column 2 is " + column2)
column3 = row1[2] + row2[2] + row3[2] +row4[2] + row5[2]
print("column 3 is " + column3)
column4 = row1[3] + row2[3] + row3[3] +row4[3] + row5[3]
print("column 4 is " + column4)
column5 = row1[4] + row2[4] + row3[4] +row4[4] + row5[4]
print("column 5 is " + column5)

def find_loc(letter):
    for i in range(len(x)):
        if x[i] in row1:
            print(x[i], "is in Row: 1 and column: ", row1.index(x[i]))
        elif x[i] in row2:
            print(x[i], "is in Row: 2 and column: ", row2.index(x[i]))
        elif x[i] in row3:
            print(x[i], "is in Row: 3 and column: ", row3.index(x[i]))
        elif x[i] in row4:
            print(x[i], "is in Row: 4 and column: ", row4.index(x[i]))
        elif x[i] in row5:
            print(x[i], "is in Row: 5 and column: ", row5.index(x[i]))
find_loc(x)

message = input("Message to encrypt:  ")

length = len(message)%2

if length != 0:
    fixed = message + "x"
else:
    fixed = message

print (fixed)
