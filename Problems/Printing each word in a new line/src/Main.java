import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// put your code here
		Scanner in = new Scanner(System.in);
		String[] input = new String[5];
		for (int i = 0; i < input.length; i++) {
			input[i] = in.next();
		}
		for (String i : input) {
			System.out.println(i);
		}
	}
}