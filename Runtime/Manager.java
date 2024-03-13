package CollectionProject.Runtime;

import CollectionProject.Object.Address;
import CollectionProject.Object.MutableField;
import CollectionProject.Object.Organization;
import CollectionProject.Object.OrganizationType;

import java.util.*;

import static CollectionProject.Runtime.Utils.isInt;


public class Manager {
    static Scanner scanner;
    static Map<Long, Organization> map;

    @Override
    public String toString() {
        return "Manager{" +
                "map=" + map +
                '}';
    }

    Manager() {
        this.map = new Hashtable<>();
    }

    public static void greetings() {
        System.out.println(
                "Выберите команду из списка. Для полного списка команд введите 'help'.\n" +
                        "Для выхода из программы введите 'exit'.\n" +
                        "В методах с {такими} {скобками} после названия введите числовое значение,\n" +
                        "при этом разделив их одним пробелом\n " +
                        "--------------------------------------------------------------------------------\n" +
                        "help\n" +
                        "info\n" +
                        "show\n" +
                        "insert\n" +
                        "update {id}\n" +
                        "remove_key {id}\n" +
                        "clear\n" +
                        "replace_if_greater {id}\n" +
                        "remove_greater_key {id}\n" +
                        "max_by_id \n" +
                        "count_greater_than_type {type} \n");
    }

    public static void defaultError() {
        System.out.println("Вы ввели неверные данные, прошу, проверьте вашу команду на наличие " +
                "опечаток, лишних пробелов и других ошибок при написании команды." +
                "\nВсе команды должны вводится маленькими буквами, без заглавных букв.");
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

    public static void info(Hashtable hashtable) {
        Set set = hashtable.entrySet();

        Iterator i = set.iterator(); // создаю итератор, который будет проходиться по всей Map'е

        while (i.hasNext()) {  // создаю метод, который считывает кол-во элементов в таблице
            Map.Entry example = (Map.Entry) i.next();
            System.out.print(example.getKey() + ": ");
            System.out.println(example.getValue());
        }
        System.out.println("Таблица хешов состоит из объектов Организаций\n" +
                "На данный момент в таблице находится " + hashtable.size() + " организации_й\n");
    }

    public static void show(Hashtable<Long, Organization> map) {
        System.out.println(map);
    }

    private String readName() {
        String name;

        do {
            System.out.print("Введите имя: ");
            name = this.scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("имя не может быть пустой");
                continue;
            }
            return name;
        } while (true);
    }

    private String readEmployeesCount() {
        String employeesCount;

        do {
            System.out.print("Введите колличество сотрудников: ");
            employeesCount = this.scanner.nextLine();
            if (!Utils.isInt(employeesCount)) {
                System.out.println("Количество сотрудников должно быть целочисленным значением");
                continue;
            }
            return String.valueOf(Long.parseLong(employeesCount));
        } while (true);
    }

    public OrganizationType readTypeOrganization() {
        System.out.println("Выберите тип организации: 1 PUBLIC, 2 OPEN_JOINT_STOCK_COMPANY,3 TRUST ");
        getNewElement(scanner);

        return null;
    }

    public String readAddress() {
        String addressLine;

        while (true) {
            System.out.print("Введите адрес организации: ");
            addressLine = scanner.nextLine();

            if (addressLine.length() > 191) {
                System.out.println("Этот адрес слишком длинный, максимальное кол-во символов - 191");
                continue;
            }
            return addressLine;
        }
    }


    public void insert() { // добавить новый элемент с заданным ключом
        System.out.println("Запущена команда добавления новой организации, введите данные.");

        String name = readName();
        Long employeesCount = Long.valueOf(readEmployeesCount());
        OrganizationType organizationType = readTypeOrganization();
        Address address = new Address(readAddress());
        Organization organization = new Organization(name, employeesCount, organizationType, address);

    }

    public static OrganizationType getNewElement(Scanner scanner) {
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                return OrganizationType.PUBLIC;
            case 2:
                return OrganizationType.TRUST;
            case 3:
                return OrganizationType.OPEN_JOINT_STOCK_COMPANY;
            default:
                System.out.println("Повторите еще раз");
        }

