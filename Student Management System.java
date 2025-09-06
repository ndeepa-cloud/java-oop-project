import tkinter as tk
from tkinter import messagebox
import json
import random
import os

class QuizApp:
    def __init__(self, master):
        self.master = master
        self.master.title("Python Quiz App")
        self.score = 0
        self.q_index = 0
        self.questions = self.load_questions()
        random.shuffle(self.questions)
        self.current_q = None

        self.label = tk.Label(master, text="Welcome to the Quiz!", font=("Arial", 16))
        self.label.pack(pady=20)

        self.var = tk.StringVar()
        self.options = []
        for i in range(4):
            rb = tk.Radiobutton(master, text="", variable=self.var, value=str(i), font=("Arial", 12))
            rb.pack(anchor="w")
            self.options.append(rb)

        self.next_btn = tk.Button(master, text="Next", command=self.next_question)
        self.next_btn.pack(pady=10)

        self.show_question()

    def load_questions(self):
        with open("questions.json", "r") as f:
            data = json.load(f)
        return data["questions"]

    def show_question(self):
        if self.q_index < len(self.questions):
            self.current_q = self.questions[self.q_index]
            self.label.config(text=self.current_q["question"])
            self.var.set(None)
            for i, option in enumerate(self.current_q["options"]):
                self.options[i].config(text=option, value=option)
        else:
            self.finish_quiz()

    def next_question(self):
        if self.var.get() == self.current_q["answer"]:
            self.score += 1
        self.q_index += 1
        self.show_question()

    def finish_quiz(self):
        messagebox.showinfo("Quiz Finished", f"Your Score: {self.score}/{len(self.questions)}")
        self.save_score()
        self.master.quit()

    def save_score(self):
        with open("scores.txt", "a") as f:
            f.write(f"Score: {self.score}/{len(self.questions)}\n")

if __name__ == "__main__":
    root = tk.Tk()
    app = QuizApp(root)
    root.mainloop()
