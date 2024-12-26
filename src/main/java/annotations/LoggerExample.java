package annotations;

public class LoggerExample {

    @Log
    public void doWork() {
        System.out.println("Working INFO...");
    }

    @Log(level = "DEBUG")
    public void doDebugWork() {
        System.out.println("Working DEBUG...");
    }
}