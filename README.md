# CSCI 5801 GRP 19 
Example Case for PPALMS System Usage 
An instructor needs to generate many quizzes to allow their students to practice computer science. This PPALMS system will make it easy to generate hundreds of quizzes. 
Source Code:
The PPALMS system works by using real examples of code to generate problems. This also means the variety of problems generated depends on the amount of code the system draws from. In order to create healthy quizzes, it is important to keep a vast database of code within app\src\main\resources\source_code before quiz generation. 
Specification File:
Using this software, the instructor can generate any quiz. In order to expedite user input, the exact specifications are put inside a special comma separated text file. 
The first line of the specs doc is a header. It contains the number of questions per quiz, the number of quizzes to make, and the title of the quiz. Each subsequent line will describe one question. 

`	This instructor wants to make a 10-question quiz called “September Midterm”. They will give a unique quiz to each of their 50 students to prevent cheating.  Because there are 10 questions in a quiz, this instructor needs 10 lines after the header. All questions are in the python language. The first 5 questions are multiple choice, the next 5 are ordering questions. 
Using the System:
The instructor boots the system up by opening their favorite terminal and cloning the code from github. Then proceed to the directory that contains the gradlew executable. 
To verify everything is working, run “gradlew clear” to remove previous builds. Run “gradlew build” to generate a new set of files. Run “gradlew test” to ensure every component is acting appropriately. Use “gradlew run”,and wait as the system proceeds through the initial startup. Then enter the path to the specification file. The system can draw on previously generated problems, instead of creating new ones. Once each quiz is complete, it prints its title, and the series of generated problems assigned to it to the terminal, so the professor can capture them and offer them to their students. After the last quiz is generated, the system signs off and shuts down.
Future Features:
Although an export file is not supplied currently, as the system is still new, the quizzes are exported to the terminal, so the instructors can redirect the stream to a file. The system is extremely close to having an exported document option, so this inconvenience should not last long. The instructor may soon be able to alter the config value for the rate of reuse to 100%, if enough generated problems exist to avoid the problems’ overuse. More problem types are expected to come, to further expand the options available for learning. 
