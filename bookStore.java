package BookShopV4;

public class bookStore {
	static int totalBook = 0;
	static int maxBook = 50;
	static Book[] arrayBook = new Book[maxBook];
	
	public static void add(Book bookObj) {
		totalBook ++;
		arrayBook[totalBook-1] = bookObj;
	}
	
	public static void list() {
		if (totalBook > 0) {
			System.out.println("Having " + totalBook + " book in store.");
			for (int i = 0; i< totalBook; i++) {
				System.out.println(" + Book number " + (i+1));
				arrayBook[i].showInfo();
			}
		} else {
			System.out.println("Don't have book in here!");
		}
		
	}
	
	public static void edit(Book bookObj,int numberChoice) {
		arrayBook[numberChoice -1] = bookObj;
		
	}
	
	public static void delete(int numberChoice) {
		for (int i = numberChoice; i <= totalBook; i++) {
			arrayBook[i-1] = arrayBook[i];
		}
		totalBook -= 1;
	}
	
	public static void findName(String name) {
		int k = 0;
		for (int i = 1; i <= totalBook; i++) {
			if (arrayBook[i-1].getName().equals(name) == true) {
				System.out.println(" + Book number " + i + " :");
				arrayBook[i-1].showInfo();
				k++;
			}
		}
		if (k == 0) System.out.println("Don't have that book in here!");
	}
	
	public static void findID(String ID) {
		int k = 0;
		for (int i = 1; i <= totalBook; i++) {
			if (arrayBook[i-1].getID().equals(ID) == true) {
				System.out.println(" + Book number " + i + " :");
				arrayBook[i-1].showInfo();
				k++;
			}
		}
		if (k == 0) System.out.println("Don't have that book in here!");
	}
	
	public static void findPrice(double price) {
		int k = 0;
		for (int i = 1; i <= totalBook; i++) {
			if (arrayBook[i-1].getPrice() == price) {
				System.out.println(" + Book number " + i + " :");
				arrayBook[i-1].showInfo();
				k++;
			}
		}
		if (k == 0) System.out.println("Don't have that book in here!");
	}
}
