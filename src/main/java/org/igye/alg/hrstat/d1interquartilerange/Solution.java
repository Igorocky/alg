package org.igye.alg.hrstat.d1interquartilerange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        List<int[]> input = readInput();
        System.out.println(solve(input.get(0), input.get(1)));
    }

    static String solve(int[] x, int[] f) {
        List<Double> q = quartiles(constructArray(x, f));
        return String.format("%.1f", q.get(2) - q.get(0));
    }

    static int[] constructArray(int[] x, int[] f) {
        int sum = 0;
        for (int i = 0; i < f.length; i++) {
            sum+=f[i];
        }
        int[] result = new int[sum];
        int p = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < f[i]; j++) {
                result[p] = x[i];
                p++;
            }
        }
        return result;
    }

    static List<Double> quartiles(int[] arr) {
        List<Double> res = new ArrayList<>();
        Arrays.sort(arr);
        int left, right;
        if (arr.length % 2 == 0) {
            left = arr.length/2-1;
            right = left+1;
        } else {
            left = arr.length/2-1;
            right = left+2;
        }
        res.add(median(arr,0,left));
        res.add(median(arr,0,arr.length-1));
        res.add(median(arr,right,arr.length-1));
        return res;
    }

    static double median(int[] arr, int start, int end) {
        if ((end - start) % 2 == 1) {
            int left = start + (end - start)/2;
            int right = left + 1;
            return (arr[left] + arr[right])/2.0;
        } else {
            return arr[start + (end - start)/2];
        }
    }

    static List<int[]> readInput() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] x = new int[N];
        int[] f = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            f[i] = scanner.nextInt();
        }
        return Arrays.asList(x,f);
    }
}
