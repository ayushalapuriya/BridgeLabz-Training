import java.util.ArrayList;
import java.util.List;

// Custom exception for invalid phone number
class InvalidPhoneNumberException extends Exception{
	InvalidPhoneNumberException(String message){
		super(message);
	}
}

// Contact class to store name and phone number
class Contact{
	private String name;
	private String phoneNo;
	Contact(String name,String phoneNo){
		this.name=name;
		this.phoneNo=phoneNo;
	}
	public String getName(){
		return name;
	}
	public String getPhoneNo(){
		return phoneNo;
	}
	public void displayContact(){
		System.out.println("Name: "+name+", Phone: "+phoneNo);
	}
}

public class PhoneContactOrganize{

	// Method to add contact
	public static void addContact(List<Contact> contacts,String name,String phoneNo) throws InvalidPhoneNumberException{
		if(phoneNo.length()!=10||!phoneNo.matches("\\d+")){
			throw new InvalidPhoneNumberException("Invalid phone number");
		}
		for(Contact c:contacts){
			if(c.getPhoneNo().equals(phoneNo)){
				throw new InvalidPhoneNumberException("Duplicate phone number");
			}
		}
		Contact c=new Contact(name,phoneNo);
		contacts.add(c);
		System.out.print("Contact added: ");
		c.displayContact();
	}

	// Method to delete contact
	public static void deleteContact(List<Contact> contacts,String phoneNo){
		for(int i=0;i<contacts.size();i++){
			if(contacts.get(i).getPhoneNo().equals(phoneNo)){
				System.out.print("Deleted contact: ");
				contacts.get(i).displayContact();
				contacts.remove(i);
				return;
			}
		}
		System.out.println("Contact not found");
	}

	// Method to search contact
	public static void searchContact(List<Contact> contacts,String key){
		for(Contact c:contacts){
			if(c.getName().contains(key)||c.getPhoneNo().contains(key)){
				c.displayContact();
			}
		}
	}

	// Method to display all contacts
	public static void displayAll(List<Contact> contacts){
		if(contacts.isEmpty()){
			System.out.println("No contacts to display");
		}else{
			System.out.println("All contacts:");
			for(Contact c:contacts){
				c.displayContact();
			}
		}
	}
	
	public static void main(String[] args){
		List<Contact> contacts=new ArrayList<>();
		try{
			addContact(contacts,"Rahul","1234567890");
			addContact(contacts,"Priya","9876543210");
			addContact(contacts,"Amit","8765432109");
			System.out.println();
			displayAll(contacts);
			System.out.println("\nSearch result for 'Rahul':");
			searchContact(contacts,"Rahul");
			System.out.println();
			deleteContact(contacts,"9876543210");
			System.out.println();
			displayAll(contacts);
		}catch(InvalidPhoneNumberException e){
			System.out.println("Error: "+e.getMessage());
		}
	}
}
