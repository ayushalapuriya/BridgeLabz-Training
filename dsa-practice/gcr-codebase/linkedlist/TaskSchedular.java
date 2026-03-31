// Use of circular linked list 
class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskSchedular {

    TaskNode head = null;
    TaskNode tail = null;
    TaskNode current = null;
    int size = 0;

    // Add at beginning
    public void addAtBeginning(TaskNode node) {
        if (head == null) {
            head = tail = node;
            node.next = head;
        } else {
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
    }

    // Add at end
    public void addAtEnd(TaskNode node) {
        if (head == null) {
            head = tail = node;
            node.next = head;
        } else {
            tail.next = node;
            tail = node;
            tail.next = head;
        }
        size++;
    }

    // Add at specific position
    public void addAtPosition(TaskNode node, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 0) {
            addAtBeginning(node);
            return;
        }

        if (pos == size) {
            addAtEnd(node);
            return;
        }

        TaskNode temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }

    // Remove task by ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = tail;

        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                size--;
                System.out.println("Task removed");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found");
    }

    // View current task & move to next
    public void viewCurrentAndMoveNext() {
        if (current == null) {
            current = head;
        }

        if (current == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println(
            "Task ID: " + current.taskId +
            ", Name: " + current.taskName +
            ", Priority: " + current.priority +
            ", Due: " + current.dueDate
        );

        current = current.next;
    }

    // Display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display");
            return;
        }

        TaskNode temp = head;
        do {
            System.out.println(
                "Task ID: " + temp.taskId +
                ", Name: " + temp.taskName +
                ", Priority: " + temp.priority +
                ", Due: " + temp.dueDate
            );
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println(
                    "Task ID: " + temp.taskId +
                    ", Name: " + temp.taskName +
                    ", Due: " + temp.dueDate
                );
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No task with given priority found");
    }

    // Main method
    public static void main(String[] args) {
        TaskSchedular ts = new TaskSchedular();

        ts.addAtEnd(new TaskNode(1, "Assignment", 1, "10-Apr"));
        ts.addAtEnd(new TaskNode(2, "Project", 2, "20-Apr"));
        ts.addAtBeginning(new TaskNode(3, "Exam Prep", 1, "05-Apr"));

        System.out.println("All Tasks:");
        ts.displayTasks();

        System.out.println("\nCurrent Task Cycle:");
        ts.viewCurrentAndMoveNext();
        ts.viewCurrentAndMoveNext();
        ts.viewCurrentAndMoveNext();

        System.out.println("\nSearch Priority 1:");
        ts.searchByPriority(1);

        ts.removeByTaskId(2);

        System.out.println("\nAfter Removal:");
        ts.displayTasks();
    }
}
