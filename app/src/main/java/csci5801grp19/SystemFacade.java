package csci5801grp19;

public class SystemFacade {
  private SystemFacade instance;

  public SystemFacade getInstance() {
    if(instance == null) {
      instance = new SystemFacade();
    }
    return instance;
  }

}
