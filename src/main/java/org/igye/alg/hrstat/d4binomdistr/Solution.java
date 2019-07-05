package org.igye.alg.hrstat.d4binomdistr;

import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {
        double b = 1.09/2.09;
        double g = 1/2.09;
        System.out.println(String.format("%.3f", sum(3,6, x -> choose(6,x)*Math.pow(b,x)*Math.pow(g,6-x))));
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
