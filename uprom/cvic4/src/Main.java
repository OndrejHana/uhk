import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var bob = new Scanner(System.in);

        /*
        int[] nums = {10,21,35,51,31,80};

        var returned = foo(nums);

        if (returned != 0) {
            System.out.println("num was: "+ returned);
        }
         */


//        var count = 0;
//        for(int i=0;i<=13;i++) {
//            var num = bob.nextInt();
//
//            if (num%10 == 0) {
//                count++;
//            }
//        }
//
//        System.out.println("count: " + count);


//        var sum =1;
//        for(int i=0;i<=10;i++) {
//            var input = bob.nextInt();
//
//            if(i%2 == 1) {
//                sum *= input;
//            }
//        }
//
//        System.out.println(sum);

//        var even = 0;
//        var odd = 0;
//
//
//        for(int i=0;i<6;i++) {
//            var input = bob.nextInt();
//
//            if (input%2 == 0) {
//                even++;
//            } else {
//                odd++;
//            }
//        }
//
//        System.out.println(even % odd);
//
//    }

//        var output = 0;
//        var index = 0;
//        var input = 0;
//        do {
//            index ++;
//            input = bob.nextInt();
//
//            if(index%2==1) {
//                output += input;
//            } else {
//                output*=input;
//            }
//
//        } while (input >= 0);
//
//        System.out.println("out:"+ output);

//        var year = bob.nextInt();
//        var credits = bob.nextInt();
//
//        if (credits/year >= 40) {
//            System.out.println("you're fine");
//        } else {
//            System.out.println("you're not fine");
//        }

        var m = bob.nextInt();
        var n = bob.nextInt();

        var count = 0;
        for (var i=1; i<=m;i++) {
            for (var j=1; j<=n;j++) {
                count++;
                System.out.print(i*j +"."+i+"."+ j+" ");
            }
            System.out.println();
        }

    }


    static int foo(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            if(nums[i] >10 && nums[i]%2==0) {
                return nums[i];
            }
        }
        return 0;
    }


}