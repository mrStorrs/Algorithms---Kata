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
        System.out.println("problem: " + expression);
        StringBuilder evaluated = new StringBuilder(expression.replaceAll(" ", ""));
        System.out.println("builder: " + evaluated);

        //remove any double negatives
        for(int i = 0; i < evaluated.length(); i++){
            if(evaluated.charAt(i) == '-' && evaluated.charAt(i+1) == '-'){
                evaluated.replace(i, i+2, "+");
                System.out.println("replaced dNegs: " + evaluated);
            }
        }


        //check for "()" -> runs at least once.
        int leftP = 0; 
        do {
            int rightP = 0;
            int leftPindex =0; int rightPindex = 0;
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

        //no () found. do rest of math.
        boolean divMultOpFound = false;
        //boolean divMultFound = false;
        int startIndex = 0;
        int endIndex = evaluated.length();

        //do mult/div
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
                    System.out.println("test " + evaluated.toString());
                    break;
                }
            }
        } while (divMultOpFound);

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
                    System.out.println("test " + evaluated.toString());
                }
            }
        } while (subAddOpFound);
        //return answer.
        return Double.parseDouble(evaluated.toString());
    }
    //used for above method.
    public static String basicMath(String exp){
        System.out.println("Doing math on: " + exp);
        String[] temp;
        for(int i = 1; i < exp.length(); i++){
            switch (exp.charAt(i)){
                case '+':
                    temp = exp.split("\\+");
                    return Double.toString((Double.parseDouble(temp[0]) + Double.parseDouble(temp[1])));
                case '-':
                    temp = exp.split("\\-");
                    if (exp.charAt(0) == '-'){
                        return Double.toString(((Double.parseDouble(temp[1]) * -1) - Double.parseDouble(temp[2])));
                    } else {
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

    /*
     * notes use switch case, to look for *+-/ then perform operations on prev and
     * next index. then use string builder replace to replace the item
     * 
     * //failed on "-521538720 + -93238217" "4.0-6/3"
     * "-1827220880 - -1427984899 - 548695" "2 + 3 * 4 / 3 - 6 / 3 * 3 + 8"
     * 
     * 
     */
}