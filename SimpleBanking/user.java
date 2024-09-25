import java.util.*;

public class user {
	private String id;
	private double amount;
	private int password;
	
	public user(String id, double amount)
	{
		this.id = id;
		this.amount = amount;
		this.password = CreatePassword();
	}
	
	public void Deposite(double depositeAmount)
	{
		
	}
	
	public void Withdraw(double withdrawAmount)
	{
		
	}
	
	public void userMenu()
	{
		
	}
	private int CreatePassword()
	{
		
		System.out.println("Please enter 4 digit password");
		Scanner scan = new Scanner(System.in);
		int pass = scan.nextInt();
		
		
		return pass;
	}
}


