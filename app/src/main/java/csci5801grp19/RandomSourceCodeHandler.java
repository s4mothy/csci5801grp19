package csci5801grp19;

import java.io.*;
import java.util.Random;

public class RandomSourceCodeHandler extends AbstractSourceCodeHandler {

  private String SRC_CODE_PATH = "src\\main\\resources\\source_code\\";

  public RandomSourceCodeHandler(Mediator dialog) {
    super(dialog);
  }

  public File ingestNewSC(String ext) {

    Random rand = new Random();
    File srcFolder;

    srcFolder = new File(SRC_CODE_PATH);
    FilenameFilter filter = new FilenameFilter() {
      public boolean accept(File f, String nm) {
        return nm.endsWith(ext);
      }
    };

    int numFiles = srcFolder.list(filter).length;
    String fname = srcFolder.list(filter)[rand.nextInt(numFiles)];
    File srcCode = new File(SRC_CODE_PATH + fname);
    return srcCode;
  }

}
