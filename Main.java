public class Main {

    public static void main(String[] args) {
        MapOfLife mapOfLife = new MapOfLife();
        mapOfLife.FetchRepository();

        Species species1 = new Birds("Tion", "ZEST", 78);
        Species species2 = new Birds("SETO", "ZET", 3);
        Species species3 = new Birds("BIOS", "CANO", 8);
        Species species4 = new Amphibians("COPPER","SS12",7,7);
        Location l = new Location("BBRB","89841654","4565463","VALCANO");
        Observation observation = new Observation("007","CANOO444",species4,l,"0418");
        Observation observation1 = new Observation("017","MIS444",species2,l,"1212");
        Observation observation2 = new Observation("027","CARDO444",species3,l,"0856");
        Observation observation3 = new Observation("037","CAADSDFO444",species1,l,"1518");
        mapOfLife.addSpecie(species1);
        mapOfLife.addSpecie(species2);
        mapOfLife.addSpecie(species3);
        mapOfLife.addSpecie(species4);
        mapOfLife.addLocation(l);
        mapOfLife.addObservation(observation);
        mapOfLife.addObservation(observation1);
        mapOfLife.addObservation(observation2);
        mapOfLife.addObservation(observation3);
        mapOfLife.displayUI();
        mapOfLife.writeFile();
    }
}
