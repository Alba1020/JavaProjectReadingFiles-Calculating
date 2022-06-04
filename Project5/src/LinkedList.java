/**
 * This class is blue print for linked list data structure
 * @author Adrian Alba
 * @version 4/18/2021
 */
public class LinkedList 
{
	//instance variables
	private Node first;
	private Node last;
	
	/**
	 * constructor sets up variables to null at first
	 */
	public LinkedList()
	{
		first = null;
		last = null;
	}
	/**
	 * checks if list is empty
	 * @return boolean value
	 */
	public boolean isEmpty()
	{
		return first==null;
	}
	/**
	 * method inserts node object
	 * @param node takes node object
	 */
	public void insert(Node node)
	{
		if(first==null)
		{
			first = last = node;
		}
		else
		{
			last.nextNode = node;
		}
	}
	
	/**
	 * counts number of nodes
	 * @return number of nodes
	 */
	public int size()
	{
		int numberNodes = 0;
		
		Node current = first;
		
		while(current != null)
		{
			current = current.nextNode;
			numberNodes++;
		}
		
		return numberNodes;
	}
	/**
	 * This method looks for match using equals function from node class
	 * @param node takes node object
	 * @return either -1 or index
	 */
	public int find(Node node)
	{
		int p = 0;
		
		Node current = first;
		
		while(current != null && !current.equals(node))
		{
			current = current.nextNode;
			p++;
		}
		
		return p;
	}
	/**
	 * This method deletes node from linkedlist
	 * @param node takes in a node
	 */
	public void delete(Node node)
	{
		Node previous = null;
		Node current = first;
		
		while(current != null && !current.equals(node))
		{
			previous = current;
			current = current.nextNode;
		}
		if(current != null)
		{
			if(previous == null)
			{
				first = first.nextNode;
				
				if(first == null)
				{
					last = null;
				}
			}
			else
			{
				previous.nextNode = current.nextNode;
				
				if(current == last)
				{
					last = previous;
				}
			}
		}
		
	}
	/**
	 * This method is used to display results to user
	 */
	@Override
	public String toString() {
		
		String display = "";
		
		Node current = first;
		while (current != null) {
			
			if (current != first) {
				display += ", ";
			}
			
			//double deathRate = current.deaths/current.population*100000;
			display += current.name + " " + current.population + " " + current.deaths;
			
			current = current.nextNode;
		}
		
		return display;
	}
	
	
}
