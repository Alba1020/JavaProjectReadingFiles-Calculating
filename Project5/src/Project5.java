import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <p>
 * This class contains code that reads the csv file and using insert method from hash table class to insert.
 * This class also has menuOptions function that displays the menu to the user.
 * The needed input depends on the menu selection
 * <p> 
 * @author Adrian Alba
 * @version 4/18/2021
 *
 */
public class Project5 
{
	
	public static void main(String[] args) 
	{
		String throwAway;
		Scanner scan = new Scanner(System.in);
		//prompts user to enter csv file name
		System.out.printf("Please input the file name:");
		String fileName = scan.next();
		System.out.println(fileName);
		
		Scanner inFile = null;
		try
		{
			inFile = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("\nSystem could not find that file!");
			System.exit(1);
		}
		
		inFile.useDelimiter(",|\n");
		
		
		inFile.hasNextLine();
		//gets rid of the first row of the csv file
		throwAway = inFile.nextLine();
		
		HashTable hashTable = new HashTable();

		while(inFile.hasNext())
		{
			
			
			String stateName = inFile.next();
			String stateCapital = inFile.next();
			String region = inFile.next();
			int houseSeats = inFile.nextInt();
			int population = inFile.nextInt();
			int numofCases = inFile.nextInt();
			int numofDeaths = inFile.nextInt();
			int medianIncome = inFile.nextInt();
			double crimeRate = inFile.nextDouble();
			
			//State s = new State(stateName, stateCapital, region, houseSeats, population, numofCases, numofDeaths, medianIncome, crimeRate);
			
			//System.out.println(s);
			
			hashTable.insert(stateName, population, numofDeaths);

		}
		
		Scanner s = new Scanner(System.in);
		int userSelection;
		boolean m = false;

		do
		{

			menuOptions();
			userSelection = s.nextInt();
			
			switch(userSelection)
			{
			case 1:
				hashTable.display();
				break;
			case 2:
				Scanner delete = new Scanner(System.in);
				System.out.print("Enter State Name: \n");
				String deleteName = delete.nextLine();
				System.out.print("Enter population: \n");
				long deletePop = delete.nextLong();
				System.out.print("Enter number of deaths: ");
				long deleteDeaths = delete.nextLong();
				hashTable.delete(deleteName, deletePop, deleteDeaths);
				break;
			case 3:
				Scanner insert = new Scanner(System.in);
				System.out.print("Enter State Name: \n");
				String passName = insert.nextLine();
				System.out.print("Enter population: \n");
				long passPop = insert.nextLong();
				System.out.print("Enter number of deaths: ");
				long passDeaths = insert.nextLong();
				hashTable.insert(passName, passPop, passDeaths);
				System.out.printf("%s was inserted!",passName);
				break;
			case 4:
				Scanner find = new Scanner(System.in);
				System.out.print("Enter State Name: \n");
				String fName = find.nextLine();
				System.out.print("Enter population: \n");
				long fPop = find.nextLong();
				System.out.print("Enter number of deaths: ");
				long fDeaths = find.nextLong();
				int resultFind = hashTable.find(fName, fPop, fDeaths);
				
				if(resultFind == -1)
				{
					System.out.println("State was not found!");
				}
				else
				{
					System.out.printf("%s was found in index %d",fName, resultFind);
				}
				break;
			case 5:
				hashTable.printEmptyAndCollisions();
				break;
			case 6:
				System.out.println("Good Bye! Have a good day.");
				m = true;
				break;
			default:
				System.out.println("Invalid input! Enter a number from 1-7");
			}
		}while(!m);

	}
	/**
	 * This function just displays the menu to the user
	 */
	public static void menuOptions()
	{
		System.out.println("\n\n1) Print hash table");
		System.out.println("2) Delete a state of a given name");
		System.out.println("3) Insert a state of a given name");
		System.out.println("4) Search and print a state and its DR for a given name");
		System.out.println("5) Print numbers of empty cells and collisions");
		System.out.println("6) Exit");
		System.out.print("Enter your choice: ");
		
	}

}
