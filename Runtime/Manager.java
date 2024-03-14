package CollectionProject.Runtime;

import CollectionProject.Object.Address;
import CollectionProject.Object.MutableField;
import CollectionProject.Object.Organization;
import CollectionProject.Object.OrganizationType;

import java.util.*;

import static CollectionProject.Runtime.Utils.isInt;


public class Manager {
    static Scanner scanner;
    static Map<Long, Organization> orgMap;

    public void setOrgMap(Map<Long, Organization> orgMap) {
        Manager.orgMap = orgMap;
    }

    Manager() {
        orgMap = new Hashtable<>();
    }

    public static void greetings() {
        System.out.println(
                "Выберите команду из списка. Для полного списка команд введите 'help'.\n" +
                        "Для выхода из программы введите 'exit'.\n" +
                        "В методах с {такими} {скобками} после названия введите числовое значение,\n" +
                        "при этом разделив их одним пробелом.\n " +
                        "--------------------------------------------------------------------------------\n" +
                        "help\n" +
                        "info\n" +
                        "show\n" +
                        "insert\n" +
                        "update {id}\n" +
                        "remove_key {id}\n" +
                        "clear\n" +
                        "remove_if_greater {id}\n" +
                        "remove_by_greater {id}\n" +
                        "max_by_id \n" +
                        "count_greater_than_type {type} \n");
    }

    public static void defaultError() {
        System.out.println("Вы ввели неверные данные, прошу, проверьте вашу команду на наличие " +
                "опечаток, лишних пробелов и других ошибок при написании команды." +
                "\nВсе команды должны вводится маленькими буквами, без заглавных букв.");
    }

    public static void help() {
        System.out.println("help: вывод пояснения всех команд.\n" +
                "info: вывод информации о коллекции и кол-во её элементов.\n" +
                "show: вывод всех элементов коллекции.\n" +
                "insert: создание нового элемента коллекции\n" +
                "update {id}: создание нового элемента коллекции по заданному ID\n" +
                "remove_key {id}: удаление элемента коллекции по заданному ID\n" +
                "clear: удаление всех элементов коллекции\n" +
                "replace_if_greater {id}: замена элемента коллекции, если значение работников больше\n" +
                "       старого элемента коллекции по заданному ID\n" +
                "remove_by_greater {id}: удаление всех элементов, ID которых меньше заданного значения\n" +
                "max_by_id: вывод элемента с самым высоким значением ID \n" +
                "count_greater_than_type {type}: подсчёт кол-ва элементов, чей тип больше заданного");
    }

    public static void info(Hashtable hashtable) {

        Set set = hashtable.entrySet();

        for (Object org : set) {  // создаю метод, который считывает кол-во элементов в таблице
            Map.Entry example = (Map.Entry) org;
        }
        System.out.println("Таблица хешов состоит из объектов Организаций\n" +
                "На данный момент в таблице находится " + hashtable.size() + " организации_й\n");
    }

    public static void show(Hashtable<Long, Organization> map) {
        for (Organization org : map.values()) {
            System.out.println(org);
        }
    }

