import java.util.Objects;

// UC1
public class Contact {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String email;

    public Contact(String firstName,String lastName,String address,
                   String city,String state,String zip,
                   String phoneNumber,String email){

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName(){
        return firstName;
    }

    // UC7
    @Override
    public boolean equals(Object obj){

        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Contact contact = (Contact)obj;
        return firstName.equals(contact.firstName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(firstName);
    }

    // UC11
    @Override
    public String toString(){
        return firstName + " " + lastName + " " + address + " " +
               city + " " + state + " " + zip + " " +
               phoneNumber + " " + email;
    }
}
