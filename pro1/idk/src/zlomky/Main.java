package zlomky;

public class Main {
    public static void main(String[] args) {
        var z1 = new Zlomek(2,5);
        var z2 = new Zlomek(8,10);
        var z3 = new Zlomek(20, 10);
        var z4 = new Zlomek(-10, 5);
        var z5 = new Zlomek(10, -5);


        System.out.println(z1);
        System.out.println(z2);
        System.out.println(z3);
        System.out.println(z4);
        System.out.println(z5);

        System.out.println(z1.secti(z2));
    }

}