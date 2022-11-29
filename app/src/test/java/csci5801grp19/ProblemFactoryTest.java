package csci5801grp19;
import java.io.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProblemFactoryTest {
  @Test void problemCreated() {
      File s = new File("app/src/main/resources/source_code");
      assertNotNull(ProblemFactory.createProblem("multiple choice", s), "createProblem should return a multiple choice problem.");
  }
}
