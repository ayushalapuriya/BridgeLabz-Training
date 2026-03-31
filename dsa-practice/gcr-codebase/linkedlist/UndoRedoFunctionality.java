// Text State Node (Doubly Linked List Node)
class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class UndoRedoFunctionality {

    // Pointers for Undo-Redo List
    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;

    // History Size
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add New Text State
    public void addState(String content) {

        if (current != null && current.next != null) {
            current.next = null;
            tail = current;
            size = calculateSize();
        }

        TextState newState = new TextState(content);

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        // Add State at End
        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;

        // Maintain Maximum History Limit
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo Operation
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo");
            return;
        }
        current = current.prev;
    }

    // Redo Operation
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo");
            return;
        }
        current = current.next;
    }

    // Display Current Text State
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("Text is empty");
            return;
        }
        System.out.println("Current Text: " + current.content);
    }

    // Calculate Total Number of States
    private int calculateSize() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {

        UndoRedoFunctionality editor = new UndoRedoFunctionality();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World!!");

        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello World!!!");
        editor.displayCurrentState();
    }
}
