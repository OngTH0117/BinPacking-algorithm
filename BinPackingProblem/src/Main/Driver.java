package Main;
import java.util.*;

public class Driver {
	public static void main(String[] args) throws InputTooLargeException {
		
		ArrayList<Double> items = new ArrayList<>();
		double binCapacity;
		
		System.out.println("----------------------------------------------------------------------");
		//Get user input for bin capacity
		Scanner scanner = new Scanner(System.in);
		
			System.out.print("Enter the Maximum Capacity for Each Recycle Bins: ");
			while(!scanner.hasNextDouble()) {
			    System.out.print("Invalid Input,please try again: ");
			    scanner.nextLine();
			}
			binCapacity = scanner.nextDouble();
        	
		
		System.out.println("----------------------------------------------------------------------");
		
		//Get user input for items quantity and size
		System.out.print("Enter the Number of Items to be Stored in Recycle Bins: ");
		int numOfItems = scanner.nextInt();
		for (int i = 1; i <= numOfItems; i++) {	
			System.out.print("Enter the Size of Item " + i + ": ");
			double input = scanner.nextDouble();	
			 if (binCapacity >=  input) {
				 items.add(input);
			    } else {
					 throw new InputTooLargeException ("The size of item should smaller than bin size");
			    }
			
		}
		
		System.out.println("----------------------------------------------------------------------");
		
		FirstFit ff = new FirstFit(items, binCapacity);
		testAlgorithm(ff, "First Fit Algorithm");
		
		NextFit nf = new NextFit(items, binCapacity);
		testAlgorithm(nf, "Next Fit Algorithm");
	}
	private static void testAlgorithm(Algorithm algo, String algorithmName) {
		//Start time when the algorithm executes
		long startTime;
		//Time required for the algorithm to executes
		long requiredTime;
		
		startTime = System.currentTimeMillis();
		//getResult(): Executing the algorithm
		System.out.println("Bins needed for " + algorithmName + ": " + algo.getResult());
		algo.printResult();
		requiredTime = System.currentTimeMillis() - startTime;
		System.out.println("Time taken: " + requiredTime +"ms");
		
		System.out.println("----------------------------------------------------------------------");
	}
}