package CollectionProject.Runtime;

import java.util.Scanner;


public class Manager {
    Scanner scanner;

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
    public static boolean isStr(int number) {
        try {  // блок с которого все начнется тут
            // если завершится с ошибкой, то перейдет в catche блок
            Integer.toString(number);
            // если предыдущая строка успешно отработала, то возвращаем true
            return true;
        } catch (Exception e) {
            return false; // если попали в catch, то возвращаем false
        }
    }

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

    public int getEmployeeNumber() {
        while (true) {
            System.out.print("Введите кол-во работников: ");
            String line = scanner.nextLine();

            if (!isInt(line)) {
                System.out.println("Это не число");
                continue;
            }
            int roomNumber = Integer.parseInt(line);

            if (roomNumber > 0) {
                return roomNumber;
            }

            System.out.println("Не может быть пустым");
        }
    }

    public String getAddress() {
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

