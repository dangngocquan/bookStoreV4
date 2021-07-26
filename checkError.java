package BookShopV4;

public class checkError {
	public static void checkFruction(String str) {
		if (str.matches("[123456]") == false) {
			System.out.println("Error! Your choice must in [1-6]");
		}
	}
	
	public static boolean checkName(String name) {
		return name.matches("[A-z0-9 !\\.]{1,32}") ;
//			System.out.println("Error! Name of Book must [A-z0-9 !\\\\.] and [1-32] char");
		
	}
	
	public static boolean checkID(String ID) {
		return ID.matches("[A-z]{3}-[0-9]{3}") ;
//			System.out.println("Error! ID of Book must [A-z]{3}-[0-9]{3}");
		
	}
	
	public static boolean checkPrice (double price) {
		if (price < 0 || price > 100 ) return false;
		else return true;
//			System.out.println("Error! Price of Book must [0-100]");
		
	}
	
	public static boolean checkNumberEdit(int numberChoice) {
		if (numberChoice > 0 && numberChoice <= bookStore.totalBook) {
			return true;
		}else return false;
		
	}
}
