package csci5801grp19;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FillBlankProblem extends AbstractProblem {

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

    // TODO: add keyword arrays for other languages.

    
    /**
     * @brief Constructor 
     * @param myFile is the opened source code file
     * @param type is the type of keyword to replace
     * @param debug is wheather to run in debug mode
     * 
     * @return instance of this class
     */
    public FillBlankProblem(File myFile, int type, boolean debug){

        // initialize parameters
        this.question = "";
        this.question = "";
        this.solution = "";
        this.langEx = "." + myFile.getName().split("\\.")[1];
        this.makeProblem(myFile,type,debug);
    }

    /**
     * @brief default Constructor (doesn't specify parameters; type = 0, debug = false)
     * @param myFile is the opened source code file
     * 
     * @return instance of this class
     */
    public FillBlankProblem(File myFile){

        // initialize parameters
        this.question = "";
        this.question = "";
        this.solution = "";
        this.langEx = "." + myFile.getName().split("\\.")[1];
        this.makeProblem(myFile,0,false);
    }

    /**
     * @brief null Constructor (doesn't make problem on its own, used 
     * for debugging)
     * @param lang is the language of the problem
     * 
     * @return instance of this class
     */
    public FillBlankProblem(String lang){

        // initialize parameters
        this.question = "";
        this.question = "";
        this.solution = "";
        this.langEx = lang;
    }

    /**
     * @brief This is the main workhorse of this class. Populates the class variables
     * with a proper, finished problem bassed on the specifications.
     * @param myFile the opened source code file.
     * @param type determines which type of keyword or operator to replace with a blank. 
     * 0 for keyword, 1 for arithmetic operator, 2 for assignment operator, 3 for 
     * comparison operator, 4 for bitwise operator.
     * @param debug either true for debug mode or false for noraml mode.
     * 
     * @return error code (0 if no issues)
     */
    public int makeProblem(File myFile, int type, boolean debug) {
        Scanner fileReader;

        // attempt to scan file
        try {
            fileReader = new Scanner(myFile);
        }

        // file not found exception:
        catch (FileNotFoundException e) {
            System.out.println("Could not find File.");
            e.printStackTrace();
            return 1;
        }

        // this method works by randomly turning the n'th keyword into 
        // a blank. We need the total number of keywords in the source code to
        // determine the range of possible random numbers.

        // this method determines the number of keywords in the souce code.
        int[] specs = getFileSpecs(myFile);

        // generate random value from 0 to number of keywords.
        Random rand = new Random();
        int upperbound = specs[type];
        int n = rand.nextInt(upperbound); 


        // if running in debugg mode, will print separators and parameter values 
        // on the final product. 
        if(debug){
            this.question = "question:";
            this.question = "question:" + type;
            this.solution = "solution:" + n + "\n";
        }

        // now turn the n'th keyword into a blank by iterating over the file:

        // i is the number of keywords we've seen
        int i = 0;
        String[] line;

        // iterate type to bring it in line with output from "categorizeToken" 
        // function.
        type++;

        while (fileReader.hasNextLine()) {
            // read and tokenize each line:
            line = fileReader.nextLine().split(" ");

            // ignore lines that begin with a comment, or are whitespace
            if(line[0] != "#" && (line.length > 1)){
                
                // iterate through each line
                for (String word : line) {

                    // this method reads which kind of keyword the token is
                    int category = categorizeToken(word);
                    

                    // when finding the beginning of a comment, 
                    // ignore the rest of that line.
                    if (category == 0) {
                        break;
                    }

                    // if word is the correct type:
                    else if (category == type){

                        // if the word is the n'th instance
                        if (i == n){
                            this.question += "_____";
                            this.solution += word;
                        }

                        // if word isn't the blank, simply write it to the 
                        // output as is.
                        else {
                            this.question += word;
                        }
                        i++;
                    }

                    // if word isn't of interest, simply write it to the 
                    // output as is. 
                    else {
                        this.question += word;
                    }

                    // add spaces in between each word.
                    this.question += " ";
                }
                // add the newline character between lines.
                this.question += "\n";
            }
        }

        // cleanup
        fileReader.close();
        return 0;
    }

    /**
     * @brief Check to see if token contains a python keyword.
     * @param word is the word we matching to python keywords. 
     * 
     * @return 0 for comment, 1 for keyword, 2 for arithmetic operation, 3 for
     * assignment operator, 4 for comparison operator, 5 for bitwise
     * operator, 6 for other
     */
    public int categorizeToken(String word) {

        if(word.contains("#")){
            return 0;
        }

        // compile a list of every category of keyword in python
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
            i++;
        }

        // if the word isn't recognized (likely a variable name)
        return i;
    }

    /**
     * @brief gets number of keywords in file
     * @param myFile is the open file we are analysing
     * 
     * @return list of counts. the index of the array signifies 
     * the type of keyword counted there. For example, result[0] is 
     * number of keywords, result[1] is the number of arithmetic operators,
     * etc.
     */
    public int[] getFileSpecs(File myFile) {
        int[] result = {0,0,0,0,0,0};
        String[] line;
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
            line = fileReader.nextLine().split(" ");

            // ignore lines that begin with a comment, or are whitespace
            if(line[0] != "#" && (line.length > 2)){
                
                for (String word : line) {

                    // read categorizeToken for more info
                    int category = categorizeToken(word);

                    // ignore comments
                    if (category == 0) {
                        break;
                    }
    
                    // add 1 to proper category
                    else {
                        category--;
                        result[category]++;
                    }
                }
            }
        }

        // cleanup
        fileReader.close();
        return result;
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
     * @brief for debugging purposes. Writes the toString version of working class
     * to a specified file path.
     * @param filepath is the location of the output.
     * 
     * @return error code. 0 if no errors.
     */
    public int writeOutput(String filepath) {

        // delete the old file
        File fOld = new File(filepath);
        fOld.delete();

        // replace with current toString()
        File fNew = new File(filepath);

        // attempty to open file
        try {
            FileWriter w = new FileWriter(fNew, false);
            w.write(this.toString());
            w.close();
        }

        // ceath errors
        catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}