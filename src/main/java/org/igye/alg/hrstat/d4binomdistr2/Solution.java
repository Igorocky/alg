package org.igye.alg.hrstat.d4binomdistr2;

import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {
        double f = 0.12;
        double s = 1-f;
        int n = 10;
        System.out.println(String.format("%.3f", sum(0,2, x -> choose(n,x)*Math.pow(f,x)*Math.pow(s,n-x))));
        System.out.println(String.format("%.3f", sum(2,n, x -> choose(n,x)*Math.pow(f,x)*Math.pow(s,n-x))));
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
