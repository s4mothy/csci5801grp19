package csci5801grp19;
import java.io.*;

public abstract class AbstractProblem implements Serializable {

  private String question;
  private String options;
  private String solution;

  public String getQuestion() {
    return this.question;
  }

  public String getOptions() {
    return this.options;
  }

  public String getSolution() {
    return this.solution;
  }
  
}
