package csci5801grp19;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuizExporterToQuizDirectoryTest {
  @Test void quizExporterHasConstructor() {
    SystemMediator m = new SystemMediator();
    QuizExporterToQuizDirectory qExp = new QuizExporterToQuizDirectory(m);
    assertTrue(qExp instanceof QuizExporterToQuizDirectory);
  }
  
}
