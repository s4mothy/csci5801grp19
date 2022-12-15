package csci5801grp19;

import java.io.*;

public abstract class AbstractProblem implements Serializable {

  protected String question;
  protected String options;
  protected String solution;
  protected String langEx;

  /**
   * Getter for part of the problem including question and modified code.
   * 
   * @return stored question section string.
   */
  public String getQuestion() {
    return this.question;
  }

  /**
   * Getter for part of the problem including the options the answerer chooses
   * from.
   * 
   * @return stored options section string.
   */
  public String getOptions() {
    return this.options;
  }

  /**
   * Getter for the solution to the problem.
   * 
   * @return stored problem solution string.
   */
  public String getSolution() {
    return this.solution;
  }

  /**
   * Getter for language extension of the source code the problem was made from.
   * 
   * @return String of language extension for source code.
   */
  public String getLangEx() {
    return this.langEx;
  }

  /**
   * Returns String of problem, which consist of three blocks of text;
   * question on top, options in middle, solution bottom.
   */
  public String toString() {
    String str = "QUESTION: \n";
    str += this.question + "\n";
    str += "OPTIONS: \n";
    str += this.options + "\n";
    str += "SOLUTION: \n";
    str += this.solution + "\n";

    return str;
  }

  public String hello(){
    return "hello";
  }

}
