import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// put your code here
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] inputs = new int[n];
		int maxSeq = 0;
		int curSeq = 0;
		int prev = 0;
		for (int i = 0; i < n; i++) {
			inputs[i] = in.nextInt();
			if (inputs[i] > prev) {
				curSeq++;
			} else {
				curSeq = 1;
			}
			prev = inputs[i];
			if (curSeq > maxSeq) {
				maxSeq = curSeq;
			}
		}
		System.out.println(maxSeq);
	}
}