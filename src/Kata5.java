import java.util.ArrayList;

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
        String lastDirection;
        ArrayList<String> reduced = new ArrayList<String>();
        boolean foundReduction = true;
        int currentSize; //used to see if any reductions or additions made
        while (foundReduction){
            currentSize = reduced.size();
            //make sure directions length is > 1 
            if (arr.length > 1 ){ //set last direction to first pos of array
                lastDirection = arr[0];
            } else return arr; //return array since there directions are simplified.
    
            //loop to move through the array testing directions
            for(int i = 1; i < arr.length; i ++ ){
                System.out.println("Current Itteration = " + i);
                switch (arr[i]) {
                    case "NORTH": 
                        if (!lastDirection.equals("SOUTH")) {
                            reduced.add(arr[i]);
                        } else if (reduced.size() > 0) {
                            reduced.remove(reduced.size() - 1);
                        }
                        break;
                    case "SOUTH": 
                        if (!lastDirection.equals("NORTH")) {
                            reduced.add(arr[i]);
                        } else if (reduced.size() > 0) {
                            reduced.remove(reduced.size() - 1);
                        }
                        break;
                    case "EAST": 
                        if (!lastDirection.equals("WEST")) {
                            reduced.add(arr[i]);
                            System.out.println(arr[i] + "bobo");
                        } else if (reduced.size() > 0) {
                            reduced.remove(reduced.size() - 1);
                        }
                        break;
                    case "WEST":
                        if (!lastDirection.equals("EAST")){
                            reduced.add(arr[i]);
                        } else if (reduced.size() > 0) {
                            reduced.remove(reduced.size() - 1);
                        }
                        break;
                }
                //if at the first itteration and there was a direction added, add  intial direction.
                if(i == 1 && !reduced.isEmpty()){
                    reduced.add(0, lastDirection);
                    System.out.println("adding the first direction");
                }
                lastDirection = arr[i]; //set to arr[i] since this will now be the last dir
            }
            if(currentSize == reduced.size()) foundReduction = false;
        }
        //declare final string array to the size of reduced array List 
        String[] finalReduced = new String[reduced.size()];
        finalReduced = reduced.toArray(finalReduced);
        for(String a : finalReduced){
            System.out.println(a);
        }
        return reduced.toArray(finalReduced); //return arraylist converted to array
    }
    
}