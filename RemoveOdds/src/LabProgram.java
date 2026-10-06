/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 04/11/26
	Assignment: Module 6 Lab(LM)
	Instructor: Sergio Pisano
	Description: removes odd integers from an array and prints the result
 */
import java.util.Arrays;

public class LabProgram {

    public static int[] removeOdds(int [] nums) {
    	int evenCount = 0;
    	int[] newArr;
    	int index = 0;
    	
        //determines new array size
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] % 2 == 0) {
    			evenCount += 1;
    		}
    	}
    	
    	newArr = new int[evenCount];
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] % 2 == 0) {
    			newArr[index] = nums[i];
    			index++;
    		}
    	}
    	return newArr;
    }

    public static void main(String[] args) {

        int [] input = {1,2,3,4,5,6,7,8,9};
        int [] result = removeOdds(input);

        // Helper method Arrays.toString() converts int[] to a String
        System.out.println(Arrays.toString(result)); // Should print [2, 4, 6, 8]
    }
}

//Output
/*
 [2, 4, 6, 8]
*/