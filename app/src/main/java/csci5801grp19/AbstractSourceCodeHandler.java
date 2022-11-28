package csci5801grp19;

import java.io.*;

public abstract class AbstractSourceCodeHandler extends Component {

  private String SRC_CODE_PATH = "src\\main\\resources\\source_code\\";

  private File srcCode;

  protected AbstractSourceCodeHandler(Mediator dialog) {
    super(dialog);
  }

  public File getSrcCode() {
    return srcCode;
  }

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
