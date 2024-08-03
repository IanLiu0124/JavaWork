import javax.swing.*;
import java.util.*;

public class RemoveDup {
	public static void DisplayArray(int[] x)
	{
		for(int i : x)
		{
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//This program will remove duplicate element of a given sorted integer array and remove the duiplicate elements from the array.
		//After removing, program should return the array without duplications and the length of the new array
		
		//So I know a SET is unique and will now allow duplications. So I am thinking about 
		int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 9, 10, 10};
		Set<Integer> mySet = new HashSet<>();
		
		//I run through the number and add the set
		for (int i: sortedArray)
		{
			mySet.add(i);
		}
		
		//System.out.println(mySet);  This returns a set of the int with no dup
		
		int[] newArray = new int[mySet.size()];
		
		int index = 0;
		for (int i : mySet)
		{
			newArray[index] = i;
			index ++;
		}
		
		System.out.println("Array before: ");
		DisplayArray(sortedArray);
		System.out.println("Array Length: " + sortedArray.length);
		System.out.println("\nArray after: ");
		DisplayArray(newArray);
		System.out.println("Array Length: " + newArray.length);

	}

}
