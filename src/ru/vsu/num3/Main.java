package ru.vsu.num3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x = readDouble("x");
        double n = readDouble("n");
        double e = readDouble("e");

        double resultSumOfSequence = calculateSumOfSequence(x, n);
        printResult("of the first N elements", resultSumOfSequence);

        double resultSumOfSequenceEpsilon = calculateSumOfSequenceEpsilon(x, n, e);
        printResult("of the first N elements superior in absolute value of the epsilon number",
                resultSumOfSequenceEpsilon);

        double resultSumOfSequenceEpsilonDivisionBy10 = calculateSumOfSequenceEpsilon(x, n, e / 10);
        printResult("of the first N elements superior in absolute value of the epsilon divided 10 number",
                resultSumOfSequenceEpsilonDivisionBy10);

        double resultSumFunction = calculateFunction(x);
        printResult("function using Math", resultSumFunction);
    }

    private static double calculateSumOfSequence(double x, double n) {
        double sum = 1;

        for (int i = 0; i < n - 1; i++) {
            double result = calculateNMemberOfSequence(i, x);
            sum += result;
        }
        return sum;
    }

    private static double calculateSumOfSequenceEpsilon(double x, double n, double e) {
        double sumEpsilon = 0;

        for (int i = 0; i < n - 1; i++) {
            double result = calculateNMemberOfSequence(i, x);
            if (Math.abs(result) > e) {
                sumEpsilon += result;
            }
        }
        return sumEpsilon;
    }

    private static double calculateFunction(double x) {
        return 1 / (1 + x);
    }

    private static double calculateNMemberOfSequence(double i, double x) {
        return Math.pow(-1, i + 1) * (x + Math.pow(x, i + 1));
    }

    private static double readDouble(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s --> ", name);
        return scanner.nextDouble();
    }

    private static void printResult(String phrase, double resultSum) {
        System.out.printf("The sum %s --> %2$.2f\n", phrase, resultSum);
    }
}