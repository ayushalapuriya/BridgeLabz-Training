import java.util.LinkedList;

class Node{
	int val;
	Node next;
	
	Node(int val){
		this.val = val;
	}
}

public class LinkedlistImplementation {
	Node head;
	Node tail;
	int size = 0;
	
	void addAtBeg(Node num) {
		if(head == null) {
			head = num;
			tail = num;
		}
		num.next = head;
		head = num;
		size++;
	}

	void addAtLast(Node num) {
		if(head == null) {
			head = num;
			tail = num;
		}
		tail.next = num;
		tail = num;
		size++;
	}
	// 10 20 30 - 40 (50, 3)
	void addAtPos(Node num, int pos) {
		Node temp=head;
		for (int i = 0 ; i < size ; i++) {
			if (i == pos-1) {
				temp.next = num;
				num.next = tail;
				return;
			}
			temp = temp.next;
		}
		size++;
	}
	
	void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	void deleteAtBeg() {
		Node temp=head.next;
		head=temp;
		size--;
	}
	
	void deleteAtLast() {
		Node temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		temp.next=null;
		tail=temp;
		size--;
	}
	
	boolean search(Node num) {
		Node temp=head;
		while(temp!=null) {
			if(temp==num) return true;
			temp = temp.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		LinkedlistImplementation list = new LinkedlistImplementation();
		list.addAtBeg(new Node(10));
		list.addAtBeg(new Node(20));
		list.addAtBeg(new Node(30));
		System.out.println(list.size);
		
		list.display();
		
		list.addAtLast(new Node(40));
		list.display();
		
		list.addAtPos(new Node(50), 3);
		list.display();
		
		list.deleteAtBeg();
		
		list.deleteAtLast();
	}
}
