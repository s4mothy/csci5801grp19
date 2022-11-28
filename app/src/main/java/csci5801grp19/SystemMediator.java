package csci5801grp19;

public class SystemMediator implements Mediator {
  private AbstractProblemDatabaseHandler pHandler;
  private AbstractSourceCodeHandler sHandler;
  private QuizGenerator qzGen;
  private AbstractQuizExporter qzExport;

  public SystemMediator() {
    this.pHandler = new RandomGrabProbDatabaseHandler();
    this.sHandler = new RandomSourceCodeHandler();
    this.qzGen = new QuizGenerator();
    this.qzExport = new QuizExporterToQuizDirectory();
    // this.pHandler.init(this);
    // this.sHandler.init(this);
    // this.qzGen.init(this);
    // this.qzExport.init(this);
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

    if(event.equals("PullOrderProb")) {
      // TBD
    return;
    }

    if(event.equals("GenOrderProb")) {
      //TODO
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
