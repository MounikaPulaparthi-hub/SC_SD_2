# SC_SD_2#  Number Guessing Game

## 📖 Overview

Number Guessing Game is an interactive Java Swing-based desktop application where players attempt to guess a randomly generated number within a limited number of attempts.

The game offers multiple difficulty levels, a scoring system, lives tracking, progress monitoring, and real-time hints to create an engaging gaming experience. This project demonstrates Java GUI development, event handling, random number generation, and game logic implementation.

---

##  Features

- Interactive Graphical User Interface (GUI)
-  Random Number Generation
-  Easy, Medium, and Hard Difficulty Levels
-  Lives System
-  Score Tracking
-  High Score Tracking
-  Progress Bar
-  Too High / 🔻 Too Low Hints
-  Winning Pop-up Messages
-  Game Over Screen
-  New Game Option
-  Real-Time User Feedback

---

## 🛠️ Technologies Used

- Java
- Java Swing
- Event Handling
- Random Class
- Object-Oriented Programming (OOP)

---

## 🎲 Game Rules

### Easy Mode
- Number Range: 1 - 50
- Lives: 10

### Medium Mode
- Number Range: 1 - 100
- Lives: 7

### Hard Mode
- Number Range: 1 - 200
- Lives: 5

### Scoring System

- Correct Guess = Remaining Lives × 10
- Score accumulates throughout gameplay
- Highest score is stored during the session

---

## 🧠 Game Logic

1. User selects a difficulty level.
2. System generates a random number.
3. User enters a guess.
4. Program compares the guess with the generated number.
5. If incorrect:
   - Displays hint (Too High / Too Low)
   - Reduces lives
6. If correct:
   - Awards score
   - Displays winning message
   - Starts a new round
7. If lives reach zero:
   - Game Over message is displayed
   - New game starts automatically

---

## 📂 Project Structure

```text
Number-Guessing-Game-Java
│
├── NumberGuessingGame.java
├── README.md
└── screenshots
```

---

##  How to Run

### Compile

```bash
javac NumberGuessingGame.java
```

### Run

```bash
java NumberGuessingGame
```

---

##  How to Play

1. Launch the application.
2. Select a difficulty level.
3. Click "New Game".
4. Enter your guess.
5. Click "Guess".
6. Follow the hints provided.
7. Try to guess the correct number before losing all lives.
8. Earn points and beat your high score.

---

## 📸 Screenshots

Add screenshots of:

- Main Game Interface
- Easy Mode Gameplay
- Winning Screen
- Game Over Screen
- Score and Lives System

---

## Learning Outcomes

This project helped in understanding:

- Java Swing GUI Design
- Event Handling
- Random Number Generation
- Game Development Fundamentals
- User Interaction Design
- Score Management
- Problem Solving Skills
- Object-Oriented Programming

---

## 💡 Key Concepts Demonstrated

- GUI Development
- Conditional Statements
- Loops
- Random Class Usage
- User Input Validation
- Exception Handling
- Score Calculation
- Interactive Game Logic

---

##  Future Enhancements

- ⏱️ Timer-Based Challenges
- 🎵 Sound Effects
- 🌙 Dark and Light Themes
- 🏅 Achievement System
- 💾 Save High Scores
- 🌍 Multiplayer Mode
- 📱 Mobile-Friendly Version
- 🎨 Advanced Animations

---

## 🌟 Project Highlights

- Attractive Black Theme Interface
- Multiple Difficulty Levels
- Dynamic Scoring System
- User-Friendly Gameplay
- Beginner-Friendly Yet Engaging
- Internship-Level Java Project

---

## 👩‍💻 Author

Mounika Pulaparthi

B.Tech Computer Science Engineering Student

Passionate about Java Development, Data Structures & Algorithms, Problem Solving, and Software Engineering.

---

## ⭐ Acknowledgements

This project was developed as part of software development practice and internship work to strengthen Java programming, GUI development, and game design skills.
A Java Swing based number guessing game with difficulty levels, score tracking, lives system and interactive GUI.
