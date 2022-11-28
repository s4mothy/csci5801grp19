package csci5801grp19;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// singleton class used to parse information from input file
public final class SystemFacade {

  // variables:
  // a reference to itself, as a singleton class
  private static volatile SystemFacade INSTANCE = null;
  // Title of the quiz
  public static String title;
  // Number of distinct versions of the quiz
  public static int num_quizzes;
  // Number of questions on the quiz
  public static int num_questions;
  // Breakdown of information regarding each problems
  public static String[][] quiz_template;

  // constructor (should only be used once, as a signleton class)
  private SystemFacade() {
  }

  // thread safe singleton referencing https://www.youtube.com/watch?v=vSxKnvxe8v0
  public static SystemFacade getInstance() {
    if (INSTANCE == null) {
      // double check locking
      synchronized (SystemFacade.class) {
        if (INSTANCE == null) {
          INSTANCE = new SystemFacade();
        }
      }
    }
    return INSTANCE;
  }

  // primary method
  public int getInput() {

    // recieve path to specifications
    Scanner inputReader = new Scanner(System.in);
    System.out.println("Enter path to specification document: ");
    String input = inputReader.nextLine();
    System.out.println("path is: " + input);
    inputReader.close();

    // attempt to open file
    try {
      File myFile = new File(input);
      Scanner fileReader = new Scanner(myFile);
      int i = readSpecs(fileReader);
      fileReader.close();
      return i;
    }

    // file not found exception:
    catch (FileNotFoundException e) {
      System.out.println("Could not find File.");
      e.printStackTrace();
      return 1;
    }

  }

  private int readSpecs(Scanner s) {

    // check to make sure file isn't empty
    if (!s.hasNextLine()) {
      System.out.println("Fill out the specification document.");
      return 2;
    }

    // read and tokenize the first line (header)
    String[] tokens = s.nextLine().split(",");

    // checks header formating
    if (tokens == null || tokens.length != 3) {
      System.out.println("header is not formatted correctly.");
      return 2;
    }

    // read header
    try {
      num_questions = Integer.parseInt(tokens[0]);
      num_quizzes = Integer.parseInt(tokens[1]);
      title = tokens[2];
      quiz_template = new String[num_questions][2];
    }
    // return error if header doesn't contain numbers
    catch (final NumberFormatException e) {
      System.out.println("header must contain number the number of questions per quiz, and the number of quizzes.");
      return 2;
    }

    // reads each question
    for (int i = 0; i < num_questions; i++) {
      if (!s.hasNextLine()) {
        System.out.println("number of questions doesn't match header.");
        return 2;
      }
      tokens = s.nextLine().split(",");

      String type = tokens[0];
      String extension = tokens[1];

      // language/problem is supported
      if (!checkType(type) || !checkExtension(extension)) {
        return 2;
      }
      quiz_template[i][0] = tokens[0];
      quiz_template[i][1] = tokens[1];
    }

    // finished reading questions
    return 0;
  }

  // makes sure specified problem type is supported
  private boolean checkType(String type) {
    if (type.equals("ordering")) {
      return true;
    } else if (type.equals("multiple choice")) {
      return true;
    }

    System.out.println("unsupported type");
    return false;
  }

  // makes sure specified language is supported
  private boolean checkExtension(String extension) {
    if (extension.equals(".py")) {
      return true;
    } else if (extension.equals(".c")) {
      return true;
    } else if (extension.equals(".java")) {
      return true;
    } else if (extension.equals(".HTML")) {
      return true;
    }

    System.out.println("unsupported language");
    return false;
  }

}