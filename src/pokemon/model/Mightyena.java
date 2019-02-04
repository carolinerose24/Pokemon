package pokemon.model;

public class Mightyena extends Pokemon implements Dark
{
	public Mightyena(int number, String name) //must be int and then string --> sequence and type is for the computer
	{
		super(number, name); 
	}
	
	public void shadowTravel()
	{
		System.out.println("My darkness is so high: " + this.getAttackPoints());
	}
	
	public int crunchEnemy()
	{
		System.out.println("Not the hero Gotham deserves, but the one it needs, a dark knight");
		return this.getHealthPoints();
	}
}
