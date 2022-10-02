# Software Requirements Specification for PPALMS System #

## Use Cases ##

**Use Case ID:** U001 \
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

   * * *

**Use Case ID:** U002 \
**Use Case Name:** Generate Multiple Choice Questions \
**Summary:** A series of multiple choice question files are generated based on the information stored in the verified question document. \
**Basic Course of Events:**

1. Completion of use case Verify Question Document.
2. The system reads the "TYPE: " line and verifies the type as "MULTIPLE CHOICE".
3. The system verifies that the range indicated in "MUTANT RANGE:" consists of only one line.
4. The system extracts that line and generates three mutated versions of the line using information from other areas in the block of code, while maintaining rules outlined in the desired language.
5. The three mutants and the original line are assigned "incorrect" and "correct" tags, respectively, and the original block of text and the choices are stored in a format such that the API for the LMS indicated in the document can ingest them.
6. Steps 4 - 5 are repeated a number of times outlined in the config file for the system.

**Alternative Paths:** None \
**Exception Paths:** For step 2, if type is no longer MULTIPLE CHOICE, an error is thrown and the system exits. For steps 3, if the range is more than a line, the instructor is informed that multiple choice mutations can only handle one line, and the system exits.\
**Extension Points:** None \
**Trigger:** The instructor has completed use case Verify Question Document, and indicated a multiple choice type question.\
**Assumptions:** None. \
**Precondition:** The Verify Question Document use case completed successfully, with the "TYPE: " section being flagged as "MULTIPLE CHOICE". \
**Postcondition:** Multiple sets of multiple choice question files are generated from the ingested question document, ready to be uploaded to the corresponding LMS.\
**Author:** Sam Williams\
**Date:** 10/02/2022

   * * *

**Use Case ID:** U003 \
**Use Case Name:** Generate Ordering Questions \
**Summary:**  \
**Basic Course of Events:**

1.
2.
3.
4.
5.
6.

**Alternative Paths:** \
**Exception Paths:** \
**Extension Points:** \
**Trigger:** \
**Assumptions:** \
**Precondition:**  \
**Postcondition:** \
**Author:** \
**Date:**

   * * *

**Use Case ID:** U004 \
**Use Case Name:** Generate Matching Questions \
**Summary:**  \
**Basic Course of Events:**

1.
2.
3.
4.
5.
6.

**Alternative Paths:** \
**Exception Paths:** \
**Extension Points:** \
**Trigger:** \
**Assumptions:** \
**Precondition:**  \
**Postcondition:** \
**Author:** \
**Date:**

   * * *

**Use Case ID:** U005 \
**Use Case Name:** Generate Fill-In-The-Blank Questions \
**Summary:**  \
**Basic Course of Events:**

1.
2.
3.
4.
5.
6.

**Alternative Paths:** \
**Exception Paths:** \
**Extension Points:** \
**Trigger:** \
**Assumptions:** \
**Precondition:**  \
**Postcondition:** \
**Author:** \
**Date:**

   * * *

**Use Case ID:** U006 \
**Use Case Name:** Generate Spot-The-Bug Questions \
**Summary:**  \
**Basic Course of Events:**

1.
2.
3.
4.
5.
6.

**Alternative Paths:** \
**Exception Paths:** \
**Extension Points:** \
**Trigger:** \
**Assumptions:** \
**Precondition:**  \
**Postcondition:** \
**Author:** \
**Date:**

   * * *

**Use Case ID:** U007 \
**Use Case Name:** Access Previous Questions \
**Summary:**  \
**Basic Course of Events:**

1.
2.
3.
4.
5.
6.

**Alternative Paths:** \
**Exception Paths:** \
**Extension Points:** \
**Trigger:** \
**Assumptions:** \
**Precondition:**  \
**Postcondition:** \
**Author:** \
**Date:**

   * * *

**Use Case ID:** U008 \
**Use Case Name:** Generate Quiz From Questions \
**Summary:**  \
**Basic Course of Events:**

