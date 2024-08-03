import java.util.ArrayList;
import java.util.*;

public class Perumtations {

	public static String userInput()
	{  
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a string: ");
		return scan.nextLine();
	}
	
	public static ArrayList<String> Permutations(String input)
	{
		ArrayList<String> result = new ArrayList<>();
		if (input.length() == 0)
		{
			result.add("");
			return result;
		}
		
		char fChar = input.charAt(0);
		String restString = input.substring(1);
		
		ArrayList<String> words = Permutations(restString);
		for (String word : words)
		{
			for (int i = 0; i<= word.length();i++)
			{
				result.add(insertChar(word, fChar, i));
			}
		}
		return result;
	}
	public static String insertChar(String word, char c, int index)
	{
		String start = word.substring(0, index);
		String end = word.substring(index);
		return start + c + end;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//This program I am writing permutations of a string.
		//I think I will approach this with a recursive Arraylist
		String userInput = userInput();

		ArrayList<String> permutation = Permutations(userInput);
		for(String i : permutation)
		{
			System.out.println(i);
		}
		

	}

}
