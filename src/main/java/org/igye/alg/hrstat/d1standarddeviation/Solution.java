package org.igye.alg.hrstat.d1standarddeviation;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solve(readInput()));
    }

    static String solve(int[] arr) {
        double mean = mean(arr);
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.pow(arr[i]-mean,2);
        }
        return String.format("%.1f", Math.sqrt(sum/arr.length));
    }

    static double mean(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum*1.0/ arr.length;
    }

    static int[] readInput() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
