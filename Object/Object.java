package CollectionProject.Object;

public class Object {

    /* тут, возможно, стоит хранить конструктор и часто повторяющиеся методы для
    работы с этими самыми конструкторами 2(ещё ждём задание, чтобы определить,
    какой именно объект, но пока что скопирую то, что было в первом задании

    Потом нужно будет сделать REFACTOR этого класса под имя клавного объекта, с которым будем работать, вот
    Мб в будущем нужно сделать отдельные классы для класса/конструктора/методов для всего остального здесь,
    если понадобится
    */

    public class Flat {
        private long id; //Значение поля должно быть больше 0,
        //Значение этого поля должно быть уникальным,
        //Значение этого поля должно генерироваться автоматически
        private String name; //Поле не может быть null, Строка не может быть пустой
        private Integer area; //Поле может быть null, Значение поля должно быть больше 0
        private Integer numberOfRooms; //Максимальное значение поля: 8,
        //Значение поля должно быть больше 0
        private boolean balcony;
        private Furnish furnish; //Поле может быть null
        private House house; //Поле не может быть null
    }

    public class House {
        private String name; // Поле не может быть null
        private Integer year; // Максимальное значение поля: 2030
        // Значение поля должно быть больше 0
    }

    public enum Furnish {
        DESIGNER,
        NONE,
        BAD,
        LITTLE;
    }


}