    private static String readName() {
        String name;

        do {
            System.out.print("Введите имя: ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Имя не может быть пустым");
                continue;
            }
            return name;
        } while (true);
    }


    private static Long readEmployeesCount() {
        String employeesCount;

        do {
            System.out.print("Введите количество сотрудников: ");
            employeesCount = scanner.nextLine();
            if (!Utils.isInt(employeesCount)) {
                System.out.println("Количество сотрудников должно быть целочисленным значением");
                continue;
            }
            return Long.parseLong(employeesCount);
        } while (true);
    }

    public static OrganizationType readTypeOrganization() {
        System.out.println("Выберите тип организации: 1 PUBLIC, 2 OPEN_JOINT_STOCK_COMPANY,3 TRUST ");
        getNewElement(scanner);

        return null;
    }

    public static String readAddress() {
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


    public static void insert() { // добавить новый элемент с заданным ключом
        System.out.println("Запущена команда добавления новой организации, введите данные.");

        String name = readName();
        Long employeesCount = readEmployeesCount();
        OrganizationType organizationType = readTypeOrganization();
        Address address = new Address(readAddress());
        Organization organization = new Organization(name, employeesCount, organizationType, address);
        orgMap.put(organization.getID(), organization);
        System.out.println("The new organization inserted");
        System.out.println(organization);
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

    public static void removeKey(String element) {

        if (!Utils.isInt(String.valueOf(element))) {
            System.out.println("Некорректный аргумент");
            return;
        }

        long id = Long.parseLong(String.valueOf(element));
        if (orgMap.remove(id) == null) {
            System.out.println("Не найдено");
        }
    }


    public static void clear() {
        orgMap.clear();
        System.out.println("Коллекция очищена");
    }

    public static void replaceIfGreater(String argsIn) {
        if (!isInt(argsIn)) {
            System.out.println("Введённые аргументы указаны неверно.");
            return;
        }
        System.out.println("Запущена команда добавления новой организации, введите данные.");

        String name = readName();
        Long employeesCount = readEmployeesCount();
        OrganizationType organizationType = readTypeOrganization();
        Address address = new Address(readAddress());

        Organization newOrg = new Organization(name, employeesCount, organizationType, address);

        long args = Long.parseLong(argsIn);

        Organization oldOrg = orgMap.get(args);
        if (newOrg.compareTo(oldOrg) < 0) {
            System.out.println("Значение кол-ва работников новой организации меньше старой организации." +
                    "Попробуйте ещё раз, изменив значение новой организации.");
        } else if (newOrg.compareTo(oldOrg) > 0) {
            orgMap.remove(oldOrg.getID());
            orgMap.put(newOrg.getID(), newOrg);
        } else if (newOrg.compareTo(oldOrg) == 0) {
            System.out.println("Обе организации имеют одинаковое кол-во работников." +
                    "Попробуйте ещё раз, изменив значение новой организации.");
        }

    }

    public static void removeByGreaterKey(String argsIn, Hashtable hashtable) {
        if (!Utils.isLong(argsIn)) {
            System.out.println("Введённые аргументы указаны неверно.");
            return;
        }
        Set<Long> set = new HashSet<>();
        long args = Long.valueOf(argsIn);

        for (Long map : orgMap.keySet()) {
            if (map > args) {
                set.add(map);
            }
        }

        for (Long id : set) {

            System.out.println("Вы успешно удалили " + orgMap.get(id));

            orgMap.remove(id);
        }
    }


    public static void updateById(String id) {
        if (!Utils.isInt(id)) {
            System.out.println("Значение id неправильное");
            return;
        }
        long idValue = Long.parseLong(id);

        Organization org = orgMap.get(idValue);
        if (org == null) {
            System.out.println("Такого id нет");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доступные поля для изменения:");
        for (MutableField field : MutableField.values()) {
            System.out.println(field);
        }
        while (true) {
            System.out.print("Введите ответ: ");
            String answer = scanner.nextLine();
            if (!Utils.isEnum(answer, MutableField.class)) {
                System.out.println("Указанно некорректное поле для изменения");
                continue;
            }
            MutableField answerValue = MutableField.valueOf(answer);

            System.out.print("Введите новое значение: ");
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
                    if (!Utils.isInt(newValue)) {
                        System.out.println("Указанно некорректное новое значение");
                        return;
                    }
                    Long employeesCount = Long.valueOf(newValue);
                    org.setEmployeesCount(employeesCount);
                    break;
                case ADDRESS_STREET:
                    if (!Utils.isInt(newValue)) {
                        System.out.println("Указанно некорректное новое значение");
                        return;
                    }
                    org.getPostalAddress();
                    break;
            }
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
        for (Organization organization : orgMap.values()) {
            if (organization.getType().ordinal() > targetType.ordinal()) {
                counter = counter + 1;
            }
        }
        System.out.println("Количество: " + counter);
    }

    public static void maxByID() {
        long maxId = -1;
        for (Organization org : orgMap.values()) {
            if (org.getID() > maxId) {
                maxId = org.getID();
                System.out.println(orgMap.get(maxId));
                break;
            }
        }
    }

}

