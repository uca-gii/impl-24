import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class tests {
    
    @Test
    void testSetNameAndGetters() {
        User user = new User();
        user.setName("John Doe");
        assertEquals("John Doe", user.getName(), "The name should be set and retrieved correctly.");
    }

    @Test
    void testSetAgeAndGetters() {
        User user = new User();
        user.setAge(25);
        assertEquals(25, user.getAge(), "The age should be set and retrieved correctly.");
    }
}
