class RotateMatrixBy90Clockwise{
	public static void main(String args[]){
		int mat[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		if(rotateMatrix(mat))
			displayMatrix(mat);
		else
			System.out.println("Cannot rotate the matrix");
	}

	public static boolean rotateMatrix(int[][] matrix){
		System.out.println(matrix.length);
		System.out.println(matrix[0].length);

		if( matrix.length == 0 || matrix[0].length != matrix.length ) return false ;
		int n = matrix.length;
		for( int layer = 0; layer < n / 2; ++layer){
			int first  = layer;
			int last = n - 1 - layer;
			for( int i = first ; i < last; ++i){
				int offset = i - first;
				int temp = matrix[first][i]; // copy the top-left
				matrix[first][i] = matrix[last - offset][first]; // copy the bottom-left to top-left
				matrix[last - offset][first] = matrix[last][last-offset]; //copy bottom-right to bottom-left
				matrix[last][last - offset] = matrix[i][last]; // copy top-right to bottom right
				matrix[i][last] = temp; //restore the top-left to top-right.
			}
		}
		return true;
	}
	public static void displayMatrix(int[][] matrix){
		for( int i = 0; i < matrix.length ; ++i){
			for(int j = 0; j < matrix.length; ++j){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
