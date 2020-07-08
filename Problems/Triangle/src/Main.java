import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// put your code here
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		if (a + b > c && a + c > b && b + c > a) {
			System.out.println("YES");
			return;
		}
		System.out.println("NO");
	}
}