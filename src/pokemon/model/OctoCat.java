package pokemon.model;

import javax.swing.JOptionPane;

public class OctoCat extends Pokemon implements Normal
{
	public OctoCat()
	{
		super(1234, "banana");
	}
	
	public OctoCat(String Name)
	{
		super(1234, "");
	}
	
	public OctoCat(String Name, int num)
	{
		super(1234, "");
	}

	public void slideTackle()
	{
		
		JOptionPane.showMessageDialog(null, "Slide Tackle!");
	}

	public String perishSong()
	{

		return "'some farcical aquatic ceremony'";
	}
}
