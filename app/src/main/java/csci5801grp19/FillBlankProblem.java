package csci5801grp19;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FillBlankProblem extends AbstractProblem {

    protected String question;
    protected String options;
    protected String solution;
    protected String langEx;

    public String[] python_keywords = { "and", "as", "assert", "break",
            "class", "continue", "def", "del", "elif", "else", "except",
            "False", "finally", "for", "from", "global", "if", "import",
            "in", "is", "lambda", "None", "nonlocal", "not", "or", "pass",
            "raise", "return", "True", "try", "while", "with", "yield" };

    public String[] python_arithmetic = { "+", "-", "*", "/", "%", "**", "//" };

    public String[] python_assignment = { "=", "+=", "-=", "*=", "/=", "%=", "//=",
            "**=", "&=", "|=", "^=", ">>=", "<<=" };

    public String[] python_comparison = { "==", "!=", ">", "<", ">=", "<=" };

    public String[] python_bitwise = {"&","|","^","~","<<",">>"};

    /**
     * @brief Constructor 
     * @param lang is the language of the source code.
     * 
     * @return instance of this class
     */
    public FillBlankProblem(String lang) {
        this.langEx = lang;
        this.question = "question:";
        this.options = "options:";
        this.solution = "solution:";
    }

    /**
     * @brief This is the main workhorse of this class. Populates the class variables
     * with a proper, finished problem bassed on the specifications.
     * @param filePath path to source code
     * @param type determines which type of keyword or operator to replace with a blank. 
     * 0 for keyword, 1 for arithmetic operator, 2 for assignment operator, 3 for 
     * comparison operator, 4 for bitwise operator.
     * @param num unimplemented. 
     * 
     * @return error code (0 if no issues)
     */
    public int makeProblem(String filePath, int type, int num) {
        File myFile;
        Scanner fileReader;

        // attempt to open file
        try {
            myFile = new File(filePath);
            fileReader = new Scanner(myFile);
        }

        // file not found exception:
        catch (FileNotFoundException e) {
            System.out.println("Could not find File.");
            e.printStackTrace();
            return 1;
        }

        // get a prediction of how many of each keyword is in the file.
        int[] specs = getFileSpecs(myFile);

        //generate random value from 0 to length of list
        Random rand = new Random();
        int upperbound = specs.length;
        int int_random = rand.nextInt(upperbound); 
        this.solution += int_random;
        int i = 0;

        String[] tokens;
        

        while (fileReader.hasNextLine()) {
            // read and tokenize the header (first line)
            tokens = fileReader.nextLine().split(" ");

            // ignore line that begin with a comment, or are whitespace
            if(tokens[0] != "#" && (tokens.length > 2)){
                
                for (String token : tokens) {

                    // read categorizeToken for more info
                    int category = categorizeToken(token);
                    

                    // ignore comments
                    if (category == 0) {
                        break;
                    }

                    else if ((category - 1) == type){
                        if (i == int_random){
                            this.question += "_____";
                            this.solution += "\n" + token;
                        }
                        else {
                            this.question += token;
                        }

                        i++;
                    }
    
                    // handle keywords
                    else if (category == 1) {
                        this.question += token;
                    }

                    // handle arithmetic operators
                    else if (category == 2) {
                        this.question += token;
                    }

                    // handle assignment operators
                    else if (category == 3) {
                        this.question += token;
                    }

                    // handle comparison operators
                    else if (category == 4) {
                        this.question += token;
                    }

                    // handle bitwise operators
                    else if (category == 5) {
                        this.question += token;
                    }

                    // handle unrecognized tokens
                    else {
                        this.question += token;
                    }

                    this.question += " ";
                }
                // new line
                this.question += "\n";
            }
        }

        // cleanup
        fileReader.close();
        return 0;
    }

    /**
     * @brief Check to see if token contains a python keyword.
     * @param word is the word we matching to a keyword. 
     * 
     * @return 0 for comment, 1 for keyword, 2 for arithmetic operation, 3 for
     * assignment operator, 4 for comparison operator, 5 for bitwise
     * operator, 6 for other
     */
    public int categorizeToken(String word) {

        if(word.contains("#")){
            return 0;
        }

        // compile a list of every kind of word in python
        String[][] python_categories = {this.python_keywords,
            this.python_arithmetic,this.python_assignment,
            this.python_comparison,this.python_bitwise};

        int i = 1;

        // iterate over the words and return number for category
        for (String[] category : python_categories){
            for (String keyword : category){
                if(word.equals(keyword)){
                    return i;
                }
            }
            // iterate
            i++;
        }

        // return 5 if the word isn't recognized (likely a variable name)
        return i;
    }

    /**
     * @brief bassed on specifications, will change the answer and options to make
     * a convincing problem.
     * @param word is the token which is being replaced with a blank.
     * @param type is the type of keyword to replace.
     * @param numOptions is the number of options to give to the student.
     * 
     * @return error code. 0 for no errors.
     */
    public int setSolution(String word, int type, int numOptions){
        this.solution += "\n" + word;

        // compile a list of every kind of word in python
        String[][] python_categories = {this.python_keywords,
            this.python_arithmetic,this.python_assignment,
            this.python_comparison,this.python_bitwise};

        String[] category = python_categories[type];

        for (int i = 0; i < numOptions; i++){
            //generate random value from 0 to length of list
            Random rand = new Random();
            int upperbound = category.length;
            int int_random = rand.nextInt(upperbound); 

            this.options += "\n" + category[int_random];
        }
        return 0;
    }

    /**
     * @brief for debugging purposes. Writes the toString version of working class
     * to a specified file path.
     * @param filepath is the location of the output.
     * 
     * @return error code. 0 if no errors.
     */
    public int writeOutput(String filepath) {
        File fOld = new File(filepath);
        fOld.delete();
        File fNew = new File(filepath);
        try {
            FileWriter w = new FileWriter(fNew, false);
            w.write(this.toString());
            w.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @brief string form of question.
     * 
     * @return Returns String of problem, which consist of three blocks of text;
     * question on top, options in middle, solution bottom.
     */
    public String toString() {
        String str = question;
        str += '\n';
        str += solution;
        str += '\n';

        return str;
    }

    /**
     * @brief gets number of keywords in file
     * @param fileReader is the Scanner which can read the file
     * 
     * @return error code. 0 if no errors.
     */
    public int[] getFileSpecs(File myFile) {
        int[] result = {0,0,0,0,0,0};
        String[] tokens;
        Scanner fileReader;

        // attempt to open file
        try {
            fileReader = new Scanner(myFile);
        }

        // file not found exception:
        catch (FileNotFoundException e) {
            System.out.println("Could not find File.");
            e.printStackTrace();
            return result;
        }



        while (fileReader.hasNextLine()) {
            // read and tokenize the header (first line)
            tokens = fileReader.nextLine().split(" ");

            // ignore line that begin with a comment, or are whitespace
            if(tokens[0] != "#" && (tokens.length > 2)){
                
                for (String token : tokens) {

                    // read categorizeToken for more info
                    int category = categorizeToken(token);

                    // ignore comments
                    if (category == 0) {
                        break;
                    }
    
                    else {
                        category--;
                        result[category]++;
                    }
                }
            }
        }

        fileReader.close();
        return result;
    }

}