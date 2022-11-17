package csci5801grp19;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PPALMS_SystemTest {
    @Test void PPALMS_SystemHasAGreeting() {
        PPALMS_System classUnderTest = new PPALMS_System();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
