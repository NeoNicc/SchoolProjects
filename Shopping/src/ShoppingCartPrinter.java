/*
	Author: Nicholas Watson
	Course: COP 2210
	Date: 02/08/26
	Assignment: Module 3 Lab(H)
	Instructor: Sergio Pisano
	Description: Prints Items in a Shopping Cart
 */
import java.util.Scanner;

public class ShoppingCartPrinter {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      //variable declarations
      String itemName;
      int itemPrice;
      int itemQuantity;
      
      //Object instantiations for items in cart
      ItemToPurchase item1 = new ItemToPurchase();
      ItemToPurchase item2 = new ItemToPurchase();
      
      //request first item
      System.out.println("Item 1\nEnter the item name:");
      itemName = scnr.nextLine();
      System.out.println("Enter the item price:");
      itemPrice = scnr.nextInt();
      System.out.println("Enter the item quantity:");
      itemQuantity = scnr.nextInt();
      scnr.nextLine();   //flush for next String input
      
      //set values to item 1
      item1.setName(itemName);
      item1.setPrice(itemPrice);
      item1.setQuantity(itemQuantity);
      
      //request second item
      System.out.println("\nItem 2\nEnter the item name:");
      itemName = scnr.nextLine();
      System.out.println("Enter the item price:");
      itemPrice = scnr.nextInt();
      System.out.println("Enter the item quantity:");
      itemQuantity = scnr.nextInt();
      
      //set values to item 2
      item2.setName(itemName);
      item2.setPrice(itemPrice);
      item2.setQuantity(itemQuantity);
      
      //output for shopping cart totals
      System.out.println("\nTOTAL COST\n" + item1.getName() + " " + item1.getQuantity() + " @ $" + item1.getPrice() + " = $" + (item1.getQuantity() * item1.getPrice()));
      System.out.println(item2.getName() + " " + item2.getQuantity() + " @ $" + item2.getPrice() + " = $" + (item2.getQuantity() * item2.getPrice()));
      System.out.println("\nTotal: $" + (item1.getQuantity() * item1.getPrice() + (item2.getQuantity() * item2.getPrice())));
      scnr.close();
   }
}
/*Output
Item1
Enter the item name:
Chocolate Chips
Enter the item price:
3
Enter the item quantity:
1
Item2
Enter the item name:
Bottled Water
Enter the item price:
1
Enter the item quantity:
10
TOTAL COST
Chocolate Chips 1 @ $3 = $3
Bottled Water 10 @ $1 = $10

Total: $13

 */
