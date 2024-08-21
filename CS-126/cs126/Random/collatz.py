# This is the code for Collatz
# Author: Luke Frazer
# Date: 17 Sept 2020


import turtle
screen = turtle.Screen()
screen.setup(width=1550, height=850, startx=1300, starty=700)
def main():
	larry = turtle.Turtle()
	larry.speed(10)
	set_pos(larry, -300, 0)
	collatz(larry, 7, 20)
	turtle.Screen().exitonclick()	

# Small tustot command I made to move the turtle to any new starting position to draw a new shape
def set_pos(turtle, x_pos, y_pos):
    turtle.penup()
    turtle.goto(x_pos, y_pos)
    turtle.pendown()

# The function for using Collatz equation to find what n is when it is even and when it is odd
# When the number is odd, it multipies it by three and adds one, then it prints the new number
# and sets the direction for the turtle in the negative direction to visually show that it is 
# odd, and goes forward the amount that n is equal to.
# When the number is even, set the heading in the positive direction and go forward the amount
# that n is equal to.
def collatz(turtle, n_init, t):
	n = n_init
	for x in range(t):
		if is_odd(n):
			turtle.setheading(-45)
			n = (3 * n) + 1
			turtle.forward(n*2)
			print(n)
		else:
			turtle.setheading(45)
			n = n / 2
			turtle.forward(n*2)
			print(n)
	return n

# Small simple function for finding if the number is odd
def is_odd(n):
	return n % 2 != 0

main()


