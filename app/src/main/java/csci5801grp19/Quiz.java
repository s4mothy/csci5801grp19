package csci5801grp19;
import java.util.*;

public class Quiz {
  private List<Problem> questions;
  private String quizInfo;

  public Quiz(String quizInfo) {
    this.questions = Arrays.asList();
    this.quizInfo = quizInfo;
  }

  public List<Problem> getQuestions() {
    return questions;
  }

  public String getQuizInfo() {
    return quizInfo;
  }
}
