import java.util.Arrays;
import java.util.Scanner;

public class Explorer {

	public static void main(String[] args) {
		String result, input, command;

		Scanner in = new Scanner(System.in);

		do {
			System.out.println(
					"Please provide instructions to the explorer in the following format:\n\nPLACE X,Y\nBLOCK X,Y\nREPORT\nEXPLORE X,Y\n");
			command = in.nextLine().trim();
			if (command != null) {
				result = validateAndPerformCommand(command);
			} else {
				System.out.print("Issues with the input");
			}
			System.out.print("Do you want to continue (y/n)");
			input = in.nextLine();
		} while (input.equalsIgnoreCase("Y"));
	}

	static String validateAndPerformCommand(String command) {
		String[] commandArray = command.split("\\s+");
		if (commandArray.length <= 2) {
			String commandProvided = commandArray[0];
			if (commandProvided != "REPORT" && commandArray.length == 2) {
				String[] commandUnit = commandArray[1].split("\\s*,\\s*");
				if (commandUnit.length == 2) {
					String x = commandUnit[0];
					String y = commandUnit[1];
				}
			}
			switch (commandProvided) {

			case "PLACE":
				System.out.println("1");
				break;

			case "BLOCK":
				System.out.println("2");
				break;

			case "REPORT":
				System.out.println("3");
				break;

			case "EXPLORE":
				System.out.println("4");
				break;

			default:
				System.out.println("5");
				break;

			}

		}

		System.out.println("6");
		return "";

	}
}
