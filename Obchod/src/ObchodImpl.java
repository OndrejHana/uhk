public class ObchodImpl {
    Nabidka nabidka;

    void pridejDoNabidky(Produkt produkt) {
        nabidka.pridej(produkt);
    }
    void odstranZNabidky(Produkt produkt) {
        nabidka.odstran(produkt);
    }

    void ulozNabidku(String filename);

    void nactiNabidku(String filename);

    String nabidka() {
        return nabidka.toString();
    }
}
