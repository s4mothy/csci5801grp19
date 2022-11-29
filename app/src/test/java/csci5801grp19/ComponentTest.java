package csci5801grp19;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComponentTest {
  @Test void ComponentConstructorHasAMediator() {
    Mediator med = new SystemMediator();
    Component comp = new Component(med);
    assertTrue(comp.dialog instanceof Mediator);
  }
}
