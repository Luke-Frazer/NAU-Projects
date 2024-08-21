# This is the code file for Lab 2 of CS126L
# Authors: Luke Frazer (lef92@nau.edu) and Moses Osuna (meo98@nau.edu)
# Date: 11 Sept 2020


import random
import math
import turtle
screen = turtle.Screen()
screen.setup(width=1550, height=850, startx=1300, starty=700)


# The main function that runs our needle simulation
def main():
    
    needleSim(20)


# First we need to create the showMontePi function
# from 2.6.5 of Python: Coding in context.
def montePi(num):

    # Create the graph and the world coordinates by telling the turtle
    # to draw the map for us.
    wn = turtle.Screen()
    drawingT = turtle.Turtle()
    drawingT.speed(10)
    wn.setworldcoordinates(-2, -2, 2, 2)
    drawingT.up()
    drawingT.goto(-1, 0)
    drawingT.down()
    drawingT.goto(1, 0)
    drawingT.up()
    drawingT.goto(0, 1)
    drawingT.down()
    drawingT.goto(0, -1)

# in Circle will be increasing for every time that
# the distance from the center is less than or equal to one
# shown by the blue dots and red dots are for when they
# are hit further than one away from the center.
    inCircle = 0
    drawingT.up()

    for i in range(num):
        x = random.random()
        y = random.random()

        distance = math.sqrt(x**2 + y**2)

        drawingT.goto(x, y)

        if distance <= 1:
            inCircle = inCircle + 1
            drawingT.color("blue")
        else:
            drawingT.color("red")
        drawingT.dot()

# We then find pi using this equation found in the book
# by diving the nimber of times it hits within 1 by the number
# of darts times 4.
    pi = inCircle / num * 4
    wn.exitonclick()

# we decided to print out our pi value to read off as we go.
    print(float(pi))
    return(pi)


# The Simulation we created to have the needles fall between 2 lines
# and calculate pi from the number of needles that hit.
def needleSim(num_needles):

    # We once again set up the table by having the turtle
    # draw two horizontal lines at y = 0 and y = 1.
    edge = turtle.Screen()
    needle = turtle.Turtle()
    needle.speed("fastest")
    edge.setworldcoordinates(-2, -2, 2, 2)
    needle.up()
    needle.goto(-1, 0)
    needle.down()
    needle.goto(1, 0)
    needle.up()
    needle.goto(-1, 1)
    needle.down()
    needle.goto(1, 1)

    inCircle = 0
    needle.up()

    # This is our loop for calculating pi and drawing
    # the needles on the table where num_needles is the amount
    # of needles we wish to use to calculate pi.
    for i in range(num_needles):
        # We pick random x coordinates for
        # the center of our needle that are between
        # -1 and 1 to stay within the table and for y we
        # set between 0 and 1 to not overextend
        # the needles out of the limits of the table.
        # Theta is the random angle that the needles fall
        # and is between -90 and 90 degrees
        # because the needle is symetrical and will also
        # extend in the opposite direction.
        x = random.uniform(-1, 1)
        y = random.uniform(0, 1)
        theta = (random.uniform(-(.5*math.pi), (.5*math.pi)))

        # The length of the needle is .5 a unit in both directions, making
        #  the full needle 1 unit long as stated in the instructions.
        needleLength = .5

        # If the y coordinate is under the mid point between the two lines,
        # then it will first check for the angle, and depending on if the
        # angle is positive or negative, it will
        # check the front side of the needle or
        # the back end of the needle that extends towards the closest line.
        # Using 1/2 Sin(theta), we then find the y
        # length that the needle extends and
        # check to see if it it touching the line.
        # If the needle is touching, it is blue
        # and adds to the inCircle, if it is
        # not touching, it is red and does nothing to the inCircle.
        if abs(y) < .5:
            if theta < 0:
                if abs(y) + (math.sin(theta)*.5) <= 0:
                    inCircle = inCircle + 1
                    needle.color("blue")
                else:
                    needle.color("red")
            else:
                if abs(y) + (math.sin(-theta)*.5) <= 0:
                    inCircle = inCircle + 1
                    needle.color("blue")
                else:
                    needle.color("red")
        else:
            if theta < 0:
                if abs(y) + (math.sin(-theta)*.5) >= 1:
                    inCircle = inCircle + 1
                    needle.color("blue")
                else:
                    needle.color("red")
            else:
                if abs(y) + (math.sin(theta)*.5) >= 1:
                    inCircle = inCircle + 1
                    needle.color("blue")
                else:
                    needle.color("red")

        # The actual portion that tells the turtle
        # to draw the line by seting the heading to
        # 180/pi times the radian value it has to convert to degrees.
        needle.penup()
        needle.goto(x, y)
        needle.setheading((180/math.pi)*theta)
        needle.pendown()
        needle.forward(needleLength)
        needle.setheading(180 + ((180 / math.pi) * theta))
        needle.forward(needleLength * 2)

        # Print out functions we added to help us see what it is drawing
        needle.dot()
        print("The theta is ")
        print(theta)
        print("and the y coordinate is ")
        print(y)

    # Calculate pi out from the values it recieved
    pi = inCircle / num_needles * 4
    edge.exitonclick()

    # Print the pi value
    print("Pi is equal to ")
    print(float(pi))
    return(pi)


main()
