package csci5801grp19;

public abstract class AbstractQuizExporter extends Component {
  public AbstractQuizExporter(Mediator dialog) {
    super(dialog);
  }
  public abstract boolean exportQuiz(Quiz currQuiz);
}
