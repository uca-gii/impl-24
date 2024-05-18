package example.dependencyinjection;

public class ServiceA implements MainService {
    @Override
    public void execute() {
        System.out.println("Executing Service A");
    }
    
}
