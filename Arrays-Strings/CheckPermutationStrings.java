import java.util.*;
class CheckPermutationStrings{
	public static void main(String args[]){
		String s1 = "odg";
		String s2 = "fog";

		if( checkPermutation(s1, s2) )
			System.out.println(s1+" is a permutated string of "+s2);
		else
			System.out.println(s1+" is NOT permutated string of "+s2);

		if( checkPermutation_v2(s1, s2) )
			System.out.println(s1+" is a permutated string of "+s2);
		else
			System.out.println(s1+" is NOT permutated string of "+s2);
		
		if( checkPermutation_v3(s1, s2) )
			System.out.println(s1+" is a permutated string of "+s2);
		else
			System.out.println(s1+" is NOT permutated string of "+s2);
	}
	public static String sort(String s){
		char[] charArr = s.toCharArray();
		java.util.Arrays.sort(charArr);
		return new String (charArr);
	}
	public static boolean checkPermutation(String s1, String s2){
		if( s1.length() != s2.length() )
			return false;
		return sort(s1).equals(sort(s2));
	}

	public static boolean checkPermutation_v2(String s1, String s2){
		if( s1.length() != s2.length() )
			return false;
		
		int[] letters = new int[256]; //assuming asci chars
		for( int i = 0; i < s1.length(); ++i)
			letters[s1.charAt(i)]++;
		for( int i = 0; i < s2.length(); ++i)
		{
			letters[s2.charAt(i)]--;
			if( letters[s2.charAt(i)] < 0 )
				return false;
		}
		
		return true;
	}

	public static boolean checkPermutation_v3(String s1, String s2){
		if( s1.length() != s2.length() )
			return false;
		
		HashMap<Character, Integer> char_counts = new HashMap<Character, Integer>();
		for( int i = 0; i < s1.length(); ++i)
		{
			if( char_counts.get(s1.charAt(i)) == null)
				char_counts.put( s1.charAt(i), 1);
			else
				char_counts.put(s1.charAt(i), char_counts.get(s1.charAt(i)) + 1);
		}

		for( int i = 0; i < s2.length(); ++i){
			if( char_counts.get(s2.charAt(i)) == null )
				return false;
			int val = char_counts.get(s2.charAt(i));
			val--;
			if( val < 0 )
				return false;
		}
		return true;
	}
}
