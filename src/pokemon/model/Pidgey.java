package pokemon.model;

public class Pidgey extends Pokemon implements Normal, Flying //could have it extend something else -> a difference pokemon by making a constructor with 0, string, and int/string parameters
{
	public Pidgey(int number, String name) 
	{
		super(number, name); //super class constructor
	}
	
	public void slideTackle()
	{
		System.out.println("wabaam");
	}
	
	public String perishSong()
	{
		return "asdfjkl;";
	}
	
	public void crashFromAbove()
	{
		
	}
	public void skyUppercut()
	{
		
	}
}
