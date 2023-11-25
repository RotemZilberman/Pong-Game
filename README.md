# Pong Game in Java

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [How to Play](#how-to-play)
- [Code Structure](#code-structure)

## Introduction
This is a simple implementation of the classic Pong game in Java. The game features two paddles, a ball, and a scoring system. It's designed to run in a console or terminal environment, providing a nostalgic experience of the original Pong game.

![image](https://github.com/RotemZilberman/Pong-Game/assets/112009232/35afaa43-aa4a-46f5-9450-62d6acb80422)


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
   ```
   Alternatively, download the ZIP file and extract it.
   
3. Navigate to the project directory:
   ```bash
   cd pong-java
4. Compile the code:
   ```bash
   ant compile
5. Run the game:
   ```bash
   ant run
6. Clean Up:
   ```bash
   ant clean
   
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
