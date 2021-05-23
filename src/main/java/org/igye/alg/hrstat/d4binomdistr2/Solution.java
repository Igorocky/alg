package org.igye.alg.hrstat.d4binomdistr2;

import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {
        double la = 0.88;
        double lb = 1.55;
        System.out.println(String.format("%.3f", 160+40*(la+la*la)));
        System.out.println(String.format("%.3f", 128+40*(lb+lb*lb)));
    }

    static double sum(int from, int to, Function<Integer, Double> function) {
        double res = 0;
        for (int i = from; i <= to; i++) {
            res+=function.apply(i);
        }
        return res;
    }

    static long choose(int n, int x) {
        return fact(n)/(fact(x)*fact(n-x));
    }

    static long fact(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n < 0");
        }
        if (n < 2) {
            return 1;
        }
        long prod = 1;
        for (int i = 2; i <= n; i++) {
            prod*=i;
        }
        return prod;
    }


}
