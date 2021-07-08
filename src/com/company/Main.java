package com.company;

public class Main {

    public static void main(String[] args) {
        practicum();
    }

    public static void practicum() {
        System.out.println("problem 1:");
        sumMultiplesNumbers(3, 5);
        System.out.println("problem 2:");
        sumEvenNumbers(4000000);
        System.out.println("problem 3:");
        sumsNumbers();
        System.out.println("problem 4:");
        sumMultiplesNumbers(3, 5);
        sumMultiplesNumbers(4, 7);
        sumMultiplesNumbers(4, 7, 2);
    }

    //  the sum of numbers that are multiples of two divisors
    public static void sumMultiplesNumbers(int firstDivisor, int secondDivisor) {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % firstDivisor == 0 || i % secondDivisor == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    //  the sum of numbers that are multiples of an arbitrary number of divisors
    public static void sumMultiplesNumbers(int... divisors) {
        int sum = 0;
        for (int number = 1; number < 1000; number++) {
            boolean isMultiple = false;
            for (int divisor : divisors) {
                if (number % divisor == 0) {
                    isMultiple = true;
                    break;
                }
            }
            if (isMultiple) {
                sum += number;
            }
        }
        System.out.println(sum);
    }

    //    the sum of the multiples of the Fibonacci numbers is less than the maximum value
    public static void sumEvenNumbers(int max) {
        int prevNum = 0;
        int curNum = 1;
        int sum = 0;

        while (true) {
            if (curNum < max) {
                if (curNum % 2 == 0) {
                    sum += curNum;
                }
                int nextNum = prevNum + curNum;
                prevNum = curNum;
                curNum = nextNum;
            } else {
                break;
            }
        }
        System.out.println(sum);
    }

    public static void sumsNumbers() {
        sumEvenNumbers(100);
        sumEvenNumbers(4000000);
    }


//    public static void problem2(int max) {
//        int num = 1;
//        int sum = 0;
//        for (int i = 1; ; ) {
//            num = fib(i);
//            if (num <= max) {
//                i++;
//                if (num % 2 == 0)
//                    sum += num;
//            } else {
//                System.out.println(sum);
//                break;
//            }
//        }
//    }
//
//    static int fib(int index) {
//        if (index == 0) return 0;
//        if (index == 1) return 1;
//        return fib(index - 2) + fib(index - 1);
//    }


}
