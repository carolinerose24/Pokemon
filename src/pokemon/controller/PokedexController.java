package pokemon.controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import pokemon.view.PokedexFrame;
import pokemon.model.*;
import pokemon.view.*;

public class PokedexController
{
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
	
	public void start()
	{
		
	}
	
	public ArrayList<Pokemon> getPokemonList()
	{
		return pokemonList;
		
	}
	
	public String isDouble(String input)
	{
		return input;
	}
	
	public String isInt(String input)
	{
		return input;
	}

	public void getFrame()
	{
		
	}
	
}
