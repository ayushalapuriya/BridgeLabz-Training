
import java.util.PriorityQueue;

public class BackupScheduler {

    private PriorityQueue<BackupTask> queue = new PriorityQueue<>();

    public void scheduleBackup(BackupTask task)
            throws InvalidBackupPathException {

        if (task == null) {
            throw new InvalidBackupPathException("Backup task cannot be null");
        }

        queue.offer(task);
        System.out.println("Backup task scheduled successfully.");
    }

    public void executeBackups() {
        System.out.println("Executing backup tasks...\n");

        while (!queue.isEmpty()) {
            BackupTask task = queue.poll();
            task.displayTask();
            System.out.println("Backup executed.\n");
        }
    }
}
