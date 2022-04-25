package comp301_hw1_sabuha_kaya;

public class Q1_version1 {

	//There are 2 versions of Q1, the first version gives the correct answer as I calculated mathematically.
	//However, the other version is also doing the same operations but there are a bit more things to do such 
	//as inserting elements into array and some constant value differences. Even though they are doing the same
	//thing there is 20-15=5n differences between them.
	public static void main(String[] args) {
		int n = 1;
		boolean isFound = false; // if we find the n than set isFound to true
		do {

			isFound = compare(n, isFound);
			n++;
		} while (!isFound);

	}

	//Compare both functions
	public static boolean compare(int n, boolean isFound) {
		if (n * n * 100 <= Math.pow(2, n)) {
			System.out.println(n);
			isFound = true;
		}
		return isFound;
	}

}
