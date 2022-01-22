import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
	public int sum3and5(final int number) {
		int sum = 0;
		if (number <= 0) { // check if number is -
			return 0;
		}
		for (int i = 0; i < number; i++) { // if number matches criteria add to sum
			if (i > 0 && i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		return sum;
	}

	/*
	 * completed 10/13/2020 Digital root is the recursive sum of all the digits in a
	 * number. Given n, take the sum of the digits of n. If that value has more than
	 * one digit, continue reducing in this way until a single-digit number is
	 * produced. The input will be a non-negative integer.
	 * 
	 * test cases: System.out.println(Kata6.digital_root(16));
	 */
	public static int digital_root(int n) {
		while (n >= 10) {
			// create an array holding the single digit values of n
			final String[] iterable = Integer.toString(n).split("");
			n = 0; // reset n to 0;
			for (final String num : iterable) {
				// add each of the values to n
				n += Integer.valueOf(num);
			}
		}
		return n;
	}

	/*
	 * completed 10/13/2020 You probably know the "like" system from Facebook and
	 * other pages. People can "like" blog posts, pictures or other items. We want
	 * to create the text that should be displayed next to such an item. Your
	 * results should look like:
	 * 
	 * likes {} // must be "no one likes this" likes {"Peter"} // must be
	 * "Peter likes this" likes {"Jacob", "Alex"} // must be
	 * "Jacob and Alex like this" likes {"Max", "John", "Mark"} // must be
	 * "Max, John and Mark like this" likes {"Alex", "Jacob", "Mark", "Max"} // must
	 * be "Alex, Jacob and 2 others like this"
	 * 
	 * test cases: System.out.println(Kata6.whoLikesIt("Max", "John", "Mark"));
	 */
	public static String whoLikesIt(final String... names) {
		final StringBuilder likes = new StringBuilder();
		// depending on number of names return the following using stringbuilder
		switch (names.length) {
			case 0:
				return "no one likes this";
			case 1:
				return likes.append(names[0] + " likes this").toString();
			case 2:
				return likes.append(names[0] + " and " + names[1] + " like this").toString();
			case 3:
				return likes.append(names[0] + ", " + names[1] + " and " + names[2] + " like this").toString();
			default:
				return likes.append(names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this")
						.toString();
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
	public static String spinWords(final String sentence) {
		final String[] seperated = sentence.split(" "); // create an array holding ind words.

		for (int i = 0; i < seperated.length; i++) {
			final StringBuilder reverse = new StringBuilder(); // reset reversed string
			if (seperated[i].length() >= 5) {
				for (int i2 = seperated[i].length() - 1; i2 >= 0; i2--) {
					// loop through word startging at the end and build rev word.
					reverse.append(seperated[i].charAt(i2));
				}
				seperated[i] = reverse.toString(); // set the word to the rev word.
			}
		}
		return (String.join(" ", seperated)); // return the joined string
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
	public static int countBits(final int n) {
		final String binary = Integer.toBinaryString(n); // convert to a binary string
		int bits = 0; // used to count 1's
		for (int i = 0; i < binary.length(); i++) { // find 1's
			if (binary.charAt(i) == '1') {
				bits++;
			}
		}
		return bits; // return amt of 1's.
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
	 * test cases: System.out.println(Kata6.createPhoneNumber(new int[] {1, 2, 3, 4,
	 * 5, 6, 7, 8, 9, 0}));
	 */
	public static String createPhoneNumber(final int[] numbers) {
		// array the same length of numbers. will hold numbers in string format
		final String[] stringNum = new String[numbers.length];
		// add each int in numbers to the same position in stringNum as a String
		for (int i = 0; i < numbers.length; i++) {
			stringNum[i] = Integer.toString(numbers[i]);
		}
		// return the properly formatted string.
		return String.format("(%s%s%s) %s%s%s-%s%s%s%s", stringNum);
	}

	/*
	 * completed 10/16/2020
	 * 
	 * You are given an array (which will have a length of at least 3, but could be
	 * very large) containing integers. The array is either entirely comprised of
	 * odd integers or entirely comprised of even integers except for a single
	 * integer N. Write a method that takes the array as an argument and returns
	 * this "outlier" N.
	 * 
	 * test cases: System.out.println(Kata6.find(new int[] {1, 2, 4, 6,}));
	 */
	public static int find(int[] integers) {
		int even = 0; int odd = 0; //used to count # of even orodd
		int evenIndex = 0; int oddIndex = 0; //used to hld the last index a even or odd was found.
		//search integers, logging even/odd numbers and last indexs
		for(int i = 0; i < integers.length; i++){
			if (integers[i] % 2 == 0){
				even++;
				evenIndex = i; //save last position an even # found.
			} else {
				odd++;
				oddIndex =i;
			}
		}
		if (even == 1){ //figure out which one only has one. then return.
			return integers[evenIndex];
		} else {
			return integers[oddIndex];
		}
	}

	/*
	 * completed 10/16/2020
	 * 
	 * You live in the city of Cartesia where all roads are laid out in a perfect
	 * grid. You arrived ten minutes too early to an appointment, so you decided to
	 * take the opportunity to go for a short walk. The city provides its citizens
	 * with a Walk Generating App on their phones -- everytime you press the button
	 * it sends you an array of one-letter strings representing directions to walk
	 * (eg. ['n', 's', 'w', 'e']). You always walk only a single block for each
	 * letter (direction) and you know it takes you one minute to traverse one city
	 * block, so create a function that will return true if the walk the app gives
	 * you will take you exactly ten minutes (you don't want to be early or late!)
	 * and will, of course, return you to your starting point. Return false
	 * otherwise.
	 * 
	 * test cases: System.out.println(Kata6.isValidWalk(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
	 */
	public static boolean isValidWalk(char[] walk) {
		int[] location = {0, 0}; //used as x and y coordinates.
		int[] home = {0,0}; //used to check if we reached home.
		for(char direction : walk){ //change coord accordingly.
			switch (direction){
				case 'n':
					location[0]++;
					break;
				case 'e':
					location[1]++;
					break;
				case 's':
					location[0]--;
					break;
				case 'w':
					location[1]--;
					break;
			}
		}
		//check if we made it back home and our walk was 10 minutes.
		if(walk.length == 10 && Arrays.equals(home, location)){
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * completed 10/16/2020
	 * 
	 * A local DJ has taken a bunch of songs and remixed them by adding "WUB"
	 * randomly through the song. Given a String of words remove all the "WUB" from
	 * the string.
	 * 
	 * test cases: System.out.println(Kata6.SongDecoder("RWUBWUBWUBLWUB"));
	 */
	public static String SongDecoder(String song) {
		//short and easy
		return song.replaceAll("(WUB)+", " ").trim();

		/* long way. Original code. revamped to above!
		StringBuilder decoded = new StringBuilder();
		boolean wubFound = false;

		for(int i = 0; i < song.length(); i++){
			char letter = song.charAt(i);

			if (song.charAt(i) == 'W'){ //find any capital W's
				//attempt to see if there is a capital U and B after the W
				try{
					if(song.charAt(i+1) == 'U' && song.charAt(i+2) == 'B'){
						wubFound = true;
						i+=2; //if there is then skip over them.
					} else {
						if (wubFound && decoded.length() > 0) {
							decoded.append(' ');
						}
						decoded.append(letter);
						wubFound = false;

					}
				} catch (Exception e) {
					System.out.println("Not WUB, or @ end of string.");
				}
			} else {
				if (wubFound && decoded.length() > 0){
					decoded.append(' ');
				}
				decoded.append(letter);
				wubFound = false;
			}
		}
		return decoded.toString();
		*/
	}
	
	/*
	 * completed 10/20/2020
	 * 
	 * given an array of 3 ints and an int. return an array that uses the last 3
	 * numbers of the sequence to generate the next number by summing the last 3
	 * #'s. the returned array should be the length of the single int given.
	 * 
	 * example: given {1,1,1},10, return; {1,1,1,3,5,9,17,31,57,105}
	 * 
	 * test cases: System.out.println(Kata6.tribonacci(new double []{1,1,1},10));
	 */
	public static double[] tribonacci(double[] s, int n) {
		double[] tSum = new double[n]; // array to hold summed values
		for(int i = 0; i < n; i++){
			if(i == 0 || i == 1 || i == 2){ // for first 3 indexs just add the element
				tSum[i] = s[i];
			} else { //then start summing the last 3 values in tSum
				tSum[i] = tSum[i-1] + tSum[i-2]  + tSum[i-3];
			}
		}
		return tSum;
	}

	/*
	 * completed 10/20/2020
	 * 
	 * Your task is to sort a given string. Each word in the string will contain a
	 * single number. This number is the position the word should have in the
	 * result.
	 * 
	 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
	 * 
	 * If the input string is empty, return an empty string. The words in the input
	 * String will only contain valid consecutive numbers.
	 * 
	 * test cases: System.out.println(Kata6.order("is2 Thi1s T4est 3a");
	 */
	public static String order(String words) {
		//check if empty string given.
		if(words.length() == 0) return "";
		//create a new array with the words split
		String[] wordsSplit = words.split(" ");
		//this array will hold the ordered items.
		String[] ordered = new String[wordsSplit.length];
		int index; //will hold the index the word should be at.
		for(int i = 0; i < wordsSplit.length; i ++){
			// get the index the word should be at by removing all non-digits then
			// casting the remaining value to an int, then subtract 1
			index = Integer.valueOf(wordsSplit[i].replaceAll("\\D+", "")) - 1;
			ordered[index] = wordsSplit[i]; //add word @ the proper index.
		}
		return String.join(" ", ordered);
	}

	/*
	 * completed 11/3/2020
	 * 
	 * You are going to be given an array of integers. Your job is to take that
	 * array and find an index N where the sum of the integers to the left of N is
	 * equal to the sum of the integers to the right of N. If there is no index that
	 * would make this happen, return -1.
	 * 
	 * For example:
	 * 
	 * Let's say you are given the array {1,2,3,4,3,2,1}: Your function will return
	 * the index 3, because at the 3rd position of the array, the sum of left side
	 * of the index ({1,2,3}) and the sum of the right side of the index ({3,2,1})
	 * both equal 6.
	 * 
	 * Let's look at another one. You are given the array {1,100,50,-51,1,1}: Your
	 * function will return the index 1, because at the 1st position of the array,
	 * the sum of left side of the index ({1}) and the sum of the right side of the
	 * index ({50,-51,1,1}) both equal 1.
	 * 
	 * Last one: You are given the array {20,10,-80,10,10,15,35} At index 0 the left
	 * side is {} The right side is {10,-80,10,10,15,35} They both are equal to 0
	 * when added. (Empty arrays are equal to 0 in this problem) Index 0 is the
	 * place where the left side and right side are equal.
	 * 
	 * Note: Please remember that in most programming/scripting languages the index
	 * of an array starts at 0
	 * 
	 * test cases: System.out.println(Kata6.findEvenIndex(new int[] {1,2,3,4,3,2,1}));
	 */
	public static int findEvenIndex(int[] arr) {
		int mainIndex = 0; //used to keep track of "middle" point
		
		while (mainIndex < arr.length){
			int leftSum = 0; int rightSum = 0; //will hold sums for left and right side
			//iterate through array, adding to left or right depending on pos.
			for(int i = 0; i < arr.length; i++){
				if (i < mainIndex){
					leftSum += arr[i];
				} else if (i > mainIndex){
					rightSum += arr[i];
				}
			}
			if (leftSum == rightSum){ //found evenIndex return spot
				return mainIndex;
			}
			mainIndex++; //increment mainIndex.
		}
		return -1;
	}

	/*
	 * completed 11/25/2020
	 * 
	 * A child is playing with a ball on the nth floor of a tall building. The
	 * height of this floor, h, is known.
	 * 
	 * He drops the ball out of the window. The ball bounces (for example), to
	 * two-thirds of its height (a bounce of 0.66).
	 * 
	 * His mother looks out of a window 1.5 meters from the ground.
	 * 
	 * How many times will the mother see the ball pass in front of her window
	 * (including when it's falling and bouncing?
	 * 
	 * Three conditions must be met for a valid experiment: Float parameter "h" in
	 * meters must be greater than 0 Float parameter "bounce" must be greater than 0
	 * and less than 1 Float parameter "window" must be less than h. If all three
	 * conditions above are fulfilled, return a positive integer, otherwise return
	 * -1.
	 * 
	 * Note: The ball can only be seen if the height of the rebounding ball is
	 * strictly greater than the window parameter.
	 * 
	 * test cases: System.out.println(Kata6.bouncingBall(3.0, 0.66, 1.5));
	 */
	public static int bouncingBall(double h, double bounce, double window) {
		int bounces = -1; //start neg, since first ball is only seen on drop
		//make sure experiment is  valid
		if(h <= window || bounce < 0 || bounce >= 1 || window <= 0) return -1;
		while(h > window){
			bounces += 2; //add bounces for this runthrough 
			h = h * bounce; //set new height 
		}
		return bounces;	
	}

	/*
	 * completed 12/1/2020
	 * 
	 * Write a function that will return the count of distinct case-insensitive
	 * alphabetic characters and numeric digits that occur more than once in the
	 * input string. The input string can be assumed to contain only alphabets (both
	 * uppercase and lowercase) and numeric digits.
	 * 
	 * test cases: System.out.println(Kata6.duplicateCount(abcde));
	 */
	public static int duplicateCount(String text) {
		int count = 0; 
		//create a new map to hold the letters 
		HashMap<Character, Integer> found = new HashMap<Character, Integer>();
		for(int i = 0; i < text.length(); i++){ 
			//find the Character at I and covert it to lowercase
			Character c = Character.toLowerCase(text.charAt(i));
			if (!found.containsKey(c)) found.put(c, 1); // add key if none
			else{
				found.put(c, found.get(c) + 1); //increment value 
				if (found.get(c)  == 2) count++; //found duplicate add to count.
			}
		}
		return count; 
	}

	/*
	 * completed 12/3/2020
	 * 
	 * Complete the method/function so that it converts dash/underscore delimited
	 * words into camel casing. The first word within the output should be
	 * capitalized only if the original word was capitalized (known as Upper Camel
	 * Case, also often referred to as Pascal case).
	 * 
	 * test cases: System.out.println(Kata6.toCamelCase("the-stealth-warrior"));
	 */
	public static String toCamelCase(String s) {
		StringBuilder camel = new StringBuilder(s.length());
		for(int i = 0; i < s.length(); i++){
			if (s.charAt(i) == '-' || s.charAt(i) == '_'){ 
				camel.append(Character.toUpperCase(s.charAt(i+1))); //add next char as UPPER.
				i++; //increment i since we just added the next letter already.
			} 
			else if (i == 0 ) camel.append(s.charAt(i)); //add first value as is.
			else camel.append(Character.toLowerCase(s.charAt(i))); //add lowercase C to 
		}
		return camel.toString();
	}

	/*
	 * completed 12/7/2020
	 * 
	 * Given a positive integer n written as abcd... (a, b, c, d... being digits)
	 * and a positive integer p
	 * 
	 * we want to find a positive integer k, if it exists, such as the sum of the
	 * digits of n taken to the successive powers of p is equal to k * n. If true
	 * return K, else return false.
	 * 
	 * test cases: System.out.println(Kata6.digPow(89, 1));
	 */
	public static long digPow(int n, int p) {
		int sum = 0; //used to hold sum
		int nTemp; //will hold ind value of each num in nStr
		//convert int to string so we can iterate through each number
		String nStr = Integer.toString(n);
		//loop through string adding adding squared values
		for(int i = 0; i < nStr.length(); i++){
			nTemp = Character.getNumericValue(nStr.charAt(i)); //convert char to int.
			sum += Math.pow(nTemp, p); //add the value to sum
			p++; //increment p
		}
		if (sum == (sum / n) * n) return sum / n; //checking condiiton
		else return -1;
	}

	/*
	 * Your task is to construct a building which will be a pile of n cubes. The
	 * cube at the bottom will have a volume of n^3, the cube above will have volume
	 * of (n-1)^3 and so on until the top which will have a volume of 1^3.
	 * 
	 * You are given the total volume m of the building. Being given m can you find
	 * the number n of cubes you will have to build?
	 * 
	 * The parameter of the function findNb (find_nb, find-nb, findNb) will be an
	 * integer m and you have to return the integer n such as n^3 + (n-1)^3 + ... +
	 * 1^3 = m if such a n exists or -1 if there is no such n.
	 * 
	 * * test cases: System.out.println(Kata6.findNb(4183059834009L));
	 */
	public static long findNb(long m){
		/* if we divide m by the sum of all previous n's then it should 
		 * = the sum of all n's. Thus this loop increments n and adds to the 
		 * sum until the answer is either = to each other or less than sumN (signifying
		 * that there is not int that matches.)	*/
		int n = 1; //used to hold n
		int sumN = 1; //used to hold the sum of all n's
		while( m / sumN > sumN){ //loop to increment n till desired outcome found
			n++; 
			sumN += n;
		}
		if( m % sumN > 0.0D) return -1; //no int that matches so return -1
		else return (long) n; //else return the n.
	}
	
}


