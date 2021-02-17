public class LeetCodeEasy {

    
    /* #1 Two Sum.
     * completed 2/17/2020
     * 
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.

     * test cases: System.out.println(LeetCodeEasy.java.TwoSum(new int[] {3,2,1,3}, 6));
     */
    public static int[] twoSum(int[] nums, int target){
        int index = 0;
        int sum = nums[index] + nums[index+1];

        while(sum != target){
            int firstN = nums[index];
            index++; //increment index so we don't add it to itself. 
            if(index > nums.length -1) return new int[] {-1}; //we reached end of index and no match found.

            for(int i = index; i < nums.length; i ++ ){
                //found match return as array
                if(nums[i] + firstN == target) return new int[] {index-1, i}; 
            }
        }
        return new int[] {index, index++};
     }
}