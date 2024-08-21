# Here is the code for Lab 1 of CS126L
# This program draws the path of a projectiles motion launched at various angles using turtle graphics
#
# Should take into account:
#
#       launch velocity (called u)
#       launch angle (called θ or theta)
#       acceleration due to gravity (called g)
#       the current time step (called t)
#
# Authors: Luke Frazer (lef92@nau.edu) and Brock Heinz (bch285@nau.edu)
# Date Started: 4 Sept 2020

import turtle
import math
screen = turtle.Screen()
screen.setup(width=1550, height=850, startx=1300, starty=700)


def main():
    proj = turtle.Turtle()
    proj.shape("turtle")
    set_pos(proj, -300, -300)
    motion(proj, 45, 70, 9.8, 20)
    turtle.Screen().exitonclick()


def set_pos(turtle, x_pos, y_pos):
    turtle.penup()
    turtle.goto(x_pos, y_pos)
    turtle.pendown()


def find_theta(x, y):
    angle = math.degrees(math.atan(y / x))
    return angle


def motion(turtle, theta, u, g, t):
    turtle.setheading(theta)
    x_v = u * math.cos(math.radians(theta))
    y_v = u * math.sin(math.radians(theta))
    for time in range(t):

        print('current theta is ' + str(find_theta(x_v, y_v)) + ' ' +
              str(x_v) + ' ' + str(y_v))

        turtle.forward(math.sqrt(((x_v)**2) + ((y_v)**2)))
        y_v -= g
        turtle.setheading(find_theta(x_v, y_v))


main()
