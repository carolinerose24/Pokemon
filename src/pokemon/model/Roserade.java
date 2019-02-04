package pokemon.model;

public class Roserade extends Pokemon implements Grass 
{
	public Roserade(int number, String name) 
	{
		super(number, name); 
	}
	
	public int eatGrass()
	{
		return 8;
	}
	public void throwGrass()
	{
		
	}
}
