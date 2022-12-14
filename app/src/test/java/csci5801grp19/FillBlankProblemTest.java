package csci5801grp19;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FillBlankProblemTest {
    @Test void  constructorTest() {
        FillBlankProblem p = new FillBlankProblem("python");
        
        assertEquals("python",p.langEx);
    }


    @Test void  attemptOpenFile(){
        FillBlankProblem p = new FillBlankProblem("python");
        int result = p.makeProblem("not a real path",0,0);
        assertEquals(1,result);
    }

    @Test void  OpenFile() {
        FillBlankProblem p = new FillBlankProblem("python");
        int result = p.makeProblem("src\\main\\resources\\source_code\\test_source_code\\primeNumber.py",0,0);
        assertEquals(0,result);
    }

    @Test void  iscomment() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "#comment";
        int result = p.categorizeToken(keyword);
        assertEquals(0,result);
    }

    @Test void  isKeyword() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "if";
        int result = p.categorizeToken(keyword);
        assertEquals(1,result);
    }

    @Test void  isArithmentic() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "+";
        int result = p.categorizeToken(keyword);
        assertEquals(2,result);
    }

    @Test void  isAssignment() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "=";
        int result = p.categorizeToken(keyword);
        assertEquals(3,result);
    }

    @Test void  isComparison() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "==";
        int result = p.categorizeToken(keyword);
        assertEquals(4,result);
    }

    @Test void  isBitwise() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "|";
        int result = p.categorizeToken(keyword);
        assertEquals(5,result);
    }

    @Test void  isOther() {
        FillBlankProblem p = new FillBlankProblem("python");
        String keyword = "variableName";
        int result = p.categorizeToken(keyword);
        assertEquals(6,result);
    }

    @Test void  toStringTest() {
        FillBlankProblem p = new FillBlankProblem("python");
        p.makeProblem("src\\main\\resources\\source_code\\test_source_code\\primeNumber.py",0,0);
        int result = p.writeOutput("src\\main\\resources\\source_code\\test_source_code\\output.py");
        assertEquals(0,result);
    }
}
