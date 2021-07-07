package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        task1();
        task2(100);
        task2(4000000);
    }

    public static void task1() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static void task2(int max) {
        int num = 1;
        int sum = 0;
        for (int i = 1; ; ) {
            if (num < max) {
                num = Fib(i);
                i++;
                if (num % 2 == 0)
                    sum += num;
            } else {
                break;
            }
        }
        System.out.println(sum);
    }


    static int Fib(int n) {
        if ( n == 0 ) return 0;
        if (n == 1) return 1;
        return Fib(n-2) + Fib(n-1);
    }

//    public static void task2() {
//        int firstNum = 1;
//        int secondNum = 2;
//        int sum = 0;
//
//        while (true) {
//            if (secondNum < 4000000) {
//                int intermediateVariable = firstNum + secondNum;
//                firstNum = secondNum;
//                secondNum = intermediateVariable;
//
////                System.out.println(secondNum);
//                if (secondNum % 2 == 0) {
//                    sum += secondNum;
//                }
//
//            } else {
//                break;
//            }
//        }
//        System.out.println(sum);
//    }


}
