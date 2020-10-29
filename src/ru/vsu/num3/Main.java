package ru.vsu.num3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x = readDouble("x");
        double n = readDouble("n");
        double e = readDouble("e");

        if (!checkInput(x)) {
            System.out.println("X entered out of range (-1, 1)");
            return;
        }

        double resultSumOfSequenceEpsilon = calculateSumOfSequenceEpsilon(x, e, 1);
        double numberOfIterationsGreaterThanEpsilon = calculateSumOfSequenceEpsilon(x, e, 0);
        double resultSumOfSequenceEpsilonDividedBy10 = calculateSumOfSequenceEpsilon(x, e / 10, 1);
        double numberOfIterationsGreaterThanEpsilonDividedBy10 = calculateSumOfSequenceEpsilon(x, e / 10, 0);
        double resultSumOfSequence = calculateSumOfSequence(x, n);
        double resultSumFunction = calculateFunction(x);

        printResultSum("of the first N elements", resultSumOfSequence);

        printResultSum("superior in absolute value of the epsilon number",
                numberOfIterationsGreaterThanEpsilon, resultSumOfSequenceEpsilon);

        printResultSum("superior in absolute value of the epsilon divided 10 number",
                numberOfIterationsGreaterThanEpsilonDividedBy10, resultSumOfSequenceEpsilonDividedBy10);

        printResultSum("function using Math", resultSumFunction);
    }

    private static boolean checkInput(double x) {
        return x > -1 && x < 1;
    }

    private static double calculateSumOfSequence(double x, double n) {
        double sequenceTerm = 1;
        double sumN = 0;

        for (int i = 0; i < n; i++) {
            sumN += sequenceTerm;
            sequenceTerm *= -x;
        }
        return sumN;
    }

    private static double calculateSumOfSequenceEpsilon(double x, double e, int index) {
        double sumEpsilon = 0;
        double sequenceTerm = 1;
        int count = 0;

        while (Math.abs(sequenceTerm) > e) {
            sumEpsilon += sequenceTerm;
            sequenceTerm *= -x;
            count++;
        }
        double[] arraySum = {count, sumEpsilon};
        return arraySum[index];
    }

    private static double calculateFunction(double x) {
        return 1 / (1 + x);
    }

    private static double readDouble(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s --> ", name);
        return scanner.nextDouble();
    }

    private static void printResultSum(String phrase, double resultSum) {
        System.out.printf("The sum %s --> %.4f\n", phrase, resultSum);
    }

    private static void printResultSum(String phrase, double resultCount, double resultSum) {
        System.out.printf("The sum of the first %.0f elements %s --> %.4f\n", resultCount, phrase, resultSum);
    }
}