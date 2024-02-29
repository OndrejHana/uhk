public class Produkt {
    Zbozi zbozi;
    int kod;
    Vyrobce vyrobce;

    double kvantita;

    public Produkt(String line, char sep) {
        var buff = line.trim().split(""+sep);

        this.kod = Integer.parseInt(buff[0]);
        this.zbozi = new Zbozi(buff[1],buff[2],Jednotka.valueOf(buff[3]));
        this.vyrobce = new Vyrobce(buff[5]);
        this.kvantita = Double.parseDouble(buff[6]);
    }

    public Produkt(Zbozi zbozi, int kod, Vyrobce vyrobce, double kvantita) {
        this.zbozi = zbozi;
        this.kod = kod;
        this.vyrobce = vyrobce;
        this.kvantita = kvantita;
    }

    public String line(char sep) {
        return ""+this.zbozi + sep + this.kod + sep + this.vyrobce + sep + this.kvantita;
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
