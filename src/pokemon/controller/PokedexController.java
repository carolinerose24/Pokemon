package pokemon.controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import pokemon.view.PokedexFrame;
import pokemon.model.*;

public class PokedexController
{
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	public PokedexController)_
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		appFrame = new PokedexFrame(this);
	}
	
	private void addPokemon()
	{
		pokemonList.add(new Mightyena());
	}
	
	public void start()
	{
		
	}
	
	public ArrayList<Pokemon> getPokemonList()
	{
		
	}
	
}
