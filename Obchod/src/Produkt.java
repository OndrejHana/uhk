public class Produkt {
    Zbozi zbozi;
    int kod;
    Vyrobce vyrobce;

    double kvantita;

    public Produkt(Zbozi zbozi, int kod, Vyrobce vyrobce, double kvantita) {
        this.zbozi = zbozi;
        this.kod = kod;
        this.vyrobce = vyrobce;
        this.kvantita = kvantita;
    }

    @Override
    public String toString() {
        return "Produk{" +
                "zbozi=" + zbozi +
                ", kod=" + kod +
                ", vyrobce=" + vyrobce +
                ", kvantita=" + kvantita +
                '}';
    }
}
