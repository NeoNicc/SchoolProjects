/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 04/11/26
	Assignment: Module 6 Lab(LM) 2
	Instructor: Sergio Pisano
	Description: Checks if an array is in descending order
 */
public class LabProgram {

   public static boolean inOrder(int[] nums) {
      /* Type your code here. */      
	   boolean ordered = true;
	   for (int i = 0; i < nums.length; i++) {
		   if (i < nums.length - 2) {
			   if (nums[i] < nums[i+1]) {
				   ordered = false;
			   }
		   } 
	   }
	   return ordered;
   }

   public static void main(String[] args) {

      // Test out-of-order example.
      int [] nums1 = {5, 6, 7, 8, 3};

      if (inOrder(nums1)){
         System.out.println("In descending order");
      }
      else{
         System.out.println("Not in order");
      }

      // Test in-order example.
      int [] nums2 = {10, 8, 7, 6, 5};

      if (inOrder(nums2)){
         System.out.println("In descending order");
      }
      else{
         System.out.println("Not in order");
      }
   }
}
//Output
/*
Not in order
In descending order
*/