
import java.io.*;
import java.util.*;

public class User {
	private String id;
	private double amount;
	private String password;
	private StringBuilder history = new StringBuilder();
	
	static public User findUser(String userId) throws IOException
	{
		String filePath = "./Bank_accounts.txt";
		File file = new File(filePath);
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null)
		{
			if((line.contains("ID:"+userId)))
			{
				String[] data = line.split(",");
				String id = data[0].split(":")[1];
				double amount = Double.parseDouble(data[1].split(":")[1]);
				StringBuilder history = new StringBuilder();
				history.append(data[2].split(":")[1]);
				reader.close();
				return new User(id, amount, history);
			}
		}
		reader.close();
		return new User();
		
	}
	public User(String id, double amount, StringBuilder history)
	{
		this.id = id;
		this.amount = amount;
		this.password = CreatePassword();
		this.history = history;
	}
	public User()
	{
		this.id = idCreation();
		this.amount = 0;
		this.password = CreatePassword();
		this.history.append("");
	}
	
	public void SaveData()
	{
		String filePath = "./Bank_accounts.txt";
		//Firs to check if file exsits
		File file = new File(filePath);
		if (!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void Deposite()
	{
		Scanner scan = new Scanner(System.in);
		boolean validinput = false;
		double depositeAmount = 0;
		while(!validinput) 
		{
			try
			{
				System.out.println("How much would you like to deposite?");
				depositeAmount = scan.nextDouble();
				if(depositeAmount >= 0)
				{
					validinput = true;
					
				}
				else
				{
					System.out.println("Error. Please enter the amount you would like to dedposite");
				}
			}
			catch(Exception e)
			{
				
			}
		}

		this.amount+= depositeAmount;
		System.out.println(depositeAmount + " deposited. Current Balance: " + this.amount);
		this.history.append("Deposited:"+depositeAmount+";");
	}
	
	
	
	public void Withdraw()
	{
		Scanner scan = new Scanner(System.in);
		boolean validinput = false;
		double withdrawAmount = 0;
		while(!validinput) 
		{
				System.out.println("How much would you like to withdraw?");
				withdrawAmount = scan.nextDouble();
				if(withdrawAmount >= 0 && this.amount >= withdrawAmount)
				{
					validinput = true;
					this.amount -= withdrawAmount;
					this.history.append("Deposited:"+withdrawAmount+";");
					System.out.println("You have withdrawn $"+withdrawAmount +"\nCurrent Balance:$" + this.amount);
				}
				else
				{
					System.out.println("You do not have enough balance to withdraw "+withdrawAmount);
				}
			
		}
		

	}
	
	public void printHeader()
	{
		System.out.printf("ID: %s\n", this.id);
		System.out.printf("Amount: $%.2f\n", this.amount);
		System.out.printf("Password: %s\n", this.password);
		
	}
	
	public void userMenu()
	{
		int userInput = 0;
		do
		{
			try
			{
				System.out.printf("Welcome %s. Your current balance is %.2f. What would you like to do?\n", this.id, this.amount);
				System.out.println("1. Withdraw");
				System.out.println("2. Deposite");
				System.out.println("3. Exit");
				Scanner scan = new Scanner(System.in);
				userInput = scan.nextInt();
				if(userInput > 3 || userInput <= 0)
				{
					System.out.println("Please enter 1 / 2 / 3. Try again.");
				}
				else
				{
					switch(userInput)
					{
					case 1:
						Withdraw();
						break;
					case 2:
						Deposite();
						break;
					}
				}
			}
			catch(Exception e)
			{
//				System.out.println("Please enter 1 / 2 / 3. Try again.");
				System.out.println("An Error has occured. Terminating the current process.");
				continue;
			}

			
		}while(userInput != 3);
		SaveData();
		
	}
	public String idCreation()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		return scan.nextLine();
	}
	private String CreatePassword()
	{
		
		System.out.println("Please enter 4 digit password");
		Scanner scan = new Scanner(System.in);
		boolean valid = false;
		while(!valid)
		{
			try
			{
				String strPass = scan.nextLine();
				if(digitValidation(strPass))
				{
					valid = true;
					return strPass;
				}
				else
				{
					System.out.println("Please keep the password in 4 digits");
				}
			}
			catch(Exception e)
			{
				System.out.println("Please make sure the password are all digits");
			}
		}
		return null;
	}
	
	private boolean digitValidation(String input)
	{
		return input.matches("\\d{4}"); //regex for exactly 4 digits
	}
}


