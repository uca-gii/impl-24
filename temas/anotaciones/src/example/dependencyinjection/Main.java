package example.dependencyinjection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        MainClient client = new MainClient();
        DependencyInjector.injectDependencies(client);
        client.executeService();
    }
}
