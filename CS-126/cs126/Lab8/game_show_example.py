questions = [
    {
        "prompt": "Who played the first Batman?",
        "answers": [
            "George Clooney",
            "Adam West",
            "Louis G Wilson",
            "Christian Bale"
        ],
        "correct": "3"
    },
    {
        "prompt": "What’s the answer to life, the universe and everything?",
        "answers": [
            "Cheese",
            "42",
            "Tacos",
            "Baseball"
        ],
        "correct": "2"
    }
]
print("Welcoem to our CS126 Trivia Game")
print ("Win MILLIONS!!\n")
for question in questions :
    print(question["prompt"])
    index = 0
    while index < len(question["answers"]) :
        choice = question["answers"][index]
        print(f"{index + 1}. {choice}")
        index += 1
    answer = input("Choose an answer 1−4: ")
    if answer == question["correct"]:
        print("Goodjob! *Confettifalls in the background*\n")
    else:
        print("Not correct. *The audience boos*\n")
