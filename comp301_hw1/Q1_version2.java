package comp301_hw1_sabuha_kaya;

import java.util.ArrayList;
import java.util.Random;

public class Q1_version2 {
	
	//This is the class in which there are more O(1)  and O(n) operations used
	public static void main(String[] args) {
		long startTime1, startTime2, endTime1, endTime2, elapsedTime1, elapsedTime2;
		// compare running times
		ArrayList<Long> func100n2RunningTime = new ArrayList<Long>();
		ArrayList<Long> func2ToPowerNRunningTime = new ArrayList<Long>();

		int counter = 0;
		do {

			startTime2 = System.nanoTime();
			func100n2(counter);
			endTime2 = System.nanoTime();
			elapsedTime2 = endTime2 - startTime2;
			func100n2RunningTime.add(elapsedTime2);

			System.out.println("Time for n^2 algorithm: " + elapsedTime2);

			startTime1 = System.nanoTime();
			func2ToPowerN(counter);
			endTime1 = System.nanoTime();
			elapsedTime1 = endTime1 - startTime1;
			func2ToPowerNRunningTime.add(elapsedTime1);
			System.out.println("Time for 2^n algorithm: " + elapsedTime1);
			counter++;

		} while (func100n2RunningTime.get(counter - 1) >= func2ToPowerNRunningTime.get(counter - 1));
		System.out.println("this is n: " + counter);

	}

	public static void func100n2(int n) {
		int a[] = new int[n];
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(n);

		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= a.length + 1; i++) {
			for (int j = i + 1; j < a.length + 1; j++) {
				list.add( i + j);
			}
		}

	}

	private static int func2ToPowerN(int n) {

		if (n <= 1)
			return n;
		return func2ToPowerN(n - 2) + func2ToPowerN(n - 1);

	}

}
