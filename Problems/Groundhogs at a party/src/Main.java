import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// put your code here
		int input = scanner.nextInt();
		boolean x = scanner.nextBoolean();
		if (!x) {
			System.out.println(input >= 10 && input <= 20);
			return;
		}
		System.out.println(input >= 15 && input <= 25);
	}
}