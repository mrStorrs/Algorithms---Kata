
public class Kata6 {
	
    /*	completed 10/13/2020
		If we list all the natural numbers below 10 that are multiples of 3 or
		5, we get 3, 5, 6 and 9. The sum of these multiples is 23.Finish the 
		solution so that it returns the sum of all the multiples of 3 or 5 
		below the number passed in.
		
		test cases:	
	    System.out.println(Kata6.sum3and5(10));
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
	
    /*	completed 10/13/2020
		You probably know the "like" system from Facebook and other pages.
		People can "like" blog posts, pictures or other items. We want to
		create the text that should be displayed next to such an item.
		Your results should look like:
		
		likes {} // must be "no one likes this"
		likes {"Peter"} // must be "Peter likes this"
		likes {"Jacob", "Alex"} // must be "Jacob and Alex like this"
		likes {"Max", "John", "Mark"} // must be "Max, John and Mark like this"
		likes {"Alex", "Jacob", "Mark", "Max"} // must be "Alex, Jacob and 2 others like this"

		test cases:	
	    System.out.println(Kata6.whoLikesIt("Max", "John", "Mark"));
	*/
    public static String whoLikesIt(String... names) {
    	StringBuilder likes = new StringBuilder();
    	//depending on number of names return the following using stringbuilder to create string
    	switch (names.length){
    		case 0:
    			return "no one likes this";
    		case 1:
    			return likes.append(names[0]).toString();
    		case 2:
    			return likes.append(names[0] + " and " + names[1] + " like this").toString();
    		case 3:
    			return likes.append(names[0] + ", " + names[1] + " and " + names[2] + " like this").toString();
    		default:
    			return likes.append(names[0] + ", " + names[1] + " and 2 others like this").toString();
    	}
    }
}
