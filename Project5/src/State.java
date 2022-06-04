/**
* The state class is straightforward, it contains instance variables, getters + setters,
 * methods that allow the state(s) to be displayed to the user with different formats.
 * Finally, the constructor that takes in variables through parameters and sets them to
 * the instance variables of the state Class. This class is being mostly reused from
 * project1
 * @author Adrian Alba
 * @version 2/15/2021
 */
public class State 
{
	
	private String stateName;
	private String stateCapital;
	private String region;
	private int houseSeats;
	private int population;
	private int numofCases;
	private int numofDeaths;
	private int medianIncome;
	private double crimeRate;
	
	/**
	 * 
	 * The constructor takes in the variables from the csv file and sets them to the
	 * instance variables in the state class
	 * @param a state name variable read from csv file
	 * @param b state capital variable read from csv file
	 * @param c region variable read from csv file
	 * @param d1 house seats variable read from csv file
	 * @param d2 population variable read from csv file
	 * @param d3 number of cases variable read from csv file
	 * @param d4 number of deaths variable read from csv file
	 * @param d5 median income variable read from csv file
	 * @param g crime rate variable read from csv file
	 */
	public State(String a,String b,String c, int d1, int d2, int d3, int d4, int d5, double g)
	{
		stateName = a;
		stateCapital = b;
		region = c;
		houseSeats = d1;
		population = d2;
		numofCases = d3;
		numofDeaths = d4;
		medianIncome = d5;
		crimeRate = g;
		
	}
	
	/**
	 * method just returns state name string variable
	 * @return stane name string variable
	 */
	public String getStateName() 
	{
		return stateName;
	}
	/**
	 * method sets stateName string instance variable
	 * @param stateName takes in a string variable
	 */
	public void setStateName(String stateName) 
	{
		this.stateName = stateName;
	}
	/**
	 * method just returns state capita string variable
	 * @return stateCapital  returns state capital string variable
	 */
	public String getStateCapital() 
	{
		return stateCapital;
	}
	/**
	 * method sets stateCapital string instance variable
	 * @param stateCapital takes in a string variable
	 */
	public void setStateCapital(String stateCapital) 
	{
		this.stateCapital = stateCapital;
	}
	/**
	 * method returns region string variable
	 * @return returns region string variable
	 */
	public String getRegion() 
	{
		return region;
	}
	/**
	 * method sets region string instance variable
	 * @param region takes in a string variable
	 */
	public void setRegion(String region) 
	{
		this.region = region;
	}
	/**
	 * method returns house seats int variable
	 * @return returns int variable
	 */
	public int getHouseSeats() 
	{
		return houseSeats;
	}
	/**
	 * method sets the houseSeats int variable
	 * @param houseSeats takes in a int variable
	 */
	public void setHouseSeats(int houseSeats) 
	{
		this.houseSeats = houseSeats;
	}
	/**
	 * method returns population int variable
	 * @return returns int variable
	 */
	public int getPopulation()
	{
		return population;
	}
	/**
	 * method sets the population int instance variable
	 * @param population takes in a int variable
	 */
	public void setPopulation(int population) 
	{
		this.population = population;
	}
	/**
	 * method returns number of cases int variable
	 * @return returns int variable
	 */
	public int getNumofCases() 
	{
		return numofCases;
	}
	/**
	 * method sets numbofCases int variable
	 * @param numofCases takes in a int variable
	 */
	public void setNumofCases(int numofCases) 
	{
		this.numofCases = numofCases;
	}
	/**
	 * method returns number of deaths int variable
	 * @return returns int variable
	 */
	public int getNumofDeaths() 
	{
		return numofDeaths;
	}
	/**
	 * method sets numofDeaths instance variable
	 * @param numofDeaths takes in a integer variable
	 */
	public void setNumofDeaths(int numofDeaths) 
	{
		this.numofDeaths = numofDeaths;
	}
	/**
	 * method returns median income int variable
	 * @return returns int
	 */
	public int getMedianIncome() 
	{
		return medianIncome;
	}
	/**
	 * method sets medianIncome int instance variable
	 * @param medianIncome takes in a integer variable
	 */
	public void setMedianIncome(int medianIncome) 
	{
		this.medianIncome = medianIncome;
	}
	/**
	 * method returns crime rate int variable
	 * @return returns a int variable
	 */
	public double getCrimeRate() {
		return crimeRate;
	}
	/**
	 * method sets crimeRate double instance variable 
	 * @param crimeRate takes in a double variable
	 */
	public void setCrimeRate(double crimeRate) 
	{
		this.crimeRate = crimeRate;
	}
	/**
	 * method calculates CRF using formula (number of deaths/number of cases)
	 * @return returns double variable which is the calculated CRF for the state
	 */
	public double calculateCRF() {
		double numberofCases = getNumofCases();
		double numberofDeaths = getNumofDeaths();
		double stateCRF = numberofDeaths / numberofCases;

		return stateCRF;
	}
	/**
	 * method calculates case rate using formula ((number of cases/population) * 100,000)
	 * @return returns double variable which is the calculated case rate for the state
	 */
	public double calculateCaseRate()
	{
		double numberofCases = getNumofCases();
		double population = getPopulation();
		double caseRate = (numberofCases/population) * 100000;
		
		return caseRate;
	}
	/**
	 * method calculates death rate using formula ((number of deaths/population) * 100,000)
	 * @return returns double variable which is the calculated death rate for the state
	 */
	public double calculateDeathRate()
	{
		double numberofDeaths = getNumofDeaths();
		double population = getPopulation();
		double deathRate = (numberofDeaths/population) * 100000;
		
		return deathRate;
	}
	/**
	 * method prints out the relevant information of the states and calls
	 * methods to be able to also display crf,case rate, and death rate
	 */
	public void printState()
	{

		double stateCRF = calculateCRF();
		double caseRate = calculateCaseRate();
		double deathRate = calculateDeathRate();
		//System.out.printf(String.format"%-8s%-8s%-8s%8s%8s%8s\n", "Name","MHI","VCR","CFR","Case Rate","Death Rate" );
		System.out.printf("Name: %s   MHI: %5d   VCR: %.2f   CRF: %f   Case Rate: %.2f   Death Rate: %.2f\n", stateName, medianIncome, crimeRate, stateCRF, caseRate, deathRate);
	}
	/**
	 * method returns a the state formatted for output
	 * @return this method returns string
	 */
	@Override
	public String toString()
	{
		double stateCRF = calculateCRF();
		double caseRate = calculateCaseRate();
		double deathRate = calculateDeathRate();
		
		return String.format("%-20s %-20s %-20s %-20f %-20.2f %-20.2f", stateName,medianIncome,crimeRate,stateCRF,caseRate,deathRate);
				
	}
	
}