//Author: Nicholas Watson
//Date: 09/17/2026
//Class: COP 3337
//Program: Warehouse Inventory Management System

//note: I realized this may have been over done and there is not really
//a specific instance of an overloaded method (I did get plenty of 
//overridden methods though. If you require that as proof of my
//understanding of overloading to exemplify polymorphism please allow
//me the chance to refactor this. Thank you.
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		//instantiate Scanner obj for user input
		Scanner scnr = new Scanner(System.in);
		
		//establish inventory types container
		List<Product> products = new ArrayList<>();
	 	
	 	//Sentinel value for main interface loop
	 	boolean running = true;
	 	
	 	//interface main loop
	 	while (running) {
	 		//variables for user input
	 		int userSelection = 0;
	 		int productId = 0;
	 		String name = "";
	 		double price = 0.0;
	 		int quantity = 0;
	 		int warrantyPeriod = 0;
	 		String materialType = "";
	 		
	 		//variable for error checking
	 		boolean validEntry = false;
	 	
	 		//initial interface menu
	 		while (!validEntry) {
				System.out.println("1: Add an inventory item\n2: Modify an inventory item\n3: Remove an inventory item\n4: Calculate ending inventory\n5: Inventory descriptions\n6: Exit Program");
				if (scnr.hasNextInt()) {
					userSelection = scnr.nextInt();
					scnr.nextLine(); //flush
					if (userSelection < 7 && userSelection > 0) {
						validEntry = true;
					} else {
						System.out.println("Please enter a number between 1 and 6 inclusive.");
						userSelection = 0;
					}
				} else {
					String invalidEntry = scnr.next();
					System.out.println("Invalid input. '" + invalidEntry + "' is not a valid number.");
				}
			}
	 		
	 		//reset error checking variable
	 		validEntry = false;
	 		
	 		switch(userSelection) {
	 			case 1:
	 				while (!validEntry) {
	 					System.out.println("Enter product ID: ");
	 					if (scnr.hasNextInt()) {
	 						productId = scnr.nextInt();
	 						scnr.nextLine(); //flush
	 						validEntry = true;
	 					} else {
	 						String invalidEntry = scnr.next();
	 						System.out.println("Invalid input. '" + invalidEntry + "' is not a valid number.");
	 					}
	 				}
	 				
	 				//reset error checking variable
	 				validEntry = false;
	 				
	 				System.out.println("Enter item name: ");
	 				name = scnr.nextLine();
	 				
	 				while (!validEntry) {
	 					System.out.println("Enter item price ($zz.zz): ");
	 					if (scnr.hasNextDouble()) {
	 						price = scnr.nextDouble();
	 						scnr.nextLine(); //flush
	 						validEntry = true;
	 					} else {
	 						String invalidEntry = scnr.next();
	 						System.out.println("Invalid input. '" + invalidEntry + "' is not a valid number.");
	 					}
	 				}
	 				//reset error checking variable
	 				validEntry = false;
	 				
	 				while (!validEntry) {
	 					System.out.println("Enter product quantity: ");
	 					if (scnr.hasNextInt()) {
	 						quantity = scnr.nextInt();
	 						scnr.nextLine(); //flush
	 						validEntry = true;
	 					} else {
	 						String invalidEntry = scnr.next();
	 						System.out.println("Invalid input. '" + invalidEntry + "' is not a valid number.");
	 					}
	 				}
	 				//reset error checking variable
	 				validEntry = false;
	 				
	 				while (!validEntry) {
	 					System.out.println("Is the item an electronic or furniture?\n1: Electronic\n2: Furniture\n3: Neither");
	 					
	 					if (scnr.hasNextInt()) {
							userSelection = scnr.nextInt();
							scnr.nextLine(); //flush
							if (userSelection < 4 && userSelection > 0) {
								validEntry = true;
							} else {
								System.out.println("Please enter a number between 1 and 3 inclusive.");
								userSelection = 0;
							}
						} else {
							String invalidEntry = scnr.next();
							System.out.println("Invalid input. '" + invalidEntry + "' is not a valid number.");
						}
	 				}
	 		
	 				//reset error checking variable
	 				validEntry = false;
	 				
	 				switch (userSelection) {
	 					//if electronics
	 					case 1:
 						while (!validEntry) {
		 					System.out.println("Enter warranty duration in months: ");
		 					if (scnr.hasNextInt()) {
		 						warrantyPeriod = scnr.nextInt();
		 						scnr.nextLine(); //flush
		 						validEntry = true;
		 					} else {
		 						String invalidEntry = scnr.next();
		 						System.out.println("Invalid input. '" + invalidEntry + "' is not a valid number.");
		 					}
		 				}
		 				
		 				//reset error checking variable
		 				validEntry = false;
 						
 						//add item to product list
						products.add(new Electronics.Builder()
								.productId(productId)
								.name(name)
								.price(price)
								.quantity(quantity)
								.warrantyPeriod(warrantyPeriod)
								.build());
 						
 						break;
 						
 						//if furniture
	 					case 2:
	 					System.out.println("Enter material type: ");
	 					
 						materialType = scnr.nextLine();
 						
 						//add item to product list
						products.add(new Furniture.Builder()
								.productId(productId)
								.name(name)
								.price(price)
								.quantity(quantity)
								.materialType(materialType)
								.build());
	 					
	 					break;
	 					
	 					//if neither (Generic Product)
	 					case 3:
 						//add item to product list
						products.add(new Product.Builder()
								.productId(productId)
								.name(name)
								.price(price)
								.quantity(quantity)
								.build());
						
						break;
						
	 				}
	 			
	 			break;
	 			
	 			//Modify an existing item
	 			//uses re-stock method
	 			case 2:
	 			System.out.println("Which product would you like to modify?");
	 			name = scnr.nextLine();
	 			
	 			//loop to check existence of product
	 			for (Product product : products) {
	 				if (product.getName().equalsIgnoreCase(name)) {
	 					System.out.println(product);
	 					
	 					//input validation
	 					while (!validEntry) {
	 						System.out.println("How many more of this product would you like to re-stock?");
		 					
		 					if (scnr.hasNextInt()) {
		 						quantity = scnr.nextInt();
		 						scnr.nextLine(); //flush
		 					} else {
		 						String invalidEntry = scnr.next();
		 						System.out.println("Invalid input. '" + invalidEntry + "' is not a valid number.");
		 					}
		 					
		 					if (quantity > 0) {
		 						//re-stock method
		 						product.restock(quantity);
		 						validEntry = true;
		 					} else {
		 						System.out.println("Please enter a positvie integer.");
		 					}
		 				}
	 				}
	 			}
	 				
	 			break;
	 			
	 			//Remove an existing item entirely
	 			case 3:
 				System.out.println("Enter the product you'd like to remove: ");
	 			name = scnr.nextLine();
	 			//check for item and remove upon 
	 			//successful query
	 			for (Product product : products) {
	 				if (product.getName().equalsIgnoreCase(name)) {
	 					products.remove(product);
	 					System.out.println(product.getName() + " removed from inventory.");
	 					validEntry = true;
	 					break;
	 				}
	 			}
	 			//error if no item matches query
	 			if (!validEntry) {
	 				System.out.println("No such product in inventory.");
	 			}
	 			//reset sentinel value
	 			validEntry = false;
	 				
	 			break;
	 			
	 			case 4:
	 			double totalValue = 0.0;
	 			for (Product product : products) {
	 				totalValue += product.calculateTotalValue();
	 			}
	 			System.out.println(String.format("\nThe total value of inventory at cost is $%.2f", totalValue));
	 			
	 			break;
	 			
	 			case 5:
	 			for (Product product : products) {
	 				System.out.println(product + String.format("\nProduct Value: $%.2f", product.calculateTotalValue()) + "\n");
	 			}
	 				
	 			break;
	 			
	 			case 6:
 				System.out.println("Exiting...");
 				scnr.close();
 				System.exit(0);
 				break;
	 		}
	 	}
	}
}