1.
2.
3.
4.
5.
6.

**Alternative Paths:** \
**Exception Paths:** \
**Extension Points:** \
**Trigger:** \
**Assumptions:** \
**Precondition:**  \
**Postcondition:** \
**Author:** \
**Date:**

   * * *

## REQUIREMENTS ##

**Requirements ID:** R001 \
**Requirements Type:** 2 \
**Relevant Use Case ID:** U001 \
**Date:** 10/02/2022\
**Introduction:** The question document provided must be verified as being in a properly ingestible format. In order for it to be read, it must contain a header and footer indicating the space of the questions, and sections corresponding to the question type, desired LMS, programming language of the question, whether the question should be stored, and the range of the section in the provided program that the question should be manipulating. The area following these sections will be assumed to be the program, up to the footer.\
**Rationale:** The customer has indicated that the instructors will want the system to work from source code files, generally text. Establishing a standard document format that is readable by the system is ideal for making the system easy for instructors to use.\
**Author:** Sam Williams\
**Source:** Customer Feedback \
**Inputs:** *Question document (txt file)*\
**Requirement Description:** The system shall be able to verify if a *question document* is formatted correctly. The *question document* will pass the verification unless

1. The "QUESTION_START" and "QUESTION_END" headers are missing from the *question document*
2. The "TYPE: " section does not follow "QUESTION_START" or the type listed after "TYPE: " is invalid or not implemented.
3. The "LMS: " section does not follow the "TYPE: " section or the LMS listed after "LMS: " is invalid or not implemented.
4. The "LANGUAGE: " section does not follow the "LMS: " section or the programming language listed after "LANGUAGE: " is invalid or not implemented.
5. The "SAVE: " section does not follow the "LANGUAGE: " section or the options listed after "SAVE: " are neither "Y" or "N".
6. The "MUTATION RANGE: " section does not follow the "SAVE: " section or the range listed after "MUTATION RANGE: " is invalid or does not exist within the bounds of the program lines following this section.

Any singular or combined instance of the above cases causes the document verification to fail. 

**Outputs:** *Verification Status* - Pass or Fail \
**Persistent Changes:** None. \
**User Satisfaction:** 5 \
**User Dissatisfaction:** 5 \
**Related Requirements:** R002-R006 \
**Conflicts:** None \
**Support Materials:** None \
**Test Cases:** TBD

   * * *

**Requirements ID:** R002 \
**Requirements Type:** 2 \
**Relevant Use Case ID:** U002 \
**Date:** 10/02/2022\
**Introduction:** The system must be capable of generating multiple choice questions from a properly verified question document.\
**Rationale:** The customer has indicated that multiple choice is a commonly utilized PPA question format, and that they wish them to be implemented by mutating a line in the provided source code and providing the mutations and the original line as potential answers.\
**Author:** Sam Williams\
**Source:** Customer Feedback \
**Inputs:** *Verified question document* with a "TYPE:" section listed as "MULTIPLE CHOICE"\
**Requirement Description:** The system shall be able to utilize the *verified question document* to generate a series of multiple choice questions by taking the mutation range and generating mutants for the line, then randomizing and storing the mutants and correct line as potential answers in a question file formatted for the indicated LMS.

* The *verified question document* will be accepted if and only if

    1. The "TYPE: " section continues to be followed by "MULTIPLE CHOICE"
    2. The "MUTATION RANGE: " section is followed by a range consisting of only one line.

Any singular or combined instance of the above cases causes the document verification to fail.

* If *verified question document* is accepted, a number of *multiple choice question files* will be generated corresponding to exactly the amount indicated in the system config file.

**Outputs:** Number of *Multiple Choice Question Files* as indicated in system config file. \
**Persistent Changes:** None. \
**User Satisfaction:** 5 \
**User Dissatisfaction:** 5 \
**Related Requirements:** R001 \
**Conflicts:** None \
**Support Materials:** None \
**Test Cases:** TBD

   * * *


