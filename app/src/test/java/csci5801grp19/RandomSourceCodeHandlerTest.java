package csci5801grp19;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
public class RandomSourceCodeHandlerTest {
  SystemMediator m = new SystemMediator();
  RandomSourceCodeHandler srcHandlerTest = new RandomSourceCodeHandler(m);
  @Test void SourceCodeHandlerHasConstructor() {
    RandomSourceCodeHandler srcHandler = new RandomSourceCodeHandler(new SystemMediator());
    assertTrue(srcHandler instanceof RandomSourceCodeHandler);
  }
  @Test void ingestingSRC() {
    File res = srcHandlerTest.ingestNewSC(".py");
    assertNotNull(res, "extension not properly stated");
  }
  @Test void incorrectExtension() {
    File res = srcHandlerTest.ingestNewSC(".sl");
    assertNull(res, "extension should not be valid");
  }
  
  
}
