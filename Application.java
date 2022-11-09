import java.util.Scanner;
/**
 * Application.java tests the methods of PalindromeStack.java by accepting Strings from the user
 * @author Jared Rosenberger
 * @version 11/9/22
 * Application.java
 * Fall 2022
 */
public class Application {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		PalindromeStack testPalindrome = new PalindromeStack();
		String userInput = "";
		
		while(!userInput.equals("end")) {
		System.out.println("Input a string to see if it is a palindrome or not (type \"end\" to stop testing)");
		userInput = keyboard.nextLine();
		if(userInput.equals("end"))
			System.out.println("Palindrome Testing Ended");
		else if(testPalindrome.isPalindrome(userInput))
			System.out.println(userInput + " is a palidrome!\n");
		else
			System.out.println(userInput + " is not a palindrome.\n");
		}//end while loop 
		
		keyboard.close();
	}//end main
}//end Application
