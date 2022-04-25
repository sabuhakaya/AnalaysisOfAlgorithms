import java.util.Arrays;
import java.util.Random;

public class linear {
	public static void main(String[] args) {
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		int[] A = new int[10];
		int[] B = new int[10];

		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextInt(9);

		}

		int k = 0;
		for (int i = 0; i < A.length; i++) {

			if (A[i] > k) {
				// k will have the maximum element of A[]
				k = A[i];
			}
		}
		System.out.println("Part B:");
		print_array(A);
		counting_sort(A, B, k);
		print_array(B);

		System.out.println("\nPart C:");
		// Part c
		for (int i = 1; i <= 8; i++) {
			int array_size = (int) Math.pow(10, i);
			int[] array = new int[array_size];
			int[] array1 = new int[array_size];

			for (int j = 0; j < array_size; j++) {
				array[j] = rand.nextInt(array_size - 1);

			}
			int max = 0;
			for (int j = 0; j < array_size; j++) {

				if (array[j] > max) {
					max = array[j];
				}
			}

			long start_time, end_time, elapsed_time;

			start_time = System.nanoTime();
			counting_sort(array, array1, max);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.printf("Elapsed time in nanoseconds for counting sort with array_size %d: %d\n", array_size,
					elapsed_time);

			start_time = System.nanoTime();
			merge_sort(array, 0, array_size - 1);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.printf("Elapsed time in nanoseconds for merge sort with array_size %d: %d\n", array_size,
					elapsed_time);

			start_time = System.nanoTime();
			heap_sort(array);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.printf("Elapsed time in nanoseconds for heap sort with array_size %d: %d\n\n", array_size,
					elapsed_time);

		}

		System.out.println("\nPart D:");
		for (int i = 1; i <= 5; i++) {
			int range = (int) Math.pow(10, 7);
			int array_size = (int) Math.pow(10, i);
			int[] array = new int[array_size];
			int[] array1 = new int[array_size];

			for (int j = 0; j < array_size; j++) {
				array[j] = rand.nextInt(range - 1);
			}
			int max = 0;
			for (int j = 0; j < array_size; j++) {

				if (array[j] > max) {
					max = array[j];
				}
			}

			long start_time, end_time, elapsed_time;

			start_time = System.nanoTime();
			counting_sort(array, array1, max);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.printf("Elapsed time in nanoseconds for counting sort with array_size %d: %d\n", array_size,
					elapsed_time);

			start_time = System.nanoTime();
			merge_sort(array, 0, array_size - 1);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.printf("Elapsed time in nanoseconds for merge sort with array_size %d: %d\n", array_size,
					elapsed_time);

			start_time = System.nanoTime();
			heap_sort(array);
			end_time = System.nanoTime();
			elapsed_time = end_time - start_time;
			System.out.printf("Elapsed time in nanoseconds for heap sort with array_size %d: %d\n\n", array_size,
					elapsed_time);

		}

		System.out.println("\nPart E:");

		int range = (int) Math.pow(10, 7);
		int array_size = (int) Math.pow(10, 8);
		int[] array = new int[array_size];
		int[] array1 = new int[array_size];

		for (int j = 0; j < array_size; j++) {
			array[j] = rand.nextInt(range - 1);
		}
		int max = 0;
		for (int j = 0; j < array_size; j++) {

			if (array[j] > max) {
				max = array[j];
			}
		}

		long start_time, end_time, elapsed_time;

		/*
		 * start_time = System.nanoTime(); counting_sort(array, array1, max); end_time =
		 * System.nanoTime(); elapsed_time = end_time - start_time; System.out.
		 * printf("Elapsed time in nanoseconds for counting sort with array_size %d: %d\n"
		 * , array_size, elapsed_time);
		 */

		/*
		 * start_time = System.nanoTime(); merge_sort(array, 0, array_size - 1);
		 * end_time = System.nanoTime(); elapsed_time = end_time - start_time;
		 * System.out.
		 * printf("Elapsed time in nanoseconds for merge sort with array_size %d: %d\n",
		 * array_size, elapsed_time);
		 * 
		 * start_time = System.nanoTime(); heap_sort(array); end_time =
		 * System.nanoTime(); elapsed_time = end_time - start_time; System.out.
		 * printf("Elapsed time in nanoseconds for heap sort with array_size %d: %d\n\n"
		 * , array_size, elapsed_time);
		 */
	}

	// Implement counting sort algorithm below
	static void counting_sort(int A[], int B[], int k) {

		int[] C = new int[k + 1];

		for (int i = 0; i < k; ++i) {
			C[i] = 0;
		}

		for (int i = 0; i < A.length; i++) {
			C[A[i]]++;
		}

		for (int i = 1; i <= k; i++) {
			C[i] += C[i - 1];
		}

		for (int i = A.length - 1; i >= 0; i--) {
			B[C[A[i]] - 1] = A[i];
			C[A[i]]--;
		}

	}

	// assumes that index i starts from 1
	public static int parent(int i) {
		return (int) Math.floor(i / 2);
	}

	// assumes that index i starts from 1
	public static int left(int i) {
		return 2 * i;
	}

	// assumes that index i starts from 1
	public static int right(int i) {
		return (2 * i + 1);
	}

	// assumes that index i starts from 1
	public static void max_heapify(int[] A, int array_size, int i) {
		int left_index, right_index, index_of_largest;
		int temp;

		left_index = left(i);
		right_index = right(i);

		if ((left_index <= array_size) && (A[left_index - 1] > A[i - 1]))
			index_of_largest = left_index;
		else
			index_of_largest = i;

		if ((right_index <= array_size) && (A[right_index - 1] > A[index_of_largest - 1]))
			index_of_largest = right_index;

		if (index_of_largest != i) {
			temp = A[i - 1];
			A[i - 1] = A[index_of_largest - 1];
			A[index_of_largest - 1] = temp;
			max_heapify(A, array_size, index_of_largest);
		}
	}

	public static void build_max_heap(int[] A) {
		int middle_index = (int) Math.floor(A.length / 2);
		int array_size = A.length;

		for (int i = middle_index; i >= 1; i--)
			max_heapify(A, array_size, i);
	}

	public static void heap_sort(int[] A) {
		int temp;
		int array_size = A.length;
		build_max_heap(A);

		for (int i = A.length; i >= 2; i--) {
			temp = A[0];
			A[0] = A[i - 1];
			A[i - 1] = temp;
			array_size--;
			max_heapify(A, array_size, 1);
		}
	}

	// indices p and r can start from 0
	public static void merge_sort(int[] A, int p, int r) {
		int q;

		if (p < r) {
			q = (int) Math.floor((p + r) / 2);
			merge_sort(A, p, q);
			merge_sort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}

	public static void merge(int[] A, int p, int q, int r) {
		int n1, n2;
		int i, j;

		n1 = q - p + 1;
		n2 = r - q;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = A[p + i];

		for (i = 0; i < n2; i++)
			R[i] = A[q + i + 1];

		i = 0;
		j = 0;

		for (int k = p; k <= r; k++) {
			if (i >= n1) // the left array finished, copy from right array
			{
				A[k] = R[j];
				j++;
				continue;
			}

			if (j >= n2) // the right array finished, copy from left array
			{
				A[k] = L[i];
				i++;
				continue;
			}

			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
		}
	}

	// prints the elements of the array A on the screen
	public static void print_array(int[] A) {
		System.out.printf("[");
		for (int i = 0; i < A.length - 1; i++) {
			System.out.printf("%d, ", A[i]);
		}

		System.out.printf("%d]\n", A[A.length - 1]);

	}
}
