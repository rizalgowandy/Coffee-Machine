import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// put your code here
		Scanner in = new Scanner(System.in);
		int min = in.nextInt();
		int max = in.nextInt();
		int cur = in.nextInt();
		if (cur < min) {
			System.out.println("Deficiency");
			return;
		}
		if (cur > max) {
			System.out.println("Excess");
			return;
		}
		System.out.println("Normal");
	}
}