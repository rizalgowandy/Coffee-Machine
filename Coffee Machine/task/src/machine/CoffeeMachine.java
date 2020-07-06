package machine;

import java.util.Scanner;

public class CoffeeMachine {
	private static final String[] steps = {
		"Starting to make a coffee",
		"Grinding coffee beans",
		"Boiling water",
		"Mixing boiled water with crushed coffee beans",
		"Pouring coffee into the cup",
		"Pouring some milk into the cup",
		"Coffee is ready!"
	};
	private static final int water = 200;
	private static final int milk = 50;
	private static final int bean = 15;

	public static void main(String[] args) {
		System.out.println("Write how many cups of coffee you will need:");
		Scanner in = new Scanner(System.in);
		int cups = in.nextInt();
		TotalIngredients(cups);
	}

	public static void Steps() {
		for (String step : steps) {
			System.out.println(step);
		}
	}

	public static void TotalIngredients(int cups) {
		int waters = water * cups;
		int milks = milk * cups;
		int beans = bean * cups;
		System.out.println(waters + " ml of water");
		System.out.println(milks + " ml of milk");
		System.out.println(beans + " g of coffee beans");
	}
}
