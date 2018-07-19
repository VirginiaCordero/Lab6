import java.util.Random;
import java.util.Scanner;

public class DiceRollerApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
	
		System.out.println("Welcome to the Grand Circus Casino!");
		String cont;
		
		do {
			System.out.println("How many sides should each die have? {User input, for example 6}");
			int diceSides = scnr.nextInt();
			System.out.println("Your first roll:");
			
			int num1 = roll(diceSides);
			int num2 = roll(diceSides);
			System.out.println(" " + num1 + " & " + num2);
			System.out.println(special(num1, num2));
			System.out.println("Do you want to continue?");
			cont = scnr.next();
			
		} while (cont.equalsIgnoreCase("y"));
		
		System.out.println("Goodbye.");
	}
	private static int roll(int diceSides) {
		// Determines random number from number of sides input and adds one (because it is exclusive - counts from 0)
		Random rand = new Random();
		int randomSides = rand.nextInt(diceSides);
		return randomSides + 1 ;
	}
	 
	private static String special(int num1, int num2) {
		// Determines snake eyes (1-1), craps (a + b = 7 or a + b = 11, or boxcars (6 + 6).
		String specialString = "We are sorry to inform you that your dice roll is not special.";
		// this is for snake eyes
		if (num1 == 1 && num2 == 1) { 
			specialString = "You've thrown snake-eyes!";
		}
		// this is for boxcars
		if (num1 == 6 && num2 == 6) {
			specialString = "This is known as boxcars. ";
		}	
		// this is for craps
		if (num1 + num2 ==7 ||
				num1 + num2 == 11) {
			specialString = "Oopsie daisies, you've got craps.";
		}
		return specialString;
	}
		
}
