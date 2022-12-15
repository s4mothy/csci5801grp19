import java.io.*;

public class qzFileGenerator {
  // number of problems in the batch
  private int NUM_PROBS = 100;
  // file name for the input quiz file
  private String FILE_NAME = "batch.txt";
  // problem type desired for the batch
  private String PROB_TYPE = "multiple choice";
  // programming language the source code each problem should be made from
  private String SRC_CODE_EXT = ".py";
  // path to the quiz_input folder
  private String INPUT_PATH = "app\\src\\main\\resources\\quiz_input\\";

  /**
   * Generates an input file for a batch of a single problem type and language.
   * Useful for requests for large sets of a single problem type.
   */
  public void genInputFile() {
    try {
      File fp = new File(INPUT_PATH + FILE_NAME);
      if(fp.exists()){
        fp.delete();
      }
      fp.createNewFile();
      FileWriter fw = new FileWriter(fp);
      fw.write(NUM_PROBS + ",1,BATCH OF QUESTIONS OF TYPE: " + PROB_TYPE+ "\n");
      for(int i=0; i<NUM_PROBS; i++) {
        fw.write(PROB_TYPE + "," + SRC_CODE_EXT + "\n");
      }
      fw.close();
    } catch (IOException e) {
      System.out.println("An error has occurred.");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    qzFileGenerator qzFG = new qzFileGenerator();
    qzFG.genInputFile();
  }
}
