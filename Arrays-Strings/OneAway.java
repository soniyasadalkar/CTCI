class OneAway{
	public static void main(String args[]){
		String s1 = "pale";
		String s2 = "ples";

		if( checkOneAway(s1, s2) )
			System.out.println("YES: "+s1+","+s2);
		else
			System.out.println("NO: "+s1+","+s2);
		
		if( checkOneAway_v2(s1, s2) )
			System.out.println("YES: "+s1+","+s2);
		else
			System.out.println("NO: "+s1+","+s2);
	}

	public static boolean checkOneAway(String s1, String s2){
		if( s1.length() == s2.length() )
			return OneReplaceAway(s1, s2);
		else if( s1.length() + 1 == s2.length() ) //which ever is small comes first.
			return OneInsertAway(s1,s2);
		else if (s1.length() - 1 == s2.length() )
			return OneInsertAway(s2, s1);
		return false;
	}

	public static boolean OneReplaceAway(String s1, String s2){
		boolean foundDifference = false;
		for( int i = 0; i < s1.length(); i++) {
			if( s1.charAt(i) != s2.charAt(i) )
			{
				if( foundDifference )
					return false;
				foundDifference = true;
			}
		}
		return true;
	}

	public static boolean OneInsertAway(String s1, String s2){
		int index1 = 0;
		int index2 = 0;

		boolean foundDifference = false;
		while( index2 < s2.length() && index1 < s1.length() ){
			if( s1.charAt(index1) != s2.charAt(index2) ){
				if( index1 != index2 )
					return false;
				index2++;
			}
			else{
				index1++;
				index2++;
			}
		}
		return true;
	}

	public static boolean checkOneAway_v2(String first, String second){
		if( Math.abs(first.length() - second.length()) > 1)
			return false;

		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;

		int index1 = 0;
		int index2 = 0;

		boolean foundDifference = false;
		while( index1 < s1.length() && index2 < s2.length() ){
			if( s1.charAt(index1) != s2.charAt(index2) )
			{
				if( foundDifference )
					return false;
				foundDifference = true;

				if( s1.length() == s2.length()) //replace case.
					index1++;
			}
			else
				index1++; // matching case.
			index2++; //index2 always advances -> the longer string ptr.
		}
		return true;
	}
}
