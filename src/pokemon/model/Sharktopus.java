package pokemon.model;

public class Sharktopus extends Pokemon implements Water
{
	public Sharktopus()
	{
		super(1,"Sharktopus");
		this.setCanEvolve(true);
	}
	
	public Sharktopus(String Name)
	{
		super(1,"Sharktopus");
	}
	
	public Sharktopus(int num, String name)
	{
		super(1,"Sharktopus");
	}
	
	public void shootWater()
	{
		
	}
	
	public void drown()
	{
		
	}
}
