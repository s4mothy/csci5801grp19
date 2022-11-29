package csci5801grp19;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SystemFacadeTest {
  @Test void fileNotFound() {
    SystemFacade facade = SystemFacade.getInstance();
    int response = facade.getInput("not a real path");
    assertEquals(1,response);
  }

  @Test void fileEmpty() {
    SystemFacade facade = SystemFacade.getInstance();
    String path = System.getProperty("user.dir");
    int response = facade.getInput(path + "/src/main/resources/quiz_input/tests/test1");
    assertEquals(2,response);
  }

  @Test void badHeader() {
    SystemFacade facade = SystemFacade.getInstance();
    String path = System.getProperty("user.dir");
    int response = facade.getInput(path + "/src/main/resources/quiz_input/tests/test2");
    assertEquals(3,response);
  }

  @Test void badHeaderNumbers() {
    SystemFacade facade = SystemFacade.getInstance();
    String path = System.getProperty("user.dir");
    int response = facade.getInput(path + "/src/main/resources/quiz_input/tests/test3");
    assertEquals(4,response);
  }

  @Test void tooFewQuestions() {
    SystemFacade facade = SystemFacade.getInstance();
    String path = System.getProperty("user.dir");
    int response = facade.getInput(path + "/src/main/resources/quiz_input/tests/test4");
    assertEquals(5,response);
  }

  @Test void unsupportedType() {
    SystemFacade facade = SystemFacade.getInstance();
    String path = System.getProperty("user.dir");
    int response = facade.getInput(path + "/src/main/resources/quiz_input/tests/test5");
    assertEquals(6,response);
  }

  @Test void unsupportedLanguage() {
    SystemFacade facade = SystemFacade.getInstance();
    String path = System.getProperty("user.dir");
    int response = facade.getInput(path + "/src/main/resources/quiz_input/tests/test6");
    assertEquals(7,response);
  }


}
