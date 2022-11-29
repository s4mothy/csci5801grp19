package csci5801grp19;

import java.io.*;
import java.util.Random;

public class RandomGrabProbDatabaseHandler extends AbstractProblemDatabaseHandler {

  private String STORED_PROB_PATH = "src\\main\\resources\\stored_probs\\";

  /**
   * Constructor for the problem data base handler, via which it
   * receives access to a mediator through its dialog.
   * 
   * @param dialog The handler's access to a mediator to communicate
   *               with other components.
   */
  public RandomGrabProbDatabaseHandler(Mediator dialog) {
    super(dialog);
  }

  /**
   * Pulls a problem from the database of a cetain type and converts
   * it back into an abstract problem.
   * 
   * @param type The desired type of the problem to be pulled.
   * @return Freshly converted abstract problem.
   */
  public AbstractProblem getProbFromDB(String type) {

    AbstractProblem prb = null;
    Random rand = new Random();

    String ptVal = "T00";
    if (type.equals("multiple choice")) {
      ptVal = "T01";
    }
    if (type.equals("ordering")) {
      ptVal = "T02";
    }

    File prbFolder = new File(STORED_PROB_PATH);
    final String tmp = ptVal;
    FilenameFilter filter = new FilenameFilter() {
      public boolean accept(File f, String nm) {
        return nm.endsWith(tmp);
      }
    };

    int numFiles = prbFolder.list(filter).length;
    String randFileName = prbFolder.list(filter)[rand.nextInt(numFiles)];

    try {
      FileInputStream fileIn = new FileInputStream(STORED_PROB_PATH + randFileName);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      if (type.equals("multiple choice")) {
        prb = (MultChcProblem) in.readObject();
      }
      if (type.equals("ordering")) {
        prb = (OrderingProblem) in.readObject();
      }

      in.close();
      fileIn.close();
    } catch (IOException i) {
      i.printStackTrace();
      return null;
    } catch (ClassNotFoundException c) {
      System.out.println("Employee class not found");
      c.printStackTrace();
      return null;
    }

    return prb;

  }

}
