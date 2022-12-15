This document is a quick-run guide meant to run on a sample piece of source code to produce a simple quiz.

PPALMS Version 0.2

Required Software:
Gradle 7.3
JDK 17.0.5

Run:
1. In csci5801grp19 directory open a command line and run "./gradlew run"
	Note: You will see it initialize and then start printing out statements and prompts for the user. The first is Hello World!. It will then ask for the absolute path to source code and say executing below. Where the cursor is, type your path.
2. Once prompted to enter path for specification file, enter the absolute path to an input file (../csci5801grp19/app/src/main/resources/quiz_input/ez_quiz.txt)
3. If successful, there will be a printed message into the terminal giving the export filename and reporting the quiz write as successful.
4. To view the quiz, once again go to the resources folder in the project folder (see path in 2). And navigate to the quiz_export folder and open the filename given in the terminal.
5. This is your quiz!