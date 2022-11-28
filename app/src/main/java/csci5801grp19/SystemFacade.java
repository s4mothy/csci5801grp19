package csci5801grp19;
import java.util.Scanner; 
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

// singleton systemfacade class
public final class SystemFacade {


  // variables
  private static volatile SystemFacade INSTANCE = null;
  private File myFile;
  public static int questions;
  public static int quizzes;
  public static String title;
  

  // constructor (should only be used once)
  private SystemFacade() {}


  // thread safe singleton reference https://www.youtube.com/watch?v=vSxKnvxe8v0
  public static SystemFacade getInstance() {
    if(INSTANCE == null){
        // double check locking
        synchronized(SystemFacade.class){
            if(INSTANCE == null) {
                INSTANCE = new SystemFacade();
            }
        }
    }
    return INSTANCE;
  }

  public int getInput(){

    // recieve path to specifications from user.
    Scanner inputReader = new Scanner(System.in);
    System.out.println("Enter path to specification document: ");
    String input = inputReader.nextLine();  
    System.out.println("path is: " + input); 
    inputReader.close();


    // attempt to open file
    try {
      myFile = new File(input);
      Scanner fileReader = new Scanner(myFile);
      int i = readSpecs(fileReader);
      fileReader.close();
      return i;
    }

    // file not found exception:
    catch(FileNotFoundException e) {
      System.out.println("Could not find File.");
      e.printStackTrace();
      return 1;
    }
  }


  private int readSpecs(Scanner s){

    // check to make sure file isn't empty
    if(!s.hasNextLine()){
      System.out.println("Fill out the specification document.");
      return 2;
    }

    // read and tokenize the first line (header)
    String[] tokens = s.nextLine().split(",");

    // checks header formating
    if(tokens == null || tokens.length != 3){
      System.out.println("header is not formatted correctly.");
      return 2;
    }

    // read header
    try {
      questions = Integer.parseInt(tokens[0]);
      quizzes = Integer.parseInt(tokens[1]);
      title = tokens[2];
    } 
    // return error if header doesn't contain numbers
    catch (final NumberFormatException e) {
      System.out.println("header must contain number the number of questions per quiz, and the number of quizzes.");
      return 2;
    }

    // reads each question
    for (int i = 0; i < questions; i++) {
      if(!s.hasNextLine()){
        System.out.println("number of questions doesn't match header.");
        return 2;
      }
      tokens = s.nextLine().split(",");
      System.out.println("question type: " + tokens[0] + "\nlanguage: " + tokens[1]);
    }

    // finished reading questions
    return 0;
  }




}
