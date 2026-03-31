import java.util.*;

public class AddressBookSystem {

    // UC6
    Map<String,AddressBook> books = new HashMap<>();

    public void addAddressBook(String name){
        books.put(name,new AddressBook());
        System.out.println("Address Book Created: " + name);
    }

    // UC8 Across Multiple Books
    public void searchAcrossBooks(String city){

        for(AddressBook book : books.values()){

            List<Contact> result = book.searchByCity(city);

            for(Contact c : result){
                System.out.println(c);
            }
        }
    }
}
