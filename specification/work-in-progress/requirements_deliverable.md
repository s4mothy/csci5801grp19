# Use Cases #

**Use Case ID:** 001 \
**Use Case Name:** Verify Question Document \
**Summary:** The instructor initiates the system in a terminal with a valid text document containing the details they wish to be included in the new question. \
**Basic Course of Events:**

1. The instructor runs the system interface with their desired question document.
2. The system reads the document, first verifying there is a valid QUESTION_START and QUESTION_END headers.
3. The system verifies that the line after QUESTION_START begins with "TYPE: ", with a valid implemented type following it.
4. The system verifies the next line begins with "LMS: ", followed by a valid implemented LMS type the instructor wishes the question to be uploaded to.
5. The system verifies the next line begins with "LANGUAGE: ", followed by a valid implemented coding language type the instructor has written the question for.
6. The system verifies the next line begins with "SAVE: ", followed by a "Y" or "N", determining whether the instructor desires to save the question for future use.
7. The system verifies the next line begins with "MUTANT RANGE: ", followed by a valid range of lines within the blocks of code that the instructor wishes to be modified in order to form the question.
8. The system prints out a summary of the information ingested, with the block of code abbreviated for readability, and asks the instructor to verify everything is correct.
9. The system acknowledges the verification.

**Alternative Paths:** None \
**Exception Paths:** For step 2, if either header is missing, the instructor is informed. For steps 3 - 7, if the starting line denoting the use for that line is incorrect, the instructor is informed of the error. For step 3 - 5, if the type, LMS, or language entered has not been implemented, the instructor is informed that the one they entered is not available, and the instructor is informed which ones are available. For step 5, if something other than "Y" or "N" is entered, the instructor is informed that one of the two is needed instead. For step 6, if the mutant range is not possible or does not exist in the blocks of code following it, the instructor is informed of the potential range it could be and what they entered. After any of these exceptions are reached, the system will then exit.\
**Extension Points:** None \
**Trigger:** The instructor has prepared a question document they wish to be implemented by the system.\
**Assumptions:** The instructor is aware of how to run the system within bash, the general format needed to make a question document, and the types of questions, LMSs, and languages that have been implemented in the system. The instructor has the language the system is run on installed on their device.\
**Precondition:** Some amount of types, LMSs, and languages have been implemented in the system. \
**Postcondition:** The question document has been verified for generating questions, and the instructor proceed to question generation.\
**Author:** Sam Williams\
**Date:** 10/01/2022