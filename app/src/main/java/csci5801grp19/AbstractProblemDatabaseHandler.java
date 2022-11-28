package csci5801grp19;
import java.io.*;

public abstract class AbstractProblemDatabaseHandler extends Component {

  private AbstractProblem currProb;

  public AbstractProblem getCurrProb () {
    return currProb;
  }

  public AbstractProblemDatabaseHandler (Mediator dialog) {
    super(dialog);
  }

  /**
   * Stores a newly generated problem in a serialized format to be later retrieved.
   * Serialization implemented with help of the following source:
   * https://www.tutorialspoint.com/java/java_serialization.htm#
   * 
   * @param newProb a newly generated problem file that is to be stored for future use.
   */
  public void storeProbInDB (AbstractProblem newProb) {
    String newFileName = genFileName(newProb);
    try { 
      FileOutputStream fileOut =
      new FileOutputStream("../../resources/stored_probs/" + newFileName);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(newProb);
      out.close();
      fileOut.close();
      System.out.printf(String.format("Problem File Saved At %s.", newFileName));
   } catch (IOException i) {
      i.printStackTrace();
   }
  }


  public int checkProbDBQt (String type) {
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

    return numFiles;
    
  }

  public abstract AbstractProblem getProbFromDB (String type);


  private String genFileName (AbstractProblem prob) {
    String ptVal = "T00";
    if (prob instanceof MultChcProblem) {
      ptVal = "T01";
    }
    if (prob instanceof OrderingProblem) {
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

    String newFileName = String.format(("P%08d" + ptVal), numFiles+1);

    return newFileName;
  }


}
