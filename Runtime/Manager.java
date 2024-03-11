package CollectionProject.Runtime;

import CollectionProject.Object.MutableField;
import CollectionProject.Object.Organization;
import CollectionProject.Object.OrganizationType;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import static CollectionProject.Runtime.Utils.isInt;


public class Manager {
    Scanner scanner;
    Map<Long, Organization> map;

    Manager(){
        this.map = new Hashtable<>();
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

        // нижележащий код должен быть в цикле и должно повторяться если указанно что то некорректно
        // (вмето return должен быть continue или аналогичная логика)
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

