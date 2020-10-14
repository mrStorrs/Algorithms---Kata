import java.util.Arrays;

public class Kata6 {
	/*
	 * completed 10/13/2020 
	 * If we list all the natural numbers below 10 that are
	 * multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is
	 * 23.Finish the solution so that it returns the sum of all the multiples of 3
	 * or 5 below the number passed in.
	 * 
	 * test cases: System.out.println(Kata6.sum3and5(10));
	 */
	public int sum3and5(int number) {
		int sum = 0; 
		if (number <= 0) { //check if number is -
			return 0;
		}
		for(int i = 0; i < number; i++) { //if number matches criteria add to sum
			if(i > 0 && i % 3 == 0 || i % 5 == 0){
				sum += i; 
			}
		}
		return sum;
	}
	
    /*	completed 10/13/2020
		Digital root is the recursive sum of all the digits in a number.
		Given n, take the sum of the digits of n. If that value has more than
		one digit, continue reducing in this way until a single-digit number
		is produced. The input will be a non-negative integer.
		
		test cases:	
	    System.out.println(Kata6.digital_root(16));
	*/
	public static int digital_root(int n) {
		while (n >= 10) {
			//create an array holding the single digit values of n
			String[] iterable = Integer.toString(n).split(""); 
			n = 0;		//reset n to 0;
			for (String num : iterable) {
				//add each of the values to n
				n += Integer.valueOf(num);
			}
		}
		return n;
	}
	
	/*
	 * completed 10/13/2020
	 * You probably know the "like" system from Facebook and
	 * other pages. People can "like" blog posts, pictures or other items. We want
	 * to create the text that should be displayed next to such an item. Your
	 * results should look like:
	 * 
	 * likes {} // must be "no one likes this"
	 * likes {"Peter"} // must be "Peter likes this"
	 * likes {"Jacob", "Alex"} // must be "Jacob and Alex like this"
	 * likes {"Max", "John", "Mark"} // must be "Max, John and Mark like this"
	 * likes {"Alex", "Jacob", "Mark", "Max"} // must be "Alex, Jacob and 2 others like this"
	 * 
	 * test cases: System.out.println(Kata6.whoLikesIt("Max", "John", "Mark"));
	 */
    public static String whoLikesIt(String... names) {
    	StringBuilder likes = new StringBuilder();
    	//depending on number of names return the following using stringbuilder
    	switch (names.length){
    		case 0:
    			return "no one likes this";
    		case 1:
    			return likes.append(names[0] + " likes this").toString();
    		case 2:
    			return likes.append(names[0] + " and " + names[1] +
    					" like this").toString();
    		case 3:
    			return likes.append(names[0] + ", " + names[1] + " and " +
    					names[2] + " like this").toString();
    		default:
    			return likes.append(names[0] + ", " + names[1] + " and " +
    					(names.length -2) +  " others like this").toString();
    	}
	}
	
	/*
	 * completed 10/14/2020
	 * 
	 * Write a function that takes in a string of one or more words, and returns the
	 * same string, but with all five or more letter words reversed. Strings passed
	 * in will consist of only letters and spaces. Spaces will be included only when
	 * more than one word is present.
	 * 
	 * Examples: spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
	 * 
	 * test cases: System.out.println(Kata6.spinWords("Hey fellow warriors"));
	 */
	public static String spinWords(String sentence) {
		String[] seperated = sentence.split(" "); //create an array holding ind words.

		for (int i = 0; i < seperated.length; i++){
			StringBuilder reverse = new StringBuilder(); //reset reversed string
			if (seperated[i].length() >= 5){
				for(int i2 = seperated[i].length() - 1; i2 >= 0; i2--){
					//loop through word startging at the end and build rev word.
					reverse.append(seperated[i].charAt(i2));
				}
				seperated[i] = reverse.toString(); // set the word to the rev word.
			}
		}
		return (String.join(" ", seperated)); //return the joined string
	}

	/*
	 * completed 10/14/2020
	 * 
	 * Write a function that takes an integer as input, and returns the number of
	 * bits that are equal to one in the binary representation of that number. You
	 * can guarantee that input is non-negative.
	 * 
	 * Example: The binary representation of 1234 is 10011010010, so the function
	 * should return 5 in this case
	 * 
	 * test cases: System.out.println(Kata6.countBits(1234));
	 */
	public static int countBits(int n) {
		String binary = Integer.toBinaryString(n); //convert to a binary string
		int bits = 0; //used to count 1's 
		for(int i = 0; i < binary.length(); i++){  //find 1's
			if(binary.charAt(i) == '1'){
				bits++;
			}
		}
		return bits; //return amt of 1's.
	}
	
	/*
	 * completed 10/14/2020
	 * 
	 * Write a function that accepts an array of 10 integers (between 0 and 9), that
	 * returns a string of those numbers in the form of a phone number.
	 * 
	 * Example: createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // =>
	 * returns "(123) 456-7890"
	 * 
	 * test cases: System.out.println(Kata6.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
	 */
	public static String createPhoneNumber(int[] numbers) {
		//array the same length of numbers. will hold numbers in string format
		String[] stringNum = new String[numbers.length];
		//add each int in numbers to the same position in stringNum as a String
		for(int i = 0; i < numbers.length; i++){
			stringNum[i] = Integer.toString(numbers[i]);
		}
		//return the properly formatted string.
		return String.format("(%s%s%s) %s%s%s-%s%s%s%s", stringNum);
	}
}
