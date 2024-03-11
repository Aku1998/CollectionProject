package CollectionProject.Object;

public class Organization{
    private static long counter;
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным,
    // Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле может быть null

    public Organization(String name, long employeesCount, OrganizationType type, Address postalAddress) {
        Organization.counter++;
        this.id = 400 + Organization.counter;
        this.name = name;
        this.employeesCount = employeesCount;
        this.type = type;
        this.postalAddress = postalAddress;
    }

    public String toString() {

        if (this.postalAddress == null) {
            return "Название организации: " + this.name + ".\n" +
                    "Количество рабочих: " + this.employeesCount + ".\n" +
                    "Тип организации: " + this.type + ".\n" +
                    "Адрес отсутствует. " + "\n" +
                    "ID организации: " + this.id + "." +
                    "-----------------------------------------------------------------\n\n";
        } else {
            return "Название организации: " + this.name + ".\n" +
                    "Количество рабочих: " + this.employeesCount + ".\n" +
                    "Тип организации: " + this.type + ".\n" +
                    "Адрес: " + this.postalAddress + ".\n" +
                    "ID организации: " + this.id + "."+
                    "-----------------------------------------------------------------\n\n";
        }
    }
}
