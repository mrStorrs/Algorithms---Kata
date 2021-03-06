public class Kata2 {
    /*
        Same as the original Kata7 coloured triangle except much harder.
        The algo must be able to run:
            100 tests of 100 <= length(row) <= 1000
            100 tests of 1000 <= length(row) <= 10000
            100 tests of 10000 <= length(row) <= 100000
        in under 16000 ms.
            
        A colored triangle is created from a row of colors,
        each of which is red, green or blue. Successive rows, each containing one
        fewer color than the last, are generated by considering the two touching
        Colors in the previous row. If these colors are identical, the same color
        is used in the new row. If they are different, the missing color is used in
        the new row. This is continued until the final row, with only a single
        Color, is generated.
	   
	    Options are: G-G -> G B-G -> R R-G -> B B-R -> G
	  
	    test cases: System.out.println(Kata2.triangle("RBRGBRB"));
	 */
	
	/*
	 * Optimization: starting avg time over 100 tests  ~176ms
	 * 1. using string builder instead of concatenations (shaved off ~110 milli per test!!! new avg ~59ms)
	 * 2. look for patterns. (THIS DID IT! test time down to 1ms -- on a random 100000 test ~67ms)
	 * 		a. 	pattern found!! when given 4 numbers if you use the 1st and 4rth number you
	 * 			get the number @ the bottom. This pattern can then be used anytime the
	 * 			row.length() % 3 == 1; Significantly lowering processing time whenever that occurs.
	 * 3. remove reuse of code and create method/sub-routine for checking indexes.
	 */
    public static char triangle(final String row) {
        String currRow = row;
        boolean notBottom = true;
        // if only 1 letter, return the char
        if (row.length() == 1) {
            return row.charAt(0);
        }
        while (notBottom) {
        	StringBuilder nextRow = new StringBuilder(); //reset nextRow
        	//this is where the bulk of the time is shaved off. when there is 4 letters,
        	//you can take the outside 2 and that will give you the answer to the bottom letter
        	//this is essentially breaking up the larger triangle into smaller triangles
        	if(currRow.length() %3 ==1) {
                for (int i = 3; i < currRow.length(); i+=3) {
                	nextRow.append(triangleCheck(currRow.charAt(i), currRow.charAt(i - 3)));
                }
                currRow = nextRow.toString(); // set row to equal the new nextRow
                if (currRow.length() == 1) { // check if last letter.
                    notBottom = false;
                }
                
        	} else { //run the normal method when cannot do above.
                for (int i = 1; i < currRow.length(); i++) {
                	nextRow.append(triangleCheck(currRow.charAt(i), currRow.charAt(i - 1)));
                }
                currRow = nextRow.toString(); // set row to equal the new nextRow
                if (currRow.length() == 1) { // check if last letter.
                    notBottom = false;
                }
        	}
        }
        return currRow.charAt(0);
    }
    //method used to check next color for triangle.
    public static String triangleCheck(char index1, char index2) {
    	//create a new string using StringBuilder with both indexes
		String both = new StringBuilder().append(index1).append(index2).toString();
        // figure out which color it should be, then return
        if (index1 == index2) {
        	return String.valueOf(index1);
        } else if (both.indexOf('R') == -1) {
            return "R";
        } else if (both.indexOf('G') == -1) {
            return "G";
        } else {
            return "B";
        }
    }
}