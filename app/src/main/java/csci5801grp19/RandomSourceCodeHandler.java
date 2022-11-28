package csci5801grp19;
import java.io.*;
import java.util.Random;

public class RandomSourceCodeHandler extends AbstractSourceCodeHandler {

  public RandomSourceCodeHandler (Mediator dialog) {
    super(dialog);
  }

  public File ingestNewSC(String ext) { 
    Random rand = new Random();

    File srcFolder = new File("../../resources/source_code/");
    FilenameFilter filter = new FilenameFilter() {
      public boolean accept (File f, String nm) {
        return nm.endsWith(ext);
      }
    };

    int numFiles = srcFolder.list(filter).length;
    String fname = srcFolder.list(filter)[rand.nextInt(numFiles)];
    File srcCode = new File(fname);
    return srcCode;
  }
}
