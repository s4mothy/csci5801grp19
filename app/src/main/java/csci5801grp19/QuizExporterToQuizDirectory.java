package csci5801grp19;

public class QuizExporterToQuizDirectory extends AbstractQuizExporter {

  /**
   * Constructor for quiz exporter that saves to the output quiz directory.
   * 
   * @param dialog The dialog that lets the exporter communicate with
   *               other Components.
   */
  public QuizExporterToQuizDirectory(Mediator dialog) {
    super(dialog);
  }

  /**
   * Exports a particular quiz to the quiz directory.
   * 
   * @param currQuiz The quiz being exported.
   */
  public boolean exportQuiz(Quiz currQuiz) {
    return false; // not yet implemented
  }

}
