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
    
}