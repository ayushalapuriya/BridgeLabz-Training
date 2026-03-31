// Use of singly linked list 
class StudentNode{
	int rollNo;
	String name;
	int age;
	String grade;
	StudentNode next;
	
	StudentNode(int rollNo,String name,int age,String grade){
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
}

public class StudentRecordManagement {
	public static StudentNode head = null;
	public static StudentNode tail = null;
	int size=0;
	
    // Add at beginning
	public void addAtBeginning(StudentNode node) {
		if(head == null) {
			head = node;
			tail = node;
		}
		else {
			node.next = head;
			head = node;
		}
		size++;
	}
	
    // Add at ending
	public void addAtEnding(StudentNode node) {
		if(head == null) {
			head = node;
			tail = node;
		}
		else {
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
    // Add at specific position
	public void addAtSpecificPosition(StudentNode node,int pos) {
		int idx = 0;
		if(pos == 0) {
			addAtBeginning(node);
		}
		else if(pos == size) {
			addAtEnding(node);
		}
		else if(pos > size || pos < 0) {
			System.out.println("Invalid position");
			return;
		}
		StudentNode temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
	}
	
    // Delete by roll no
	public void deleteByRollNo(StudentNode node,int roll) {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		if(head.rollNo == roll) {
			head = head.next;
			size--;
			return;
		}
		StudentNode temp = head;
		while(temp.next != null && temp.next.rollNo != roll) {
			temp = temp.next;
		}
		if(temp.next == null) {
			System.out.println("Student not found");
		}
		else {
			if(temp.next == tail) {
				tail=temp;
			}
			temp.next=temp.next.next;
			size--;
		}
	}
	
    // Search by roll no
	public void searchByRollNo(StudentNode node,int roll) {
		StudentNode temp=head;
		while(temp!=null) {
			if(temp.rollNo == roll) {
				System.out.println("Found: "+temp.name+"and  Grade: "+temp.grade);
				return;
			}
			temp=temp.next;
		}
		System.out.println("Student not found");
	}
	
	// Display records of student
	public void displayRecord(StudentNode node) {
	    if (head == null) {
	        System.out.println("No records available");
	        return;
	    }

	    StudentNode temp = head;
	    while (temp != null) {
	        System.out.println(
	            "RollNo: " + temp.rollNo +
	            ", Name: " + temp.name +
	            ", Age: " + temp.age +
	            ", Grade: " + temp.grade
	        );
	        temp = temp.next;
	    }
	}

    // Update grade based on roll no
	public void updateGrade(StudentNode node, int roll, String grade) {
	    StudentNode temp = head;

	    while (temp != null) {
	        if (temp.rollNo == roll) {
	            temp.grade = grade;
	            System.out.println("Grade updated successfully");
	            return;
	        }
	        temp = temp.next;
	    }
	    System.out.println("Student not found");
	}

	
	public static void main(String[] args) {
	    StudentRecordManagement srm = new StudentRecordManagement();

	    srm.addAtEnding(new StudentNode(1 ,"Alice", 20 ,"A"));
	    srm.addAtEnding(new StudentNode(2 ,"Bob", 21 ,"B"));
	    srm.addAtBeginning(new StudentNode(3 ,"Charlie", 19 ,"A+"));
	    srm.addAtSpecificPosition(new StudentNode(4 ,"Mid", 20 ,"A"), 2);

	    System.out.println("Student Records:");
	    srm.displayRecord(null);

	    System.out.println("\nSearching roll no 2:");
	    srm.searchByRollNo(null, 2);

	    System.out.println("\nUpdating grade of roll no 2:");
	    srm.updateGrade(null, 2, "A+");

	    System.out.println("\nAfter update:");
	    srm.displayRecord(null);

	    System.out.println("\nDeleting roll no 1:");
	    srm.deleteByRollNo(null, 1);

	    System.out.println("\nFinal Records:");
	    srm.displayRecord(null);
	}

}
