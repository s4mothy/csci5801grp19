package csci5801grp19;
import java.io.*;

public class QuizGenerator extends Component {

  private Quiz currQuiz;
  private File quizDoc;

  public QuizGenerator(Mediator dialog) {
    super(dialog);
  }

  public Quiz getQuiz() {
    return currQuiz;
  }

  public File getQuizDoc() {
    return quizDoc;
  }

  Quiz generateQuiz(String fname) {
    
    this.dialog.notify(this, "ChkSrcCode");


    
    return getQuiz();
  }

}
