package CollectionProject.Runtime;

import java.util.Scanner;

import static CollectionProject.Runtime.Manager.defaultError;

public class Commands {

    public static void runProgram() {  // главный метод, который будет запускаться в main и будет проводить всю работу программы
        System.out.println("Добро пожаловать в Collection Project!\n" +
                "Для выхода из программы введите 'exit', для ознакомления со " +
                "всеми доступными командами введите 'help'");

        Scanner scanner = new Scanner(System.in); // создание сканера для считавания пользовательского ввода
        String chosenCommand; // инициализация стринга, чтобы тот был виден в switch case'ах

        do {
            /* создание цикла do, который будет вмещать в себя switch case для работы с программой,
            после выбора комманды и срабатывания определённого кейса, будет водить программу по кругу */

            System.out.println("Введите желаемую вами комманду");
            chosenCommand = scanner.nextLine();

            switch (chosenCommand) {
                case "help":
                    help();
                    break;

                case "exit":
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
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_head : вывести первый элемент коллекции и удалить его\n" +
                "history : вывести последние 15 команд (без их аргументов)\n" +
                "filter_less_than_balcony balcony : вывести элементы, значение поля balcony которых меньше заданного\n" +
                "print_ascending : вывести элементы коллекции в порядке возрастания\n");
    }
}
