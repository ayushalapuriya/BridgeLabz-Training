import java.util.Scanner;

public class CafeteriaMenuApp {

    // Array to store 10 menu items
    static String[] menuItems = {"Burger","Pizza","Pasta","Sandwich","Salad","Fries","Coffee","Tea","Juice","Ice Cream"};

    // Method to display menu with index numbers
    public static void displayMenu(){
        System.out.println("----- Cafeteria Menu -----");
        for(int i=0; i<menuItems.length; i++){
            System.out.println(i + ". " + menuItems[i]);
        }
    }

    // Method to get item by index
    public static String getItemByIndex(int index){
        if(index >= 0 && index < menuItems.length){
            return menuItems[index];
        } else {
            return "Invalid selection!";
        }
    }

    // Main method to run the app
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Display the menu
        displayMenu();

        // Ask user to select an item
        System.out.print("Enter the index of the item you want to order: ");
        int choice = sc.nextInt();

        // Show the selected item
        String selectedItem = getItemByIndex(choice);
        System.out.println("You selected: " + selectedItem);

        sc.close();
    }
}
