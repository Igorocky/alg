package org.igye.alg.hrstat.d0mean;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testSolve() {
        Assert.assertEquals(Arrays.asList("2,0", "2", "1"), Solution.solve(new int[]{1,2,3}));
        Assert.assertEquals(Arrays.asList("2,5", "2,5", "1"), Solution.solve(new int[]{4,2,1,3}));
        Assert.assertEquals(Arrays.asList("43900,6", "44627,5", "4978"), Solution.solve(
                new int[]{64630 ,11735 ,14216 ,99233 ,14470 ,4978 ,73429 ,38120 ,51135 ,67060}
        ));
    }

}
