package csci5801grp19;
import java.io.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultChcProblemTest {
  File a = new File("app/src/main/resources/source_code");
  MultChcProblem test1 = new MultChcProblem(a);
  @Test void MultChcProblemHasAConstructor() {
    MultChcProblem test2 = new MultChcProblem(a);
    assertTrue(test2 instanceof MultChcProblem);
  }
  @Test void QuestionExists() {
    test1.question = "What is 3 x 4 ?";
    assertNotNull(test1.getQuestion(), "problem should contain a question");
  }
  @Test void SolutionExists() {
    String solutionA = "a = 12";
    String solutionB = "b = 4";
    String solutionC = "c = 9";
    String var = solutionA + "\n" + solutionB + "\n" + solutionC;
    String[] arr = var.split("\n");
    test1.solution = arr[0];
    assertNotNull(test1.getSolution(), "problem should contain an answer");
    assertEquals(arr[0], test1.solution);
  }
  @Test void OptionsExists() {
    String solutionA = "a = 12";
    String solutionB = "b = 4";
    String solutionC = "c = 9";
    String var = solutionA + "\n" + solutionB + "\n" + solutionC;
    test1.options = var;
    assertNotNull(test1.getOptions(), "problem should contain an option");
  }
  @Test void LangExists() {
    test1.langEx = "Java";
    assertNotNull(test1.getLangEx(), "problem should specify language");
  }
  @Test void printStr() {
    assertNotNull(test1.toString(), "problem is missing one or more components");
  }
}
