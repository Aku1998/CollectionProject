package CollectionProject.Object;

public class Address {
    private String street; //Длина строки не должна быть больше 191, Поле может быть null

    public Address(String street) {
        this.street = street;
    }

    public String street() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String toString() {
        return this.street;
    }

}