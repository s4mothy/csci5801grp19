package csci5801grp19;

public class QuizGenerator extends Component {

  private Quiz currQuiz;

  public Component getInstance() {
    if (instance == null) {
      instance = new QuizGenerator();
    }
    return instance;
  }

  public Quiz getQuiz() {
    return currQuiz;
  }

  Quiz generateQuiz(String fname) {
    this.getInstance().dialog.notify(this, "ChkSrcCode");
    

    return getQuiz();
  }

}
