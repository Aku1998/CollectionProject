package CollectionProject.Runtime;

import CollectionProject.Object.Flat;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.LinkedList;
import java.util.Scanner;

import static CollectionProject.Object.Commands.help;
import static CollectionProject.Runtime.Manager.defaultError;

public class Main {

    /* класс для самой прогонки программы и взаимодействия с ней, тут уже используются все методы
    из других классов и т.д., вооот
    */

    Flat[] flatArray = new Flat[4];

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Collection Project!\n" +
                "Для выхода из программы введите 'exit', для ознакомления со " +
                "всеми доступными коммандами введите 'help'");

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
        /* программа будет работать пока пользователь не введёт "EXIT" в кач-ве.
        пока что так, потому что мы пока не знаем, как работать с файлами и т.д.,
        потом заменю на отдельный метод */
    }
}
