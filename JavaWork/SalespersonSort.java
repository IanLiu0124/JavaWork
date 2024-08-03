import java.util.*;

public class SalespersonSort {

	static Salesperson[] salesPeople = new Salesperson[3];
	
	public static void UserInput(int x)
	{
		int id;
		double saleAnnual;
		Scanner scan = new Scanner(System.in);
		System.out.println("Salesman # "+ x + " - > ID: ");
		id = Integer.parseInt(scan.nextLine());
		System.out.println("Salesman # "+ x + "- > Annual Sale Amount");
		saleAnnual = Double.parseDouble(scan.nextLine());
		initializeObject(id, saleAnnual, --x);
	}
	
	public static void initializeObject(int id, double sale, int index)
	{
		salesPeople[index] = new Salesperson(id, sale);
		
	}
	public static void menu()
	{
		System.out.println("How would you like to find your salesperson?");
		System.out.println("1. By ID Number");
		System.out.println("2. By Sales value");
		System.out.println("Please enter 1 or 2");
		
	}
	public static void FindByID()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the sales ID");
		int idLook = scan.nextInt();
		for (Salesperson i : salesPeople)
		{
			if(i.Get_ID() == idLook)
			{
				System.out.println(i);
			}
		}
		
	}
	
	public static void FindBySales()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the sales value");
		double saleLook = scan.nextDouble();
		for (Salesperson i : salesPeople)
		{
			if(i.Get_Annual_Sale_Amount() == saleLook)
			{
				System.out.println(i);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("We are going to create 3 sales person. Please give me their information one by one.");
		for(int i = 1; i <= 3; i++)
		{
			UserInput(i);
		}
		
		//System.out.println(salesPeople[2].Get_Annual_Sale_Amount());
		
		boolean validInput = false;
		while(!validInput)
		{
			
			Scanner newScan = new Scanner(System.in);
			menu();
			int userInput = newScan.nextInt();
			if(userInput != 1 && userInput != 2)
			{
				System.out.println("Sorry, please enter either 1 or 2");
			}
			else if(userInput == 1)
			{
				FindByID();
				validInput = true;
			}
			else if(userInput ==2)
			{
				FindBySales();
				validInput = true;
			}
		}
		
	}

}
