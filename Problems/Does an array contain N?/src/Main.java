import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// put your code here
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = in.nextInt();
		}
		int w = in.nextInt();
		for (int i : s) {
			if (w == i) {
				System.out.println(true);
				return;
			}
		}
		System.out.println(false);
	}
}