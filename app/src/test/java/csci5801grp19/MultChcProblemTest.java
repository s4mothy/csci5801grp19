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
  @Test void QuestionDoesNotExist() {
    test1.question = "";
    assertEquals(test1.getQuestion(), "");
  }
  @Test void SolutionExists() {
    String solutionA = "a = 12";
    String solutionB = "b = 4";
    String solutionC = "c = 9";
    String var = solutionA + "\n" + solutionB + "\n" + solutionC;
    String[] arr = var.split("\n");
    test1.solution = arr[0];
    assertNotNull(test1.getSolution(), "problem should contain an answer");
    assertEquals(test1.getSolution(), arr[0]);
  }
  @Test void SolutionDoesNotExist() {
    String solutionA = "a = 15";
    String solutionB = "b = 4";
    String solutionC = "c = 9";
    String var = solutionA + "\n" + solutionB + "\n" + solutionC;
    String[] arr = var.split("\n");
    test1.solution = arr[0];
    assertNotNull(test1.getSolution(), "problem should contain an answer");
    assertNotEquals(test1.getSolution(), "12");
  }
  @Test void SolutionIsIncorrect() {
    String solutionA = "a = 12";
    String solutionB = "b = 4";
    String solutionC = "c = 9";
    String var = solutionA + "\n" + solutionB + "\n" + solutionC;
    String[] arr = var.split("\n");
    test1.solution = arr[1];
    assertNotNull(test1.getSolution(), "problem should contain an answer");
    assertNotEquals(test1.getSolution(), "a = 12");
  }
  @Test void OptionsExists() {
    String solutionA = "a = 12";
    String solutionB = "b = 4";
    String solutionC = "c = 9";
    String var = solutionA + "\n" + solutionB + "\n" + solutionC;
    test1.options = var;
    assertNotNull(test1.getOptions(), "problem should contain an option");
  }
  @Test void OptionsDoNotExist() {
    String solutionA = "";
    String solutionB = "";
    String solutionC = "";
    String var = solutionA + solutionB + solutionC;
    test1.options = var;
    assertEquals(test1.getOptions(), "");
  }
  @Test void LangExists() {
    test1.langEx = "Java";
    assertNotNull(test1.getLangEx(), "problem should specify language");
  }
  @Test void printStr() {
    assertNotNull(test1.toString(), "problem is missing one or more components");
  }
}
