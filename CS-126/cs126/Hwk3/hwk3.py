# !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!!
# You should not use the print() or input() functions anywhere in this file!
# !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!! !!WARNING!!


def main():
    same_first_digit(123, 11352, 1858)
    same_first_digit(23, 11352, 858)
    reverse('hello')
    is_palindrome('123jdj32')
    is_palindrome('Ha-=n  n ; [ah')
    str_to_ascii('abc123;[]')
    get_piece_value('bishop')
    get_piece_value('Bishop')
    get_piece_value('queEn')
    get_piece_value('Rok')
    format_date(20190209)


# Function 1: Same First Digit
#
# Define a function called same_first_digit() that takes in three numbers and
# returns True if they all have the same first digit and False otherwise.
#
# Hint: Mold data according to the way you are going to use it: it's a shame
#       you can't index into a number...


def same_first_digit(first, second, third):
    if str(first)[0] == str(second)[0] and str(second)[0] == str(third)[0]:
        return True
    else:
        return False


# Function 2: String Reversal
#
# Write a function called reverse() that takes in a string and gives back the
# the string with its characters in inverted order.
#
# Don't be a tool and just call the built-in function reversed()


def reverse(string):
    stringLength = len(string)
    reversedString = string[stringLength::-1]
    return reversedString


# Function 3: Palindrome Detection
#
# Write a function called is_palindrome() which takes in a single string
# parameter.  The function should return True if the string is a palindrome and
# False otherwise.  A palindrome is a string which can be read in the same way
# both forward and backward, "mom" for example.  The case of the string should
# not affect correctly detecting a palindrome; neither should any spaces,
# commas, or apostrophes in the string.
#
# HINT: If only you could get rid of all the characters you don't care about
# some how.
#
# HINT: If only there was some way to obtain a backwards version of a string...


def is_palindrome(string):
    newString = ''
    for char in string:
        if ((ord(char) >= 97 and ord(char) <= 122)
                or (ord(char) >= 65 and ord(char) <= 90)
                or (ord(char) >= 48 and ord(char) <= 57)):
            newString += char

    return newString.lower() == reverse(newString.lower())


# Function 4: String to ASCII Codes
#
# Write a function called str_to_ascii() that takes in a string and returns a
# list of integers where each integer is the ASCII code for the corresponding
# character in the string at that position.
#
# EX: str_to_ascii('abc') --> [97, 98, 99]
#
# HINT: If you dont know what ASCII is, Google "ASCII table"
#
# HINT: There is a built in function that can do the char --> ASCII code
#       conversion for you; you just have to find it.


def str_to_ascii(string):
    wList = []
    for i in range(len(string)):
        wList.append(ord(string[i]))
    return wList


# Function 5: Get Piece Value
#
# Write a function called get_piece_value() which takes in the name of a chess
# piece as a string and returns a numeric value corresponding to the piece
# after this scheme:
#
# | piece  | value |
# |--------+-------|
# | pawn   |     1 |
# | bishop |     3 |
# | knight |     3 |
# | rook   |     5 |
# | queen  |     9 |
#
# If a string is given as input which is not the name of a valid piece, your
# function should return None.  Make sure this function works for strings with
# any combination of letter case as long as they are spelled right.
#
# To get the intended practice for this problem, don't use *any* if statements


def get_piece_value(cPiece):
    chess = {'pawn': 1, 'bishop': 3, 'knight': 3, 'rook': 5, 'queen': 9}
    return chess.get(cPiece.lower())


# Function 6: Formatting Dates
#
# Write a function called format_date() which takes in a single parameter which
# is a string of the format yyyymmdd (like 20190209) and returns a string of
# the format "February 9th, 2019"
#
# Hint: One part of the date string is really easy, and one part has a
#       surprising number of edge cases


def format_date(date):
    newDate = str(date)
    finalDate = ''
    year = int(newDate[0:4])
    month = int(newDate[4:6])
    day = newDate[6:8]
    months = {
        1: 'January',
        2: 'February',
        3: 'March',
        4: 'April',
        5: 'May',
        6: 'June',
        7: 'July',
        8: 'August',
        9: 'September',
        10: 'October',
        11: 'November',
        12: 'December'
    }
    if ((day[1] == '3' and day != '13') or (day == '3')):
        day = int(day)
        day = str(day)
        finalDay = str(day) + 'rd,'
    elif ((day[1] == '2' and day != '12') or (day == '2')):
        day = int(day)
        day = str(day)
        finalDay = str(day) + 'nd,'
    elif ((day[1] == '1' and day != '11') or (day == '1')):
        day = int(day)
        day = str(day)
        finalDay = str(day) + 'st,'
    else:
        day = int(day)
        day = str(day)
        finalDay = str(day) + 'th,'
    finalDate += months[month] + ' ' + finalDay + ' ' + str(year)
    return finalDate


if __name__ == "__main__":
    main()
