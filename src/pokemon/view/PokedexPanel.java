package pokemon.view;
import javax.swing.*;

import pokemon.controller.PokedexController;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;


public class PokedexPanel extends JPanel
{
	private SpringLayout appLayout;
	private PokedexController app;


	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	private JButton changeButton; 
	private JComboBox<String> pokedexDropdown;
	
	private ImageIcon pokemonIcon;

	public PokedexPanel(PokedexController app)
	{
		super();
		this.app = app;
		this.appLayout = new SpringLayout();
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/PMflareon.jpeg")); //default image
		
	
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");

		
		numberLabel = new JLabel("The pokemon number is ");
		nameLabel = new JLabel ("My name is ");
		evolveLabel = new JLabel ("This pokemon can evolve ");
		attackLabel = new JLabel ("This pokemon attack level is ");
		enhanceLabel = new JLabel ("This pokemon enhancement level is ");
		healthLabel = new JLabel ("This pokemon health is");
		imageLabel = new JLabel ("pokemon goes here", pokemonIcon, JLabel.CENTER); //tell the panel how to display in relationship to the text
		
		changeButton = new JButton("Click here to change the pokevalues");
		pokedexDropdown = new JComboBox<String>(); //stub
		
		setUpPanel();
		setUpLayout();
		setUpListeners();
	}
	
	private void setUpPanel()
	{
		this.setLayout(appLayout);
		//this.setPreferredSize(new Dimension(800,600));
		//this.setBackground(Color.PINK);
		
		this.add(changeButton);
		this.add(pokedexDropdown);
		
		this.add(numberField);
		this.add(nameField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhancementField);
		this.add(healthField);
		
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(enhanceLabel);
		this.add(healthLabel);
		this.add(imageLabel);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);

	
		

	}
	
	private void setUpLayout()
	{
		
	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
	
	private void setUpListeners()
	{
		changeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
		
		pokedexDropdown.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
	}
	
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "Flareon";
		String extension = ".jpeg";
		
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
		
	};
	
	

}
