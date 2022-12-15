package csci5801grp19;

import org.checkerframework.checker.lock.qual.MayReleaseLocks;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class FillBlankProblemTest {
    @Test
    void constructorTest() {
        FillBlankProblem p = new FillBlankProblem("python");

        assertEquals("python", p.langEx);
    }

    @Test
    void attemptOpenFile() {
        FillBlankProblem p = new FillBlankProblem("python");
        String filePath = "not a real path";
        File myFile = new File(filePath);
        int result = p.makeProblem(myFile, 0);
        assertEquals(1, result);
    }

    @Test
    void OpenFile() {
        FillBlankProblem p = new FillBlankProblem("python");
        String filePath = "src\\main\\resources\\source_code\\test_source_code\\primeNumber.py";
        File myFile = new File(filePath);
        int result = p.makeProblem(myFile, 0);
        assertEquals(0, result);
    }

    @Test
    void iscomment() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "#comment";
        int result = p.categorizeToken(keyword);
        assertEquals(0, result);
    }

    @Test
    void isKeyword() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "if";
        int result = p.categorizeToken(keyword);
        assertEquals(1, result);
    }

    @Test
    void isArithmentic() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "+";
        int result = p.categorizeToken(keyword);
        assertEquals(2, result);
    }

    @Test
    void isAssignment() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "=";
        int result = p.categorizeToken(keyword);
        assertEquals(3, result);
    }

    @Test
    void isComparison() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "==";
        int result = p.categorizeToken(keyword);
        assertEquals(4, result);
    }

    @Test
    void isBitwise() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "|";
        int result = p.categorizeToken(keyword);
        assertEquals(5, result);
    }

    @Test
    void isOther() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "variableName";
        int result = p.categorizeToken(keyword);
        assertEquals(6, result);
    }

    @Test
    void getFileSpecsTest() {
        FillBlankProblem p = new FillBlankProblem("python");
        File myFile;
        String filePath = "src\\main\\resources\\source_code\\test_source_code\\getFileSpecsTest.py";

        myFile = new File(filePath);
            

        int[] expected = {8, 1, 3, 2, 0, 94};
        int[] actual = p.getFileSpecs(myFile);

        assertEquals(expected[0], actual[0]);
    }

    @Test
    void toStringTest() {
        String filePath = "src\\main\\resources\\source_code\\test_source_code\\primeNumber.py";
        File myFile = new File(filePath);
        FillBlankProblem p = new FillBlankProblem(myFile);
        int result = p.writeOutput("src\\main\\resources\\source_code\\test_source_code\\output.py");
        assertEquals(0, result);
    }
}
