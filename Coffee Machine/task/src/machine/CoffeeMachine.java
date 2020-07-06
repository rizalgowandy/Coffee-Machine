package machine;

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

	public static void main(String[] args) {
		PrintSteps();
	}

	public static void PrintSteps() {
		for (String step : steps) {
			System.out.println(step);
		}
	}
}
