import random
import string

letters = list(string.ascii_lowercase)
random.shuffle(letters)
nothing = ""
x = nothing.join(letters[:26])
x = x.replace("u", "")
x = x.replace("q", "")
print (x)

message = input("Message to encrypt:  ")

length = len(message)%2

if length != 0:
    fixed = message + "x"
else:
    fixed = message

print (fixed)
