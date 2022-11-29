package csci5801grp19;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuizGeneratorTest {
  SystemMediator m = new SystemMediator();
  QuizGenerator qGen = new QuizGenerator(m);
  @Test void quizGeneratorHasConstructor() {
    QuizGenerator qExp = new QuizGenerator(new SystemMediator());
    assertTrue(qExp instanceof QuizGenerator);
  }
  @Test void quizExists() {
    assertNotNull(qGen.getQuiz(), "no quiz currently stored.");
    
  }
  @Test void quizDoesNotExist() {
    assertEquals(qGen.getQuiz(), null);
    
  }
  @Test void quizGenerated() {
    assertNotNull(qGen.generateQuiz(), "no quiz currently generated.");
  }
  @Test void quizNotGenerated() {
    assertEquals(qGen.generateQuiz(), null);
  }
  
}
