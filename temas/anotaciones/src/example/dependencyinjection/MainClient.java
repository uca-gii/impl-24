package example.dependencyinjection;

public class MainClient {
    @InjectService(ServiceA.class)
    private MainService service;

    public void executeService() {
        service.execute();
    }
}
