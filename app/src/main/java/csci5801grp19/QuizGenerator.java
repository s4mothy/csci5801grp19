package csci5801grp19;

public class QuizGenerator extends Component {

  private Quiz currQuiz;

  /**
   * Constructor for the component that generates quizzes.
   * 
   * @param dialog The quiz generators access to a mediator
   *               to communicate with other components.
   */
  public QuizGenerator(Mediator dialog) {
    super(dialog);
  }

  /**
   * Getter for getting the currently stored quiz.
   */
  public Quiz getQuiz() {
    return currQuiz;
  }

  /**
   * Heavily utilizes the system mediator to faciliate problem generation
   * and populate the quiz stored within this class, before eventually
   * exporting the quiz to a file.
   * 
   * @return The Quiz being generated.
   */
  Quiz generateQuiz() {

    currQuiz = new Quiz(SystemFacade.title);

    this.dialog.notify(this, "ChkSrcCode");
    this.dialog.notify(this, "ChkProbDB");

    for (int i = 0; i < (SystemFacade.quiz_template.length); i++) {
      String currType = SystemFacade.quiz_template[i][0];
      if (currType.equals("multiple choice")) {
        this.dialog.notify(this, "GenMCProb");
      }
      if (currType.equals("ordering")) {
        this.dialog.notify(this, "GenOrderProb");
      }
    }

    this.dialog.notify(this, "ExportQuiz");

    return getQuiz();
  }

}
