package com.company;

import com.company.FileSystem.Directory;
import com.company.FileSystem.Notepad;

public class Main {

    public static void main(String[] args) {
//        bankTransactionsOutput();

        Notepad notepad = new Notepad();
        notepad.addAnEntry("new file", "22222");
        notepad.record("new file", "3333");

        Directory dir = new Directory("1");
        dir.removeDirectory();
    }

    public static void bankTransactionsOutput() {
        Bank BNPParibas = new Bank("BNPParibas", 0.08F);
        Bank CreditAgricole = new Bank("CreditAgricole", 0.18F);
        Bank BankOfAmerica = new Bank("BankOfAmerica", 0.4F);

        BNPParibas.concludeContract(CreditAgricole);

        BankAccount Misha = new BankAccount("Misha", CreditAgricole, 100);
        BankAccount Daniel = new BankAccount("Daniel", BNPParibas, 1000.2);
        BankAccount Vanya = new BankAccount("Vanya", BankOfAmerica, 500);


        System.out.println("Daniel: " + Daniel.accountStatus());
        System.out.println("Misha: " + Misha.accountStatus());
        Daniel.transaction(100, Misha);
        System.out.println("Daniel: " + Daniel.accountStatus());
        System.out.println("Misha: " + Misha.accountStatus());
        System.out.println();
        System.out.println("Vanya: " + Vanya.accountStatus());
        System.out.println("Misha: " + Misha.accountStatus());
        Vanya.transaction(100, Misha);
        System.out.println("Vanya: " + Vanya.accountStatus());
        System.out.println("Misha: " + Misha.accountStatus());
    }

    public static void mathematicalProblemsOutput() {
        System.out.println("problem 1:");
        System.out.println(getMultiplesNumbersSum(3, 5));

        System.out.println("problem 2:");
        System.out.println(sumEvenNumbers(4000000));

        System.out.println("problem 3:");
        System.out.println(sumEvenNumbers(4000000));
        System.out.println(sumEvenNumbers(100));

        System.out.println("problem 4:");
        System.out.println(getMultiplesNumbersSum(3, 5));
        System.out.println(getMultiplesNumbersSum(4, 7));
        System.out.println(getMultiplesNumbersSum(4, 7, 2));

    }

    //  the sum of numbers that are multiples of two divisors
    public static int getMultiplesNumbersSum(int firstDivisor, int secondDivisor) {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % firstDivisor == 0 || i % secondDivisor == 0) {
                sum += i;
            }
        }
        return sum;
    }

    //  the sum of numbers that are multiples of an arbitrary number of divisors
    public static int getMultiplesNumbersSum(int... divisors) {
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
        return sum;
    }

    //    the sum of the multiples of the Fibonacci numbers is less than the maximum value
    public static int sumEvenNumbers(int max) {
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
        return sum;
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
