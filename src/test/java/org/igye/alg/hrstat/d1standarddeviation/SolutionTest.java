package org.igye.alg.hrstat.d1standarddeviation;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void testSolve() {
        Assert.assertEquals("14,1", Solution.solve(
                new int[]{10 ,40 ,30 ,50 ,20}
        ));
    }

}
