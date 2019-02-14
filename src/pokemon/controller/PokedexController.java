package pokemon.controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.*;
import pokemon.model.*;
import pokemon.view.*;

public class PokedexController
{
	private Pokemon thisPokemon;
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	
	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		appFrame = new PokedexFrame(this);
	}
	
	private void addPokemon()
	{
		pokemonList.add(new Mightyena(262 , "Dark"));
		pokemonList.add(new Leafeon(570, "Grass"));
		pokemonList.add(new Flareon(136, "Fire"));
		pokemonList.add(new Roserade(407, "Grass/Poison"));
		pokemonList.add(new Pidgey(16, "Normal/Flying"));
		
	
	}
	
	
	public PokedexFrame getFrame() //appFrame
	{
		return appFrame;
	}
	
	public void setFrame(PokedexFrame appFrame)
	{
		this.appFrame = appFrame;
	}
	
	public Pokemon getThisPokemon()

	{
		return thisPokemon;
	}
	
	public void setThisPokemon(Pokemon thisPokemon)

	{
		this.thisPokemon = thisPokemon;
	}
	
	
	
	public void updatePokemon (int index, String [] data)
	{
		if (data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			
			current.setAttackPoints(Integer.parseInt(data[0]));
			current.setEnhancementModifier(Double.parseDouble(data[1]));
			current.setHealthPoints(Integer.parseInt(data[2]));
			current.setName(data[3]);
			current.setCanEvolve(Boolean.parseBoolean(data[4]));
			
		//	this.setCanEvolve(true);
		}
	}
	
	public String[] buildPokedexText()
	{
		String[] names = new String [pokemonList.size()];
		
		for (int index = 0; index < pokemonList.size(); index++)
		{
			names[index] = pokemonList.get(index).getName();
		}
		return names;
	}

//	public void start()
//	{
//		
//	}
	
	public ArrayList<Pokemon> getPokemonList()
	{
		return pokemonList;
		
	}

	
	public boolean isDouble(String maybeDouble)
	{
		boolean isValid = false;
		try
		{
			Double.parseDouble(maybeDouble); //String to double conversion
			isValid=true;
		}
		catch(NumberFormatException error)
		{
			//JOptionPane.showMessageDialog(null, "Put in a double");
		
		}
		return isValid;
	}
	
	public boolean isInt(String maybeInt)
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(maybeInt);
			isValid = true;
		}
		catch(NumberFormatException error) //type, variable -- formal parameter
		{
			//JOptionPane.showMessageDialog(null, "Put in an integer");
		}
		
		
		return isValid;
	}
	

	
}
