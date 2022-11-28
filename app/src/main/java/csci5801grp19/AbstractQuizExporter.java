package csci5801grp19;

public abstract class AbstractQuizExporter extends Component {

  protected AbstractQuizExporter(Mediator dialog) {
    super(dialog);
  }

  public abstract boolean exportQuiz(Quiz currQuiz);
}
