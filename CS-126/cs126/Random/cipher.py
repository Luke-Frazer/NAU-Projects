from math import ceil
# Transposition Cipher:
#
# The characters in a plain message get rearranged
#
# Railfence Cipher:
#	Encryption example:
#	  01234567				  02461357
#	  starfish --railfence--> safstrih
# Evens at the front, odds at the back

def main():
    cipher_text1 = railfence("starfishy")
    print(unrailfence(cipher_text1))

def railfence(message):
    even_char = ""
    odd_char = ""
    for i in range(len(message)):
        if is_even(i):
            even_char = even_char + message[i]
        else:
            odd_char = odd_char + message[i]
    cipher = even_char + odd_char
    print(cipher)
    return cipher

#	Decryption Ex:											  eoeoeoeo
#	  01234567				0123	0123					  00112233
#	  safstrih	--split-->	safs	trih	--un-railfence--> starfish
    
def unrailfence(e_message):
    halfway_index = ceil(len(e_message) / 2)
    even_half = e_message[:halfway_index]
    odd_half = e_message[halfway_index:]
    decrypted_message = ""
    for i in range(len(odd_half)):
        decrypted_message = decrypted_message + even_half[i] + odd_half[i]
    if len(even_half) > len(odd_half):
            decrypted_message += even_half[-1]

    return decrypted_message

def is_even(n):
    return n % 2 == 0

main()
