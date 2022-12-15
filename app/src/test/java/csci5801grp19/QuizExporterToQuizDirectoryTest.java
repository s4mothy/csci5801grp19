package csci5801grp19;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class QuizExporterToQuizDirectoryTest {
  @Test void quizExporterHasConstructor() {
    SystemMediator m = new SystemMediator();
    QuizExporterToQuizDirectory qExp = new QuizExporterToQuizDirectory(m);
    assertTrue(qExp instanceof QuizExporterToQuizDirectory);
  }

  @Test void quizExporterGeneratesQuizDoc() {
    SystemMediator m = new SystemMediator();
    QuizExporterToQuizDirectory qExp = new QuizExporterToQuizDirectory(m);
    SystemFacade.qz_fname = "test";
    Quiz newQuiz = new Quiz("test title");
    qExp.exportQuiz(newQuiz);
    File qz = new File("src\\main\\resources\\quiz_export\\test_export.txt");
    assertTrue(qz.exists());
    if(qz.exists()) {
      qz.delete();
    }
  }
  
}
