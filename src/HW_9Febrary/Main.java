package HW_9Febrary;

public class Main {

    private static Stack stack;

    public static void main(String args[]) {
        stack = new Stack();
        addElements();
        checkStack();
    }

    private static void printInfo() {
        System.out.println("Current size: " + stack.size());
        System.out.println("Start " + stack.peek().toString() + ", wait...");
    }

    private static void addElements() {
        for (int i = 1; i <= 5; i++) stack.add(new Task("Task " + i));
    }

    private static void checkStack() {
        while (stack.size() != 0) {
            if (!Task.isRunning()) {
                printInfo();
                Task task = (Task) stack.pop();
                System.out.println(task.toString() + " complete!");
                task.run();
            }
        }
        System.out.println("All Tasks were complete");
    }
}
