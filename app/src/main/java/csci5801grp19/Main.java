package csci5801grp19;
import java.util.Scanner; 

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello World!");

    System.out.println("Creating System Facade:");
    SystemFacade facade = SystemFacade.getInstance();

    // recieve path to specifications
    Scanner inputReader = new Scanner(System.in);
    System.out.println("Enter path to specification document: ");
    String input = inputReader.nextLine();
    System.out.println("path is: " + input);
    inputReader.close();

    if (facade.getInput(input) != 0) {
      System.out.println("error");
      return;
    }

    System.out.println("title: " + SystemFacade.title);
    System.out.println("number of questions: " + SystemFacade.num_questions);
    System.out.println("number of quizzes: " + SystemFacade.num_quizzes);

    for (int i = 0; i < SystemFacade.num_questions; i++) {
      System.out.print("question " + (i + 1) + " is of type: ");
      System.out.println(SystemFacade.quiz_template[i][0]);
      System.out.print(" with this file extension: ");
      System.out.println(SystemFacade.quiz_template[i][1]);

    }

    SystemMediator newMed = new SystemMediator();

    System.out.println("Generating quizzes...");
    for (int i = 0; i < SystemFacade.num_quizzes; i++) {
      newMed.reactOnQZGen("GenerateQuiz");
    }
    System.out.println("Quiz generation complete.");
  }
}
