import java.util.*;

class CheckPalindrome{
	public static void main(String args[]){
		String input = "Tact Coa";
		if( checkPalindrome(input) )
			System.out.println("Yes! "+input+" has a permutation which is palindrome");
		else
			System.out.println("No! "+input+" does NOT have a permutation which is palindrome");

	}

	public static boolean checkChar(char ch){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(ch);
		if( a <= val && z >= val)
			return true;
		return false;
	}

	public static boolean checkPalindrome(String input){
		input = input.toLowerCase();
		ArrayList<Character> chars_list = new ArrayList<Character>();
		for( char ch : input.toCharArray() )
		{
			boolean is_char = checkChar(ch);
			if(is_char){
				if( chars_list.contains(ch))
				{
					int index = chars_list.indexOf(ch);
					chars_list.remove(index);
				}
				else
					chars_list.add(ch);
			}
		}
		return (chars_list.size() <= 1);
	}
}
