import java.util.ArrayList;
import java.util.Arrays;

public class Kata5 {
    /*
     * completed 10/20/2020
     * 
     * Move the first letter of each word to the end of it, then add "ay" to the end
     * of the word. Leave punctuation marks untouched. just like the "pig latin"
     * language
     * 
     * test cases: System.out.println(Kata5.pigIt("Pig latin is cool"));
    */
    public static String pigIt(String str) {
        //seperate words into an array
        String[] strSplit = str.split(" ");
        String word; char letter;

        for(int i = 0; i < strSplit.length; i++){
            //reset pigged stringbuilder 
            StringBuilder pigged = new StringBuilder();
            word = strSplit[i]; //set current word
            System.out.println(word);
            if (word.length() > 1){
                //build string by looping through current word
                for(int a = 1; a < word.length(); a++){
                    letter = word.charAt(a); //set current letter
                    //if not at the last letter of the word add the next letter
                    if (a != word.length() -1){
                        pigged.append(letter);
                    } else {

                        pigged.append(letter).append(word.charAt(0)).append("ay");
                    }
                }
                //replace word with pig latin;
                strSplit[i] = pigged.toString();
            } else  if (!word.equals("!") && !word.equals("?")
                        && !word.equals(",") && !word.equals(".")){
                strSplit[i] = pigged.append(word).append("ay").toString();
                System.out.println(word.getClass());
            }
        }  
        return String.join(" ", strSplit); //return the array of words joined by " "
    }

    /*
     * completed 10/30/2020
     * 
     * Write a function, which takes a non-negative integer (seconds) as input and
     * returns the time in a human-readable format (HH:MM:SS)
     * 
     * test cases: System.out.println(Kata5.makeReadable(3600));
     */
    public static String makeReadable(int seconds) {
        int hours = 0; int minutes = 0;
        if(seconds >= 3600){  //find hours
            hours = seconds / 3600; 
            seconds = seconds % 3600; 
        }
        if(seconds >= 60){ //find minutes
            minutes = seconds / 60;
            seconds = seconds % 60; 
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    /*
     * completed 10/30/2020
     * 
     * … a man was given directions to go from one point to another. The directions
     * were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are
     * opposite, "WEST" and "EAST" too.
     * 
     * Going to one direction and coming back the opposite direction right away is a
     * needless effort. Since this is the wild WEST, with dreadfull weather and not
     * much water, it's important to save yourself some energy, otherwise you might
     * die of thirst!
     * 
     * So, given a set of directions remove any redundant directions and then return
     * only the correct moves.
     * 
     * test cases: System.out.println(Kata5.dirReduc(new String[]{"NORTH", "SOUTH",
     * "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
     */
    public static String[] dirReduc(String[] arr) {
        String lastDir; //used to hold last direction called
        String dir; //hold current direction
        ArrayList<String> reduced = new ArrayList<String>(Arrays.asList(arr));
        boolean redFound = false;
        String[][] directions = { {"NORTH", "SOUTH"}, {"EAST", "WEST"} };

        do {
            redFound = false;
            //if arr has a length of 1 or less return the arr in current state
            if (reduced.size() > 1 ) lastDir = reduced.get(0);
            else break; 

            for(int i = 1; i < reduced.size(); i++){ //loop to find redundant directions
                lastDir = reduced.get(i - 1).toUpperCase();  
                dir = reduced.get(i).toUpperCase();
                //find current direction in directions grid, then check if redundant
                for(String[] d : directions){
                    if(lastDir.equals(dir)) break; //not redundant if same directions
                    // find array that holds current direction
                    if (d[0].equals(dir) || d[1].equals(dir)){
                        //check if array holds last direction. then remove redundant
                        if (d[0].equals(lastDir) || d[1].equals(lastDir)){
                            reduced.remove(i-1); //remove offending directions.
                            reduced.remove(i-1);
                            i--; //decrement i since we removed elements
                            redFound = true; //a reduction has been found. Continue loop
                        } 
                    }
                }
            }
        } while (redFound);
        //convert reduced to String[] then return.
        String[] reducedStr = new String[reduced.size()];
        return reducedStr = reduced.toArray(reducedStr);
    }
}