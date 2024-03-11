package CollectionProject.Runtime;

import CollectionProject.Object.Address;
import CollectionProject.Object.Organization;

import java.util.Hashtable;
import java.util.Scanner;

import static CollectionProject.Object.OrganizationType.*;
import static CollectionProject.Runtime.Manager.defaultError;

public class Commands {

    public static void runProgram() {  // VAl: главный метод, который будет запускаться в main и будет проводить всю работу программы
        System.out.println("Добро пожаловать в Collection Project!\n" +
                "Для выхода из программы введите 'exit', для ознакомления со " +
                "всеми доступными командами введите 'help'");

        Scanner scanner = new Scanner(System.in); // VAl: создание сканера для считывания пользовательского ввода
        String chosenCommand; // VAl: инициализация String, чтобы тот был виден в switch case'ах

        do {
            /* VAl: создание цикла do, который будет вмещать в себя switch case для работы с программой,
            после выбора команды и срабатывания определённого кейса, будет водить программу по кругу */


            /* VAL: для того, чтобы конструктор работал корректно вместе с полем postalAddress, т.к. это является отдельным
            классом и строка street является отдельным экземпляром этого класса, нам нужно, собственно, создать объект класса
            Адрес и позже уже вложить его в конструкт нашего класса Организации и объект организации
             */

            Address dunkinDonutsAddress = new Address("Город Пушкин, улица Колотушкина");  // тут создаётся объект Адреса с нужным нам адресом
            Organization dunkinDonuts = new Organization("Dunkin Donuts", 66, PUBLIC, dunkinDonutsAddress); // сюда в Организацию он и вставляется, ну и так со всеми

            // VAl: Т.к. тут поле является null, то создавать адрес под него не нужно
            Organization kFC = new Organization("KFC", 99, OPEN_JOINT_STOCK_COMPANY, null);

            Address waterSportsAddress = new Address("Город Кульма, улица Улиткина");
            Organization waterSports = new Organization("KFC", 22, PUBLIC, waterSportsAddress);

            Address myNewBankAddress = new Address("Город Рига, улица Тескана");
            Organization myNewBank = new Organization("My New Bank", 39, TRUST, myNewBankAddress);

            System.out.println(kFC);
            System.out.println(dunkinDonuts);
            System.out.println(waterSports);
            System.out.println(myNewBank);

            System.out.println("Введите желаемую вами команду");
            chosenCommand = scanner.nextLine();

            Hashtable<Long, Organization> hashtable = new Hashtable<>();

            switch (chosenCommand) {
                case "help":
                    help();
                    break;

                case "info":
                    info();
                    break;

                case "show":
                    show();
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

    public static void info () {
        System.out.println("Метод для инфо");
    }
    public static void show () {
        System.out.println("Метод для show");
    }
    public static void insert () {
        System.out.println("Метод для insert");
    }
    public static void updateID () {
        System.out.println("Метод для updateID");
    }
    public static void removeKey () {
        System.out.println("Метод для removeKey");
    }

    public static void clear () {
        System.out.println("Метод для clear");
    }

    public static void replaceIfGreater () {
        System.out.println("Метод для replaceIfGreater");
    }

}
