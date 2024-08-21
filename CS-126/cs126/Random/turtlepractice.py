import turtle

baobab = turtle.Turtle()
baobab.shape("turtle")

# Color changes and the starting location changes
def draw_circle(color, loc_x, loc_y, circle_size):
    baobab.fillcolor(color)
    baobab.penup()
    baobab.goto(loc_x, loc_y)
    baobab.pendown()
    baobab.begin_fill()
    baobab.circle(circle_size)
    baobab.end_fill()

draw_circle("blue", 50, 50, 100)
draw_circle("red", 50, -50, 100)
draw_circle("green", -50, 50, 100)
draw_circle("yellow", -50, -50, 100)
draw_circle("white", 0, 0, 100)

turtle.Screen().exitonclick()

self.window = turtle.Screen()
self.window.screensize(sizex, sizey)
self.window.setup(width=1.0, height=1.0, startx=None, starty=None)
