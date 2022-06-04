/**
 * This class contains contructor which sets up array of linkedlists
 * This class contains hashmethod adds up all unicode values of all the cahracters in states name and deaths + population % length of arr
 * 
 * @author Adrian Alba
 * @version 4/18/2021
 */
public class HashTable 
{
	
	private LinkedList[] objStates;
	
	/**
	 * Constructor sets up the array of linkedlists
	 */
	public HashTable()
	{
		objStates = new LinkedList[101];
		
		for(int i = 0;i < objStates.length;i++)
		{
			objStates[i] = new LinkedList();
		}
	}
	/**
	 * This method adds up all unicode values of all the cahracters in states name and deaths + population
	 * also takes % length
	 * @param state takes state name string parameter
	 * @param population takes population long parameter
	 * @param deaths takes deaths long parameter
	 * @return int result after adding
	 */
	public int hash(String state, long population, long deaths)
	{
		int total = 0;
		
		for(char c: state.toCharArray())
		{
			total += (int)c;
		}
		
		total += (int)deaths + (int)population;
		
		return total % objStates.length;
	}
	/**
	 * This class calls hash function to calculate and sets to variable p and uses that to call insert function from LinkedList class
	 * @param state takes state name
	 * @param population takes population
	 * @param deaths takes deaths
	 * @return nothing 
	 */
	public void insert(String state, long population, long deaths)
	{
		int p = hash(state,population,deaths);
		
		objStates[p].insert(new Node(state,population,deaths));
	}
	/**
	 * This method is used to display contents of hash table to user
	 */
	public void display()
	{
		for(int i = 0;i<objStates.length;i++)
		{
			System.out.printf("%-4d", i);
			
			
			if(objStates[i].isEmpty())
			{
				System.out.printf("%-19s\n", "Empty");
			}
			else
			{
				
				System.out.println(objStates[i].toString());
			}
		}
		
	}
	/**
	 * This class displays the number of empty cells and collission to the user.
	 * It uses counters to keep count and calls size function from linkedList class
	 */
	public void printEmptyAndCollisions()
	{
		int Empty = 0;
		int Collisions = 0;
		
		for(int i = 0;i < objStates.length;i++)
		{
			int size = objStates[i].size();
			
			if(size == 0)
			{
				Empty++;
			}
			else if(size > 1)
			{
				Collisions++;
			}
		}
		
		System.out.printf("There are %d empty cells and %d collisions in the hash table.", Empty, Collisions);
	}
	/**
	 * Function calls hash and sets it to variable
	 * creates new node object and calls find function from linkedlist class
	 * return -1 if not found
	 * returns index if found
	 * @param state takes state name
	 * @param population takes population
	 * @param deaths takes deaths
	 * @return
	 */
	public int find(String state, long population, long deaths)
	{
		int p = hash(state,population,deaths);
		
		Node node = new Node(state,population,deaths);
		
		int spot = objStates[p].find(node);
		
		if(spot != -1)
		{
			//found
			return p;
		}
		//not found
		return -1;
	}
	/**
	 * Again calls hash and sets to variable p
	 * creates new node object
	 * uses delete function from linkedlist class
	 * @param state takes state name
	 * @param population takes population
	 * @param deaths takes deaths
	 */
	public void delete(String state,long population,long deaths)
	{
		int p = hash(state,population,deaths);
		
		Node node = new Node(state,population,deaths);
		
		objStates[p].delete(node);
	}
	

	
}
