import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Explorer {
	public static String place, report, block, explore;
	public static ArrayList<String> blockList = new ArrayList<String>();;

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

	public static String validateAndPerformCommand(String command) {
		int x = 0, y = 0;
		String[] commandArray = command.split("\\s+");
		if (commandArray.length <= 2) {
			String commandProvided = commandArray[0];
			if (commandProvided != "REPORT" && commandArray.length == 2) {
				String[] commandUnit = commandArray[1].split("\\s*,\\s*");
				if (commandUnit.length == 2) {
					x = parseStrToInt(commandUnit[0].trim());
					y = parseStrToInt(commandUnit[1].trim());
				}
			}
			switch (commandProvided) {

			case "PLACE":
				currentPlace(x, y);
				break;

			case "BLOCK":
				updateCurrentBlocks(x, y);
				break;

			case "REPORT":
				report();
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

	public static int parseStrToInt(String str) {
		if (str.matches("\\d+")) {
			return Integer.parseInt(str);
		} else {
			return -1;
		}
	}

	public static boolean validBoundary(int x, int y) {
		if (x <= 5 && x >= 0 && y <= 5 && y >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void currentPlace(int x, int y) {
		if (validBoundary(x, y)) {
			blockList.clear(); //clears all the existing blocks
			place = "E: (" + x + "," + y + ")";
			System.out.println(place);
		} else {
			System.out.println("The boundary is not valid");
		}
	}

	public static void updateCurrentBlocks(int x, int y) {
		String blockUnits = "(" + x + "," + y + ")";
		if (validBoundary(x, y)) {
			if (blockList.size() > -1) {
				
				if (blockList.contains(blockUnits)) {
					System.out.println("This block already exist");
				} else {
					blockList.add(blockUnits);
					System.out.println(blockList.toString());
				}
			}else {
				blockList.add(blockUnits);
				System.out.println(blockList.toString());
			}

		} else {
			System.out.println("The boundary is not valid");
		}
	}
	
	public static void report() {
		System.out.println("E: "+ place + "\nB: "+ blockList.toString());
	}
	
	public static void explore(int x, int y) {
		if(validBoundary(x,y)) {
			
		}else {
			System.out.println("invalid boundary value");
		}
	}
}
