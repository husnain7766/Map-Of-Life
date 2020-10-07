import java.util.Scanner;

public class Location {
    String name;
    String latitude;
    String longitude;
    String biome;

    public Location() {
    }

    public Location(String name, String latitude, String longitude, String biome) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.biome = biome;
    }

    @Override
    public String toString() {
        return "Location{" +
                "Name = '" + name + '\'' +
                ", Latitude = '" + latitude + '\'' +
                ", Longitude = '" + longitude + '\'' +
                ",Biome = '" + biome + '\'' +
                '}';
    }

    public void input() {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter The Name : ");
        name = scanner.nextLine();
        System.out.println("Enter The Latitude : ");
        latitude = scanner.nextLine();
        System.out.println("Enter The Longitude : ");
        longitude = scanner.nextLine();
        System.out.println("Enter The Biome : ");
        biome = scanner.nextLine();
    }
}
