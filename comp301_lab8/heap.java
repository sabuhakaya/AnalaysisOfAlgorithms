import java.util.Arrays;
import java.util.Random;

public class heap {
	public static void main(String[] args) {

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

//part 1b
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++)
			arr[i] = rand.nextInt(100);

		heap_sort(arr);
		print_array(arr);

		int array_size = 67108864;
		int[] array = new int[array_size];
		long start_time, end_time, elapsed_time, elapsed_time_insertion, elapsed_time_merge;

//part 1c
		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(67108864);

		heap_sort(array);
//861 java 99.6 00:06.34 27/1 3 117 277M 0B 0B 493 493

//part d
//merge_sort(array, 0,arr.length-1);
//881 java 100.5 00:07.84 27/1 3 117 778M+ 0B 0B 493 493

		start_time = System.nanoTime();
		merge_sort(array, 0, array_size - 1);
		end_time = System.nanoTime();
		elapsed_time = end_time - start_time;
		System.out.printf("Elapsed time in nanoseconds for insertion sort when "+array_size+" integers are sorted: %d\n",
				elapsed_time);

//Heap is consuming less memory than merge
	}

//Implement heap sort algorithm below
	public static void heap_sort(int A[]) {

		int heap_size = A.length - 1;
		BUILD_MAX_HEAP(A);
		for (int i = heap_size; i > 0; i--) {
			int swap = A[0];
			A[0] = A[i];
			A[i] = swap;
			heap_size = heap_size - 1;
			MAX_HEAPIFY(A, 0, heap_size);
		}

	}

	static void MAX_HEAPIFY(int arr[], int i, int heap_size) {

		int l = LEFT(i);
		int r = RIGHT(i);
		int largest = 0;

		if (l < heap_size && arr[l] > arr[i])
			largest = l;
		else
			largest = i;

		if (r < heap_size && arr[r] > arr[largest])
			largest = r;

// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			MAX_HEAPIFY(arr, largest, heap_size);
		}
	}

	static void BUILD_MAX_HEAP(int A[]) {
		int heap_size = A.length - 1;
		for (int i = heap_size / 2; i >= 1; i--) {
			MAX_HEAPIFY(A, i, heap_size);
		}

	}

	int PARENT(int i) {
		return (i - 1) / 2;

	}

	static int LEFT(int i) {
		return 2 * i + 1;

	}

	static int RIGHT(int i) {
		return 2 * i + 2;

	}

//indices p and r can start from 0
	public static void merge_sort(int[] A, int p, int r) {
		int q;

		if (p < r) {
			q = (int) Math.floor((p + r) / 2);
			merge_sort(A, p, q);
			merge_sort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}

//Part 2(a)
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

//prints the elements of the array A on the screen
	public static void print_array(int[] A) {
		System.out.printf("[");
		for (int i = 0; i < A.length - 1; i++) {
			System.out.printf("%d, ", A[i]);
		}

		System.out.printf("%d]\n", A[A.length - 1]);

	}
}