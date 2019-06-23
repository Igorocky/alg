package org.igye.alg.hrstat.d1quartiles;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testSolve() {
//        Assert.assertEquals(Arrays.asList(6 ,12 ,16), Solution.solve(
//                new int[]{3 ,7 ,8 ,5 ,12 ,14 ,21 ,13 ,18}
//        ));
        Assert.assertEquals(Arrays.asList(6 ,10 ,14), Solution.solve(
                new int[]{3 ,5 ,7 ,8 ,12 ,13 ,15 ,21}
        ));
    }

}
