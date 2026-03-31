// Friend Linked List Node
class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

// User Linked List Node
class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

public class SocialMediaConnections {

    private UserNode head = null;
    private int size = 0;

    // Add User
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        newUser.next = head;
        head = newUser;
        size++;
    }

    // Search User by ID
    private UserNode searchById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search User by Name
    public void searchByName(String name) {
        UserNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("ID: " + temp.userId +
                        ", Name: " + temp.name +
                        ", Age: " + temp.age);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("User not found");
    }

    // Add Friend Connection
    public void addFriend(int userId, int friendId) {
        UserNode user = searchById(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friends;
        user.friends = newFriend;

        System.out.println("Friend added successfully");
    }

    // Remove Friend Connection
    public void removeFriend(int userId, int friendId) {
        UserNode user = searchById(userId);
        if (user == null || user.friends == null) {
            System.out.println("Friend not found");
            return;
        }

        FriendNode temp = user.friends;

        if (temp.friendId == friendId) {
            user.friends = temp.next;
            System.out.println("Friend removed successfully");
            return;
        }

        while (temp.next != null) {
            if (temp.next.friendId == friendId) {
                temp.next = temp.next.next;
                System.out.println("Friend removed successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Friend not found");
    }

    // Display Friends of a User
    public void displayFriends(int userId) {
        UserNode user = searchById(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friends;

        if (temp == null) {
            System.out.println("No friends");
            return;
        }

        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find Mutual Friends
    public void findMutualFriends(int userId1, int userId2) {
        UserNode u1 = searchById(userId1);
        UserNode u2 = searchById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Mutual Friends: ");
        boolean found = false;

        FriendNode f1 = u1.friends;
        while (f1 != null) {
            FriendNode f2 = u2.friends;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.print(f1.friendId + " ");
                    found = true;
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }

        if (!found)
            System.out.print("None");

        System.out.println();
    }

    // Count Friends for Each User
    public void countFriends() {
        UserNode temp = head;

        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friends;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends");
            temp = temp.next;
        }
    }

    // Display All Users
    public void displayUsers() {
        if (head == null) {
            System.out.println("No users available");
            return;
        }

        UserNode temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.userId +
                    ", Name: " + temp.name +
                    ", Age: " + temp.age);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaConnections sm = new SocialMediaConnections();

        sm.addUser(1, "Alice", 22);
        sm.addUser(2, "Bob", 24);
        sm.addUser(3, "Charlie", 21);
        sm.addUser(4, "David", 23);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);
        sm.addFriend(2, 4);

        System.out.println("\nAll Users:");
        sm.displayUsers();

        System.out.println("\nFriends of User 1:");
        sm.displayFriends(1);

        System.out.println("\nMutual Friends of User 1 and 2:");
        sm.findMutualFriends(1, 2);

        System.out.println("\nFriend Count:");
        sm.countFriends();

        System.out.println("\nRemoving Friend 3 from User 1:");
        sm.removeFriend(1, 3);

        System.out.println("\nFriends of User 1 After Removal:");
        sm.displayFriends(1);
    }
}
