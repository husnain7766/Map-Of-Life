import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ObservationRepository {
    List<Location> locations =new ArrayList<>();
    List<Observation> observations = new ArrayList<>();
    List<Species> species = new ArrayList<>();
    public List<Location> loadLocations() {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get("Locations.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            Location location;
            for (CSVRecord record : csvParser) {
                location = new Location();
                location.name = record.get(0);
                location.biome = record.get(1);
                location.latitude = record.get(2);
                location.longitude = record.get(3);
                System.out.println(location);
                locations.add(location);
            }
            return locations;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Observation> loadObservations() {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get("Observations.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord record : csvParser) {
                Location loc = null;
                Species sp = null;
                for (Species species1 : species) {
                    if(species1.scientificName.equalsIgnoreCase(record.get(2)));
                        sp = species1;
                }
                for (Location location : locations) {
                    if(location.name.equalsIgnoreCase(record.get(3))){
                        loc = location;
                    }
                }
                Observation observation= new Observation(record.get(0),record.get(1),sp,loc,record.get(4));
                observations.add(observation);
                System.out.println(observation);
            }
            return observations;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Species> loadSpecies() {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get("Species.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            Species specie=null;
            for (CSVRecord record : csvParser) {
                if (record.get(0).equalsIgnoreCase("B")) {
                    specie=new Birds(record.get(1),record.get(2),Integer.parseInt(record.get(3)));
                    species.add(specie);
                } else if (record.get(0).equalsIgnoreCase("I")) {
                    specie = new Invertebrates(record.get(1),record.get(2),Integer.parseInt(record.get(3)));
                    species.add(specie);
                } else if (record.get(0).equalsIgnoreCase("A")) {
                    specie = new Amphibians(record.get(1),record.get(2),Integer.parseInt(record.get(3)),Integer.parseInt(record.get(4)));
                    species.add(specie);
                }
                System.out.println(specie);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    void writeToFileOB() {
        try {
            BufferedWriter reader = Files.newBufferedWriter(Paths.get("Observations.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(reader, CSVFormat.DEFAULT);
            for (Observation observation : observations) {
                csvPrinter.printRecord(observation.id, observation.name, observation.animal.scientificName, observation.location.name, observation.time);
            }
            csvPrinter.flush();
        } catch (IOException e) {

        }
    }
    void writeToFileLocations() {
        try {
            BufferedWriter reader = Files.newBufferedWriter(Paths.get("Locations.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(reader, CSVFormat.DEFAULT);
            for (Location location : locations) {
                csvPrinter.printRecord(location.name,location.latitude,location.longitude,location.biome);
            }
            csvPrinter.flush();
        } catch (IOException e) {

        }
    }
    void writeToFileSpecies() {
        try {
            BufferedWriter reader = Files.newBufferedWriter(Paths.get("Species.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(reader, CSVFormat.DEFAULT);
            for (Species species1 : species) {
                if(species1 instanceof Birds){
                     csvPrinter.printRecord("B",species1.commonName,species1.scientificName,((Birds) species1).wings);
                }else if(species1 instanceof Invertebrates){
                    csvPrinter.printRecord("I",species1.commonName,species1.scientificName,((Invertebrates) species1).legs);
                }else if(species1 instanceof Amphibians){
                    csvPrinter.printRecord("A",species1.commonName,species1.scientificName,((Amphibians) species1).legs,((Amphibians) species1).wings);
                }
            }
            csvPrinter.flush();
        } catch (IOException e) {

        }
    }
}

