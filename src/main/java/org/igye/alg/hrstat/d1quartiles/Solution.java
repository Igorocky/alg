package org.igye.alg.hrstat.d1quartiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        solve(readInput()).forEach(System.out::println);
    }

    static List<Integer> solve(int[] arr) {
        List<Integer> res = new ArrayList<>();
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

    static int median(int[] arr, int start, int end) {
        if ((end - start) % 2 == 1) {
            int left = start + (end - start)/2;
            int right = left + 1;
            return (arr[left] + arr[right])/2;
        } else {
            return arr[start + (end - start)/2];
        }
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
