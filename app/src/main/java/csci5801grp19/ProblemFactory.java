package csci5801grp19;
import java.io.*;

public class ProblemFactory {

  public static AbstractProblem createProblem(String pType, File sc) {
    if (pType.equals("Ordering")) {
      return new OrderingProblem(sc);
    }
    if (pType.equals("MultipleChoice")) {
      return new MultChcProblem(sc);
    }
    return null;
  }
  
}
