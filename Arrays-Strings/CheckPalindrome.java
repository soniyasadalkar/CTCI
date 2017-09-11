import java.util.*;

class CheckPalindrome{
	public static void main(String args[]){
		String input = "Tact Coa";
		if( checkPalindrome(input) )
			System.out.println("Yes! "+input+" has a permutation which is palindrome");
		else
			System.out.println("No! "+input+" does NOT have a permutation which is palindrome");

		if( checkPalindrome_v2(input) )
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

	public static boolean checkPalindrome_v2(String input){
		int bitVector = createBitVector(input);
		return (bitVector == 0 || checkExactlyOneBitSet(bitVector));
	}

	public static boolean checkExactlyOneBitSet(int bitVector){
		return (bitVector & (bitVector - 1)) == 0;
	}

	public static int getChar(char ch){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(ch);
		if( a <= val && z >= val)
			return val - a;
		return -1;
	}
	public static int createBitVector(String input){
		int bitVector = 0;
		for( char ch : input.toCharArray() ){
			int index = getChar(ch);
			bitVector = toggleVector(bitVector, index);
		}
		return bitVector;
	}
	
	public static int toggleVector(int bitVector, int index){
		if( index < 0) 
			return bitVector;
		int mask = (1 << index);
		if( (bitVector & mask) == 0)
			bitVector |= mask;
		else
			bitVector &= ~mask;
		
		return bitVector;
	}
}
