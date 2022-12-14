package csci5801grp19;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QuizExporterToQuizDirectory extends AbstractQuizExporter {

  private String QZ_EXP_PATH = "src\\main\\resources\\quiz_export\\";

  /**
   * Constructor for quiz exporter that saves to the output quiz directory.
   * 
   * @param dialog The dialog that lets the exporter communicate with
   *               other Components.
   */
  public QuizExporterToQuizDirectory(Mediator dialog) {
    super(dialog);
  }

  /**
   * Exports a particular quiz to the quiz directory.
   * 
   * @param currQuiz The quiz being exported.
   */
  public boolean exportQuiz(Quiz currQuiz) {
    String export_fname = QZ_EXP_PATH + SystemFacade.qz_fname + "_export.txt";
    try {
      File expFile = new File(export_fname);
      // If file already exists, deletes and makes new.
      if (!expFile.createNewFile()) {
        System.out.println("Deleting old quiz file...");
        expFile.delete();
        expFile.createNewFile();
      } 
      System.out.println("Quiz export file generated: " + expFile.getName());
      FileWriter expWriter = new FileWriter(expFile);
      expWriter.write(currQuiz.toString());
      expWriter.close();
      System.out.println("Successfully wrote quiz to export file.");
      
    } catch (IOException e) {
      System.out.println("An error has occurred.");
      e.printStackTrace();
      return false;
    }

    

    return true; // not yet implemented
  }

}
