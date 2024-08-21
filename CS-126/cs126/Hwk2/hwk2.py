from math import sqrt
# I have provided a test file for you to run to ensure that your functions
# are, er, functioning properly.  You can run it by issuing the command
# 'pytest' at in your shell when in directory containing this file and the test
# file.  If pytest isn't installed, you can install it with the this command:
#     sudo pip3 install pytest

# By the way, you can delete these instructions once you don't need them any
# more if you feel like they are getting in the way and want to tidy up your
# file.  If you find you need them again, you can always redownload the
# original files and look at them, just be careful not to accidentally
# overwrite the file you did all your work in with a fresh, empty copy!


def main():
    pounds_to_kilos(1)
    kilos_to_pounds(1)
    fahrenheit_to_celsius(0)
    celsius_to_fahrenheit(0)
    hms_to_seconds(60, 30, 10)
    distance_between_points(1, 5, 4, 8)
    distance_from_origin(5, 10)
    score_to_grade(68)
    convert(20, 'lb')
    convert(30, 'kg')
    convert(60, 'f')
    convert(200, 'c')
    sdbtp(14, 50, 63, 31, 7, 43)


##############################################################################
# Function 1: Pounds to kilos                                                #
##############################################################################

# Define a function called "pounds_to_kilos" that accepts a single parameter
# which is expected to be a number of pounds and returns the equivalent number
# of kilograms.

# Note, it is *not* cheating to look up the formula for converting pounds to
# kilos, the challenge here is simply implementing a well-known mathematical
# formula as a function.  The same goes for the functions below.

# Once you've finished this function, run the tests!  In fact, I recommend
# that you run the tests after finishing every function so that you don't end
# up with a long list of errors to fix at the very end.


def pounds_to_kilos(pounds):
    final = pounds / 2.20462
    return final


##############################################################################
# Function 2: Kilos to pounds                                                #
##############################################################################

# Basically the same as Function 1, but the other way around.  Name the
# function "kilos_to_pounds".


def kilos_to_pounds(kilos):
    final = kilos * 2.20462
    return final


##############################################################################
# Function 3: Fahrenheit to celsius                                          #
##############################################################################

# Exactly what it sounds like.  Call it "fahrenheit_to_celsius".


def fahrenheit_to_celsius(far):
    final = (far - 32) / (9 / 5)
    return final


##############################################################################
# Function 4: Celsius to Fahrenheit                                          #
##############################################################################

# I think you know what to do by now ;)


def celsius_to_fahrenheit(cel):
    final = (cel * (9 / 5)) + 32
    return final


##############################################################################
# Function 5: Hours, minutes, and seconds to seconds                         #
##############################################################################

# This function will take in three parameters: hours, minutes, and seconds.
# It should reduce these three numbers to a single number of seconds and
# return that result.  Call the function "hms_to_seconds".

# Example of what the function should do: hms_to_seconds(1, 5, 33) --> 3933


def hms_to_seconds(hr, min, sec):
    final = (hr * 3600) + (min * 60) + sec
    return final


##############################################################################
# Function 6: Distance between two points                                    #
##############################################################################

# This function will have four parameters since each point is composed of an
# "x" and a "y" component.  They will be given to the function in the order
# x1, y1, x2, y2.  Call the function "distance_between_points".

# In order to find the distance between these two points, you will need to do
# a square root operation.  Python has a built-in square root function called
# sqrt(), but it is part of the math library so it can't be accessed without
# importing it first.  To do this, put the line 'from math import sqrt' up at
# the very top of this file (without the quotes of course).


def distance_between_points(x1, y1, x2, y2):
    final = sqrt(((x2 - x1)**2) + ((y2 - y1)**2))
    return final


##############################################################################
# Function 7: Distance from the origin                                       #
##############################################################################

# This function will have only two parameters representing a single point's
# "x" and "y" components and will return that point's distance from the
# origin.  Call this function "distance_from_origin".

# CONSTRAINT: Don't use any math operators (+, -, *, etc.) or sqrt()
#             in this function!
#
# You: Wait, wha?  Nakai, how am I supposed to do math without math?
#
# Me: Because, grass-hoppah, you have already done the math; simply lift up
#     your eyes and ask yourself for the answer.


def distance_from_origin(x, y):
    final = distance_between_points(0, 0, x, y)
    return final


##############################################################################
# Function 8: Score to Grade                                                 #
##############################################################################

# Write a function called "score_to_grade" that accepts a number as it's
# parameter and gives back a string represeting the associated grade.  Use the
# familiar grading scheme: F < 60 <= D < 70 <= C < 80 <= B < 90 <= A

# "<=" is less-than-or-equal and ">=" is greater-than-or-equal


def score_to_grade(num):
    if num < 60:
        return 'F'
    elif num < 70:
        return 'D'
    elif num < 80:
        return 'C'
    elif num < 90:
        return 'B'
    elif num >= 90:
        return 'A'
    else:
        return None


##############################################################################
# Function 9: Unit converter                                                 #
##############################################################################

# This function should be called "convert" and will take in two parameters.
# The first will be a number and the second will be a string which indicates
# the unit of measurement for the first parameter.  The valid unit strings
# which could be passed to this function are: "lb", "kg", "f", and "c".

# If your function is given some other string, it should return None.

# When the function is given a number and "lb" as the unit, it should treat
# the number as pounds and convert it to kilograms.  If the string is "kg" it
# should do the opposite; likewise "f" is for Fahrenheit and "c" is for
# Celsius.

# Make sure that you DON'T REPEAT YOURSELF by duplicating code you've already
# written.  Use the lesson learned from function 7 to avoid this.


def convert(num, unit):
    if unit == 'lb':
        final = pounds_to_kilos(num)
    elif unit == 'kg':
        final = kilos_to_pounds(num)
    elif unit == 'f':
        final = fahrenheit_to_celsius(num)
    elif unit == 'c':
        final = celsius_to_fahrenheit(num)
    else:
        final = None
    return final


##############################################################################
# Function 10: Shortest distance between three points                        #
##############################################################################

# This function takes in a whopping six parameters in order to represent three
# points (x1, y1, x2, y2, x3, y3)!  We're looking for the smallest *distance*
# between any two of these points, a.k.a. the length of the shortest leg of
# the triangle formed by the three points.  Call the function "sdbtp", which is
# a terrible function name.

# Again, DON'T REPEAT YOURSELF


def sdbtp(x1, y1, x2, y2, x3, y3):
    A = distance_between_points(x1, y1, x2, y2)
    B = distance_between_points(x1, y1, x3, y3)
    C = distance_between_points(x2, y2, x3, y3)
    if A <= B and A <= C:
        return A
    elif B <= A and B <= C:
        return B
    elif C <= A and C <= B:
        return C
    else:
        return None


main()
