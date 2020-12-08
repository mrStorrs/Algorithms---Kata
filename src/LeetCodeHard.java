import java.util.ArrayList;
import java.util.Arrays;

public class LeetCodeHard {
    /* #41 First Missing Positive.
     * completed 12/4/2020
     * 
     * Given an unsorted integer array nums, find the smallest
     * missing positive integer.
     * 
     * test cases: System.out.println(LeetCodeHard.java.firstMissingPositive(new
     * int[] {7,8,9,11,12}));
     */
    public static int firstMissingPositive(int[] nums) {
        //check single digit arrays: 
        if (nums.length == 1 && nums[0]  == 1) return 2;
        else if (nums.length == 1) return 1;
        Arrays.sort(nums); //sort nums in ascending order
        int posI = 1; // index for looking for postitive num
        for(int i = 0; i < nums.length; i++){
            //check for dupes. skip iteration if dupe found.
            if (i < nums.length - 2 && nums[i] == nums[i + 1] ) continue;
            //if number is positive, look for missing #
            if(nums[i] > 0){ 
                if (nums[i] != posI) return posI; //found missing pos #
                else posI++; //no missing pos, increment posI
            }
        }
        return posI;
    }

    /*
     * #4 Median of Two Sorted Arrays
     * 
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
     * the median of the two sorted arrays.
     * 
     * test cases: System.out.println(LeetCodeHard.java.findMedianSortedArrays(new
     * int[] {1,2}, new int[] {1}));
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] bothNums = new int[totalLength];
        int bothIndex = 0;

        //add all the items
        for(int i = 0; i < nums1.length; i ++){
            bothNums[bothIndex] = nums1[i];
            bothIndex++;
        }
        for(int i = 0; i < nums2.length; i ++){
            bothNums[bothIndex] = nums2[i];
            bothIndex++;
        }

        Arrays.sort(bothNums); //sort array

        //find median
        if(totalLength == 1) return bothNums[0];
        if(totalLength % 2 != 0){
            return (bothNums[totalLength/2]);
        } else {
            return ((((double) bothNums[totalLength / 2 - 1]) + ((double) bothNums[totalLength / 2]))) / 2;
        }

    }
}