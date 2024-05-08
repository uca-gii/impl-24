package main.java;

public class UserManager {
    private User currentUser;

    User getCurrentUser() {
        System.out.println("Accessing user data");
        return currentUser;
    }

    void setCurrentUser(User user) {
        System.out.println("Updating user data");
        currentUser = user;
    }

    void deleteUser() {
        System.out.println("Deleting user data");
        currentUser = null;
    }
}

