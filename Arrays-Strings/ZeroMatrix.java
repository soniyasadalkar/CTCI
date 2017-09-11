import java.util.*;
class ZeroMatrix{
	public static void main(String args[]){
		int mat[][] = { {0, 2, 3, 6}, {4, 9, 6, 5} }; //, {7, 8, 9} };
		System.out.println("BEFORE");
		displayMatrix(mat);
		ReplaceZeros(mat);
		System.out.println("AFTER");
		displayMatrix(mat);
		System.out.println("------------------------------------");
		int mat2[][]  = 	{ {1,2,3,0} ,{0, 2, 3, 6}, {4, 9, 6, 5} };
		System.out.println("BEFORE");
		displayMatrix(mat2);
		ReplaceZeros_v2(mat2);
		System.out.println("AFTER");
		displayMatrix(mat2);
	}

	public static void ReplaceZeros_v2(int[][] matrix){
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		for( int i = 0; i < matrix[0].length ; ++i){
			if(matrix[0][i] == 0){
				rowHasZero = true;
				break;
			}	
		}
		for( int i = 0; i < matrix.length; ++i ){
			if( matrix[i][0] == 0 ){
				colHasZero = true;
				break;
			}
		}
		
		for( int i = 1; i < matrix.length; i++){
			for( int j = 1; j < matrix[0].length; ++j){
				if( matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
					System.out.println("here");
				}
			}
		}
		
		for( int i = 1; i < matrix.length ; i++){
			if( matrix[i][0] == 0 )
				nullifyRow(matrix, i);	
		}
		for( int i = 1; i < matrix[0].length; i++){
			if( matrix[0][i] == 0)
				nullifyColumn(matrix, i);
		}
		
		if( rowHasZero )
			nullifyRow(matrix, 0);
		if(colHasZero)
			nullifyColumn(matrix, 0);
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
