package machine;

import java.util.Scanner;

public class CoffeeMachine {
	static final Scanner in = new Scanner(System.in);
	static int waterSupply = 0;
	static int milkSupply = 0;
	static int beanSupply = 0;
	static int cupsSupply = 0;
	static int money = 0;

	public static void main(String[] args) {
		waterSupply = 400;
		milkSupply = 540;
		beanSupply = 120;
		cupsSupply = 9;
		money = 550;
		boolean run = true;
		while (run) {
			System.out.println("Write action (buy, fill, take, remaining, exit):");
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
				case "remaining":
					PrintState();
					break;
				case "exit":
					run = false;
					break;
				default:
					break;
			}
		}
	}

	static void PrintState() {
		System.out.println();
		System.out.println("The coffee machine has:");
		System.out.printf("%d of water\n", waterSupply);
		System.out.printf("%d of milk\n", milkSupply);
		System.out.printf("%d of coffee beans\n", beanSupply);
		System.out.printf("%d of disposable cups\n", cupsSupply);
		System.out.printf("%d of money\n", money);
		System.out.println();
	}

	static void Buy() {
		System.out.println();
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
		String action = in.next();
		if (action.equals("back")) {
			return;
		}
		int coffeeType = Integer.parseInt(action);
		int requiredWater, requiredMilk, requiredBean, cost;
		switch (coffeeType) {
			case 1:
				requiredWater = 250;
				requiredMilk = 0;
				requiredBean = 16;
				cost = 4;
				BuyByType(requiredWater, requiredMilk, requiredBean, cost);
				break;
			case 2:
				requiredWater = 350;
				requiredMilk = 75;
				requiredBean = 20;
				cost = 7;
				BuyByType(requiredWater, requiredMilk, requiredBean, cost);
				break;
			case 3:
				requiredWater = 200;
				requiredMilk = 100;
				requiredBean = 12;
				cost = 6;
				BuyByType(requiredWater, requiredMilk, requiredBean, cost);
				break;
			default:
				break;
		}
		System.out.println();
	}

	static void BuyByType(int requiredWater, int requiredMilk, int requiredBean, int cost) {
		if (waterSupply - requiredWater < 0) {
			System.out.println("Sorry, not enough water!");
			return;
		}
		if (milkSupply - requiredMilk < 0) {
			System.out.println("Sorry, not enough milk!");
			return;
		}
		if (beanSupply - requiredBean < 0) {
			System.out.println("Sorry, not enough coffee beans!");
			return;
		}
		if (cupsSupply - 1 < 0) {
			System.out.println("Sorry, not enough disposable cups!");
			return;
		}
		System.out.println("I have enough resources, making you a coffee!");
		waterSupply -= requiredWater;
		milkSupply -= requiredMilk;
		beanSupply -= requiredBean;
		cupsSupply -= 1;
		money += cost;
	}

	static void Fill() {
		System.out.println();
		System.out.println("Write how many ml of water do you want to add:");
		waterSupply += in.nextInt();
		System.out.println("Write how many ml of milk do you want to add:");
		milkSupply += in.nextInt();
		System.out.println("Write how many grams of coffee beans do you want to add:");
		beanSupply += in.nextInt();
		System.out.println("Write how many disposable cups do you want to add:");
		cupsSupply += in.nextInt();
		System.out.println();
	}

	static void Take() {
		System.out.println();
		System.out.printf("I gave you $%d\n", money);
		money = 0;
		System.out.println();
	}
}
