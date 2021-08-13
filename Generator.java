
/* Java program for Sudoku generator */

public class Generator
{
	int[][] mat;
	int N; // number of columns/rows.
	int K; // No. Of missing digits

	// Constructor
	 Generator(int N, int K)
	{
		this.N = N;
		this.K = K;
		mat = new int[N][N];

		fillValues();
	
	}


	// Sudoku Generator
	public void fillValues()
	{
		// Fill the diagonal matrices
		fillDiagonal();

		// Fill remaining blocks
		fillRemaining(0, 3);

	}
	// Fill the diagonal SRN number of SRN x SRN matrices
	void fillDiagonal()
	{

		for (int i = 0; i<N; i=i+3)

			// for diagonal box, start coordinates->i==j
			fillBox(i, i);
	}

  //UTILITY FUNCTION TO CHECK FOR DUPLICATES IN ROW/COLUMN/SUB MATRIX

	// Returns false if given 3 x 3 block contains num.
	boolean unUsedInBox(int rowStart, int colStart, int num)
	{
		for (int i = 0; i<3; i++)
			for (int j = 0; j<3; j++)
				if (mat[rowStart+i][colStart+j]==num)
					return false;

		return true;
	}

boolean unUsedInRow(int i,int num)
	{
		for (int j = 0; j<N; j++)
		if (mat[i][j] == num)
				return false;
		return true;
	}

	
	boolean unUsedInCol(int j,int num)
	{
		for (int i = 0; i<N; i++)
			if (mat[i][j] == num)
				return false;
		return true;
	}

	int randomGenerator(int num)
	{
    
    return (int) Math.floor((Math.random()*num+1));
	}

	// Fill a 3 x 3 matrix.
	void fillBox(int row,int col)
	{
		int num;
		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				do
				{
					num = randomGenerator(N);
				}
				while (!unUsedInBox(row, col, num));

				mat[row+i][col+j] = num;
			}
		}
	}

	// Random generator


	// Check if safe to put in cell
	boolean CheckIfSafe(int i,int j,int num)
	{
		return (unUsedInRow(i, num) &&
				unUsedInCol(j, num) &&
				unUsedInBox(i-i%3, j-j%3, num));
	}

	// A recursive function to fill remaining
	// matrix after diagonal
	boolean fillRemaining(int i, int j)
	{
		// System.out.println(i+" "+j);
		if (j>=N && i<N-1)
		{
			i = i + 1;
			j = 0;
		}

		if (i>=N && j>=N)
			return true;

		if (i < 3)
		{
			if (j < 3)
				j = 3;
		}

		else if (i < N-3)
		{
			if (j==(int)(i/3)*3)
				j = j + 3;
		}
		else
		{
			if (j == N-3)
			{
				i = i + 1;
				j = 0;
				if (i>=N)
					return true;
			}
		}

		for (int num = 1; num<=N; num++)
		{
			if (CheckIfSafe(i, j, num))
			{
				mat[i][j] = num;
				if (fillRemaining(i, j+1))
					return true;

				mat[i][j] = 0;
			}
		}
		return false;
	}

	// Print sudoku
	public void printSudoku()
	{
		for (int i = 0; i<N; i++)
		{
			for (int j = 0; j<N; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	private static class Holder
	{ //singleton class to avoid multiple instantiation of the object. here only one sudoku per game.
		static int N = 9;
		static int K = 80;
		private final static Generator sudoku = new Generator(N, K);

	}
 public static  Generator getInstance()
 {//returns the singleton sudoku
		return Holder.sudoku;
 }

 

	// Driver code
	public static void main(String[] args)
	{
		 Generator sudoku= Generator.getInstance();
		 //sudoku.fillValues();
		 //sudoku.printSudoku();
 
	}
}
