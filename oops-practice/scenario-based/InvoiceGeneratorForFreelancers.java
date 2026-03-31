import java.util.ArrayList;

// Class to represent a single task
class Task {
    private String name;
    private int amount;

    Task(String name, int amount){
        this.name=name;
        this.amount=amount;
    }

    // Get task name
    public String getName(){ 
    	return name; 
    }

    // Get task amount
    public int getAmount(){ 
    	return amount;
    }

    // Show task details
    public String toString(){
        return name+" - "+amount+" INR";
    }
}

// Class to manage the invoice
class Invoice {
    private ArrayList<Task> tasks=new ArrayList<>(); // List of tasks

    // Convert input string into tasks
    public void parseInvoice(String input){
        String[] taskStrings=input.split(","); // Split by comma
        for(String taskStr:taskStrings){
            taskStr=taskStr.trim(); // Remove spaces
            String[] parts=taskStr.split("-"); // Split by dash
            if(parts.length==2){
                String name=parts[0].trim();
                int amount=Integer.parseInt(parts[1].replaceAll("[^0-9]",""));
                tasks.add(new Task(name,amount));
            }
        }
    }

    // Calculate total amount
    public int getTotalAmount(){
        int total=0;
        for(Task t:tasks) total+=t.getAmount();
        return total;
    }

    // Print all tasks and total
    public void printInvoice(){
        System.out.println("Invoice Details:");
        for(Task t:tasks) System.out.println(t);
        System.out.println("Total Invoice Amount: "+getTotalAmount()+" INR");
    }
}

// Main class to run the program
public class InvoiceGeneratorForFreelancers {
    public static void main(String[] args){
        String input="Logo Design - 3000 INR, Web Page - 4500 INR, App UI - 7000 INR";

        Invoice invoice=new Invoice();
        invoice.parseInvoice(input);
        invoice.printInvoice();
    }
}
