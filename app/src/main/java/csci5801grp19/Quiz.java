package csci5801grp19;
import java.util.*;

public class Quiz {
  
  private List<AbstractProblem> questions;
  private String quizInfo;

  public Quiz(String quizInfo) {
    this.questions = Arrays.asList();
    this.quizInfo = quizInfo;
  }

  public List<AbstractProblem> getQuestions() {
    return questions;
  }

  public String getQuizInfo() {
    return quizInfo;
  }

}
