//Author: Nicholas Watson
//Date: 09/12/2026
//Class: COP 3337
//Program: Library System Manager Program

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Library myLibrary = new Library();
		
		Scanner scnr = new Scanner(System.in);
		
		//menu options and interface details
		while(true) {
			//variables for use by the interface
			int choice;
			String title;
			String creator;
			int itemId = 0;
			String bookOrDVD;
			String genre;
			int numberOfPages;
			String director;
			int duration;
			String name;
			String address;
			String contact;
			int memberId = 000;
			int check = 1;
			
			//main menu 
			//offers the 6 choices that are available
			System.out.println("1. Add item\n2. Add member\n3. Borrow item\n4. Return item\n5. Display library\n6. Exit\nEnter your choice: ");
			
			//user's selection
			choice = scnr.nextInt();
			scnr.nextLine();
			
			//logic to manage the user's choices
			switch(choice) {
			//add item to library
			case 1:
				System.out.println("Enter title: ");
				title = scnr.nextLine();
				System.out.println("Enter creator: ");
				creator = scnr.nextLine();
				System.out.println("Enter item ID: ");
				itemId = scnr.nextInt();
				scnr.nextLine();
				
				System.out.println("Is it a book or a DVD (B/D): ");
				bookOrDVD = scnr.nextLine();
				
				if (bookOrDVD.equals("B") || bookOrDVD.equals("b")) {
					System.out.println("Enter genre: ");
					genre = scnr.nextLine();
					System.out.println("Enter number of pages: ");
					numberOfPages = scnr.nextInt();
					scnr.nextLine();
					
					myLibrary.addItem(new Book(title, creator, itemId, genre, numberOfPages));
				} else {
					System.out.println("Enter director: ");
					director = scnr.nextLine();
					System.out.println("Enter duration: ");
					duration = scnr.nextInt();
					scnr.nextLine();
					
					myLibrary.addItem(new DVD(title, creator, itemId, director, duration));
				}
				break;
				
			//add member to library
			case 2:
				System.out.println("Enter name: ");
				name = scnr.nextLine();
				System.out.println("Enter address: ");
				address = scnr.nextLine();
				System.out.println("Enter contact: ");
				contact = scnr.nextLine();
				System.out.println("Enter member ID: ");
				memberId = scnr.nextInt();
				scnr.nextLine();
				
				myLibrary.addMember(new LibraryMember(name, address, contact, memberId));
				break;
				
			//borrow item from library
			case 3: 
				System.out.println("Enter member ID: ");
				//check for accurate member id
				while (check == 1) {
					memberId = scnr.nextInt();
					scnr.nextLine();
					
					for (int i=0; i<myLibrary.members.length; i++) {
						if (myLibrary.members[i] != null) {
							if (myLibrary.members[i].memberId == memberId) {
								check = 0;
								break;
							}
						}
					}
					
					if (check == 1) {
						System.out.println("Member not found");
					}
				}
				
				//reset sentinel value
				check = 1;
				
				System.out.println("Enter item ID to borrow: ");
				
				//check for accurate item id number
				while (check == 1) {
					itemId = scnr.nextInt();
					scnr.nextLine();
					
					for (int i=0; i<myLibrary.items.length; i++) {
						if (myLibrary.items[i] != null) {
							if (myLibrary.items[i].getItemId() == itemId) {
								check = 0;
								break;
							}
						}
					}
					if (check == 1) {
						System.out.println("Item not found");
					}
				}
				
				for (int i=0; i<myLibrary.items.length; i++) {
					if (myLibrary.items[i] != null) {
						if (myLibrary.items[i].getItemId() == itemId) {
							if (myLibrary.items[i].checkoutItem()) {
								for (int j=0; j<myLibrary.members.length;j++) {
									if (myLibrary.members[j] != null) {
										if (myLibrary.members[j].memberId == memberId) {
											myLibrary.members[j].borrowItem(myLibrary.items[i]);
										}
									}
								}
							}
						}
					}
				} 
				break;
				
				//return an item
			case 4:
				System.out.println("Enter member ID: ");
				//check for accurate member id
				while (check == 1) {
					memberId = scnr.nextInt();
					scnr.nextLine();
					
					for (int i=0; i<myLibrary.members.length; i++) {
						if (myLibrary.members[i] != null) {
							if (myLibrary.members[i].memberId == memberId) {
								check = 0;
								break;
							}
						}
					}
					
					if (check == 1) {
						System.out.println("Member not found");
					}
				}
				
				//reset sentinel value
				check = 1;
				
				System.out.println("Enter item ID to return: ");
				//check for accurate item id number
				while (check == 1) {
					itemId = scnr.nextInt();
					scnr.nextLine();
					
					for (int i=0; i<myLibrary.items.length; i++) {
						if (myLibrary.items[i] != null) {
							if (myLibrary.items[i].getItemId() == itemId) {
								check = 0;
								break;
							}
						}
					}
					if (check == 1) {
						System.out.println("Item not found");
					}
				}
				
				for (int i=0; i<myLibrary.items.length; i++) {
					if (myLibrary.items[i] != null) {
						if (myLibrary.items[i].getItemId() == itemId) {
							if (myLibrary.items[i].returnItem()) {
								for (int j=0; j<myLibrary.members.length;j++) {
									if (myLibrary.members[j] != null) {
										if (myLibrary.members[j].memberId == memberId) {
											myLibrary.members[j].returnItem(myLibrary.items[i]);
										}
									}
								}
							}
						}
					}
				} 
				break;
				
				//display library item and member count
			case 5:
				System.out.println(myLibrary.toString());
				break;
				
				//exit program
			case 6:
				System.out.println("Exiting...");
				scnr.close();
				System.exit(0);
				break;
			}
		}
	}
}
