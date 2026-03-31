
class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    ProcessNode next;

    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinSchedulingAlgorithm {

    private ProcessNode head = null;
    private ProcessNode tail = null;
    private int size = 0;

    // Add process at end (circular)
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode node = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = tail = node;
            node.next = head; // circular
        } else {
            tail.next = node;
            tail = node;
            tail.next = head; // maintain circularity
        }
        size++;
        System.out.println("Process added: ID " + processId);
    }

    // Remove process by ID (after execution)
    public void removeProcess(int processId) {
        if (head == null) return;

        ProcessNode curr = head;
        ProcessNode prev = tail;
        int count = 0;

        while (count < size) {
            if (curr.processId == processId) {
                if (curr == head) head = head.next;
                if (curr == tail) tail = prev;
                prev.next = curr.next;
                size--;
                System.out.println("Process removed: ID " + processId);
                return;
            }
            prev = curr;
            curr = curr.next;
            count++;
        }
    }

    // Display current processes in circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        System.out.println("Processes in Circular Queue:");
        ProcessNode temp = head;
        int count = 0;
        while (count < size) {
            System.out.println("ID: " + temp.processId + ", Burst Time: " + temp.burstTime +
                               ", Remaining Time: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
            count++;
        }
    }

    // Simulate round-robin scheduling
    public void roundRobin(int timeQuantum) {
        if (head == null) return;

        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processed = 0;

        // Store initial burst times
        int[] waitingTimes = new int[size];
        int[] turnAroundTimes = new int[size];
        ProcessNode[] nodes = new ProcessNode[size];

        // Flatten circular list into array for calculation
        ProcessNode temp = head;
        for (int i = 0; i < size; i++) {
            nodes[i] = temp;
            temp = temp.next;
        }

        boolean done;
        do {
            done = true;
            System.out.println("\n--- New Round ---");

            for (int i = 0; i < size; i++) {
                if (nodes[i].remainingTime > 0) {
                    done = false;
                    int execTime = Math.min(nodes[i].remainingTime, timeQuantum);
                    System.out.println("Process " + nodes[i].processId + " executed for " + execTime + " units");
                    nodes[i].remainingTime -= execTime;

                    // Increase waiting time for other processes
                    for (int j = 0; j < size; j++) {
                        if (j != i && nodes[j].remainingTime > 0) {
                            waitingTimes[j] += execTime;
                        }
                    }
                }
            }

            displayProcesses();

        } while (!done);

        // Calculate turn-around time
        for (int i = 0; i < size; i++) {
            turnAroundTimes[i] = waitingTimes[i] + nodes[i].burstTime;
            totalWaitingTime += waitingTimes[i];
            totalTurnAroundTime += turnAroundTimes[i];
        }

        System.out.println("\nAverage Waiting Time: " + ((double) totalWaitingTime / size));
        System.out.println("Average Turn-Around Time: " + ((double) totalTurnAroundTime / size));
    }

    // Demo
    public static void main(String[] args) {
        RoundRobinSchedulingAlgorithm rr = new RoundRobinSchedulingAlgorithm();

        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 5, 2);
        rr.addProcess(3, 8, 3);

        System.out.println("\nInitial Processes:");
        rr.displayProcesses();

        int timeQuantum = 4;
        System.out.println("\n--- Starting Round Robin Scheduling (Time Quantum = " + timeQuantum + ") ---");
        rr.roundRobin(timeQuantum);
    }
}
