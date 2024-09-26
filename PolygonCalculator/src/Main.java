import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
    	// Add a scanner to read the users input
        Scanner scan = new Scanner(System.in);
        boolean running = true; // Determine whether the program should loop or stop

        // While loop to run the program unless the user states they'd prefer to terminate
        while (running) {
            runPolygonCalculator(scan); // Call the method that calculates the users polygon name, perimeter and area
            
            // Ask the user if they'd like to run the program again
            System.out.println("Would you like to run the program again? (yes/no)");
            String run = scan.next();
            
            // If the user enters 'yes' run the program, if the user enters 'no' terminate the program
            while (!run.equals("yes") && !run.equals("no")) {
                System.out.println("Invalid input. Please enter 'yes' or 'no': ");
                run = scan.next();
            }
            if (run.equals("no")) {
                running = false; 
            }
        }
        
        // Close the scanner
        scan.close();
    }

    // Private method to calculate the necessary information about the users polygon
    private static void runPolygonCalculator(Scanner scan) {
        int numSides = 0;

        // Prompt user for their polygons number of sides
        while (true) {
            System.out.println("Enter the polygon's number of sides: ");
            numSides = scan.nextInt();
            
         // Confirm the user's input => 3 & <= 9
            if (numSides > 9) {
                System.out.println("Your polygon can't have over 9 sides. Please try again."); // Explain the polygon must be => 3 & <= 9
            } else if (numSides < 3) {
                System.out.println("Your polygon must contain at least 3 sides. Please try again.");
            } else {
                break;
            }
        }
        
     // Prompt user for the length of the sides of their polygon
        System.out.println("Enter the length of the sides of the polygon: ");
        double sideLength = scan.nextDouble();
        
        // Calculate the perimeter and area of the users polygon by utilising their respective formulas
        double perimeter = sideLength * numSides;
        double area = numSides * Math.pow(sideLength, 2) / (4 * Math.tan(Math.PI / numSides));

        // Print the calculated polygon information for the user
        String polygonName = getPolygonName(numSides);
        System.out.println("Your polygon is a " + polygonName);
        System.out.println("The perimeter of your " + polygonName + " = " + perimeter);
        System.out.printf("The area of your %s = %.2f%n", polygonName, area); // Use formatted printing to round to 2 decimal places
    }
    
    // Private method utilising a switch statement to determine the name of the users polygon
    private static String getPolygonName(int numSides) {
        switch (numSides) {
            case 3: return "triangle";
            case 4: return "quadrilateral";
            case 5: return "pentagon";
            case 6: return "hexagon";
            case 7: return "heptagon";
            case 8: return "octagon";
            case 9: return "nonagon";
            default: return "Invalid"; // Validating the users input should prevent the usage of this
        }
    }
}


           
           
		
		
	
          
     



