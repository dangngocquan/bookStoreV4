package BookShopV4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String fruntion = "";
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			fruntion = sc.nextLine();
			checkError.checkFruction(fruntion);
			
			switch (fruntion) {
			case "1":
				addBook();
				break;
			case "2":
				editBook();
				break;
			case "3":
				deleteBook();
				break;
			case "4":
				listBook();
				break;
			case "5":
				findBook();
				break;
			case "6":
				flag = false;
				break;
			
			}
		} while (flag == true);
		sc.close();
	}
	
	public static void myPrint(String abc) {
		System.out.println(abc);
	}
	public static void showMenu() {
		myPrint("==================== Book Maganer ====================");
		myPrint("||  1.Add Book \t\t\t\t\t    ||");
		myPrint("||  2.Edit Book \t\t\t\t    ||");
		myPrint("||  3.Delete Book \t\t\t	    ||");
		myPrint("||  4.List Book \t\t\t\t    ||");
		myPrint("||  5.Find Book \t\t\t\t    ||");
		myPrint("||  6.Exit \t\t\t\t\t    ||");
		myPrint("======================================================");
		myPrint("Your choice [1-6] : ");
	}
	
	static Scanner sc = new Scanner(System.in);
	public static void addBook() {
		boolean errorJava = true;
		String name = "";
		String ID = "";
		double price = 0;
		do {
			try {
				errorJava = true;
				System.out.println("Name \t:");
				name = sc.nextLine();
				System.out.println("ID \t:");
				ID = sc.nextLine();
				System.out.println("Price \t:");
				price = sc.nextDouble();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Erro! Please try again!");
				errorJava = false;
				sc.nextLine();
			}
		} while (errorJava == false);
		if (errorJava == true) {
			String error = "";
			if (checkError.checkName(name) == false) {
				error += "Error! Name of Book must [A-z0-9 !\\\\.] and [1-32] char"+"\n";
			}
			if (checkError.checkID(ID) == false) {
				error += "Error! ID of Book must [A-z]{3}-[0-9]{3}" + "\n";
			}
			if (checkError.checkPrice(price) == false) {
				error += "Error! Price of Book must [0-100]";
			}
			if (error.equals("") == true) {
				System.out.println("Add successful!");
				Book bookObj = new Book(name, ID, price);
				bookStore.add(bookObj);
			} else {
				System.out.println(error);
			}
			
		} else {
			System.out.println("Error! Price of Book must [0-100]");
		}
		}
	
	public static void editBook() {
		if (bookStore.totalBook > 0) {
			boolean errorJava = true;
			String name = "";
			String ID = "";
			double price = 0;
			int numberChoice = 0;
			
			
			do {
				try {
					System.out.println("Choose your number book you want to edit [1-" + bookStore.totalBook + "] :");
					numberChoice = sc.nextInt();
					sc.nextLine();
					errorJava = true;
				} catch (Exception e) {
					errorJava = false;
					sc.nextLine();
					}
				
			} while (errorJava == false || checkError.checkNumberEdit(numberChoice) == false);
				
			
			
			do {
					try {
						errorJava = true;
						System.out.println("Name \t:");
						name = sc.nextLine();
						System.out.println("ID \t:");
						ID = sc.nextLine();
						System.out.println("Price \t:");
						price = sc.nextDouble();
						sc.nextLine();
					} catch (Exception e) {
						System.out.println("Error! Price of Book must [0-100], please try again!");
						errorJava = false;
						sc.nextLine();
					}
				} while (errorJava == false);
				
				
					String error = "";
				do {
					error = "";
					if (checkError.checkName(name) == false) {
						error += "Error! Name of Book must [A-z0-9 !\\\\.] and [1-32] char"+"\n";
					}
					if (checkError.checkID(ID) == false) {
						error += "Error! ID of Book must [A-z]{3}-[0-9]{3}" + "\n";
					}
					if (checkError.checkPrice(price) == false) {
						error += "Error! Price of Book must [0-100]";
					}
					if (error.equals("") == true) {
						Book bookObj = new Book(name, ID, price);
						bookStore.edit(bookObj, numberChoice);
						System.out.println("Edit book successful!");
					} else {
						System.out.println(error);
						System.out.println("Please try again!");
					}
				} while (error.equals("") == false);
		}  
				
			
		
			
		
	}
	
	public static void deleteBook() {
		boolean errorJava = true;
		int numberChoice = 0;
		if (bookStore.totalBook > 0) {
			do {
				try {
					errorJava = true;
					System.out.println("Choose number book you want to delete [1-" + bookStore.totalBook + "] :");
					numberChoice = sc.nextInt();
					sc.nextLine();
				} catch (Exception e) {
					System.out.println("Erro! Please try again!");
					errorJava = false;
					sc.nextLine();
				}
			} while (errorJava == false || checkError.checkNumberEdit(numberChoice) == false);
			bookStore.delete(numberChoice);
			System.out.println("Delete successful!");
		} else {
			System.out.println("Don't have book in here!");
		}
		
	}
	
	public static void listBook() {
		bookStore.list();
		
	}
	
	public static void findBook() {
		int function = 0;
		boolean errorJava = true;
		if (bookStore.totalBook > 0) {
			do {
				System.out.println("1. Find name");
				System.out.println("2. Find ID");
				System.out.println("3. Find Price");
				System.out.println("Your choice [1-3] :");
				try {
					errorJava = true;
					function = sc.nextInt();
					sc.nextLine();
					
					} catch (Exception e) {
					errorJava = false;
					System.out.println("Error! Please ty again!");
					System.out.println("****************************");
					sc.nextLine();
				}
				
			} while (errorJava == false || function <1 || function > 3);
			
			switch (function) {
			case 1:
				System.out.println("Find name :");
				String name = sc.nextLine();
				bookStore.findName(name);
				break;
			case 2:
				System.out.println("Find ID :");
				String ID = sc.nextLine();
				bookStore.findID(ID);
				break;
			case 3:
				boolean flag = true;
				double price = 0;
				do {
					try {
						flag = true;
						System.out.println("Find price :");
						price = sc.nextDouble();
						sc.nextLine();
					} catch (Exception e) {
						flag = false;
						System.out.println("Error! Please try again!");
						System.out.println("**************************");
						sc.nextLine();					}
					
				} while (flag == false);
				
				bookStore.findPrice(price);
				break;

			
			}
			
		} else {
			System.out.println("Don't have book in here!");
		}
	}
}
