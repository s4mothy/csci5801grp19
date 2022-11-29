package csci5801grp19;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SystemMediatorTest {
  @test void SystemMediatorHasConstructor() {
    SystemMediator sm = new SystemMediator();
    assertTrue(sm instanceof SystemMediator);
  }

  
}
