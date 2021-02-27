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

    /*
     * #7 Reverse Integer completed 2/24/2020
     * 
     * Given a signed 32-bit integer x, return x with its digits reversed. If
     * reversing x causes the value to go outside the signed 32-bit integer range
     * [-231, 231 - 1], then return 0.
     * 
     * test cases: System.out.println(LeetCodeEasy.reverse(-321));
     */
    public static int reverse(int x) {
        StringBuilder sbInt = new StringBuilder(Integer.toString(x)); //convert to SB to use revers func
        if(sbInt.charAt(0) == '-'){ //check if negative, put negative at end before reversing.
            sbInt.deleteCharAt(0);
            sbInt.append('-');
        }
        Long revLong = Long.parseLong(sbInt.reverse().toString()); //reverse string and convert to a long
        if (revLong > Math.pow(2,31)-1 || revLong < - Math.pow(2,31)){ //check if value is within integer range.
            return 0; 
        }
        return revLong.intValue(); 
    }

    /*
     * #11 Roman To Integer
     * completed 2/26/2020 (99% more efficent than others! & 99% less memory)
     * 
     * For example, 2 is written as II in Roman numeral, just two one's added
     * together. 12 is written as XII, which is simply X + II. The number 27 is
     * written as XXVII, which is XX + V + II.
     * 
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII. Instead, the number four is
     * written as IV. Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX. There
     * are six instances where subtraction is used:
     * 
     * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
     * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
     * and M (1000) to make 400 and 900. Given a roman numeral, convert it to an
     * integer.
     * 
     * test cases: System.out.println(LeetCodeEasy.romanToInt("III"));
     */
    public static int romanToInt(String s) {
        char c; //holds current char
        int sum = 0; //holds running sum of #'s
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i); //set current char
            switch(c){
                case 'I': 
                    if(i < s.length() -1){
                        if(s.charAt(i+1) == 'X' || s.charAt(i+1) == 'V'){
                            sum --;
                            break; //don't add the number
                        } 
                    }
                    sum++;
                    break;
                case 'V':
                    sum += 5; 
                    break;
                case 'X':
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C') {
                            sum -= 10; // don't add the number
                            break;
                        }
                    }
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if (i < s.length() - 1) {
                        if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M') {
                            sum -= 100; // don't add the number
                            break;
                        }
                    } 
                    sum += 100; 
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000; 
                    break;
            }
        }
        return sum;
    }    
}