public class Kata3 {
    /*
     * completed 10/30/2020
     * 
     * Create a simple calculator that given a string of operators (), +, -, *, /
     * and numbers separated by spaces returns the value of that expression.
     * remember the order of operations!
     * 
     * example; Calculator.evaluate("2 / 2 + 3 * 4 - 6") // => 7
     * 
     * test cases: System.out.println(Kata3.evaluate("2 - (4 - (3-2))"));
     */
    public static Double evaluate(String expression) {
        //make a stringbuilder and remove all spaces.
        StringBuilder evaluated = new StringBuilder(expression.replaceAll(" ", ""));

        //remove any double negatives
        for(int i = 0; i < evaluated.length(); i++){
            if(evaluated.charAt(i) == '-' && evaluated.charAt(i+1) == '-'){
                evaluated.replace(i, i+2, "+");
            }
        }

        //check for "()"
        int leftP = 0; //hold index of outermost left "("
        do {
            int rightP = 0; //same but right.
            int leftPindex =0; int rightPindex = 0; //hold position of inner "()"
            for(int i = 0; i < evaluated.length(); i++){
                if (evaluated.charAt(i) == '('){
                    leftP++;
                    if (leftP == 1){ 
                        leftPindex = i;
                    }
                } else if( evaluated.charAt(i) == ')'){
                    rightP++; 
                }
                if (leftP == rightP && rightP > 0){
                    rightPindex = i;
                }
            }
            
            //do the math inside of the () 
            if (leftP == 1) {
                evaluated.replace(leftPindex, rightPindex + 1,
                        basicMath(evaluated.substring(leftPindex + 1, rightPindex)));
                leftP--;
            } 
        } while (leftP > 0);

        //no () found. do now do multiplication and division.
        boolean divMultOpFound = false;
        int startIndex = 0;
        int endIndex = evaluated.length();
        do {
            startIndex = 0; //reset both start and endIndex
            endIndex = evaluated.length();
            divMultOpFound = false; //reset to false;

            for( int i = 1; i < evaluated.length(); i++ ){
                char c = evaluated.charAt(i);
                if (c=='+' || c=='-'){
                    startIndex = i + 1; //do not include operator
               // } else if (c=='-'){
                //    startIndex = i; //include operator (because it's negative.)
                //mult || div found, do math.
                } else if (c=='*' || c=='/'){
                    divMultOpFound = true;
                    //find the next operator or end of string. +1 after i to avoid catching that '*'
                    for(int end = i+1; end < evaluated.length(); end++){
                        c = evaluated.charAt(end);
                        if(c=='*' ||  c=='/' || c=='+' || c=='-'){
                            endIndex = end;
                            break;
                        }
                    }
                    //do math then replace og stringbuilder
                    evaluated.replace(startIndex, endIndex,
                            basicMath(evaluated.substring(startIndex, endIndex )));
                    endIndex = evaluated.length(); //reset endIndex
                    break;
                }
            }
        } while (divMultOpFound);

        //no "()", or multiplicaiton/division now do addition/subtraction
        boolean subAddOpFound = false;
        do {
            // finally do addition and subtraction.
            startIndex = 0; // reset startIndex
            subAddOpFound = false; //reset op found 
            endIndex = evaluated.length(); // reset endIndex
            for (int i = 1; i < evaluated.length(); i++) {
                char c = evaluated.charAt(i);
                if (c=='+' || c=='-'){
                    subAddOpFound = true;
                    //find the next operator or end of string. +1 after i to avoid catching that '*'
                    for(int end = i+1; end < evaluated.length(); end++){
                        c = evaluated.charAt(end);
                        if(c=='+' || c=='-' && end != i+1){ //does not include op directly following start.
                            endIndex = end;
                            break;
                        }
                    }
                    //do math then replace og stringbuilder
                    evaluated.replace(startIndex, endIndex,
                            basicMath(evaluated.substring(startIndex, endIndex )));
                    endIndex = evaluated.length(); //reset endIndex
                }
            }
        } while (subAddOpFound);
        //return answer.
        return Double.parseDouble(evaluated.toString());
    }
    //used to do simple math in above method.
    public static String basicMath(String exp){
        String[] temp; //will hold the values to have mathmatical op performed on.
        for(int i = 1; i < exp.length(); i++){
            //find type of math
            switch (exp.charAt(i)){
                case '+':
                    temp = exp.split("\\+"); //split by the operator 
                    //convert to Doubles then do math, then convert back to string.
                    return Double.toString((Double.parseDouble(temp[0]) + Double.parseDouble(temp[1])));
                case '-':
                    temp = exp.split("\\-");
                    if (exp.charAt(0) == '-'){ //value must be negative.
                        return Double.toString(((Double.parseDouble(temp[1]) * -1) - Double.parseDouble(temp[2])));
                    } else { //do same as above
                        return Double.toString((Double.parseDouble(temp[0]) - Double.parseDouble(temp[1])));
                    }
                case '*':
                    temp = exp.split("\\*");
                    return Double.toString((Double.parseDouble(temp[0]) * Double.parseDouble(temp[1])));
                case '/':
                    temp = exp.split("\\/");
                    return Double.toString((Double.parseDouble(temp[0]) / Double.parseDouble(temp[1])));
            }
        }
        return "";
    }
}