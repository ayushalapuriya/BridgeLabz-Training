public class AddressBookMain {

    public static void main(String[] args) {

        // START
        System.out.println("Welcome to Address Book Program");

        AddressBookSystem system = new AddressBookSystem();

        // UC6
        system.addAddressBook("Home");

        AddressBook book = system.books.get("Home");

        // UC2
        Contact c1 = new Contact("Dipanshu","Sharma","Street",
                "Mathura","UP","281001","9999999999","mail@gmail.com");

        book.addContact(c1);

        // UC11
        book.sortByName();

        // UC17 Non Blocking IO
        new Thread(() -> {
            try{
                DataSource source = new FileDataSource();  // change to CSV/JSON/Server
                source.save(book.getContacts());
            }catch(Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}
