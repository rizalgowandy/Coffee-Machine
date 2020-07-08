import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// put your code here
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int z = scanner.nextInt();
		int count = 0;
		if (x > 0) {
			count++;
		}
		if (y > 0) {
			count++;
		}
		if (z > 0) {
			count++;
		}
		System.out.println(count == 1);
	}
}