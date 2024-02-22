public class Zbozi {
    enum Jednotka {kg,ks,l};

    String nazev;
    String zkratka;
    Jednotka jednotka;

    public Zbozi(String nazev, String zkratka, Jednotka jednotka) {
        this.nazev = nazev;
        this.zkratka = zkratka;
        this.jednotka = jednotka;
    }

    @Override
    public String toString() {
        return "Zbozi{" +
                "nazev='" + nazev + '\'' +
                ", zkratka='" + zkratka + '\'' +
                ", jednotka=" + jednotka +
                '}';
    }
}
