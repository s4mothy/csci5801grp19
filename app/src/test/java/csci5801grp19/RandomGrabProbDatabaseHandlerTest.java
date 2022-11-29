package csci5801grp19;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
public class RandomGrabProbDatabaseHandlerTest {
  SystemMediator m = new SystemMediator();
  RandomGrabProbDatabaseHandler test = new RandomGrabProbDatabaseHandler(m);
  @Test void ProbDatabaseHandlerExists() {
    RandomGrabProbDatabaseHandler rand = new RandomGrabProbDatabaseHandler(new SystemMediator());
    assertTrue(rand instanceof RandomGrabProbDatabaseHandler);
  }
  @Test void retrieveProblemFromDB() {
    AbstractProblem res = test.getProbFromDB("multiple choice");
    assertNotNull(res, "no type specified.");

  }
  @Test void incorrectTypeFormat() {
    AbstractProblem wrong_res = test.getProbFromDB("");
    assertEquals(wrong_res, null);

  }
  
  
}
