// Use of circular linked list 
class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(int itemId,String itemName,int quantity,double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagementSystem {

    ItemNode head = null;
    int size = 0;

    // Add at beginning
    public void addAtBeginning(ItemNode node) {
        node.next = head;
        head = node;
        size++;
    }

    // Add at end
    public void addAtEnd(ItemNode node) {
        if(head == null) {
            head = node;
        }
        else {
            ItemNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    // Add at specific position
    public void addAtPosition(ItemNode node,int pos) {
        if(pos < 0 || pos > size) {
            System.out.println("Invalid position");
            return;
        }

        if(pos == 0) {
            addAtBeginning(node);
            return;
        }

        ItemNode temp = head;
        for(int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }

    // Remove item by ID
    public void removeByItemId(int itemId) {
        if(head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        if(head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed");
            size--;
            return;
        }

        ItemNode temp = head;
        while(temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed");
            size--;
        }
    }

    // Update quantity by item ID
    public void updateQuantity(int itemId,int newQuantity) {
        ItemNode temp = head;

        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Search by ID or Name
    public void searchItem(int itemId, String itemName) {
        ItemNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemId == itemId || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println(
                        "ID: " + temp.itemId +
                        ", Name: " + temp.itemName +
                        ", Qty: " + temp.quantity +
                        ", Price: " + temp.price
                );
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found");
    }

    // Display inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("No items in inventory");
            return;
        }

        ItemNode temp = head;
        while (temp != null) {
            System.out.println(
                    "ID: " + temp.itemId +
                    ", Name: " + temp.itemName +
                    ", Qty: " + temp.quantity +
                    ", Price: " + temp.price
            );
            temp = temp.next;
        }
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double total = 0;
        ItemNode temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }


    // Sort by name
    public void sortByName(boolean ascending) {
        head = mergeSortByName(head, ascending);
    }

    // Sort by price
    public void sortByPrice(boolean ascending) {
        head = mergeSortByPrice(head, ascending);
    }

    private ItemNode mergeSortByName(ItemNode node, boolean asc) {
        if (node == null || node.next == null)
            return node;

        ItemNode mid = getMiddle(node);
        ItemNode nextMid = mid.next;
        mid.next = null;

        ItemNode left = mergeSortByName(node, asc);
        ItemNode right = mergeSortByName(nextMid, asc);

        return mergeByName(left, right, asc);
    }

    private ItemNode mergeByName(ItemNode a, ItemNode b, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        if ((asc && a.itemName.compareToIgnoreCase(b.itemName) <= 0) ||
            (!asc && a.itemName.compareToIgnoreCase(b.itemName) > 0)) {
            a.next = mergeByName(a.next, b, asc);
            return a;
        } else {
            b.next = mergeByName(a, b.next, asc);
            return b;
        }
    }

    private ItemNode mergeSortByPrice(ItemNode node, boolean asc) {
        if (node == null || node.next == null)
            return node;

        ItemNode mid = getMiddle(node);
        ItemNode nextMid = mid.next;
        mid.next = null;

        ItemNode left = mergeSortByPrice(node, asc);
        ItemNode right = mergeSortByPrice(nextMid, asc);

        return mergeByPrice(left, right, asc);
    }

    private ItemNode mergeByPrice(ItemNode a, ItemNode b, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        if ((asc && a.price <= b.price) || (!asc && a.price > b.price)) {
            a.next = mergeByPrice(a.next, b, asc);
            return a;
        } else {
            b.next = mergeByPrice(a, b.next, asc);
            return b;
        }
    }

    private ItemNode getMiddle(ItemNode node) {
        ItemNode slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Main method (demo)
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addAtEnd(new ItemNode(1, "Laptop", 5, 60000));
        ims.addAtEnd(new ItemNode(2, "Mouse", 20, 500));
        ims.addAtEnd(new ItemNode(3, "Keyboard", 15, 1500));
        ims.addAtBeginning(new ItemNode(4, "Monitor", 7, 12000));

        System.out.println("Inventory:");
        ims.displayInventory();

        ims.calculateTotalValue();

        System.out.println("\nSort by Name (Ascending):");
        ims.sortByName(true);
        ims.displayInventory();

        System.out.println("\nSort by Price (Descending):");
        ims.sortByPrice(false);
        ims.displayInventory();

        System.out.println("\nSearch Item:");
        ims.searchItem(2, "Mouse");

        ims.updateQuantity(1, 10);
        ims.removeByItemId(3);

        System.out.println("\nFinal Inventory:");
        ims.displayInventory();
    }
}
