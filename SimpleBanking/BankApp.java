import java.io.IOException;
import java.util.*;
public class BankApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "bank_accounts.txt";
		User user = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String input = scan.nextLine();
		try {
			user = User.findUser(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.printHeader();
		try {
			user.userMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