        return null;
    }

    public static Address address(Scanner scanner) { // Akmoor
        String address = scanner.nextLine();
        System.out.println(address);
        return null;
    }

    public static void updateID() {
        System.out.println("Метод для updateID");
    }

    public static void removeKey(String element) {
        Hashtable<Long, Object> longObjectHashtable = new Hashtable<>();

        if (!Utils.isInt(element)) {
            System.out.println("Некорректный аргумент");
            return;
        }

        long id = Long.parseLong(element);
        if (longObjectHashtable.remove(id) == null) {
            System.out.println("Не найдено");
        }
    }


    public static void clear() {
        Hashtable<Long, Object> longObjectHashtable = new Hashtable<>();
        longObjectHashtable.clear();
        System.out.println("Коллекция очищен");
    }

    public static void replaceIfGreater(Hashtable hashtable, String argsIn) {   // VAL: этот метод ещё в разработке, но пока что так
        Integer.valueOf(argsIn);
        if (!isInt(argsIn)) {
            System.out.println("Значение id неправильное");
            return;
        }
        Set set = hashtable.entrySet();

        Iterator i = set.iterator(); // создаю итератор, который будет проходиться по всей Map'е

        while (i.hasNext()) {  // создаю метод, который считывает кол-во элементов в таблице
            Map.Entry example = (Map.Entry) i.next();
            System.out.print(example.getKey() + ": ");
            System.out.println(example.getValue());
        }
    }
//    public void removeByGreaterKey (Hashtable hashtable, String argsIn) {
//        if (!isLong(argsIn)) {
//            System.out.println("Значение id неправильное");
//            return;
//        }
//        Set set = hashtable.entrySet();
//        Organization.getID();
//
//        Iterator i = set.iterator(); // создаю итератор, который будет проходиться по всей Map'е
//
//        while (i.hasNext()) {  // создаю метод, который считывает кол-во элементов в таблице
//            Map.Entry example = (Map.Entry) i.next();
//            if (Organization.getID() > argsIn) {
//                map.remove(Organization.getID());
//            }
//        }
//    }


    public void updateById(String id) {
        if (!isInt(id)) {
            System.out.println("Значение id неправильное");
            return;
        }
        long idValue = Long.parseLong(id);

        Organization org = this.map.get(idValue);
        if (org == null) {
            System.out.println("Такого id нет");
            return;
        }

        // нижележащий код должен быть в цикле и должно повторяться если указанно, что-то некорректно
        // (вместо return должен быть continue или аналогичная логика)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доступные поля для изменения:");
        for (MutableField field : MutableField.values()) {
            System.out.println(field);
        }
        System.out.print("Введите ответ: ");
        String answer = scanner.nextLine();
        if (!Utils.isEnum(answer, MutableField.class)) {
            System.out.println("Указанно некорректное поле для изменения");
            return;
        }
        MutableField answerValue = MutableField.valueOf(answer);

        System.out.print("Введите новое: ");
        String newValue = scanner.nextLine();

        switch (answerValue) {
            case NAME:
                if (newValue.isEmpty()) {
                    System.out.println("Указанно некорректное новое значение");
                    return;
                }
                org.setName(newValue);
                break;
            case TYPE:
                if (!Utils.isEnum(newValue, OrganizationType.class)) {
                    System.out.println("Указанно некорректное новое значение");
                    return;
                }
                OrganizationType orgType = OrganizationType.valueOf(newValue);
                org.setType(orgType);
                break;
            case EMPLOYEES_COUNT:
                if (!isInt(newValue)) {
                    System.out.println("Указанно некорректное новое значение");
                    return;
                }
                Long employeesCount = Long.valueOf(newValue);
                org.setEmployeesCount(employeesCount);
                break;
            case ADDRESS_STREET:
                // ...
                break;
        }
    }

    public static void countGreaterThanType(String argIn) {
// проверка аргумента
        if (!Utils.isEnum(String.valueOf(argIn), OrganizationType.class)) {
            System.out.println("Указанно некорректное значение");
            return;
        }
        OrganizationType targetType = OrganizationType.valueOf(argIn);
// логика команды
        int counter = 0;
        for (Organization organization : map.values()) {
            if (organization.getType().ordinal() > targetType.ordinal()) {
                counter = counter + 1;
            }
        }
        System.out.println("Количество: " + counter);
    }

    public static void maxByID() {
        long maxId = -1;
        for (Organization org : map.values()) {
            if (org.getID() > maxId) {
                maxId = org.getID();
            }
        }
        System.out.println(map.get(maxId));
    }

}

