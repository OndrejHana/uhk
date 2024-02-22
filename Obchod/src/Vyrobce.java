public class Vyrobce {
    String nazev;

    public Vyrobce(String nazev) {
        this.nazev = nazev;
    }

    @Override
    public String toString() {
        return this.nazev;
    }
}
