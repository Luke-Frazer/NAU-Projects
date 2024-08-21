# Author: Luke Frazer (lef92@nau.edu)
# Date: 16 Nov 2020
def main():
    select_field('Apple, CheESE, Bannana, meat', 3)
    find_vowel_indexes('Holy Guacamole Mr White!')
    first_factor(4357)
    is_prime(4357)
    romanize(63)


# Function 1: Select a field
#
# Write a function called select_field() that takes in two parameters.  The
# first parameter should be a string of comma separated fields.  The second
# parameter should be a number designating which field to select.  The first
# field should be designated by the number 0 (just like indexing).
#
# The function should return the designated field from the string with any
# leading and/or trailing whitespace removed.
#
# EX: select_field('AL, AK, AZ, AR, CA, CO', 2) --> "AZ"
#
# If a field index is provided which designates a non-existent field of the
# string (e.g. it's too big), the function should return None.  Use a
# try-except structure to make this happen.
#
# EX: select_field('AL, AK, AZ, AR, CA, CO', 750) --> None


def select_field(mylist, field):
    mylist = mylist.split(',')
    try:
        item = mylist[field]
    except (ValueError, IndexError):
        return
    return item.strip()


# Function 2: Find all vowel indices
#
# Write a function called find_vowel_indexes() that takes in a string and
# returns a list containing the indexes of all the vowels in the string.  The
# letter 'y' should count as a vowel unless it is the first character of the
# word.
#
# The input string may be in upper, lower, or mixed case.
#
# Don't forget that you can write helper functions
#
# EX: find_vowel_indexes("hello") --> [1, 4]
#     find_vowel_indexes("yellow") --> [1, 4]
#     find_vowel_indexes("the sky is falling") --> [2, 6, 8, 12, 15]


def find_vowel_indexes(string):
    string = string.lower()
    vowel_list = []
    for i in range(len(string)):
        if string[i] in 'aeiou':
            vowel_list.append(i)
        elif string[i] == 'y':
            if i == 0:
                pass
            else:
                vowel_list.append(i)
        else:
            pass
    return vowel_list


# Function 3: Finding the First Factor
#
# Write a function called first_factor() which takes in a number and returns
# the first number larger than one which evenly divides that number.
#
# EX: first_factor(55) --> 5
#     first_factor(19) --> 19
#     first_factor(6)  --> 2


def first_factor(number):
    for num in range(1, number + 1):
        if (number % num) == 0 and num > 1:
            return num
        else:
            pass


# Function 4: Detecting Primes
#
# Write a function called is_prime() that takes in an integer and returns True
# if it is prime and False otherwise.
#
# HINT: Remind yourself of what it means for a number to be prime by looking
#       it up
#
# HINT: *DON'T* look up how to decide if a number is prime on the
#       internet, you will almost certainly find a bunch of really complicated
#       code that is overkill for this problem
#
# HINT: You have already implemented another function that you could call to
#       make this problem easier (assuming you are doing these in order)


def is_prime(integer):
    return first_factor(integer) == integer


# Function 5: Roman Numerals
#
# Write a function called romanize() that takes in one number as an argument.
# The number is guaranteed to be in the range [1, 100].  The function should
# return a string containing the Roman Numeral representation of the number.
#
# SUGGESTION: If you don't know/remember how Roman Numerals work, Wikipedia has
#             a good set of explanations
#
# FOOD FOR THOUGHT: It is possible to create a solution to this problem that
#                   uses no loops!  That solution is also not one that is easy
#                   to come up with (in my opinion)


def romanize(number):
    integers = [100, 90, 50, 40, 10, 9, 5, 4, 1]
    numerals = ['C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I']
    roman_numeral = ''
    index = 0
    while number > 0:
        current_num = number // integers[index]
        for i in range(current_num):
            roman_numeral = roman_numeral + numerals[index]
            number = number - integers[index]
        index += 1
    return roman_numeral


# EXTRA CREDIT! EXTRA CREDIT! EXTRA CREDIT! EXTRA CREDIT! EXTRA CREDIT!
#
# Matching Parentheses
#
# Define a function called all_parens_matched() that takes in a string and
# returns True if the string contains properly matched parenthesis pairs.
#
# Ex: all_parens_matched("(this (string) is) (fine)") --> True
#     all_parens_matched(")uh (oh) (doomed from (the start))") --> False
#     all_parens_matched("(everything (is (fine until the end)))(") --> False
#
# HINT: Order matters! You can't simply count the number of open parentheses
#       and compare to the number of close parentheses
#
# HINT: This problem is hard!

if __name__ == '__main__':
    main()
