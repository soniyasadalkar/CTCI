import java.util.*;
class ZeroMatrix{
	public static void main(String args[]){
		int mat[][] = { {0, 2, 3, 6}, {4, 9, 6, 5} }; //, {7, 8, 9} };
		System.out.println("BEFORE");
		System.out.println(Arrays.toString(mat[0]));
		displayMatrix(mat);
		ReplaceZeros(mat);
		System.out.println("AFTER");
		displayMatrix(mat);	
	}

	public static void ReplaceZeros(int[][] matrix){
		boolean row[] = new boolean[matrix.length];
		boolean column[] = new boolean[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0 ; j < matrix[0].length; j++){
				if( matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		System.out.println(Arrays.toString(row));
		for( int i = 0 ; i < row.length ; ++i)
		{
			if( row[i] )
				nullifyRow(matrix, i);
		}

		for( int i = 0 ; i < column.length ; ++i)
		{
			if( column[i] )
				nullifyColumn(matrix, i);
		}
	}
	
	public static void nullifyRow(int[][] matrix, int row){
		for( int  i = 0; i < matrix[0].length ; ++i)
			matrix[row][i] = 0;
	}

	public static void nullifyColumn(int[][] matrix, int column){
		for( int  i = 0; i < matrix.length ; ++i)
			matrix[i][column] = 0;
	}
	public static void displayMatrix(int[][] matrix){
		for( int i = 0; i < matrix.length ; ++i){
			for(int j = 0; j < matrix[0].length; ++j){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
