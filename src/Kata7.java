import java.util.Arrays;

public class Kata7 {
    /*	completed 9/28/2020
		Return the number (count) of vowels in the given string.
		We will consider a, e, i, o, u as vowels for this Kata (but not y).
		The input string will only consist of lower case letters and/or spaces.
		
		test cases:	
	    System.out.println(Kata7.getCount());
	*/
	public static int getCount(String str) {
		int vowelCount = 0;
		//loop through str and find vowels
		for(int i = 0; i < str.length(); i++) {
			char l = str.charAt(i);
			if(l == 'a' || l == 'e' || l =='i' || l == 'o' || l =='u') {
				vowelCount++; //when found increment vowel count
			}
		}
		return vowelCount++; //return count.
	}
	
    /*	completed 9/29/2020
		You are going to be given a word. Your job is to return the middle character
		of the word. If the word's length is odd, return the middle character. If the
		word's length is even, return the middle 2 characters.
		
		test cases:	
	    System.out.println(Kata8.getMiddle("test"));
	*/
	
	public static String getMiddle(String word) {
		String mid = "";
		if(word.length() % 2 == 0 ) { //return middle 2 char
			return mid + (word.charAt(word.length() / 2 -1)) + (word.charAt(word.length() / 2));
		} else { //return middle char
			return mid + word.charAt(word.length() / 2);
		}
	}
	
    /*	completed 9/29/2020
		Your task is to write a function that takes a string and return a new
		string with all vowels removed.
		Note: for this kata, y isn't considered a vowel.
		
		test cases:	
	    System.out.println(Kata8.disemvowel("test"));
	*/
    public static String disemvowel(String str) {
    	String voweless = "";
    	char c; 
    	for(int i = 0; i < str.length(); i++) {
    		c = Character.toUpperCase(str.charAt(i)); //set c to uppercase version for test
    		//check if c is a  vowel
    		if(c != 'A' && c != 'E' && c !='I' && c != 'O' && c !='U') {
    			//if not then add the char to the vowelless.
    			voweless += str.charAt(i);
    		}
    	}
    	return voweless;
    }
    
    /*	completed 9/29/2020
		Given an integral number, determine if it's a square number:
		
		test cases:	
	    System.out.println(Kata8.isSqaure(9));
	*/
    public static boolean isSquare(int n) {
    	int num = (int) Math.sqrt(n); //get the sqrnt of n, floored by converting the sqrt to int
    	if(num*num == n ) { // if the floored value squared equals n then it must be a perfect sqr.
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /*	completed 9/29/2020
		Welcome. In this kata, you are asked to square every digit of a number
		and concatenate them. For example, if we run 9119 through the function, 
		811181 will come out, because 92 is 81 and 12 is 1.
		
		test cases:	
	    System.out.println(Kata8.squareDigites(9119));
	*/
    public static int squareDigits(int n) {
    	String s = "" + n; //convert n to string
    	String concat = "";
    	int num;
    	for(int i = 0; i < s.length(); i ++) {
    		num = (int) s.charAt(i);
    		System.out.println(num);
    		concat += num * num;
    	}
    	System.out.println(concat);
    	return Integer.valueOf(concat);
    }
    
    /*	completed 10/9/2020
		In this little assignment you are given a string of space separated numbers,
		and have to return the highest and lowest number.
		
		test cases:	
	    System.out.println(Kata8.highAndLow("1 2 3 4 5"));
	*/
    public static String highAndLow(String numbers) {
    	//split the String to an array of strings only holding the number
    	String[] numbersArr = numbers.split(" ");
    	//convert to an array of integers
    	int[] intArr = Arrays.stream(numbersArr).mapToInt(Integer::parseInt).toArray();
    	int min = intArr[0]; int max = intArr[0]; //set min and max to int @ first index
    	
    	for(int i = 1; i < intArr.length; i++) { 
    		if (intArr[i] > max) { //check if min or max
    			max = intArr[i];
    		} else if(intArr[i] < min) {
    			min = intArr[i];
    		}
    	}
    	return max + " " + min; 
    }
    
    /*	completed 10/9/2020
		Given a string of letters return each letter times the amount of its position in
		the string sepereated by "-" the first iteration of the letter should be capitalized
		e.g. "abcd" becomes "A-Bb-Ccc-Ddddd"
		
		test cases:	
	    System.out.println(Kata7.accum("abcd"));
	*/
    public static String accum(String s) {
    	String[] letters = new String[s.length()]; //an array to hold letters in the string.
    	String l; //will hold letter in string.
    	for(int i = 0; i < s.length(); i++) {
    		l = Character.toString(s.charAt(i)); // convert character @ index to string
    		letters[i] = l.toUpperCase(); //add uppercase to the array @ index
    		for(int a = 0; a < i; a++) { //add the extra letters depending on the index.
    			letters[i] += l.toLowerCase(); // add lowercase of letter.
    		}
    	}
    	return String.join("-", letters);
    }
    
    /*	completed 10/10/2020
		given a string of words, return the length of the shortest word
		
		test cases:	
	    System.out.println(Kata7.findShort("bitcoin take over the world maybe who knows perhaps"));
	*/
    public static int findShort(String s) {
        String[] seperated = s.split(" "); //split s into an array of words
        int shortest = seperated[0].length(); //init shortest to length of word at the first pos
        for (String word : seperated) { //loop through to check if any words are shorter
        	if(word.length() < shortest) {
        		shortest = word.length();
        	}
        }
        return shortest; //return shortest.
    }
    
    /*	completed 10/10/2020
		Your task is to make a function that can take any non-negative integer as an argument
		and return it with its digits in descending order.
		
		test cases:	
	    System.out.println(Kata7.findShort("bitcoin take over the world maybe who knows perhaps"));
	*/
    public static int sortDesc(final int num) {
        String numbers = "" + num;
        int temp;
        for(int i = 0; i < numbers.length(); i++) {
        	temp = (int) numbers.charAt(i);
        }
    }

}
