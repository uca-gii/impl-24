package main.java;

public class UserManager {
    private UserManager userManager;
    private User testUser;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
        testUser = new User("TestUser", 50);
    }

    User getCurrentUser() {
        System.out.println("Accessing user data");
        return testUser;
    }

    void setCurrentUser(User user) {
        System.out.println("Updating user data");
        testUser = user;
    }

    void deleteUser() {
        System.out.println("Deleting user data");
        testUser = null;
    }

    @Test
    void testGetCurrentUser() {
        userManager.setCurrentUser(testUser);
        Assertions.assertEquals(testUser, userManager.getCurrentUser(),
                "getCurrentUser should return the currently set user");
    }

    @Test
    void testSetCurrentUser() {
        userManager.setCurrentUser(testUser);
        Assertions.assertEquals(testUser, userManager.getCurrentUser(),
                "setCurrentUser should set the user correctly");
    }

    @Test
    void testDeleteUser() {
        userManager.setCurrentUser(testUser);
        userManager.deleteUser();
        Assertions.assertNull(userManager.getCurrentUser(),
                "deleteUser should set currentUser to null");
    }
}


