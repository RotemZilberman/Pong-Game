# Pong Game in Java

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [How to Play](#how-to-play)
- [Code Structure](#code-structure)
- [Contributing](#contributing)
- [License](#license)

## Introduction
This is a simple implementation of the classic Pong game in Java. The game features two paddles, a ball, and a scoring system. It's designed to run in a console or terminal environment, providing a nostalgic experience of the original Pong game.

![Pong Screenshot](screenshots/pong_screenshot.png)

## Features
- Two-player gameplay
- Simple console-based graphics
- Scoring system
- Ball bouncing and paddle collision mechanics

## Prerequisites
Make sure you have the following installed before running the game:
- Java Development Kit (JDK) version 8 or higher
- Git (optional, for cloning the repository)

## Installation
1. Clone the repository to your local machine using the following command:
   ```bash
   git clone https://github.com/your-username/pong-java.git
   Alternatively, download the ZIP file and extract it.
2. Navigate to the project directory:
   ```bash
   cd pong-java
3. Compile the Java source code:
   ```bash
   javac PongGame.java
4. Run the game:
   ```bash
   java PongGame
   
## How to Play
- Control the paddle using the 'W' and 'S' keys.
- The game starts with a single life and progresses through levels.
- The ball bounces off the paddle and walls.
- Earn points by hitting the ball with the paddle.
- Lose a life when the ball passes the paddle.
- The game ends when you run out of lives.

## Code Structure
The code is organized into the following files:

- PongGame.java: Main class that contains the game logic.
- Paddle.java: Class representing the paddle.
- Ball.java: Class representing the ball.
- GameUtils.java: Utility class for console input/output.
