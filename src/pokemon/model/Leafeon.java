package pokemon.model;

public class Leafeon extends Pokemon implements Grass
{
	public Leafeon(int number, String name) 
	{
		super(number, name); 
	}
	
	public int eatGrass()
	{
		return 8989;
	}
	
	public void throwGrass()
	{
		
	}
}
