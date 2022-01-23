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

    /*
     * #10 Regular Expression Matching
     * 
     * Given an input string (s) and a pattern (p), implement regular expression
     * matching with support for '.' and '*' where:
     * 
     * '.' Matches any single character.​​​​ '*' Matches zero or more of the
     * preceding element. The matching should cover the entire input string (not
     * partial).
     * 
     * test cases: System.out.println(LeetCodeHard.isMatch("aa", "a*"));
     */
    public static boolean isMatch(String s, String p) {
        boolean repeat = false;
        char patternC;
        char cR = ' '; // will hold letter to repeat.
        int sI = s.length(); // this will be our pattern itterator
        int pI = p.length();
        int repeatCnt = 0; // track how many times a letter is repeated

        // Work backward. This will allow us to catch any of the . or * to know when a
        // letter an be repeated
        while (sI > 0 && pI > 0) {
            pI--;
            sI--;
            patternC = p.charAt(pI); // current matching letter.
            // System.out.println(pI);
            // what to do when found repeat char
            if (patternC == '*') {
                if (pI > 0) {
                    cR = p.charAt(pI - 1); // get preceding character and set to be repeated.
                    repeat = true; // found a letter that can be repeated.
                    repeatCnt = 0;
                    sI++; // don't move string interval this iteration
                }
            } else if (repeat) { // if repeat is true then check if it shold remain true
                if (s.charAt(sI) != cR && cR != '.') { // no longer a repeat. Do not move string interval
                    sI++;
                    repeat = false;
                    // check if a letter was never repeated. If so skip rest of loop and go to next
                    // iteration
                    if (repeatCnt < 2) {
                        // sI--;
                        continue;
                    }
                } else {
                    pI++; // repeat found, do not move pattern matcher
                    repeatCnt++;
                }
            }

            // System.out.println("patternC: " + pI + " StringC: " + sI);
            if (!repeat) { // repeat not active, check pattern vs str.
                // if (sI == 0 && pI != 0)
                // return false; // see if string interval is @ 0 and pattern is not.
                // if (sI == 0 && pI != 0)
                // return false; // see if string interval is @ 0 and pattern is not.
                if (patternC != s.charAt(sI) && patternC != '.') {
                    // System.out.println("testing");
                    return false;
                }
            }

            // check for end of matcher but not string.
            if (pI == 0 && sI != 0)
                return false; // string is longer than pattern allows.

        }

        if (sI > 0)
            return false; // ensure full string was checked.

        // ensure that there is the a minimum amount of letters per periods
        // if (pI > 0){
        int nPeriod = 0;
        for (int i = 0; i < pI; i++) {
            if (p.charAt(i) == '.')
                nPeriod++;
            if (p.charAt(i) == '*' && p.charAt(i - 1) == '.')
                nPeriod--;
        }
        if (nPeriod > s.length())
            return false;
        // }

        return true;

    }
}