public class Amphibians extends Species{
    int legs = 8;
    int wings = 4;

    public Amphibians(String commonName, String scientificName, int legs, int wings) {
        super(commonName, scientificName);
        this.legs = legs;
        this.wings = wings;
    }

    @Override
        public String toString() {
        return "Amphibians {" +
                "Legs = " + legs +
                ", Wings = " + wings +
                ", CommonName = '" + commonName + '\'' +
                ", ScientificName = '" + scientificName + '\'' +
                '}';
    }
}
