import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class ObchodImpl {
    private HashMap<String, Produkt> nabidka;

    void pridejDoNabidky(Produkt produkt) {
        this.nabidka.put(produkt.toString(), produkt);
    }
    void odstranZNabidky(Produkt produkt) {
        this.nabidka.remove(produkt.toString());
    }

    void ulozNabidku(String filename) {
        try {
            var fileWriter = new FileWriter(filename);
            var buffWriter = new BufferedWriter(fileWriter);

            buffWriter.write("Nabidka:\n");
            for (Produkt p : this.nabidka.values()) {
                buffWriter.write(p.line(';'));
                buffWriter.newLine();
            }
            buffWriter.close();
        } catch (Exception e) {
            System.out.println("rip bozo");
        }
    }

    void nactiNabidku(String filename) {
        try {
            var fileReader = new FileReader(filename);
            var buffReader = new BufferedReader(fileReader);

            var line = buffReader.readLine();

            while (!(line = buffReader.readLine()).isBlank()) {
                var p = new Produkt(line);
                this.pridejDoNabidky(p);

            }
        } catch (Exception e) {
            System.out.println("rip bozo pri cteni");
        }
    }

    String nabidka() {
        return nabidka.toString();
    }

    public ArrayList<String>  vypis() {
        var results = new ArrayList<String>();
        for (Produkt p : this.nabidka.values()) {
            results.add(p.toString());
        }

        return results;
    }

}
