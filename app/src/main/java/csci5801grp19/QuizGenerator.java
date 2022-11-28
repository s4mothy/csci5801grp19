package csci5801grp19;
import java.io.*;
import java.util.Random;

public class QuizGenerator extends Component {

  private Quiz currQuiz;
  private boolean canUseSavedProbs;
  private double DATABASE_ODDS = 0.1;

  public QuizGenerator(Mediator dialog) {
    super(dialog);
  }

  public Quiz getQuiz() {
    return currQuiz;
  }

  Quiz generateQuiz() {

    currQuiz = new Quiz(SystemFacade.title);
    
    this.dialog.notify(this, "ChkSrcCode");
    this.dialog.notify(this, "ChkProbDB");

    for(int i=0; i<(SystemFacade.quiz_template.length); i++) {
      String currType = SystemFacade.quiz_template[i][0];
      if(currType.equals("multiple choice")) {
        this.dialog.notify(this, "GenMCProb");
      }
      if(currType.equals("ordering")) {
        this.dialog.notify(this, "GenOrderProb");
      }
    }

    this.dialog.notify(this, "exportQuiz");


    
    return getQuiz();
  }

}
