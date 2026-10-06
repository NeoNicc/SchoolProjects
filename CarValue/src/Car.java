/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 02/07/26
	Assignment: Module 3 lab 2
	Instructor: Sergio Pisano
	Description: determine car value
 */
public class Car {
   private int modelYear; 
   private int purchasePrice;

   private int currentValue;

   public void setModelYear(int userYear){
      modelYear = userYear;
   }

   public int getModelYear() {
      return modelYear;
   }

   public void setPurchasePrice(int price) {
	   purchasePrice = price;
   }

   public int getPurchasePrice() {
	   return purchasePrice;
   }


   public void calcCurrentValue(int currentYear) {
      double depreciationRate = 0.15;
      int carAge = currentYear - modelYear;

      // Car depreciation formula
      currentValue = (int) 
         Math.round(purchasePrice * Math.pow((1 - depreciationRate), carAge));
   }

   public void printInfo() {
	   System.out.println(
			   "Car's information:\n  Model year: " + modelYear + "\n  Purchase price: $" + purchasePrice + "\n  Current value: $" + currentValue
			   );
   }

}