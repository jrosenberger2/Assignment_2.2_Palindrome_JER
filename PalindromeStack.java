package palindrome;
import java.util.Stack;
/**
 * PalindromeStack.java uses a stack to test if Strings given by the user are palindromes or not (ignoring case, punctuation and spaces)
 * @author Jared Rosenberger
 * @version 9/29/22
 * PalindromeStack.java
 * Fall 2022
 */
public class PalindromeStack {
	private Stack<Character> backwards;//backwards is used to reserve strings
	private Stack<Character> inputMessage;//allows the original message to be parsed for spaces/punctuation
	
	/**
	 * Constructor initializes class variables
	 */
	public PalindromeStack() {
		backwards = new Stack<Character>();
		inputMessage = new Stack<Character>();
	}//end PalindromeStack
	
	/**
	 * isPalindrome pushes the chars in a String onto a stack and then pops them off into a new String in order to see
	 *   if the phrase is the same forwards as it is backwards 
	 * @param input is the word/phrase to be tested 
	 * @return true if the phrase is a palindrome and false if it is not
	 */
	public Boolean isPalindrome(String input) {
		input = input.toLowerCase();
		//pareseInput removes all illegal characters from the input string
		inputMessage = parseInput(input);
		//toStack pushes each letter of the input onto a stack and returns that stack
		backwards = toStack(input);
		
		//getStackMessage pops each letter off the stack and formats it into a new string
		while(backwards.size() > 0 && inputMessage.size() > 0) {
			Character a = backwards.pop();
			Character b = inputMessage.pop();
			if(a != b)
				return false;
		}//end while loop
		
		return true;
	}//end isPalindrome
	
	/**
	 * toStack pushes each letter of the message onto a stack
	 * @param message is the String to be pushed onto a stack
	 * @return a new stack of the characters in the input message
	 */
	private Stack<Character> toStack(String message){
		Stack<Character> result = new Stack<Character>();
		for(int i = 0; i < message.length(); i++) {
			char temp = message.charAt(i);
			if(isCharAllowed(temp)) {
				result.push(temp);
			}
		}
		return result;
	}//end toStack
	
	/**
	 * parseInput takes an input string and removes "illegal" characters while keeping the order of the string intact
	 * @param message is the string to parsed for "illegal" characters
	 * @return a new version of the original string that doesn't have any "illegal" characters
	 */
	private Stack<Character> parseInput(String message){
		Stack<Character> result = new Stack<Character>();
		for(int i = message.length()-1; i > -1; i--) {
			char temp = message.charAt(i);
			if(isCharAllowed(temp)) {
				result.push(temp);
			}
		}
		return result;
	}//end toStackKeepOrder
	
	/**
	 * isCharAllowed tests passed in characters to see if they should be added to the stack or not
	 * @param c is the character being passed into the method
	 * @return true if the character should be pushed onto the stack and false if it should not
	 */
	private Boolean isCharAllowed(char c) {
		Boolean result = true;
		char[] ignore = {'!', ';', ':', '"', '\'', '.', ',', '/', '?', '-', ' '}; //Array of all the chars we are ignoring for palindrome tests
		for(char f: ignore) {
			if(c == f)
				result = false;
		}
		return result;
	}//end isCharAllowed
	
}//end PalindromeStack