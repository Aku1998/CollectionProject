package CollectionProject.Runtime;

import CollectionProject.Object.Address;
import CollectionProject.Object.MutableField;
import CollectionProject.Object.Organization;
import CollectionProject.Object.OrganizationType;

import java.util.*;

import static CollectionProject.Runtime.Utils.isInt;
import static CollectionProject.Runtime.Utils.isLong;


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
                        "exit\n" +
                        "remove_greater {fieldValue}\n" +
                        "remove_lower {fieldValue}\n" +
                        "count_less_than_genre {genre}\n");
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

    public static Organization insert(){ // Akmoor
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");;
        String name= scanner.nextLine();
        System.out.println("Введите количество сотрудников: ");
        Long employeesCount= scanner.nextLong();
        System.out.println("Выберите тип организации: 1 PUBLIC, 2 OPEN_JOINT_STOCK_COMPANY,3 TRUST ");
        getNewElement(scanner);
        System.out.println("Введите адрес: ");
        address(scanner);

        Organization organization=new Organization(name,employeesCount,getNewElement(scanner),address(scanner));

        System.out.println(organization);
        return insert() ;

    }
    public static OrganizationType getNewElement(Scanner scanner){  // Akmoor
        int choice=scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:
                return OrganizationType.PUBLIC;
            case  2:
                return OrganizationType.TRUST;
            case 3:
                return OrganizationType.OPEN_JOINT_STOCK_COMPANY;
            default: System.out.println("Повторите еще раз");       }

        return null ;
    }
    public static Address address(Scanner scanner){ // Akmoor
        String address=scanner.nextLine();
        System.out.println(address);
        return null;
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

    public static void countGreaterThanType(){
        System.out.println("Введите команду: ");
        String cmd = scanner.nextLine(); // count_greater_than_type TRUST
        cmd = cmd.split(" ")[0];
        String argIn = cmd.split(" ")[1];
// проверка аргумента
        if (!Utils.isEnum(argIn, OrganizationType.class)) {
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

    };

    public static void maxByID() {
        long maxId = -1;
        for (Organization org : map.values()) {
            if (org.getID() > maxId) {
                maxId = org.getID();
            }
        }
        System.out.println(map.get(maxId));
    }

    public int getEmployeeNumberFromUser() {
        while (true) {
            System.out.print("Введите кол-во работников: ");
            String line = scanner.nextLine();

            if (!isInt(line)) {
                System.out.println("Это не число");
                continue;
            }
            int employeeNumber = Integer.parseInt(line);

            if (employeeNumber > 0) {
                return employeeNumber;
            }

            System.out.println("Не может быть пустым");
        }
    }

    public String getAddressFromUser() {
        while (true) {
            System.out.print("Введите адрес организации: ");
            String addressLine = scanner.nextLine();

            if (addressLine.length() > 191) {
                System.out.println("Этот адрес слишком длинный, максимальное кол-во символов - 191");
                continue;
            }
            return addressLine;
        }
    }

}

