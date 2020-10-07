public class Invertebrates extends Species{
    int legs =0;

    public Invertebrates(String commonName,String scientificName,int legs) {
        super(commonName,scientificName);
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "Invertebrates{" +
                "Legs=" + legs +
                ", CommonName = '" + commonName + '\'' +
                ", ScientificName = '" + scientificName + '\'' +
                '}';
    }
}
