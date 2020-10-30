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
}