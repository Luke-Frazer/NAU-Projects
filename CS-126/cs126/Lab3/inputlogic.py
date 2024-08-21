import random
import string

allowed = set(string.ascii_lowercase + ' ')
choice = input("encrypt(1) or decrypt(2):  ")

def encrypt():
    letters = list(string.ascii_lowercase)
    random.shuffle(letters)
    nothing = ""
    key = nothing.join(letters[:26])
    key = key.replace("u", "")
    key = key.replace("q", " ")
    print (key)

    message = input("Message to encrypt:  ")

    length = len(message)%2

    if set(message) <= allowed:
        if length != 0:
            fixed = message + "x"
            print (fixed)
        else:
            fixed = message
            print (fixed)
    else:
        print ("Invalid characters")
def decrypt():
    message = input("Message to dycrypt:  ")

    length = len(message)%2

    if length != 0:
        print ("Not valid length")
    elif set(message) <= allowed:
        print ("Ready to decrypt")
    else:
        print ("Invalid characters")
    
if choice == "1":
    encrypt()
else:
    decrypt()
