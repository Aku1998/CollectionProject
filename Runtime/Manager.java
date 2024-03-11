package CollectionProject.Runtime;

import CollectionProject.Object.MutableField;
import CollectionProject.Object.Organization;
import CollectionProject.Object.OrganizationType;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;


public class Manager {
    Scanner scanner;

    Map<Long, Organization> map;

    public static void defaultError() {
        System.out.println("Вы ввели неверные данные, прошу, проверьте вашу команду на наличие " +
                "опечаток, лишних пробелов и других ошибок при написании команды." +
                "\nВсе команды должны вводится маленькими буквами, без заглавных букв.");
    }


    public static boolean isInt(String str) {
        try {  // блок с которого все начнется тут
            // если завершится с ошибкой, то перейдет в catche блок
            Integer.valueOf(str);
            // если предыдущая строка успешно отработала, то возвращаем true
            return true;
        } catch (Exception e) {
            return false; // если попали в catch, то возвращаем false
        }
    }

    // я не знаю, будет ли это работать и нужно ли это, но я это сделала, потом можно это поменять/удалить, воооот
//    public static boolean isStr(int number) {
//        try {  // блок с которого все начнется тут
//            // если завершится с ошибкой, то перейдет в catche блок
//            Integer.toString(number);
//            // если предыдущая строка успешно отработала, то возвращаем true
//            return true;
//        } catch (Exception e) {
//            return false; // если попали в catch, то возвращаем false
//        }
//    }

//    public int getHouseYear() {
//        while (true) {
//            System.out.print("Введите название вашей организации: ");
//            String line = scanner.nextLine();
//
//            if (!isInt(line)) {
//                System.out.println("Это не число");
//                continue;
//            }
//            int year = Integer.parseInt(line);
//
//            if (year < 2030 && year > 0) {
//                return year;
//            }
//
//            System.out.println("Должно быть меньше 2030 и больше 0");
//        }
//    }

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

    public void updateById(String id) {
        if (!Utils.isInt(id)) {
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
                if (!Utils.isInt(newValue)) {
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

}

