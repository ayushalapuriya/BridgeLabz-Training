
public class Table {
	private int tableNo;
	private int capacity;
	
	Table(int tableNo, int capacity){
		this.tableNo = tableNo;
		this.capacity = capacity;
	}
	
	public int getTableNo() {
		return tableNo;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void displayTable() {
        System.out.println("Table Details");
        System.out.println("Table Number: " + tableNo);
        System.out.println("Capacity: " + capacity);
        System.out.println("---------------------------");
    }
}
