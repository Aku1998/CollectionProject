package CollectionProject.Runtime;

import CollectionProject.Object.Address;
import CollectionProject.Object.Organization;

import java.util.Hashtable;
import java.util.Scanner;

import static CollectionProject.Object.OrganizationType.*;

public class Main {

    // тут ничего не будет, всё будет реализованно в других классах

    public static void main(String[] args) {

        Manager.greetings();

        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in); // VAl: создание сканера для считывания пользовательского ввода
        // VAl: создание organizationHashtable, где ключом у нас является ID, а самой хранящейся информацией объект организации
        Hashtable<Long, Organization> organizationHashtable = new Hashtable<>();
        String chosenCommand; // VAl: инициализация String, чтобы тот был виден в switch case'ах

        /* VAL: для того, чтобы конструктор работал корректно вместе с полем postalAddress, т.к. это является объектом другого класса,
        нам нужно вместо обычной строки писать в конструктор, например, вместо просто строки "Город Пушкин, улица Колотушкина",
        писать new Address ("Город Пушкин, улица Колотушкина"), воооот */

        Organization dunkinDonuts = new Organization("Dunkin Donuts", 66, PUBLIC, new Address("Город Пушкин, улица Колотушкина"));
        // VAL: сюда в Организацию он и вставляется, ну и так со всеми
        Organization kFC = new Organization("KFC", 99, OPEN_JOINT_STOCK_COMPANY, null);
        Organization waterSports = new Organization("Water Sports", 22, PUBLIC, new Address("Город Кульма, улица Улиткина"));

        Address myNewBankAddress = new Address("Город Рига, улица Тескана");
        Organization myNewBank = new Organization("My New Bank", 39, TRUST, myNewBankAddress);

        organizationHashtable.put(dunkinDonuts.getID(), dunkinDonuts); // VAl: кладём в таблицу id KFC с помощью геттера
        organizationHashtable.put(kFC.getID(), kFC); // VAl: то же самое, что и выше
        organizationHashtable.put(waterSports.getID(), waterSports); // VAl:то же самое, что и выше
        organizationHashtable.put(myNewBank.getID(), myNewBank); // VAl: то же самое, что и выше

        do {
            /* VAl: создание цикла do, который будет вмещать в себя switch case для работы с программой,
            после выбора команды и срабатывания определённого кейса, будет водить программу по кругу */

            System.out.println("Введите желаемую вами команду:\n");
            chosenCommand = scanner.nextLine();
            String[] chosenCommandInParts = null; // VAL: объявление строки для работы далее, она будет отвечать за разделение строк при работе с некоторыми методами, вооот
            String argsIn = null; // VAL: объявление аргументов, которые будут появляться при пользовательском вводе


            if (chosenCommand.contains(" ")) {
                chosenCommandInParts = chosenCommand.split(" ");
            }

            if (chosenCommandInParts != null && chosenCommandInParts.length == 2){
                chosenCommand = chosenCommandInParts[0];
                argsIn = chosenCommandInParts[1];
            }

            switch (chosenCommand) {
                case "help":
                    Manager.help();
                    break;

                case "info":
                    Manager.info(organizationHashtable);
                    break;

                case "show":
                    Manager.show(organizationHashtable);
                    break;

                case "insert":
                    Manager.insert();
                    break;

                case "updateID":
                    Manager.updateID();
                    break;

                case "removeKey":
                    Manager.removeKey(argsIn);
                    break;

                case "clear":
                    Manager.clear();
                    break;

                case "replace_if_greater {key}":
                    Manager.replaceIfGreater(organizationHashtable, argsIn);
                    break;

                case "remove_by_greater {key}":
                    Manager.replaceIfGreater(organizationHashtable, argsIn);
                    break;

                case "max_by_id":
                    Manager.maxByID();
                    break;

                case "count_greater_than_type":
                    Manager.countGreaterThanType(argsIn);
                    break;

                default:
                    Manager.defaultError();
            }

        } while (!chosenCommand.equalsIgnoreCase("EXIT"));
    }
}
