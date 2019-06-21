package org.igye.alg.hrstat.d0wmean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        List<int[]> inp = readInput();
        System.out.println(solve(inp.get(0), inp.get(1)));
    }

    static String solve(int[] arr, int[] wi) {
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1+=arr[i]*wi[i];
            sum2+=wi[i];
        }
        return String.format("%.1f", sum1*1.0/sum2);
    }

    static void inc(Map<Integer,Integer> counts, int cnt) {
        if (!counts.containsKey(cnt)) {
            counts.put(cnt,0);
        } else {
            counts.put(cnt, counts.get(cnt)+1);
        }
    }

    static List<int[]> readInput() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        int[] wi = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            wi[i] = scanner.nextInt();
        }
        return Arrays.asList(arr,wi);
    }
}
