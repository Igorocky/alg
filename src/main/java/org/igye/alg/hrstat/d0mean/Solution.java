package org.igye.alg.hrstat.d0mean;

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

    static List<String> solve(int[] arr) {
        List<String> res = new ArrayList<>();
        long sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        res.add(String.format("%.1f", sum*1.0/arr.length));
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            res.add(String.format("%.1f", (arr[arr.length/2-1] + arr[arr.length/2])/2.0));
        } else {
            res.add(arr[arr.length/2] + "");
        }
        Map<Integer,Integer> counts = new HashMap<>();
        for (int i : arr) {
            inc(counts, i);
        }
        Integer maxCnt = counts.values().stream().max(Integer::compareTo).get();
        Integer mode = counts.entrySet().stream()
                .filter(e -> e.getValue().equals(maxCnt))
                .map(Map.Entry::getKey)
                .min(Integer::compareTo)
                .get();
        res.add(mode.toString());
        return res;
    }

    static void inc(Map<Integer,Integer> counts, int cnt) {
        if (!counts.containsKey(cnt)) {
            counts.put(cnt,0);
        } else {
            counts.put(cnt, counts.get(cnt)+1);
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
