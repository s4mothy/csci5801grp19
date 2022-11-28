package csci5801grp19;

public class SystemMediator implements Mediator {
  private AbstractProblemDatabaseHandler pHandler;
  private AbstractSourceCodeHandler sHandler;
  private QuizGenerator qzGen;
  private AbstractQuizExporter qzExport;

  public SystemMediator() {
    this.pHandler = new RandomGrabProbDatabaseHandler(this);
    this.sHandler = new RandomSourceCodeHandler(this);
    this.qzGen = new QuizGenerator(this);
    this.qzExport = new QuizExporterToQuizDirectory(this);
  }

  public void notify(Component sender, String event) {
    if(sender instanceof AbstractProblemDatabaseHandler) {
      reactOnPHandler(event);
      return;
    }
    if(sender instanceof AbstractSourceCodeHandler) {
      reactOnSHandler(event);
      return;
    }
    if(sender instanceof QuizGenerator) {
      reactOnQZGen(event);
      return;
    }
    if(sender instanceof AbstractQuizExporter) {
      reactOnQZExport(event);
      return;
    }
  }

  public void reactOnPHandler(String event) {
    if(event.equals("AddToQuiz")) {
      // TBD
    return;
    }
  }

  public void reactOnSHandler(String event) {
    // stub for future use
  }

  public void reactOnQZGen(String event) {
    if(event.equals("ChkSrcCode")) {
      // TBD
    return;
    }
    
    if(event.equals("ChkProbDB")) {
      // TBD
    return;
    }

    if(event.equals("PullMCProb")) {
      // TBD
    return;
    }

    if(event.equals("PullOrderProb")) {
      // TBD
    return;
    }

    if(event.equals("GenMCProb")) {
      AbstractProblem newOrderingProb = ProblemFactory.createProblem("MultipleChoice",
            this.sHandler.ingestNewSC(".py"));
      // qzGen.getQuiz().getQuestions().add(newOrderingProb);
    return;
    }

    if(event.equals("GenOrderProb")) {
      AbstractProblem newOrderingProb = ProblemFactory.createProblem("Ordering",
            this.sHandler.ingestNewSC(".py"));
      // qzGen.getQuiz().getQuestions().add(newOrderingProb);
    return;
    }

    if(event.equals("ExportQuiz")) {
      // TBD
    return;
    }
  }

  public void reactOnQZExport(String event) {
    // stub for future use
  }

}
