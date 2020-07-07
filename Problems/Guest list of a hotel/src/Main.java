import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// put your code here
		Scanner in = new Scanner(System.in);
		var input = new ArrayList<String>();
		while (in.hasNext()) {
			input.add(in.next());
		}
		Collections.reverse(input);
		for (String i : input) {
			System.out.println(i);
		}
	}
}