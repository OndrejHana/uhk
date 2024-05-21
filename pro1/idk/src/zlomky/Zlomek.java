package zlomky;

public class Zlomek {
    private int cit;
    private int jmen;

    public Zlomek(int cit, int jmen) {
        this.cit = cit;
        this.jmen = jmen;
        vyresZnamenko();
        zkrat();
    }

    private void vyresZnamenko() {
        if (this.jmen < 0) {
            this.cit *= -1;
            this.jmen *= -1;
        }
    }

    public Zlomek secti(Zlomek other) {
        var cit = (this.cit * other.jmen) + (other.cit * this.jmen);
        var jmen = this.jmen * other.jmen;

        System.out.println(cit);
        System.out.println(jmen);

        return new Zlomek(cit, jmen);
    }

    private void zkrat() {
        var nsd = Util.nsd(this.cit, this.jmen);
        System.out.println(nsd);

        if (nsd < 1) return;

        this.cit /= nsd;
        this.jmen /= nsd;
    }

    @Override
    public String toString() {

        if (this.jmen == 1) {
            return "(" + this.cit + ")";
        }
        return "(" + this.cit + ")/(" + this.jmen + ")";
    }
}
