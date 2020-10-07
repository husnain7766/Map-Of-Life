public class Birds extends Species {
    int wings = 0;

    public Birds(String commonName, String scientificName, int wings) {
        super(commonName, scientificName);
        this.wings = wings;
    }

    @Override
    public String toString() {
        return "Birds {" +
                "Wings = " + wings +
                ", CommonName = '" + commonName + '\'' +
                ", ScientificName = '" + scientificName + '\'' +
                '}';
    }
}
