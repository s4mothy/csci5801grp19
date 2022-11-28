package csci5801grp19;
import java.util.*;

public class Quiz {
  
  private List<AbstractProblem> questions;
  private String quizInfo;

  public Quiz(String quizInfo) {
    this.questions = new ArrayList<AbstractProblem>();
    this.quizInfo = quizInfo;
  }

  public List<AbstractProblem> getQuestions() {
    return questions;
  }

  public String getQuizInfo() {
    return quizInfo;
  }

  public String toString() {
    String str = quizInfo;
    str += "\n";
    for(int i=0;i<questions.size();i++) {
      str+=questions.get(i).toString();
    }
    return str;
  }

}
