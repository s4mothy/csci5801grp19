package csci5801grp19;
import java.io.*;

public class ProblemFactory {

  public static AbstractProblem createProblem(String pType, File sc) {
    if (pType.equals("ordering")) {
      return new OrderingProblem(sc);
    }
    if (pType.equals("multiple choice")) {
      return new MultChcProblem(sc);
    }
    return null;
  }
  
}
