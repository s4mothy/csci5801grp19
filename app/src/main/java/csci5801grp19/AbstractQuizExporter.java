package csci5801grp19;

public abstract class AbstractQuizExporter extends Component {

  /**
   * Inaccessible constructor that exists to allow dialog to be
   * passed to correctly with super.
   * 
   * @param dialog The mediator reference shared among Components.
   */
  protected AbstractQuizExporter(Mediator dialog) {
    super(dialog);
  }

  public abstract boolean exportQuiz(Quiz currQuiz);
}
