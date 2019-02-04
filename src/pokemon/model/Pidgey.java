package pokemon.model;

public class Pidgey extends Pokemon implements Normal
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
}
