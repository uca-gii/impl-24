package example.dependencyinjection;

public class ServiceB implements MainService {
    @Override
    public void execute () {
        System.out.println("Executing Service B");
    }
    
}
