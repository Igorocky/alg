package org.igye.alg.leetcode;


import java.util.function.BiFunction;

class Solution4MedianOfTwoSortedArrays {
    public boolean isSolution(int i, int[] a, int[] b) {
        final Boundaries bnd = getBoundaries(i, a, b);
        return bnd.aL <= bnd.bR && bnd.bL <= bnd.aR;
    }

    public int choseSolution(Pair range, int[] a, int[] b) {
        if (range.left + 1 != range.right) {
            throw new RuntimeException("range.left + 1 != range.right");
        }
        return isSolution(range.left, a, b) ? range.left : range.right;
    }

    public int getJ(int i, int[] a, int[] b) {
        return (a.length + b.length) / 2 - i;
    }

    public Boundaries getBoundaries(int i, int[] a, int[] b) {
        int j = getJ(i, a, b);
        int aL = i == 0 ? Integer.MIN_VALUE : a[i-1];
        int aR = i == a.length ? Integer.MAX_VALUE : a[i];
        int bL = j == 0 ? Integer.MIN_VALUE : b[j-1];
        int bR = j == b.length ? Integer.MAX_VALUE : b[j];
        return new Boundaries(aL,aR,bL,bR);
    }

    public double getMedian(int i, int[] a, int[] b) {
        final Boundaries bnd = getBoundaries(i, a, b);

        int l = Math.max(bnd.aL,bnd.bL);
        int r = Math.min(bnd.aR,bnd.bR);
        if ((a.length + b.length) % 2 == 0) {
            return (l+r)/2.0;
        } else {
            return r;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return findMedianSortedArray(nums2);
        }
        if (nums2.length == 0) {
            return findMedianSortedArray(nums1);
        }
        int[] a = nums1.length <= nums2.length ? nums1 : nums2;
        int[] b = a == nums1 ? nums2 : nums1;
        int i = choseSolution(
                binarySearch(0, a.length, (left, right) -> {
                    final Boundaries bnd = getBoundaries(right.left, a, b);
                    return bnd.aL > bnd.bR ? -1 : 1;
                }),
                a,
                b
        );
        return getMedian(i, a, b);
    }

    public Pair binarySearch(int min, int max, BiFunction<Pair,Pair,Integer> test) {
        while (min < max) {
            int mid = (min + max) / 2;
            Integer testResult = test.apply(new Pair(min,mid), new Pair(mid,max));
            if (testResult < 0) {
                max = mid;
            } else {
                if (min == mid) break;
                min = mid;
            }
        }
        return new Pair(min,max);
    }

    public double findMedianSortedArray(int[] nums) {
        final int midIdx = nums.length / 2;
        if (nums.length % 2 == 1) {
            return nums[midIdx];
        } else {
            return (nums[midIdx-1] + nums[midIdx]) / 2.0;
        }
    }

    public static void main(String[] args) {
        asrt(2.0, new Solution4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        asrt(2.5, new Solution4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        asrt(0.0, new Solution4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
        asrt(1, new Solution4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{}, new int[]{1}));
        asrt(2, new Solution4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{2}, new int[]{}));

        asrt(2.5, new Solution4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,3}, new int[]{2,7}));
        asrt(-1, new Solution4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{3}, new int[]{-2,-1}));
        asrt(2.0, new Solution4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1}, new int[]{2,3}));
    }

    public static void asrt(double expected, double actual) {
        if (expected != actual) {
            throw new RuntimeException("Expected " + expected + " but was " + actual);
        }
    }

    private static class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    private static class Boundaries {
        int aL;
        int aR;
        int bL;
        int bR;

        public Boundaries(int aL, int aR, int bL, int bR) {
            this.aL = aL;
            this.aR = aR;
            this.bL = bL;
            this.bR = bR;
        }
    }
}