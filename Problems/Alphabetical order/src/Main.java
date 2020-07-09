import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// put your code here
		Scanner in = new Scanner(System.in);
		String[] txt = in.nextLine().split("[ ]");
		for (int i = 0; i < txt.length - 1; i++) {
			if (txt[i].compareTo(txt[i + 1]) > 0) {
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);
	}
}