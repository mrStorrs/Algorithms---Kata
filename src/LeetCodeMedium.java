import java.util.LinkedList;

public class LeetCodeMedium {
    /*
     * #3 Longest Substring without repeating characters. completed 2/18/2020
     * 
     * Given a string s, find the length of the longest substring without repeating
     * characters.
     * 
     * 
     * test cases: System.out.println(LeetCodeMedium.lengthOfLongestSubstring(randomString);
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
}
