# Luke Frazer
# This is the code for the CS126 Final.


def main():
    is_vowel('a')
    is_vowel('b')
    is_vowel('i')
    is_vowel('E')
    index_of_first_vowel('string')
    index_of_first_vowel('index')
    index_of_first_vowel('sdf')
    index_of_first_vowel('HIII')
    pig_latinize('egg')
    pig_latinize('biscuit')
    pig_latinize('GraVy')


# Simple function that just checks if the inputed letter is in a string of all
# the vowels.
def is_vowel(letter):
    return letter.lower() in 'aeiou'


# Converts the inputted string to lowercase, then runs a for loop for the index
# locations in the range of the length of the string. If the current index
# location's letter returns true for the is_vowel function, the function will
# return the index location of that letter.
def index_of_first_vowel(string):
    string = string.lower()
    for i in range(len(string)):
        if is_vowel(string[i]):
            return i
    return


# If the first index location is a vowel, then the string will add yay to the
# end of it. Otherwise, the string will start at the vowel, then add the
# letters before the vowel to the end with ay afterwards.
def pig_latinize(string):
    if is_vowel(string[0]):
        newString = string + 'yay'
    else:
        newString = (string[index_of_first_vowel(string):] +
                     string[0:index_of_first_vowel(string)] + 'ay')
    return newString


if __name__ in '__main__':
    main()
