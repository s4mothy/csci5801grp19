package csci5801grp19;

import java.io.*;

public abstract class AbstractSourceCodeHandler extends Component {

  private String SRC_CODE_PATH = "src\\main\\resources\\source_code\\";

  private File srcCode;

  /**
   * Inaccessible constructor that exists to allow dialog to be
   * passed to correctly with super.
   * 
   * @param dialog The mediator reference shared among Components.
   */
  protected AbstractSourceCodeHandler(Mediator dialog) {
    super(dialog);
  }

  /**
   * Getter for the current source code stored in the source code handler.
   * 
   * @return Stored source code File.
   */
  public File getSrcCode() {
    return srcCode;
  }

  /**
   * Calculates the amount of source code of a certain type exists, to verify if
   * a requested quiz can be made.
   */
  public int checkSrcCodeQt(String ext) {
    File srcFolder = new File(SRC_CODE_PATH);

    FilenameFilter filter = new FilenameFilter() {
      public boolean accept(File f, String nm) {
        return nm.endsWith(ext);
      }
    };

    return srcFolder.list(filter).length;
  }

  public abstract File ingestNewSC(String ext);

}
