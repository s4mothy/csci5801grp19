package csci5801grp19;
import java.io.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuizTest {
File s = new File("app/src/main/resources/source_code");
  Quiz quiz = new Quiz("Quiz is multiple choice, with a time limit of 20 minutes.");
  @Test void QuizExists() {
    Quiz testQuiz = new Quiz("Quiz is multiple choice, with a time limit of 20 minutes.");
    assertTrue(testQuiz instanceof Quiz);
  }
  @Test void QuizQuestionsExists() {
    assertNotNull(quiz.getQuestions(), "questions list should not be empty.");
  }
  @Test void QuizInfoExists() {
    assertNotNull(quiz.getQuizInfo(), "quiz information should be specified.");
  }
  @Test void QuiztoString() {
    assertNotNull(quiz.toString(), "quiz info and/or quiz questions are missing.");
  }
}
