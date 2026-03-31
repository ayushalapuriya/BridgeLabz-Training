
public class BackupTask implements Comparable<BackupTask> {

    private String sourcePath;
    private String destinationPath;
    private int priority;
    private boolean critical;

    public BackupTask(String sourcePath, String destinationPath, int priority, boolean critical) {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
        this.priority = priority;
        this.critical = critical;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCritical() {
        return critical;
    }

    @Override
    public int compareTo(BackupTask other) {
        if (this.critical && !other.critical) return -1;
        if (!this.critical && other.critical) return 1;

        // Higher priority value first
        return Integer.compare(other.priority, this.priority);
    }

    public void displayTask() {
        System.out.println("Backup Task Details");
        System.out.println("Source: " + sourcePath);
        System.out.println("Destination: " + destinationPath);
        System.out.println("Priority: " + priority);
        System.out.println("Critical: " + critical);
        System.out.println("---------------------------");
    }
}
