public class Kata4 {
    /*
     * completed 10/29/2020
     * 
     * Given an n x n array, return the array elements arranged from outermost
     * elements to the middle element, traveling clockwise. creating a snail /
     * whirlpool movement
     * 
     * example; given array:  [[1,2,3], 
     *                         [8,9,4], 
     *                         [7,6,5]] 
     * return:                 [1,2,3,4,5,6,7,8,9]
     * 
     * test cases: System.out.println(Kata4.snail(new int {[[1,2,3], [4,5,6], [7,8,9]]}));
     */
    public static int[] snail(int[][] array) {
        //create an array that will be the same size as the full array.
        int[] snailed = new int[array[0].length * array.length];
        boolean down = true; //determine which way the snail is moving.
        int snailedIndex = 0; //main index for keeping track of new array position

        int xIndex = 0; //keep track of left and right boundaries
        int yIndex = 0; //keep track of top and bottom boundaries
        int currentArr = 0; // array we are currently in.

        while(snailedIndex < snailed.length){
            // this will run when at the top boundary of the "snail" pattern
            if (yIndex == currentArr){
                //since we are at the top of snail boundarie add the whole row from left to right.
                for(int i = xIndex; i < array[currentArr].length - yIndex; i++){
                    snailed[snailedIndex] = array[currentArr][i];
                    //move x boundary by 1, only if not first time through loop and !down
                    if(!down && snailedIndex != 0) xIndex++;
                    snailedIndex++;
                    down = true; //prepare to move downwards
                }
                currentArr++; //move down an array

            // we are at the bottom boundary of the "snail" pattern
            } else if (down && currentArr == (array.length - 1) - yIndex){
                for(int i = (array[currentArr].length - 1) - xIndex; i >= xIndex; i--){
                    snailed[snailedIndex] = array[currentArr][i];
                    System.out.println(snailed[snailedIndex]);
                    snailedIndex++;
                }
                yIndex++; //move y boundary up 1
                down = false; // "snail" now moving upwards
                currentArr--;

            // we are currently moving down and not at a boundary
            } else if (down) {
                //add last value
                snailed[snailedIndex] = array[currentArr][(array[currentArr].length - 1)- xIndex];
                snailedIndex++;
                currentArr++; //continue moving down.

            // we are moving up and not @ a boundary
            } else {
                // add first value
                snailed[snailedIndex] = array[currentArr][xIndex];
                System.out.println(snailed[snailedIndex]);
                snailedIndex++;
                currentArr--; //continue moving up.
            }
        }
        return snailed;
    }

}
