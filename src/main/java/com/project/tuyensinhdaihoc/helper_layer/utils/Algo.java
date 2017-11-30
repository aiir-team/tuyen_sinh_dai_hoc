package com.project.tuyensinhdaihoc.helper_layer.utils;

import java.util.*;
import java.util.stream.IntStream;

public class Algo {

    private static double[] normalizeWeight(int weight[]) {
        double temp[] = new double[weight.length];
        int sum = IntStream.of(weight).sum();
        for(int i = 0; i < weight.length; i++) {
            temp[i] = (weight[i])*1.0 / sum;
        }
        return temp;
    }


    private static double sumSquareArray(double[] vector) {
        double sum = 0.0;
        for(double i: vector) {
            sum += Math.pow(i, 2.0);
        }
        return sum;
    }

    private static double[] normalizeVectorMax(double[] vector) {
        double[] temp = new double[vector.length];
        double sum = sumSquareArray(vector);
        for(int i = 0; i < vector.length; i++) {
            temp[i] = vector[i] / Math.sqrt(sum);
        }
        return temp;
    }

    private static double[] normalizeVectorMin(double[] vector) {
        double[] temp = new double[vector.length];
        double sum = sumSquareArray(vector);
        for(int i = 0; i < vector.length; i++) {
            temp[i] = 1.0 - vector[i] / Math.sqrt(sum);
        }
        return temp;
    }

    private static double[] multiplyNumberWithArray(double[] vector, double number) {
        for(int i = 0; i< vector.length; i++) {
            vector[i] = vector[i] * number;
        }
        return vector;
    }

    public static Integer[] modelTOPSIS(int[] arrayId, double[] amountStudent, double[] score, double[] rank, double[] mainSubject, int vecWeight[]) {

        //1. Normalize vector weights
        double[] vectorWeight = normalizeWeight(vecWeight);

        //2. Normalize Input Matrix
        int inputSize = arrayId.length;

        // Normalize vector input
        amountStudent = normalizeVectorMax(amountStudent);
        score = normalizeVectorMax(score);
        rank = normalizeVectorMin(rank);
        mainSubject = normalizeVectorMax(mainSubject);

        // Multiply with weight
        double[] rAmount = multiplyNumberWithArray(amountStudent, vectorWeight[0]);
        double[] rScore = multiplyNumberWithArray(score, vectorWeight[1]);
        double[] rRank = multiplyNumberWithArray(rank, vectorWeight[2]);
        double[] rSubject = multiplyNumberWithArray(mainSubject, vectorWeight[3]);

        // Idea solution
        double maxAmount = Arrays.stream(rAmount).max().getAsDouble();
        double maxScore = Arrays.stream(rScore).max().getAsDouble();
        double maxRank = Arrays.stream(rRank).max().getAsDouble();
        double maxSubject = Arrays.stream(rSubject).max().getAsDouble();

        double minAmount = Arrays.stream(rAmount).min().getAsDouble();
        double minScore = Arrays.stream(rScore).min().getAsDouble();
        double minRank = Arrays.stream(rRank).min().getAsDouble();
        double minSubject = Arrays.stream(rSubject).min().getAsDouble();

        double[] s_star = new double[inputSize];
        double[] s_bar = new double[inputSize];
        Double[] c_star = new Double[inputSize];
        for(int i = 0; i < inputSize; i++){
            double x1 = Math.pow(maxAmount - rAmount[i], 2.0);
            double x2 = Math.pow(maxScore - rScore[i], 2.0);
            double x3 = Math.pow(maxRank - rRank[i], 2.0);
            double x4 = Math.pow(maxSubject - rSubject[i], 2.0);
            double ss = Math.sqrt(x1 + x2 + x3 + x4);

            double t1 = Math.pow(minAmount - rAmount[i], 2.0);
            double t2 = Math.pow(minScore - rScore[i], 2.0);
            double t3 = Math.pow(minRank - rRank[i], 2.0);
            double t4 = Math.pow(minSubject - rSubject[i], 2.0);
            double sb = Math.sqrt(t1 + t2 + t3 + t4);

            s_star[i] = ss;
            s_bar[i] = sb;
            c_star[i] = sb / (ss + sb);
        }

        // Sort result
        Double[] c_star_old = Arrays.copyOf(c_star, c_star.length);

        HashMap<Integer, Double> hmap = new HashMap<>();
        for(int j = 0; j < inputSize; j++) {
            hmap.put(arrayId[j], c_star_old[j]);
        }


        Object[] a = hmap.entrySet().toArray();
        Arrays.sort(a, (Comparator) (o1, o2) -> ((Map.Entry<Integer, Double>) o2).getValue()
                .compareTo(((Map.Entry<Integer, Double>) o1).getValue()));

        Integer[] keys = new Integer[a.length];
        Double[] values = new Double[a.length];

        for (int j = 0; j < a.length; j++) { //Object e : a) {

            keys[j] = ((Map.Entry<Integer, Double>) a[j]).getKey();
            values[j] = ((Map.Entry<Integer, Double>) a[j]).getValue();

            System.out.println(((Map.Entry<Integer, Double>) a[j]).getKey() + " : "
                    + ((Map.Entry<Integer, Double>) a[j]).getValue());
        }

        return keys;
    }

}
