import java.util.Random;

public class matrix {
	public static void main(String[] args) {
		int size = 2;
		int size_2 = 16;
		int size_3 = 64;

		int[][] A = new int[size][size];
		int[][] B = new int[size][size];
		int[][] C = new int[size][size];

		int[][] A_2 = new int[size_2][size_2];
		int[][] B_2 = new int[size_2][size_2];
		int[][] C_2 = new int[size_2][size_2];

		int[][] A_3 = new int[size_3][size_3];
		int[][] B_3 = new int[size_3][size_3];
		int[][] C_3 = new int[size_3][size_3];

		long start_time, end_time, elapsed_time;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		// part 1(b)
		A[0][0] = 1;
		A[0][1] = 3;
		A[1][0] = 7;
		A[1][1] = 5;
		B[0][0] = 6;
		B[0][1] = 8;
		B[1][0] = 4;
		B[1][1] = 2;

		//square_matrix_multiply(A, B, C);

		print_2d_array(A);
		print_2d_array(B);
		print_2d_array(C);

		// part 1(c)
		// initialize elements of matrices with random integers
		initialize_2d_array_random(A_2);
		initialize_2d_array_random(B_2);
		start_time = System.nanoTime();
		square_matrix_multiply(A_2, B_2, C_2);
		end_time = System.nanoTime();
		elapsed_time = end_time - start_time;
		//System.out.println("Time it takes: " + elapsed_time);

		// compute the elapsed time

		// part 1(d)
		// initialize elements of matrices with random integers
		initialize_2d_array_random(A_3);
		initialize_2d_array_random(B_3);
		initialize_2d_array(C_3);

		start_time = System.nanoTime();
		square_matrix_multiply(A_3, B_3, C_3);
		end_time = System.nanoTime();
		elapsed_time = end_time - start_time;
		//System.out.println("Time it takes part d: " + elapsed_time);

		// compute the elapsed time
		A[0][0] = 1;
		A[0][1] = 3;
		A[1][0] = 7;
		A[1][1] = 5;
		B[0][0] = 6;
		B[0][1] = 8;
		B[1][0] = 4;
		B[1][1] = 2;
		// part 2(b)
		
		
		square_matrix_multiply_recursive(A, B,0, 1, 0,1, 0,1, 0,1,0,1,0,1, C);
		System.out.println("This was the array");
		print_2d_array(C);

		// set elements of C to zero first
		initialize_2d_array(C);
		/*
		 * print_2d_array(A); print_2d_array(B); print_2d_array(C);
		 */
		// part 2(c)

		// set elements of C_2 to zero first
		initialize_2d_array(C_2);

		// compute the elapsed time

		// second version of recursive algorithm implementation that uses less variable
		// assignmens for divide step
		// set elements of C_2 to zero first
		initialize_2d_array(C_2);

		// compute the elapsed time

		// part 2(d)

		// set elements of C_3 to zero first
		initialize_2d_array(C_3);

		// compute the elapsed time

		// second version of recursive algorithm implementation that uses less variable
		// assignmens for divide step
		// set elements of C_3 to zero first
		initialize_2d_array(C_3);

		// compute the elapsed time
	}

