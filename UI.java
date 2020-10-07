import javax.swing.*;
import java.util.List;

public class UI extends JFrame {
    public UI(List<Observation> observationList) {
        String[] columns = new String[]{
                "Observation Id", "Observation Name", "Animal Id", "Location ID", "TIME"};
        int size = observationList.size();
        Object[][] data = new Object[size][5];
        int i = 0;
        for (Observation observation : observationList) {
            data[i][0]=observation.id;
            data[i][1]=observation.name;
            data[i][2]=observation.animal.scientificName;
            data[i][3]=observation.location.name;
            data[i][4]=observation.time;
            i++;
        }

        JTable table = new JTable(data, columns);
        this.add(new JScrollPane(table));

        this.setTitle("OBSERVATIONS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
