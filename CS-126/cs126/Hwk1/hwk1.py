# This is the code for Homework Assignment 1 for CS126
# Author: Luke E Frazer
# Date: 9 Sept, 2020
# Questions 1.2, 1.3, 1.1, and 1.4 from page 38 of Python: Programming in
# Context


import turtle
screen = turtle.Screen()
screen.setup(width=1550, height=850, startx=1300, starty=700)


def main():
    me = turtle.Turtle()
    me.speed(10)
    set_pos(me, -75, -400)
    draw_star(me, 400)
    set_pos(me, -600, -100)
    draw_custom_star(me, 50, 13)
    set_pos(me, 0, 300)
    draw_flower(me, 100, 20, 4)
    set_pos(me, 200, 0)
    draw_custom_line(me, 7, 0, 100, 170, 300, -95, 200, 90, 200)
    turtle.Screen().exitonclick()


# Creates a star shape with 5 corners and any specified length
def draw_star(turtle, sideLength):
    turtle.setheading(72)
    for x in range(2): 
        turtle.forward(sideLength)
        turtle.right(144)
        turtle.forward(sideLength)
        turtle.right(144)
    turtle.forward(sideLength)


# Small custom command I made to move the turtle to any new starting position to draw a new shape
def set_pos(turtle, x_pos, y_pos):
    turtle.penup()
    turtle.goto(x_pos, y_pos)
    turtle.pendown()


# Custom star shape with any side length specified and any number of odd sides
def draw_custom_star(turtle, sideLength, sides):
    turtle.setheading(360/sides)
    for x in range(sides//2):
	    turtle.forward(sideLength)
	    turtle.right(180-(360/(sides*2)))
	    turtle.forward(sideLength)
	    turtle.right(180-(360/(sides*2)))
    turtle.forward(sideLength)


# Creates a custom flower shape with any side lenth, number of shapes in the star, and even a custom shape number to make more then just squares (just for fun)
def draw_flower(turtle, sideLength, numSides, sidesOfShape):
	turtle.setheading(0)
	for i in range(numSides):
		draw_square(turtle, sideLength, sidesOfShape)
		turtle.left(360/numSides)


# Square function from previous work with a modification to create a shape of any number of sides
def draw_square(turtle, sideLength, sides):
    for i in range(sides):
        turtle.forward(sideLength)
        turtle.right(360/sides)


# Etch a Sketch with the option to repeat the patern any number of times to create cool shapes
def draw_custom_line(turtle, num_repeat, angle1, dis1, angle2, dis2, angle3, dis3, angle4, dis4):
	for x in range(num_repeat):
		turtle.setheading(angle1)
		turtle.forward(dis1)
		turtle.setheading(angle2)
		turtle.forward(dis2)
		turtle.setheading(angle3)
		turtle.forward(dis3)
		turtle.setheading(angle4)
		turtle.forward(dis4)


main()
