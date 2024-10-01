import java.io.IOException;

public class BankApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "bank_accounts.txt";
		User user = null;
		try {
			user = User.findUser("Ian", path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.printHeader();
		user.userMenu();
	}

}
