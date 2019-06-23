package org.igye.alg.hrstat.d1interquartilerange;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void testSolve() {
        Assert.assertEquals("9,0", Solution.solve(
                new int[]{6 ,12 ,8 ,10 ,20 ,16},
                new int[]{5 ,4 ,3 ,2 ,1 ,5}
        ));
    }

}
