import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    // UC5
    List<Contact> contacts = new ArrayList<>();

    // UC2
    public void addContact(Contact contact){

        // UC7 Duplicate Check
        if(contacts.contains(contact)){
            System.out.println("Duplicate Entry Not Allowed");
            return;
        }

        contacts.add(contact);
        System.out.println("Contact Added Successfully");
    }

    // UC3
    public void editContact(String name,String newCity,String newState){

        for(Contact c : contacts){

            if(c.getFirstName().equals(name)){
                c.city = newCity;
                c.state = newState;
                System.out.println("Contact Edited");
            }
        }
    }

    // UC4
    public void deleteContact(String name){
        contacts.removeIf(x -> x.getFirstName().equals(name));
        System.out.println("Contact Deleted");
    }

    // UC8
    public List<Contact> searchByCity(String city){

        return contacts.stream()
                .filter(x -> x.city.equals(city))
                .collect(Collectors.toList());
    }

    // UC10
    public long countByCity(String city){
        return contacts.stream()
                .filter(x -> x.city.equals(city))
                .count();
    }

    // UC11
    public void sortByName(){
        contacts.sort((x,y) -> x.firstName.compareTo(y.firstName));
    }

    // UC12
    public void sortByCity(){
        contacts.sort((x,y) -> x.city.compareTo(y.city));
    }

    public List<Contact> getContacts(){
        return contacts;
    }
}
