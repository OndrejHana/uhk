//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var now = System.nanoTime();

        var ar = new Array(10);
        for (int i = 0; i < 100; i++) {
            ar.insert(0, i);
        }

        System.out.println((System.nanoTime() - now) / 1.0E+6);

        System.out.println(ar.remove(50));
        System.out.println(ar.remove(52));
        System.out.println(ar.remove(54));
        System.out.println(ar.remove(95));


//        var ar = new Array();
//        ar.insert(0,1);
//        ar.insert(0,2);
//        ar.insert(0,3);
//        ar.insert(0,4);
//        ar.insert(0,5);
//        ar.insert(0,6);
//        ar.insert(0,7);
//        ar.insert(0,8);
//        ar.insert(0,9);
//
//        System.out.println(ar);

//        ar.insert(2, 10);

        System.out.println(ar);


//        var now = System.nanoTime();
//
//        var ar = new Array(1000000);
//        for (int i = 0; i < 1000000; i++) {
//            ar.add(i);
//        }
//
//        System.out.println((System.nanoTime() - now) / 1.0E+6);
//
//        var now2 = System.nanoTime();
//
//        var ar2 = new Array(2);
//        for (int i = 0; i < 1000000; i++) {
//            ar2.add(i);
//        }
//
//        System.out.println((System.nanoTime() - now2) / 1.0E+6);

    }


}