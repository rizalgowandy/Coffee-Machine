package machine;

import java.util.Scanner;

public class CoffeeMachine {
	static final String[] steps = {
		"Starting to make a coffee",
		"Grinding coffee beans",
		"Boiling water",
		"Mixing boiled water with crushed coffee beans",
		"Pouring coffee into the cup",
		"Pouring some milk into the cup",
		"Coffee is ready!"
	};
	static final int requiredWater = 200;
	static final int requiredMilk = 50;
	static final int requiredBean = 15;
	static int waterSupply = 0;
	static int milkSupply = 0;
	static int beanSupply = 0;

	public static void main(String[] args) {
		CanMakeOrder();
	}

	static void PrintSteps() {
		for (String step : steps) {
			System.out.println(step);
		}
	}

	static void PrintTotalIngredients() {
		System.out.println("Write how many cups of coffee you will need:");
		Scanner in = new Scanner(System.in);
		int cups = in.nextInt();
		int waters = requiredWater * cups;
		int milks = requiredMilk * cups;
		int beans = requiredBean * cups;
		System.out.println(waters + " ml of water");
		System.out.println(milks + " ml of milk");
		System.out.println(beans + " g of coffee beans");
	}

	static void CanMakeOrder() {
		Scanner in = new Scanner(System.in);
		System.out.println("Write how many ml of water the coffee machine has: ");
		waterSupply = in.nextInt();
		System.out.println("Write how many ml of milk the coffee machine has:");
		milkSupply = in.nextInt();
		System.out.println("Write how many grams of coffee beans the coffee machine has:");
		beanSupply = in.nextInt();
		System.out.println("Write how many cups of coffee you will need:");
		int cups = in.nextInt();
		int supply = ToCup(waterSupply, milkSupply, beanSupply);
		if (cups < supply) {
			int extra = supply - cups;
			System.out.printf("Yes, I can make that amount of coffee " +
				"(and even %d more than that)\n", extra);
			return;
		}
		if (cups == supply) {
			System.out.println("Yes, I can make that amount of coffee");
			return;
		}
		System.out.printf("No, I can make only %d cup(s) of coffee\n", supply);
	}

	static int ToCup(int water, int milk, int bean) {
		int maxWater = water / requiredWater;
		int maxMilk = milk / requiredMilk;
		int maxBean = bean / requiredBean;
		int result = Math.min(maxWater, maxMilk);
		return Math.min(result, maxBean);
	}
}
