import java.util.ArrayList;
public interface Obchod {
    void pridejDoNabidky(Produkt produkt);
    void odstranZNabidky(Produkt produkt);
    void ulozNabidku(String filename);
    void nactiNabidku(String filename);
    String nabidka();
    boolean jeVNabidce();
    void vymazNabidku();
    ArrayList<String> vypis();
}
