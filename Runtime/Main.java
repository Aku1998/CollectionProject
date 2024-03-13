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
        Organization kFC = new Organization("KFC", 99, OPEN_JOINT_STOCK_COMPANY, null);
        Organization waterSports = new Organization("Water Sports", 22, PUBLIC, new Address("Город Кульма, улица Улиткина"));
        Organization motorolaSolutions = new Organization("Motorola Solutions", 23, OPEN_JOINT_STOCK_COMPANY, new Address("Город Рига, улица Тескана"));
        Organization enterpriseProductsPartners = new Organization("Enterprise Products Partners", 101, TRUST, new Address("Город Златоуст, улица Спортивная"));
        Organization southern = new Organization("Southern", 55, OPEN_JOINT_STOCK_COMPANY, new Address("Город Рига, улица Тескана"));
        Organization alphabet = new Organization("Alphabet", 66, PUBLIC, new Address("Город Домодедово, улица Речная "));
        Organization gap = new Organization("Gap", 64, TRUST, new Address("Город Булькано, улица Мясистая"));
        Organization rRDAndS = new Organization("R.R. Donnelley & Sons", 78, TRUST, new Address("Город Утана, улица Пекаря"));
        Organization ascenaRetailGroup = new Organization("Ascena Retail Group", 61, PUBLIC, new Address("Город Сегиль, улица Холи"));
        Organization cSX = new Organization("CSX", 93, OPEN_JOINT_STOCK_COMPANY, new Address("Город Грейс, улица Святой Присциллы"));
        Organization myNewBank = new Organization("My New Bank", 75, TRUST, new Address("Город Акоста, улица Оборонительная"));

        organizationHashtable.put(dunkinDonuts.getID(), dunkinDonuts); // VAl: кладём в таблицу id KFC с помощью геттера
        organizationHashtable.put(kFC.getID(), kFC); // VAl: то же самое, что и выше
        organizationHashtable.put(waterSports.getID(), waterSports); // VAl:то же самое, что и выше
        organizationHashtable.put(myNewBank.getID(), myNewBank); // VAl: то же самое, что и выше
        organizationHashtable.put(motorolaSolutions.getID(), motorolaSolutions); // VAl: то же самое, что и выше
        organizationHashtable.put(enterpriseProductsPartners.getID(), enterpriseProductsPartners); // VAl: то же самое, что и выше
        organizationHashtable.put(alphabet.getID(), alphabet); // VAl: то же самое, что и выше
        organizationHashtable.put(southern.getID(), southern); // VAl: то же самое, что и выше
        organizationHashtable.put(gap.getID(), gap); // VAl: то же самое, что и выше
        organizationHashtable.put(rRDAndS.getID(), rRDAndS); // VAl: то же самое, что и выше
        organizationHashtable.put(ascenaRetailGroup.getID(), ascenaRetailGroup); // VAl: то же самое, что и выше
        organizationHashtable.put(cSX.getID(), cSX); // VAl: то же самое, что и выше
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
                    Manager.updateById(argsIn);
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
                    Manager.removeByGreaterKey(argsIn);
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
