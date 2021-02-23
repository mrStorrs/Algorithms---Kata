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

    /*
     * 5. Longest Palindromic Substring
     * 
     * Given a string s, return the longest palindromic substring in s.
     * 
     * test cases:
     * System.out.println(LeetCodeMedium.longestPalindrome(randomString));
     */
    }
    
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
}
