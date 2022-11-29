package csci5801grp19;

import java.io.*;

public class ProblemFactory {

  /**
   * Private constructor to prevent instants.
   */
  private ProblemFactory() {
  };

  /**
   * Method that generates a new problem instance based on
   * desired problem type and given source code.
   * 
   * @param pType Problem type requested to be made.
   * @param sc    Source code File that the problem is supposed to be made from.
   * @return A new problem of the type desired created from the source code.
   */
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
