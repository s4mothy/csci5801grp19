package csci5801grp19;

public class Component {

  protected Mediator dialog;

  /**
   * General constructor for a component, where the dialog is passed and stored.
   * 
   * @param dialog The component's access to a mediator to communicate with other
   *               components.
   */
  public Component(Mediator dialog) {
    this.dialog = dialog;
  }

}
