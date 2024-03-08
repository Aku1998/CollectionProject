package CollectionProject.Object;

public class Flat {
    private static int counter;
    private final long id;
    private final String name;
    private final int area;
    private final int numberOfRooms;
    private final boolean balcony;
    private final Furnish furnish;
    private final House house;

    public Flat(String name, int area, int numberOfRooms, boolean balcony, Furnish furnish, House house) {
        Flat.counter++;
        this.id = 400 + Flat.counter;
        this.name = name;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.balcony = balcony;
        this.furnish = furnish;
        this.house = house;
    }


    /*
    Потом нужно будет сделать REFACTOR этого класса под имя клавного объекта, с которым будем работать, вот
    Мб в будущем нужно сделать отдельные классы для класса/конструктора/методов для всего остального здесь,
    если понадобится
    */


}
