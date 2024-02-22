public interface Obchod {
    void pridejDoNabidky(Produkt produkt);
    void odstranZNabidky(Produkt produkt);

    void ulozNabidku(String filename);

    void nactiNabidku(String filename);

    String nabidka();
}
