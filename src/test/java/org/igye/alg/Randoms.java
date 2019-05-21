package org.igye.alg;

import java.util.Random;

public class Randoms {
    private Random rnd = new Random();

    public int randInt(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("from > to");
        }
        return from + rnd.nextInt(to-from+1);
    }
}