	// part 1(a) implementing the square matrix multiply algorithm
	public static void square_matrix_multiply(int[][] A, int[][] B, int[][] C) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {

				for (int k = 0; k < B.length; k++)
					C[i][j] += A[i][k] * B[k][j];

			}

		}
		// print_2d_array(C);

	}

	// part 2(a)
	public static void square_matrix_multiply_recursive(int[][] A, int[][] B, int A_row_index_start,
			int A_row_index_end, int A_col_index_start, int A_col_index_end, int B_row_index_start, int B_row_index_end,
			int B_col_index_start, int B_col_index_end, int C_row_index_start, int C_row_index_end,
			int C_col_index_start, int C_col_index_end, int[][] C) {
		int n = A_row_index_end - A_row_index_start + 1;

		// Divide step, compute the middle points for the row and column indices of A
		// and B matrix

		int A11_row_index_start = A_row_index_start;
		int A11_row_index_end = (A_row_index_end + A_row_index_start) / 2;
		int A11_col_index_start = A_col_index_start;
		int A11_col_index_end = (A_col_index_end + A_col_index_start) / 2;

		int A12_row_index_start = A_row_index_start;
		int A12_row_index_end = (A_row_index_end + A_row_index_start) / 2;
		int A12_col_index_start = (A_col_index_end + A_col_index_start) / 2 + 1;
		int A12_col_index_end = A_col_index_end;

		int A21_row_index_start = (A_row_index_end + A_row_index_start) / 2 + 1;
		int A21_row_index_end = A_row_index_end;
		int A21_col_index_start = A_col_index_start;
		int A21_col_index_end = (A_col_index_end + A_col_index_start) / 2;

		int A22_row_index_start = (A_row_index_end + A_row_index_start) / 2 + 1;
		int A22_row_index_end = A_row_index_end;
		int A22_col_index_start = (A_col_index_end + A_col_index_start) / 2 + 1;
		int A22_col_index_end = A_col_index_end;

		int B11_row_index_start = B_row_index_start;
		int B11_row_index_end = (B_row_index_end + B_row_index_start) / 2;
		int B11_col_index_start = B_col_index_start;
		int B11_col_index_end = (B_col_index_end + B_col_index_start) / 2;

		int B12_row_index_start = B_row_index_start;
		int B12_row_index_end = (B_row_index_end + B_row_index_start) / 2;
		int B12_col_index_start = (B_col_index_end + B_col_index_start) / 2 + 1;
		int B12_col_index_end = B_col_index_end;

		int B21_row_index_start = (B_row_index_end + B_row_index_start) / 2 + 1;
		int B21_row_index_end = B_row_index_end;
		int B21_col_index_start = B_col_index_start;
		int B21_col_index_end = (B_col_index_end + B_col_index_start) / 2;

		int B22_row_index_start = (B_row_index_end + B_row_index_start) / 2 + 1;
		int B22_row_index_end = B_row_index_end;
		int B22_col_index_start = (B_col_index_end + B_col_index_start) / 2 + 1;
		int B22_col_index_end = B_col_index_end;

		if (n == 1) {
			C[C_row_index_start][C_col_index_start] += A[A_row_index_start][A_col_index_start]
					* B[B_row_index_start][B_col_index_start];
		
	
		}
		else {
			// implement the recursive part here
			// Recursive call 1 for C11
			square_matrix_multiply_recursive(A, B, A11_row_index_start, A11_row_index_end,
					A11_col_index_start, A11_col_index_end, B11_row_index_start, B11_row_index_end, B11_col_index_start,
					B11_col_index_end, C_row_index_start, C_row_index_end, C_col_index_start, C_col_index_end, C);

			C_row_index_start = A11_row_index_start;
			C_row_index_end = A11_row_index_end;
			C_col_index_start = A11_col_index_start;
			C_col_index_end = A11_col_index_end;

			// Recursive call 2 for C11

			 square_matrix_multiply_recursive(A, B, A12_row_index_start, A12_row_index_end,
					A12_col_index_start, A12_col_index_end, B21_row_index_start, B21_row_index_end, B21_col_index_start,
					B21_col_index_end, C_row_index_start, C_row_index_end, C_col_index_start, C_col_index_end, C);

			// Recursive call 1 for C12
			square_matrix_multiply_recursive(A, B, A11_row_index_start, A11_row_index_end, A11_col_index_start,
					A11_col_index_end, B12_row_index_start, B12_row_index_end, B12_col_index_start, B12_col_index_end,
					C_row_index_start, C_row_index_end, C_col_index_start, C_col_index_end, C);

			C_row_index_start = A12_row_index_start;
			C_row_index_end = A12_row_index_end;
			C_col_index_start = A12_col_index_start;
			C_col_index_end = A12_col_index_end;

			// Recursive call 2 for C12
			square_matrix_multiply_recursive(A, B, A12_row_index_start, A12_row_index_end, A12_col_index_start,
					A12_col_index_end, B22_row_index_start, B22_row_index_end, B22_col_index_start, B22_col_index_end,
					C_row_index_start, C_row_index_end, C_col_index_start, C_col_index_end, C);

			// Recursive call 1 for C21
			square_matrix_multiply_recursive(A, B, A21_row_index_start, A21_row_index_end, A21_col_index_start,
					A21_col_index_end, B11_row_index_start, B11_row_index_end, B11_col_index_start, B11_col_index_end,
					C_row_index_start, C_row_index_end, C_col_index_start, C_col_index_end, C);

			C_row_index_start = A21_row_index_start;
			C_row_index_end = A21_row_index_end;
			C_col_index_start = A21_col_index_start;
			C_col_index_end = A21_col_index_end;

			// Recursive call 2 for C21
			square_matrix_multiply_recursive(A, B, A22_row_index_start, A22_row_index_end, A22_col_index_start,
					A22_col_index_end, B21_row_index_start, B21_row_index_end, B21_col_index_start, B21_col_index_end,
					C_row_index_start, C_row_index_end, C_col_index_start, C_col_index_end, C);

			// Recursive call 1 for C22
			square_matrix_multiply_recursive(A, B, A21_row_index_start, A21_row_index_end, A21_col_index_start,
					A21_col_index_end, B12_row_index_start, B12_row_index_end, B12_col_index_start, B12_col_index_end,
					C_row_index_start, C_row_index_end, C_col_index_start, C_col_index_end, C);

			C_row_index_start = A22_row_index_start;
			C_row_index_end = A22_row_index_end;
			C_col_index_start = A22_col_index_start;
			C_col_index_end = A22_col_index_end;

			// Recursive call 2 for C12
			square_matrix_multiply_recursive(A, B, A22_row_index_start, A22_row_index_end, A22_col_index_start,
					A22_col_index_end, B22_row_index_start, B22_row_index_end, B22_col_index_start, B22_col_index_end,
					C_row_index_start, C_row_index_end, C_col_index_start, C_col_index_end, C);
			
			
			
		}
		
		
	}

	static void add(int[][] C, int[][] A, int[][] B, int rowC, int colC) {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				C[i + rowC][j + colC] = A[i][j] + B[i][j];
			}
		}

	}

	// prints the elements of the array A on the screen
	public static void print_2d_array(int[][] A) {
		// System.out.printf("[");
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++)
				System.out.printf("%d ", A[i][j]);
			System.out.printf("\n");
		}

		// System.out.printf("%d]\n", A[A.length-1]);

	}

	public static void initialize_2d_array_random(int[][] A) {
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++)
				A[i][j] = rand.nextInt(100);
		}
	}

	public static void initialize_2d_array(int[][] A) {
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++)
				A[i][j] = 0;
		}
	}
}
