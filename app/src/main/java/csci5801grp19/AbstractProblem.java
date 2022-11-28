package csci5801grp19;
import java.io.*;

public abstract class AbstractProblem implements Serializable {

  protected String question;
  protected String options;
  protected String solution;

  public String getQuestion() {
    return this.question;
  }

  public String getOptions() {
    return this.options;
  }

  public String getSolution() {
    return this.solution;
  }

  public String toString() {
    String str = question;
    str += '\n';
    str += options;
    str += '\n';
    str += solution;
    str += '\n';

    return str;
  }
  
}
