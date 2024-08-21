# Authors: Luke Frazer and Sarah Nolt-Caraway
import turtle


def main():
    # This is the turtle object
    t = turtle.Turtle()

    # Turtle module functions to set the screensize,
    # background color, make drawing faster, and turtle color.
    turtle.screensize(500, 500)
    turtle.bgcolor('black')
    turtle.speed(0)
    turtle.tracer(1, 0)
    t.color('white')

    # Open the data file and run a loop that checks each line
    # one at a time and converts the x coordinate, y coordinate,
    # and magnitude values to the split values of each line.
    # Then, the turtle will move to the location of each line using
    # the accurately converted coordinates, and would draw a star using
    # an accurately converted magnitude with proper size limits.
    with open('stars.txt', 'r') as stars_file:
        lines = stars_file
        for line in lines:
            list = line.split()
            x_coor = float(list[0])
            y_coor = float(list[1])
            magnitude = float(list[4])
            mag = new_mag(magnitude)
            if mag >= 10:
                mag = 10
            elif mag <= 1:
                mag = 1
            else:
                mag = mag
            go_to(t, convert(x_coor), convert(y_coor))
            t.begin_fill()
            t.fd(mag)
            t.right(90)
            t.fd(mag)
            t.right(90)
            t.fd(mag)
            t.right(90)
            t.fd(mag)
            t.right(90)
            t.end_fill()

    # Causes the drawing area to stay until you click on it
    # This should be the absolute LAST thing that you call
    # in your program after all of the drawing is over.
    turtle.exitonclick()


# Moves the turtle to a new point without drawing anything.
def go_to(t, x_pos, y_pos):
    t.penup()
    t.goto(x_pos, y_pos)
    t.pendown()


# Converts any coordinate to the proper turtle coordinate system.
def convert(coor):
    return coor * 250


# Converts the original magnitude to the proper turtle value.
def new_mag(origin):
    return round(10 / (origin + 2))


if __name__ == "__main__":
    main()
