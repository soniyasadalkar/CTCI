class StringCompression
{
	public static void main(String args[]){
		String input = "aabb";
		System.out.println(getCompressedString(input));
	}

	public static String getCompressedString(String input){
		StringBuilder compressed_str = new StringBuilder();
		int countCompress = 0;
		for( int i  = 0; i < input.length() ; ++i){
			countCompress++;
			if( i + 1 >= input.length() || input.charAt(i) != input.charAt(i+1)){
				compressed_str.append(input.charAt(i));
				compressed_str.append(countCompress);
				countCompress = 0;
			}
		}
		return compressed_str.length() >= input.length() ? input : compressed_str.toString();
	}
}
