package HW_9Febrary;

/**
 * Created by Timbaev on 15.02.2017.
 * Heavy task
 */
public class Task implements Runnable {

    private static boolean isRunning;
    private String name;

    public Task(String name) {
        this.name = name;
        isRunning = false;
    }


    public static boolean isRunning() {
        return isRunning;
    }

    @Override
    public void run() {
        isRunning = true;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            isRunning = false;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
