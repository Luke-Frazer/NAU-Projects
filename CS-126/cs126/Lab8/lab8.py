# Authors: Luke Frazer and Trent Gayer
# Date: 13 Nov 2020
import json
from random import shuffle


def main():
    # The main menu for the user to choose what to do.
    print('\n\tMAIN MENU\n')
    print('(1)\tPLAY GAME\n')
    print('(2)\tVIEW CREDITS\n')
    print('(3)\tQUIT GAME\n')
    player_choice = input('CHOOSE AN OPTION ABOVE: ')
    # Check to make sure the user's choice is valid and retry if not.
    while player_choice not in ['1', '2', '3']:
        try:
            player_choice = input("choose a numbered option please: ")
        except ValueError:
            pass
    if player_choice == '1':
        play_game()
    elif player_choice == '2':
        view_credits()
    elif player_choice == '3':
        quit_game()


# The main chunk of the active code that runs to game show and retrieves the
# questions from the json file in order to print it back to the user.
def play_game():
    with open('questions.json', 'r') as file:
        questions = json.load(file)
    print("Welcome to our CS126 Trivia Game")
    print("Win MILLIONS!!\n")
    shuffle(questions)  # randomizes the json file's questions every run
    score = 0  # resets the score every run
    for question in questions:
        # Creates a variable for a list of numbers that are all of the possible
        # answers the user can input.
        values = range(1, len(question["answers"]) + 1)
        final_values = value(values)
        print(question["prompt"])
        index = 0
        while index < len(question["answers"]):
            choice = question["answers"][index]
            print(f"{choice}")
            index += 1
        answer = input("Choose an answer 1−4: ")
        # Check to make sure the input was valid.
        # while answer not in ['1', '2', '3', '4']:
        while answer not in final_values:
            try:
                answer = input("choose a numbered option please: ")
            except ValueError:
                pass
        if answer == question["correct"]:
            print("Goodjob! *Confetti falls in the background*\n")
            score += 1  # increase the score on each correct answer.
            print(f"Your current score is: {score}\n")  # keep track of score.
        else:
            print("Not correct. *The audience boos*\n")
            print(f"Your current score is: {score}\n")
    print(f"Your final score was: {score}")  # final score for the whole game.

# Creates a list of values that is the exact length of the number of questions.
def value(numbers):
    actual_values = []
    for number in numbers:
        actual_values.append(str(number))
    return actual_values

# Small function to just read out the creators of the game.
def view_credits():
    print('Authors: Luke Frazer and Trent Gayer\n')


# Small function to quit out of the game.
def quit_game():
    print('Thank you for playing, have a great day!\n')


if __name__ == "__main__":
    main()
