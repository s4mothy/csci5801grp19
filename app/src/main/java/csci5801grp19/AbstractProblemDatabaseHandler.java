package csci5801grp19;


public abstract class AbstractProblemDatabaseHandler extends Component {

  private Problem currProb;

  public Problem getCurrProb () {
    return currProb;
  }

  public void storeProbInDB(Problem newProb) {
    
  }
  
  public AbstractProblemDatabaseHandler (Mediator dialog) {
    super(dialog);
  }


}
