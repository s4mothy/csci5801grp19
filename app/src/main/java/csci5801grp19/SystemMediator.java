package csci5801grp19;

import java.util.*;

public class SystemMediator implements Mediator {
  private AbstractProblemDatabaseHandler pHandler;
  private AbstractSourceCodeHandler sHandler;
  private QuizGenerator qzGen;
  private AbstractQuizExporter qzExport;

  /**
   * Constructor for SystemMediator, where each component it mediates
   * between is instantiated.
   */
  public SystemMediator() {
    this.pHandler = new RandomGrabProbDatabaseHandler(this);
    this.sHandler = new RandomSourceCodeHandler(this);
    this.qzGen = new QuizGenerator(this);
    this.qzExport = new QuizExporterToQuizDirectory(this);
  }

  /**
   * Functioned used by components to communicate intended outcomes
   * they wish the mediator to handle.
   * 
   * @param sender The component utilizing notify to send the request.
   * @param event  The specific details of the request from the sender.
   */
  public void notify(Component sender, String event) {
    if (sender instanceof AbstractProblemDatabaseHandler) {
      reactOnPHandler(event);
      return;
    }
    if (sender instanceof AbstractSourceCodeHandler) {
      reactOnSHandler(event);
      return;
    }
    if (sender instanceof QuizGenerator) {
      reactOnQZGen(event);
      return;
    }
    if (sender instanceof AbstractQuizExporter) {
      reactOnQZExport(event);
      return;
    }
  }

  /**
   * Method defining how the mediator would handle requests coming from the
   * problem database
   * handler, currently considered for a transferring information to the quiz in
   * quiz generator.
   * 
   * @param event The specific event being requested by the
   *              problem database handler.
   */
  public void reactOnPHandler(String event) {
    if (event.equals("AddToQuiz")) {
      // TBD
      return;
    }
  }

  /**
   * Method defining how the mediator would handle requests coming from the source
   * code
   * handler, currently just a stub, here in consideration of future usage.
   * 
   * @param event The specific event being requested by the source code handler.
   */
  public void reactOnSHandler(String event) {
    // stub for future use
  }

  /**
   * Method defining how the mediator handles requests coming from the quiz
   * generator,
   * where most requests come from. Range from requests for database quantities,
   * to generated problems, to requests for reused problems, to quiz generation
   * itself.
   * 
   * @param event The specific event being requested by the quiz generator.
   */
  public void reactOnQZGen(String event) {
    if (event.equals("ChkSrcCode")) {
      // TBD
      return;
    }

    if (event.equals("ChkProbDB")) {
      // TBD
      return;
    }

    if (event.equals("PullMCProb")) {
      // TBD
      return;
    }

    if (event.equals("PullOrderProb")) {
      // TBD
      return;
    }

    if (event.equals("GenMCProb")) {
      AbstractProblem newMultChcProb = ProblemFactory.createProblem("multiple choice",
          this.sHandler.ingestNewSC(".py"));
      qzGen.getQuiz().getQuestions().add(newMultChcProb);
      pHandler.storeProbInDB(newMultChcProb);
      return;
    }

    if (event.equals("GenOrderProb")) {
      AbstractProblem newOrderingProb = ProblemFactory.createProblem("ordering",
          this.sHandler.ingestNewSC(".py"));
      qzGen.getQuiz().getQuestions().add(newOrderingProb);
      pHandler.storeProbInDB(newOrderingProb);
      return;
    }

    if (event.equals("GenerateQuiz")) {
      qzGen.generateQuiz();
      return;
    }

    if (event.equals("ExportQuiz")) {
      // TEMPORARY USE AS MEANS TO PRINT PROBLEMS
      System.out.println(qzGen.getQuiz());
      return;
    }
  }

  /**
   * Method defining how the mediator would handle requests coming from the quiz
   * exporter, currently just a stub, here in consideration of future usage.
   * 
   * @param event The specific event being requested by the quiz exporter.
   */
  public void reactOnQZExport(String event) {
    // stub for future use
  }

}
