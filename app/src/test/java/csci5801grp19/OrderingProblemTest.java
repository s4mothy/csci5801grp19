package csci5801grp19;
import java.io.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderingProblemTest {
  
  @Test void OrderingProblemHasAConstructor() {
      File s = new File("app/src/main/resources/source_code");
      OrderingProblem ord = new OrderingProblem(s);
      assertTrue(ord instanceof OrderingProblem);
  }
  @Test void NoFile() {
    File st = new File("");
    OrderingProblem ordTest = new OrderingProblem(st);
    fail("No file found");
  }
  @Test void IncorrectParameter() {
    File f = new File("home/tests/test1");
    OrderingProblem ordTest = new OrderingProblem(f);
    fail("Incorrect file specifications");
  }
}
