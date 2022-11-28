package csci5801grp19;
import java.io.*;

public abstract class AbstractSourceCodeHandler extends Component{
  private File srcCode;

  public AbstractSourceCodeHandler(Mediator dialog) {
    super(dialog);
  }

  public File getSrcCode() {
    return srcCode;
  }

  // TBD, currently just says there is an infinite amount of source code available
  public int checkSrcCodeQt(String ext) {
    File srcFolder = new File("../../resources/source_code/");

    FilenameFilter filter = new FilenameFilter() {
      public boolean accept (File f, String nm) {
        return nm.endsWith(ext);
      }
    };

    int numFiles = srcFolder.list(filter).length;
    return numFiles;
  }

  public abstract File ingestNewSC(String ext);


}
