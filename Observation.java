import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Observation {
    String image;
    String id;
    String name;
    Species animal;
    Location location;
    String time;

    public Observation(String id, String name, Species animal, Location location, String time, List<String> comments) {
        this.id = id;
        this.name = name;
        this.animal = animal;
        this.location = location;
        this.time = time;
        this.comments = comments;
    }

    public Observation() {

    }

    @Override
    public String toString() {
        return "Observation{" +
                "\nId = '" + id + '\'' +
                "\nName = '" + name + '\'' +
                "\nAnimal = " + animal +
                "\nLocation = " + location +
                "\nTime = '" + time + '\'' +
                "\nComments = " + comments +
                "\nImage = "+image+
                "\n}";
    }

    List<String> comments;

    public Observation(String id, String name, Species animal, Location location, String time) {
        this.id = id;
        this.name = name;
        this.animal = animal;
        this.location = location;
        this.time = time;
        comments = new ArrayList<>();
    }
    void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID : ");
        id = scanner.nextLine();
        System.out.println("Enter Name : ");
        name = scanner.nextLine();
        System.out.println("Enter Time : ");
        time = scanner.nextLine();
    }
}
