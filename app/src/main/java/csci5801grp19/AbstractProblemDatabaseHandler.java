package csci5801grp19;


public abstract class AbstractProblemDatabaseHandler extends Component {

  private AbstractProblem currProb;

  public AbstractProblem getCurrProb () {
    return currProb;
  }

  public void storeProbInDB(AbstractProblem newProb) {
    
  }
  
  public AbstractProblemDatabaseHandler (Mediator dialog) {
    super(dialog);
  }


}
