package CollectionProject.Object;

public class Organization {
    private static long counter;
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным
                    // Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле может быть null

    public Organization(String name, long employeesCount, OrganizationType type, Address postalAddress) {
        Organization.counter++;
        this.id = Organization.counter;
        this.name = name;
        this.employeesCount = employeesCount;
        this.type = type;
        this.postalAddress = postalAddress;
    }

    public String toString() {
        return "ID организации: " + this.id + ".\n" +
                "Название организации: " + this.name + ".\n" +
                "Количество рабочих: " + this.employeesCount + ".\n" +
                "Тип организации: " + this.type.getOrgType() + ".\n" +
                "Адрес: " + this.postalAddress + ".\n" +
                "-----------------------------------------------------------------\n";
    }

    public long getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Long employeesCount) {
        this.employeesCount = employeesCount;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }

}
