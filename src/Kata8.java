import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Kata8{
    /* completed: 9/11/2020
     check if integer is positive in array. if it is then add to a
     sum and return sum at end of array.
    */
    public static int sum(int[] arr){
    	int sum = 0;
    	for(int i = 0; i < arr.length; i++) {
    		if (arr[i] > 0){
    			sum += arr[i];
    		}
    	}
        return sum;
    }
    
    /* completed: 9/11/2020    
      Write a function findNeedle() that takes an array full of junk but containing one "needle"
	  After your function finds the needle it should return a message (as a string) that says:
	  "found the needle at position " plus the index it found the needle, so:
	
	  test cases
	  Object[] haystack1 = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false}
    */
    public static String findNeedle(Object[] haystack) {
    	String found;
    	int count = -1; //used to track index
        // Your code here
    	for (Object treasure : haystack ) {
    		count ++; 

    		if (treasure instanceof String) { //check type to avoid null pointer exception
    			if (treasure.equals("needle")){ //find needle and then return it with index
    				found = "found the needle at position " + String.valueOf(count);
    				return found;
    			}    			
    		}
    	}
    	return null;
    }
    
    /*  completed: 9/11/2020 
      Given a non-negative integer, 3 for example, 
      return a string with a murmur: "1 sheep...2 sheep...3 sheep...". 
      Input will always be valid, i.e. no negative integers.
    */
    public static String countingSheep(int num) {
        String sheep = "";
        for(int i = 1; i <= num; i++) {
        	sheep += String.valueOf(i) + " sheep...";
        }
    	return sheep;
    }
    
    /* 	completed: 9/11/2020
       	Create a method that accepts 2 strings of either rock paper or scissors. then decide who wins
       	if it is a draw return "Draw!". if a player wins return "Player (player) won!"
    
    	test cases:
        System.out.println(Kata8.rps("rock", "scissors"));
        System.out.println(Kata8.rps("paper", "scissors"));
        System.out.println(Kata8.rps("rock", "rock"));
    */ 
    public static String rps(String p1, String p2) {
    	String p1win = "Player 1 won!";
    	String p2win = "Player 2 won!";
    	
        if (p1.equals(p2)){ //check if both players picked same
        	return "Draw!";
        //check all conditions that p1 can win. if none found return p2win
        } else if ((p1 == "rock" && p2 == "scissors")
        		   || (p1 == "scissors" && p2 == "paper") 
        		   || (p1 == "paper" && p2 == "rock")) {
        	return p1win;	
        } else {
        	return p2win;
        }
    }
    
    /*	completed: 9/12/2020
    	Character recognition software is widely used to digitise printed texts. Thus the texts can be edited, searched and stored on a computer.
		When documents (especially pretty old ones written with a typewriter), are digitised character recognition softwares often make mistakes.
		Your task is correct the errors in the digitised text. You only have to handle the following mistakes:

		S is misinterpreted as 5
		O is misinterpreted as 0
		I is misinterpreted as 1
		The test cases contain numbers only by mistake.
		
		test cases:
v
    */
    
    public static String correct(String string) {
    	String corrected = "";
    	for(int  i=0; i<string.length(); i++) {
    		char c = string.charAt(i); //get character at index
    		switch(c) { //check if character matches common mistakes. then add corrected or default.
    		case '5': corrected += "S"; break;
    		case '0': corrected += "O"; break;
    		case '1': corrected += "I"; break;
    		default: corrected += String.valueOf(c); break;
    		}
    	}
    	return corrected;
    }
    
    /*	completed: 9/12/2020
     	write me a function stringy that takes a size and returns a string of alternating '1s' and '0s'.
		the string should start with a 1. a string with size 6 should return :'101010'.
		with size 4 should return : '1010'. with size 12 should return : '101010101010'.
		The size will always be positive and will only use whole numbers.
		
		test cases:
        System.out.println(Kata8.stringy(6));
    */
    public static String stringy(int size) {
    	String binaryish = "";
    	for(int i=0; i < size; i++) {
    		if(i % 2 == 0) {
    			binaryish += "1";
    		} else {
    			binaryish += "0";
    		}
    	}
    	return binaryish;
    }
    
    /* 	completed 9/12/2020
    	Replace all vowel to exclamation mark in the sentence. aeiouAEIOU is vowel.
    	
    	test cases:
        System.out.println(Kata8.replace("ABCDE"));
        System.out.println(Kata8.replace("Hi!"));
    */
    public static String replace(final String s) {
    	String noVowels = ""; //will hold new string with ! instead of vowles
    	char c; //will hold current char in string
    	String vowels = "aeiouAEIOU"; //what to look for to replace.
    	
    	for(int i=0; i<s.length(); i++) { //loop through string
    		c = s.charAt(i); //set c to item at current index
        	boolean foundVowel = false; //reset to false
    		for(int v=0; v<vowels.length(); v++) { //loop through vowels string
    			if (c == vowels.charAt(v)) { //when vowel found, add ! and set foundvowel to true
    				noVowels += "!"; 
    				foundVowel = true;
    			}
    		}
    		if(!foundVowel) { //if no vowel found add c to noVowels.
    			noVowels += c;
    		}
    	}
    	return noVowels;
    }
    /* 	completed 9/12/2020
		Create a function that will return a string that combines all of the letters of the three
		inputed strings in groups. Taking the first letter of all of the inputs and grouping them
		next to each other. Do this for every letter, see example below!
		E.g. Input: "aa", "bb" , "cc" => Output: "abcabc"	
		Note: You can expect all of the inputs to be the same length.
		
		test cases:
	    System.out.println(Kata8.tripleTrouble("Bm", "aa", "tn"));
	    System.out.println(Kata8.tripleTrouble("LLh","euo","xtr"));
	*/	
    public static String tripleTrouble(String one, String two, String three) {
    	String combined = ""; //string to hold new letters
    	for(int i=0; i<one.length(); i++) {
    		combined += one.charAt(i);
    		combined += two.charAt(i);
    		combined += three.charAt(i);
    	}
        return combined;
      }
    
    /* 	completed 9/13/2020
		Convert number to reversed array of digits
		Given a random non-negative number, you have to return the digits of this number within
		an array in reverse order.
		
		test cases:
	    System.out.println(Kata8.digitize(35231));
	*/	
    public static int[] digitize(long n) { 
    	String nString = Long.toString(n); //convert long to string to so it can be iterated through.
    	int[] arrayed = new int[nString.length()] ; //create new array with size of nString
    	int index = 0;
    	
    	for(int reverseIndex=nString.length()-1; reverseIndex>=0; reverseIndex--) { //loop from end of string
    		//set arrayed at index to the numerical value of the character at the reversed index
    		arrayed[index] = Character.getNumericValue(nString.charAt(reverseIndex));
    		index++; 
    	}
    	return arrayed;
    }
    
    /* 	completed 9/15/2020
		Very simple, given a number, find its opposite.
		eg. 5 = -5, or , -5 = 5
		
		test cases:
	    System.out.println(Kata8.oppositeNum(5));
	*/
    public static int oppositeNum(int num) {
    	return num * -1;
    }
    
    /* 	completed 9/15/2020
		It's pretty straightforward. Your goal is to create a function that removes the first and last
		characters of a string. You're given one parameter, the original string. Only strings with 3+ chars
		will be given.
		
		test cases:
	    System.out.println(Kata8.removeFL("test"));
	*/
    public static String removeFL(String str) {
    	String removed = "";
    	for (int i=0; i<str.length(); i++) {
    		if(i != 0 && i != str.length()-1) {
    			removed += str.charAt(i);
    		}
    	}
    	return removed;
    }
    
    /* 	completed 9/15/2020
		In this simple assignment you are given a number and have to make it negative. leave 0's and negatives alone
	*/
    public static int makeNegative(int num) {
    	if(num > 0) {    		
    		return num * -1;
    	} else {
    		return num;
    	}
    }
    
    /* 	completed 9/15/2020
		Write a function called repeat_str which repeats the given string a specified amount of times.
		
		test cases:
	    System.out.println(Kata8.repeatStr("test"));
	*/
    
    public static String repeatStr(int repeat,String string) {
    	String repeated = "";
    	while(repeat > 0) {
    		repeated += string;
    		repeat--;
    	}
        return repeated;
    }
    
    /* 	completed 9/15/2020
		Simple, remove the spaces from the string, then return the resultant string.
		
		test cases:
	    System.out.println(Kata8.noSpace("te st"));
	*/
    public static String noSpace(String x) {
    	String noSpaces = "";
    	for(int i=0; i<x.length(); i++) {
    		if(x.charAt(i) != ' ') {
    			noSpaces += x.charAt(i);
    		}
    	}
        return noSpaces;
    }
    
    /* 	completed 9/15/2020
		Simple, remove the spaces from the string, then return the resultant string.
		
		test cases:
	    System.out.println(Kata8.findSmallestInt([78,56,232,12,11,43]));
	*/
    public static int findSmallestInt(int[] args) {
    	int min = args[0];
    	for(int num : args) {
    		if(num < min) {
    			min = num;
    		}
    	}
    	return min;
    }
    
    /* 	completed 9/15/2020
		Write a program that finds the summation of every number from 1 to num.
		The number will always be a positive integer greater than 0.
		
		test cases:
	    System.out.println(Kata8.summation(28));
	*/
    public static int summation(int n) {
        int sum = 0; //used to hold sum
        while(n > 0) { 
        	sum += n; //add n to running sum
        	n--;
        }
        return sum;
    }
    
    /* 	completed 9/15/2020
		Complete the method that takes a boolean value and return a "Yes" string for true,
		or a "No" string for false.
		
		test cases:
	    System.out.println(Kata8.boolToWord(true));
	*/
    public static String boolToWord(boolean b) {
    	if(b) {
    		return "Yes";
    	} else {
    		return "No";
    	}
    }
    
    /* 	completed 9/18/2020
		Convert an int to a string.
		
		test cases:	
	    System.out.println(Kata8.numbeToString(123));
	*/
    public static String numberToString(int num) {
        return Integer.toString(num);
    }
    
    /* 	completed 9/18/2020
		reverse the string that is passed into the method.
		
		test cases:	
	    System.out.println(Kata8.reverseString("hello"));
	*/
    public static String reverseString(String str) {
    	String rev = "";
    	for(int i = str.length()-1; i >= 0; i--) {
    		rev += str.charAt(i);
    	}
    	return rev;
    }
    
    /* 	completed 9/18/2020
		Consider an array/list of sheep where some sheep may be missing from their place. We need a function
		that counts the number of sheep present in the array (true means present). return int that 
		is the amount of sheep

		test cases:	
	    System.out.println(Kata8.countSheeps(Boolean[] sheep = {true,  true,  true,  false}));
	*/
    public int countSheeps(Boolean[] arrayOfSheeps) {
    	int count = 0;
    	for(Boolean b : arrayOfSheeps) {
    		try { //using a try statement since if b is not a boolean an error will be thrown.
    			if(b) {
    				count++;
    			}
    		} catch (Exception e) {
    			System.out.println("not a boolean.");
    		}
    	}
    	return count;
    }
    
    /* 	completed 9/18/2020
		Complete the square sum function so that it squares each number passed into it and then sums the results together.

		test cases:	
	    System.out.println(Kata8.squareSum(new int[] {1,2,2}));
	*/
    public static int squareSum(int[] n){ 
    	int sum = 0;
    	for(int num : n) { //loop through array, squaring the value then adding it to sum.
    		sum += num * num;
    	}
    	return sum;
    }
    
    /* 	completed 9/18/2020
		Make a simple function that returns the famous "hello world" 

		test cases:	
	    System.out.println(Kata8.greet());
	*/
    public static String greet() {
    	return ("hello world");
    }
    
    /* 	completed 9/18/2020
		Your task is to create a function that does four basic mathematical operations.
		The function should take three arguments - operation(string/char), value1(number), value2(number).
		The function should return result of numbers after applying the chosen operation.

		test cases:	
	    System.out.println(Kata8.basicMath("+", 4, 7));
	*/
    public static Integer basicMath(String op, int v1, int v2) {
    	switch(op){ // find which math statement matches and do applicable math.
    	case "+": 
    		return v1 + v2;
    	case "-":
    		return v1 - v2;
    	case "*":
    		return v1 * v2;
    	case "/":
    		return v1 / v2;
    	}
    	return null; //just incase none of the cases work
    }
    
    /* 	completed 9/18/2020
		Nathan loves cycling.
		Because Nathan knows it is important to stay hydrated, he drinks 0.5 litres of water per hour of cycling.
		You get given the time in hours and you need to return the number of litres Nathan will drink, rounded to the smallest value.

		test cases:	
	    System.out.println(Kata8.liters(1.2));
	*/
    public int liters(double time)  {
    	return (int) (0.5 * time);
    }
    
    /* 	completed 9/18/2020
		The first century spans from the year 1 up to and including the year 100, The second - from the year 101 up to and including the year 200, etc.
	
		test cases:	
	    System.out.println(Kata8.century(1705));
	*/
    public static int century(int number) {
    	int getCent = (int)(number * .01); //convert to 10's place

    	if (number % 100 == 0) { //check if it is the last year of the previous century
    		return getCent;
    	} else {
    		return getCent + 1;
    	}
    }
    
    /* 	completed 9/18/2020
		Create a function that checks if a number n is divisible by two numbers x AND y. All inputs are positive, non-zero digits.
		return true if both are divisible by the number.
	
		test cases:	
	    System.out.println(Kata8.isDivisible(12,4,3));
	*/
    public static boolean isDivisible(long n, long x, long y) {
		if(n % x == 0 && n % y == 0) {
			return true;
		} else {
			return false;
		}
	}
	
    /* 	completed 9/18/2020
		We need a function that can transform a string into a number. What ways of achieving this do you know?
		Note: Don't worry, all inputs will be strings, and every string is a perfectly valid representation of an 	integral number.
			
		test cases:	
	    System.out.println(Kata8.stringToNumber("18"));
	*/
	public static int stringToNumber(String str) {
		 return Integer.parseInt(str);
	}
	  
    /* 	completed 9/21/2020
		Given an array of integers, return a new array with each value doubled.
		For the beginner, try to use the map method - it comes in very handy quite a lot so is a good one to know.
		
		test cases:	
	    System.out.println(Kata8.arrDouble(new int[] = {1,2,3,4}));
	*/
	public static int[] arrDouble(int[] arr) {
		
	    return Arrays.stream(arr).map(x -> x*2).toArray(); // using map to return array with doubled ints
	    
	    //below way will also return the correct int array without using the map function.
//		int[] doubled = new int[arr.length];
//		for(int i = 0; i < arr.length; i++) {
//			doubled[i] = arr[i] * 2;
//		}
//		return doubled;
	}
	
    /* 	completed 9/22/2020
		Write a function to convert a name into initials. This kata strictly takes two words with one space 
		in between them.The output should be two capital letters with a dot separating them.
		
		test cases:	
	    System.out.println(Kata8.abbrevName("Sam Harris"));
	*/
	public static String abbrevName(String name) {
		String initials = "" + name.charAt(0) + "."; 
		for(int i = 0; i < name.length(); i++) { //loop through and find the space 
			if(name.charAt(i) == ' ') {
				initials += name.charAt(i + 1); //add the letter after the space to initials
				break; //break loop
			}
		}
		return initials.toUpperCase(); //returning intials in all uppercase
	}
	
    /* 	completed 9/22/2020
		Given an array of integers. Return an array, where the first element is the count of positives numbers and
		the second element is sum of negative numbers. If the input array is empty or null, return an empty array.
		
		test cases:	
	    System.out.println(Kata8.countPositivesSumNegatives(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
	*/
    public static int[] countPositivesSumNegatives(int[] input) {
    	int countPos = 0; 
    	int sumNeg = 0;
    	int[] empty = {};
    	int countSum[] = new int[2];

    	if(input == null) { //check for null or empty arrays
    		return empty;
    	} else if (input.length == 0) {
    		return empty;
    	}
    	

    	for(int num : input) { //loop through and find positives and neg, then do respective options.
    		if(num > 0) {
    			countPos++;
    		} else {
    			sumNeg += num;
    		}
    	}
    	countSum[0] = countPos; countSum[1] = sumNeg; //set values to aray.
        return countSum; //return an array with count of positives and sum of negatives
    }
    
    /* 	completed 9/22/2020
		You take your son to the forest to see the monkeys. You know that there are a certain number there (n), but your
		son is too young to just appreciate the full number, he has to start counting them from 1. As a good parent, you
		will sit and count with him. Given the number (n), populate an array with all numbers up to and including that
		number, but excluding zero.
		
		test cases:	
	    System.out.println(Kata8.monkeyCount(5));
	*/
    public static int[] monkeyCount(final int n){
    	int[] monkeys = new int[n]; //init array to hold count to size of n

    	for(int i = 1; i <= n; i++) { //loop through adding the index as the count.
    		monkeys[i -1] = i;
    		System.out.println(i);
    	}
    	return monkeys;
    }
    
    /* 	completed 9/22/2020
		Given a set of numbers, return the additive inverse of each. Each positive becomes negatives, and the negatives become positives.

		test cases:	
	    System.out.println(Kata8.invert(new int[] {-1,-2,-3,-4,-5}));
	*/
    public static int[] invert(int[] array) {
    	//use Streams map to multiply each value by -1 and return that as an array.
    	return Arrays.stream(array).map(num -> num*-1).toArray();
    }
    
    /* 	completed 9/23/2020
		Write function avg which calculates average of numbers in given list
		
		test cases:	
	    System.out.println(Kata8.invert(new int[]{1, 2, 3}));
	*/
    public static double find_average(int[] array){
        double sum = 0;
        for(int num : array) {
        	sum += num;
        }
        return sum / array.length;
    }
    
    /* 	completed 9/23/2020
		Code as fast as you can! You need to double the integer and return it.
		
		test cases:	
	    System.out.println(Kata8.doubleInteger(2));
	*/
    public static int doubleInteger(int i) {
        return i*2;
    }
    
    /* 	completed 9/23/2020
		It's bonus time in the big city! The fatcats are rubbing their paws in anticipation...
		but who is going to make the most money? Build a function that takes in two arguments
		(salary, bonus). Salary will be an integer, and bonus a boolean. If bonus is true, the
		salary should be multiplied by 10. If bonus is false, the fatcat did not make enough
		money and must receive only his stated salary. Return the total figure the individual will
		receive as a string prefixed with "�" (= "\u00A3", JS, Go, and Java), "$"
		(C#, C++, Ruby, Clojure, Elixir, PHP and Python, Haskell, Lua) or "�" (Rust).
		
		test cases:	
	    System.out.println(Kata8.bonusTime(2));
	*/
    public static String bonusTime(int salary, final boolean bonus) {
    	if(bonus) {
    		salary *= 10;
    	}
    	return "\u00a3" + salary;
    }
    
    /* 	completed 9/23/2020
		Given a string of digits, you should replace any digit below 5 with '0' and any digit 5 and
		above with '1'. Return the resulting string.
		
		test cases:	
	    System.out.println(Kata8.fakeBin("512368"));
	*/
    public static String fakeBin(String numberString) {
    	String fake = "";
    	for(int i = 0; i < numberString.length(); i++) {
    		//check if the numerical value of the character at index i is less than 5.
    		if (Character.getNumericValue(numberString.charAt(i))< 5) {
    			fake += 0;
    		} else {
    			fake += 1;
    		}
    	}
        return fake;
    }
    
    /* 	completed 9/23/2020
		Deoxyribonucleic acid, DNA is the primary information storage molecule in biological systems.
		It is composed of four nucleic acid bases Guanine ('G'), Cytosine ('C'), Adenine ('A'), and Thymine ('T').
		Ribonucleic acid, RNA, is the primary messenger molecule in cells. RNA differs slightly from DNA its chemical
		structure and contains no Thymine. In RNA Thymine is replaced by another nucleic acid Uracil ('U').
		Create a function which translates a given DNA string into RNA.
		
		test cases:	
	    System.out.println(Kata8.dnaToRna("GCAT"));
	*/
    public String dnaToRna(String dna) {
    	String rna = "";
    	for(int i =0; i < dna.length(); i++) {
    		if(dna.charAt(i) == 'T') {
    			rna += "U";
    		} else {
    			rna += dna.charAt(i);
    		}
    	}
    	return rna;
    } 
    
    /* 	completed 9/23/2020
		You will be given an array a and a value x. All you need to do is check whether the provided array contains the value.
		Array can contain numbers or strings. X can be either. Return true if the array contains the value, false if not.
		
		test cases:	
	    System.out.println(Kata8.check(new Object[] {66, 101}, 66));
	*/
    public static boolean check(Object[] a, Object x) {
        for(Object item: a) {
        	if(item.equals(x)) {
        		return true;
        	}
        }
        return false;
    }

    /* 	completed 9/23/2020
		Create a function which answers the question "Are you playing banjo?". If your name starts with the letter "R"
		or lower case "r", you are playing banjo!The function takes a name as its only argument, and returns one of
		the following strings:
		name + " plays banjo" 
		name + " does not play banjo"
		
		test cases:	
	    System.out.println(Kata8.areYouPlayingBanjo("randy"));
	*/
    public static String areYouPlayingBanjo(String name) {
        if(name.charAt(0) == 'r' || name.charAt(0) == 'R') {
        	return name + " plays banjo";
        } else {
        	return name + " does not play banjo";
        }
    }
    
    /* 	completed 9/23/2020
		Our football team finished the championship. The result of each match look like "x:y". Results of all matches are recorded in the collection.
		For example: ["3:1", "2:2", "0:1", ...]
		Write a function that takes such collection and counts the points of our team in the championship. Rules for counting points for each match:
			if x>y - 3 points
			if x<y - 0 point
			if x=y - 1 point
		
		test cases:	
	    System.out.println(Kata8.points(new String[] {"1:0","2:0","3:0","4:0","2:1","3:1","4:1","3:2","4:2","4:3"}));
	*/
    public static int points(String[] games) {
    	int points = 0; 
    	for(String results : games) {
    		int x = Character.getNumericValue(results.charAt(0));
    		int y = Character.getNumericValue(results.charAt(2));
    		if(x > y) {
    			points += 3;
    		} else if (x == y) {
    			points += 1;
    		}
    	}
    	return points;
    }
    
    /* 	completed 9/23/2020
		Your task is to make two functions, max and min (maximum and minimum in PHP and Python) that take a(n) array/vector
		of integers list as input and outputs, respectively, the largest and lowest number in that array/vector. You may consider
		that there will not be any empty arrays/vectors.
	*/
    public int min(int[] list) {
    	int min = list[0];
    	for(int num : list) {
    		if (num < min) {
    			min = num;
    		}
    	}
    	return min;
    }
    
    public int max(int[] list) {
    	int max = list[0];
    	for(int num : list) {
    		if (num > max) {
    			max = num;
    		}
    	}
    	return max;
    }
    
    /* 	completed 9/23/2020
		Sum all the numbers of the array (in F# and Haskell you get a list) except the highest and the lowest element (the value, not the index!).
		(The highest/lowest element is respectively only one element at each edge, even if there are more than one with the same value!)
		If array is empty, null or None, or if only 1 Element exists, return 0.

		
		test cases:	
	    System.out.println(Kata8.sumMinusMinMax(new int[] { 6, 2, 1, 8, 10}));
	*/
    public static int sumMinusMinMax(int[] numbers){
    	//check if empty or null first
    	if(numbers == null || numbers.length < 2) {
    		return 0;
    	}
    	int min = numbers[0], max = numbers[0], sum = 0;
    	for(int num : numbers) {
    		sum += num;
    		if(num > max) {
    			max = num;
    		} else if(num < min) {
    			min = num;
    		}
    	}
    	return sum - max - min;
    }
    
    /* 	completed 9/23/2020
		Complete the solution so that it reverses all of the words within the string passed in.

		test cases:	
	    System.out.println(Kata8.reverseWords("I like eating"));
	*/
    public static String reverseWords(String str){
    	ArrayList<String> words = new ArrayList<String>();
    	String temp = "";
    	String reversed = "";
    	//loop through adding words to array list.
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) != ' ') {
        		temp += str.charAt(i);
    		}

    		if(str.charAt(i) == ' ' || i == str.length() - 1) {
    			words.add(temp);
    			temp = "";
    		} 
    	}
    	//add words starting from the end to a new string
    	for(int i = words.size() - 1; i >= 0; i--) {
    		if(i==0) {
    			reversed += words.get(i);
    		} else {
        		reversed += words.get(i) + " ";
    		}
    	}
    	return reversed;
    }
    /* 	completed 9/23/2020
		It's the academic year's end, fateful moment of your school report. The averages must
		be calculated. All the students come to you and entreat you to calculate their average
		for them. Easy ! You just need to write a script. Return the average of the given array
		rounded down to its nearest integer. The array will never be empty.

		test cases:	
	    System.out.println(Kata8.reverseWords("I like eating"));
	*/
 	public static int getAverage(int[] marks){
		int sum = 0; 
		for(int num : marks) {
			sum += num;
		}
		return sum / marks.length;
	}
    /* 	completed 9/23/2020
		Clock shows 'h' hours, 'm' minutes and 's' seconds after midnight. Your task is to make
		'Past' function which returns time converted to milliseconds.

		test cases:	
	    System.out.println(Kata8.reverseWords("I like eating"));
	*/
 	public static int Past(int h, int m, int s){
 		return h * 3600000 + m * 60000 + s * 1000;
 	}
	
    /* 	completed 9/23/2020
		I want to get the sum of two arrays...actually the sum of all their elements.
		Each array includes only integer numbers. Output is a number too.

		test cases:	
	    System.out.println(Kata8.sumArray(new int[]{1,2,3}, new int[]{4,5,6}));
	*/
 	public static int sumArray(int[] arr) { //create a method to sum all ints in an array
 		int sum = 0;
 		for(int num : arr) {
 			sum += num;	
 		}
 		return sum;
 	}
 	public static int arrayPlusArray(int[] arr1, int[] arr2) {
	    return sumArray(arr1) + sumArray(arr2);
 	}
 	
    /* 	completed 9/23/2020
		Get the number n (n>0) to return the reversed sequence from n to 1
		Example : n=5 >> [5,4,3,2,1]

		test cases:	
	    System.out.println(Kata8.reverse(new int[]{5,4,3,2,1}));
	*/
 	public static int[] reverse(int n){
 		int[] reverse = new int[n]; 
 		int i = 0; 
 		while(n > 0) {
 			reverse[i] = n;
 			i++; n--;
 		}
 		return reverse;
	}
 	
    /* 	completed 9/23/2020
		Implement a function which convert the given boolean value into its string representation.
	*/
 	public static String convert(boolean b){
 		if(b) {
 			return "true";
 		} else {
 		    return "false";
 		}
 	}
 	
    /* 	completed 9/23/2020
		Write a function which converts the input string to uppercase.

		test cases:	
	    System.out.println(Kata8.makeUpperCase("string"));
	*/
 	 public static String makeUpperCase(String str){
 		 return str.toUpperCase();
 	 }
 	 
     /*	completed 9/23/2020
		There was a test in your class and you passed it. Congratulations!But you're an ambitious person.
		You want to know if you're better than the average student in your class. You receive an array with
		your peers' test scores. Now calculate the average and compare your score!
		
		Return True if you're better, else False!

 		test cases:	
 	    System.out.println(Kata8.makeUpperCase(new int[] {100, 40, 34, 57, 29, 72, 57, 88}, 75));
 	*/
 	public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
 		int sum = yourPoints; //set sum in your points to add that to avg
 		int avg;
 		for(int num : classPoints) {
 			sum += num;
 		}
 		avg = sum / (classPoints.length + 1); //find avg then check if better.
 		if(yourPoints > avg) {
 			return true;
 		} else {
 			return false;
 		}
 	}
 	
    /*	completed 9/23/2020
		Given a non-empty array of integers, return the result of multiplying the values together in order. Example:

		test cases:	
	    System.out.println(Kata8.grow(new int[]{1,2,3}));
	*/
 	public static int grow(int[] x){
 		int sum = 1; //use 1 because anything time 1 will be itself. 0 would make any first value 0
 		for (int num : x) {
 			sum *= num;
 		}
 		return sum;
 	}
 	
    /*	completed 9/23/2020
		Bob needs a fast way to calculate the volume of a cuboid with three values: length, width and
		the height of the cuboid. Write a function to help Bob with this calculation.

		test cases:	
	    System.out.println(Kata8.grow(new int[]{1,2,3}));
	*/
 	public static double getVolumeOfCuboid(final double length, final double width, final double height) {
 		return length * width * height;
 	}
 	
    /*	completed 9/23/2020
		You were camping with your friends far away from home, but when it's time to go back, you realize that
		your fuel is running out and the nearest pump is 50 miles away! You know that on average, your car runs
		on about 25 miles per gallon. There are 2 gallons left. Considering these factors, write a function that
		tells you if it is possible to get to the pump or not. Function should return true (1 in Prolog) if it is
		possible and false (0 in Prolog) if not. The input values are always positive.

		test cases:	
	    System.out.println(Kata8.zeroFuel(50, 25, 2));
	*/
 	public static boolean zeroFuel(double distanceToPump, double mpg, double fuelLeft) {
 		System.out.println("test" + (mpg * fuelLeft / distanceToPump));
 		if(mpg * fuelLeft / distanceToPump >= 1) {
 			return true;
 		} else {
 			return false;
 		}
 	}
 	
    /*	completed 9/23/2020
		Write a function that takes an array of words and smashes them together into a sentence and returns the sentence.
		You can ignore any need to sanitize words or add punctuation, but you should add spaces between each word. Be
		careful, there shouldn't be a space at the beginning or the end of the sentence!

		test cases:	
	    System.out.println(Kata8.zeroFuel(50, 25, 2));
	*/
	public static String smash(String... words) {
		/* the long way not useing join

		String smush = "";
		if(words.length == 0 || words == null) { //check for null or empty
			return smush;
		} else {
			for (int i = 0; i < words.length; i++) {
				if(i != 0) { //add the word at i wit a space before it unless it is the first word.
					smush += " " + words[i];
				} else {
					smush += words[i];
				}
			}
		}
		return smush;
		*/
		return String.join(" ", words); //easy smeasy way.
	}
	
    /*	completed 9/24/2020
		After a hard quarter in the office you decide to get some rest on a vacation. So you will book a flight
		for you and your girlfriend and try to leave all the mess behind you.You will need a rental car in order
		for you to get around in your vacation. The manager of the car rental makes you some good offers.
		Every day you rent the car costs $40. If you rent the car for 7 or more days, you get $50 off your total.
		Alternatively, if you rent the car for 3 or more days, you get $20 off your total.
		Write a code that gives out the total amount for different days(d).
		
		test cases:	
	    System.out.println(Kata8.rentalCarCost(10));
	*/
	public static int rentalCarCost(int d) {
		if(d >= 7) {
			return d*40 - 50;
		} else if(d >= 3) {
			return d*40 - 20;
		} else {
			return d*40;
		}
	}
	
    /*	completed 9/24/2020
		You are given two interior angles (in degrees) of a triangle. Write a function to return the 3rd.
		Note: only positive integers will be tested.
		
		test cases:	
	    System.out.println(Kata8.otherAngle(45, 12));
	*/
	public static int otherAngle(int angle1, int angle2) {
		return 180 - (angle1 + angle2);
	}
	
    /*	completed 9/24/2020
		Write a function to split a string and convert it into an array of words. For
		
		test cases:	
	    System.out.println(Kata8.strignToArray("Robin Singh"));
	*/
	public static String[] stringToArray(String s) {
		
		//easy way
		return s.split(" ");
		
		/* long way!
		String temp = "";
		int wordCount = 1; //start at one for the first word
		int index = 0;
		//find out how many words in string by counting spaces
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				wordCount++;
			}
		}
		//create the string[] with size of wordCount then loop though adding words depending on conditions.
		String[] words = new String[wordCount];
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') { //check if space found. add temp to word array, reset temp, increase indx
				words[index] = temp;
				temp = "";
				index++;
			} else if( i == s.length()-1) { //check if last pos in string. add char then word 
				temp += s.charAt(i);
				words[index] = temp;
			} else {
				temp += s.charAt(i);
			}
		}
		return words;
		*/
	}
    /*	completed 9/24/2020
		Given three integers a ,b ,c, return the largest number obtained after inserting the following
		operators and brackets: +, *, ()
		In other words , try every combination of a,b,c with [*+()] , and return the Maximum Obtained
		
		test cases:	
	    System.out.println(Kata8.expressionsMatter(2, 1, 2));
	*/
    public static int expressionsMatter(int a, int b, int c) {
    	int max = a;
    	//an array holding all possible outcomes.
    	int[] express = {a*b*c,a*b+c, a+b*c, a+b+c, (a+b)*c, a*(b+c)};
    	
    	//find max in the array of values.
    	for(int num : express) {
    		if(num > max) {
    			max = num;
    			System.out.println(max);
    		}
    	}
    	return max;
    }
    
    /*	completed 9/24/2020
		This kata is about multiplying a given number by eight if it is an even number and by nine otherwise.
		
		test cases:	
	    System.out.println(Kata8.simpleMulitplication(2));
	*/
    public static int simpleMultiplication(int n) {
        if(n % 2 == 0) {
        	return n * 8;
        } else {
        	return n * 9;
        }
    }
    
    /*	completed 9/24/2020
		given a string change the case of any letters to the opposite. e.g. uppercase becomes lower
		
		test cases:	
	    System.out.println(Kata8.toAlternativeString("hello world"));
	*/
    public static String toAlternativeString(String string) {
    	String alternate = "";
    	for(int i = 0; i < string.length(); i++) {
    		if(Character.isUpperCase(string.charAt(i))) {
    			alternate += Character.toLowerCase(string.charAt(i));
    		} else if(Character.isLowerCase(string.charAt(i))) {
    			alternate += Character.toUpperCase(string.charAt(i));
    		} else {
    			alternate += string.charAt(i);
    		}
    	}
    	return alternate;
    }
    
    /*	completed 9/25/2020
		Given an array of integers as strings and numbers, return the sum of the array values as if all were numbers.
		Return your answer as a number.
				
		test cases:	
	    System.out.println(Kata8.sumMixed(Arrays.asList("3", 6, 6, 0, "5", 8, 5, "6", 2, "0"));
	*/
   	public static int sumMixed(List<?> mixed) {
   		int sum = 0;
   		for(int i = 0; i < mixed.size(); i++) {
   			//each item to a string, then to an integer and add it to the sum.
   			sum += Integer.parseInt(mixed.get(i).toString());
   		}
   		return sum;
   	}
   	
    /*	completed 9/25/2020
		Write function bmi that calculates body mass index (bmi = weight / height ^ 2).
		if bmi <= 18.5 return "Underweight"
		if bmi <= 25.0 return "Normal"
		if bmi <= 30.0 return "Overweight"
		if bmi > 30 return "Obese"
				
		test cases:	
	    System.out.println(Kata8.bmi(125, 14));
	*/
    public static String bmi(double weight, double height) {
        double bmi = weight / (height * height); //find bmi
        //determine weight class
        if 		(bmi <= 18.5) 	return "Underweight";
        else if (bmi <= 25.0) 	return "Normal";
        else if (bmi <= 30.0) 	return "Overweight";
        else 					return "Obese";
    }
    
    /*	completed 9/25/2020
		Implement a function which multiplies two numbers.
				
		test cases:	
	    System.out.println(Kata8.multiply(125, 14));
	*/
    public static int multiply(int num1, int num2) {
    	return num1*num2;
    }
    
    /*	completed 9/25/2020
		Your task is to find the first element of an array that is not consecutive.
		By not consecutive we mean not exactly 1 larger than the previous element of the array.
		E.g. If we have an array [1,2,3,4,6,7,8] then 1 then 2 then 3 then 4 are all consecutive 
		but 6 is not, so that's the first non-consecutive number.If the whole array is consecutive
		then return null. The array will always have at least 2 elements and all elements will
		be numbers. The numbers will also all be unique and in ascending order. The numbers could be
		positive or negative and the first non-consecutive could be either too!
				
		test cases:	
	    System.out.println(Kata8.find(new int[]{1, 2, 3, 4, 6, 7, 8}));
	*/
    static Integer find(final int[] array) {
    	int temp = array[0];
    	for(int i = 1; i < array.length; i++) {
    		if(array[i] - temp > 1 || array[i] - temp == 0) { //look for non consec #
    			return array[i]; //return the number if found
    		}
    		temp++; //increment temp
    	}
        return null; //if all consecutive return null.
	}

	/*
	 * completed 11/27/2020
	 * 
	 * Given a number(n) return true if the number is even and false if not.
	 * Input may be pos/neg integers and floats. Floats are always false
	 * 
	 * test cases: System.out.println(Kata8.isEven(8));
	 */
	public boolean isEven(double n) {
		if(n % 2 == 0) return true;
		else return false;
	}

}