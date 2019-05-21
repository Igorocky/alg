package org.igye.alg;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MaximumSubSequenceTest {
    @Test
    public void findMaxSubSequenceEtalon_sanity_check() {
        int[] res = findMaxSubSequenceEtalon(new Integer[]{1, 2, 3, 4});
        assertEquals(0,res[0]);
        assertEquals(3,res[1]);
        assertEquals(10,res[2]);

        res = findMaxSubSequenceEtalon(new Integer[]{-1, 2, 3, -4});
        assertEquals(1,res[0]);
        assertEquals(2,res[1]);
        assertEquals(5,res[2]);

        res = findMaxSubSequenceEtalon(new Integer[]{-1, -2, -3, -4});
        assertEquals(0,res[0]);
        assertEquals(0,res[1]);
        assertEquals(-1,res[2]);
    }

    @Test
    public void findMaxSubSequence_sanity_check() {
        MaximumSubSequence maxSubSeq = new MaximumSubSequence();
        int[] res = maxSubSeq.findMaxSubSequence(new Integer[]{1, 2, 3, 4});
        assertEquals(0,res[0]);
        assertEquals(3,res[1]);
        assertEquals(10,res[2]);

        res = maxSubSeq.findMaxSubSequence(new Integer[]{-1, 2, 3, -4});
        assertEquals(1,res[0]);
        assertEquals(2,res[1]);
        assertEquals(5,res[2]);

        res = maxSubSeq.findMaxSubSequence(new Integer[]{-1, -2, -3, -4});
        assertEquals(0,res[0]);
        assertEquals(0,res[1]);
        assertEquals(-1,res[2]);
    }

    @Test
    public void findMaxSubSequence_comparison_check() {
        MaximumSubSequence maxSubSeq = new MaximumSubSequence();
        Randoms rnd = new Randoms();
        for (int i = 0; i < 300; i++) {
            int size = rnd.randInt(20, 300);
            Integer[] seq = Stream.generate(() -> rnd.randInt(-100, 300))
                    .limit(size)
                    .collect(Collectors.toList())
                    .toArray(new Integer[size]);

            int[] expected = findMaxSubSequenceEtalon(seq);
            int[] actual = maxSubSeq.findMaxSubSequence(seq);
            if (expected[0] != actual[0] || expected[1] != actual[1] || expected[2] != actual[2]) {
                throw new RuntimeException(
                        "Expected: " + Arrays.toString(expected)
                                + ", actual: " + Arrays.toString(actual)
                                + " Seq: " + Arrays.toString(seq)
                );
            }
            if (expected[0] > 10 || i == 30) {
                System.out.println(
                        "Expected: " + Arrays.toString(expected)
                                + ", actual: " + Arrays.toString(actual)
                                + " size =  " + size
                                + " Seq: " + Arrays.toString(seq)
                );
            }
        }
    }

    private int[] findMaxSubSequenceEtalon(Integer[] seq) {
        int mB = 0;
        int mE = 0;
        int mS = Integer.MIN_VALUE;
        for (int cB = 0; cB < seq.length; cB++) {
            int cS = 0;
            for (int cE = cB; cE < seq.length; cE++) {
                cS += seq[cE];
                if (cS > mS) {
                    mB = cB;
                    mE = cE;
                    mS = cS;
                }
            }
        }
        return new int[]{mB,mE,mS};
    }
}
