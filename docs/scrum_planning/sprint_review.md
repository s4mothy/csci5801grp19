# Sprint Review #

## Work Done ##

An implementation was created for generating multiple choice problems, as well as fill-in-the-blank problems. The new problem types were then integrated into the system. Adding a feature missing in the last release, quizzes are now exported to a txt file, with better formatting for readability.

## Goal Review ##

While the new types can generate problems for most source code supplied, there are scenarios where undesired behavior can occur, depending on how the source code is written. There is intent to add better handling of source code in future, but in order to verify that the behavior of a line matches expectations, either a lot more work to control the generation of problems is needed from the instructor, or the code will need to be run, which requires a certain expected risk if the instructor utilizes unverified source code. Overall, for each type of problem, a discussion is needed to clarify the best direction moving forward.

## Backlog Changes ##

Items 1, 2, and 5 are removed, as they are completed. Item 3 has returned to the backlog, with the following items added.

- Item 10: Improved Mutations for Multiple Choice Problems
- Item 11: Customizable Comment Handling for Fill-In-The-Blank Problems
- Item 12: Problem Rework for Consistent Implementations
- Item 13: Extending Language Tables and Handling Within Problem Classes to Additional Languages
- Item 14: Integer Recognition for Problems
- Item 15: Vertical Bar Not Handled Correctly in Multiple Choice Generation
