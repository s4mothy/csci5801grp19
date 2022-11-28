package csci5801grp19;
import java.io.*;
import java.util.Random;

public class RandomGrabProbDatabaseHandler extends AbstractProblemDatabaseHandler {

  public RandomGrabProbDatabaseHandler (Mediator dialog) {
    super(dialog);
  }

  public AbstractProblem getProbFromDB (String type) {
    
    AbstractProblem prb = null;
    Random rand = new Random();

    String ptVal = "T00";
    if (type.equals("multiple choice")) {
      ptVal = "T01";
    }
    if (type.equals("ordering")) {
      ptVal = "T02";
    }
    
    File prbFolder = new File ("../../resources/stored_probs/");
    final String tmp = ptVal;
    FilenameFilter filter = new FilenameFilter() {
      public boolean accept (File f, String nm) {
        return nm.endsWith(tmp);
      }
    };

    int numFiles = prbFolder.list(filter).length;
    String randFileName = prbFolder.list(filter)[rand.nextInt(numFiles)];
    
    try {
      FileInputStream fileIn = new FileInputStream("../../resources/stored_probs/" + randFileName);
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
