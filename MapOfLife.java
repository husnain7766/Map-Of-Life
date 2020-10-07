import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapOfLife {
    List<Observation> observations;
    List<Species> species;
    List<Location> locations;
    ObservationRepository observationRepository = new ObservationRepository();
    MapOfLife(){
        observations = new ArrayList<>();
        species = new ArrayList<>();
    }

    void addSpecie(Species sps){
        System.out.println(sps);
        species.add(sps);
    }
    void addObservation(Observation ob){
        observations.add(ob);
    }
    void addLocation(Location location){
        locations.add(location);
    }
    void FetchRepository(){
        observationRepository.loadLocations();
        observationRepository.loadSpecies();
        observationRepository.loadObservations();
        this.observations = observationRepository.observations;
        this.species = observationRepository.species;
        this.locations = observationRepository.locations;
    }
    void AddNewLocation(){
        Location location = new Location();
        location.input();
        locations.add(location);
    }
    void
    AddNewObservations(){
        Scanner scanner= new Scanner(System.in);
        String locationName;
        String specieName;
        System.out.println("Enter Location Name : ");
        locationName = scanner.nextLine();
        System.out.println("Enter Specie Name : ");
        specieName = scanner.nextLine();
        Location loc = null;
        Species sp = null;
        for (Species species1 : species) {
            if(species1.scientificName.equalsIgnoreCase(specieName));
            sp = species1;
        }
        for (Location location : locations) {
            if(location.name.equalsIgnoreCase(locationName)){
                loc = location;
            }
        }
        if(loc == null || sp == null){
            System.out.println("One of the item don't Exist");
            return;
        }
        Observation observation = new Observation();
        observation.animal = sp;
        observation.location = loc;
        observation.input();
    }
    void displayUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UI(observations);
            }
        });
    }

    public void writeFile() {
        observationRepository.writeToFileLocations();
        observationRepository.writeToFileOB();
        observationRepository.writeToFileSpecies();
    }
}
