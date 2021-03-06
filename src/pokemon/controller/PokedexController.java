package pokemon.controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.*;
import pokemon.model.*;
import pokemon.view.*;
import java.io.*;

public class PokedexController
{
	private String saveFile = "backup.pokemon";
	private Pokemon thisPokemon; //may not need this?
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	
	
	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		appFrame = new PokedexFrame(this);
	}
	
	public void start()
	{
//		this.appFrame = new PokedexFrame(this);
	}
	
	private void addPokemon()
	{
		pokemonList.add(new Flareon(136, "Flareon"));
		pokemonList.add(new Mightyena(262 , "Mightyena"));
		pokemonList.add(new Leafeon(570, "Leafeon"));
		pokemonList.add(new Roserade(407, "Roserade"));
		pokemonList.add(new Pidgey(16, "Pidgey"));
		pokemonList.add(new Sharktopus(1, "Sharktopus"));
			
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
			current.setCanEvolve(Boolean.parseBoolean(data[3]));
			current.setName(data[4]);

			
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
	
	public void savePokedex()
	{
		try
		{
			FileOutputStream saveStream = new FileOutputStream(saveFile);
			ObjectOutputStream output = new ObjectOutputStream(saveStream);
			output.writeObject(pokemonList);
			output.close();
			saveStream.close();
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(appFrame, error.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void loadPokedex()
	{
		try
		{
			ArrayList<Pokemon> saved = new ArrayList<Pokemon>();
			FileInputStream inputStream = new FileInputStream(saveFile);
			ObjectInputStream input = new ObjectInputStream(inputStream);
			saved = (ArrayList<Pokemon>) input.readObject();
			input.close();
			inputStream.close();
			pokemonList = saved;
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(appFrame, "No Save File", "Loading Pokemon", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(ClassNotFoundException pokemonError)
		{
			JOptionPane.showMessageDialog(appFrame, pokemonError.getMessage(), "Type Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public String [] getPokeData(int index)
	{
		String [] data = new String [6];
		Pokemon current = pokemonList.get(index);
		data[0] = current.getAttackPoints() + "";
		data[1] = current.getEnhancementModifier() + "";
		data[2] = current.getHealthPoints() + "";
		data[3] = current.getName() + "";
		data[4] = current.isCanEvolve() + "";
		data[5] = current.getNumber() + "";
		return data;	
	}
	
}
