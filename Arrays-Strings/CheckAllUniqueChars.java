import java.util.*;

class CheckAllUniqueChars{
	public static void main(String args[]){
		System.out.println("Hello world");
		String str = "hello";
		if(checkUniqueChars(str) == true)
			System.out.println("All chars are unique in "+str);
		else
			System.out.println("Chars are not unique in "+str);
	}
	public static boolean checkUniqueChars(String str){
		/* If additional data structure is not allowed to use. And it assumes only chars from a-z */
		if( str.length() > 26 )
			return false;
		int checker = 0;
		for( int i = 0; i < str.length(); ++i)
		{
			int val = str.charAt(i) - 'a';
			if( (checker & (1 << val)) > 0 )
				return false;
			checker = checker | (1 << val);
		}
		return true;

		/* If additional data structures is allowed to use 
		ArrayList<Character> char_list = new ArrayList<Character>();
		for( int i = 0; i < str.length(); ++i)
		{
			if(char_list.contains(str.charAt(i)))
				return false;
			char_list.add(str.charAt(i));
		}
		return true;
		*/
	}
}
