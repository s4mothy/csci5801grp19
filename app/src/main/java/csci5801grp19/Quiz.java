package csci5801grp19;

import java.util.*;

public class Quiz {

  private String BUFFER = "================================================================\n";

  private List<AbstractProblem> questions;
  private String quizInfo;

  /**
   * Constructor for a new quiz, initializes the array of questions
   * and stores the title of the quiz.
   * 
   * @param quizInfo Contains the title of the quiz.
   */
  public Quiz(String quizInfo) {
    this.questions = new ArrayList<>();
    this.quizInfo = quizInfo;
  }

  /**
   * Getter for the list of questions being stored in the quiz.
   * 
   * @return The list of quiz questions.
   */
  public List<AbstractProblem> getQuestions() {
    return questions;
  }

  /**
   * Getter for the title of the quiz.
   * 
   * @return Quiz title.
   */
  public String getQuizInfo() {
    return quizInfo;
  }

  /**
   * String constructor, first printing the title, then printing
   * the contents of the quiz's contained problems.
   */
  public String toString() {
    String str = quizInfo;
    str += "\n";
    str += BUFFER;
    for (int i = 0; i < questions.size(); i++) {
      str += questions.get(i).toString();
      str += BUFFER;
    }
    return str;
  }

}
