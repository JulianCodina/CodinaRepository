package Prog2.Person;

public class Person {
    protected String name;
    protected String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //metodos


    @Override
    public String toString() {
        return "Prog2.Person[" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ']';
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
