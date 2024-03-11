package CollectionProject.Runtime;

import CollectionProject.Object.Address;
import CollectionProject.Object.MutableField;
import CollectionProject.Object.Organization;
import CollectionProject.Object.OrganizationType;

import java.util.*;

import static CollectionProject.Object.OrganizationType.*;
import static CollectionProject.Runtime.Manager.defaultError;

public class Commands {



    public static void runProgram() {  // VAl: главный метод, который будет запускаться в main и будет проводить всю работу программы
        System.out.println("Добро пожаловать в Collection Project!\n" +
                "Для выхода из программы введите 'exit', для ознакомления со " +
                "всеми доступными командами введите 'help'");

        Scanner scanner = new Scanner(System.in); // VAl: создание сканера для считывания пользовательского ввода
        String chosenCommand; // VAl: инициализация String, чтобы тот был виден в switch case'ах

        /* VAL: для того, чтобы конструктор работал корректно вместе с полем postalAddress, т.к. это является объектом другого класса,
        нам нужно вместо обычной строки писать в конструктор, например, вместо просто строки "Город Пушкин, улица Колотушкина",
        писать new Address ("Город Пушкин, улица Колотушкина"), воооот */

        Organization dunkinDonuts = new Organization("Dunkin Donuts", 66, PUBLIC, new Address("Город Пушкин, улица Колотушкина")); // сюда в Организацию он и вставляется, ну и так со всеми
        Organization kFC = new Organization("KFC", 99, OPEN_JOINT_STOCK_COMPANY, null);
        Organization waterSports = new Organization("Water Sports", 22, PUBLIC, new Address("Город Кульма, улица Улиткина"));

        Address myNewBankAddress = new Address("Город Рига, улица Тескана");
        Organization myNewBank = new Organization("My New Bank", 39, TRUST, myNewBankAddress);

        // VAl: создание organizationHashtable, где ключом у нас является ID, а самой хранящейся информацией объект организации
        Hashtable<Long, Organization> organizationHashtable = new Hashtable<>();

        organizationHashtable.put(dunkinDonuts.getID(), dunkinDonuts); // VAl: кладём в таблицу id KFC с помощью геттера
        organizationHashtable.put(kFC.getID(), kFC); // VAl: то же самое, что и выше
        organizationHashtable.put(waterSports.getID(), waterSports); // VAl:то же самое, что и выше
        organizationHashtable.put(myNewBank.getID(), myNewBank); // VAl: то же самое, что и выше


        String value = String.valueOf(organizationHashtable.get(dunkinDonuts.getID()));
        String value2 = String.valueOf(organizationHashtable.get(kFC.getID()));
        String value3 = String.valueOf(organizationHashtable.get(waterSports.getID()));
        String value4 = String.valueOf(organizationHashtable.get(myNewBank.getID()));
        System.out.println(value + value2 + value3 + value4);

        do {
            /* VAl: создание цикла do, который будет вмещать в себя switch case для работы с программой,
            после выбора команды и срабатывания определённого кейса, будет водить программу по кругу */

            System.out.println("Введите желаемую вами команду");
            chosenCommand = scanner.nextLine();


            switch (chosenCommand) {
                case "help":
                    help();
                    break;

                case "info":
                    info();
                    break;

                case "show":
                    show(organizationHashtable);
                    break;

                case "insert":
                    insert();
                    break;

                case "updateID":
                    updateID();
                    break;

                case "removeKey":
                    removeKey();
                    break;

                case "clear":
                    clear();
                    break;

                case "replaceIfGreater":
                    replaceIfGreater();
                    break;


                default:
                    defaultError();
            }

        } while (!chosenCommand.equalsIgnoreCase("EXIT"));
    }

    public static void help() {
        System.out.println("help: вывести описание всех команд \n" +
                "info : информация о коллекции\n" +
                "add : добавить новый элемент в коллекцию (спросить про значение каждого поля)\n" +
                "update_by_id {id}: обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id {id} : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "exit : завершить программу\n" +
                "remove_head : вывести первый элемент коллекции и удалить его\n" +
                "history : вывести последние 15 команд (без их аргументов)\n" +
                "filter_less_than_balcony balcony : вывести элементы, значение поля balcony которых меньше заданного\n" +
                "print_ascending : вывести элементы коллекции в порядке возрастания\n");
    }

    public static void info() {
        System.out.println("Метод для инфо");
    }

    public static void show(Hashtable ht) {
        System.out.println(ht.toString());
    }

    public static void insert() {
        System.out.println("Метод для insert");
    }

    public static void updateID() {
        System.out.println("Метод для updateID");
    }

    public static void removeKey() {
        System.out.println("Метод для removeKey");
    }

    public static void clear() {
        System.out.println("Метод для clear");
    }

    public static void replaceIfGreater() {
        System.out.println("Метод для replaceIfGreater");
    }
}
