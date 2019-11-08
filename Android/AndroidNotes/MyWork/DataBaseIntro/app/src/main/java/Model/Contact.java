package Model;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;


    // GENERATE CONSTRUCTORS - remember to always make a blank one (i.e. the first constructor) - [right click for "generate"]
    public Contact() {
    }

    public Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    // GENERATE GETTERS & SETTERS - [right click for "generate"]
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}