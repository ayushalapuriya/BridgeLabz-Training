
public class Main {

    public static void main(String[] args) {

        BackupScheduler scheduler = new BackupScheduler();

        try {
            BackupTask task1 = new BackupTask(
                    "C:/Projects",
                    "D:/Backup/Projects",
                    2,
                    false
            );

            BackupTask task2 = new BackupTask(
                    "C:/System",
                    "D:/Backup/System",
                    5,
                    true
            );

            BackupTask task3 = new BackupTask(
                    "C:/Documents",
                    "D:/Backup/Documents",
                    3,
                    false
            );

            scheduler.scheduleBackup(task1);
            scheduler.scheduleBackup(task2);
            scheduler.scheduleBackup(task3);

        } catch (InvalidBackupPathException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scheduler.executeBackups();
    }
}
