package org.igye.alg;

public class MaximumSubSequence {
    int[] findMaxSubSequence(Integer[] seq) {
        int cB = 0;
        int cE = 0;
        int cS = 0;
        int mB = cB;
        int mE = cE;
        int mS = Integer.MIN_VALUE;
        while (cE < seq.length) {
            cS += seq[cE];
            if (cS < seq[cE]) {
                cB = cE;
                cS = seq[cB];
            }

            if (mS < cS) {
                mB = cB;
                mE = cE;
                mS = cS;
            }
            cE++;
        }
        return new int[]{mB,mE,mS};
    }
}
