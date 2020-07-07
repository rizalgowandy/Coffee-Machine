package machine;

import java.util.Scanner;

public class CoffeeMachine {
	static int waterSupply = 0;
	static int milkSupply = 0;
	static int beanSupply = 0;
	static int cupsSupply = 0;
	static int money = 0;

	public static void main(String[] args) {}

	static void PrintSteps() {
		final String[] steps = {
			"Starting to make a coffee",
			"Grinding coffee beans",
			"Boiling water",
			"Mixing boiled water with crushed coffee beans",
			"Pouring coffee into the cup",
			"Pouring some milk into the cup",
			"Coffee is ready!"
		};
		for (String step : steps) {
			System.out.println(step);
		}
	}

	static void PrintTotalIngredients() {
		System.out.println("Write how many cups of coffee you will need:");
		Scanner in = new Scanner(System.in);
		int cups = in.nextInt();
		final int requiredWater = 200;
		final int requiredMilk = 50;
		final int requiredBean = 15;
		int waters = requiredWater * cups;
		int milks = requiredMilk * cups;
		int beans = requiredBean * cups;
		System.out.println(waters + " ml of water");
		System.out.println(milks + " ml of milk");
		System.out.println(beans + " g of coffee beans");
	}

	static void PrintCanMakeOrders() {
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
		final int requiredWater = 200;
		final int requiredMilk = 50;
		final int requiredBean = 15;
		int maxWater = water / requiredWater;
		int maxMilk = milk / requiredMilk;
		int maxBean = bean / requiredBean;
		int result = Math.min(maxWater, maxMilk);
		return Math.min(result, maxBean);
	}

	static void StartBuyFillTake() {
		waterSupply = 400;
		milkSupply = 540;
		beanSupply = 120;
		cupsSupply = 9;
		money = 550;
		PrintState();
		Scanner in = new Scanner(System.in);
		System.out.println("Write action (buy, fill, take):");
		String action = in.next();
		switch (action) {
			case "buy":
				Buy();
				break;
			case "fill":
				Fill();
				break;
			case "take":
				Take();
				break;
			default:
				break;
		}
		System.out.println();
		PrintState();
	}

	static void PrintState() {
		System.out.println("The coffee machine has:");
		System.out.printf("%d of water\n", waterSupply);
		System.out.printf("%d of milk\n", milkSupply);
		System.out.printf("%d of coffee beans\n", beanSupply);
		System.out.printf("%d of disposable cups\n", cupsSupply);
		System.out.printf("%d of money\n", money);
		System.out.println();
	}

	static void Buy() {
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
		Scanner in = new Scanner(System.in);
		int coffeeType = in.nextInt();
		int requiredWater, requiredMilk, requiredBean, cost;
		switch (coffeeType) {
			case 1:
				requiredWater = 250;
				requiredMilk = 0;
				requiredBean = 16;
				cost = 4;
				Buy(requiredWater, requiredMilk, requiredBean, cost);
				break;
			case 2:
				requiredWater = 350;
				requiredMilk = 75;
				requiredBean = 20;
				cost = 7;
				Buy(requiredWater, requiredMilk, requiredBean, cost);
				break;
			case 3:
				requiredWater = 200;
				requiredMilk = 100;
				requiredBean = 12;
				cost = 6;
				Buy(requiredWater, requiredMilk, requiredBean, cost);
				break;
			default:
				break;
		}
	}

	static void Buy(int requiredWater, int requiredMilk, int requiredBean, int cost) {
		waterSupply -= requiredWater;
		milkSupply -= requiredMilk;
		beanSupply -= requiredBean;
		cupsSupply -= 1;
		money += cost;
	}

	static void Fill() {
		Scanner in = new Scanner(System.in);
		System.out.println("Write how many ml of water do you want to add:");
		waterSupply += in.nextInt();
		System.out.println("Write how many ml of milk do you want to add:");
		milkSupply += in.nextInt();
		System.out.println("Write how many grams of coffee beans do you want to add:");
		beanSupply += in.nextInt();
		System.out.println("Write how many disposable cups do you want to add:");
		cupsSupply += in.nextInt();
	}

	static void Take() {
		money = 0;
		System.out.printf("I gave you $%d\n", money);
	}
}
