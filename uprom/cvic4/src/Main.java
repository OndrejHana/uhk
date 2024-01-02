import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var bob = new Scanner(System.in);

//        int[] nums = {10,21,35,51,31,80};
//
//        var returned = foo(nums);
//
//        if (returned != 0) {
//            System.out.println("num was: "+ returned);
//        }

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

//        var m = bob.nextInt();
//        var n = bob.nextInt();
//
//        var count = 0;
//        for (var i=1; i<=m;i++) {
//            for (var j=1; j<=n;j++) {
//                count++;
//                System.out.print(i*j +"."+i+"."+ j+" ");
//            }
//            System.out.println();
//        }
//
//        int[] arr = {1,45,6,7,3,2,5,6,2,7};
//
//        idk2(arr);

//        System.out.println("arr len");
//        var arrLen = bob.nextInt();
//        var a = new int[arrLen];
//        var b = new int[arrLen];
//        var j = 0;
//
//        for (int i=0; i<arrLen; i++) {
//            System.out.println("num>");
//
//            var in = bob.nextInt();
//            a[i] = in;
//            if(in%2 == 0) {
//                b[j] = in;
//                j++;
//            }
//        }
//
//        System.out.println("done");

//        var arrLen = bob.nextInt();
//        var a = new int[arrLen];
//        var b = new int[arrLen];
//        var bIdx = 0;
//        var c = new int[arrLen];
//        var cIdx = 0;
//
//        for (int i=0; i<arrLen; i++) {
//            var curr = bob.nextInt();
//            a[i] = curr;
//
//            if (curr <= 35) {
//                b[bIdx] = curr;
//                bIdx++;
//            } else {
//                c[cIdx] = curr;
//                cIdx++;
//            }
//        }
//
//        System.out.println("done");
//        var arr = new int[] {1,2,3,4,5,6,7,8};
//
//        unshift(arr);
//        shift(arr);
//

        var len = 10;
        var a = new int[len];

        for(int i=0; i<len; i++) {
            a[i] = i*i*i;
        }

        System.out.println(a);


    }

    static void shift(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = 0;
    }

    static void unshift(int[] arr) {
        var last = arr[arr.length-1];
        for (int i=arr.length-1; i>0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = last;
    }

    static int foo(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            if(nums[i] >10 && nums[i]%2==0) {
                return nums[i];
            }
        }
        return 0;
    }

    static void idk(int size) {
        var bob = new Scanner(System.in);
        int minIndex = 0;
        int maxIndex = 0;

        int[] pole = new int[size];
        for (int i=0; i<size; i++) {
            System.out.println("cislo plz");
            int num = bob.nextInt();
            pole[i] = num;
            if (num < pole[minIndex]) {
                minIndex = i;
            }
            if (num > pole[maxIndex]) {
                maxIndex = i;
            }
        }
    }

    static void idk2(int[] arr) {
        int sudaCount = 0;
        int lichaCount = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] %2 == 0) {
                sudaCount ++;
            } else {
                lichaCount++;
            }
        }
        int[] suda = new int[sudaCount];
        int[] licha = new int[lichaCount];

        int sudaIdx = 0;
        int lichaIdx = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] %2 == 0) {
                suda[sudaIdx] = arr[i];
                sudaIdx++;
            } else {
                licha[lichaIdx] = arr[i];
                lichaIdx ++;
            }
        }
    }

}