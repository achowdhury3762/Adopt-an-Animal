package nyc.c4q.ashiquechowdhury.adoptme.model;

/**
 * Created by ashiquechowdhury on 12/2/16.
 */
public class Contact {
    Phone phone;
    State state;
    Email email;

    public Phone getPhone() {
        return phone;
    }

    public Address getAddress1() {
        return address1;
    }

    public City getCity() {
        return city;
    }

    public Email getEmail() {
        return email;
    }

    public State getState() {
        return state;
    }

    public Zip getZip() {
        return zip;
    }

    City city;
    Zip zip;
    Address address1;
}
