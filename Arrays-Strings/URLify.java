import java.util.*;
class URLify{
	public static void main(String args[]){
		String input = "Mr John Smith Gold      ";
		int truelength = 18;
		char[] urlified_str = getUrlifiedStr(input.toCharArray(), truelength);
		System.out.println("Orginal String: "+input);
		System.out.println("URLified String: "+ Arrays.toString(urlified_str));
	}
	/* Hints : traverse the input string in reverse */
	public static char[] getUrlifiedStr(char[] input, int truelength){
		/* first count the number of true spaces */
		int spaceCount = 0;
		int index = 0;
		for( int i = 0; i < truelength ; i++)
		{
			if(input[i] == ' ')
				++spaceCount;
		}
		index = truelength + spaceCount * 2;
		System.out.println("index: "+index);
		if( truelength < input.length )
			input[truelength] = '\0';

		for( int i = truelength - 1; i >= 0 ; --i)
		{
			if( input[i] == ' ' )
			{
				input[index - 1] = '0';
				input[index - 2] = '2';
				input[index - 3] = '%';
				index = index - 3;
			}
			else{
				input[index - 1] = input[i];
				index--;
			}
		}
		return input;
	}
}
