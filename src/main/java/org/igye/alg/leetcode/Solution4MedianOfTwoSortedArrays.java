package org.igye.alg.leetcode;


import java.util.function.Function;

class Solution4MedianOfTwoSortedArrays {
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
        int i = binarySearch(0, a.length, x -> {
            final Boundaries bnd = getBoundaries(x, a, b);
            if (bnd.aL <= bnd.bR && bnd.bL <= bnd.aR) {
                return 0;
            } else {
                return bnd.aL > bnd.bR ? -1 : 1;
            }
        });
        return getMedian(i, a, b);
    }

    public int binarySearch(int min, int max, Function<Integer,Integer> test) {
        while (min < max) {
            int mid = (min + max) / 2;
            int testResult = test.apply(mid);
            if (testResult == 0) {
                return mid;
            } else if (testResult < 0) {
                max = mid;
            } else {
                if (min == mid) {
                    return max;
                } else {
                    min = mid;
                }
            }
        }
        return min;
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