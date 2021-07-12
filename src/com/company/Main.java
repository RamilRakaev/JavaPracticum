package com.company;

import com.company.FileSystem.Directory;
import com.company.FileSystem.File;
import com.company.FileSystem.FilesystemElement;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Directory directory = new Directory("directory1", null);
        File file1 = new File("file1", directory);
        File file2 = new File("file2", directory);
        Directory directory2 = new Directory("directory2", directory);

        Directory directory3 = new Directory("directory3", directory);
        directory.pasteElement(directory3);
        Directory directory4 = new Directory("directory4", directory3);
        directory3.pasteElement(directory4);

        outputFilesystem(directory);
    }

    public static void outputFilesystem(@NotNull Directory element){
        System.out.println(element.getFullName());
        System.out.println("children:");
        for(Directory dir : element.getDirectories()){
            outputFilesystem(dir);
        }
        for(File dir : element.getFiles()){
            System.out.println(dir.getFullName());
        }
        System.out.println("end");
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

    //  the sum of the multiples of the Fibonacci numbers is less than the maximum value
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
}
