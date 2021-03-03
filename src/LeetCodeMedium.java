import java.util.LinkedList;

public class LeetCodeMedium {
    /*
     * #3 Longest Substring without repeating characters. completed 2/18/2020
     * 
     * Given a string s, find the length of the longest substring without repeating
     * characters.
     * 
     * 
     * test cases: System.out.println(LeetCodeMedium.lengthOfLongestSubstring(randomString));
     */
    public static int lengthOfLongestSubstring(String s) {
        StringBuilder noRep = new StringBuilder();
        int tempSum = 0;
        int sum = 0;
        String letter = "";

        //using a "slidingwindow" to avoid nested for loops. 
        for(int i = 0, start = 0; i < s.length(); i++){
            letter = Character.toString(s.charAt(i)); //find current letter

            //check for dupes. if none add letter to StringBuilder and +1 to temp sum
            if(noRep.indexOf(letter) == -1){
                noRep.append(letter);
                tempSum++;    
            } else { //dupe found, move sliding window and reset temps
                noRep.setLength(0); //reset noRep
                tempSum = 0; //reset tempSum
                start++;
                i = start - 1;
            }
            
            if (tempSum > sum ) sum = tempSum; 
        }
        return sum;
    }

    /*
     * 5. Longest Palindromic Substring
     * 
     * Given a string s, return the longest palindromic substring in s.
     * 
     * test cases:
     * System.out.println(LeetCodeMedium.longestPalindrome(randomString));
     */
    public static String longestPalindrome(String s) {
        boolean palFound = false; //used for search from center loop
        int start = 0; int end = 0; //holds bounds of center loop search
        String pal = Character.toString(s.charAt(0)); // hold longest palindrome found
        int conseqDouble = 0; //track how many conseq double letters. 

        for(int i = 1; i < s.length(); i++){
            start = i-1; end = i+1; //set bounds.
            
            //find for double letters
            if(s.charAt(start) == s.charAt(i)){
                conseqDouble++; 

                if(pal.length() == 1) pal = s.substring(start, end); //update longest palindrome if nessescary.

                //looking for odd or even repeats. 
                if(conseqDouble % 2 != 0) { //found one double so far, move start bounds 
                    start--; 
                } else { //double repeat found, move sliding window back and reset conseq double.
                    i--;
                    start--;
                    end--;
                    conseqDouble = 0; 
                }
            }
            //find a palindrome center.
            if(end != s.length() && start >= 0 && s.charAt(start) == s.charAt(end)){
                palFound = true;
                
                //search outwards from center to see how big the palindrome it is.
                while (palFound && start >= 0 && end < s.length()) {
                    // System.out.println("testing");
                    
                    if(s.charAt(start) == s.charAt(end)) {
                        //check if palindrome is longer than prev, if so update.
                        if (s.substring(start, end + 1).length() > pal.length()) {
                            pal = s.substring(start, end + 1);
                        }
                        start--; end++; //move bounds wider.
                    } else { 
                        palFound = false; 
                    }
                }
            }
        }
        return pal;
    }

    /*
     * 8. String to Integer.
     * 
     * Implement the myAtoi(string s) function, which converts a string to a 32-bit
     * signed integer (similar to C/C++'s atoi function).
     * 
     * The algorithm for myAtoi(string s) is as follows:
     * 
     * Read in and ignore any leading whitespace. Check if the next character (if
     * not already at the end of the string) is '-' or '+'. Read this character in
     * if it is either. This determines if the final result is negative or positive
     * respectively. Assume the result is positive if neither is present. Read in
     * next the characters until the next non-digit charcter or the end of the input
     * is reached. The rest of the string is ignored. Convert these digits into an
     * integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the
     * integer is 0. Change the sign as necessary (from step 2). If the integer is
     * out of the 32-bit signed integer range [-231, 231 - 1], then clamp the
     * integer so that it remains in the range. Specifically, integers less than
     * -231 should be clamped to -231, and integers greater than 231 - 1 should be
     * clamped to 231 - 1. Return the integer as the final result. Note:
     * 
     * Only the space character ' ' is considered a whitespace character. Do not
     * ignore any characters other than the leading whitespace or the rest of the
     * string after the digits. 
     * 
     * test cases:
     * System.out.println(LeetCodeMedium.myAtoi("-42"));
     */
    public static int myAtoi(String s) {
        String reg = "-+0123456789";
        String sTrim = s.trim(); // remove leading and trailing whitespace
        String sSub; 
        int start = -1;
        int end = 0;

        for(int i = 0; i < sTrim.length(); i++){
            //look for characters in reg string
            if(reg.indexOf(sTrim.charAt(i)) != -1){
                //check for double signs or numbers before signs. 
                if (sTrim.charAt(i) == '-' || sTrim.charAt(i) == '+') {
                    if (i > 0 && sTrim.charAt(i - 1) != ' '){
                        if (end - start > 0) break;
                        else return 0; 
                    }
                }
                //move bounds
                if(start == -1) start = i;
                else end = i; 
            } else { // end loop word char found. 
                break;
            }
        }
        // no nums found return 0
        if (start == -1) return 0;
        //get the new substring without any acompaning whitespace.
        sSub = sTrim.substring(start, end+1);
        //check for lonely signs 
        if(sSub.equals("-") || sSub.equals("+")) return 0;

        //convert trimed substring to a long to be tested if in int bounds
        try{
            return Integer.parseInt(sSub);
        } catch (Exception e) {
            return (sSub.charAt(0) == '-')  ? (int) -(Math.pow(2, 31)) : (int) Math.pow(2, 31);
        }

    }

    /*
     * 11. Container with most water.
     * 
     * Given n non-negative integers a1, a2, ..., an , where each represents a point
     * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
     * of the line i is at (i, ai) and (i, 0). Find two lines, which, together with
     * the x-axis forms a container, such that the container contains the most
     * water.
     * 
     * Notice that you may not slant the container.
     * 
     * test cases: System.out.println(LeetCodeMedium.maxArea(new int[] = {1,8,6,2,5,4,8,3,7} ));
     */
    public static int maxArea(int[] height) {
        //use two pointers approach. initialize pointer.
        int beg = 0;
        int end = height.length - 1;

        int max = Integer.MIN_VALUE; 
        while (beg < end){
            //check if new max found.
            max = Math.max(max, Math.min(height[beg], height[end])* (end-beg));
            //move pointers 
            if(height[beg] < height[end]) beg++;
            else end--;
        }
        return max; 
    }
    
}
 