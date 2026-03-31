import java.time.LocalTime;

class TaskRunner extends Thread {
    TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000); // TIMED_WAITING
            for (int i = 0; i < 1000000; i++); // RUNNABLE
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class StateMonitor extends Thread {
    private Thread[] tasks;

    StateMonitor(Thread[] tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        boolean allDone;
        do {
            allDone = true;
            for (Thread t : tasks) {
                System.out.println("[Monitor] " + t.getName() +
                        " is in " + t.getState() +
                        " at " + LocalTime.now());
                if (t.getState() != State.TERMINATED) {
                    allDone = false;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!allDone);

        System.out.println("Summary: All tasks completed");
    }
}

public class ThreadStateDemo {
    public static void main(String[] args) {

        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        Thread[] tasks = { t1, t2 };

        StateMonitor monitor = new StateMonitor(tasks);

        monitor.start();
        t1.start();
        t2.start();
    }
}
